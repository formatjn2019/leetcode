package leetcode._423_从英文中重建数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OrginalDigits {
    public String originalDigits(String s) {
        //统计将要解析的字符串中的全部字符
        Map<Character, AtomicInteger> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.computeIfAbsent(c, ch -> new AtomicInteger()).getAndIncrement();
        }
        int[] resultNums = new int[10];
        //通过 z w x 解析出 0,2,6
        //0
        if (charCount.containsKey('z')) {
            resultNums[0] = charCount.get('z').get();
            charCount.get('o').addAndGet(-resultNums[0]);
            charCount.get('r').addAndGet(-resultNums[0]);
        }
        //2
        if (charCount.containsKey('w')) {
            resultNums[2] = charCount.get('w').get();
            charCount.get('o').addAndGet(-resultNums[2]);
        }
        //6
        if (charCount.containsKey('x')) {
            resultNums[6] = charCount.get('x').get();
            charCount.get('s').addAndGet(-resultNums[6]);
            charCount.get('i').addAndGet(-resultNums[6]);
        }
        //7
        if (charCount.getOrDefault('s', new AtomicInteger()).get() > 0) {
            resultNums[7] = charCount.get('s').get();
            charCount.get('v').addAndGet(-resultNums[7]);
        }
        //5
        if (charCount.getOrDefault('v', new AtomicInteger()).get() > 0) {
            resultNums[5] = charCount.get('v').get();
            charCount.get('f').addAndGet(-resultNums[5]);
            charCount.get('i').addAndGet(-resultNums[5]);
        }
        //4
        if (charCount.getOrDefault('f', new AtomicInteger()).get() > 0) {
            resultNums[4] = charCount.get('f').get();
            charCount.get('o').addAndGet(-resultNums[4]);
            charCount.get('r').addAndGet(-resultNums[4]);
        }
        //1
        if (charCount.getOrDefault('o', new AtomicInteger()).get() > 0) {
            resultNums[1] = charCount.get('o').get();
        }
        List<Map<Character,String>> keyWord=List.of(
                Map.of('z',"zero"),
                Map.of('w',"two"),
                Map.of('x',"six"),
                Map.of('s',"seven"),
                Map.of('v',"five"),
                Map.of('f',"four"),
                Map.of('o',"one"),
                Map.of('r',"three"),
                Map.of('h',"eight"),
                Map.of('i',"nine")
        );
        //3
        if (charCount.getOrDefault('r', new AtomicInteger()).get() > 0) {
            resultNums[3] = charCount.get('r').get();
            charCount.get('h').addAndGet(-resultNums[3]);
        }
        //8
        if (charCount.getOrDefault('h', new AtomicInteger()).get() > 0) {
            resultNums[8] = charCount.get('h').get();
        }
        //8
        if (charCount.getOrDefault('i', new AtomicInteger()).get() > 0) {
            resultNums[9] = charCount.get('i').get();
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<10;i++){
            sb.append((""+i).repeat(resultNums[i]));
        }
        return sb.toString();
    }

    private Map<String, Map<Character, Integer>> parseWords(List<String> strings) {
        Map<String, Map<Character, Integer>> result = new HashMap<>();
        for (String string : strings) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : string.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
            result.put(string, charCount);
//            System.out.println(string);
//            System.out.println(charCount);
        }
        return result;
    }


    public static void main(String[] args) {
        OrginalDigits orginalDigits = new OrginalDigits();
        System.out.println(orginalDigits.originalDigits("owoztneoer"));
        System.out.println(orginalDigits.originalDigits("fviefuro"));
        System.out.println(orginalDigits.originalDigits("owoztneoerfviefuro"));
    }
}
