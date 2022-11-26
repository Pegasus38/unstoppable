package myLeetCodeAnswer;

//leetcode No.1608 pass 但是暴力解法 效率极低
public class specialArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2};
        int res = -1;
        for(int i = 1;i <= nums.length;i++){
            int count = 0;
            for(int j : nums){
                if(j >= i){
                    count++;
                }
            }
            if(count == i){
                res = i;
            }
        }
        System.out.println(res);
    }
}
