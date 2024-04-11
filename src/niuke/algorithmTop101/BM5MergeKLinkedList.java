package niuke.algorithmTop101;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BM5MergeKLinkedList {
    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<>();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(-1);
        lists.add(node1);
        lists.add(null);
        lists.add(node2);
        System.out.println(new Solution().mergeKLists(lists).val);
    }

}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here
        ListNode head = new ListNode(0);
        ListNode pHead = head;
        while (lists.size() > 0){
            int index = MinLinked(lists);
            if (index == -1){
                break;
            }
            ListNode temp = lists.get(index);
            pHead.next = temp;
            lists.add(temp.next);
            lists.remove(temp);
            pHead.next.next = null;
            pHead = pHead.next;
            for (int i = 0;i < lists.size();i++) {
                if (lists.get(i) == null){
                    lists.remove(lists.get(i));
                }
            }
        }
        return head.next;
    }
    public int MinLinked(ArrayList<ListNode> lists){
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) == null){
                continue;
            }
            if (lists.get(i).val < min) {
                min = lists.get(i).val;
                index = i;
            }
        }
        return index;
    }
}
