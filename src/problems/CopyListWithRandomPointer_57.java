package problems;

public class CopyListWithRandomPointer_57 {

    public Node copyRandomList(Node head) {
      if(head == null ) {
        return null;
      }

      Node ptr = head;
      while(ptr!= null) {
        Node newNode = new Node(ptr.val);
        newNode.next = ptr.next;
        ptr.next = newNode;
        ptr = newNode.next;
      }

      ptr = head;
      while(ptr!=null) {
        ptr.next.random = ptr.random != null ? ptr.random.next: null;
        ptr = ptr.next.next;
      }

      Node oldList = head;
      Node newList = head.next;
      Node newHead = head.next;
      while(oldList != null) {
        oldList.next = oldList.next.next;
        newList.next = newList.next!=null ? newList.next.next: null;

        oldList = oldList.next;
        newList = newList.next;
      }

      return newHead;
    }
}

class Node{
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
  }
}
