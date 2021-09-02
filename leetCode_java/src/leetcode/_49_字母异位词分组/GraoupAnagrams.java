package leetcode._49_字母异位词分组;

import java.util.*;

public class GraoupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupMap=new HashMap<>();
        int [] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count,0);
            for (char c : str.toCharArray()) {
                count[c-'a']++;
            }
            groupMap.computeIfAbsent(Arrays.toString(count),_n->new LinkedList<>()).add(str);
        }
        return new ArrayList<>(groupMap.values());
    }
    public static void main(String[] args) {
        List<List<String>> lists = new GraoupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        lists.forEach(System.out::println);
    }
}
