package Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class December {
    public static void main(String[] args) {

    }
    //12.2
    //leetcode No.1769 每日一题 暴力解pass
    public static int[] minOperations(String boxes){
        int[] res = new int[boxes.length()];
        for(int i = 0;i < res.length;i++){
            int count = 0;
            for(int j = 0;j < res.length;j++){
                if(boxes.charAt(j) == '1'){
                    count += Math.abs(j-i);
                }
            }
            res[i] = count;
        }
        return res;
    }
    //12.3
    //leetcode No.1796 每日一题 pass 原来8月份就做过了.
    public static int secondHighest(String s){
        HashSet<Integer> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                set.add(c-'0');
            }
        }
        List<Integer> list = new ArrayList<>(set);
        if(list.size() < 2){
            return -1;
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size()-2);
    }
    //leetcode No.343 pass 规律题 但是数据规模太小 很简单的过了 不用取余 如果数据规模大了 就是剑指offer的14 也是用这个方法
    public static int integerBreak(int n){
        long res = 1;
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int count = n / 3;
        int mod = n % 3;
        if(mod == 0){
            for(int i = 0;i < count;i++){
                res *= 3;
                res %= 1000000007;
            }
        }
        else if(mod == 1){
            for(int i = 0;i < count-1;i++){
                res *= 3;
                res %= 1000000007;
            }
            res *= 4;
            res %= 1000000007;
        }
        else {
            for(int i = 0;i < count;i++){
                res *= 3;
                res %= 1000000007;
            }
            res *= 2;
            res %= 1000000007;
        }
        return (int)res;
    }

}
