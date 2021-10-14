package leetcode._126_单词接龙II;

import java.util.*;
import java.util.stream.Collectors;

public class FindLadders_timeout {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //单词转子串
        Map<String, List<String>> wordToSubDic = new HashMap<>();
        wordList.stream()
                .map(this::createWordToSubDic)
                .forEach(wordToSubDic::putAll);
//        wordToSubDic.entrySet().stream()
//                .forEach(System.out::println);
        //子串转单词
        Map<String, List<String>> subToWordDic = new HashMap<>();
        wordToSubDic.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(value -> List.of(entry.getKey(), value)))
                .forEach(item -> subToWordDic.computeIfAbsent(item.get(1),i-> new ArrayList<>()).add(item.get(0)));
        //添加其实单词
        wordToSubDic.putAll(this.createWordToSubDic(beginWord));
//        System.out.println(subToWordDic);
        LinkedHashSet<String> passed = new LinkedHashSet<>();
        passed.add(beginWord);
        Map<Integer,List<List<String>>> results=new HashMap<>();
        searchResult(beginWord,0,passed,endWord,wordToSubDic,subToWordDic,results);
        for (int i=0;i< wordToSubDic.size();i++){
            if (results.containsKey(i)){
                return results.get(i).stream().distinct().collect(Collectors.toList());
            }
        }
        return List.of();
    }
    public void searchResult(String pre,int depth,LinkedHashSet<String> passed,String target,Map<String,List<String>> wordToSubDic,Map<String,List<String>> subToWordDic,Map<Integer,List<List<String>>> results){
        if (pre.equals(target)){
            results.computeIfAbsent(depth,dp->new LinkedList<>()).add(new LinkedList<>(passed));
            return;
        }
        for (String sub : wordToSubDic.get(pre)) {
            for (String word : subToWordDic.getOrDefault(sub,List.of())) {
                if (!passed.contains(word)){
                    LinkedHashSet<String> newPassed = new LinkedHashSet<>(passed);
                    newPassed.add(word);
                    searchResult(word,depth+1,newPassed,target,wordToSubDic,subToWordDic,results);
                }
            }
        }
    }

    public Map<String, List<String>> createWordToSubDic(String s) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(0, i) +" "+ s.substring(i + 1));
        }
        return Map.of(s, result);
    }

    public static void main(String[] args) {
        FindLadders_timeout findLadders = new FindLadders_timeout();
        System.out.println(findLadders.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(findLadders.findLadders("talk", "tail", List.of("talk","tons","fall","tail","gale","hall","negs")));

    }
}
