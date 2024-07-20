/*
Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An

reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …

You must do this in-place without altering the nodes' values.



Problem Constraints

1 <= |A| <= 10^6



Input Format

The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]

Input 2:

 A = [1, 2, 3, 4]



Example Output

Output 1:

 [1, 5, 2, 4, 3]

Output 2:

 [1, 4, 2, 3]



Example Explanation

Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].

Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].

 */
package com.linkedlist;

public class RecorderList {
    int value;
    RecorderList next;

    RecorderList(int data){
        value = data;
    }
    public static void main(String[] args) {
        RecorderList head = null;

        head = insert(1, 1, head);
        head = insert(2, 2, head);
        head = insert(3, 3, head);
        head = insert(4, 4, head);
        head = insert(5, 5, head);

        print(head);
        System.out.println();
        RecorderList mid = findingMid(head);
        RecorderList rightList = mid.next;
        mid.next = null;
        rightList = reverse(rightList);
        print(head);
        System.out.println();
        print(rightList);

        RecorderList result = head;

        while(head!=null && rightList!=null){
            RecorderList rightNodeNext = rightList.next; //4
            rightList.next = null; //5
            RecorderList leftNodeNext = head.next; //2
            head.next = rightList;
            rightList.next = leftNodeNext;
            head = leftNodeNext;
            rightList = rightNodeNext;
        }

        System.out.println();
        print(result);

    }

    public static RecorderList reverse(RecorderList head){
        RecorderList previous = null;
        RecorderList current = head;
        RecorderList next = null;

        while (current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static RecorderList findingMid(RecorderList head){
        if(head==null || head.next==null) {
            return head;
        }
        RecorderList first = head;
        RecorderList second = head;

        while (second.next!=null && second.next.next!=null){
            first = first.next;
            second = second.next.next;
        }

        return first;
    }

    public static void print(RecorderList head){
        RecorderList temp = head;
        while(temp.next!=null){
            System.out.print(temp.value + "    ");
            temp = temp.next;
        }

        System.out.print(temp.value);
    }

    public static RecorderList insert(int position, int data, RecorderList head){
        RecorderList newNode = new RecorderList(data);

        if(position==1){
            newNode.next=null;
            head = newNode;
        }
        else{
            RecorderList temp = head;
            for(int i=1; i<position-1 && temp!=null; i++){
                temp = temp.next;
            }

            RecorderList tempo = temp.next;
            temp.next= newNode;
            newNode.next = tempo;

        }

        return head;

    }
}
