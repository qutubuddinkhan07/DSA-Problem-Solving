import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + (next != null ? next.val : "null") +
                ", random=" + (random != null ? random.val : "null") +
                '}';
    }
}

class BruteSolution{
    /*-
    Approach -1: Brute Force [Using Map]
    Time Complexity: O(n) + O(n) + O(1) [depends on the map]
    Space Complexity: O(n) + O(n) [because of nodes we created]
     */
    public Node copyRandomListBrute(Node head) { // Brute
        Node temp = head;
        Map<Node, Node> mpp = new HashMap<>();

        // traverse in List and create copies
        while (temp != null) {
            Node newNode = new Node(temp.val);
            mpp.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copyNode = mpp.get(temp);
            copyNode.next = mpp.get(temp.next);
            copyNode.random = mpp.get(temp.random);
            temp = temp.next;
        }
        return mpp.get(head);
    }
}

class Solution{
    /*-
    Using Optimized Approach [Two Pointers]

    Time Complexity: O(3N),
    Space Complexity : O(N)
     */
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        // Step 1: Copy nodes
        insertCopyInBetween(head);

        // Step 2: Connect random
        connectRandomPointers(head);

        // Step 3: Retrieve the deep copy of the LL
        return getDeepCopyList(head);
    }
    private void insertCopyInBetween(Node head){
        Node temp = head;
        while(temp != null){
            Node nextEle = temp.next;
            Node copyNode = new Node(temp.val);
            copyNode.next = nextEle;
            temp.next = copyNode;
            temp = nextEle;
        }
    }
    private void connectRandomPointers(Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = temp.next;

            if(temp.random != null)
                copyNode.random = temp.random.next;
            else
                copyNode.random = null;

            temp = temp.next.next;
        }
    }
    private Node getDeepCopyList(Node head){
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while(temp != null){
            // creating a new List pointing to copied nodes
            res.next = temp.next;
            res = res.next;

            // disconnect and revert back the List to original List
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return  dummyNode.next;
    }
}

class Main{
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // 7 -> Null
        head.random = null;

        // 13 -> 7
        head.next.random = head;

        // 11 -> 10
        head.next.next.random = head.next.next.next.next;

        // 10 -> 13
        head.next.next.next.random = head.next.next;

        // 1 -> 7
        head.next.next.next.next.random = head;
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

    private static void printLL(Node head){
        Node curr = head;
        while (curr != null){
            System.out.println(curr + " ");
            curr = curr.next;
        }
    }

    // ---------- LeetCode answer formatter -------------------------
    private static void serialize(Node head){
        List<Node> nodes = new ArrayList<>();
        Map<Node, Integer> indexOf = new HashMap<>();

        Node curr = head;
        int i=0;
        while(curr != null){
            nodes.add(curr);
            indexOf.put(curr, i++);
            curr = curr.next;
        }

        StringBuilder res = new StringBuilder();
        for(int j = 0; j<nodes.size(); j++){
            Node n = nodes.get(j);
            Integer randIdx = (n.random == null) ? null : indexOf.get(n.random);
            res.append("[").append(n.val).append(",").append(randIdx == null ? "null" : randIdx).append("]");
            if(j != nodes.size()-1)
                res.append(",");
        }
        res.append("]");
        System.out.println(res);
    }
}

