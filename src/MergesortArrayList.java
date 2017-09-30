import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergesortArrayList {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] b = sc.nextLine().split(" ");
		ArrayList<Integer> arr =new ArrayList<>();
		for(int i = 0; i<b.length; i++){
			arr.add(Integer.parseInt(b[i]));
			
		}
		sort(arr);
		for(int i:arr){
			System.out.printf("%d ",i);
		}
		System.out.println();

	}
	 private static void merge(ArrayList<Integer> a, ArrayList<Integer> aux, int lo, int mid, int hi) {

	        // copy to aux[]
	        for (int k = lo; k <= hi; k++) {
	           aux.set(k,a.get(k)) ;
	        }

	        // merge back to a[]
	        int i = lo, j = mid+1;
	        for (int k = lo; k <= hi; k++) {
	            if(i > mid){
	            	a.set(k, aux.get(j));
	            	j++;
	            	
	            }
	            else if (j > hi)  {
	            	a.set(k, aux.get(i));
	            	i++;
	            	
	            }
	            else if (less(aux.get(j), aux.get(i))){
	            	a.set(k, aux.get(j));
	            	j++;
	            	
	            }
	            else  {   
	            	a.set(k, aux.get(i));
	            	i++;
	            	
	            }
	        }

	    }

	 private static void sort(ArrayList<Integer> a, ArrayList<Integer> aux, int lo, int hi) {
	        if (hi <= lo) return;
	        int mid = lo + (hi - lo) / 2;
	        sort(a, aux, lo, mid);
	        sort(a, aux, mid + 1, hi);
	        merge(a, aux, lo, mid, hi);
	    }

	    
	    public static void sort(ArrayList<Integer> a) {
	    	
	    	ArrayList<Integer> aux = new ArrayList<Integer>();
	    	for(int i =0; i<a.size();i++){
	    		aux.add(0);
	    	}
	        sort(a, aux, 0, a.size()-1);
	        
	    }

	  private static boolean less(int v, int w) {
	        return v<w;
	    }
}
