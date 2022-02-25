package leetcode._537_复数乘法;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumberMultiply {
    static Pattern compile = Pattern.compile("(-?[0-9]+)\\+(-?[0-9]+)i");
    public String complexNumberMultiply(String num1, String num2) {
        Matcher matcher1 = compile.matcher(num1),matcher2 = compile.matcher(num2);
        int a=0,b=0,c=0,d=0;
        if (matcher1.find()){
            a=Integer.parseInt(matcher1.group(1));
            b=Integer.parseInt(matcher1.group(2));
        }
        if (matcher2.find()){
            c=Integer.parseInt(matcher2.group(1));
            d=Integer.parseInt(matcher2.group(2));
        }

        return String.format("%d+%di", (a*c-b*d), (b*c+a*d));
    }

    public static void main(String[] args) {
        ComplexNumberMultiply complexNumberMultiply = new ComplexNumberMultiply();
        System.out.println(complexNumberMultiply.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(complexNumberMultiply.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
