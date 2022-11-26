package myLeetCodeAnswer;
//leetcode No.1582 pass

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numSpecial {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0,1}, {1,0,0,0}, {0,1,0,0}};
        int count = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        boolean tag = true;
        for(int i = 0;i < list.size();i++){
            int a = list.get(i).get(0);
            int b = list.get(i).get(1);
            for(int j = 0 ; j < mat[0].length;j++){
                if(mat[a][j] == 1 && j != b){
                    tag = false;
                }
            }
            for(int k = 0 ; k < mat.length;k++){
                if(mat[k][b] == 1 && k != a){
                    tag = false;
                }
            }
            if(tag){
                count++;
            }
            tag = true;
        }
        System.out.println(count);
    }
}
