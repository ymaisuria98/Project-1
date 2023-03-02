import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class StatsLibrary {

	public double findMean(int[] list) {
		double sum = 0;
		for (int singleElement : list) {
			sum = sum + singleElement;			
		}
		double result = sum/ list.length;
		return result;
	}
	
	
	public double findMedian (int[] list) {
		int n=list.length;
		double median= 0.0;
		Arrays.sort(list);
		if((n/2)%2==0)
		{
			median=(list[n/2] + list[n/2+1])/2;
		}
		else
		{
			median=list[n/2+1];
		}
		return median;
	}

	
	public double findMode (int[] list) {
		int value=0, mcount=0;
		for (int i = 0; i < list.length; ++i) {
			int count = 0;
			for (int j = 0; j < list.length; ++j) {
				if(list[j] == list[i]) ++count;
			}
			if (count > mcount) {
				mcount = count;
				value = list[i];
			}
		}
		return value;
	}
	public double standardDeviation (int[] list) {
		double sum = 0;	
		double squareSum = 0;
		for (int i=0;i<list.length;i++) {
			sum = sum + list[i];
		}
			double average = sum/list.length;
		for (int i=0;i<list.length;i++) {
			squareSum = squareSum + (list[i]-average)*(list[i]-average);
		}
		return Math.sqrt(squareSum/(list.length-1));
		}
	
	public int factorial(int n)
	{
	int result = 1;
	if (n < 0) {
	return 0;
	}
	while (n > 1) {
	result *= n;
	n--;
	}
	return result;
	}

	public int permutation(int n, int r){
	return factorial(n)/factorial(n-r);
	}
	
	public int combinations(int n, int r)
	{
	    if(r == 0 || r == n)
	        return 1;
	    return combinations(n-1, r-1) + combinations(n-1, r);
	}
	
	
	public <T> List<T> union(List<T> list1, List<T> list2) {
	        Set<T> set = new HashSet<T>();

	        set.addAll(list1);
	        set.addAll(list2);

	        return new ArrayList<T>(set);
	    }

	    public <T> List<T> intersection(List<T> list1, List<T> list2) {
	        List<T> list = new ArrayList<T>();

	        for (T t : list1) {
	            if(list2.contains(t)) {
	                list.add(t);
	            }
	        }

	        return list;
	    }
	    public <T> List <T> complement(List<T> list1, List<T> list2) {
	    	Set<T> set = new HashSet<T>();

	        set.addAll(list1);
	        set.addAll(list2);
	        for (T t : list1) {
	            if(list2.contains(t)) {
	                set.remove(t);
	            }
	        }
	        return new ArrayList<T>(set);
	    }        
	    
	    public double binomial(int p, int y, double prob)
	    {
	        double way= combinations(p,y);
	        double prob_each_way = Math.pow(prob,y)*Math.pow((1.0-prob),p-y);
	        return (way*prob_each_way);
	    }
	   
	    public double geometric (int p, double prob) {
	        return 1-Math.pow(1 - prob, p);
    }
	    
	   
	    static Random random = new Random();

	    public int montyHall(boolean playerSwitch) {

	        if (playerSwitch) {

	        	int prizeDoor = random.nextInt(3);
	            int playerChoose = random.nextInt(3);
	            int wrong_door = prizeDoor;
	            while (wrong_door == prizeDoor ||
	                   wrong_door == playerChoose) {
	                wrong_door = random.nextInt(3);
	            }

	            int alternate_door = 3 - (playerChoose + wrong_door);

	            if (alternate_door == prizeDoor) return 1;
	            else return 0;

	        } else {

	        	int prizeDoor = random.nextInt(3);
	            int playerChoose = random.nextInt(3);
	            if (prizeDoor == playerChoose) return 1;
	            else return 0;
	        }

	        
	    }
	    public boolean birthday (int sampleSize) {
			ThreadLocalRandom rand = ThreadLocalRandom.current();
			int[] days = new int [365];
			
			for (int i = 0; i < sampleSize; i++) {
				int j = rand.nextInt(days.length);
				days[j]++;
				if (days[j] == 2) {
					return true;
				}
			}
			return false;
	    }
}
	    




