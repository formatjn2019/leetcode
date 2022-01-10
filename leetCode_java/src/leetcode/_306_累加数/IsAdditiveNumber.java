package leetcode._306_累加数;

public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        //dfs搜索
        for (int i=1;i<=num.length()/2;i++){
            for (int j=i+1;j<=num.length()-Math.max(i,j-i);j++){
                //核查数字是否符合要求
                if (checkNum(j,Long.parseLong(num.substring(0,i)),Long.parseLong(num.substring(i,j)),num)){
                    return true;
                }
                //首位位0只判定一次
                if (num.charAt(i)=='0'){
                    break;
                }
            }
            //首位为0只判定0的情况
            if (num.charAt(0)=='0'){
                break;
            }
        }
        return false;
    }
    //检查数字是否合法
    public boolean checkNum(int start,long first,long second,String num){
        if (start==num.length()){
            return true;
        }else {
            long nNum=first+second;
            String nstr = Long.toString(nNum);
            return nstr.equals(num.substring(start, Math.min(start + nstr.length(),num.length()))) && checkNum(start+nstr.length(),second,nNum,num);
        }
    }

    public static void main(String[] args) {
        IsAdditiveNumber isAdditiveNumber = new IsAdditiveNumber();
        System.out.println(isAdditiveNumber.isAdditiveNumber("12122436"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("0235813"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("000"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("123"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("101"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("112358"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("199100199"));
    }
}
