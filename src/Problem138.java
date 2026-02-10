package src;

import java.util.HashMap;
import java.util.Map;

public class Problem138 {

// Definition for a Node.
static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            Node temp = new Node(cur.val);
            if (!map.containsKey(cur)) {
                map.put(cur, temp);
            }

            if (cur.next != null && !map.containsKey(cur.next)) {
                Node nextCon = new Node(cur.next.val);
                map.put(cur.next, nextCon);
                temp.next = map.get(cur.next);
            }

            cur = cur.next;
        }


        cur = head;
        while (cur != null) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;

        Problem138 obj = new Problem138();
        Node newNode = obj.copyRandomList(head);
        for (Node cur=newNode; cur!=null;cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}
