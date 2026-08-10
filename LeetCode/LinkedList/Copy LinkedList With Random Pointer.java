import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ================================================================
 * Problem: Copy List with Random Pointer (LeetCode 138)
 * ================================================================
 * You're given a linked list where each node has two pointers:
 *   - next   : points to the next node in the list (or null)
 *   - random : points to ANY node in the list, or null
 *
 * Return a deep copy of the list: every node in the copy must be a
 * brand-new object, and the copy's next/random pointers must mirror
 * the same relative structure as the original (i.e. if original
 * node i's random points to node j, the copy of node i's random
 * must point to the COPY of node j — not back to the original).
 *
 * Two solutions are provided below:
 *   1. BruteSolution — uses a HashMap<original, copy> to remember
 *      which copy corresponds to which original node.
 *   2. Solution       — the O(1) extra-space "weave" trick: splice
 *      each copy node directly after its original, use that to wire
 *      up random pointers without a map, then unweave the two lists.
 * ================================================================
 */

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    // Prints only the neighbor's val (not the full neighbor object)
    // to avoid infinite recursion when random/next pointers form a
    // cycle back to an already-printed node.
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + (next != null ? next.val : "null") +
                ", random=" + (random != null ? random.val : "null") +
                '}';
    }
}

class BruteSolution {
    /*
     * Approach 1: Brute Force [Using a HashMap]
     * ------------------------------------------------------------
     * Pass 1: walk the original list once, creating a new copy node
     *         for each original node, and record the mapping
     *         original -> copy in a HashMap (next/random left unset
     *         for now, since the target nodes may not exist yet).
     * Pass 2: walk the original list again; for each original node,
     *         look up its own copy, then set copy.next and
     *         copy.random by looking up the ORIGINAL's next/random
     *         in the map (which now safely resolves to their
     *         copies, since every copy was created in pass 1).
     *
     * Time Complexity:  O(N) + O(N) = O(N) — two linear passes over
     *                    the list; each HashMap get/put is O(1)
     *                    average case.
     * Space Complexity: O(N) for the HashMap (one entry per node)
     *                    + O(N) for the N new copy nodes themselves
     *                    (unavoidable, since they're the output).
     */
    public Node copyRandomListBrute(Node head) { // Brute
        Node temp = head;
        Map<Node, Node> mpp = new HashMap<>();

        // Pass 1: create a copy for every original node
        while (temp != null) {
            Node newNode = new Node(temp.val);
            mpp.put(temp, newNode);
            temp = temp.next;
        }

        // Pass 2: wire up next/random using the map
        temp = head;
        while (temp != null) {
            Node copyNode = mpp.get(temp);
            copyNode.next = mpp.get(temp.next);     // null-safe: mpp.get(null) -> null
            copyNode.random = mpp.get(temp.random);  // same here
            temp = temp.next;
        }
        return mpp.get(head);
    }
}

class Solution {
    /*
     * Approach 2: Optimized — Weave/Interleave Trick (Two Pointers)
     * ------------------------------------------------------------
     * Instead of a HashMap, splice each copy node directly after
     * its original so the list temporarily looks like:
     *   A -> A' -> B -> B' -> C -> C' -> ... -> null
     * With that layout, "the copy of any node X" is simply
     * "X.next" — which lets us wire up random pointers with zero
     * extra lookup structure. Afterward we un-weave the two lists
     * back apart, restoring the original list and extracting the
     * copy as an independent list.
     *
     * Runs in 3 linear passes over the list:
     *   Step 1 (insertCopyInBetween)   — interleave copies in
     *   Step 2 (connectRandomPointers) — wire up random pointers
     *   Step 3 (getDeepCopyList)       — split the two lists apart
     *
     * Time Complexity:  O(3N) = O(N) — three separate O(N) passes.
     * Space Complexity: O(1) auxiliary (no map), + O(N) for the N
     *                    new copy nodes themselves (unavoidable,
     *                    since they're the output) — this is the
     *                    main advantage over the brute-force
     *                    approach, which needs O(N) extra for the map.
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: interleave a copy node after every original node
        insertCopyInBetween(head);

        // Step 2: use the interleaved structure to set random pointers
        connectRandomPointers(head);

        // Step 3: split the interleaved list back into original + copy
        return getDeepCopyList(head);
    }

    // Turns  A -> B -> C -> ...
    // into   A -> A' -> B -> B' -> C -> C' -> ...
    private void insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextEle = temp.next;          // remember original next BEFORE overwriting it
            Node copyNode = new Node(temp.val);
            copyNode.next = nextEle;           // A' -> B
            temp.next = copyNode;              // A -> A'
            temp = nextEle;                    // advance to the next ORIGINAL node (B), not A'
        }
    }

    // For each original node `temp`, its copy is `temp.next`.
    // If temp.random == R, then the copy's random should point to
    // R's copy, which (thanks to the interleaving) is simply R.next.
    private void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = temp.next;

            if (temp.random != null)
                copyNode.random = temp.random.next;   // R's copy immediately follows R
            else
                copyNode.random = null;

            temp = temp.next.next;   // skip over the copy, land on the next original node
        }
    }

    // Un-weaves the interleaved list: pulls every copy node out into
    // its own list, while simultaneously restoring the original
    // list's `next` pointers to skip over the (now-removed) copies.
    private Node getDeepCopyList(Node head) {
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (temp != null) {
            // attach the copy node to the result list
            res.next = temp.next;
            res = res.next;

            // disconnect it and restore the original list's link
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}

class Main {
    public static void main(String[] args) {
        // Build the test list: 7 -> 13 -> 11 -> 10 -> 1
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // Set up random pointers
        head.random = null;                                  // 7 -> null
        head.next.random = head;                              // 13 -> 7
        head.next.next.random = head.next.next.next.next;      // 11 -> 1
        head.next.next.next.random = head.next.next;           // 10 -> 11
        head.next.next.next.next.random = head;                // 1  -> 7

        System.out.println("ORIGINAL LL");
        printLL(head);
        System.out.println();

        Solution sol = new Solution();
        head = sol.copyRandomList(head);
        System.out.println("AFTER PERFORMING OPERATION");
        printLL(head);

        System.out.println("\nSERIALISED OUTPUT");
        serialize(head);
    }

    // Walks and prints every node in the list, one per line.
    private static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr + " ");
            curr = curr.next;
        }
    }

    // ---------- LeetCode answer formatter -------------------------
    // Converts the list into LeetCode's [[val, randomIdx], ...]
    // serialization, where randomIdx is the 0-based position of the
    // node the random pointer targets (or "null" if unset). Purely
    // for local testing/debugging — LeetCode's judge does this
    // conversion itself; you never write it as part of a submission.
    private static void serialize(Node head) {
        List<Node> nodes = new ArrayList<>();
        Map<Node, Integer> indexOf = new HashMap<>();

        Node curr = head;
        int i = 0;
        while (curr != null) {
            nodes.add(curr);
            indexOf.put(curr, i++);
            curr = curr.next;
        }

        StringBuilder res = new StringBuilder();
        for (int j = 0; j < nodes.size(); j++) {
            Node n = nodes.get(j);
            Integer randIdx = (n.random == null) ? null : indexOf.get(n.random);
            res.append("[").append(n.val).append(",").append(randIdx == null ? "null" : randIdx).append("]");
            if (j != nodes.size() - 1)
                res.append(",");
        }
        res.append("]");
        System.out.println(res);
    }
}