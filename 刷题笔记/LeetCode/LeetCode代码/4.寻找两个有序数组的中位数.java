/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (36.41%)
 * Likes:    1931
 * Dislikes: 0
 * Total Accepted:    126K
 * Total Submissions: 346K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */
/**
 * 方法一：首先祭出 O(m + n) 的算法，参照归并排序的合并过程，根据元素的个数，找出中位数的位置
 * 
 * 方法二：使用二分，依次排除 (k / 2), 最开始 k 为 (nums1.length + nums2.length) / 2
 *      设两个数组分别为 A 和 B
 *      则若 A[1]、A[2] ... A[i]、A[k / 2]、A[(k / 2) + 1] ... A[nums1.length - 1]
 *          B[1]、B[2] ... B[j]、A[k / 2]、B[(k / 2) + 1] ... B[nums2.length - 1]
 *      中，A[k / 2] < B[k / 2]; 则可以直接将 A[1] ... A[k / 2] 的元素排除，因为 A[k / 2] 不可能
 *      是第 k 个元素，最多为第 (k - 1) 个元素【最极端的情况下就是 A[k / 2] < B[k / 2], 
 *      A[k / 2] > B[k / 2 - 1], 此时 A[k / 2] 为第 (k - 1) 个元素】
 * 具体的解释见：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 *
 * 方法三：还是二分，与上方不同。该二分是将相对短的数组进行二分，找到一个值，将两个数组划分为两部分，左半部分的最大值
 *      小于右半部分的最小值。看的官方题解，考虑的条件挺多的，自己按着自己的理解写一下。
 */
// @lc code=start
class Solution {
    private int[] nums1;
    private int[] nums2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        /************** 方法一 ************* */
        // int tar = (nums1.length + nums2.length) / 2;
        // int left = -1, right = -1;
        // int index1 = 0, index2 = 0;

        //寻找第 k 小
        // for (int i = 0; i <= tar; i++) {
        //     left = right;
        //     if (index1 < nums1.length && index2 < nums2.length) {
        //         if (nums1[index1] < nums2[index2]) {
        //             right = nums1[index1++];
        //         } else {
        //             right = nums2[index2++];
        //         }
        //     } else if (index1 >= nums1.length){
        //         right = nums2[index2++];
        //     } else {
        //         right = nums1[index1++];
        //     }
        // }
        /******** 改进写法 ******** */
        // for (int i = 0; i <= tar; i++) {
        //     left = right;
        //     if (index1 < nums1.length && (index2 >= nums2.length || nums1[index1] <= nums2[index2])) {
        //         right = nums1[index1++];
        //     } else {
        //         right = nums2[index2++];
        //     }
        // }    
        /******** 改进写法 ******** */

        // if ((nums1.length + nums2.length) % 2 == 1) {
        //     return right;
        // } else {
        //     return (left + right) / 2.0;
        // }
        /************** 方法一 ************* */

        /*********** 方法二：二分 ********** */
        // int len1 = nums1.length, len2 = nums2.length;
        // //奇数，返回
        // if (((len1 + len2) & 1) == 1) {
        //     return getKthElem((len1 + len2 + 1) / 2) * 1.0;
        // } else {
        //     return (getKthElem((len1 + len2 + 1) / 2) + getKthElem((len1 + len2 + 2) / 2)) / 2.0;
        // }
        /*********** 方法二：二分 ********** */

        /*********** 方法三：二分 ********** */
        if (nums1.length <= nums2.length) {
            return binarySearchTwoArray(nums1, nums2, (nums1.length + nums2.length + 1) / 2);
        } else {
            return binarySearchTwoArray(nums2, nums1, (nums1.length + nums2.length + 1) / 2);
        }
        /*********** 方法三：二分 ********** */
    }

    /**
     * 方法二的二分，获取两个数组中的第 k 小的元素
     * @param k
     * @return
     */
    public int getKthElem(int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int start1 = 0, start2 = 0;

        while (true) {
            if (start1 == len1 || start2 == len2) {           //当某一个数组被全部排除的时候
                return start1 == len1 ? nums2[start2 + k - 1] : nums1[start1 + k - 1];
            } else if (k == 1) {     //当 k 为 1 的时候
                return Math.min(nums1[start1], nums2[start2]);
            }

            int tmp = k / 2;
            int cpOne = -1;
            int cpTwo = -1;

            //确定两个要比较的元素
            if (start1 + tmp > len1) {
                cpOne = len1 - 1;
            } else {
                cpOne = start1 + tmp - 1;
            }
            if (start2 + tmp > len2){
                cpTwo = len2 - 1;
            } else {
                cpTwo = start2 + tmp - 1;
            }

            //比较，将某一个数组的前 (k / 2) 排除
            if (nums1[cpOne] > nums2[cpTwo]) {
                k -= (cpTwo - start2 + 1);
                start2 = cpTwo + 1;       //排除第二个数组的前一部分
            } else {          //排除第一个数组的前一部分
                k -= (cpOne - start1 + 1);
                start1 = cpOne + 1;
            }
        }
    }

    /**
     * 方法三的二分，二分小的数组，将两个数组重新划分为两部分
     * @param smallNums 小数组
     * @param bigNums 大数组
     * @param k 找第几个元素
     * @return 结果
     */
    public double binarySearchTwoArray(int[] smallNums, int[] bigNums, int k){
        int len1 = smallNums.length, len2 = bigNums.length;
        int left = 0, right = len1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int index = k - mid;

            /**** ggg*/
            // System.out.println(mid + " " + index);
            /****ggggggg */

            if (mid < right && bigNums[index - 1] > smallNums[mid]){
                left = mid + 1;    // i is too small
            } else if (mid > left && smallNums[mid - 1] > bigNums[index]) {
                right = mid - 1;  // i is too big
            } else {              // i is perfect
                int maxLeft = 0;
                if (mid == 0) {
                    maxLeft = bigNums[index - 1]; 
                } else if (index == 0) { 
                    maxLeft = smallNums[mid - 1]; 
                } else { 
                    maxLeft = Math.max(smallNums[mid - 1], bigNums[index - 1]); 
                }
                if ((len1 + len2) % 2 == 1) { 
                    return maxLeft; 
                }

                int minRight = 0;
                if (mid == len1) { 
                    minRight = bigNums[index]; 
                } else if (index == len2) { 
                    minRight = smallNums[mid]; 
                } else { 
                    minRight = Math.min(bigNums[index], smallNums[mid]); 
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return -1;
    }
}
// @lc code=end
// [1,2]\n[3,4]

