package myLeetCodeAnswer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//leetcode NO.423 pass 但是效率有点低 也是头一次写100+行代码 就是靠枚举 0到9的独特的地方 比如说zero只包含z
public class originalDigits {
    public static void main(String[] args) {
        String s = "ninefive";
        String res = "";
        List<Integer> list = new ArrayList<>();
        int[] a = new int[15];
        for(int i = 0;i < s.length();i++) {
            char j = s.charAt(i);
            if (j == 'e') {
                a[0]++;
            } else if (j == 'g') {
                a[1]++;
            } else if (j == 'f') {
                a[2]++;
            } else if (j == 'i') {
                a[3]++;
            } else if (j == 'h') {
                a[4]++;
            } else if (j == 'o') {
                a[5]++;
            } else if (j == 'n') {
                a[6]++;
            } else if (j == 's') {
                a[7]++;
            } else if (j == 'r') {
                a[8]++;
            } else if (j == 'u') {
                a[9]++;
            } else if (j == 't') {
                a[10]++;
            } else if (j == 'w') {
                a[11]++;
            } else if (j == 'v') {
                a[12]++;
            } else if (j == 'x') {
                a[13]++;
            } else if (j == 'z') {
                a[14]++;
            }
        }
        if(a[13] > 0){
            int time = a[13];
            for(int i = 0;i < time;i++){
                list.add(6);
                a[13]--;a[3]--;a[7]--;
            }
        }
        if(a[11] > 0){
            int time = a[11];
            for(int i = 0;i < time;i++){
                list.add(2);
                a[11]--;a[10]--;a[5]--;
            }
        }
        if(a[14] > 0){
            int time = a[14];
            for(int i = 0;i < time;i++){
                list.add(0);
                a[14]--;a[8]--;a[5]--;a[0]--;
            }
        }
        if(a[9] > 0){
            int time = a[9];
            for(int i = 0;i < time;i++){
                list.add(4);
                a[9]--;a[8]--;a[5]--;a[2]--;
            }
        }
        if(a[1] > 0){
            int time = a[1];
            for(int i = 0;i < time;i++){
                list.add(8);
                a[1]--;a[0]--;a[3]--;a[4]--;a[10]--;
            }
        }
        if(a[13] == 0 && a[7] > 0){
            int time = a[7];
            for(int i = 0;i < time;i++){
                list.add(7);
                a[7]--;a[12]--;a[6]--;a[0]-=2;
            }
        }
        if(a[9] == 0 && a[2] > 0){
            int time = a[2];
            for(int i = 0;i < time;i++){
                list.add(5);
                a[2]--;a[12]--;a[0]--;a[3]--;
            }
        }
        if(a[1] == 0 && a[4] > 0){
            int time = a[4];
            for(int i = 0;i < time;i++){
                list.add(3);
                a[4]--;a[10]--;a[0]-=2;a[8]--;
            }
        }
        if(a[11] == 0 && a[14] == 0 && a[5] > 0){
            int time = a[5];
            for(int i = 0;i < time;i++){
                list.add(1);
                a[5]--;a[0]--;a[6]--;
            }
        }
        if(a[13] == 0 && a[1] == 0 && a[3] > 0){
            int time = a[3];
            for(int i = 0;i < time;i++){
                list.add(9);
                a[3]--;a[0]--;a[6]-=2;
            }
        }
        list.sort(Comparator.naturalOrder());
        for(int i : list){
            res += i + "";
        }
        System.out.println(res);
    }
}
