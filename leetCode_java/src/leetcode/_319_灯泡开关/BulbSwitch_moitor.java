package leetcode._319_灯泡开关;

import java.util.stream.IntStream;

public class BulbSwitch_moitor {
    public int bulbSwitch(int n) {
        boolean[] judgeArray = new boolean[n+1];
        for (int i=1;i<=n;i++){
            if (i%2==0){
                judgeArray[i]=true;
            }
        }
        for (int i=3;i<=n;i++){
            for (int j=i;j<=n;j+=i){
                judgeArray[j]=!judgeArray[j];
            }
        }
        int result=0;
        for (int i=1;i<=n;i++){
            if (!judgeArray[i]){
                result++;
            }
        }
        System.out.println(Math.sqrt(n));
        return result;
    }

    public static void main(String[] args) {
        BulbSwitch_moitor bulbSwitch = new BulbSwitch_moitor();
        IntStream.range(1,100)
                .peek(i-> System.out.print(i+"\t"))
                .map(bulbSwitch::bulbSwitch)
                .forEach(System.out::println);
    }
}
