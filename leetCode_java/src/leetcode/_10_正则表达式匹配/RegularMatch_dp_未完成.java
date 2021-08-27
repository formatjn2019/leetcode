package leetcode._10_正则表达式匹配;

public class RegularMatch_dp_未完成 {
    public boolean isMatch(String s, String p) {
        int ruleLength=0;
        //将规则转换成组
        char[] pChars = p.toCharArray();
        for (int index=0;index<p.length();index++){
            if (pChars[index]!='*'){
                pChars[ruleLength++]=pChars[index];
            }else if (pChars[index-1]!='.'){
                pChars[ruleLength-1]= (char) (pChars[ruleLength-1]-32);
            }else {
                pChars[ruleLength-1]='+';
            }
        }
        char []rules=new char[ruleLength];
        for (int i=0;i<rules.length;i++){
            rules[i]=pChars[i];
        }
        //卫语句
        if (s.length()==0){
            for (char c:rules){
                if (c >'Z'){
                    return false;
                }
            }
            return true;
        }
        char[] chars = s.toCharArray();
        boolean [][]judgeArray=new boolean[rules.length+1][chars.length+1];

        for (int j=0;j<Math.min(chars.length+1,2);j++){
            judgeArray[0][j]=true;
        }
        if (rules.length>0&& rules[0]<'a'){
            for (int i=0;i<judgeArray.length;i++){
                judgeArray[i][0]=true;
            }
        }

            for (int i=1;i<judgeArray.length;i++){
            for (int j=1;j<judgeArray[i].length;j++){
                if (judgeArray[i][j]){
                    continue;
                }
                char rule = rules[i-1];
                //固定字符
                if (rule == '.'){
                    judgeArray[i][j] = judgeArray[i-1][j-1];
                    if (i ==1)
                        break;
                }else if(rule <='z' && rule >='a'){
                    judgeArray[i][j] = judgeArray[i-1][j-1] && rule ==chars[j-1];
                    if (i ==1)
                        break;

                }//变长字符
                else if (rule == '+'){
                                            //匹配一个              //匹配空
                    judgeArray[i][j] = judgeArray[i-1][j-1]||judgeArray[i][j-1]||judgeArray[i-1][j];
//                    if(j==1){
//                        judgeArray[i][j]=true;
//                    }
                }else {
                        //匹配一个                                      //匹配空
                        judgeArray[i][j] = (judgeArray[i-1][j-1]||judgeArray[i][j-1])&& rule +32 ==chars[j-1]||judgeArray[i-1][j];
//                    if(j==1){
//                        judgeArray[i][j]=true;
//                    }
                }
            }
        }
//
//        for (boolean []line:judgeArray){
//            System.out.println(Arrays.toString(line));
//        }

        return judgeArray[judgeArray.length-1][judgeArray[0].length-1];

    }
    public boolean test(String s,String p,boolean expect){
        boolean match = isMatch(s, p);
        System.out.println(s+"\t|\t"+p+"\t|\t"+match);
        boolean result= expect==match;
        if (! result){
            System.out.println(s+"\t"+"\t"+"失败");
        }
        return result;
    }

    public static void main(String[] args) {
        RegularMatch_dp_未完成 rm=new RegularMatch_dp_未完成();
        System.out.println("\t\t\t结果："+rm.test("aa","a",false));
        System.out.println("\t\t\t结果："+rm.test("aa","a*",true));
        System.out.println("\t\t\t结果："+rm.test("ab",".*",true));
        System.out.println("\t\t\t结果："+rm.test("mississippi","mis*is*p*.",false));
        System.out.println("\t\t\t结果："+rm.test("aab","c*a*b",true));
        System.out.println("\t\t\t结果："+rm.test("","c*",true));
        System.out.println("\t\t\t结果："+rm.test("a","ab*",true));
        System.out.println("\t\t\t结果："+rm.test("aa","aaa",false));
        System.out.println("\t\t\t结果："+rm.test("mississippi","mis*is*ip*.",true));
        System.out.println("\t\t\t结果："+rm.test("ab",".*..",true));
        System.out.println("\t\t\t结果："+rm.test("a",".*..a",false));
    }
}
