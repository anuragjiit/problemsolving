/*
Problem Description

Given a linked list A, swap every two adjacent nodes and return its head.

NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.



Problem Constraints

1 <= |A| <= 10^6



Input Format

The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = 1 -> 2 -> 3 -> 4

Input 2:

 A = 7 -> 2 -> 1



Example Output

Output 1:

 2 -> 1 -> 4 -> 3

Output 2:

 2 -> 7 -> 1



Example Explanation

Explanation 1:

 In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3

Explanation 2:

 In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped.
 */
package com.linkedlist;

public class SwapTwoNodes {

    int value;
    SwapTwoNodes next;

    SwapTwoNodes(int data){
        value = data;
    }

    public static void main(String[] args) {

        SwapTwoNodes head = null;
        head = insert(1, 10, head);
        head = insert(2, 4, head);
        head = insert(3, 50, head);
        head = insert(4, 40, head);
        head = insert(5, 4, head);
        head = insert(6, 5, head);

        print(head);


        SwapTwoNodes first = head;
        SwapTwoNodes current = head;

        if(current!=null && current.next!=null){
            current = current.next.next;
            head = first.next;
            head.next = first;
            first.next = current;
        }

        while(current!=null && current.next!=null){
            SwapTwoNodes temp1 = current;
            SwapTwoNodes temp2 = current.next;
            current = current.next.next;
            first.next = temp2;
            temp2.next = temp1;
            temp1.next = current;
            first = temp1;
        }

        System.out.println();
        print(head);

    }

    public static SwapTwoNodes insert(int position, int data, SwapTwoNodes head){
        SwapTwoNodes newNode = new SwapTwoNodes(data);
        if(position==1){
            newNode.next=head;
            head = newNode;
        } else {
            SwapTwoNodes temp = head;
            for(int i=1; i<position-1 && temp!=null; i++){
                temp = temp.next;
            }
            if(temp!=null){
                newNode.next = temp.next;
                temp.next= newNode;
            }
        }
        return head;
    }

    public static void print(SwapTwoNodes head){
        SwapTwoNodes temp = head;
        while(temp.next!=null){
            System.out.print( temp.value + "   ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }
}
