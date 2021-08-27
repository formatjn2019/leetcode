package leetcode._13_罗马数字转整数;

public class RomanNumeralToInt_Array {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result=0;
        char []unitStr=new char[]{'M','D','C','L','X','V','I'};
        int []unit=new int[]{1000,500,100,50,10,5,1};
        for (int index=0,currUnit=0;index<chars.length;index++){
            while (unitStr[currUnit]!=chars[index]){
                currUnit++;
            }
            if (index+1<chars.length){
                if (currUnit-1>0 && chars[index+1]==unitStr[currUnit-2]){
                    result+=unit[currUnit-2]-unit[currUnit];
                    index++;
                    currUnit-=2;
                    continue;
                }else if (currUnit>0 && chars[index+1]==unitStr[currUnit-1]){
                    result+=unit[currUnit-1]-unit[currUnit--];
                    index++;
                    continue;
                }
            }
            result+=unit[currUnit];

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
        RomanNumeralToInt_Array romanNumeralToInt = new RomanNumeralToInt_Array();
        romanNumeralToInt.test("I",1);
        romanNumeralToInt.test("III",3);
        romanNumeralToInt.test("IV",4);
        romanNumeralToInt.test("IX",9);
        romanNumeralToInt.test("LVIII",58);
        romanNumeralToInt.test("MCMXCIV",1994);

    }
}
