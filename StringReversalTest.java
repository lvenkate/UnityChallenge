import static org.junit.Assert.*;
import org.junit.Test;

public class StringReversalTest {
	
	 @Test
	   public void stringReversalTest() {
		 StringReversal stringReversal = new StringReversal();
         String result = stringReversal.reverse(" foobar baz "); //Leading and Trailing white spaces
         
         String resultCheck ="zab raboof";//Result has the leading and trailing spaces removed
         assertEquals(result,resultCheck);
         
         result = stringReversal.reverse("");
         assertNull(null);
 
         result = stringReversal.reverse("     ");
         resultCheck =""; //All empty spaces are removed
         assertEquals(result,resultCheck);
         
	 }
}
