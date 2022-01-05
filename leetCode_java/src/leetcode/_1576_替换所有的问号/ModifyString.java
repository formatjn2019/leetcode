package leetcode._1576_替换所有的问号;

public class ModifyString {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '?') {
                for (char nc = 'a'; nc <= 'z'; nc++) {
                    if (nc != chars[i - 1] && nc != chars[i + 1]) {
                        chars[i] = nc;
                        break;
                    }
                }
            }
        }
        if (chars[0] == '?') {
            chars[0] = chars.length > 1 &&chars[1]!='?'? (char) ((chars[1] - 'a' + 1) % 26 + 'a') : 'a';
        }
        if (chars[chars.length - 1] == '?') {
            chars[chars.length - 1] = chars.length > 1 ? (char) ((chars[chars.length - 2] - 'a' + 1) % 26 + 'a') : 'a';
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ModifyString modifyString = new ModifyString();
        System.out.println(modifyString.modifyString("??"));
        System.out.println(modifyString.modifyString("?zs"));
        System.out.println(modifyString.modifyString("ubv?w"));
        System.out.println(modifyString.modifyString("j?qg??b"));
        System.out.println(modifyString.modifyString("??yw?ipkj?"));
    }
}
