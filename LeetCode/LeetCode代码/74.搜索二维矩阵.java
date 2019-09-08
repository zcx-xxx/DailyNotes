/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */
class Solution {
    /**
     * 标准的二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0, end = m * n - 1;

        while(start <=  end){
            int mid = (start + end) / 2;
            
            if(matrix[mid / m][mid % m] == target){
                return true;
            } else if(matrix[mid / m][mid % m] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    /**
     * 返回值为符合条件的元素的下标
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
    
        while(start <  end){
            int mid = (start + end + 1) / 2;
    
            if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid;
            }
        }
    
        if(nums[start] > target){
            return -1;
        }
        return start;
    }


    public int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
    
        while(start <  end){
            int mid = (start + end) / 2;
    
            if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
    
        if(nums[end] < target){
            return -1;
        }
        return start;
    }
}

