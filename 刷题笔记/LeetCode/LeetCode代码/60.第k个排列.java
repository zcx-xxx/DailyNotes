import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (47.55%)
 * Likes:    147
 * Dislikes: 0
 * Total Accepted:    19.2K
 * Total Submissions: 40.3K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */

// @lc code=start
class Solution {
    private int end;
    private int[] arr;
    private int cnt = 0;
    private int k;
    private String res = "";

    public String getPermutation(int n, int k) {
        end = n;
        this.k = k;
        arr = new int[end + 1];

        init();
        
        /************* 字典序法 *************** */
        // for(int i = 1; i < k; ++i){
        //     getNextPermutation();
        // }
        
        // StringBuffer buffer = new StringBuffer();
        // for(int t = 1; t <= end; ++t){
        //     buffer.append(arr[t]);
        // }

        // return buffer.toString();
        /************* 字典序法 *************** */

        /************* 递归法****************** */
        getPermutation(1);
		return res;
        /************* 递归法****************** */
    }

    /**
     * 初始化
     */
    public void init(){
        for(int i = 0; i <= end; ++i){
            arr[i] = i;
        }
    }

    /**
     * 字典序法生成下一个排列
     * @return
     */
    public void getNextPermutation(){
        int index1 = 0;
        //首先从右向左找第一个 p[i - 1] < p[i]
        for(int i = end; i > 1; --i){
            if(arr[i] > arr[i - 1]){
                index1 = i - 1;
                break;
            }
        }

        //从右向左找到第一个大于 p[index1] 的元素，并交换
        for(int i = end; i > index1; --i){
            if(arr[i] > arr[index1]){
                int tmp = arr[index1];
                arr[index1] = arr[i];
                arr[i] = tmp;
                break;
            }
        }

        //反转数组，将 p[index1] 后边的元素进行翻转
        for(int i = index1 + 1, j = end; i < j; ++i, --j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return;
    }

    /**
     * 递归生成全排列，按字典序的
     * @param index
     */
    public boolean getPermutation(int index){
        //递归结束
        if(index == end){
            cnt++;
            if(cnt == k){
                StringBuffer buffer = new StringBuffer();
                for(int t = 1; t <= end; ++t){
                    buffer.append(arr[t]);
                }
                res = buffer.toString();
                return true;
            }
            return false;
        }

        for(int i = index; i <= end; ++i){
            //先排序，保证生成的排列为字典序
            Arrays.sort(arr, index, end + 1);
            //交换
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
            //递归排列
            if(getPermutation(index + 1)){
                return true;
            }
            //在交换回去
            tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
        return false;
    }
}
// @lc code=end

