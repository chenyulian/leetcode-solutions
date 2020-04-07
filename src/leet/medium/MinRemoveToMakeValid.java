package medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * leetcode 1249.Minimum Remove to Make Valid Parentheses
 */
public class MinRemoveToMakeValid {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexToRemove = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == ')') {
                if(stack.empty()) {
                    indexToRemove.add(i);
                }else{
                    stack.pop();
                }
            }else if(s.charAt(i) == '(') {
                stack.push(i);
            }
        }

        // when loop ends, if there exists elements in Stack, they should be removed
        while(!stack.empty()) {
            indexToRemove.add(stack.pop());
        }

        for(int i = 0; i < s.length(); i ++) {
            if(!indexToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        new MinRemoveToMakeValid().minRemoveToMakeValid("a)b(c)d");
    }
}
