package leetcode._126_单词接龙II;

import java.util.*;
import java.util.stream.Collectors;

public class FindLadders_lfs_timeout {
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
                .forEach(item -> subToWordDic.computeIfAbsent(item.get(1), i -> new ArrayList<>()).add(item.get(0)));
        //添加其余单词
        wordToSubDic.putAll(this.createWordToSubDic(beginWord));
//        System.out.println(subToWordDic);
        LinkedHashSet<String> passed = new LinkedHashSet<>();
        passed.add(beginWord);

        return searchResult(endWord, wordToSubDic, subToWordDic, Map.of(beginWord, List.of(passed)));
    }

    public List<List<String>> searchResult(String target, Map<String, List<String>> wordToSubDic,
                                           Map<String, List<String>> subToWordDic, Map<String, List<LinkedHashSet<String>>> nextFloor) {
        if (nextFloor.keySet().size() == 0) {
            return List.of();
        } else if (nextFloor.containsKey(target)) {
            return nextFloor.get(target)
                    .stream()
                    .map(ArrayList::new)
                    .distinct()
                    .collect(Collectors.toList());
        } else {
            Map<String, List<LinkedHashSet<String>>> newNextFloor = new HashMap<>();
            //下一层
            for (String pre : nextFloor.keySet()) {
                //下一个单词
                for (String sub : wordToSubDic.get(pre)) {
                    for (String word : subToWordDic.getOrDefault(sub, List.of())) {

                        //是否增加进下一层
                        for (LinkedHashSet<String> passed : nextFloor.get(pre)) {
                            if (!passed.contains(word)) {
                                LinkedHashSet<String> newPassed = new LinkedHashSet<>(passed);
                                newPassed.add(word);
                                newNextFloor.computeIfAbsent(word, _w -> new ArrayList<>()).add(newPassed);
                            }
                        }
                    }
                }
            }
            return searchResult(target, wordToSubDic, subToWordDic, newNextFloor);
        }
    }

    public Map<String, List<String>> createWordToSubDic(String s) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(0, i) + " " + s.substring(i + 1));
        }
        return Map.of(s, result);
    }

    public static void main(String[] args) {
        FindLadders_lfs_timeout findLadders = new FindLadders_lfs_timeout();
        System.out.println(findLadders.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(findLadders.findLadders("talk", "tail", List.of("talk", "tons", "fall", "tail", "gale", "hall", "negs")));

    }
}
