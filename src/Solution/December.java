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
    //12.4
    //leetcode No.1492 pass
    public static int kthFactor(int n, int k){
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            if(n % i == 0){
                list.add(i);
            }
        }
        if(k > list.size()){
            return -1;
        }
        return list.get(k-1);
    }
    //12.6
    //leetcode No.2053 pass 优化之后 用两个set 用趟循环 超过100%执行用时
    public static String kthDistinct(String[] arr, int k){
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for(String s : arr){
            if(set.contains(s)){
                set2.add(s);
            }
            set.add(s);
        }
        for(String s : arr){
            if(!set2.contains(s)) {
                if(k > 0){
                    k--;
                    if(k == 0){
                        return s;
                    }
                }
            }
        }
        return "";
    }
    //12.8
    //leetcode No.2094 pass 想的有点多 后面直接写了个函数暴力写三位数 实际上不必要 每一位减完后面加回去即可
    public static int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for(int i : digits){
            count[i]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i <= 9;i++){
            if(count[i] > 0){
                count[i]--;
                for(int j = 0 ; j < 10;j ++){
                    if(count[j] > 0){
                        count[j]--;
                        for(int k = 0;k < 10;k += 2){
                            if(count[k] > 0){
                                list.add(i * 100 + j * 10 + k);
                            }
                        }
                        count[j]++;
                    }
                }
                count[i]++;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
