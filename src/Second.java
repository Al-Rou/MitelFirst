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



public class Second {
    public static void main(String[] args)
    {
        Second second = new Second();
        //int[] input = {2,7,11,15};
        int[] input = {3,2,100,20,35,4};
        int[] res = second.showIndex(input, 6);
        System.out.println("The index "+ res[0] + " and index " + res[1]);
    }
    //This
    public int[] showIndex(int[] A, int target)
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
    }
}
