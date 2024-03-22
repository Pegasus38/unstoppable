package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MyCommonMethod {
    //根据value获取key的方法，常用
    public static List<Integer> myGetKey(HashMap<Integer,Integer> map, int value){
        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i).equals(value)){
                list.add(i);
            }
        }
        return list;
    }
    //想输出数组的方法，用于打印结果用，常用
    public static List<String> parse2DArray(int[][] array){
        List<String> list = new ArrayList<>();
        for(int[] arr : array){
            list.add(Arrays.toString(arr));
        }
        return list;
    }
    //计算最大公约数
    public static int gcd(int a,int b){
        if (b == 0){
            return a;
        }
        else {
            return gcd(b,a % b);
        }
    }
    //计算最大公倍数
    public static int lcm(int a,int b){
        return a * b / gcd(a,b);
    }
    //埃氏筛
    public static List<Integer> Eratosthenes(int n){
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            return res;
        }
        int[] aa = new int[n];
        aa[2] = 0;
        int k = 2,tt = 0;
        while(tt < n){
            for(int i = 1;i < aa.length;i++){//筛出非质数
                if(i % k == 0 && i != k){
                    aa[i] = 1;
                }
            }
            for(int i = 1;i < aa.length;i++){//将筛选后第一个数作为新的筛子
                if(i > k && aa[i] == 0){
                    k = i;
                    break;
                }
            }
            tt++;
        }
        for(int i = 1; i < aa.length;i++){
            if(aa[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
