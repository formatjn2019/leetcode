package leetcode._89_格雷编码;

import java.util.LinkedList;
import java.util.List;

public class GaryCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new LinkedList<>();
        for (int i=0;i<Math.pow(2,n);i++){
            result.add(i^i>>1);
        }
        return result;
    }



    public static void main(String[] args) {
        GaryCode garyCode = new GaryCode();
        System.out.println(garyCode.grayCode(3));
    }
}
