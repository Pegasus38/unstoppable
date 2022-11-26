package myLeetCodeAnswer;

import java.util.ArrayList;
import java.util.List;

//leetcode NO.886 不通过，错了三遍，有点恶心，放弃了
public class possibleBipartition {
    public static void main(String[] args) {
        int n = 10;
        int[][] dislikes = {{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}};
        /*
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> index = new ArrayList<>();
        set1.add(dislikes[0][0]);
        set2.add(dislikes[0][1]);
        for(int i = 1;i < dislikes.length;i++){
            if(set1.contains(dislikes[i][0])){
                set2.add(dislikes[i][1]);
            }
            else if(set2.contains(dislikes[i][0])){
                set1.add(dislikes[i][1]);
            }
            else if(set1.contains(dislikes[i][1])){
                set2.add(dislikes[i][0]);
            }
            else if(set2.contains(dislikes[i][1])){
                set1.add(dislikes[i][0]);
            }
            else if(set1.contains(dislikes[i][0]) && set1.contains(dislikes[i][1])){
                System.out.println(false);
                break;
            }
            else if(set2.contains(dislikes[i][0]) && set2.contains(dislikes[i][1])){
                System.out.println(false);
                break;
            }
            else if(!set1.contains(dislikes[i][0]) && !set1.contains(dislikes[i][1]) && !set2.contains(dislikes[i][0]) && !set2.contains(dislikes[i][1])){
                index.add(i);
            }
        }
        if(set1.size()+set2.size() == n){
            System.out.println(true);
        }
        int length = index.size();
        while(!index.isEmpty()){
            set1.add(dislikes[index.get(0)][0]);
            set2.add(dislikes[index.get(0)][1]);
            List<Integer> toRemove = new ArrayList<>();
            for(int i = 1;i < index.size();i++){
                if(set1.contains(dislikes[index.get(i)][0]) && !set2.add(dislikes[index.get(i)][1])){
                    set2.add(dislikes[index.get(i)][1]);
                    toRemove.add(i);
                }
                else if(set2.contains(dislikes[index.get(i)][0]) && !set1.add(dislikes[index.get(i)][1])){
                    set1.add(dislikes[index.get(i)][1]);
                    toRemove.add(i);
                }
                else if(set1.contains(dislikes[index.get(i)][1]) && !set2.add(dislikes[index.get(i)][0])){
                    set2.add(dislikes[index.get(i)][0]);
                    toRemove.add(i);
                }
                else if(set2.contains(dislikes[index.get(i)][1]) && !set1.add(dislikes[index.get(i)][0])){
                    set1.add(dislikes[index.get(i)][0]);
                    toRemove.add(i);
                }
                else if(set1.contains(dislikes[index.get(i)][0]) && set1.contains(dislikes[index.get(i)][1])){
                    System.out.println(false);
                    break;
                }
                else if(set2.contains(dislikes[index.get(i)][0]) && set2.contains(dislikes[index.get(i)][1])){
                    System.out.println(false);
                    break;
                }
            }
            toRemove.sort(Comparator.reverseOrder());
            for(int i = 0;i < toRemove.size();i++){
                index.remove(toRemove.get(i));
            }
            if(length != index.size()){
                length = index.size();
            }
            else if(length == index.size()){
                break;
            }
        }
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(index);
        for(int i : set1){
            if(set2.contains(i)){
                System.out.println(false);
                break;
            }
        }

         */
        int[] color = new int[n+1];
        List<Integer>[] g = new List[n+1];
        for(int i = 0;i <= n;i++){
            g[i] = new ArrayList<>();
        }
        for(int[] p : dislikes){
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for(int i = 1;i <= n;++i){
            if(color[i] == 0 && !dfs(i,1,color,g)){
                System.out.println(false);
                break;
            }
        }
    }
    private static boolean dfs(int curNode,int nowColor,int[] color,List<Integer>[] g) {
        color[curNode] = nowColor;
        for(int nextNode : g[curNode]){
            if(color[nextNode] != 0 && color[nextNode] == color[curNode]){
                return false;
            }
            if(color[nextNode] == 0 && !dfs(nextNode,3^nowColor,color,g)){
                return false;
            }
        }
        return true;
    }
}
