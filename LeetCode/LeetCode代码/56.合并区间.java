import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Set<Node> set = new TreeSet<>();
        int[][] arr = new int[intervals.length][2];

        for(int i = 0; i < intervals.length; ++i){
            set.add(new Node(intervals[i][0], intervals[i][1]));
        }

        int i = 0;
        int ta = 0, tb = 0;
        for(Node node : set){
            if(i == 0){
                arr[i][0] = node.a;
                arr[i][1] = node.b;
                i++;
            } else {
                ta = node.a;
                tb = node.b;

                if(ta <= arr[i - 1][1] && tb > arr[i - 1][1]){
                    arr[i - 1][1] = tb;
                } else if(ta > arr[i - 1][1]){
                    arr[i][0] = ta;
                    arr[i][1] = tb;
                    i++;
                }
            }
        }

        int[][] brr = new int[i][2];
        for(int j = 0; j < i; ++j){
            brr[j][0] = arr[j][0];
            brr[j][1] = arr[j][1];
        }

        return brr;
    }
}

class Node implements Comparable<Node>{
    int a, b;

    public Node(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node node){
        if(this.a == node.a){
            return node.b - this.b;
        }
        return this.a - node.a;
    }
}

