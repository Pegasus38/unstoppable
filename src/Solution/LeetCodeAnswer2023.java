package Solution;

import java.util.*;

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
    //2.27
    //leetcode No.575 差点理解错题意
    public static int distributeCandies(int[] candyType){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : candyType){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return Math.min(map.keySet().size(), candyType.length / 2);
    }
    //3.1 每日一题
    //leetcode No.2373 牛马写法 虽然我很想用什么滑动窗口 但是写不出
    public static int[][] largestLocal(int[][] grid){
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        for(int i = 1;i < n - 1;i ++){
            for(int j = 1;j < n - 1;j++){
                int center = grid[i][j];
                center = Math.max(center,grid[i-1][j]);
                center = Math.max(center,grid[i-1][j-1]);
                center = Math.max(center,grid[i-1][j+1]);
                center = Math.max(center,grid[i][j-1]);
                center = Math.max(center,grid[i][j+1]);
                center = Math.max(center,grid[i+1][j-1]);
                center = Math.max(center,grid[i+1][j]);
                center = Math.max(center,grid[i+1][j+1]);
                res[i-1][j-1] = center;
            }
        }
        return res;
    }
    //3.5 这两天的每日一题 一天是hard一天是牛马阅读理解题 做都不想做
    //leetcode No.290
    public static boolean wordPattern(String pattern, String s) {
        String[] temp = s.split(" ");
        //map存字符和下标
        HashMap<Character,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i),new ArrayList<>());
            }
            map.get(pattern.charAt(i)).add(i);
        }
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, temp);
        if(set.size() != map.keySet().size()){
            return false;
        }
        //先统计一波单词长度
        int sum = 0;
        for(char c : map.keySet()){
            sum += map.get(c).size();
        }
        if(sum != temp.length){
            return false;
        }
        for(char c : map.keySet()){
            List<Integer> index = map.get(c);
            int first_index = index.get(0);
            String t = temp[first_index];
            for(int i = 1;i < index.size();i++){
                int target_index = index.get(i);
                if(!temp[target_index].equals(t)){
                    return false;
                }
            }
        }
        return true;
    }
    //3.11 今天去洗了牙 很几把难受
    //leetcode 面试题 17.05 其实这个题和No.525 连续数组是一个思路 所以照搬就可以了
    public static String[] findLongestSubArray(String[] array){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0,max = 0,start = 0;
        for(int i = 0;i < array.length;i++){
            char c = array[i].charAt(0);
            sum += Character.isDigit(c) ? 1 : -1;
            if(map.containsKey(sum)){
                int j = map.get(sum);
                //max = Math.max(max,i-j);
                if(i-j > max){
                    max = i-j;
                    start = j+1;
                }
            }
            else {
                map.put(sum,i);
            }
        }
        String[] res = new String[max];
        for(int i = 0;i < res.length;i++){
            res[i] = array[start];
            start++;
        }
        return res;
    }
    //3.12 写完睡觉
    //leetcode No.884 pass
    public static String[] uncommonFromSentences(String s1, String s2){
        String[] t1 = s1.split(" ");
        String[] t2 = s2.split(" ");
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        for(String t : t1){
            map1.put(t,map1.getOrDefault(t,0)+1);
        }
        for(String t : t2){
            map2.put(t,map2.getOrDefault(t,0)+1);
        }
        List<String> res = new ArrayList<>();
        for(String t:map1.keySet()){
            if(map1.get(t) == 1 && !map2.containsKey(t)){
                res.add(t);
            }
        }
        for(String t:map2.keySet()){
            if(map2.get(t) == 1 && !map1.containsKey(t)){
                res.add(t);
            }
        }
        return res.toArray(new String[0]);
    }
    //3.27 真好久没写 主要是这两周的周末题不是hard就是做过的
    //leetcode No.551
    public static boolean checkRecord(String s){
        int count = 0;
        for(char c: s.toCharArray()){
            if(c == 'A'){
                count++;
            }
        }
        return count < 2 && !s.contains("LLL");
    }
    //3.29 11点回到家 写个题去洗澡
    //leetcode No.1641 每日一题 pass
    public static int countVowelStrings(int n){
        if(n == 1){
            return 5;
        }
        int a = 1,b = 1,c = 1,d = 1,e = 1;
        for(int i = 1;i < n;i++){
            int t2 = a + b;
            int t3 = t2 + c;
            int t4 = t3 + d;
            int t5 = t4 + e;
            b = t2;c = t3;d = t4;e = t5;
        }
        return a+b+c+d+e;
    }
    //再来写一下学习project里的题 上来就是梦开始的地方
    //leetcode No.1 两数之和
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
    //然后是一道我当时提交错了五遍的题目 纯牛马 把数导进去之后还排序 虽然我昨天之前也是这样写的
    //leetcode No.88 合并两个有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int len = m + n - 1;
        m--;n--;
        while(m >= 0 && n >= 0){
            nums1[len--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while(n >= 0){
            nums1[len--] = nums2[n--];
        }
    }
    //3.30 今天的每日一题稍微有点长 先不做了
    //leetcode No.350 两个数组交集
    public static int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i : nums2){
            if(map.getOrDefault(i,0)>0){
                list.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
    //leetcode No.121 经典中的经典之dp题 我已经把答案背下来了 毕竟我提交WA了四次
    public static int maxProfit(int[] prices){
        int min = prices[0];
        int max = 0;
        for(int i = 1;i < prices.length;i++){
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
    //3.31 下了一星期的雨
    //leetcode No.2367 每日一题 不想动脑 我要暴力 pass
    public static int arithmeticTriplets(int[] nums, int diff){
        int res = 0;
        for(int i = 0;i < nums.length - 2;i++){
            for(int j = i + 1;j < nums.length - 1;j++){
                if(nums[j] - nums[i] == diff){
                    for(int k = j + 1;k < nums.length;k++){
                        if(nums[k] - nums[j] == diff){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
    //4.1 停雨了
    //leetcode No.831 每日一题 pass
    public static String maskPII(String s){
        StringBuilder sb = new StringBuilder();
        if(s.contains("@")){
            String[] t = s.split("@");
            String part1 = t[0];
            String part2 = t[1];
            char c1 = Character.toLowerCase(part1.charAt(0));
            char c2 = Character.toLowerCase(part1.charAt(part1.length()-1));
            part1 = c1 + "*****" + c2;
            sb.append(part1);
            sb.append("@");
            for(char c : part2.toCharArray()){
                if(Character.isUpperCase(c)){
                    sb.append(Character.toLowerCase(c));
                }
                else {
                    sb.append(c);
                }
            }
        }
        else {
            for(char c : s.toCharArray()){
                if(Character.isDigit(c)){
                    sb.append(c);
                }
            }
            String t = sb.toString();
            String num = t.substring(t.length()-4);
            sb = new StringBuilder();
            if(t.length() == 10){
                sb.append("***-***-");
                sb.append(num);
            }
            else if(t.length() == 11){
                sb.append("+*-***-***-");
                sb.append(num);
            }
            else if(t.length() == 12){
                sb.append("+**-***-***-");
                sb.append(num);
            }
            else {
                sb.append("+***-***-***-");
                sb.append(num);
            }
        }
        return sb.toString();
    }
    //No.73 做过一次 再来一次 结果还是错了 看到忘了第二次扫是从1,1开始才对，不能从0,0赋值
    public static void setZeroes(int[][] matrix){
        boolean column = false,row = false;
        int m = matrix.length,n = matrix[0].length;
        for(int i = 0;i < n;i++){
            if(matrix[0][i] == 0){
                row = true;
                break;
            }
        }
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                column = true;
                break;
            }
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i < m;i++){
            if(matrix[i][0] == 0){
                for(int j = 0;j < n;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1;i < n;i++){
            if(matrix[0][i] == 0){
                for(int j = 0;j < m;j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(column){
            for(int i = 0;i < m;i++){
                matrix[i][0] = 0;
            }
        }
        if(row){
            for(int i = 0;i < n;i++){
                matrix[0][i] = 0;
            }
        }
    }
    //leetcode No.36 pass
    public static boolean isValidSudoku(char[][] board){
        //扫每一列
        for(int i = 0;i < 9;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0;j < 9;j++){
                if(Character.isDigit(board[i][j])){
                    if(set.contains(board[i][j]-'0')){
                        return false;
                    }
                    else {
                        set.add(board[i][j]-'0');
                    }
                }
            }
        }
        //扫每一行
        for(int i = 0;i < 9;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0;j < 9;j++){
                if(Character.isDigit(board[j][i])){
                    if(set.contains(board[j][i]-'0')){
                        return false;
                    }
                    else {
                        set.add(board[j][i]-'0');
                    }
                }
            }
        }
        //牛马的四层循环扫九宫格法
        for(int i = 0;i < 9;i+=3){
            for(int j = 0;j < 9;j += 3){
                HashSet<Integer> set = new HashSet<>();
                for(int a = 0;a < 3;a++){
                    for(int b = 0;b < 3;b++){
                        if(Character.isDigit(board[i+a][j+b])){
                            if(set.contains(board[i+a][j+b]-'0')){
                                return false;
                            }
                            else {
                                set.add(board[i+a][j+b]-'0');
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    //4.2 今天的dp题不想写 做点简单弱智题
    //leetcode No.387
    public static int firstUniqueChar(String s){
        int[] index = new int[26];
        Arrays.fill(index,-2);
        for(int i = 0;i < s.length();i++){
            int now = s.charAt(i) - 'a';
            //如果他等于-2 说明是首次出现 可以赋值
            if(index[now] == -2){
                index[now] = i;
            }
            //如果他大于等于0 说明已经赋值过了 如果这时候再出现 就给他变成-1
            else if(index[now] >= 0){
                index[now] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : index){
            if(i >= 0){
                min = Math.min(min,i);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    //leetcode No.383
    public static boolean canConstruct(String ransomNote, String magazine){
        int[] count = new int[26];
        for(char c : magazine.toCharArray()){
            count[c-'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            count[c-'a']--;
        }
        for(int i : count){
            if(i < 0){
                return false;
            }
        }
        return true;
    }
    //leetcode No.242
    public static boolean isAnagram(String s, String t){
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }
        for(char c:t.toCharArray()){
            count[c-'a']--;
        }
        for(int i : count){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
    //4.5 放假一天
    //leetcode No.2427 每日一题 pass
    public static int commonFactors(int a, int b){
        if(a < b){
            return commonFactors(b,a);
        }
        int res = 0,n = b;
        while(n > 0){
            if(a % n == 0 && b % n == 0){
                res++;
            }
            n--;
        }
        return res;
    }
    //leetcode No.20 回归经典 当时提交错四次的题目 还是easy 差点写反了
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if((c == '(') || (c == '[') || (c == '{')){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    if(c == ')'){
                        if(stack.peek() == '('){
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else if(c == ']'){
                        if(stack.peek() == '['){
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else{
                        if(stack.peek() == '{'){
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    //4.9 做完睡觉
    //leetcode No.2399 用会之前的老办法吧
    public static boolean checkDistances(String s, int[] distance){
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
        for(char c : map.keySet()){
            int start = map.get(c).get(0);
            int end = map.get(c).get(1);
            if(distance[(int)c - 97] != end - start - 1){
                return false;
            }
        }
        return true;
    }
    //4.21 最近没什么时间刷题 每日一题都是cv比较多 简单的做过 中等的不会 难的直接copy 心态越来越不好
    //leetcode No.2413 弱智题
    public static int smallestEvenMultiple(int n){
        return n % 2 == 0 ? n : 2 * n;
    }
    //4.29 我在想为什么这道简单题的通过率不到20%
    //leetcode No.2423 pass 但是我竟然发现我之前做过这道题 虽然他妈用了不同的方法 但是时间和内存竟然是一模一样的 说明我好像一点进步没有 纯牛马
    public static boolean equalFrequency(String word){
        int[] count = new int[26];
        for(int i = 0;i < word.length();i++){
            String s = word.substring(0,i) + word.substring(i+1);
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            Arrays.sort(count);
            int num = count[25];
            boolean tag = true;
            for(int j = 24;j >= 0;j--){
                if(count[j] != 0){
                    if(count[j] != num){
                        tag = false;
                        break;
                    }
                }
            }
            if(tag){
                return true;
            }
            count = new int[26];
        }
        return false;
    }
    //5.1 讲出来可能不信 我竟然在51这天跟工作跟到凌晨三点
    //面试题17.10 我受不了了 我要直接用map 什么叫摩尔投票法啊 没有map没有sort做个鸡毛啊
    public static int majorityElement(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i : map.keySet()){
            if(map.get(i) > nums.length / 2){
                return i;
            }
        }
        return -1;
    }
    //5.3 每日一题
    //leetcode No.1003 pass
    public static boolean isValid2(String s){
        //长度不是3的倍数 直接false
        if(s.length() % 3 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c != 'c'){
                stack.push(c);
            }
            else {
                //遇到c的时候 如果栈为空或者长度<2 说明没东西弹 说明是false
                if(stack.isEmpty() || stack.size() < 2){
                    return false;
                }
                else {
                    int first = stack.pop();
                    int second = stack.peek();
                    if (first == 'b' && second == 'a') {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    //5.7
    //leetcode No.1010 pass
    public static int numPairsDivisibleBy60(int[] time){
        int res = 0;
        int[] count = new int[60];
        for(int i : time){
            int mod = i % 60;
            res += mod == 0 ? count[0] : count[60-mod];
            count[mod]++;
        }
        return res;
    }
    //5.13
    //leetcode No.2441 pass
    public static int findMaxK(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        int max = -1;
        for(int i : nums){
            int target = -i;
            if(set.contains(target)){
                max = Math.max(max,Math.abs(i));
            }
            set.add(i);
        }
        return max;
    }
    //5.14
    //leetcode No.1054 pass
    public static int[] rearrangeBarcodes(int[] barcodes){
        if(barcodes.length == 1){
            return barcodes;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : barcodes){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] res = new int[barcodes.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o2[0]-o1[0]));
        for(int i : map.keySet()){
            queue.offer(new int[]{map.get(i),i});//优先队列存放格式：[次数,元素]
        }
        if(!queue.isEmpty()) {
            int[] first_pop = queue.poll();//先弹一个出来
            res[0] = first_pop[1];
            first_pop[0]--;
            if (first_pop[0] != 0) {
                queue.offer(first_pop);//如果没有的话就不用插回去，如果有的话就继续插回去
            }
        }
        for(int i = 1;i < res.length;i++){
            int cur = res[i-1];
            int[] top = queue.poll();//顶弹出来
            //如果顶的值和上一次不等，就把顶的值放入当前，然后次数-1，如果次数-1之后不等于0，就再放回去；如果等于0了就取出了不管了
            assert top != null;
            if(cur != top[1]){
                res[i] = top[1];
                top[0]--;
                if(top[0] != 0){
                    queue.offer(top);
                }
            }
            else {
                int[] new_top = queue.poll();
                assert new_top != null;
                res[i] = new_top[1];
                new_top[0]--;
                if(new_top[0] != 0){
                    queue.offer(new_top);
                }
                queue.offer(top);
            }
        }
        return res;
    }
    //5.17
    //leetcode No.2446
    public static boolean haveConflict(String[] event1, String[] event2){
        //转成整数 分别是event1 = [time1,time2],event2 = [time3,time4] 统一假设 time1 <= time3
        int time1 = Integer.parseInt(event1[0].substring(0,2)) * 60 + Integer.parseInt(event1[0].substring(3));
        int time2 = Integer.parseInt(event1[1].substring(0,2)) * 60 + Integer.parseInt(event1[1].substring(3));
        int time3 = Integer.parseInt(event2[0].substring(0,2)) * 60 + Integer.parseInt(event2[0].substring(3));
        if(time1 > time3){
            return haveConflict(event2,event1);
        }
        //存在交集就true 不存在交集就false
        return !(time2 < time3 && time1 < time3);
    }
    //5.20 这天通宵了 很热 睡不着 越来越精神 起来玩了会舟舟 写了一道题
    //leetcode No.674
    public static int findLengthOfLCIS(int[] nums){
        int res = 1,len = 1;
        int last = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] > last){
                len++;
            }
            else {
                len = 1;
            }
            last = nums[i];
            res = Math.max(res,len);
        }
        return res;
    }
    //5.29
    //leetcode No.2455 忘了list=0，错了一遍
    public static int averageValue(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i : nums){
            if(i % 3 == 0 && i % 2 == 0){
                list.add(i);
                sum += i;
            }
        }
        int n = list.size();
        return n == 0 ? 0 : sum / n;
    }
    //6.5
    //leetcode No.2460 简单模拟 pass
    public static int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int index = 0;
        for(int i : nums){
            if(i > 0){
                res[index] = i;
                index++;
            }
        }
        return res;
    }
    //6.6
    //leetcode No.2352 做过了
    public static int equalPairs(int[][] grid) {
        int res = 0,n = grid.length;
        HashMap<List<Integer>,Integer> map = new HashMap<>();
        for(int[] i : grid){
            List<Integer> list = new ArrayList<>();
            for(int j : i){
                list.add(j);
            }
            map.put(new ArrayList<>(list),map.getOrDefault(new ArrayList<>(list),0)+1);
        }
        for(int i = 0;i < n;i++){
            List<Integer> list = new ArrayList<>();
            for (int[] ints : grid) {
                list.add(ints[i]);
            }
            if(map.containsKey(new ArrayList<>(list))){
                res += map.get(new ArrayList<>(list));
            }
        }
        return res;
    }
    //6.23
    //leetcode No.2496
    public static int maximumValue(String[] strs){
        int res = 0;
        for(String str : strs){
            boolean isDigit = true;
            for(char c : str.toCharArray()){
                if(!Character.isDigit(c)){
                    isDigit = false;
                    break;
                }
            }
            if(!isDigit){
                res = Math.max(res,str.length());
            }
            else {
                res = Math.max(res,Integer.parseInt(str));
            }
        }
        return res;
    }
    //6.25
    //leetcode No.1401
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        //描点
        int[][] points = new int[4][2];
        points[0][0] = x1;points[0][1] = y1;//左下
        points[1][0] = x1;points[1][1] = y2;//左上
        points[2][0] = x2;points[2][1] = y2;//右上
        points[3][0] = x2;points[3][1] = y1;//右下
        //找距离
        int min_distance = Integer.MAX_VALUE;
        //如果圆心在矩形里面，那么无论半径多少，圆肯定在矩形里面，肯定重叠
        if((yCenter>=y1 && yCenter <=y2) && (xCenter>=x1 && xCenter<=x2)){
            return true;
        }
        //找左右，如果点在y1和y2中间 那么最短的就是他到x1或x2的垂直距离
        if(yCenter>=y1 && yCenter <=y2){
            min_distance = Math.min(Math.abs(x2-xCenter)*Math.abs(x2-xCenter),Math.abs(x1-xCenter)*Math.abs(x1-xCenter));
        }
        if(xCenter>=x1 && xCenter<=x2){
            min_distance = Math.min(Math.abs(y2-yCenter)*Math.abs(y2-yCenter),Math.abs(y1-yCenter)*Math.abs(y1-yCenter));
        }
        //四个点的距离
        for(int[] i : points){
            min_distance = Math.min(min_distance,(i[0]-xCenter)*(i[0]-xCenter)+(i[1]-yCenter)*(i[1]-yCenter));
        }
        //如果l<=r，说明有重复部分，如果l>r，说明没有重复
        return min_distance <= radius * radius;
    }
    //7.4 每日一题
    //leetcode No.2679
    public int matrixSum(int[][] nums) {
        int res = 0,m = nums.length,n = nums[0].length;
        for(int i = 0;i < m;i++){
            int[] temp = nums[i];
            Arrays.sort(temp);
            nums[i] = temp;
        }
        for(int i = n -1 ;i >= 0;i--){
            int max = 0;
            for (int[] num : nums) {
                max = Math.max(max, num[i]);
            }
            res += max;
        }
        return res;
    }
    //7.5 每日一题
    //leetcode No.2600
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int ignoredNumNegOnes, int k) {
        //k有可能在以下几种情况：1.k在0,one之间；2.k在one-zero之间，3.k在zero-1之间
        if(k == 0){
            return 0;
        }
        if(k > 0 && k <= numOnes){
            return k;
        }
        else if(k > numOnes && k <= numOnes+numZeros){
            return numOnes;
        }
        int count = k - (numOnes+numZeros);
        return numOnes - count;
    }
    //7.12 每日一题
    //leetcode No.2544
    public static int alternateDigitSum(int n) {
        int res = 0;
        boolean target = true;
        for(char c : String.valueOf(n).toCharArray()){
            if(target){
                res += c - '0';
            }
            else {
                res -= c - '0';
            }
            target = !target;
        }
        return res;
    }
}
