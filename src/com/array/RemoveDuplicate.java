/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.
 */
package com.array;

public class RemoveDuplicate {
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int count = 1;

        // option 3 - same Data structure
    for(int j=1; j < nums.length; j++){
        if (nums[j] != nums[j-1]){
            nums[count] = nums[j];
            count += 1;
        }
    }
        for (int arr:nums){
            System.out.println(arr);
        }

  /*      ArrayList<Integer> newNum = new ArrayList<Integer>();

            while(i < nums.length){
                if (nums.length == 0)  {
                    System.out.println("Empty array");
                    break;
                }
                else if (nums.length == 1) {
                    System.out.println(count+1);
                    break;
                }
                else if (i+1 < nums.length && nums[i] == nums[i+1]) {
                        i+= 1;
                }
                else {
                    newNum.add(nums[i]);
                    i+=1;
                 count+=1;
                }
            }
   //     newNum.add(nums[nums.length-1]);
    //    count+=1;
       System.out.println(count);
        for (int arr:newNum){
            System.out.println(arr);
        }
*/
      // option 2 only with loop

  /*      for (i =0; i< nums.length; i++){
            if (i+1 < nums.length && nums[i] != nums[i+1]) {
                count += 1;
            }
        }
        int count1= 0;
        int[] newNum = new int[count+1];
        for (i =0; i< nums.length; i++){
            if (i+1 < nums.length && nums[i] != nums[i+1]) {
                newNum[count1] = nums[i];
                count1 +=1;
            }
        }
        newNum[newNum.length-1] = nums[nums.length-1];
            for (int arr:newNum){
                System.out.println(arr);
            } */





    }
}
