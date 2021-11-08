package leetcode._299_猜数字游戏;

import java.util.Arrays;

public class GetHint {
    public String getHint(String secret, String guess) {
        int bulls=0,cows=0;
        int []numCountScret=new int[10];
        int []numCountGuess=new int[10];
        char[] secretChar = secret.toCharArray();
        char[] guessChar = guess.toCharArray();
        for (int i=0;i<secretChar.length;i++){
            if (secretChar[i]==guessChar[i]){
                bulls++;
            }else {
                numCountGuess[guessChar[i]-'0']++;
                numCountScret[secretChar[i]-'0']++;
            }
        }
        for (int i=0;i<10;i++){
            cows+=Math.min(numCountGuess[i],numCountScret[i]);
        }
//        System.out.println(Arrays.toString(numCountGuess));
//        System.out.println(Arrays.toString(numCountScret));
        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {
        GetHint getHint = new GetHint();
        System.out.println(getHint.getHint("1807", "7810"));
    }
}
