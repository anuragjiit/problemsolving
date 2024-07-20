package com.linkedlist;

public class SimpleLinkedListNode {
    int value;
    SimpleLinkedListNode next;

    SimpleLinkedListNode(int data){
        value = data;
    }

    static SimpleLinkedListNode head = null;

    public static void main(String[] args) {

        insert(1, 10);
        insert(2, 20);
        insert(3, 30);
        insert(4, 40);
        print();
        System.out.println();
        insert(2, 50);
        insert(1, 1);
        System.out.println("List After insertion ");
        print();
        delete(5);
        System.out.println();
        print();
    }

    public static void insert(int position, int data){
        SimpleLinkedListNode newNode = new SimpleLinkedListNode(data);
        if(position==1){
            newNode.next=head;
            head = newNode;
        } else {
            SimpleLinkedListNode temp = head;
            for(int i=1; i<position-1 && temp!=null; i++){
                temp = temp.next;
            }
            if(temp!=null){
                newNode.next = temp.next;
                temp.next= newNode;
            }
        }
    }

    public static void print(){
        SimpleLinkedListNode temp = head;
        while(temp.next!=null){
            System.out.print( temp.value + "   ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }

    public static void delete(int position){
        SimpleLinkedListNode temp = head;
        if(position==1){
            head = temp.next;
        } else {
            for(int i=1; i<position-1 && temp!=null; i++){
                temp = temp.next;
            }
            if(temp!=null && temp.next!=null){
                temp.next=temp.next.next;
            }
        }
    }

}
