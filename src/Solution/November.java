package Solution;


import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;

public class November {
    public static void main(String[] args) {

    }
    //11.3
    //leetcode No.611 pass 小到大排序不行 大到小才能用双指针 最后用了选两边然后二分找第三边的方法 时间复杂度可能慢 但是还是过了
    public static int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0;i < nums.length-2;i++){
            int tag1 = nums[i];
            for(int j = i+1;j < nums.length-1;j++){
                int tag2 = nums[j];
                int left = j+1;
                int right = nums.length-1;
                while(left <= right){
                    int mid = (left + right)/2;
                    if(tag1 + tag2 <= nums[mid]){
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                count += left - 1 - j;
            }
        }
        return count;
    }
    //11.5
    //leetcode No.1106 每日一题hard题 一遍pass 堆栈
    public static boolean parseBoolExpr(String expression){
        Stack<Character> stack_char = new Stack<>();
        Stack<String> stack_info = new Stack<>();
        //少了一个只有一个字母的判断，需要补上
        if(expression.length() == 1){
            return expression.equals("t");
        }
        for(char c : expression.toCharArray()){
            //如果遇到运算符，就放进第一个stack
            if(c == '!' || c == '&' || c == '|'){
                stack_char.push(c);
            }
            //遇到左括号就开始记录
            if(c == '('){
                stack_info.push("");
            }
            if(c == 't' || c == 'f'){
                String temp = stack_info.pop();
                temp += c + "";
                stack_info.push(temp);
            }
            if(c == ')'){
                char cal = stack_char.pop();
                String info = stack_info.pop();
                if(cal == '&'){
                    info = info.contains("f") ? "f" : "t";
                }
                else if(cal == '|'){
                    info = info.contains("t") ? "t" : "f";
                }
                else {
                    info = info.equals("f") ? "t" : "f";
                }
                if(stack_info.isEmpty()){
                    stack_info.push(info);
                }
                else {
                    String temp = stack_info.pop();
                    temp += info;
                    stack_info.push(temp);
                }
            }
        }
        String result = stack_info.pop();
        return result.equals("t");
    }
    //leetcode No.503 pass 没有用单调栈 用了两个while
    public static int[] nextGreaterElements(int[] nums){
        int[] res = new int[nums.length];
        for(int i = 0;i < nums.length-1;i++){
            int left = 0,right = i+1;
            while(right < nums.length && nums[right] <= nums[i]){
                right++;
            }
            if(right == nums.length){
                while(left < i && nums[left] <= nums[i]){
                    left++;
                }
                if(left == i){
                    res[i] = -1;
                }
                else {
                    res[i] = nums[left];
                }
            }
            else {
                res[i] = nums[right];
            }
        }
        int index = 0;
        while(nums[index] <= nums[nums.length-1] && index < nums.length-1){
            index++;
        }
        res[nums.length-1] = index == nums.length-1 ? -1 : nums[index];
        return res;
    }
    //11.6
    //leetcode No.1678 每日一题 一眼简单题 pass
    public static String interpret(String command){
        return command.replace("()","o").replace("(al)","al");
    }
    //11.10
    //leetcode No.864 不会且不想抄 先留空 很难 BFS+位运算状态压缩
    //leetcode No.970 pass
    public static List<Integer> powerfulIntegers(int x, int y, int bound){
        int left = 0,right = 32;
        while(left <= right){
            int mid = (left+right)>>1;
            if((int)Math.pow(x,mid) > bound){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        int a_max = left;
        left = 0;right = 32;
        while(left <= right){
            int mid = (left+right)>>1;
            if((int)Math.pow(y,mid) > bound){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        int b_max = left;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < a_max; i++){
            for(int j = 0;j < b_max;j++){
                int temp = (int)Math.pow(x,i) + (int)Math.pow(y,j);
                if(temp <= bound){
                    set.add(temp);
                }
            }
        }
        return new ArrayList<>(set);
    }
    //11.11
    //leetcode No.1704 每日一题 简单题 pass
    public static boolean halvesAreAlike(String s){
        List<Character> list = List.of('a','e','i','o','u','A','E','I','O','U');
        int count = 0;
        for(int i = 0;i < s.length()/2;i++){
            if(list.contains(s.charAt(i))){
                count++;
            }
        }
        for(int i = s.length()/2;i<s.length();i++){
            if(list.contains(s.charAt(i))){
                count--;
            }
        }
        return count == 0;
    }
    //leetcode No.2139 pass
    public static int minMoves(int target, int maxDoubles){
        int res = 0;
        while(target > 1){
            if(target % 2 != 0){
                target--;
                res++;
            }
            else {
                if(maxDoubles > 0){
                    target /= 2;
                    res++;
                    maxDoubles--;
                }
                else {
                    res += target - 1;
                    target = 1;
                }
            }
        }
        return res;
    }
    //11.12
    //leetcode No.790 每日一题动态规划倒是不会 找规律倒是会了 pass
    public static int numTilings(int n){
        if(n < 3){
            return n;
        }
        else {
            long[] res = new long[n+1];
            long[] count = new long[n+1];
            res[1] = 1;
            res[2] = 2;
            count[2] = 1;
            for(int i = 3;i <= n;i++){
                res[i] = (res[i-1] * 2 + count[i-1]);
                count[i] = res[i-2];
                res[i] %= 1000000007;
            }
            return (int)res[n];
        }
    }
    //leetcode No.763 最后错了一步，服了，提交错误次数+1 虽然还是pass了 但是思路很几把笨
    public static List<Integer> partitionLabels(String s){
        List<Integer> res = new ArrayList<>();
        HashMap<Character,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
        boolean tag = true;
        int left = 0,right = -1,index;
        while(left < s.length()){
            if(map.get(s.charAt(left)).size() < 2){
                res.add(1);
                left++;
            }
            else {
                if(right == -1){
                    right = map.get(s.charAt(left)).get(map.get(s.charAt(left)).size()-1);
                }
                index = right;
                String temp = s.substring(left,right);
                for(char c : temp.toCharArray()){
                    if(map.get(c).size() > 1){
                        if(map.get(c).get(map.get(c).size()-1) > right){
                            right = map.get(c).get(map.get(c).size()-1);
                        }
                    }
                }
                System.out.println(List.of(left,right,index,tag));
                if(tag){
                    if(right == index){
                        res.add(right-left+1);
                        left = right+1;
                        right = -1;
                    }
                    else {
                        //注意，这里的right有可能被更新了，所以如果想要记录上一段，实际上是要算index的
                        res.add(index-left+1);
                        tag = false;
                        left = index;
                    }
                }
                else {
                    int temp_len = res.get(res.size()-1);
                    if(right == index){
                        res.set(res.size()-1,temp_len+right-left);
                        tag = true;
                        left = right+1;
                        right = -1;
                    }
                    else {
                        res.set(res.size()-1,temp_len+index-left);
                        left = index;
                    }
                }
            }
        }
        return res;
    }
    //11.13
    //leetcode No.791 每日一题 一眼简单题 pass
    public static String customSortString(String order, String s){
        int[] temp = new int[26];
        for(char c: s.toCharArray()){
            temp[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length();i++){
            if(s.contains(order.charAt(i)+"")){
                String t = order.charAt(i)+"";
                sb.append(t.repeat(temp[order.charAt(i)-'a']));
                temp[order.charAt(i)-'a'] = 0;
            }
        }
        for(int i = 0;i < temp.length;i++){
            if(temp[i] > 0){
                char c1 = (char)(97+i);
                String s1 = c1+"";
                sb.append(s1.repeat(temp[i]));
            }
        }
        return sb.toString();
    }
    //leetcode No.56 来做一道经典的贪心算法-合并区间 死在了包含重复区间的例子 比如[1,4][2,3] GG
    //选错方向了，如果选右边界的话，会存在A包含B的情况，导致没办法判断出来，虽然我已经知道这种套路了，但还是中招了
    //理论上来说，是想错题目了，想到了之前的无重叠区间去了
    //实际上只是错了一句，少了一个左区间最小的判断->left = Math.min(left,intervals[i][0]) 所以还是pass了
    public static int[][] merge(int[][] intervals){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o2[1] - o1[1]);
        int right = intervals[0][1],left = intervals[0][0];
        for(int i = 1;i < intervals.length;i++){
            if(intervals[i][1] < left){
                list.add(0,Arrays.asList(left,right));
                left = intervals[i][0];
                right = intervals[i][1];
            }
            else {
                left = Math.min(left,intervals[i][0]);
            }
        }
        list.add(0,Arrays.asList(left,right));
        int[][] res = new int[list.size()][2];
        for(int i = 0;i < res.length;i++){
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        return res;
    }
    //11.14
    //leetcode No.1481 今天的每日一题有点难 直接ctrl+CV了 随便来一题 pass
    public static int findLeastNumOfUniqueInts(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        while(k > 0){
            int count = map.get(list.get(list.size()-1));
            if(k >= count){
                k -= count;
                list.remove(list.size()-1);
            }
            else {
                k = 0;
            }
        }
        return list.size();
    }
    //leetcode No.2200 pass
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == key){
                list.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            boolean tag = false;
            for (int j : list) {
                if (Math.abs(i - j) <= k) {
                    tag = true;
                    break;
                }
            }
            if(tag) res.add(i);
        }
        return res;
    }
    //11.15
    //leetcode No.1710 每日一题 忘记处理全部装完的情况了 导致错了一次 笨b pass
    public static int maximumUnits(int[][] boxTypes, int truckSize){
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int index = 0,res = 0;
        while(truckSize > 0 && index < boxTypes.length){
            if(truckSize >= boxTypes[index][0]){
                res += boxTypes[index][0] * boxTypes[index][1];
                truckSize -= boxTypes[index][0];
                index++;
            }
            else {
                res += truckSize * boxTypes[index][1];
                break;
            }
        }
        return res;
    }
    //leetcode No.1358 有点抽象 稍后再思考 做了两天 用的变量有点多
    public static int numberOfSubstrings(String s){
        int res = 0;
        char near = s.charAt(0),last = ' ';
        int add = 0,len = 1,cur = 1,index = 0;
        boolean cal = false;
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) != near){
                index = i;
                last = s.charAt(index);
                cur = index + 1;
                break;
            }
        }
        //如果没有last 或者 指针到头了 说明没有东西 就可以直接返回0
        if(index == 0 || index == s.length()-1){
            return 0;
        }
        //然后这里 从index+1开始遍历
        for(int i = index+1;i < s.length();i++){
            if(s.charAt(i) == last){
                cur++;
                len++;
                if(cal){
                    res += add;
                }
            }
            else if(s.charAt(i) == near){
                cur++;
                len = 1;
                if(cal){
                    res += add;
                }
                near = last;
                last = s.charAt(i);
            }
            else {
                cal = true;
                add = add +cur - len;
                res += add;
                cur = len + 1;
                len = 1;
                near = last;
                last = s.charAt(i);
            }
        }
        return res;
    }
    //leetcode No.775 每日一题 过不去[2,1,0]这个例子
    /*理解有点问题 我一开始是以为 如果他所在的位置 和当前的数值不一致 就加上这个差值 最后统计差值
        但是后面发现 210这个例子 差值是2 局部也是2 实际差值是3 存在3堆 分别是21 20 10
        实际上 只要观察可以发现 局部差 一定是全局差 只要存在局部差以外的全局差 就是false
        先定一个max=n[0] 如果下标和当前的值相差大于2，那肯定是false
        如果满足的话，肯定满足Math.abs(nums[i] - i) <= 1
     */
    public static boolean isIdealPermutation(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
    //11.17
    //leetcode No.1689 送分题
    public static int minPartitions(String n){
        int max = 0;
        for(char c : n.toCharArray()){
            max = Math.max(max,c - '0');
        }
        return max;
    }
    //11.18
    //leetcode No.1103 死活过不去倒数第二个例子 越写越来气
    public static int[] distributeCandies(int candies, int num_people) {
        int curr_give = 0;
        int[] res = new int[num_people];

        while (candies > 0) {

            res[curr_give % num_people] += Math.min(++curr_give, candies);
            candies -= curr_give;
        }

        return res;
    }
    //11.19
    //leetcode No.1732 每日一题 简单题 一眼pass
    public static int largestAltitude(int[] gain) {
        int res = 0;
        int[] temp = new int[gain.length];
        temp[0] = gain[0];
        res = Math.max(temp[0],res);
        for (int i = 1; i < gain.length; i++) {
            temp[i] = temp[i - 1] + gain[i];
            res = Math.max(temp[i], res);
        }
        return res;
    }
    //leetcode No.1122 pass
    public static int[] relativeSortArray(int[] arr1, int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for (int j : arr2) {
            int time = map.get(j);
            while (time > 0) {
                res[index] = j;
                index++;
                time--;
            }
            map.remove(j);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.naturalOrder());
        for(int i : list){
            int time = map.get(i);
            while(time > 0){
                res[index] = arr2[i];
                index++;
                time--;
            }
        }
        return res;
    }
    //11.20
    //leetcode No.799 每日一题 当天做不出来，先跳过 思路不对 不会怎么处理溢出的部分 直接给
    public static double champagneTower(int poured, int query_row, int query_glass){
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[1][1] = poured; // 为了方式越界，下标（0,0）的酒杯我们存放在dp[1][1]的位置上
        for (int row = 2; row <= query_row + 1; row++) {
            for (int column = 1; column <= row; column++) {
                dp[row][column] = Math.max(dp[row - 1][column - 1] - 1, 0) / 2 + Math.max(dp[row - 1][column] - 1, 0) / 2;
            }
        }
        return Math.min(dp[query_row + 1][query_glass + 1], 1);
    }
    //11.22
    //leetcode No.1037 笨b 排除了一万种情况 还是没有排除重点的情况 十字相乘会不会
    public static boolean isBoomerang(int[][] points){
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
    //leetcode No.917 pass
    public static String reverseOnlyLetters(String s){
        List<Character> list = new ArrayList<>();
        for(int i = s.length()-1;i >= 0;i--){
            if(Character.isLowerCase(s.charAt(i)) || Character.isUpperCase(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        int index = 0;
        char[] c = s.toCharArray();
        for(int i = 0;i < c.length;i++){
            if(Character.isLowerCase(s.charAt(i)) || Character.isUpperCase(s.charAt(i))){
                c[i] = list.get(index);
                index++;
            }
        }
        String res = "";
        for(char c1 : c){
            res += c1 + "";
        }
        return res;
    }
    //11.26
    //leetcode No.2390 pass
    public static String removeStars(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*'){
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    //11.27
    //leetcode No.1752 每日一题
    public static boolean check(int[] nums){
        //这是上次的 用那个是否包含某个颠倒顺序的字符串的写法 但是我想了一下 这玩意 其实没有这么复杂
        //后来我写了一个断崖点的写法 但是少了一个判断 如果我发现还是按照这个提交吧 虽然很笨 但是管用啊
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int[] temp = nums.clone();
        Arrays.sort(temp);
        for(int i = 0;i < nums.length;i++){
            sb.append(nums[i]);
            sb.append("/");
            sb2.append(temp[i]);
            sb2.append("/");
        }
        String res = sb + sb.toString();
        return res.contains(sb2.toString());
    }
    //leetcode No.1297 写法不完全对 有问题 准备推翻重写 先提交一版
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize){
        HashMap<String,Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        int[] temp = new int[26];
        int max = 0;
        for(int i = 0;i < s.length();i++){
            if(q.size() < maxLetters - 1){
                q.offer(s.charAt(i));
                temp[s.charAt(i) - 'a']++;
            }
            else{
                if(q.contains(s.charAt(i))){
                    temp[s.charAt(i) - 'a']++;
                }
                else {
                    Queue<Character> t = new LinkedList<>(q);
                    int length = 1;
                    while(!t.isEmpty()){
                        length += temp[t.poll() - 'a'];
                    }
                    if(length >= minSize && length <= maxSize){
                        map.put(s.substring(i+1-length,i+1),map.getOrDefault(s.substring(i+1-length,i+1),0)+1);
                    }
                    System.out.println(map);
                    char c = q.poll();
                    temp[c - 'a'] = 0;
                    q.offer(s.charAt(i));
                    temp[s.charAt(i) - 'a']++;
                }
            }
        }
        for(int i : map.values()){
            max = Math.max(i,max);
        }
        return max;
    }
    //11.29 昨天没写 很暴躁 没心态学习 后面慢慢补上
    //leetcode No.1758 每日一题 很笨的方法
    public static int minOperations(String s){
        if(s.length() == 1){
            return 0;
        }
        int count1 = 0,count2 = 0;
        String s1 = "10".repeat(s.length() / 2);
        String s2 = "01".repeat(s.length() / 2);
        if(s.length() % 2 != 0){
            s1 += "1";
            s2 += "0";
        }
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != s1.charAt(i)){
                count1++;
            }
            if(s.charAt(i) != s2.charAt(i)){
                count2++;
            }
        }
        return Math.min(count1,count2);
    }
}
