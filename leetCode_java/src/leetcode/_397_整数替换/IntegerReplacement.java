package leetcode._397_整数替换;

public class IntegerReplacement {
    public int integerReplacement(int n) {
        int result=0;
        for (long temp=n;temp!=1;result++){
            if (temp%2==0){
                temp/=2;
            }else if (temp > 3 && (temp + 1) % 4 == 0) {
                temp+=1;
            } else {
                temp-=1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntegerReplacement integerReplacement = new IntegerReplacement();
//        IntStream.range(1,100)
//                .peek(i-> System.out.print(i+"\t"))
//                .map(integerReplacement::integerReplacement)
//                .forEach(System.out::println);

        System.out.println(integerReplacement.integerReplacement(11));
    }
}
