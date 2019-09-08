import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()){
                    return false;
                } else {
                    char c = stack.peek();
                    if((c == '(' && s.charAt(i) == ')')
                    || (c == '{' && s.charAt(i) == '}')
                    || (c == '[' && s.charAt(i) == ']')){
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        if(stack.empty()){
            return true;
        } else {
            return false;
        }
    }
}

