package com.company.codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

    }

    public int solution(String S) {
        //TODO:

        // main idea: use "Stack" (push and pop)

        //special case
        if (S.length() == 0)
            return 1;

        // new Stack<Character>()
        Deque<Character> stack = new ArrayDeque<>();

        // scan the string (just one pass)
        for (int i = 0; i < S.length(); i++) {
            // note: push "its pair"
            if (S.charAt(i) == '(') {
                stack.push(')');
            } else if (S.charAt(i) == '[') {
                stack.push(']');
            } else if (S.charAt(i) == '{') {
                stack.push('}');
            }
            // pop and check
            else if (S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}') {
                // important: check if the stack is empty or not (be careful)
                if (stack.isEmpty() == true) {
                    return 0;
                } else {
                    char temp = stack.pop(); // check if the stack is empty before pop!!!
                    if (temp != S.charAt(i)) { // not a pair
                        return 0;
                    }
                }
            }
        }
        // note: check if the stack is empty or not (be careful)
        if (!stack.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }
}
