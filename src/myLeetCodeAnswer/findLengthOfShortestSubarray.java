package myLeetCodeAnswer;
//leetcode No.1574 不会做 明天上班看看题解
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class findLengthOfShortestSubarray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,4,2,3,5};
        List<Integer> list1 = new ArrayList<>();
        list1.add(arr[0]);
        for(int i = 1;i < arr.length;i++){
            if(arr[i] >= arr[i-1]){
                list1.add(arr[i]);
            }
            else break;
        }
        List<Integer> list2 = new ArrayList<>();
        list2.add(arr[arr.length-1]);
        for(int i = arr.length -2;i>=0;i--){
            if(arr[i] <= arr[i+1]){
                list2.add(arr[i]);
            }
            else break;
        }
        list2.sort(Comparator.naturalOrder());
        int res = 0;
        if(list1.size() == arr.length || list2.size() == arr.length){
            res = arr.length;
        }
        List<Integer> join = new ArrayList<>();
        join.addAll(list1);
        join.addAll(list2);
        System.out.println(join);
        Integer[] end = join.toArray(new Integer[0]);

        System.out.println(res);
    }
}
