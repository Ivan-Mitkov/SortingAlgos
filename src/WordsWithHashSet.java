import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class WordsWithHashSet {

	static HashSet<String> perm= new HashSet<>();
	
	static HashSet<String> temp= new HashSet<>();
	public static void main(String[] args) throws IOException {
		 BufferedReader in
		   = new BufferedReader(new InputStreamReader(System.in));
		
		String  b = in.readLine();
		
		if(unique(b))System.out.println(fact(b.length()));
		else{
			permute("",b);
			System.out.println(perm.size());
		}
		
		
		
		
		//System.out.println(noConsecutiveEqualCharacters (b));
	}
	public static boolean noConsecutiveEqualCharacters (String b){
		
		int i =0;
		
		for( i =0;i<b.length()-1; i++ ){
			
			if(b.charAt(i)==b.charAt(i+1))return false;
			
		}
		return true;
		
	}
	 /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private static void permute(String prefix, String str)
    {
    	int n= str.length();
        if (n==0)
        	if(noConsecutiveEqualCharacters(prefix)){
        		perm.add(prefix);
        	}
        	else{
        		return;
        	}
        
        else
        {
            for (int i = 0; i < n; i++)
            {
            	permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
                
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
    public static boolean unique(String b){
    	HashSet<Character> uniq= new HashSet<>();
    	for(int i = 0; i<b.length(); i++){
    		uniq.add(b.charAt(i));
    	}
    	return b.length()==uniq.size();
    }
    public static long fact(int n){
    	long b=1;
    	for(int i =1; i<=n;i++){
    		b*=i;
    	}
    	return b;
    }

}
