import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Words {

	static HashSet<String> perm= new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		 BufferedReader in
		   = new BufferedReader(new InputStreamReader(System.in));
		
		String  b = in.readLine();
		int n=b.length();
		permute(b,0,n-1);
		System.out.println(perm.size());
		
		//System.out.println(noConsecutiveEqualCharacters (b));
	}
	public static boolean noConsecutiveEqualCharacters (String b){
		
		int i =0;
		int j = 1;
		for( i =0,  j= i+1;i<b.length()-1; i++,j++ ){
			
			if(b.charAt(i)==b.charAt(j))return false;
			
		}
		return true;
		
	}
	 /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private static void permute(String str, int l, int r)
    {
        if (l == r)
        	if(noConsecutiveEqualCharacters(str))
        		perm.add(str);
        	else
        		return;
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
 
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
//    public static int check(HashSet<String> perm){
//    	int res=0;
//    	for(String b:perm){
//    		if(noConsecutiveEqualCharacters(b)){
//    			res++;
//    		}
//    	}
//    	return res;
//    }

}
