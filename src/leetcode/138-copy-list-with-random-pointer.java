/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.



Example 1:


Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.




Note:
1.You must return the copy of the given head as a reference to the cloned list.

 */

package leetcode;

import java.util.Map;

class CopyListWithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        java.util.Map<Node, Node> visited = new java.util.HashMap<>();

        return copyRandomList(head, visited);
    }

    private Node copyRandomList(Node current, Map<Node, Node> visited) {
        if (current == null) {
            return null;
        }

        if (visited.containsKey(current)) {
            return visited.get(current);
        }

        Node newNode = new Node();
        visited.put(current, newNode);

        newNode.val = current.val;
        newNode.next = copyRandomList(current.next, visited);
        newNode.random = copyRandomList(current.random, visited);

        return newNode;
    }
}
