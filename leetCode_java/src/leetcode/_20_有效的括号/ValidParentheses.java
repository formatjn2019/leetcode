package leetcode._20_有效的括号;

import java.util.ArrayDeque;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack=new ArrayDeque<>();
        Map<Character, Character> charDic = Map.of('{','}','(',')','[',']');
        for (char c : s.toCharArray()) {
            if(charDic.containsKey(c)){
                stack.addFirst(c);
            }else {
                if (stack.size()==0 || charDic.get(stack.pop())!=c){
                    return false;
                }
            }
        }
        return stack.size()==0;
    }
    public boolean test(String digits, boolean expect){
        boolean result = isValid(digits);
        boolean passed=expect==result;

        if (!passed){
            System.out.println("失败");
            System.out.println(digits);
            System.out.println("结果:"+result+"\t期望\t："+expect);
        }else {
            System.out.println("成功");
        }
        return passed;
    }
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.test("",true);
        validParentheses.test("{}",true);
        validParentheses.test("[]()",true);
        validParentheses.test("{[]}",true);
        validParentheses.test("[{]}",false);
        validParentheses.test("[]}",false);
    }
}
