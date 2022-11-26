package myLeetCodeAnswer;

import java.util.*;

/*
leetcode No.658 pass
 */
public class findClosestElements {
    public static void main(String[] args) {
        int[] a ={3,3,3,3,4};
        int k = 4,x = 3;
        int b = Arrays.binarySearch(a,x);
        int left = 0,right = 0;
        List<Integer> res = new ArrayList<>();
        if(b == 0 || b == -1){
            for(int i = 0; i < k ; i++){
                res.add(a[i]);
            }
        }
        else if(b == a.length - 1 || b == -(a.length + 1)){
            for(int i = 0;i < k;i++){
                res.add(a[a.length-1-i]);
            }
        }
        else{
            if(b > 0){
                res.add(a[b]);
                left = b - 1;
                right = b + 1;
                for(int i = 0;i < k - 1;i++){
                    if(left >= 0 && right <a.length){
                        if(Math.abs(a[left] - a[b]) <= Math.abs(a[right] - a[b])) {
                            res.add(a[left]);
                            left--;
                        }
                        else if(Math.abs(a[left] - a[b]) > Math.abs(a[right] - a[b])){
                            res.add(a[right]);
                            right++;
                        }
                    }
                    else{
                        if(left < 0){
                            res.add(a[right]);
                            right++;
                        }
                        else{
                            res.add(a[left]);
                            left--;
                        }
                    }
                }
            }
            else{
                int c = Math.abs(b);
                left = c - 2;
                right = c - 1;
                for(int i = 0;i < k ;i++){
                    if(left >= 0 && right <a.length){
                        if(Math.abs(a[left] - x) <= Math.abs(a[right] - x)) {
                            res.add(a[left]);
                            left--;
                        }
                        else if(Math.abs(a[left] - x) > Math.abs(a[right] - x)){
                            res.add(a[right]);
                            right++;
                        }
                    }
                    else{
                        if(left < 0){
                            res.add(a[right]);
                            right++;
                        }
                        else{
                            res.add(a[left]);
                            left--;
                        }
                    }
                }
            }
        }
        res.sort(Comparator.naturalOrder());
        for(int i : res){
            System.out.println(i);
        }
    }
}
