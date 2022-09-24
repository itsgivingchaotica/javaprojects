public class QuickSort {
	int comparisons = 0;
	int swaps = 0;
	
	void swap(int[] nums, int i, int j)
	{
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
	int partition(int[] nums, int lo, int hi)
	{
	     
	    int pivot = nums[hi];
	     
	    int i = (lo - 1);
	 
	    for(int j = lo; j <= hi - 1; j++)
	    {
	    	comparisons++;
	        if (nums[j] < pivot)
	        {
	            i++;
	            swap(nums, i, j);
	            swaps++;
	        }
	    }
	    swap(nums, i + 1, hi);
	    swaps++;
	    return (i + 1);
	}
	 
	int[] quickSort(int[] nums, int lo, int hi)
	{
	    if (lo < hi)
	    {
	         
	        int par = partition(nums, lo, hi);
	 
	        quickSort(nums, lo, par - 1);
	        quickSort(nums, par + 1, hi);
	    }
	    return nums;
	}
	 	
	void printData()
	{
		System.out.println("Quick sort had " + comparisons + " comparisons and " + swaps + " swaps.");
	}

}
