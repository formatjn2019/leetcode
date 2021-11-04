package leetcode._367_有效的完全平方数;

public class IsPerfectSquare_api {
    public boolean isPerfectSquare(int num) {
        return Math.pow((int)Math.sqrt(num),2)==num;
    }
}
