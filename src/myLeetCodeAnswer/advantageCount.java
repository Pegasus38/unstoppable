package myLeetCodeAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode NO.870 最后一个例子死掉了，长度太大，总的来说思路应该没有问题，就是效率太差，indexOf占的时间很长很长。
public class advantageCount {
    public static void main(String[] args) {
        int[] nums1 = {6,2,1,5,7};
        int[] nums2 = {0,3,4,7,8};
        int[] temp = nums2.clone();
        List<Integer> list = new ArrayList<>();
        for(int i : nums2){
            list.add(i);
        }
        Arrays.sort(nums1);
        Arrays.sort(temp);
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        int index = 0;
        for(int i = 0;i < nums1.length;i++) {
            if (nums1[i] > temp[index]) {
                res[list.indexOf(temp[index])] = nums1[i];
                list.set(list.indexOf(temp[index]), -1);
                nums1[i] = -1;
                index++;
            }
        }
        Arrays.sort(nums1);
        for(int i = 0;i < nums1.length;i++){
            if(nums1[i] > 0){
                index = i;
                break;
            }
        }
        for(int i = 0;i < res.length;i++){
            if(res[i] == -1){
                res[i] = nums1[index];
                index++;
            }
        }
        for(int i : res){
            System.out.println(i);
        }
    }
}
