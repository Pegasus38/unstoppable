package myLeetCodeAnswer;
//leetcode No.1694 pass
public class reformatNumber {
    public static void main(String[] args) {
        String number = "789-0469-2731-5107289";
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < number.length();i++){
            if(number.charAt(i) != '-' && number.charAt(i) != ' '){
                sb.append(number.charAt(i));
            }
        }
        String temp = sb.toString();
        System.out.println(temp);
        int length = temp.length();
        int mod = length % 3;
        String res = "";
        int time = length / 3;
        if(mod == 0){//余数为0，说明没有余数，能被3平均分
            for(int i = 0;i < (time - 1);i++){
                sb.insert(4*(i+1) - 1,'-');
            }
            System.out.println(sb);
        }
        else if(mod == 1){
            if(time == 1){
                sb.insert(2,'-');
            }
            else if(time > 1){
                for(int i = 0;i < (time-1);i++){
                    sb.insert(4*(i+1) - 1,'-');
                }
                sb.insert(sb.length()-2,'-');
            }
            System.out.println(sb);
        }
        else if(mod == 2){
            for(int i = 0;i < time;i++){
                sb.insert(4*(i+1) - 1,'-');
            }
            System.out.println(sb);
        }
    }
}
