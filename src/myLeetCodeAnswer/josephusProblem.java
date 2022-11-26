package myLeetCodeAnswer;
//剑指offer No.62 约瑟夫环 没学过 抄答案
public class josephusProblem {
    public static void main(String[] args) {
        //m是人数，n是第几个要干掉的人，res是要求的最后一个人的下表
        int m = 5,n = 3;
        int res = 0;
        for(int i = 2; i < m+1 ;++i){//剩余2个人的时候开始，倒推他的坐标
            res = (res + n) % i;//递推公式：假设剩1个人，他是安全的，他的坐标是0，剩2个人，坐标是（0+m)%2,剩3个人，坐标是((0+m)%2+m)%3...类推
        }
        System.out.println(res);
    }
}
