package myLeetCodeAnswer;
//leetcode 面试题17.09 第K个数 不会 没思路 参考答案 思路源于丑数
public class getKthMagicNumber {
    public static void main(String[] args) {
        int k = 7;
        int[] dp = new int[k];
        dp[0] = 1;
        int three = 0,five = 0,seven = 0;
        //用3，5，7三个指针，表示出现的个数
        //规律：下一个数，肯定是之前的三五七倍，找出之前的数，乘以3，5，7倍即可。
        //丑数同样的道理，用这个东西，乘以2，3，5
        for(int i = 1;i < k;i++){
            dp[i] = Math.min(Math.min(dp[three]*3,dp[five]*5),dp[seven]*7);
            if(dp[i] % 3 == 0)  three++;
            if(dp[i] % 5 == 0)  five++;
            if(dp[i] % 7 == 0)  seven++;
        }
        System.out.println(dp[k-1]);
    }
}
