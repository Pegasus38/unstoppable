package Solution;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class October {
    public static void main(String[] args) {

    }
    //10.22 每日一题 = 困难题 = 不想做 = 随便刷一题
    //leetcode No.1337 虽然知道是根堆做法 但是写不出Comparator，而且也不太会二维数组写法，寄
    public static int[] kWeakestRows(int[][] mat,int k){
        int[][] temp = new int[mat.length][2];
        for(int i = 0;i < mat.length;i++){
            int count = 0;
            for(int j = 0;j < mat[0].length;j++){
                if(mat[i][j] == 1){
                    count++;
                }
                else {
                    break;
                }
            }
            temp[i][0] = count;
            temp[i][1] = i;
        }
        Arrays.sort(temp, (o1, o2) -> {
            if(o1[0] != o2[0])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        int[] res = new int[k];
        for(int i = 0;i < k;i++){
            res[i] = temp[i][1];
        }
        return res;
    }
    //10.23 今天的每日一题发现已经做过了 不想再写 直接copy+paste
    //leetcode No.1812 一句话pass
    public static boolean squareIsWhite(String coordinates){
        return (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0') % 2 == 0;
    }
    //10.26 今天的每日一题通过率很低 不做了 应该也做不出
    //做一道经典的前缀和题目
    //leetcode No.525 不写了 有点烦 明天看看题解 题解已经在云笔记里
    public static int findMaxLength(int[] num){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0,res = 0;
        for(int i = 0; i< num.length;i++){
            sum += num[i] == 0 ? -1 : num[i];
            if(map.containsKey(sum)){
                int j = map.get(sum);
                res = Math.max(res,i - j);
            }
            else{
                map.put(sum,i);
            }
        }
        return res;
    }
    //10.29 每日一题
    //leetcode No.1773 非常简单的简单题 pass
    public static int countMatches(List<List<String>> items,String ruleKey,String ruleValue){
        int count = 0;
        for(List<String> list : items){
            if(ruleKey.equals("type")){
                if(list.get(0).equals(ruleValue)){
                    count++;
                }
            }
            else if(ruleKey.equals("color")){
                if(list.get(1).equals(ruleValue)){
                    count++;
                }
            }
            else {
                if(list.get(2).equals(ruleValue)){
                    count++;
                }
            }
        }
        return count;
    }
}
