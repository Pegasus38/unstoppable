package Solution;

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
}
