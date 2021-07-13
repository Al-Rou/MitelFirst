/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.


You may assume that each input would have exactly one solution, and you may not use the same element twice.


You can return the answer in any order.

Input: nums = [2,7,15,11], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:


Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:


Input: nums = [3,3], target = 6
Output: [0,1]

 */


import java.util.HashSet;

public class Second {
    public static void main(String[] args)
    {
        Second second = new Second();
        //int[] input = {2,7,11,15};
        int[] input = {3,2,100,20,35,4};
        //int[] res = second.showIndex(input, 6);
        int[] res = second.showIndexUsingHashSet(input, 6);
        if((res[0] != 0) || (res[1] != 0)) {
            System.out.println("The index " + res[0] + " and index " + res[1]);
        }
    }
    //This is another algorithm with the help of a data structure
    public int[] showIndexUsingHashSet(int[] A, int target)
    {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        set.add(A[0]);
        int remain = 0;
        //int secondIndex = 0;
        for(int i = 1; i < A.length; i++)
        {
            remain = target - A[i];
            if(set.contains(remain)) {
                result[0] = i;
                break;
            }
            else {
                set.add(A[i]);
            }
        }
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] == remain)
            {
                result[1] = i;
            }
        }
        if((result[0] == 0) && (result[1] == 0))
        {
            System.out.println("There is no pair in the array!");
        }
        return result;
    }
    //This is a better algorithm, whose complexity is the complexity of the chosen sorting algorithm!
    public int[] showIndex(int[] A, int target)
    {
        int lo = 0;
        int hi = A.length-1;
        int[] result = new int[2];
        int[] sortedArray = new int[A.length];
        for(int i = 0; i < A.length; i++)
        {
            sortedArray[i] = A[i];
        }
        //First, sorting the array
        MergeSort mergeSort = new MergeSort();
        sortedArray = mergeSort.mergeSort(sortedArray,lo,hi);
        int firstIndex = 0;
        int secondIndex = 0;

        //Now, this loop finds the answer if exists!
        while (hi > lo) {
            if ((sortedArray[lo] + sortedArray[hi]) == target) {
                firstIndex = lo;
                secondIndex = hi;
                break;
            } else if ((sortedArray[lo] + sortedArray[hi]) < target) {
                lo++;
            } else {
                hi--;
            }
        }
        if((firstIndex != 0) || (secondIndex != 0))
        {
            for(int i = 0; i < A.length; i++)
            {
                if(sortedArray[firstIndex] == A[i])
                {
                    result[0] = i;
                    break;
                }
            }
            for(int i = 0; i < A.length; i++)
            {
                if(sortedArray[secondIndex] == A[i])
                {
                    result[1] = i;
                    break;
                }
            }
            return result;
        }
        else {
            System.out.println("There is no pair whose summation is equal to the target!");
            return result;
        }
    }

    //The complexity is O(N^2)
    /*public int[] showIndex(int[] A, int target)
    {
        int remain = 0;
        int[] result = new int[2];
        for(int i = 0; i < A.length; i++)
        {
            remain = target - A[i];
            for(int j = 0; j < A.length; j++)
            {
                if(j == i)
                {
                    continue;
                }
                else {
                    if(A[j] == remain)
                    {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }*/
}
