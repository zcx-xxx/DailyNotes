/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (48.43%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    63.2K
 * Total Submissions: 130.1K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = head;
        ListNode curNode = null;

        if (head.next != null) {
            curNode = head.next;
        } else {
            return head;
        }

        //删除元素
        while (curNode != null) {
            if (curNode.val == preNode.val) {
                curNode = curNode.next;
                preNode.next.next = null;
                preNode.next = curNode;
            } else {
                preNode = preNode.next;
                curNode = curNode.next;
            }
        }

        return head;
    }
}
// @lc code=end

// [1,1,2,3,3]