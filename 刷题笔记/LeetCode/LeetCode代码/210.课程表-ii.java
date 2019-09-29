/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */
class Solution {
    /**
     * ?????
     */
    public class Node{
        public int degree;
        public List<Integer> list;

        public Node(){
            this.degree = 0;
            this.list = new ArrayList<>();
        }
    }

    /**
     * @param numCourses ???????
     * @param prerequisites ?????????
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        Queue<Node> que = new LinkedList<>();
        int[] res = new int[numCourses];
        int s = 0, e = 0, cnt = 0;

        //???
        for(int i = 0; i < numCourses; ++i){
            nodes[i] = new Node();
        }

        //?????
        for(int i = 0; i < prerequisites.length; ++i){
            s = prerequisites[i][1];
            e = prerequisites[i][0];

            nodes[s].list.add(e);
            nodes[e].degree++;
        }

        //????
        for(int i = 0; i < numCourses; ++i){
            if(nodes[i].degree == 0){
                que.add(nodes[i]);
                res[cnt++] = i;
            }
        }

        while(!que.isEmpty()){
            Node tnode = que.peek();
            que.poll();

            for(int i = 0; i < tnode.list.size(); ++i){
                if(--nodes[tnode.list.get(i)].degree == 0){
                    que.add(nodes[tnode.list.get(i)]);
                    res[cnt++] = tnode.list.get(i);
                }
            }
        }

        //??
        if(cnt == numCourses){
            return res;
        } else {
            return new int[0];
        }

    }
}

