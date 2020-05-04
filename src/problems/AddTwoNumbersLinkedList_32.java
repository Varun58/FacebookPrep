package problems;

import java.util.Stack;

public class AddTwoNumbersLinkedList_32 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode p = l1;
    ListNode q = l2;
    ListNode curr = dummy;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;

      int sum = x + y + carry;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);

      curr = curr.next;
      if (p != null) {
        p = p.next;
      }

      if (q != null) {
        q = q.next;
      }
    }

    if (carry > 0) {
      curr.next = new ListNode(carry);
    }

    return dummy.next;
  }

  // cannot reverse and most signifcant digit is in front
  public ListNode addTwoNumbersPart2(ListNode l1, ListNode l2) {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    ListNode p = l1;
    while (p != null) {
      s1.push(p.val);
      p = p.next;
    }

    ListNode q = l1;
    while (q != null) {
      s2.push(q.val);
      q = q.next;
    }

    ListNode dummy = new ListNode(0);
    int sum = 0;
    while (!s1.isEmpty() || !s2.isEmpty()) {
      if (!s1.isEmpty()) {
        sum += s1.pop();
      }

      if (!s2.isEmpty()) {
        sum += s2.pop();
      }

      dummy.val = sum % 10;

      int carry = sum / 10;
      ListNode newNode = new ListNode(carry);
      newNode.next = dummy;
      dummy = newNode;

      sum = carry;
    }

    return dummy.val == 0 ? dummy.next : dummy;
  }


  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
