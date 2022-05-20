package com.company;

// Java program to sort a stack using
// a auxiliary stack.

import java.util.*;

class SortStack {
    // This function return the sorted stack
    public static Stack<Integer> sortstack(Stack<Integer>
                                                   input) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while (!input.isEmpty()) {
            // pop() the top value from input stack and store it in temporary integer variable ‘value’.
            int value = input.pop();

            // While ‘temp’ stack is NOT empty AND ‘value’<top value in ‘temp’ stack
            // Pop the top value from the ‘temp’ stack and push it to ‘input’ stack.
            while (!tmpStack.isEmpty() && value < tmpStack.peek()) {
                input.push(tmpStack.pop());
            }

            // push value in temporary of stack
            tmpStack.push(value);
        }
        return tmpStack;
    }

    // Driver Code
    public static void main(String args[]) {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack
        Stack<Integer> tmpStack = sortstack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty()) {
            System.out.print(tmpStack.pop() + " ");
        }
    }
}

