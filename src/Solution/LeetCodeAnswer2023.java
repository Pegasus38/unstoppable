package Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LeetCodeAnswer2023 {
    //今年所有的刷题记录都整合在这里吧 2023加油
    public static void main(String[] args) {
    }
    //1.7
    //leetcode No.1658 错了两次 第一次没有判断整个和刚好等于x的情况 第二次好像是把sum改成了long 反而不过 真几把服了
    public static int minOperations(int[] nums, int x){
        int res = -1;
        int allSum = Arrays.stream(nums).sum();
        int sum = 0,target = allSum - x;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - target)){
                res = Math.max(res,i - map.get(sum-target));
            }
            map.put(sum,i);
        }
        if(map.containsKey(x)){
            res = Math.max(res,nums.length-1-map.get(x));
        }
        return res == -1 ? -1 : nums.length - res;
    }
    //1.8
    //leetcode No.2442 pass
    public static int countDistinctIntegers(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            int temp = Integer.parseInt(sb.reverse().toString());
            set.add(temp);
        }
        return set.size();
    }
    //补充一下 1月8号这天通宵了 凌晨五点 先写道题精神精神
    //leetcode No.1920 纯送分题 pass
    public static int[] buildArray(int[] nums){
        int[] res = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            res[i] = nums[nums[i]];
        }
        return res;
    }
    //leetcode No.318 不会位运算 试试暴力能不能ac先 pass了 虽然有点小笨 但是还是有效的
    public static int maxProduct(String[] words){
        int res = 0;
        List<int[]> list = new ArrayList<>();
        for(String s : words){
            int[] temp = new int[26];
            for(char c :s.toCharArray()){
                temp[c - 'a']++;
            }
            list.add(temp);
        }
        for(int i = 0;i < list.size() - 1;i++){
            for(int j = i + 1;j < list.size();j++){
                if(!haveSameElement(list.get(i),list.get(j))){
                    res = Math.max(res,words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
    private static boolean haveSameElement(int[] a,int[] b){
            for(int i = 0;i < 26;i++){
                if(a[i] > 0 && b[i] > 0){
                    return true;
                }
            }
            return false;
    }
    //1.15 这星期好像没有在自己电脑上提交过东西 星期六是hard没办法
    //leetcode No.2293 pass
    public static int minMaxGame(int[] nums){
        while(nums.length > 1){
            int[] t = new int[nums.length / 2];
            for(int i = 0;i < t.length;i+=2){
                t[i] = Math.min(nums[2 * i],nums[2 * i+1]);
            }
            for(int i = 1;i < t.length;i += 2){
                t[i] = Math.max(nums[2 * i],nums[2 * i+1]);
            }
            nums = t;
        }
        return nums[0];
    }
    //1.19 准备收拾东西回家
    //leetcode NO.2299 每日一题 我服了 符号错了 真几把服了
    public static boolean strongPasswordCheckerII(String password){
        boolean tag_lower = false;
        boolean tag_upper = false;
        boolean tag_num = false;
        boolean tag_special = false;
        boolean tag_noSame = true;
        String s = "!@#$%^&*()_+";
        if(password.length() < 8){
            return false;
        }
        for(int i = 0;i < password.length() - 1;i++){
            char c = password.charAt(i);
            if(Character.isDigit(c)){
                tag_num = true;
            }
            if(Character.isUpperCase(c)){
                tag_upper = true;
            }
            if(Character.isLowerCase(c)){
                tag_lower = true;
            }
            if(s.indexOf(c) >= 0){
                tag_special = true;
            }
            if(c == password.charAt(i+1)){
                tag_noSame = false;
            }
        }
        char last = password.charAt(password.length()-1);
        if(Character.isDigit(last)){
            tag_num = true;
        }
        if(Character.isUpperCase(last)){
            tag_upper = true;
        }
        if(Character.isLowerCase(last)){
            tag_lower = true;
        }
        if(s.indexOf(last) >= 0){
            tag_special = true;
        }
        return tag_noSame && tag_lower && tag_upper && tag_special && tag_num;
    }
    //1.31 回来之后还没写过 牙痛了好几天
    //leetcode No.2319 每日一题 pass
    public static boolean checkXMatrix(int[][] grid){
        int length = grid.length;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid.length;j++){
                if(j == i){
                    if(grid[i][j] == 0){
                        return false;
                    }
                }
                else if(j == length - i - 1){
                    if(grid[i][j] == 0){
                        return false;
                    }
                }
                else {
                    if(grid[i][j] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //2.16 应该有半个月没在自己电脑上写过东西了
    //leetcode No.2341 每日一题 pass
    public static int[] numberOfPairs(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count = 0,time = 0;
        for(int i : map.keySet()){
            count += map.get(i) / 2;
            time += map.get(i) % 2;
        }
        return new int[]{count,time};
    }
    //2.19 最近发现做题有点浮躁了 只想挑一眼简单的做 遇到难题就装死
    //leetcode No.2490 这都能WA一次 服了
    public static boolean isCircularSentence(String sentence){
        String[] t = sentence.split(" ");
        if(t.length == 1){
            return t[0].charAt(0) == t[0].charAt(t[0].length()-1);
        }
        for(int i = 1;i < t.length;i++){
            String a = t[i-1];
            String b = t[i];
            if(a.charAt(a.length()-1) != b.charAt(0)){
                return false;
            }
        }
        return t[0].charAt(0) == t[t.length - 1].charAt(t[t.length - 1].length() - 1);
    }
    //leetcode No.1222 pass 其实很简单 复杂度是8 * 8 * n
    public static List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king){
        List<List<Integer>> res = new ArrayList<>();
        int[][] direction = {{-1,1},{0,1},{1,1},{-1,0},{1,0},{-1,-1},{0,-1},{1,-1}};
        for(int[] i : direction){
            int x = king[0],y = king[1];
            boolean tag = false;
            while(x >= 0 && x < 8 && y >= 0 && y < 8){
                int new_x = x + i[0];
                int new_y = y + i[1];
                for(int[] j : queens){
                    if(j[0] == new_x && j[1] == new_y){
                        res.add(Arrays.asList(j[0],j[1]));
                        tag = true;
                        break;
                    }
                }
                if(tag){
                    break;
                }
                x = new_x;
                y = new_y;
            }
        }
        return res;
    }
    //2.20 尝试一下五分钟内搞定 每日一题 简单题 pass 下机
    //leetcode No.2347
    public static String bestHand(int[] ranks, char[] suits){
        //如果有同花的 就返回这个
        if(suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4]){
            return "Flush";
        }
        int[] poker = new int[13];
        for(int i : ranks){
            poker[i-1]++;
        }
        int max = 0;
        for(int i : poker) {
            max = Math.max(max,i);
        }
        //从高到低 从3 到2 什么都没就返回最后一个
        if(max >= 3){
            return "Three of a Kind";
        }
        else if(max == 2){
            return "Pair";
        }
        return "High Card";
    }
    //2.21 继续挑战五分钟一道题 pass 用时十分钟
    //leetcode No.482
    public static String licenseKeyFormatting(String s, int k){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != '-'){
                sb.append(c);
            }
        }
        sb.reverse();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < sb.length();i++){
            res.append(sb.charAt(i));
            if((i+1) % k == 0 && (i+1) != sb.length()){
                res.append("-");
            }
        }
        return res.reverse().toString().toUpperCase();
    }
    //leetcode No.2570 pass 但是我后面想到他是递增的 应该会简单点
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] i : nums1){
            map.put(i[0],i[1]);
        }
        for(int[] i : nums2){
            int key = i[0];
            int value = i[1];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+value);
            }
            else {
                map.put(key,value);
            }
        }
        int[][] res = new int[map.keySet().size()][2];
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(int i = 0;i < res.length;i++){
            res[i][0] = list.get(i);
            res[i][1] = map.get(list.get(i));
        }
        return res;
    }
    //2.25 每日一题
    //leetcode No.1247 错了一遍 被这个傻逼提示坑了
    public static int minimumSwap(String s1, String s2){
        int res = 0;
        //第一遍 先过滤掉不同的位置的 相同的话就不检索
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                sb.append(s1.charAt(i));
            }
        }
        //如果sb不为空的话
        if(!sb.isEmpty()) {
            if(sb.length() % 2 != 0){
                return -1;
            }
            else {
                int x = 0,y = 0;
                for(char c :sb.toString().toCharArray()){
                    if(c == 'x'){
                        x++;
                    }
                    else {
                        y++;
                    }
                }
                if(x % 2 != 0 && y % 2 != 0){
                    res += 2;
                }
                res += x / 2;
                res += y / 2;
            }
        }
        return res;
    }
    //2.26 每日一题是hard 随便找一个顺眼的medium
    //leetcode No.1362 pass
    public static int[] closestDivisors(int num){
        int a = num + 1,b = num + 2;
        int sqrt_a = (int)Math.sqrt(a);
        int sqrt_b = (int)Math.sqrt(b);
        if(sqrt_a * sqrt_a == a){
            return new int[]{sqrt_a,sqrt_a};
        }
        if(sqrt_b * sqrt_b == b){
            return new int[]{sqrt_b,sqrt_b};
        }
        while(a % sqrt_a != 0){
            sqrt_a--;
        }
        while(b % sqrt_b != 0){
            sqrt_b--;
        }
        int min_a = a / sqrt_a - sqrt_a;
        int min_b = b / sqrt_b - sqrt_b;
        return min_a <= min_b ? new int[]{a/sqrt_a,sqrt_a} : new int[]{b/sqrt_b,sqrt_b};
    }
}
