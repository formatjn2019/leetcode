package leetcode._67_二进制求和;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sba = new StringBuilder(a);
        StringBuilder sbb = new StringBuilder(b);
        StringBuilder result = new StringBuilder();
        sba.reverse();
        sbb.reverse();
        boolean carry = false;
        for (int i = 0, count; i < sba.length() || i < sbb.length() || carry; i++) {
            count = 0;
            count += sba.length() > i ? sba.charAt(i) - '0' : 0;
            count += sbb.length() > i ? sbb.charAt(i) - '0' : 0;
            count += carry ? 1 : 0;
            carry = count > 1;
            result.append(count % 2);
        }
        result.reverse();
        return result.toString();
    }
}
