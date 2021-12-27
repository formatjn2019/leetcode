package leetcode._825_适龄的朋友;

public class NumFriendRequests_timeout {
    public int numFriendRequests(int[] ages) {
        int result = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (judge(ages[i], ages[j])) {
                    System.out.println(ages[i]+"->"+ages[j]);
                    result++;
                }
                if (judge(ages[j], ages[i])) {
                    System.out.println(ages[j]+"->"+ages[i]);
                    result++;
                }
            }
        }
        return result;
    }

    private boolean judge(int x, int y) {
        return !(y <= 0.5 * x + 7 || y > x);
    }

    public static void main(String[] args) {
        NumFriendRequests_timeout numFriendRequests = new NumFriendRequests_timeout();
        System.out.println(numFriendRequests.numFriendRequests(new int[]{16, 16}));
        System.out.println(numFriendRequests.numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(numFriendRequests.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }
}
