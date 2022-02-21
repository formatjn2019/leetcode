package leetcode._838_推多米诺;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int[] judge = new int[dominoes.length()];
        Map<Integer, Integer> extendDominoes = new HashMap<>();
        char[] chars = dominoes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                judge[i] = -1;
                extendDominoes.put(i, -1);
            } else if (chars[i] == 'R') {
                judge[i] = 1;
                extendDominoes.put(i, 1);
            }
        }
        while (extendDominoes.size() != 0) {
            HashMap<Integer, Integer> newLevel = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : extendDominoes.entrySet()) {
                if (entry.getValue() != 0) {
                    int index = entry.getKey() + entry.getValue();
                    if (index >= 0 && index < judge.length && judge[index] == 0) {
                        //倒地
                        newLevel.put(index, newLevel.getOrDefault(index, 0) + entry.getValue());
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : newLevel.entrySet()) {
                if (entry.getKey() >= 0 && entry.getKey() < judge.length) {
                    judge[entry.getKey()] = entry.getValue();
                }
            }
            extendDominoes = newLevel;
        }
        StringBuilder result = new StringBuilder();
        for (int i : judge) {
            switch (i) {
                case 0 -> result.append('.');
                case 1 -> result.append('R');
                default -> result.append('L');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        System.out.println(pushDominoes.pushDominoes("RR.L"));
        System.out.println(pushDominoes.pushDominoes(".L.R...LR..L.."));
    }
}
