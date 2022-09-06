package DailyPractice.Day05;
//https://www.nowcoder.com/questionTerminal/54275ddae22f475981afa2244dd448c6

import java.util.Stack;

public class ImplementQueuesWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.size() == 1) {
            return stack1.pop();
        }
        Integer temp = 0;
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        temp = stack1.pop();
//        for (int i = 0; i < stack1.size(); i++) {
//            if (i == stack1.size() - 1){
//                temp = stack1.pop();
//            }else {
//                stack2.push(stack1.pop());
//            }
//        }

        for (int i = 0; i < stack2.size(); i++) {
            stack1.push(stack2.pop());
        }
        return temp;
    }
}

class Main {
    public static void main(String[] args) {
        ImplementQueuesWithTwoStacks iqwts = new ImplementQueuesWithTwoStacks();
        iqwts.push(1);
        iqwts.push(2);
        System.out.println(iqwts.pop());
        System.out.println(iqwts.pop());
    }
}
