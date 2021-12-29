package leetcode._472_连接词;

import leetcode.Tools;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class FindAllConcatenatedWordsInADict {
    static int MOD=131;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        Map<Long,List<String>> hashMemory=new HashMap<>();
        Arrays.sort(words,(w1,w2)->w1.length()-w2.length());
        Arrays.stream(words)
                .filter(wd->wd.length()>0)
                .filter(word->dfsSearch(hashMemory,word.toCharArray(),0,word.length()))
                .forEach(result::add);
        System.out.println(result.size());
        System.out.println(hashMemory.size());
        System.out.println(hashMemory);
        return result;
    }

    public boolean dfsSearch(Map<Long,List<String>> memory,char []chars,int start,int end){
        if (start>=chars.length){
            return true;
        }
        long cur=0,cur2=0;
        for (int i=start;i<end;i++){
            cur+=cur*MOD+chars[i]-'a'+127;
            //当前串被包含
            if (memory.containsKey(cur)){
                //子串也被单词包含
                if (dfsSearch(memory,chars,i+1,end)){
                    return true;
                }
            }
        }
        if (start==0){
            memory.computeIfAbsent(cur,_cur->new ArrayList<>()).add(new String(chars));
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        FindAllConcatenatedWordsInADict findAllConcatenatedWordsInADict = new FindAllConcatenatedWordsInADict();
//        findAllConcatenatedWordsInADict.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
        String[] words=Tools.readData(Paths.get("D:\\Documents\\GitHub\\leetcode\\leetCode_java\\src\\leetcode\\_472_连接词\\words.txt"));
        System.out.println(words.length);
        findAllConcatenatedWordsInADict.findAllConcatenatedWordsInADict(words);
    }
}
