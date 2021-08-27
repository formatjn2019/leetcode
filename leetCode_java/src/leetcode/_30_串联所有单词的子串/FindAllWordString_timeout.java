package leetcode._30_串联所有单词的子串;

import java.util.*;

public class FindAllWordString_timeout {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result= new LinkedList<>();
        Set<String> allConcat= new HashSet<>();
        concatAllStrings(words,allConcat,new boolean[words.length],"");
        for (String subStr : allConcat) {
            for (int start=0;start<s.length();start++){
                start=s.indexOf(subStr,start);
                System.out.println(start);
                if (start!=-1){
                    result.add(start);
                }else {
                    break;
                }
            }
        }
        return result;
    }

    public void concatAllStrings(String[] words,Set<String> result,boolean []flag,String medium){
        boolean changedflag=false;
        for (int i=0;i<flag.length;i++){
            if (flag[i]==false){
                flag[i] = true;
                concatAllStrings(words,result,flag,medium+words[i]);
                changedflag=true;
                flag[i]=false;
            }
        }
        if (!changedflag){
            result.add(medium);
        }
    }


    public static void main(String[] args) {
        FindAllWordString_timeout findAllWordString=new FindAllWordString_timeout();
        List<String> strs=new LinkedList<>();
//        findAllWordString.findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"});
//        System.out.println(findAllWordString.findSubstring("foobarfoobar", new String[]{"foo", "bar"}));
        System.out.println(findAllWordString.findSubstring("aaaaaaaaaaaaaa", new String[]{"aa", "aa"}));
        System.out.println(strs);
    }
}
