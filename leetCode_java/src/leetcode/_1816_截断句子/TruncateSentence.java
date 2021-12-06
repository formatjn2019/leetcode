package leetcode._1816_截断句子;

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        char[] chars = s.toCharArray();
        int endIndex = 0;
        for (int index=0; index < chars.length && k > 0; index++) {
            if (chars[index]==' ' ){
                endIndex=index;
                k--;
                //多个连续空格进行跳过
                //由于没有尾空格，不会造成索引错误
                while (index<chars.length && chars[index]==' '){
                    index++;
                }
            }else if (index==chars.length-1){
                endIndex=chars.length;
            }
        }
        return s.substring(0,endIndex);
    }

    public static void main(String[] args) {

    }
}
