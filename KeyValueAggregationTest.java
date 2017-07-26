import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class KeyValueAggregationTest {
	
	@Test
	public void keyValueAggregationTest(){
	
		KeyValueAggregationTest kVAT = new KeyValueAggregationTest();
		KeyValueAggregation kVA = new KeyValueAggregation();
		ArrayList<String> pairs = new ArrayList<String>();
		
		pairs.add("USA");
		pairs.add("California");
		
		pairs.add("India");
		pairs.add("Maharastra");
				
		pairs.add("India");
		pairs.add("Karnataka");
		
		pairs.add("USA");
		pairs.add("New Jersey");
		
		pairs.add("India");
		pairs.add("Kerala");
		
		pairs.add("USA");
		pairs.add("Washington");
		
		pairs.add("India");
		pairs.add("Delhi");
		
		pairs.add("USA");
		pairs.add("New York");
		
		ArrayList<String> india = new ArrayList<String>();
		india.add("Delhi");
		india.add("Karnataka");
		india.add("Kerala");
		india.add("Maharastra");
		
	   List<Entry<String, ArrayList<String>>> list = kVA.arrange(pairs);
	   Entry<String, ArrayList<String>> entryUSA = list.get(1);//Checking if the key is stored in ascending order
	   entryUSA = list.get(1);//Checking if the key is stored in ascending order
	   assertEquals(entryUSA.getKey(),"USA");
	   assert entryUSA.getValue().contains("New York");
	   
	   Entry<String, ArrayList<String>> entry = list.get(0);//Checking if the key is stored in ascending order
	   assertEquals(entry.getKey(),"India");
	   
	   ArrayList<String> resultList = entry.getValue();
	   assert resultList.containsAll(india); //Checking whether the values are stored in ascending order
	   
	   ArrayList<String> nullValue = new ArrayList<String>();
	   list = kVA.arrange(nullValue);
	   assertTrue(nullValue.isEmpty());
	   
	}

}
