package myLeetCodeAnswer;

import java.util.Stack;

//leetcode No.394 failed 有点恶心 写了两三点还是找不到思路 虽然知道是用栈做 类似逆波兰那道题 但是不会边计算边转 给了 思路完全不对 没有一个答案用的分割写法
//不过答案是用linkedlist来做的 我想看看自己写一边stack看看有什么不一样
public class decodeString {
    public static void main(String[] args) {
        String s = "3[2[ab]3[bc]]";
        //想了一下 不能随意使用中心扩散 因为比如说2[ab3[ac]]这种，他的字母左边，可能就是个需要处理东西，如果用扩散，就直接处理他了，不合适。
        //左括号左边一定是数字 或者左括号，，右括号左边一定是字母
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> stack_multi = new Stack<>();//存放数字
        Stack<String> stack_res = new Stack<>();//存放字符串
        for(Character c: s.toCharArray()){
            if(c == '['){
                /*
                当C为“[”时，将当前multi和res入栈，置空。
                记录在这左括号之前的，放进res的临时结果，用于发现对应右括号的拼接操作。
                记录在这左括号之前的mulit，丢进栈里面，用于发现对应右括号的时候，获取multi * [res]的字符串
                进行的新的左括号后，res和mulit重新记录。
                 */
                stack_multi.push(multi);//数字入栈
                stack_res.push(res.toString());//字符串入栈
                multi = 0;//重置
                res = new StringBuilder();//重置
            }
            else if(c == ']'){
                /*
                当C为“]”时，stack需要出栈，拼接字符串 res = last_res + cur_multi * res
                last_res = 上一个左括号到当前左括号的字符串，存放在stack_res里
                cur_multi是当前左括号到右括号内字符串的重复倍数，存放在stack_multi里
                 */
                StringBuilder temp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for(int i = 0; i < cur_multi;i++){
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + temp);
            }
            else if(c >= '0' && c <= '9'){
                //当C为数字时，将数字字符转化为数字multi，用于后续倍数计算
                multi = multi * 10 + (c - '0');
            }
            else {
                //当C为字母时，在res尾部添加C
                res.append(c);
            }
        }
        System.out.println(res.toString());
    }
}
