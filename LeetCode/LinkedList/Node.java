public class Node {
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
