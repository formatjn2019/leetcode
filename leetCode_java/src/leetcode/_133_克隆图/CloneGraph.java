package leetcode._133_克隆图;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        return cloneOneNode(node,new HashMap<>(),new HashSet<>());
    }

    public Node cloneOneNode(Node node, Map<Integer, Node> newItems, Set<Integer> cloned) {
        Node result = newItems.computeIfAbsent(node.val, Node::new);
        node.neighbors.stream()
                .map(item -> newItems.computeIfAbsent(item.val, Node::new))
                .forEach(result.neighbors::add);
        System.out.println(node.neighbors);
        cloned.add(result.val);
        for (Node nodeNeighbor : node.neighbors) {
            if (!cloned.contains(nodeNeighbor.val)){
                cloneOneNode(nodeNeighbor,newItems,cloned);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        n1.neighbors.addAll(List.of(n2,n4));
        n2.neighbors.addAll(List.of(n1,n3));
        n3.neighbors.addAll(List.of(n2,n4));
        n4.neighbors.addAll(List.of(n1,n3));

        cloneGraph.cloneGraph(n1);
    }
}
