package niuke.algorithmTop101;
// 合并两个有序的链表，并合并后 的链表也有序
public class BM4MergeLinkedList {
    public static void main(String[] args) {

    }
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode head = new ListNode(0);
        ListNode phead = head;
        while (pHead1 != null || pHead2 != null){
            if (pHead1 == null){
                head.next = pHead2;
                pHead2 = pHead2.next;
                head.next.next = null;
                head = head.next;
                continue;
            }
            if (pHead2 == null){
                head.next = pHead1;
                pHead1 = pHead1.next;
                head.next.next = null;
                head = head.next;
                continue;
            }
            if (pHead1.val <= pHead2.val){
                head.next = pHead1;
                pHead1 = pHead1.next;
                head.next.next = null;
                head = head.next;
            }else {
                head.next = pHead2;
                pHead2 = pHead2.next;
                head.next.next = null;
                head = head.next;
            }
        }
        return phead.next;
    }
}
