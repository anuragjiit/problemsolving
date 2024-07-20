package com.linkedlist;

public class RemoveDuplicatesLinkedList {

    int value;
    RemoveDuplicatesLinkedList next;

    RemoveDuplicatesLinkedList(int data){
        value = data;
    }

    public static RemoveDuplicatesLinkedList insert(int position, int data, RemoveDuplicatesLinkedList head){
        RemoveDuplicatesLinkedList newNode = new RemoveDuplicatesLinkedList(data);

        if(position==1){
            newNode.next=null;
            head = newNode;
        }
        else{
            RemoveDuplicatesLinkedList temp = head;
            for(int i=1; i<position-1 && temp!=null; i++){
                temp = temp.next;
            }

            RemoveDuplicatesLinkedList tempo = temp.next;
            temp.next= newNode;
            newNode.next = tempo;
        }
        return head;
    }

    public static void removeDuplicate(RemoveDuplicatesLinkedList head){
        RemoveDuplicatesLinkedList current = head;
        if(current.next==null) {
            System.out.println(current.value);
            System.exit(0);
        }
        RemoveDuplicatesLinkedList nextNode = current.next;

        while (current!=null && nextNode!=null){
            if(current.value==nextNode.value){
                if(nextNode.next!=null){
                    nextNode = nextNode.next;
                }
                else{
                    current.next=null;
                    current=current.next;
                }
            }
            else {

                current.next = nextNode;
                current = nextNode;
                nextNode = nextNode.next;
            }
        }
        System.out.println();
        print(head);
    }

    public static void print(RemoveDuplicatesLinkedList head){
        RemoveDuplicatesLinkedList temp = head;
        while(temp.next!=null){
            System.out.print(temp.value + "    ");
            temp = temp.next;
        }

        System.out.print(temp.value);
    }
    public static void main(String[] args) {
        RemoveDuplicatesLinkedList head = null;

        head = insert(1, 1, head);
        head = insert(2, 1, head);
        head = insert(3, 2, head);
        head = insert(4, 2, head);
        head = insert(5, 2, head);

        print(head);

        removeDuplicate(head);
    }
}
