
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		String[] b = sc.nextLine().split(" ");
		int[] arr =new int[b.length];
		for(int i = 0; i<b.length; i++){
			arr[i]=Integer.parseInt(b[i]);
			
		}
		int a = sc.nextInt();
		System.out.println(BinaryS(arr,a));
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
