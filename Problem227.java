import java.util.*;

public class Problem227 {
    public int calculate(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < s.length()) {
            int num = 0, result=0, sign=1;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + Character.getNumericValue(s.charAt(i));
                i++;
            }
            if (num > 0) { stack.push(num); }
            i--;
            if (s.charAt(i) == '+') {
                result += stack.pop() * sign;
                sign = 1;

            } else if (s.charAt(i) == '-') {

                sign = -1;
            }

        }
        System.out.println(stack);
        return 0;
    }
    public static void main(String[] args){
        Problem227 p = new Problem227();
        p.calculate("400+600+(900+1000)");

    }
}
