package leetcode._131_分隔回文串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Partition {
    public List<List<String>> partition(String s) {
        return partition(s, new HashSet<>(), new HashSet<>());
    }

    public List<List<String>> partition(String s, Set<String> palindrome, Set<String> unPalindrome) {
        List<List<String>> result=new ArrayList<>();
        //如果自身为回文串，则添加自身
        if (isPalindrome(s,palindrome,unPalindrome)){
            result.add(List.of(s));
        }
        //添加所有的子节点的回文
        for (int i=1;i<s.length();i++){
            //如果0-i为回文数，则进行添加，否则跳出
            if (!isPalindrome(s.substring(0,i),palindrome,unPalindrome)){
                continue;
            }
            List<List<String>> left = List.of(List.of(s.substring(0,i)));
            List<List<String>> right = partition(s.substring(i), palindrome, unPalindrome);
            for (List<String> lItem : left) {
                for (List<String> rItem : right) {
                    ArrayList<String> item = new ArrayList<>(lItem);
                    item.addAll(rItem);
                    result.add(item);
                }
            }
        }
        return result;
    }
    //回文判断，记忆
    public boolean isPalindrome(String s, Set<String> palindrome, Set<String> unPalindrome) {
        if (s.length()==1){
            return true;
        }else if (unPalindrome.contains(s)){
            return false;
        }else if (palindrome.contains(s)){
            return true;
        }
        char[] chars = s.toCharArray();
        for (int lp = 0, rp = s.length() - 1; lp < rp; lp++, rp--) {
            if (chars[lp]!=chars[rp]){
                unPalindrome.add(s);
                return false;
            }
        }
        palindrome.add(s);
        return true;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        String s="abbab";
        List<List<String>> partition1 = partition.partition(s);
        AtomicInteger atomicInteger = new AtomicInteger();
        partition1.stream()
                .peek(i->atomicInteger.getAndIncrement())
                .distinct()
                .forEach(System.out::println);
        System.out.println(atomicInteger);
    }
}
