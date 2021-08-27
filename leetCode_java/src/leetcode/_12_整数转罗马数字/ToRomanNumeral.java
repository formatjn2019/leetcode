package leetcode._12_整数转罗马数字;

public class ToRomanNumeral {
    public String intToRoman(int num) {
        int []unit=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []unitStr=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for (int cut=0;num>0;cut++){
            while (num>=unit[cut]){
                num-=unit[cut];
                sb.append(unitStr[cut]);
            }
        }
        return sb.toString();
    }
    public boolean test(int num,String expect){
        String result = intToRoman(num);
        boolean passed = expect.equals(result);
        if (!passed){
            System.out.println("失败");
            System.out.println(num);
            System.out.println("结果:"+result+"\t期望\t："+expect);
        }else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        ToRomanNumeral romanNumeral = new ToRomanNumeral();
        romanNumeral.test(1,"I");
        romanNumeral.test(3,"III");
        romanNumeral.test(4,"IV");
        romanNumeral.test(9,"IX");
        romanNumeral.test(58,"LVIII");
        romanNumeral.test(1994,"MCMXCIV");
    }
}
