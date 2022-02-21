package leetcode._717_1比特与2比特字符;

public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        boolean pre = false;
        boolean result = false;
        for (int bit : bits) {
            result = false;
            //是否时两位数的后一位
            if (pre) {
                pre = false;
            }//是否新增两位数
            else if (bit == 0) {
                result = true;
            } else {
                pre = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IsOneBitCharacter isOneBitCharacter = new IsOneBitCharacter();
        isOneBitCharacter.isOneBitCharacter(new int[]{1, 0, 0});
        isOneBitCharacter.isOneBitCharacter(new int[]{1, 1, 1, 0});
    }
}
