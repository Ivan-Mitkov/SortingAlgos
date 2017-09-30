import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class NeedlesSelectionSort {

	static ArrayList<Integer> answers= new ArrayList<>();
	public static void main(String[] args) throws IOException {
		 BufferedReader in
		   = new BufferedReader(new InputStreamReader(System.in));
		 
		String[] razmeri= in.readLine().split(" ");
		String[]  C = in.readLine().split(" ");
		String[]  N = in.readLine().split(" ");
		
		int[] razm= new int[2];
		for(int i = 0; i<2; i++){
			razm[i]=Integer.parseInt(razmeri[i]);
			
		}
		int[] arr =new int[razm[1]];
		for(int i = 0; i<razm[1]; i++){
			arr[i]=Integer.parseInt(N[i]);
			
		}		
		
		int[] ins =new int[razm[0]];
		for(int i = 0; i<razm[0]; i++){
			ins[i]=Integer.parseInt(C[i]);
			
		}
		
		
		allInserte(arr,ins);
		print(answers);

	}
	private static void print(ArrayList<Integer> answers2) {
		for(int i=0; i<answers2.size(); i++){
			System.out.printf("%d ",answers2.get(i));
		}
		System.out.println();
		
	}
	public static int findPrevGreaterThanZero(int[] arr, int a){
		int res=0;
		for(int i=0; i<=a; i++){
			if(arr[i]!=0&&arr[i+1]!=0){
				res=i;
			}
			
		}
		return res;
	}
	public static void print(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.printf("%d ",arr[i]);
		}
		System.out.println();
	}
	
	public static void allInserte(int[] small, int []big){
			if(findZeroes(big)){
				for(int i = 0 ; i<small.length; i++){
					int res=BinaryS(big,small[i]);
					if(res==-1&&small[i]<=findMin(big)) answers.add(0);
					else if(res==-1&&small[i]>=findMax(big))answers.add(big.length);
					else{
						answers.add(res);
					}
				}
			}
			else{
				int countFirst=0;
				int countLast=big.length;
				for(int i = 0 ; i<small.length; i++){
					 
					 if(small[i]<=findMin(big)){
						 answers.add(countFirst);
						 
					 }
					 else if(small[i]>findMax(big)){
						 answers.add(countLast);
						 
					 }
					 else {
						 int biggerSoFar=big[0];
						 for(int j=0;j<big.length;j++ ){
							
							 if(big[j]>biggerSoFar){
								 biggerSoFar=big[j];
							 }
							 if(small[i]<=biggerSoFar){
								
								 int k=j-1;
								 if(big[k]!=0){
									 answers.add(k+1);
									 break;
								 }
								 else{
									 while(big[k]==0&&k>0){
											k--;
											 
										 }
									 if(k<0){
										 answers.add(0);
										 break; 
									 }
									 else{
										 answers.add(k+1);
										 break; 
									 }


								 }
								
							 }
							
						 }
					 }
					 
				}
			}
		
	}
	public static int findMax(int[] arr){
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]>0){
				return arr[i];
			}
		}
		return 0;
		
	}
	public static int findMin(int[]arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0){
				return arr[i];
			}
		}
		return 0;
	}
	public static boolean findZeroes(int[]arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				return false;
			}
		}
		return true;
	}
	public static int BinaryS(int[]a, int searched){
		 int lo = 0;
	        int hi = a.length - 1;
	        while (lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            if      (searched < a[mid]) hi = mid - 1;
	            else if (searched > a[mid]) lo = mid + 1;
	            else return mid;
	        }
	        return -1;
	}
	
}
