import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */
class MinStack {
    Stack<Integer> s1 = null;
    Stack<Integer> s2 = null;

    /** 
     * initialize your data structure here. 
     * 使用两个栈保存数据，s1 按插入顺序保存，s2 永远保存比栈顶小的元素 
     * */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /**
     * 添加元素
     * @param x
     */
    public void push(int x) {
        s1.push(x);
        
        //s2 为空或者 x 小于等于 s2 的栈顶元素
        if(s2.empty() || x <= s2.peek()){
            s2.push(x);
        }
    }
    
    /**
     * 弹出元素
     */
    public void pop() {
        if(!s1.empty()){
            int tmp = s1.peek();
            s1.pop();

            //如果 s1 将最小值弹出，则 s2 也需要同时将该值弹出
            if(tmp == s2.peek()){
                s2.pop();
            }
        }
    }
    
    /**
     * 获取栈顶元素，但不删除
     * @return
     */
    public int top() {
        return s1.peek();
    }
    
    /**
     * 返回栈中的最小值
     * @return
     */
    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

