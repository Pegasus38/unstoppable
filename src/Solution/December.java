package Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

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
    //12.11
    //leetcode No.1827 每日一题 pass 总感觉有坑 但是过了
    public static int minOperations(int[] nums){
        int res = 0;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] <= nums[i-1]){
                res += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }
        return res;
    }
    //leetcode No.873 不会做且不想做 其实很简单 数组长度不长 一路查就行了
    public static int lenLongestFibSubseq(int[] arr){
        int res = 2;
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        for(int i = 0;i < arr.length;i++){
            for(int j = i + 1;j < arr.length;j++){
                int a = arr[i];
                int b = arr[j];
                int sum = a + b;
                int now = 2;
                while(set.contains(sum)){
                    a = b;
                    b = sum;
                    sum = a + b;
                    now++;
                }
                res = Math.max(res,now);
            }
        }
        return res < 3 ? 0 : res;
    }
    //12.12
    //leetcode No.1646 pass 搞不懂为什么简单题 提交通过率才60%+
    public static int getMaximumGenerated(int n){
        int[] temp = new int[100+1];
        int res = 1;
        temp[0] = 0;temp[1] = 1;
        if(n == 0 || n == 1){
            return n;
        }
        for(int i = 2;i <= n;i++){
            if(i % 2 == 0){
                temp[i] = temp[i / 2];
            }
            else {
                temp[i] = temp[i/2] + temp[(i+1)/2];
            }
            res = Math.max(res,temp[i]);
        }
        return res;
    }
    //12.13 每日一题
    //leetcode No.1832 一眼简单题 pass
    public static boolean checkIfPangram(String sentence){
        HashSet<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray()){
            set.add(c);
        }
        return set.size() == 26;
    }
    //12.15 每日一题
    //leetcode No.1945 一眼简单题 pass
    public static int getLucky(String s, int k){
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            sb.append(c - 'a'+1);
        }
        while(k > 0){
            int temp = 0;
            for(char c :sb.toString().toCharArray()){
                temp += c -'0';
            }
            sb = new StringBuilder(temp + "");
            k--;
        }
        return Integer.parseInt(sb.toString());
    }
    //12.18 很久没写 最近有点暴躁 在家只想cv 遇到困难就cv 不想动
    //leetcode No.389 简单题 pass
    public static char findTheDifference(String s, String t){
        int[] count = new int[26];
        for(char c : t.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : s.toCharArray()){
            count[c - 'a']--;
        }
        for(int i = 0;i < count.length;i++){
            if(count[i] > 0){
                return (char) (i + 'a');
            }
        }
        return ' ';
    }
    //leetcode No.1736 中等题 pass 两层暴力即可 虽然也想用复杂度为n的写法 但是不想思考了
    public static int tupleSameProduct(int[] nums){
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1 ; j < nums.length;j++){
                if(map.containsKey(nums[i] * nums[j])){
                    res += map.get(nums[i] * nums[j]) * 8;
                }
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        return res;
    }
    //leetcode No.781 pass 脑筋急转弯题目
    public static int numRabbits(int[] answers){
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : answers){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i : map.keySet()){
            int tag = i + 1;
            int time = map.get(i) / tag;
            if(map.get(i) % tag > 0){
                time++;
            }
            res += time * tag;
        }
        return res;
    }
    //12.21
    //leetcode No.1753 每日一题 和以前做过的一道简单题很像 pass
    public static int maximumScore(int a, int b, int c){
        int[] count = new int[3];
        count[0] = a;count[1] = b;count[2] = c;
        Arrays.sort(count);
        if(count[0] + count[1] <= count[2]){
            return count[0] + count[1];
        }
        return (count[0]+count[1]+count[2]) / 2;
    }
    //12.23 羊了 但是很精神 大半夜不睡觉
    //leetcode No.2011 每日一题 简单题 pass
    public static int finalValueAfterOperations(String[] operations){
        int res = 0;
        for(String s : operations){
            if(s.equals("++x") || s.equals("x++")){
                res++;
            }
            else {
                res--;
            }
        }
        return res;
    }
    //12.24 羊了的第二天还是第三天 感觉好了一丢丢
    //leetcode No.1754 每日一题 不写了
    public static String largestMerge(String word1, String word2){
        StringBuilder res = new StringBuilder();
        int idx1 = 0,idx2 = 0;
        while(idx1 < word1.length() || idx2 < word2.length()){
            if(idx1 < word1.length() && word1.substring(idx1).compareTo(word2.substring(idx2)) > 0){
                res.append(word1.charAt(idx1));
                idx1++;
            }
            else {
                res.append(word2.charAt(idx2));
                idx2++;
            }
        }
        return res.toString();
    }
    //12.26 居家办公 一点不想动
    //leetcode No.1759 每日一题 pass
    public static int countHomogenous(String s){
        long len = 1,res = 0;
        int mod = 1000000007;
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                len++;
            }
            else {
                res += (1 + len) * len / 2;
                res %= mod;
                len = 1;
            }
        }
        res += (1 + len) * len / 2;
        res %= mod;
        return (int)res;
    }

    //12.27
    //leetcode No.2027 每日一题 pass
    public static int minimumMoves(String s){
        int res = 0;
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) == 'O'){
                index++;
            }
            else {
                index+=3;
                res++;
            }
        }
        return res;
    }
}
