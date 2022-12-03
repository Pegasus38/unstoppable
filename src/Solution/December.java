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
}
