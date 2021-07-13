public class MergeSort {
    public int[] merge(int[] A, int lo, int mid, int hi)
    {
        int[] aux = new int[A.length];
        for(int i = 0; i < A.length; i++)
        {
            aux[i] = A[i];
        }
        int i = lo;
        int j = mid+1;
        for(int k = lo; k < hi+1; k++)
        {
            if(i >= mid+1)
            {
                A[k] = aux[j];
                j++;
            }
            else if(j > hi)
            {
                A[k] = aux[i];
                i++;
            }
            else if(aux[i] <= aux[j])
            {
                A[k] = aux[i];
                i++;
            }
            else if(aux[i] > aux[j])
            {
                A[k] = aux[j];
                j++;
            }

        }
        return A;
    }
    public int[] mergeSort(int[] A, int lo, int hi)
    {
        if(hi <= lo)
        {
            return A;
        }
        int mid = lo + ((hi-lo)/2);
        mergeSort(A,lo,mid);
        mergeSort(A,mid+1,hi);
        merge(A,lo,mid,hi);

        return A;
    }
}
