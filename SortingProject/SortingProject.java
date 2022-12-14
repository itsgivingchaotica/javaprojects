import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//Saoirse Siobhan Ebert

class SortingProject {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc1 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_1.txt"));
		Scanner sc2 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_2.txt"));
		Scanner sc3 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_3.txt"));
		Scanner sc4 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_4.txt"));
		Scanner sc5 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_5.txt"));
		Scanner sc6 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_6.txt"));
		Scanner sc7 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_7.txt"));
		Scanner sc8 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_8.txt"));
		Scanner sc9 = new Scanner(new File("/Users/siobhan/javaprojects/SortingProject/sortpart_9.txt"));
		
		int[] set1 = new int[10];
		int[] set2 = new int[10];
		int[] set3 = new int[10];
		int[] set4 = new int[30];
		int[] set5 = new int[30];
		int[] set6 = new int[30];
		int[] set7 = new int[50];
		int[] set8 = new int[50];
		int[] set9 = new int[50];
		
		
		BubbleSort sort1b = new BubbleSort();
		QuickSort sort1q = new QuickSort();
		ShellSort sort1s = new ShellSort();
		
		System.out.println("SET 1 DATA: 10 numbers in almost sorted order (a few out of order)");
		set1 = readData(sc1,set1.length);
		printData(set1);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted1 = Arrays.copyOf(set1,set1.length);
		sort1b.bubbleSort(bubbleSorted1);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted1 = Arrays.copyOf(set1,set1.length);
		sort1q.quickSort(quickSorted1, 0, 9);
		printData(quickSorted1);
		sort1q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted1 = Arrays.copyOf(set1,set1.length);
		shellSorted1 = sort1s.shellSort(shellSorted1);
		printData(shellSorted1);
		sort1s.printData();
		
		System.out.println();
		
		BubbleSort sort2b = new BubbleSort();
		QuickSort sort2q = new QuickSort();
		ShellSort sort2s = new ShellSort();
		
		System.out.println("SET 2 DATA: 10 numbers in random order");
		
		set2 = readData(sc2,set2.length);
		printData(set2);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted2 = Arrays.copyOf(set2,set2.length);
		sort2b.bubbleSort(bubbleSorted2);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted2 = Arrays.copyOf(set2,set2.length);
		sort2q.quickSort(quickSorted2, 0, 9);
		printData(quickSorted2);
		sort2q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted2 = Arrays.copyOf(set2,set2.length);
		sort2s.shellSort(shellSorted2);
		printData(shellSorted2);
		sort2s.printData();
		
		System.out.println();
		
		System.out.println("SET 3 DATA: 10 numbers in reverse order (a few out of order)");
		
		BubbleSort sort3b = new BubbleSort();
		QuickSort sort3q = new QuickSort();
		ShellSort sort3s = new ShellSort();
		
		set3 = readData(sc3,set3.length);
		printData(set3);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted3 = Arrays.copyOf(set3,set3.length);
		sort3b.bubbleSort(bubbleSorted3);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted3 = Arrays.copyOf(set3,set3.length);
		sort3q.quickSort(quickSorted3, 0, 9);
		printData(quickSorted3);
		sort3q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted3 = Arrays.copyOf(set3,set3.length);
		sort3s.shellSort(shellSorted3);
		printData(shellSorted3);
		sort3s.printData();
		
		System.out.println();
		
		BubbleSort sort4b = new BubbleSort();
		QuickSort sort4q = new QuickSort();
		ShellSort sort4s = new ShellSort();
		
		System.out.println("SET 4 DATA: 30 numbers in almost sorted order (a few out of order)");
		set4 = readData(sc4,set4.length);
		printData(set4);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted4 = Arrays.copyOf(set4,set4.length);
		sort4b.bubbleSort(bubbleSorted4);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted4 = Arrays.copyOf(set4,set4.length);
		sort4q.quickSort(quickSorted4, 0, 29);
		printData(quickSorted4);
		sort4q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted4 = Arrays.copyOf(set4,set4.length);
		shellSorted4 = sort4s.shellSort(shellSorted4);
		printData(shellSorted4);
		sort4s.printData();
		
		System.out.println();
		
		BubbleSort sort5b = new BubbleSort();
		QuickSort sort5q = new QuickSort();
		ShellSort sort5s = new ShellSort();
		
		System.out.println("SET 5 DATA: 30 numbers in random order");
		set5 = readData(sc5,set5.length);
		printData(set5);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted5 = Arrays.copyOf(set5,set5.length);
		sort5b.bubbleSort(bubbleSorted5);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted5 = Arrays.copyOf(set5,set5.length);
		sort5q.quickSort(quickSorted5, 0, 29);
		printData(quickSorted5);
		sort5q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted5 = Arrays.copyOf(set5,set5.length);
		shellSorted5 = sort5s.shellSort(shellSorted5);
		printData(shellSorted5);
		sort5s.printData();
		
		System.out.println();
		
		BubbleSort sort6b = new BubbleSort();
		QuickSort sort6q = new QuickSort();
		ShellSort sort6s = new ShellSort();
		
		System.out.println("SET 6 DATA: 30 numbers in reverse order (a few out of order)");
		set6 = readData(sc6,set6.length);
		printData(set6);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted6 = Arrays.copyOf(set6,set6.length);
		sort6b.bubbleSort(bubbleSorted6);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted6 = Arrays.copyOf(set6,set6.length);
		sort6q.quickSort(quickSorted6, 0, 29);
		printData(quickSorted6);
		sort6q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted6 = Arrays.copyOf(set6,set6.length);
		shellSorted6 = sort6s.shellSort(shellSorted6);
		printData(shellSorted6);
		sort6s.printData();
		
		System.out.println();
		
		BubbleSort sort7b = new BubbleSort();
		QuickSort sort7q = new QuickSort();
		ShellSort sort7s = new ShellSort();
		
		System.out.println("SET 7 DATA: 50 numbers in almost sorted order (a few out of order)");
		set7 = readData(sc7,set7.length);
		printData(set7);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted7 = Arrays.copyOf(set7,set7.length);
		sort7b.bubbleSort(bubbleSorted7);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted7 = Arrays.copyOf(set7,set7.length);
		sort7q.quickSort(quickSorted7, 0, 49);
		printData(quickSorted7);
		sort7q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted7 = Arrays.copyOf(set7,set7.length);
		shellSorted7 = sort7s.shellSort(shellSorted7);
		printData(shellSorted7);
		sort7s.printData();
		
		System.out.println();
		
		BubbleSort sort8b = new BubbleSort();
		QuickSort sort8q = new QuickSort();
		ShellSort sort8s = new ShellSort();
		
		System.out.println("SET 8 DATA: 50 numbers in random order)");
		set8 = readData(sc8,set8.length);
		printData(set8);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted8 = Arrays.copyOf(set8,set8.length);
		sort8b.bubbleSort(bubbleSorted8);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted8 = Arrays.copyOf(set8,set8.length);
		sort8q.quickSort(quickSorted8, 0, 49);
		printData(quickSorted8);
		sort8q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted8 = Arrays.copyOf(set8,set8.length);
		shellSorted8 = sort8s.shellSort(shellSorted8);
		printData(shellSorted8);
		sort8s.printData();
		
		System.out.println();
		
		BubbleSort sort9b = new BubbleSort();
		QuickSort sort9q = new QuickSort();
		ShellSort sort9s = new ShellSort();
		
		System.out.println("SET 9 DATA: 50 numbers in reverse order (or almost reverse))");
		set9 = readData(sc9,set9.length);
		printData(set9);
		System.out.println("Perform Bubble Sort:");
		int[] bubbleSorted9 = Arrays.copyOf(set9,set9.length);
		sort9b.bubbleSort(bubbleSorted9);
		System.out.println("Perform Quick Sort:");
		int[] quickSorted9 = Arrays.copyOf(set9,set9.length);
		sort9q.quickSort(quickSorted9, 0, 49);
		printData(quickSorted9);
		sort9q.printData();
		System.out.println("Perform Shell Sort:");
		int [] shellSorted9 = Arrays.copyOf(set9,set9.length);
		shellSorted9 = sort9s.shellSort(shellSorted9);
		printData(shellSorted9);
		sort9s.printData();
		
		System.out.println();
	}
	
	public static int[] readData(Scanner sc,int len)
	{
		int[] numbers = new int[len];
		int i = 0;
		sc.nextLine();
		while (sc.hasNextInt())
		{
			numbers[i] = sc.nextInt();
			i++;
		}
		return numbers;
	}
	
	
	public static void printData(int[] numbers)
	{
		
		for (int number: numbers)
		{
			System.out.print(number + " ");
		}
		System.out.println();
	}

}
