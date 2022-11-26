package myLeetCodeAnswer;

import java.util.HashSet;

//leetcode No.1935 pass
public class canBeTypeWords {
    public static void main(String[] args) {
        String text = "leet code";
        String brokenLetters = "e";
        int res = 0;
        String[] s = text.split(" ");
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        for(String c : s){
            if(isVaild(c,set)){
                res++;
            }
        }
        System.out.println(res);
    }
    private static boolean isVaild(String s,HashSet<Character> b){
        for(char c : b){
            if(s.contains(c + "")){
                return false;
            }
        }
        return true;
    }
}
