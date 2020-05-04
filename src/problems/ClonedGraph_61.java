package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ClonedGraph_61 {

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

  public Node cloneGraph(Node node) {
    if(node == null) return node;

    HashMap<Node, Node> visited = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    Node clonedNode = new Node(node.val, new ArrayList<>());
    visited.put(node, clonedNode);
    queue.add(node);

    while(!queue.isEmpty()) {
      Node n = queue.remove();
      for(Node nei : n.neighbors) {
        if(!visited.containsKey(nei)) {
          visited.put(nei, new Node(nei.val, new ArrayList<>()));
          queue.add(nei);
        }

        visited.get(n).neighbors.add(visited.get(nei));
      }
    }
    return visited.get(node);
  }

  HashMap<Node, Node> visited = new HashMap<>();

  public Node cloneGraphR(Node node) {
    if(node == null) return node;

    if(visited.containsKey(node)) {
      return visited.get(node);
    }

    Node clonedNode = new Node(node.val, new ArrayList<>());
    visited.put(node,clonedNode);

    for(Node nei : node.neighbors) {
      clonedNode.neighbors.add(cloneGraph(nei));
    }

    return clonedNode;
  }
}



