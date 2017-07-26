
public class StringReversal {

	
	public String reverse(String string){
		if( string == null|| string.length() == 0){
			return string;
		}
		string=string.trim();
		int left = 0;
		int right = string.length()-1;
		char[] result =string.toCharArray();
	
		while(left < right){
			
		  char temp = result[left];
		  result[left] = result[right];
		  result[right]= temp;
	      left++;
	      right--;
		  
		}
		
	    return new String(result);
		
	}

	public static void main(String[] args){
		StringReversal stringReversal = new StringReversal();
	    String result = stringReversal.reverse("Lakshmi Venkateswaran");
		 System.out.println(result);
	
	}
	
	

}
