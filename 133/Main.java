import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        Node first = new Node(1);
        Main main = new Main();
        System.out.println(main.cloneGraph(first).val);
    }

    public Node cloneGraph(Node first) {
        if (first == null)
            return new Node();
        HashSet<Integer> checked = new HashSet<Integer>();
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        map.put(first.val, new Node(first.val));
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(first);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node adjNode : node.neighbors) {
                if (!checked.contains(adjNode.val)) {
                    queue.add(adjNode);
                    map.putIfAbsent(adjNode.val, new Node(adjNode.val));
                    map.get(adjNode.val).neighbors.add(map.get(node.val));
                    map.get(node.val).neighbors.add(map.get(adjNode.val));
                }
            }
            checked.add(node.val);
        }
        return map.get(first.val);
    }
}