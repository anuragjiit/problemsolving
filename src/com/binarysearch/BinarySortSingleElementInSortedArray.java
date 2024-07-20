package com.binarysearch;

public class BinarySortSingleElementInSortedArray {
    public static void main(String[] args) {

        int[]A = new int[]{1,1,2,2,3,4,4};

        int e = A.length-1;

        int s = 0;
        int fo = -1;
        int mid = 0;

        if(e==0) { System.out.println(A[0]); System.exit(0);}
        if(A[s] != A[s+1]) { System.out.println(A[s]); System.exit(0);}
        else if(A[e]!=A[e-1]) {System.out.println(A[e]); System.exit(0);}
        else {

            while (s<=e) {
                mid = (e-s)/2+s;

                if(A[mid]!=A[mid-1] && A[mid]!=A[mid+1]) {
                    System.out.println(A[mid]);
                    System.exit(0);
                }

                if(A[mid]==A[mid-1]){
                    fo = mid-1;
                }
                if(A[mid]==A[mid+1]){
                    fo = mid;
                }
                if(fo%2==0) s = mid+1;
                else e = mid-1;
            }
        }
        System.out.println(mid);
    //    System.out.println(A[mid]);
    }
}
