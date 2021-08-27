package leetcode._13_罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralToInt_map {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result=0;
        char []unitStr=new char[]{'M','D','C','L','X','V','I'};
        int []unit=new int[]{1000,500,100,50,10,5,1};
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<unitStr.length;i++){
            map.put(unitStr[i],unit[i]);
        }
        for (int index=0;index<chars.length;index++){
            if (index+1<chars.length && map.get(chars[index+1])>map.get(chars[index])){
                result+=-map.get(chars[index++])+map.get(chars[index]);
            }else {
                result+=map.get(chars[index]);
            }
        }
        return result;
    }
    public boolean test(String s,int expect){
        int result = romanToInt(s);
        boolean passed =result ==expect;
        if (!passed){
            System.out.println("失败");
            System.out.println(s);
            System.out.println("结果:"+result+"\t期望\t："+expect);
        }else {
            System.out.println("成功");
        }
        return passed;
    }
    public static void main(String[] args) {
        RomanNumeralToInt_map romanNumeralToInt = new RomanNumeralToInt_map();
        romanNumeralToInt.test("I",1);
        romanNumeralToInt.test("III",3);
        romanNumeralToInt.test("IV",4);
        romanNumeralToInt.test("IX",9);
        romanNumeralToInt.test("LVIII",58);
        romanNumeralToInt.test("MCMXCIV",1994);

    }
}
