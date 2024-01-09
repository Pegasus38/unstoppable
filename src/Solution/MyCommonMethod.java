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
}
