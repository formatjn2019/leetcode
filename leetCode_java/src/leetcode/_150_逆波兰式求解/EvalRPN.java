package leetcode._150_逆波兰式求解;

import java.util.ArrayDeque;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());

                case "-" -> stack.push(-stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());

                case "/" -> {
                    Integer later = stack.pop();
                    stack.push(stack.pop() / later);
                }

                default -> stack.push(Integer.parseInt(token));

            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        evalRPN.evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }
}
