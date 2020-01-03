/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (54.35%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    21.9K
 * Total Submissions: 40K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * 示例:
 * 
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 以第一个节点为界，维护左右两个指针，分别做插入,记住每次插入后将最后一个节点的指针域赋空，否则会报内存溢出
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode left = null, right = null, cur = null;
        ListNode leftHead = null, rightHead = null;

        cur = head;

        while (cur != null) {
            if (cur.val < x) {            //小于指定的值
                if (left == null) {
                    left = cur;          //维护左边最后
                    leftHead = cur;       //维护新的头节点
                    cur = cur.next;
                    left.next = null;
                } else {
                    left.next = cur;
                    cur = cur.next;
                    left = left.next;
                    left.next = null;
                }
            } else {            //大于等于指定的值
                if (right == null) {
                    right = cur;
                    rightHead = cur;
                    cur = cur.next;
                    right.next = null;
                } else {
                    right.next = cur;
                    cur = cur.next;
                    right = right.next;
                    right.next = null;
                }
            }
        }

        //连接链表
        if (leftHead != null) {
            left.next = rightHead;
        } else {
            leftHead = rightHead;
        }
        return leftHead;
    }
}
// @lc code=end

// [1,1]\n2
// [2,1]\n2