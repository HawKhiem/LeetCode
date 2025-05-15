package BinaryTree.no0116;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node prev = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                Node current = queue.poll();
                if (current != null) {
                    if (prev != null) {
                        prev.next = current;
                    }
                    prev = current;
                    if (queue.isEmpty()) {
                        current.next = null;
                    }
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            prev = null;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
