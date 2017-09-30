import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mergesort {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] b = sc.nextLine().split(" ");
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
	 private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

	        // copy to aux[]
	        for (int k = lo; k <= hi; k++) {
	           aux[k]=a[k] ;
	        }

	        // merge back to a[]
	        int i = lo, j = mid+1;
	        for (int k = lo; k <= hi; k++) {
	            if(i > mid){
	            	a[k]= aux[j];
	            	j++;
	            	
	            }
	            else if (j > hi)  {
	            	a[k]= aux[i];
	            	i++;
	            	
	            }
	            else if (less(aux[j], aux[i])){
	            	a[k]= aux[j];
	            	j++;
	            	
	            }
	            else  {   
	            	a[k]= aux[i];
	            	i++;
	            	
	            }
	        }

	    }

	 private static void sort(int[] a, int[] aux, int lo, int hi) {
	        if (hi <= lo) return;
	        int mid = lo + (hi - lo) / 2;
	        sort(a, aux, lo, mid);
	        
	        sort(a, aux, mid + 1, hi);
	        merge(a, aux, lo, mid, hi);
	    }

	    
	    public static void sort(int[] a) {
	    	
	    	int[] aux = new int[a.length];
	    	
	        sort(a, aux, 0, a.length-1);
	        
	    }

	  private static boolean less(int v, int w) {
	        return v<w;
	    }
}
