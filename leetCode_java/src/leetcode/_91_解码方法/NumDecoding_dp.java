package leetcode._91_解码方法;

import java.util.Arrays;
import java.util.Map;

public class NumDecoding_dp {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int []judgeArray=new int[s.length()+1];
        judgeArray[0]=1;
        judgeArray[1]=(s.length()==0||s.charAt(0)==0)?0:1;
        for (int i=2;i<judgeArray.length;i++){
            int value=0;
            //当前符号
            if (chars[i-1]!='0'){
                value+=judgeArray[i-1];
            }
            if (chars[i - 2] == '1' || chars[i - 2] == '2' && chars[i - 1] < '7'){
                value+=judgeArray[i-2];
            }
            judgeArray[i]=value;
        }
        return judgeArray[chars.length];
    }

    public int isAvaliable(char[] chars, int start, int end) {
        if (start == end ) {
            return 1;
        }
        if (start > end) {
            return 0;
        }
        int result= 0 ;
        //当前值
        if (chars[end-1]!='0'){
            result+=isAvaliable(chars, start, end - 1);
        }
        if (end-2>=0 && (chars[end-2]=='1' || (chars[end-2]=='2'&& (chars[end-1]<'7')))){
            result+=isAvaliable(chars, start, end - 2);
        }
        return  result ;
    }


    public static void main(String[] args) {
        Map<String, Integer> testMap = Map.of(
                "1", 1
                , "11", 2
                , "111", 3
                , "1111", 5
                , "11111", 8
                , "301", 0
                , "226", 3
        );

        NumDecoding_dp numDecoding = new NumDecoding_dp();
        testMap.keySet().stream()
                .map(key -> Map.entry(key, numDecoding.numDecodings(key)))
                .filter(entry -> !entry.getValue().equals(testMap.get(entry.getKey())))
                .forEach(System.out::println);
    }
}
