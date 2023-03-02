import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
   *
   * Author: Yash Maisuria
   * Date: 1/26/23
   *
*/

public class TestStatsLibrary {
	/**
	   * Main method
	*/
	public static void main (String[] args) { 
		StatsLibrary test = new StatsLibrary();
		int[] someNumbers = {1,2,3,4};
		 // 1 + 2 + 3 + 4 = 10/4 = Expected result 2.5
		double result = test.findMean(someNumbers);
		
		System.out.println("Average of input " + result);
	
		int[] evenList = {38,56,18,20,12,44};

		int[] oddList = {5,21,49,41,31,19};

		System.out.print("Even List: ");

		for(int i=0;i<evenList.length;i++)

		System.out.print(evenList[i]+" ");

		System.out.println("\nMean: "+ (test.findMean(evenList))); 
		System.out.println("Median: "+ (test.findMedian(evenList)));
		System.out.println("Mode: "+ test.findMode(evenList)); 
		System.out.println("Standard Deviation: "+ test.standardDeviation(evenList));
		
		System.out.print("\nOdd List: ");

		for(int i=0;i<oddList.length;i++)

		System.out.print(oddList[i]+" ");

		System.out.println("\nMean: "+ (test.findMean(oddList)));
		System.out.println("Median: "+ (test.findMedian(oddList)));
		System.out.println("Mode: "+ test.findMode(oddList));
		System.out.println("Standard Deviation: "+ test.standardDeviation(oddList));
		
		
		int [] wholeList = new int [evenList.length + oddList.length];
		System.arraycopy(evenList, 0, wholeList, 0, evenList.length);
		System.arraycopy(oddList, 0, wholeList, evenList.length, oddList.length);
		
		System.out.print("\nWhole List: ");
		for(int i=0;i<wholeList.length;i++)
		System.out.print(wholeList[i] + " ");
		
		
		System.out.println("\nMean: "+ (test.findMean(wholeList)));
		System.out.println("Median: "+ (test.findMedian(wholeList)));
		System.out.println("Mode: "+ test.findMode(wholeList));
		System.out.println("Standard Deviation: "+ test.standardDeviation(wholeList));
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter Total Amount In Set: ");
		int n = scanner.nextInt();
		System.out.print("Enter Amount in each Sub-Set: ");
		int r = scanner.nextInt();
		System.out.println("Permutation: ("+n+", "+r+") = "+ test.permutation(n,r));
		System.out.println("Combinations: ("+n+", "+r+") = "+ test.combinations(n, r));

		
		List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
	        List<String> list2 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F"));

	        System.out.println("\nList 1:" + list1 );
	        System.out.println("List 2:" + list2 );
	        System.out.println("Intersection: " + new StatsLibrary().intersection(list1, list2));
	        System.out.println("Union: " + new StatsLibrary().union(list1, list2));
	        System.out.println("Complement: " + new StatsLibrary().complement(list1, list2));
	
	        Scanner scanner1 = new Scanner(System.in);
			System.out.print("\nEnter Number of Trials: ");
			int p = scanner.nextInt();
			System.out.print("Enter Successes: ");
			int y = scanner.nextInt();
			System.out.print("Enter Probability of Success: ");
			double prob = scanner.nextDouble();
			System.out.println("Binomial: ("+p+", "+y+", "+prob+") = "+ test.binomial(p, y, prob));
			System.out.println("Geometric: (X < "+p+") = "+ test.geometric(p, prob));
	       
			 	int times = 100000;
		        int winsWithNoSwitch = 0, winsWithSwitch = 0;
		        for(int x=1;x<=times;x++){
		            winsWithNoSwitch += test.montyHall(false);
		            winsWithSwitch += test.montyHall(true);
		        }

		        System.out.println("\nWin Chance With Switching: "+ winsWithSwitch*100.0/times);
		        System.out.println("Win Chance Without Switching: "+ winsWithNoSwitch*100.0/times);

		        int numPeople = 30;
		    	int trial = 1000000;
		    	int match = 0; 
		    	for (int i = 0; i < trial; i++) {
		    		if (test.birthday(numPeople)) {
		    			match++;
		    		}
		    	}
		    	System.out.println("\nSampling Birthdays Number Of People: " + numPeople);
		    	double probability = (double) match / trial * 100;
		    	System.out.println("Probability Of A Birthday Match: " + probability);
	}
}
		
	
