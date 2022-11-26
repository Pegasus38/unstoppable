package myLeetCodeAnswer;

import java.util.ArrayList;
import java.util.List;

//leetcode No.728 pass 暴力循环 一次过
public class selfDividingNumbers {
    public static void main(String[] args) {
        int left = 1,right = 10000;
        List<Integer> res = new ArrayList<>();
        int temp;
        for(int i = left ; i <= right;i++){
            temp = i;
            boolean tag = true;
            while(temp > 0){
                int mod = temp % 10;
                if(mod != 0){
                    if(i % mod != 0){
                        tag = false;
                    }
                }
                else if(mod == 0){
                    tag = false;
                }
                temp /= 10;
            }
            if(tag){
                res.add(i);
            }
        }
        System.out.println(res);
    }
}
