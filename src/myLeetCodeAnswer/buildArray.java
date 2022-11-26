package myLeetCodeAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode No.1441 pass 但是没看懂这个n有什么用
public class buildArray {
    public static void main(String[] args) {
        int[] target = {2,3,4};
        int n = 5;
        Stack<Integer> stack = new Stack<>();
        int now = 1;
        List<String> list = new ArrayList<>();
        if(stack.isEmpty()){
            stack.push(now);
            list.add("Push");
        }
        for(int i = 0;i < target.length;i++){
            while(stack.peek() != target[i]){
                now = stack.pop() + 1;
                list.add("Pop");
                stack.push(now);
                list.add("Push");
            }
            if(stack.size() < target.length){
                stack.push(++now);
                list.add("Push");
            }
        }
        System.out.println(list);
    }
}
