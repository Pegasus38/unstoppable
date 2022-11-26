package myLeetCodeAnswer;

import java.util.HashMap;

//leetcode No.1897 pass 但是提交错了三次，第一次是忘记处理单个字符串的情况，第二次是多了一个判断，不需要判断里面的出现次数是否相等的，第三次是没有把之前的代码改回来。
public class makeEqual {
    public static void main(String[] args) {
        String[] words = {"ab","a"};
        HashMap<Character,Integer> map = new HashMap<>();
        for(String s : words){
            for(int i = 0;i < s.length();i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
        }
        boolean tag = true;
        Integer[] a = map.values().toArray(new Integer[0]);
        for(int i = 0; i < a.length;i++){
            if(a[i] % words.length != 0){
                tag = false;
            }
        }
        System.out.println(tag);
    }
}
