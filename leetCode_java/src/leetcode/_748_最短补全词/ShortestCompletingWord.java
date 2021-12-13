package leetcode._748_最短补全词;

import java.util.Arrays;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        //字符串预处理
        licensePlate = licensePlate.toLowerCase().replaceAll("[^a-z]", "");
//        System.out.println(licensePlate);
        String result = null;
        int resultLenth=Integer.MAX_VALUE;
        int[] expectCharCount = new int[26], tempCharCount = new int[26];
        countCharacters(licensePlate,expectCharCount);
        for (String word : words) {
            //剪枝，无效结果剔除
            if (word.length()>=resultLenth){
                continue;
            }
            countCharacters(word,tempCharCount);
            boolean canComplete=true;
            for (int i=0;i<26;i++){
                if (tempCharCount[i]<expectCharCount[i]){
                    canComplete=false;
                    break;
                }
            }
            if (canComplete){
                result=word;
                resultLenth=word.length();
            }
        }
        return result;
    }

    private void countCharacters(String s, int[] countArr) {
        Arrays.fill(countArr, 0);
        for (char c : s.toCharArray()) {
            countArr[c - 'a']++;
        }
    }

    public static void main(String[] args) {
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        System.out.println(shortestCompletingWord.shortestCompletingWord("OgEu755",
                new String[]{"enough","these","play","wide","wonder","box","arrive","money","tax","thus"}));
    }
}
