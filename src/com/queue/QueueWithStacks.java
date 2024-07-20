package com.queue;

import java.util.Stack;

public class QueueWithStacks {
    public static Stack<Integer> enQueue;
    public static Stack<Integer> deQueue;

    QueueWithStacks(){
        enQueue = new Stack<>();
        deQueue = new Stack<>();
    }

    public static int pop(){
        if(!deQueue.isEmpty()) {
            return deQueue.pop();
        }
        else {
            while(!enQueue.isEmpty()){
                deQueue.push(enQueue.pop());
            }
            return deQueue.pop();
        }
    }

    public static int peek(){
        if(!deQueue.isEmpty()) {
            return deQueue.peek();
        }
        else {
            while(!enQueue.isEmpty()){
                deQueue.push(enQueue.pop());
            }
            return deQueue.peek();
        }
    }

    public static boolean empty(){
        return (enQueue.isEmpty() && deQueue.isEmpty());
    }

    public void push(int data){
        enQueue.push(data);
    }

    public static void main(String[] args) {
        QueueWithStacks obj = new QueueWithStacks();
        obj.push(1000);
        obj.push(1001);
        int param2 = obj.pop();
        int param3 = obj.peek();
        boolean param4 = obj.empty();

        System.out.println(param2);
        System.out.println(param3);
        System.out.println(param4);
    }
}
