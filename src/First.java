/*Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:


        [4,5,6,7,0,1,2] if it was rotated 4 times.
        [0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].


Given the sorted rotated array nums of unique elements, return the minimum element of this array.*/




public class First {
    public static void main(String[] args)
    {
        First first = new First();
        //[] input = {4,5,6,7,0,1,2};
        int[] input = {0,1,2,4,5,6,7};
        System.out.println(first.showMinimum(input));
    }
    public int showMinimum(int[] A)
    {
        for(int i = 0; i < A.length-1; i++)
        {
            //Since the array is sorted rotated, this if-clause finishes the whole search
            if(A[i+1] < A[i])
            {
                return A[i+1];
            }
        }
        //If the program comes out of the loop, it means that the array is sorted ascending. So, the first element is
        //the smallest.
        return A[0];
    }
}
