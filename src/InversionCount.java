import java.util.Scanner;

public class InversionCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] b = sc.nextLine().split(" ");
		int[] arr =new int[b.length];
		for(int i = 0; i<b.length; i++){
			arr[i]=Integer.parseInt(b[i]);
			
		}
		printInversion(arr);
	}
	 
	    public static void printInversion(int[]a){
	    	int sum=0;
	    	for(int i = 0; i<a.length-1;i++){
	    		for(int j=i+1; j<a.length;j++){
	    			if(a[i]>a[j]){
			        	System.out.printf("%d %d",a[i],a[j]);
			        	System.out.println();
			        	sum++;
	    			}
	    		
		        }
	    	}
	    	System.out.println(sum);
	    	
	    }

}
