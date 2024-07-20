package com.linkedlist;

public class AddTwoNumberList {

    int value;
    AddTwoNumberList next;

    AddTwoNumberList(int data){
        value = data;
    }

    public static void main(String[] args) {
        AddTwoNumberList head1 = null;
        AddTwoNumberList head2 = null;
        AddTwoNumberList mergeList = null;

        head1 = insert(1, 9, head1);
        head1 = insert(2, 9, head1);
        head1 = insert(3, 9, head1);

        print(head1);
        System.out.println();
        head2 = insert(1, 1, head2);
//        head2 = insert(2, 6, head2);
//        head2 = insert(3, 4, head2);
//        head2 = insert(4, 7, head2);

        print(head2);

        AddTwoNumberList sumNode = null;
        AddTwoNumberList result= null;

        AddTwoNumberList h1 = head1;
        AddTwoNumberList h2 = head2;
        int carry = 0;

        while(h1!=null && h2!=null){
            int sum = h1.value+h2.value+carry;
            carry = sum/10;
            sum = sum%10;
            AddTwoNumberList newNode = new AddTwoNumberList(sum);

            if(sumNode==null){
               sumNode = newNode;
               result = sumNode;

            } else {
//                AddTwoNumberList temp = sumNode;
//                while (temp.next!=null){
//                    temp = temp.next;
//                }
                sumNode.next = newNode;
                sumNode = newNode;
            }
            h1 = h1.next;
            h2 = h2.next;

        }

        System.out.println();

//        while(sumNode.next!=null) {
//            sumNode = sumNode.next;
//        }



        if(h1!=null && carry==0){
            sumNode.next=h1;
        }
        if(h2!=null && carry==0){
            sumNode.next=h2;
        }

        if(carry==1){
            while(h1!=null){
                int sum = h1.value+carry;
                carry = sum/10;
                sum = sum%10;
                sumNode.next = new AddTwoNumberList(sum);
                h1 = h1.next;
                sumNode = sumNode.next;
            }
            while(h2!=null){
                int sum = h2.value+carry;
                carry = sum/10;
                sum = sum%10;
                sumNode.next = new AddTwoNumberList(sum);
                h2 = h2.next;
                sumNode = sumNode.next;
            }
        }

        if(carry==1) {
            sumNode.next = new AddTwoNumberList(carry);
        }

        System.out.println();

        print(result);
    }

    public static AddTwoNumberList insert(int position, int data, AddTwoNumberList head){
        AddTwoNumberList newNode = new AddTwoNumberList(data);
        if(position==1){
            newNode.next=head;
            head = newNode;
        } else {
            AddTwoNumberList temp = head;
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

    public static void print(AddTwoNumberList head){
        AddTwoNumberList temp = head;
        while(temp.next!=null){
            System.out.print( temp.value + "   ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }
}
