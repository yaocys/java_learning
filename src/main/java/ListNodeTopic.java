/**
 * @author yaosunique@gmail.com
 * 2024/7/24 13:51
 */
public class ListNodeTopic {


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode head;
        if (list1.val > list2.val) {
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        } else {
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        }
        return head;
    }
}
