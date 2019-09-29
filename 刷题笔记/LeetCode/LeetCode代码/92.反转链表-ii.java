/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //创建头结点
        ListNode prevNode = new ListNode(0);
        prevNode.next = head;
        int prev = 0;
        
        //找第 m-1 个结点
        while(prev < m - 1){
            prevNode = prevNode.next;
            prev++;
        }

        //将 m - 1 个结点作为头结点，将 m ~ n 的结点进行头插
        //index 在此处并无实际的对应意义，只是起到计数的作用
        ListNode cur = prevNode.next;
        int index = m;       

        while(index < n){
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = prevNode.next;
            prevNode.next = tmp;
            index++;
        }

        if(m == 1){
            return prevNode.next;
        } else {
            return head;
        }
    }
}

