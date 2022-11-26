package myLeetCodeAnswer;
//leetcode No.400 没有思路
//明天上班在研究一下
//最后写了出来，但是不是按照这个方法，写在了云笔记上
public class findNthDigit {
    public static void main(String[] args) {
        int n = 21474;
        int left = 1,right = 9;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(totalDigits(mid) < n){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        int d = left;
        int prevDigits = totalDigits(d-1);
        int index = n - prevDigits - 1;
        int start = (int)Math.pow(10,d-1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num/ (int)(Math.pow(10,d - digitIndex - 1))) % 10;
        System.out.println(digit);
    }
    private static int totalDigits(int length){
        int digits = 0,curLength = 1,curCount = 9;
        while(curLength <= length){
            digits += curLength * curCount;
            curLength++;
            curCount*=10;
        }
        return digits;
    }
}
