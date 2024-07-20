package com.linkedlist;

public class SortLinkList {
    int value;
    SortLinkList next;

    SortLinkList(int data){
        value = data;
    }

    public static void main(String[] args) {

    /*   code to create 2 list in sorted order then merge them

        SortLinkList head1 = null;
        SortLinkList head2 = null;
        SortLinkList mergeList = null;

        head1 = insert(1, 10, head1);
        head1 = insert(2, 20, head1);
        head1 = insert(3, 30, head1);

        print(head1);
        System.out.println();
        head2 = insert(1, 4, head2);
        head2 = insert(2, 5, head2);
        head2 = insert(3, 6, head2);
        head2 = insert(4, 7, head2);

        print(head2);

        System.out.println();
        mergeList = mergeLinkedList(head1,head2);
        print(mergeList);  */

        // sort the Linked list in order of nlogn order i..e Merge sort

        SortLinkList head1 = null;
        head1 = insert(1, 10, head1);
        head1 = insert(2, 4, head1);
        head1 = insert(3, 50, head1);
        head1 = insert(4, 40, head1);
        head1 = insert(5, 100, head1);
        head1 = insert(6, 30, head1);
        head1 = insert(7, 10, head1);
        head1 = insert(8, 4, head1);
        head1 = insert(9, 9, head1);
        head1 = insert(10, 8, head1);
        head1 = insert(11, 1, head1);

        SortLinkList result = sortList(head1);

        print(result);

    }

        public static SortLinkList sortList(SortLinkList head){
            if(head.next==null){
                return head;
            }

            SortLinkList midList = findingMid(head);
            SortLinkList left = head;
            SortLinkList right = midList.next;
            midList.next = null;

            SortLinkList leftHead = sortList(left);
            SortLinkList rightHead = sortList(right);
            return mergeLinkedList(leftHead, rightHead);
        }

        // merge 2 sorted listed list
        public static SortLinkList mergeLinkedList(SortLinkList A, SortLinkList B){
            if(A==null && B==null){
                return null;
            }
            if(A==null){
                return B;
            }
            if(B==null){
                return A;
            }
            SortLinkList firstPointer = null;
            SortLinkList secondPointer = null;
            if(A.value<=B.value){
                firstPointer = A;
                secondPointer = A;
                A = A.next;
            }
            else {
                firstPointer = B;
                secondPointer = B;
                B = B.next;
            }

            while(A!=null && B!=null){

                if(A.value<=B.value){
                    secondPointer.next = A;
                    A = A.next;
                }
                else {
                    secondPointer.next = B;
                    B = B.next;
                }
                secondPointer = secondPointer.next;
            }

            if(A!=null){
                secondPointer.next=A;
            }
            if(B!=null){
                secondPointer.next=B;
            }

            return firstPointer;
        }

    public static SortLinkList findingMid(SortLinkList head){
        if(head==null || head.next==null) {
            return head;
        }
        SortLinkList first = head;
        SortLinkList second = head;

        while (second.next!=null && second.next.next!=null){
            first = first.next;
            second = second.next.next;
        }

        return first;
    }

    public static SortLinkList insert(int position, int data, SortLinkList head){
        SortLinkList newNode = new SortLinkList(data);
        if(position==1){
            newNode.next=head;
            head = newNode;
        } else {
            SortLinkList temp = head;
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

    public static void print(SortLinkList head){
        SortLinkList temp = head;
        while(temp.next!=null){
            System.out.print( temp.value + "   ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }
}
