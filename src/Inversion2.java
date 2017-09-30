import java.util.Scanner;

public class Inversion2 {

	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			String[] b = sc.nextLine().split(" ");
			int[] arr =new int[b.length];
			for(int i = 0; i<b.length; i++){
				arr[i]=Integer.parseInt(b[i]);
				
			}
			System.out.println(sort(arr,arr.length));

	}
		private static int merge(int[] a, int[] aux, int lo, int mid, int hi, int t) {
			 int inv_count = t;
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
	            	inv_count ++;	            	
	            	a[k]= aux[j];
	            	j++;
	            	
	            }
	            else  {   
	            	a[k]= aux[i];
	            	i++;
	            	
	            }
	        }
	        //System.out.printf("Merge: %d\n",inv_count);
		      return inv_count;
	    }

	 private static int sort(int[] a, int[] aux, int lo, int hi) {
		 	int inv_count=0;
		 	int mid = 0;
		 	if (hi > lo) {
		 		
		 		mid = lo+(hi-lo)/2;
		 		inv_count =sort(a, aux, lo, mid);
		 		inv_count+=sort(a, aux, mid + 1, hi);
		 		inv_count+=merge(a, aux, lo, mid, hi,inv_count);
		 	}
		 	//System.out.printf("Sort: %d\n",inv_count);
		 	return inv_count;
	    }

	    
	    public static int sort(int[] a,int l) {
	    	
	    	int[] aux = new int[l];
	    	
	        return sort(a, aux, 0, a.length-1);
	        
	    }
	    private static boolean less(int v, int w) {
	        return v<w;
	    }
	 
}
