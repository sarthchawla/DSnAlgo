package com.company;

import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String parens = "{}{()}";
        try {
            System.out.println(matchParanes(parens));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static boolean matchParanes(String parens) throws Exception {
        Stack<Character> stack = new Stack<>();

        for (char c : parens.toCharArray()) {
            if (c == '(' || c == '{') { // step 1:
                stack.push(c);
            } else if (c == ')') { // step 2:
                try {
                    char t = stack.pop();
                    if (t != '(') {
                        return false;
                    }
                } catch (EmptyStackException e) {
                    return false;
                }
            } else if (c == '}') { // step 2:
                try {
                    char t = stack.pop();
                    if (t != '{') {
                        return false;
                    }
                } catch (EmptyStackException e) {
                    return false;
                }
            } else {
                throw new Exception("Unexpected character" + c);
            }
        }

        return stack.isEmpty(); // step 3:
    }

}

