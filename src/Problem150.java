package src;

import java.util.*;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        Set<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('/');
        operators.add('*');

        int len = tokens.length;
        int i=0;

        while(i < len) {
            String curToken =  tokens[i];
            if (isDigit(curToken) && !operators.contains(curToken)) {
                operands.push(Integer.parseInt(curToken));
            } else {
                int result=0;
                int num2 = operands.pop();
                int num1 = operands.pop();

                if (curToken.equals("+")) {
                    result += (num1 + num2);
                } else if (curToken.equals("-")) {
                    result += (num1 - num2);
                } else if (curToken.equals("*")) {
                    result += (num1 * num2);
                } else {
                    result += (num1 / num2);
                }
                operands.push(result);
            }
            i++;
        }
        return operands.pop();
    }

    public boolean isDigit(String str) {
        try {
            int num = Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Problem150 obj = new Problem150();
        String[] tokens = new String[]{"1","2","+","3","*","4","-"};

        System.out.println(obj.evalRPN(tokens));
    }
}
