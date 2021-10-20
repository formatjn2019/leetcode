package leetcode._139_单词拆分;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int [] minMax=new int[]{s.length(),1};
        Map<String, Boolean> judged = wordDict.stream()
                .peek(word->minMax[0]=Math.min(word.length(),minMax[0]))
                .peek(word->minMax[1]=Math.max(word.length(),minMax[1]))
                .collect(Collectors.toMap(k -> k, k -> true));
        return wordBreak(s,judged,minMax);
    }

    public boolean wordBreak(String s, Map<String,Boolean> judged,int []minMax){
        if (judged.containsKey(s)){
            return judged.get(s);
        }else if (s.length()==minMax[0]){
            judged.put(s,false);
        }
        else{
            for (int i=minMax[0];i<Math.min(minMax[1]+1,s.length());i++){
                String pre = s.substring(0,i);
                boolean prer = wordBreak(pre, judged, minMax);
                judged.put(pre,prer);
                if (prer){
                    String suf=s.substring(i);
                    boolean sufr = wordBreak(suf,judged,minMax);
                    judged.put(suf,sufr);
                    if (sufr){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "catsandog";
        List<String> wordDic=List.of("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak.wordBreak(s, wordDic));
    }
}
