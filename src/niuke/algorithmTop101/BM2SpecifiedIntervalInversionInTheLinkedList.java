package niuke.algorithmTop101;

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//}

public class BM2SpecifiedIntervalInversionInTheLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int m = 2, n = 4;
        ListNode head = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode temp = new ListNode(i);
            temp.next = head;
            head = temp;
        }
        head = reverseBetween(head, m, n);
        System.out.println(head);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lNode = head, rNode, temp = null;

        for (int i = 0; i < m - 1; i++) {
            lNode = lNode.next;
        }
        rNode = lNode.next;
        for (int i = 0; i < n; i++) {
            if(rNode == null){
                break;
            }
            temp = rNode.next;
            lNode.next = lNode;
            lNode = rNode;
            rNode = temp;
        }
        return head;
    }
}
