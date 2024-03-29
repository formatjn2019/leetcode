package leetcode._140_单词拆分II;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int[] minMax = new int[]{s.length(), 1};
        wordDict.stream()
                .peek(word -> minMax[0] = Math.min(word.length(), minMax[0]))
                .forEach(word -> minMax[1] = Math.max(word.length(), minMax[1]));
        return new ArrayList<>(wordBreak(s, new HashSet<>(wordDict), new HashMap<>(), minMax));
    }

    public Set<String> wordBreak(String s, Set<String> wordDic, Map<String, Set<String>> judged, int[] minMax) {
        if (judged.containsKey(s)) {
            return judged.get(s);
        } else if (s.length() < minMax[0]) {
            judged.put(s, new HashSet<>());
            return new HashSet<>();
        } else {
            Set<String> result = new HashSet<>();
            if (wordDic.contains(s)) {
                result.add(s);
            }
            for (int i = minMax[0]; i < Math.min(s.length() - minMax[0], minMax[1]) + 1; i++) {
                String pre = s.substring(0, i);
                Set<String> prer = wordBreak(pre, wordDic, judged, minMax);
                judged.computeIfAbsent(pre, key -> new HashSet<>()).addAll(prer);
                if (prer.size() > 0) {
                    String suf = s.substring(i);
                    Set<String> sufr = wordBreak(suf, wordDic, judged, minMax);
                    judged.computeIfAbsent(pre, key -> new HashSet<>()).addAll(prer);
                    if (sufr.size() > 0) {
                        for (String s1 : prer) {
                            for (String s2 : sufr) {
                                result.add(s1 + " " + s2);
                            }
                        }
                    } else {
                        judged.put(suf, new HashSet<>());
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        System.out.println(wordBreakII.wordBreak("aaaaaaa", List.of("aaaa", "aa", "a")));
    }
}
