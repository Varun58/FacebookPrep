package problems;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerialiizeAndDeserializeBinaryTree_18 {

  public String serialize(TreeNode root) {
    return serializeHelper(root, "");
  }

  private String serializeHelper(TreeNode root, String str) {
    if(root == null) {
      str += "null,";
    } else {
      str += String.valueOf(root.val) + ",";
      str = serializeHelper(root.left, str);
      str = serializeHelper(root.right, str);
    }
    return str;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] dataArr = data.split(",");
    Queue<String> queue = new LinkedList<>(Arrays.asList(dataArr));
    return deserializeHelper(queue);
  }

  private TreeNode deserializeHelper(Queue<String> queue) {
    String data = queue.poll();

    if(Objects.equals(data, "null")) {
      return null;
    }

    TreeNode newNode = new TreeNode(Integer.valueOf(data));

    newNode.left = deserializeHelper(queue);
    newNode.right = deserializeHelper(queue);
    return newNode;
  }
}
