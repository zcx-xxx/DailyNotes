/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (44.77%)
 * Likes:    188
 * Dislikes: 0
 * Total Accepted:    27.2K
 * Total Submissions: 60.6K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
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
 * 大体的思路就是遍历原先的链表，当某一个节点与自己的前一个和后一个节点的值均不相同的时候，将其尾插入结果链表，需要注意的就是判断首尾节点的特殊情况
 * 
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode resHead = null;         //结果头节点
        ListNode pTail = null;         //结果尾节点
        ListNode curNode = head;
        ListNode preNode = null;

        //遍历原先的链表
        while (curNode != null) {
            // && 之前的处理的是某一个节点的前边的特殊情况【前一个节点为空】
            // && 之后的处理的是某一个节点的后边的特殊情况【后一个节点为空】
            if ((preNode == null || curNode.val != preNode.val) && 
            (curNode.next == null || curNode.val != curNode.next.val)) {
                //注意需要在此处新建节点，否则当前的节点的 next 不为空，而且也不能置空
                //另一种较好的解决办法是，最后将 pTail 的 next 域置空
                if (resHead == null) {
                    // resHead = new ListNode(curNode.val);
                    resHead = curNode;
                    pTail = resHead;
                } else {
                    // pTail.next = new ListNode(curNode.val);
                    pTail.next = curNode;
                    pTail = pTail.next;
                }
            }

            if (preNode == null){
                preNode = head;
            } else {
                preNode = preNode.next;
            }
            curNode = curNode.next;
        }

        if (pTail != null) {
            pTail.next = null;
        }
        return resHead;
    }
}
// @lc code=end

// [1,2,2]
// [1,1]