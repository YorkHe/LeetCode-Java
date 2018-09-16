package N20_Valid_Parentheses;


import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>() ;

        if (s.length() == 1) return false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            char top = stack.peek();

            if (top == '(' && c == ')') {
                stack.pop();
                continue;
            }

            if (top == '[' && c == ']') {
                stack.pop();
                continue;
            }

            if (top == '{' && c == '}') {
                stack.pop();
                continue;
            }

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }

            return false;
        }

        if (stack.isEmpty()) return true;
        else return false;
    }
}
