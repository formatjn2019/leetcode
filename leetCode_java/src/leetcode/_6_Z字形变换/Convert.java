package leetcode._6_Z字形变换;

public class Convert {
    public String convert(String s, int numRows) {
        //数组长度
//        System.out.println(s.length());
        if (numRows == 1) {
            return s;
        }
        int fullRow = (s.length() / (2 * numRows - 2) + 1) * 2;
        int arrLenth = (s.length() - fullRow * (2 * numRows - 2) > 0 ? 1 : 0) + fullRow;
//        System.out.println(arrLenth);
        char[][] arrs = new char[arrLenth][numRows];
        int index = 0;
        for (int i = 0; i < arrLenth; i++) {
            //下方向
            if (i % 2 == 0) {
                for (int j = numRows - 1; j >= 0; j--) {
                    arrs[i][j] = arrs[i][j] = index < s.length() ? s.charAt(index++) : '\0';
                }
            }
            //上方向
            else {
                for (int j = 1; j < numRows - 1; j++) {
                    arrs[i][j] = arrs[i][j] = index < s.length() ? s.charAt(index++) : '\0';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = numRows - 1; j >= 0; j--) {
            for (int i = 0; i < arrLenth; i++) {
                if (arrs[i][j] != '\0') {
                    sb.append(arrs[i][j]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(arrs));
        return sb.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        String paypalishiring = convert.convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
        System.out.println(paypalishiring.equals("PAHNAPLSIIGYIR"));
        paypalishiring = convert.convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);
        System.out.println(paypalishiring.equals("PINALSIGYAHRPI"));

        paypalishiring = convert.convert("ABCDE", 4);
        System.out.println(paypalishiring);
        System.out.println(paypalishiring.equals("ABCED"));
    }
}
