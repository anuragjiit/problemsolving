package com.linkedlist;

public class PalindromeLinkedList {
    int value;
    PalindromeLinkedList next;

    PalindromeLinkedList(int data){
        value = data;
    }

    public static void main(String[] args) {
        PalindromeLinkedList head = null;
        head = insert(1, 1, head);
        head = insert(2, 1, head);
        head = insert(3, 6, head);
        head = insert(4, 4,head);
        head = insert(5, 1,head);

 //       print(head);




//       for(int i=1; i<=1; i++){
//            part1 = part1.next;
//        }
//        part1.next= null;
  //      print(head);


        int nodeSize = counter(head);

        if(nodeSize==1) {
            System.out.println("Palindrome");
            System.exit(0);
        }
        if(nodeSize==2){
            if(head.value==head.next.value) {
                System.out.println("Palindrome");
                System.exit(0);
            } else {
                System.out.println("Not Palindrome");
                System.exit(0);
            }
        }

        PalindromeLinkedList part1  = head;
        PalindromeLinkedList part2 = null;


        int mid = nodeSize/2;
        if(nodeSize%2!=0){
            part2 = reverse(head, mid+1);
        }
        else {
            part2 = reverse(head, mid);
        }

        print(part1);
        System.out.println();
        print(part2);

        for(int i=1; i<=mid; i++){
            if(part1.value!=part2.value){
                System.out.println("Not Palindrome");
                System.exit(0);
            }
            part1=part1.next;
            part2=part2.next;
        }

        System.out.println("Palindrome");

    }

    public static PalindromeLinkedList insert(int position, int data, PalindromeLinkedList head){
        PalindromeLinkedList newNode = new PalindromeLinkedList(data);

        if(position==1){
            newNode.next=null;
            head = newNode;
        }
        else{
            PalindromeLinkedList temp = head;
            for(int i=1; i<position-1 && temp!=null; i++){
                temp = temp.next;
            }

            PalindromeLinkedList tempo = temp.next;
            temp.next= newNode;
            newNode.next = tempo;

        }
        return head;
    }

    public static PalindromeLinkedList reverse(PalindromeLinkedList head, int position){
        PalindromeLinkedList previous = null;
        PalindromeLinkedList current = head;
        PalindromeLinkedList next = null;

        for(int i=1; i<=position && current!=null; i++){
            current = current.next;
        }

        while (current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void print(PalindromeLinkedList head){
        PalindromeLinkedList temp = head;
        while(temp!=null){
            System.out.print(temp.value + "    ");
            temp = temp.next;
        }
    }

    public static int counter(PalindromeLinkedList head){
        int count=0;
        PalindromeLinkedList temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }


}
