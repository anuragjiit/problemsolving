package com.linkedlist;

public class ReverseLinkedList {
    int value;
    ReverseLinkedList next;

    ReverseLinkedList(int data){
        value = data;
    }

    public static void main(String[] args) {

        ReverseLinkedList head = null;

        head = insert(1, 1, head);
        head = insert(2, 2, head);
        head = insert(3, 3, head);
        head = insert(4, 4, head);
        head = insert(5, 5, head);
        head = insert(6, 6, head);
        head = insert(7, 7, head);
        head = insert(8, 8, head);
        head = insert(9, 9, head);
        head = insert(10, 10, head);
        head = insert(11, 11, head);


        print(head);

        int start = 1;
        int end = 2;

        ReverseLinkedList to = head;
        ReverseLinkedList toPrevious = null;
        ReverseLinkedList from = head;
        ReverseLinkedList fromNext = null;

        for(int i=1;i<start; i++){
            toPrevious=to;
            to=to.next;     // start
        }

        for(int i=1;i<end; i++){
            from=from.next;   // end
        }
        fromNext = from.next;
        from.next = null;

        ReverseLinkedList result = reverse(to);

        if(fromNext!=null){
            ReverseLinkedList temp = result;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=fromNext;
        }

        if(toPrevious!=null){
            toPrevious.next = result;
            print(head);
            System.exit(0);
        }

        System.out.println();
       print(result);

    }

    public static ReverseLinkedList insert(int position, int data, ReverseLinkedList head){
        ReverseLinkedList newNode = new ReverseLinkedList(data);

        if(position==1){
            newNode.next=null;
            head = newNode;
        }
        else{
            ReverseLinkedList temp = head;
            for(int i=1; i<position-1 && temp!=null; i++){
                temp = temp.next;
            }

                ReverseLinkedList tempo = temp.next;
                temp.next= newNode;
                newNode.next = tempo;

        }

        return head;

    }

    public static ReverseLinkedList reverse(ReverseLinkedList head){
        ReverseLinkedList previous = null;
        ReverseLinkedList current = head;
        ReverseLinkedList next = null;

        while (current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


    public static void print(ReverseLinkedList head){
        ReverseLinkedList temp = head;
        while(temp.next!=null){
            System.out.print(temp.value + "    ");
            temp = temp.next;
        }

             System.out.print(temp.value);
    }

}
