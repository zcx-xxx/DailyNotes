/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */
class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }

        //寻找最大，最小值
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }

        //计算出桶的大小
        int vol = (max - min + 1)/(nums.length - 1);
        //++vol 是防止后边报除 0 异常
        if(vol == 0){
            ++vol;
        }

        //计算桶的数目
        int bucketCount = (max - min + 1) / vol + 1;
        int[][] tub = new int[bucketCount][2];

        //将元素装入指定的桶中
        int tmp = 0;
        for(int i = 0; i < nums.length; ++i){
            tmp = (nums[i] - min) / vol;
            if(nums[i] > tub[tmp][1] || tub[tmp][1] == 0){
                tub[tmp][1] = nums[i];
            }
            if(nums[i] < tub[tmp][0] || tub[tmp][0] == 0){
                tub[tmp][0] = nums[i];
            }
        }

        //从头到尾遍历，寻找最大间距
        int res = tub[0][1] - tub[0][0];
        int pre = tub[0][1];
        for(int i = 1; i < tub.length; ++i){
            if(tub[i][0] - pre > res){
                res = tub[i][0] - pre;
            }
            if(tub[i][1] > pre){
                pre = tub[i][1];
            }
        }

        return res;
    }
}
 
