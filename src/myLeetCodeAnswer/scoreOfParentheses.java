package myLeetCodeAnswer;

import java.util.Stack;

//leetcode No.856 不写了 有点烦躁
public class scoreOfParentheses {
    public static void main(String[] args) {
        String s = "()(()(())())";
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(0);
            }
            else {
                int v = stack.pop();
                int top = stack.pop() + Math.max(2 * v,1);
                stack.push(top);
            }
        }
        System.out.println(s.replace("()","1"));
        System.out.println(stack.peek());
    }
}
