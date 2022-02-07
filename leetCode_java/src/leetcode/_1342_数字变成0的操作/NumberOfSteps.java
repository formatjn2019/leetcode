package leetcode._1342_数字变成0的操作;

public class NumberOfSteps {
    public int numberOfSteps(int num) {
        if(num ==0){
            return 0;
        }else {
            return (num%2==0?numberOfSteps(num/2):numberOfSteps(num-1))+1;
        }
    }
}
