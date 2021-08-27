package leetcode._30_串联所有单词的子串;

import leetcode.ListNode;

import java.util.*;

public class FindAllWordString_slidder {
    public List<Integer> findSubstring(String s, String[] words) {
        int []firstCharCounter=new int[26];
        char []indexs=new char[words.length];
        Map<Character,Set<Integer>> characterSetMap = new HashMap<>();
        //初始化首字母
        for (int i=0;i<words.length;i++){
            String word=words[i];
            firstCharCounter[word.charAt(0)-'a']++;
            Set<Integer> integers = characterSetMap.computeIfAbsent(word.charAt(0), k -> new HashSet<>());
            integers.add(i);
        }
        LinkedList<Integer> result=new LinkedList<>();
        int[] clone = firstCharCounter.clone();
        char[] chars = s.toCharArray();
        for (int i=0;i<=chars.length-words.length*words[0].length();i++){
            Arrays.fill(clone,0);
            Arrays.fill(indexs,' ');
            for (int j=i,k=0;j<chars.length;j+=words[0].length()){
                if (clone[chars[j]-'a']<firstCharCounter[chars[j]-'a']){
                    clone[chars[j]-'a']++;
                    indexs[k++]=chars[j];
                }else {
                    break;
                }
            }
            //首字母都获得了匹配
            if (indexs[indexs.length-1]!=' '){
                BitSet bs=new BitSet();
                boolean isMatch=true;
                int j=i;
                for (char index : indexs) {
                    System.out.println(index);
                    boolean innerMatched=false;
                    for (Integer integer : characterSetMap.get(index)) {
                        //当前索引未被使用 && 字符进行了匹配
                        if ((!bs.get(integer)&& s.substring(j,j+words[0].length()).equals(words[integer]))){
                            bs.set(integer,true);
                            j+=words[0].length();
                            innerMatched=true;
                            break;
                        }

                    }
                    //没有合适的匹配项
                    if (!innerMatched){
                        isMatch=false;
                        break;
                    }
                }
                if (isMatch){
                    result.add(i);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        FindAllWordString_slidder findAllWordString=new FindAllWordString_slidder();
        List<String> strs=new LinkedList<>();
        System.out.println(findAllWordString.findSubstring("bbcbcbca", new String[]{"cb","ca"}));
//        System.out.println(findAllWordString.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
//        System.out.println(findAllWordString.findSubstring("foobarfoobar", new String[]{"foo", "bar"}));
//        System.out.println(findAllWordString.findSubstring("aaaaaaaaaaaaaa", new String[]{"aa", "aa"}));
        System.out.println(strs);
    }
}
