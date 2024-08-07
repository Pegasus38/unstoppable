package Solution;

import java.util.*;

public class LeetCodeAnswer {
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
    //7.24 终于遇到一道简单的题
    //leetcode No.771
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        for(char c : stones.toCharArray()){
            if(jewels.indexOf(c) >= 0){
                res++;
            }
        }
        return res;
    }
    //7.28 写一道不是很简单的简单题 约瑟夫环 之前不会做 再看一遍也不会做
    //剑指offer 62
    public int lastRemaining(int n, int m){
        /*
        这是一道有点抽象的题 我需要结合例子 来说明一下这个题为什么这么做
        以n=5 m=3为例
        最后一圈的最后一个数字 他的下标肯定是0
        倒数第二圈的这个数字的坐标 等于(0+m) % 2 = 1
        倒数第三圈的这个数字的坐标 等于(1+m) % 3 = 1
        倒数第四圈的这个数字的坐标 等于(1+m) % 4 = 0
        那么倒数第五圈的这个数字的坐标 也就是第一圈的坐标 等于(0+m) % 5 = 3
        结论就是 下一圈的index = （上一圈的index + m ) % 圈数
         */
        int index = 0;
        for(int i = 1;i <= n;i++){
            index = (index + m) % i;//第一圈其实没有意义
        }
        return index;
    }
    //8.6
    //leetcode No.804 没什么难度 就转换然后丢进set里
    public static int uniqueMorseRepresentations(String[] words) {
        String[] s = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){
                sb.append(s[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
    //8.24 真很久没在自己电脑上学习了 太懒了 最近真的事业没有一点进展
    //leetcode No.1267 做个每日一题再睡吧
    public static int countServers(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[] count_x = new int[m];
        int[] count_y = new int[n];
        int res = 0;
        for(int i = 0;i < m;i++){
            int count = 0;
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
            count_x[i] = count;//统计 每一行 有多少个电脑\
            res += count_x[i];
        }
        for(int i = 0;i < n;i++){
            int count = 0;
            for (int[] ints : grid) {
                if (ints[i] == 1) {
                    count++;
                }
            }
            count_y[i] = count;
        }
        int pass = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1 && count_x[i] == 1 && count_y[j] == 1){
                    pass++;
                }
            }
        }
        return res - pass;
    }
    //8.26 有点失眠 起来做个题
    //leetcode No.228 每日一题 我竟然发现以前写的更几把精简 一个钟过去了还在用原来的方法
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            return new ArrayList<>();
        }
        int len = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                len++;
            }
            else {
                if(len == 1){
                    res.add(String.valueOf(nums[i-1]));
                }
                else  {
                    String s = (nums[i - 1] - len + 1) + "->" + nums[i - 1];
                    res.add(s);
                    len = 1;
                }
            }
        }
        if(len == 1){
            res.add(String.valueOf(nums[nums.length-1]));
        }
        else {
            String s = (nums[nums.length - 1] - len + 1) + "->" + nums[nums.length - 1];
            res.add(s);
        }
        return res;
    }
    //9.1 每日一题 这个题一看就知道是自己做的
    //leetcode No.2240
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        int min = Math.min(cost1,cost2),max = Math.max(cost1,cost2);
        int time = total / max;//最少能买time次笔
        for(int i = 0;i <= time;i++){
            int buy1 = i * max;
            int buy2 = (total - buy1) / min;
            res += buy2 + 1;
        }
        return res;
    }
    //9.3 每日一题 不能理解为什么不过 思路没问题 而且一开始用了while 效率也不高 有点迷惑 这个题绝对不倒 其实后面是取整有问题
    //leetcode No.1921
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int[] arrive = new int[dist.length];
        for(int i = 0;i < dist.length;i++){
            arrive[i] = (dist[i] - 1) / speed[i] + 1;//怪物到达时间 = 距离/速度 + 1
        }
        Arrays.sort(arrive);
        for(int i = 0;i < dist.length;i++){
            if(arrive[i] <= i){
                return i;
            }
        }
        return dist.length;
    }
    //9.5 每日一题
    //leetcode No.2605
    public static int minNumber(int[] nums1, int[] nums2) {
        //备注一下 这题还不是同一个意思 不是找最小值 先找有没有重复 有重复就返回单独重复的数字 没有就拉几把倒
        int[] count = new int[10];
        int min1 = 10,min2 = 10;
        for(int i : nums1){
            count[i]++;
            min1 = Math.min(min1,i);
        }
        for(int i : nums2){
            count[i]++;
            min2 = Math.min(min2,i);
        }
        for(int i = 0;i < count.length;i++){
            if(count[i] == 2){
                return i;
            }
        }
        return Math.min(min1,min2) * 10 + Math.max(min1,min2);
    }
    //9.16 经典DP题之打家劫舍
    //leetcode No.198
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i = 2;i < dp.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
    //9.17 今天变成打家劫舍2了
    //leetcode No.213
    public static int rob2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] n1 = new int[nums.length-1];
        int[] n2 = new int[nums.length-1];
        System.arraycopy(nums,0,n1,0,nums.length-1);
        System.arraycopy(nums,1,n2,0,nums.length-1);
        return Math.max(rob(n1),rob(n2));
    }
    //9.30 回家继续coding
    //leetcode No.2136 自己做出来的hard题
    public static int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] plant = new int[n][2];
        for(int i = 0;i < n;i++){
            plant[i][0] = plantTime[i];
            plant[i][1] = growTime[i];
        }
        Arrays.sort(plant,(o1,o2)->(o2[1] == o1[1] ? o2[0] - o1[0] : o2[1] - o1[1]));
        int res = 0,p_time = 0,min_g_time = Integer.MAX_VALUE;
        //排序完之后 长的最快的 就在最后面了
        for(int[] p : plant){
            p_time += p[0];//种植时间
            min_g_time = Math.min(min_g_time,p[1]);
            res = Math.max(p_time+min_g_time,res);
        }
        return res;
    }
    //10.2 股票2
    //leetcode No.122 简单弱智题
    public static int maxProfit2(int[] prices) {
        int res = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] >= prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
    //10.15 最近真的每日都只做一题了 有点懒了 没有激情了 字典也不写了
    //leetcode No.137 这个题不会做 写一下答案思路之 依次确定每一个二进制位
    /*
    思路：
    依次计算 res的 每一个二进制位 是0还是1
    考虑res的 第i个二进制位 它可能是0 或者 1
    对于 非res的元素 每一个元素 都出现3次 对应的 第i个二进制位 是3个0 或者 3个1  他们的和 都是3的倍数 即0或3
    所以有 res的第i个二进制位 是所有元素的 二进制位之和 除以3 的余数
    所以需要 对于数组每一个元素 用位运算 (x >> i) & 1 得到x的第i个二进制位
    然后相加 对3求余 得到0或1 也就是res的第i位
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0;i < 32;i++){
            int all = 0;
            for(int num :nums){
                all += ((num >> i) & 1);
            }
            if(all % 3 != 0){
                res |= (1 << i);
            }
        }
        return res;
    }
    //10.26 简单题 写完睡觉
    //leetcode No.2520
    public static int countDigits(int num) {
        int res = 0,temp = num;
        while(temp > 0){
            int t = temp % 10;
            if(num % t == 0){
                res++;
            }
            temp /= 10;
        }
        return res;
    }
    //10.29 每日一题 中等题 写完睡觉
    //leetcode No.274 莫名其妙过了 排个序 遍历就没了
    public static int hIndex(int[] citations){
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0;i < n;i++){
            int time = n - i;
            if(citations[i] >= time){
                return time;
            }
        }
        return 0;
    }
    //11.15 每日一题 好像已经半个月没有提交了
    //leetcode No.2656 这个题有点弱智
    public static int maximizeSum(int[] nums, int k) {
        int max = 0,res = 0;
        for(int i : nums){
            max = Math.max(i,max);
        }
        while(k > 0){
            res += max;
            max += 1;
            k--;
        }
        return res;
    }
    //11.22 今天不太服气 一定要做出来
    //leetcode No.2304
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length,n = grid[0].length;
        int[][] dp = new int[m][n];
        System.arraycopy(grid[0], 0, dp[0], 0, n);//复制第一行
        for(int i = 1;i < m;i++){
            for(int j = 0;j < n;j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0;k < n;k++){
                    int last = grid[i-1][k];//定位一个last 便于丢进m里面
                    min = Math.min(min,dp[i-1][k] + moveCost[last][j] + grid[i][j]);//这一步记得 要加上g[i][j] 不然容易算错
                }
                dp[i][j] = min;//dp[i][j] = 上一行传过来的min
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            res = Math.min(res,dp[m-1][i]);//找到最后一行的Min
        }
        return res;
    }
    //12.20 最近发现写东西好像没什么意义了 每日一题不会的copy 会的又是做过的 只能写一下这种简单弱智题
    //leetcode No.2828
    public static boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word.charAt(0));
        }
        return sb.toString().equals(s);
    }
    //12.23 冷死了 写完速度碎觉
    //leetcode No.1962 一眼优先队列解决
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->(o2-o1));
        for(int i : piles){
            queue.offer(i);
        }
        while(k > 0 && !queue.isEmpty()){
            double temp = queue.poll() / 2.0;
            queue.offer((int)(Math.ceil(temp)));
            k--;
        }
        int res = 0;
        while(!queue.isEmpty()){
            res += queue.poll();
        }
        return res;
    }
    //12.29
    //leetcode No.2706
    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return money - prices[0] - prices[1] >= 0 ? money - prices[0] - prices[1] : money;
    }
    //24.1.10
    //leetcode No.2696 简单题
    public static int minLength(String s) {
        while(s.contains("AB") || s.contains("CD")) {
            if(s.contains("AB")){
                s = s.replace("AB","");
            }
            if(s.contains("CD")){
                s = s.replace("CD","");
            }
        }
        return s.length();
    }
    //24.1.12
    //leetcode No.2085
    public static int countWords(String[] words1, String[] words2) {
        int res = 0;
        HashMap<String,int[]> map = new HashMap<>();
        for(String word : words1){
            if(!map.containsKey(word)){
                map.put(word,new int[]{1,0});//没有的话就放一个1,0
            }
            else {
                int count = map.get(word)[0]+1;
                map.put(word,new int[]{count,0});//有的话就放一个count+1,0
            }
        }
        for(String word : words2){
            if(!map.containsKey(word)){
                map.put(word,new int[]{0,1});
            }
            else {
                int count1 = map.get(word)[0];
                int count2 = map.get(word)[1]+1;
                map.put(word,new int[]{count1,count2});
            }
        }
        for(String s : map.keySet()){
            int[] value = map.get(s);
            if(value[0] == 1 && value[1] == 1){
                res++;
            }
        }
        return res;
    }
    //24.1.17
    //leetcode No.2744
    public static int maximumNumberOfStringPairs(String[] words) {
        /*
        互不相同 匹配一次
         */
        int res = 0;
        HashSet<String> set = new HashSet<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder(word);
            if(set.contains(sb.reverse().toString())){
                res++;
            }
            set.add(word);
        }
        return res;
    }
    //24.1.20
    //leetcode No.2788
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for(String word : words){
            if(!word.contains(separator+"")){
                System.out.println("123");
                res.add(word);
            }
            else {
                //注意 不能直接用split 因为要转义 ".,|$#@"这里面 这几个
                word = word.replace(separator,'1');
                String[] temp = word.split("1");
                for(String t : temp){
                    t = t.strip();
                    if(t.length() > 0){
                        res.add(t);
                    }
                }
            }
        }
        return res;
    }
    //24.1.23
    //leetcode No.2765
    public static int alternatingSubArray(int[] nums) {
        int max = -1;
        for(int i = 0;i < nums.length;i++){
            int index = i;
            boolean flag = true;
            for(int j = i + 1;j < nums.length;j++){
                if(flag){
                    if(nums[j] - nums[index] == 1){
                        max = Math.max(max,j-i+1);
                        index++;
                        flag = false;
                    }
                    else {
                        break;
                    }
                }else {
                    if(nums[index] - nums[j] == 1){
                        max = Math.max(max,j-i+1);
                        index++;
                        flag = true;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return max;
    }
    //24.1.25
    //leetcode No.2859 easy
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for(int i = 0;i < nums.size();i++){
            String s = Integer.toBinaryString(i);
            int count = 0;
            for(char c : s.toCharArray()){
                if(c == '1'){
                    count++;
                }
            }
            if(count == k){
                res += nums.get(i);
            }
        }
        return res;
    }
    //24.3.6
    //leetcode No.2917 easy
    public static int findKOr(int[] nums, int k) {
        int[] count = new int[32];//范围2^0-2^31
        for(int num : nums){
            String binaryString = Integer.toBinaryString(num);
            for(int i = binaryString.length() - 1;i >= 0;i--){
                if(binaryString.charAt(i) == '1'){
                    count[binaryString.length() - i - 1]++;
                }
            }
        }
        int res = 0;
        for(int i = 0;i < count.length;i++){
            if(count[i] >= k){
                res += (int)Math.pow(2,i);
            }
        }
        return res;
    }
    //24.3.23
    //leetcode No.2549 纯傻逼 还写了个埃氏筛 吊用没有
    public static int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        if(n == 1){
            return set.size();
        }
        int temp = 0;
        while(n != 2){
            for(int i = 1;i <= n;i++){
                if(n % i == 1){
                    set.add(i);
                    temp = i;
                }
            }
            n = temp;
        }
        return set.size();
    }
    //24.3.29
    //leetcode No.2908 easy 三层循环暴力
    public static int minimumSum(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length - 2;i++){
            for(int j = i + 1;j < nums.length - 1;j++){
                for(int k = j + 1;k < nums.length;k++){
                    if(nums[i] < nums[j] && nums[k] < nums[j]){
                        res = Math.min(res,nums[i]+nums[j]+nums[k]);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    //24.4.1 又六点醒了
    //leetcode No.2810 easy
    public static String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != 'i'){
                sb.append(c);
            }
            else {
                sb.reverse();
            }
        }
        return sb.toString();
    }
    //24.4.9
    //leetcode NO.2529 easy
    public int maximumCount(int[] nums) {
        int pos = 0,neg = 0;
        for(int num : nums){
            if(num > 0){
                pos++;
            }
            else if(num < 0){
                neg++;
            }
        }
        return Math.max(pos,neg);
    }
    //24.4.12 easy
    //leetcode No.2923 easy
    public static int findChampion(int[][] grid) {
        // 其实是一道语文题 g[i][j] = 1 也就是说这一行 只有 g[i][j] = 0 其他都必须是1
        int n  = grid.length;
        for(int i = 0;i < n;i++){
            int sum = 1;
            for(int j = 0;j < n;j++){
                if(i != j) {
                    sum *= grid[i][j];
                }
            }
            if(sum == 1){
                return i;
            }
        }
        return 0;
    }
    //24.4.27 easy
    //leetcode No.2639
    public static int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid[0].length];
        for(int i = 0;i < grid[0].length;i++){
            int max = 0;
            for (int[] ints : grid) {
                int len = ints[i] >= 0 ? String.valueOf(ints[i]).length() : String.valueOf(-ints[i]).length() + 1;
                max = Math.max(len, max);
            }
            res[i] = max;
        }
        return res;
    }
    //24.5.1 mid
    //leetcode No.2462
    public static long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        for(int i = 0;i < candidates;i++){
            queue1.offer(costs[i]); //把前C个数送进q1
            queue2.offer(costs[costs.length-1-i]);//把后C个数送进q2
        }
        int front_index = candidates,behind_index = costs.length - candidates - 1;
        if(front_index > behind_index){
            Arrays.sort(costs);
            for(int i = 0;i < k;i++){
                res += costs[i];
            }
            return res;
        }
        boolean flag = false;
        //0-3 6-9 假如从0-3里踢了一个数 那么把f加进去，然后f+1
        //假如从6-9里踢了一个数 那么把b加进去，然后b-1
        //当f=b的时候说明重叠了 这个时候数组没剩下数字了 看那个小 弹那个
        //还有一种情况 数组没数字 且有一方被弹空了
        while(k > 0){
            if(!queue1.isEmpty() && !queue2.isEmpty()){
                int num1 = queue1.peek();
                int num2 = queue2.peek();
                if(num1 <= num2){
                    res += num1;
                    queue1.poll();
                    if(!flag) {
                        queue1.offer(costs[front_index]);
                        front_index++;
                    }
                }
                else {
                    res += num2;
                    queue2.poll();
                    if(!flag) {
                        queue2.offer(costs[behind_index]);
                        behind_index--;
                    }
                }
                if(front_index > behind_index){
                    flag = true;
                }
            }
            else {
                if(!queue1.isEmpty()){
                    res += queue1.poll();
                }
                else if(!queue2.isEmpty()){
                    res += queue2.poll();
                }
            }
            k--;
        }
        return res;
    }
    //24.5.3 easy
    //leetcode No.1491
    public static double average(int[] salary) {
        long sum = 0;
        Arrays.sort(salary);
        for(int i = 1;i < salary.length - 1; i++){
            sum += salary[i];
        }
        return  (sum / (double)(salary.length - 2));
    }
    //24.5.4 copy一道hard
    //leetcode No.857
    public static double minCostToHireWorkers(int[] quality, int[] wage, int k){
        /*
        假设选择了某一个组H 构成k个人 总质量 = tQ 总支付 = tC
        那么对于任意组内工人H[i] 满足 -- tC / tQ * q[i] >= w[i]
        即 总金额/总质量 * 单个工人质量 >= 对应金额
        那么 总金额 = 总质量 * （金额[i] / 质量[i])
        那么工作质量固定的时候 最小金额 只和 工资组里 最大的 （金额[i] / 质量[i])有关
        由此推出贪心算法：权重 = （金额[i] / 质量[i])
        以某个工人x作为权重最高的时候，其他人需要小于x
        枚举每一个能成为权重最大的人，来计算开销，然后取最小
         */
        int n = quality.length;
        Integer[] h = new Integer[n];
        for(int i = 0;i < n;i++){
            h[i] = i; // h是个下标数组 用来排序用 在不打乱原数组金额和质量对应顺序的前提下 以及不额外使用map来一对一的情况下
        }
        // 这一步 是按权重排序 假设 w[a]/q[a] > w[b]/q[b] 那么有 w[a] * q[b] > w[b] * q[a] 即 (w[a] * q[b] - w[b] * q[a]) > 0
        Arrays.sort(h,(a,b)-> quality[b] * wage[a] - quality[a] * wage[b]);
        double res = 1e9;
        double totalQ = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i = 0;i < k - 1; i++){
            totalQ += quality[h[i]];
            pq.offer(quality[h[i]]); //先计算前k-1个权重最小的总金额，把他们放进优先队列里
        }
        //然后遍历 剩下的 n - (k - 1) 个数 一边放进去一边弹栈顶 最后找出一个数就行
        for(int i = k - 1;i < n;i++){
            int index = h[i];
            totalQ += quality[index];
            pq.offer(quality[index]);
            double totalC = ((double) wage[index] / quality[index]) * totalQ;
            res = Math.min(res,totalC);
            if(!pq.isEmpty()) {
                totalQ -= pq.poll();
            }
        }
        return res;
    }
    //24.5.10 easy
    //leetcode No.2960
    public static int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage - count > 0) {
                count++;
            }
        }
        return count;
    }
    //24.5.18 easy
    //leetcode No.2644
    public static int maxDivScore(int[] nums, int[] divisors) {
        int res = -1,max = -1;
        for(int divisor : divisors){
            int count = 0;
            for(int num : nums){
                if(num % divisor == 0){
                    count++;
                }
                if(count > max){
                    res = divisor;
                    max = count;
                }
                else if(count == max){
                    if(res > divisor){
                        res = divisor;
                    }
                }
            }
        }
        return res;
    }
    //24.5.25 easy
    //leetcode No.2903
    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] res = {-1,-1};
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < nums.length;j++){
                if(Math.abs(i-j) >= indexDifference && Math.abs(nums[i]-nums[j]) >= valueDifference){
                    return new int[]{i,j};
                }
            }
        }
        return res;
    }
    //24.5.28 easy
    //leetcode No.2951
    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i < mountain.length - 1;i++){
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]){
                res.add(i);
            }
        }
        return res;
    }
    //24.5.31 easy
    //leetcode No.2965
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n*n+1];
        for(int[] i :grid){
            for(int j : i){
                count[j]++;
            }
        }
        int a = -1,b = -1;
        for(int i = 1;i < count.length;i++){
            if(count[i] == 2){
                a = i;
            }
            else if(count[i] == 0){
                b = i;
            }
        }
        return new int[]{a,b};
    }
    //24.6.1 easy
    //leetcode No.2928
    public static int distributeCandies(int n, int limit) {
        //分给3个人 每个人不超过limit个
        int res = 0;
        if(limit * 3 < n){
            return res;//如果limit * 3 < n 说明 n / 3 > limit 甚至 不能分到最小
        }
        else if(limit * 3 == n){
            return 1;//如果刚好相对 说明只有 l,l,l一种分法
        }
        else {
            //两个条件 ： a+b+c = n ; 0=<a,b,c<=limit
            for(int i = 0;i <= n;i++){
                for(int j = 0;j <= n;j++){
                    for(int k = 0;k <= n;k++){
                        if(i + j + k == n && i <= limit && j <= limit && k <= limit){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
    //24.6.6 睡不着 medium
    //leetcode No.2938
    public static long minimumSteps(String s) {
        /*
        遇到0就计数，遇到1就结算
         */
        long res = 0;
        int count = 0;
        for(int i = s.length() - 1; i >= 0;i--){
            if(s.charAt(i) == '0'){
                count++;
            }
            else {
                res += count;
            }
        }
        return res;
    }
    //24.6.7 easy
    //leetcode No.3038
    public static int maxOperations(int[] nums) {
        int count = 1,sum = nums[0] + nums[1];
        for(int i = 3;i < nums.length; i += 2){
            if(nums[i] + nums[i-1] == sum){
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }
    //24.6.10 medium
    //leetcode No.881
    public static int numRescueBoats(int[] people, int limit) {
        /*
        大清早起来一个半钟发现裂了，看答案重写
        排序，然后两个指针l,r首位开始匹配
        如果p[l]+p[r] <= limit，说明可以同船，count+1，两边各自往中间靠
        如果p[l]+p[r] > limit，说明不能成组，因为不能超过limit,所以p[r]自己要成，r左移
        草 原来最重+最轻的做法已经足够了 不用最优解
        假设最优解数量=c1，贪心解数量=c2
        最终答案=二元组数量+剩余人数数量，二元组数量是固定的，剩余人数也固定
        也就是说无论是最优解还是贪心解，每一对能组合的人的数量都是一样的
        证明比题还抽象，不看了
         */
        Arrays.sort(people);
        int n = people.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            ans++;
        }
        return ans;
    }
    //24.6.15 medium
    //leetcode No.2779
    public static int maximumBeauty(int[] nums, int k) {
        /*
        子序列，不需要顺序，直接排序
        然后双指针，在区间内就加，不在就左指针往右滑
         */
        Arrays.sort(nums);
        int res = 1,left = 0;
        for(int right = 1;right < nums.length;right++){
            if(nums[right] - nums[left] <= k * 2){
                res = Math.max(res,right-left+1);
            }
            else {
                while(nums[right] - nums[left] > k * 2){
                    left++;
                }
            }
        }
        res = Math.max(res,nums.length-left);
        return res;
    }
    //24.6.21
    //leetcode Lcp 61
    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        /*
        注意，是趋势相同的，最大天数，两个定语，趋势相同，最大
         */
        int res = 0,max = 0;
        for(int i = 1;i < temperatureA.length;i++){
            int diffA = temperatureA[i] - temperatureA[i-1];
            int diffB = temperatureB[i] - temperatureB[i-1];
            if((diffA > 0 && diffB > 0) || (diffA == 0 && diffB == 0) || (diffA < 0 && diffB < 0)){
                max++;
            }
            else {
                max = 0;
            }
            res = Math.max(res,max);
        }
        return res;
    }
    //24.6.23 easy
    //leetcode No.520
    public static boolean detectCapitalUse(String word) {
        boolean upper = true,lower = true;
        int upper_count = 0;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                lower = false;
                upper_count++;
            }
            else {
                upper = false;
            }
        }
        if(upper || lower){
            return true; // 如果全大写或全小写 说明有效
        }
        //如果走到下面的return 说明u和l都为false 这个时候判断是否只有一个大写 和大写是否为首个字符即可
        return upper_count == 1 && Character.isUpperCase(word.charAt(0));
    }
    //24.6.29 easy
    //leetcode No.2710
    public static String removeTrailingZeros(String num) {
        int index = num.length() - 1;
        while(index > 0 && num.charAt(index) == '0'){
            index--;
        }
        return num.substring(0,index+1);
    }
    //24.7.2 medium
    //leetcode No.3115
    public static int maximumPrimeDifference(int[] nums) {
        List<Integer> even = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        List<Integer> index = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(even.contains(nums[i])){
                index.add(i);
            }
        }
        if(index.size() == 1){
            return 0;
        }
        return index.get(index.size()-1) - index.get(0);
    }
    //24.7.3 easy
    //leetcode No.3099
    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0,temp = x;
        while(temp > 0){
            sum += temp % 10;
            temp /= 10;
        }
        if(x % sum == 0){
            return sum;
        }
        return -1;
    }
    //24.7.6 medium
    //leetcode No.3101
    public static long countAlternatingSubArrays(int[] nums) {
        /*
        从nums[0]开始 res = 1 len = 1
        如果n[i] != n[i-1] len++ res += len
        如果n[i] == n[i-1] len = 1 res += len
         */
        long res = 1;
        int len = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] != nums[i-1]){
                len++;
            }
            else {
                len = 1;
            }
            res += len;
        }
        return res;
    }
    //24.7.12 easy 两分钟写出来
    //leetcode No.2974
    public static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i += 2){
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
        return nums;
    }
    //24.7.16 easy
    //leetcode No.2956
    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int c1 = 0,c2 = 0;
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            if(set1.contains(num)){
                c2++;
            }
            set2.add(num);
        }
        for(int num : nums1){
            if(set2.contains(num)){
                c1++;
            }
        }
        return new int[]{c1,c2};
    }
    //24.7.26
    //leetcode No.2740
    public static int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 1;i < nums.length;i++){
            res = Math.min(res,nums[i] - nums[i-1]);
        }
        return res;
    }
    //24.7.31 medium
    //leetcode No.3111
    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int res = 1,start = points[0][0] + w;
        for(int i = 1;i < points.length;i++){
            if(points[i][0] > start){
                res++;
                start = points[i][0] + w;
            }
        }
        return res;
    }
    //24.8.8 easy
    //leetcode No.3131
    public static int addedInteger(int[] nums1, int[] nums2) {
        int r1 = -1,r2 = -1;
        for(int i = 0;i < nums1.length;i++){
            r1 = Math.max(r1,nums1[i]);
            r2 = Math.max(r2,nums2[i]);
        }
        return r2 - r1;
    }
}
