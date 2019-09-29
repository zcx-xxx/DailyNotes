/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        //?????????
        int len = 0;
        ListNode tmp = head;
        while(tmp != null){
            tmp = tmp.next;
            len++;
        }

        //????????????
        k = k % len;
        if(k == 0){
            return head;
        }

        //???? k ????????? k ?????????
        ListNode right = head, left = head;
        
        while(k != 0){
            right = right.next;
            k--;
        }

        //?? left ????? k ?????????
        while(right.next != null){
            left = left.next;
            right = right.next;
        }

        ListNode res = left.next;
        right.next = head;
        left.next = null;

        return res;
    }
}

