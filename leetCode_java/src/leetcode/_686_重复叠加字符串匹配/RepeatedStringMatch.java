package leetcode._686_重复叠加字符串匹配;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b){
        //卫语句
        //a包含b，直接返回1
        if (a.contains(b)){
            return 1;
        }
        //正则分组，不等于a的开头，等于a的n次重复的终端，不等于a的结尾
        Pattern compile = Pattern.compile("^(.*?)((?:"+a+")+)(.*?)$");
        Matcher matcher = compile.matcher(b);
        //如果能匹配到值，进行判定
        if (matcher.find()){
            int result=0;
            //开头情况判定，正则
            if (!matcher.group(1).equals("")){
                if (Pattern.compile(matcher.group(1) + "$").matcher(a).find()) {
                    result++;
                }else {
                    return -1;
                }
            }
            //中间情况判定
            if (!matcher.group(3).equals("")){
                if (Pattern.compile("^"+matcher.group(3)).matcher(a).find()) {
                    result++;
                }else {
                    return -1;
                }
            }
            //结尾情况判定
            if (matcher.group(2)!=null && matcher.group(2).length()>0){
                result+=matcher.group(2).length()/a.length();
            }
            return result;
        }else {
            //匹配不到，有可能b不能被a拆分，但两个a首尾相接能包含b
            return  ((a+a).contains(b))?2:-1;
        }
    }

    public static void main(String[] args) {
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
//        System.out.println(repeatedStringMatch.repeatedStringMatch("abcd", "cdabcdab"));
//        System.out.println(repeatedStringMatch.repeatedStringMatch("a", "aa"));
//        System.out.println(repeatedStringMatch.repeatedStringMatch("a", "a"));
//        System.out.println(repeatedStringMatch.repeatedStringMatch("abc", "wxyz"));
//        System.out.println(repeatedStringMatch.repeatedStringMatch("abc", "cabcabca"));
//        System.out.println(repeatedStringMatch.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab","ba"));
//        System.out.println(repeatedStringMatch.repeatedStringMatch("xxxx","33abcdb33"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("aa", "a"));

    }
}
