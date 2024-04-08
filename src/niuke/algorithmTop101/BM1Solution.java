package niuke.algorithmTop101;


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class BM1Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList(ListNode head) {
        // write code here
        if(head == null){
            return null;
        }
        ListNode a = head;
        ListNode b = head.next;
        a.next = null;
        while (b.next.next != null) {
            ListNode temp = b.next;
            b.next = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
