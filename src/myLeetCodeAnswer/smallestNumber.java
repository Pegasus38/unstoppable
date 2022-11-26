package myLeetCodeAnswer;
//leetcode No.2165 pass
import java.util.Arrays;
import java.util.Collections;

public class smallestNumber {
    public static void main(String[] args) {
        long num = -2;
        long abs = Math.abs(num);
        long res = 0;
        if(num > 10) {
            Long a = abs;
            String b = a.toString();
            long[] c = new long[b.length()];
            for (int i = 0; i < c.length; i++) {
                c[i] = Long.parseLong(b.charAt(i) + "");
            }
            Arrays.sort(c);
            long tag = 0, temp = 0;
            if(c[(int)tag] == 0) {
                while (c[(int) tag] == 0) {
                    tag++;
                }
                temp = c[(int) tag];
                c[0] = temp;
                c[(int) tag] = 0;
            }
            StringBuilder sb = new StringBuilder();
            for (long i : c) {
                sb.append(i);
            }
            res = Long.parseLong(sb.toString());
        }
        else if(num > -10 && num < 10){
            res = num;
        }
        else{
            Long a = abs;
            String b = a.toString();
            Long[] c = new Long[b.length()];
            for (int i = 0; i < c.length; i++) {
                c[i] = Long.parseLong(b.charAt(i) + "");
            }
            Arrays.sort(c, Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for(long i : c){
                sb.append(i);
            }
            res = -1 * Long.parseLong(sb.toString());
        }
        System.out.println(res);
    }
}
