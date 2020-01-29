package stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     1.Open brackets must be closed by the same type of brackets.
 *     2.Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == '(' ||  c == '{' || c == '[') {
                stack.push(c);
            }else{
                // compare with top element of stack
                if(stack.empty()) {
                    return false;
                }

                char topChar = stack.pop();
                if(topChar == '(' && c != ')') {
                    return false;
                }
                if(topChar == '[' && c != ']') {
                    return false;
                }
                if(topChar == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
