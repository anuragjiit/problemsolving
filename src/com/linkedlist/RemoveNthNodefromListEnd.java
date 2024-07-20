package com.linkedlist;

public class RemoveNthNodefromListEnd {

    int value;
    RemoveNthNodefromListEnd next;

    RemoveNthNodefromListEnd(int data){
        value = data;
    }

    static RemoveNthNodefromListEnd A = null;

    public static void main(String[] args) {
        insert(1, 10);
        insert(2, 20);
        insert(3, 30);
        insert(4, 40);
        print(A);
        System.out.println();

        int B = 2;

        int count = 0;
        RemoveNthNodefromListEnd head = A;
        while(head!=null){
            count++;
            head = head.next;
        }

        System.out.println(count);

        head = A;

        if(B>=count){
            A = head.next;
            print(A);
            System.exit(0);
        }

        int removeNode = count-B;
        for(int i=1; i<removeNode; i++){
            head = head.next;
        }

        RemoveNthNodefromListEnd nextNode = head.next;
        if(head.next.next==null){
            head.next = null;
        } else {
            head.next = head.next.next;
        }

        nextNode.next = null;

        print(A);
    }

    public static void insert(int position, int data){
        RemoveNthNodefromListEnd newNode = new RemoveNthNodefromListEnd(data);
        if(position==1){
            newNode.next=A;
            A = newNode;
        } else {
            RemoveNthNodefromListEnd temp = A;
            for(int i=1; i<position-1 && temp!=null; i++){
                temp = temp.next;
            }
            if(temp!=null){
                newNode.next = temp.next;
                temp.next= newNode;
            }
        }
    }

    public static void print(RemoveNthNodefromListEnd A){
        RemoveNthNodefromListEnd temp = A;
        while(temp.next!=null){
            System.out.print( temp.value + "   ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }
}
