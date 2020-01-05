/*
 * @lc app=leetcode.cn id=5305 lang=java
 *
 * [5305] 获取你好友已看的视频
 *
 * https://leetcode-cn.com/problems/get-watched-videos-by-your-friends/
 * 
 * 题目描述具体见上方网址
 */
/**
 * bfs 找出指定 level 的所有的电影名，同时使用 map 记录每一个电影的出现次数，自定义字符串的比较规则进行排序
 * 注意此处的排序小技巧，由于根据次数进行排序，并不需要必须将电影的名字和电影出现的次数绑定在一起，由于可以指定具体的比较规则，因此只需要我后续和以根据电影的名字找到他的次数即可
 */

// @lc code=start
class Solution {
    private boolean[] book = new boolean[100 + 5];        //记录每一个人是否被访问过
    private Map<String, Integer> moviceToNums = new HashMap<>();        //统计每一个电影出现的次数
    private List<String> resList = new ArrayList<>();

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Person> queue = new LinkedList<>();
        Person p = new Person(id, 0);
        queue.add(p);
        book[id] = true;

        //做一个 bfs
        while (!queue.isEmpty()) {
            Person tmp = queue.peek();
            queue.poll();
            int tid = tmp.id;
            int tlevel = tmp.level;

            //到达指定的层之后，后续的层就不需要再访问了
            if (tlevel == level) {
                System.out.println(tlevel);
                for (String movice : watchedVideos.get(tid)) {
                    int cnt = 1;
                    if (moviceToNums.containsKey(movice)) {
                        cnt = moviceToNums.get(movice) + 1;
                    } else {
                        resList.add(movice);
                    }
                    moviceToNums.put(movice, cnt);
                }
                continue;
            }

            //将下一层放入队列
            for (Integer newId : friends[tid]) {
                if (!book[newId]) {
                    Person newPerson = new Person(newId, tlevel + 1);
                    queue.add(newPerson);
                    book[newId] = true;
                }
            }
        }

        //将结果进行排序
        Collections.sort(resList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (moviceToNums.get(o1) - moviceToNums.get(o2) != 0) {
                    return moviceToNums.get(o1) - moviceToNums.get(o2);
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        return resList;
    }

    // 人的编号和 level 的对应类
    public class Person{
        int id, level;
        
        public Person () {}
        public Person (int id, int level) {
            this.id = id;
            this.level = level;
        }
    }
}
// @lc code=end