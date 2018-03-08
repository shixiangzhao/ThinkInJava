package com.shixiang.think.collection;

public class StackCollection<T> {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < 10000000; i++) {
            for (String s : "My dog has fleas".split(" ")) {
                stack.push(s);
            }
            while (!stack.empty()) {
                stack.pop();
                //System.out.print(stack.pop() + " ");
            }
        }
        System.out.print("stack finish.");
        System.out.println();
        java.util.Stack<String> stack2 = new java.util.Stack<>();
        for (int i = 0; i < 10000000; i++) {
            for (String s : "My dog has fleas".split(" ")) {
                stack2.push(s);
            }
            while (!stack2.empty()) {
                stack2.pop();
                //System.out.print(stack2.pop() + " ");
            }
        }
        System.out.print("stack2 finish.");
    }
}
