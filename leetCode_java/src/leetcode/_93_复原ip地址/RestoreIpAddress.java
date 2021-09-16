package leetcode._93_复原ip地址;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        appendItem(s, new ArrayList<>(), result);
        return result;
    }

    public void appendItem(String subStr, List<String> item, List<String> results) {
        if ("".equals(subStr) && item.size() == 4) {
            results.add(String.join(".", item));
            return;
        } else if ("".equals(subStr) || item.size() >= 4) {
            return;
        }
        if (subStr.charAt(0) == '0') {
            ArrayList<String> strings = new ArrayList<>(item);
            strings.add("0");
            appendItem(subStr.substring(1), strings, results);
        } else {
            for (int i = 1; i <= Math.min(3,subStr.length()); i++) {
                if (Integer.parseInt(subStr.substring(0, i)) < 256) {
                    ArrayList<String> strings = new ArrayList<>(item);
                    strings.add(subStr.substring(0, i));
                    appendItem(subStr.substring(i), strings, results);
                }
            }
        }
    }


    public static void main(String[] args) {
        RestoreIpAddress restoreIpAddress = new RestoreIpAddress();
        List<String> strings = List.of(
                "25525511135"
                ,"1111"
                ,"0000"
                ,"010010"
                ,"101023"
        );
        strings.stream()
                .map(restoreIpAddress::restoreIpAddresses)
                .forEach(System.out::println);
    }
}
