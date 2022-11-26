package myLeetCodeAnswer;
//leetcode No.788 pass
import java.util.HashMap;

public class rotatedDigits {
    public static void main(String[] args) {
        int n = 100;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1;i < dp.length;i++){
            dp[i] = dp[i-1] + (isGoodNum(i) ? 1 : 0);
        }
        System.out.println(dp[n]);
    }
    private static boolean isGoodNum(int n){
        HashMap<Character,Integer> map = new HashMap<>();
        String s = String.valueOf(n);
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        if(map.containsKey('3') || map.containsKey('4') || map.containsKey('7')){
            return false;
        }
        else return (map.containsKey('2')) || (map.containsKey('5')) || (map.containsKey('6')) || (map.containsKey('9'));
    }
}
