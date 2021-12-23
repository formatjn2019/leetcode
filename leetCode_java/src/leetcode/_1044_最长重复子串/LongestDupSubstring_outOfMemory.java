package leetcode._1044_最长重复子串;

import leetcode.Tools;

public class LongestDupSubstring_outOfMemory {
    public String longestDupSubstring(String s) {
        char[] chars = s.toCharArray();
        int [][]matrix = new int[chars.length][chars.length];
        //矩阵填充
        for (int i=0;i<chars.length;i++){
            for (int j=0;j<i;j++){
                if (chars[i]==chars[j]) {
                    matrix[i][j]=1;
                }
            }
        }
        Tools.showMatrixWithAxis(matrix,chars,chars,false);
        int maxLenth=0,start=0;
        //对斜线进行搜索
        for (int lastStart=1;lastStart< matrix.length;lastStart++){
            for (int offset=0,count=0;offset+lastStart<matrix.length;offset++){
                if (matrix[lastStart+offset][offset]==1){
                    count++;
                    if (count>maxLenth){
                        maxLenth=count;
                        System.out.println(lastStart +"\t"+(offset-maxLenth+1));
                        start=offset-maxLenth+1;
                    }
                }else {
                    count=0;
                }
            }
        }
        return s.substring(start,start+maxLenth);
    }

    public static void main(String[] args) {
        LongestDupSubstring_outOfMemory longestDupSubstring = new LongestDupSubstring_outOfMemory();
        longestDupSubstring.longestDupSubstring("abcabcdeabcd");
        longestDupSubstring.longestDupSubstring("banana");
        longestDupSubstring.longestDupSubstring("abcd");
        longestDupSubstring.longestDupSubstring("ababacaba");
    }
}
