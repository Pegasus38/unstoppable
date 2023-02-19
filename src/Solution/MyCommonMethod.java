package Solution;

import java.util.ArrayList;
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
    public static List<Integer> myArrayToList(int [] arr){
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }
        return list;
    }
}
