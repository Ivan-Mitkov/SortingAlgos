import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) throws IOException {
		 BufferedReader in
		   = new BufferedReader(new InputStreamReader(System.in));
		
		String[]  b = in.readLine().split(" ");
		
		int[] arr =new int[b.length];
		for(int i = 0; i<b.length; i++){
			arr[i]=Integer.parseInt(b[i]);
			
		}
		sort(arr);
		StringBuilder a = new StringBuilder();
		for(int i:arr){
			a.append(i);
			a.append(" ");
		}
		System.out.println(a);
	}
	 public static void sort(int[] a) {
		 
	        shuffle(a);
	        sort(a, 0, a.length - 1);
	       
	    }

	    // quicksort the subarray a[lo .. hi] using 3-way partitioning
	    private static void sort(int[] a, int lo, int hi) { 
	        if (hi <= lo) return;
	        int lt = lo, gt = hi;
	        int v = a[lo];
	        int i = lo;
	        while (i <= gt) {
	          
	            if      (a[i]<v) exch(a, lt++, i++);
	            else if (a[i]>v) exch(a, i, gt--);
	            else              i++;
	        }

	        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
	        sort(a, lo, lt-1);
	        sort(a, gt+1, hi);
	        
	    }


	    // is v < w ?
	    private static boolean less(int v, int w) {
	        return v<w;
	    }
	        
	    // exchange a[i] and a[j]
	    private static void exch(int[] a, int i, int j) {
	        int swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }
	    public static void shuffle(int[] a) {
	        if (a == null) throw new IllegalArgumentException("argument array is null");
	        Random ran = new Random();
	        int n = a.length;
	        for (int i = 0; i < n; i++) {
	            int r = i + ran.nextInt(n-i);     // between i and n-1
	            int temp = a[i];
	            a[i] = a[r];
	            a[r] = temp;
	        }

	    }
}
