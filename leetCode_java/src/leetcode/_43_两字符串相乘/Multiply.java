package leetcode._43_两字符串相乘;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Stream;

public class Multiply {
    public String multiply(String num1, String num2) {
        //简化计算
        if (num1.length()==1){
            if (Integer.parseInt(num1)==0){
                return "0";
            }else if (Integer.parseInt(num1) == 1){
                return num2;
            }
        }
        if (num2.length()==1){
            if (Integer.parseInt(num2)==0){
                return "0";
            }else if (Integer.parseInt(num2) == 1){
                return num1;
            }
        }
        boolean resultFlag=true;
        if (num1.charAt(0)=='-'){
            resultFlag=!resultFlag;
            num1=num1.substring(1);
        }
        if (num2.charAt(0)=='-'){
            resultFlag=!resultFlag;
            num2=num2.substring(1);
        }
        //交换，小的后乘法
        if (num1.length()<num2.length()){
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        List<String> slice1 = slice(num1);
        List<String> slice2 = slice(num2);
        List<String> results=new LinkedList<>();
//        System.out.println(num1);
//        System.out.println(num2);
        for (int i=0;i<slice1.size();i++){
            for (int j=0;j<slice2.size();j++){
                String multiple = multiple(i*7+j*7, slice1.get(i), slice2.get(j));
                results.add(multiple);
            }
        }
//        System.out.println(results);
        String result=combine(results);
        if (!resultFlag){
            result="-"+result;
        }
        return result;
    }
    //切片，倒序
    public List<String>slice(String origin){
        List<String> result=new LinkedList<>();
        for (int i=origin.length();i>0;i-=7) {
            result.add(origin.substring(Math.max(0, i - 7), i));
        }
        return result;
    }
    //乘积，倒序
    public String multiple(int expand,String num1,String num2){
        StringBuilder sb=new StringBuilder();
        sb.append(Long.parseLong(num1)*Long.parseLong(num2));
        sb.append("0".repeat(Math.max(0, expand)));
        sb.reverse();
        return sb.toString();
    }
    public String combine(List<String> list){
        int max=0;
        for (String s : list) {
            max=Math.max(s.length(),max);
        }
        StringBuilder result=new StringBuilder();
        int sub=0;
        for (int index=0;index<max||sub!=0;index++){
            int sum=sub;
            for (String s : list) {
                if (index<s.length()){
                    sum+=s.charAt(index)-'0';
                }
            }
            result.append(sum%10);
            sub=sum/10;
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        String value1=Long.MAX_VALUE+"";
        String value2=Long.MAX_VALUE+"";
        System.out.println(multiply.multiply(value1, value2));
        BigDecimal bd1 =new BigDecimal(value1);
        BigDecimal multiply1 = bd1.multiply(new BigDecimal(value2));
        System.out.println(multiply1);

//        System.out.println("+++++++++++++++++++++");
//        System.out.println(multiply.combine(List.of("1122233","998877","445566")));
//        System.out.println("_________________");
//        int sum = Stream.of("1122233", "998877", "445566")
//                .map(StringBuilder::new)
//                .peek(StringBuilder::reverse)
//                .map(StringBuilder::toString)
//                .mapToInt(Integer::parseInt)
//                .sum();
//        System.out.println(sum);
//        List<String> slice = multiply.slice("" + Long.MAX_VALUE);
//        System.out.println(slice);
//        String multiple = multiply.multiple(10, 9999999 + "", 999999 + "");
//        System.out.println(multiple);
//
    }
}
