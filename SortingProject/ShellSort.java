public class ShellSort {
	int swaps = 0;
	int comparisons = 0;
	int[] shellSort (int[] nums)
	{
		
		 int n = nums.length;
		 
	        for (int gap = n/2; gap > 0; gap /= 2)
	        {
	            for (int i = gap; i < n; i += 1)
	            {
	            	comparisons++;
	                int temp = nums[i];
	                int j;
	                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap)
	                    nums[j] = nums[j - gap];
	                swaps++;
	 
	                nums[j] = temp;
	                swaps++;
	            }
	        }
		return nums;
	}
	
	void printData()
	{
		System.out.println("Shell sort had " + comparisons + " comparisons and " + swaps + " swaps.");
	}

}
