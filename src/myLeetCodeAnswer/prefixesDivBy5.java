package myLeetCodeAnswer;
//leetcode No.1018 思路不对 抄答案
import java.util.ArrayList;
import java.util.List;

public class prefixesDivBy5 {
    public static void main(String[] args) {
        int[] nums = {0,1,1};
        List<Boolean> res = new ArrayList<>();
        /*
        int sum = 0;
        int[] a = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            for(int j = 0 ; j <=i ;j++ ){
                double now = nums[i-j] * Math.pow(2,j);
                sum += (int)now;
            }
            a[i] = sum;
            sum = 0;
        }
        for(int i = 0; i < a.length;i++){
            if(a[i] % 5 == 0){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        for(boolean b : res){
            System.out.println(b);
        }
        以上写法看似没问题，实际上，到超出int的时候，就会炸了，思路完全不对。
        能不能被5整除，其实看他的对10和对5有没有余数即可。
        因为只有尾数为5和为0，对5取余才等于0.
         */
        int num = 0;
        for (int j : nums) {
            num <<= 1;
            num += j;
            num %= 10;
            res.add(num % 5 == 0);
        }
        for(boolean b : res){
            System.out.println(b);
        }
        /*
        上面才是正确思路：num左移+余数 = 先余10，再余5。
         */
    }
}
