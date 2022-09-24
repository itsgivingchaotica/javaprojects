public class BubbleSort 
{
	void bubbleSort(int[] nums)
	{
		
		int swaps = 0;
		int comparisons = 0;
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) 
			{
				comparisons++;
				if (nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					swaps++;
				}
					
			}
		}
		
		for (int i=0; i<len; i++)
		{
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		System.out.println("Bubble sort had " + comparisons + " comparisons and " + swaps + " swaps.");
	}
}
