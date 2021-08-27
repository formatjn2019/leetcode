package leetcode._10_正则表达式匹配;

public class RegularMatch_recursion_not_greedy {
    public boolean isMatch(String s, String p) {
        int ruleLength=0;
        //将规则转换成组
        char[] chars = p.toCharArray();
        for (int index=0;index<p.length();index++){
            if (chars[index]!='*'){
                chars[ruleLength++]=chars[index];
            }else if (chars[index-1]!='.'){
                chars[ruleLength-1]= (char) (chars[ruleLength-1]-32);
            }else {
                chars[ruleLength-1]='+';
            }
        }
        char []rules=new char[ruleLength];
        for (int i=0;i<rules.length;i++){
            rules[i]=chars[i];
        }

        return isInRule(s.toCharArray(),rules,0,0);
    }
    private boolean isInRule(char[] chars,char []rules,int searchIndex,int ruleIndex){
        if (searchIndex==chars.length && ruleIndex == rules.length){
            return true;
        }
        if (ruleIndex == rules.length){
            return false;
        }
        //卫语句，防止指针越界
        if (searchIndex ==chars.length){
            for (int i=ruleIndex;i<rules.length;i++){
                char c = rules[i];
                if (c =='.' ||(c<='z'&&c>='a') ){
                    return false;
                }
            }
            return true;
        }
        char rule = rules[ruleIndex];
        //固定大小
        if (rule == '.'){
            return isInRule(chars,rules,searchIndex+1,ruleIndex+1);
        }else if(rule <='z' && rule >='a'){
            if (rule==chars[searchIndex]){
                return isInRule(chars,rules,searchIndex+1,ruleIndex+1);
            }else {
                return false;
            }
        }
        //非固定大小
        else if (rule =='+'){
            //不匹配 || 匹配一个 || 匹配多个
            return isInRule(chars,rules,searchIndex,ruleIndex+1) ||
                    isInRule(chars,rules,searchIndex+1,ruleIndex+1) ||
                    isInRule(chars,rules,searchIndex+1,ruleIndex);
        }//默认没有破坏规则的输入
        else {
            //不匹配 || 匹配一个 || 匹配多个
            return isInRule(chars,rules,searchIndex,ruleIndex+1) ||
                    (rule + 32 == chars[searchIndex] && isInRule(chars, rules, searchIndex + 1, ruleIndex + 1)) ||
                    (rule + 32 == chars[searchIndex] && isInRule(chars, rules, searchIndex + 1, ruleIndex));
        }
    }

    public boolean test(String s,String p,boolean expect){
        boolean match = isMatch(s, p);
        System.out.println(s+"\t|\t"+p+"\t|\t"+match);
        return expect==match;
    }

    public static void main(String[] args) {
        RegularMatch_recursion_not_greedy rm=new RegularMatch_recursion_not_greedy();
        System.out.println("\t\t\t结果："+rm.test("aa","a",false));
        System.out.println("\t\t\t结果："+rm.test("aa","a*",true));
        System.out.println("\t\t\t结果："+rm.test("ab",".*",true));
        System.out.println("\t\t\t结果："+rm.test("mississippi","mis*is*p*.",false));
        System.out.println("\t\t\t结果："+rm.test("aab","c*a*b",true));
        System.out.println("\t\t\t结果："+rm.test("","c*",true));
        System.out.println("\t\t\t结果："+rm.test("a","ab*",true));
        System.out.println("\t\t\t结果："+rm.test("aa","aaa",false));
    }
}
