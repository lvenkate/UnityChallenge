// Section 4 : Data Processing
//Part 1
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class KeyValueAggregation {
	
	public  List<Entry<String, ArrayList<String>>> arrange(ArrayList<String> tokens){
		 if(tokens == null ||  tokens.size() == 0)
			 return null;
		 
		Comparator<Entry<String, ArrayList<String>>> comparator = new Comparator<Entry<String, ArrayList<String>>>()
	    {
	        public int compare(Entry<String, ArrayList<String>> o1, Entry<String, ArrayList<String>> o2)
	        {
	        	int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getKey(), o2.getKey());
	            if (res == 0) {
	                res = o1.getKey().compareTo(o2.getKey());
	             }
	            return res;
	        } 
	    };
		Map<String , ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(int  i = 0;i< tokens.size() ; i=i+2)  {
			ArrayList<String> list = null;
		    if(map.containsKey(tokens.get(i))){
		    	 list = map.get(tokens.get(i));
		    	 list.add(tokens.get(i+1));
		    }
		    else{
		    	list= new ArrayList<String>();
		    	list.add(tokens.get(i+1));
		    	
		    }
		    Collections.sort(list);//Sort the internal values for each key(ascending order)
		    map.put(tokens.get(i),list);
		}
		List<Entry<String, ArrayList<String>>> list = new ArrayList<Entry<String, ArrayList<String>>>(map.entrySet());
		Collections.sort(list,comparator);//Sort key (ascending order)
        return list;
	}
	
	//Prints the List of Key Value Pairs
	public  void print(List<Entry<String, ArrayList<String>>> list){
		 if(list == null || list.size() == 0 )
			   System.out.println("No values to List"); ;
		   for(Entry<String, ArrayList<String>> l : list){
	        	 System.out.println("Key: " + l.getKey());
	        	 {
	        		 for(String s: l.getValue()){
	        			 System.out.println("Value:" + s);
	        		 }
	        	 }
	         }
	}
	public static void main(String[] args){
		 KeyValueAggregation keyValueAggregation = new KeyValueAggregation();
		 ArrayList<String> pairs = new ArrayList<String>();
		 String line;
		 String[] tokens=new String[2];
		 //Reading from standard input
		 Scanner stdin = new Scanner(System.in); 
		 //Type "End" to stop inputing data
		    while(stdin.hasNextLine() && !(line=stdin.nextLine()).equalsIgnoreCase("end"))
		    {
		    	if(line.contains(",")){
		        tokens = line.split(",");
		        System.out.println(tokens[0]+ " "+ tokens[1]);
		        pairs.add(new String(tokens[0]));
		        pairs.add(new String(tokens[1]));
		    	}
		    }
		    stdin.close();
		  //Call arrange for the Key Value Arrangement
		 List<Entry<String, ArrayList<String>>> list = keyValueAggregation.arrange(pairs);
		 keyValueAggregation.print(list);
		    
	 }
}

// Part 2
 /*Suppose that the data was extremely large, and did not fit in memory. What problems would
 *  this cause? How could these problems be solved?
 */
 /*Answer : The problem that is if the huge data loaded all at once . There would be overflow while 
 * reading the input data and chances of missing those over the limit data list is the possibility.
 * 
 * Solution for this is to read chunks of data and a specific intervals this will again cause problem in 
 * aggregation as not all the data would be taken into consideration
 * 
 * Use a solution like a Hadoop eco system where you scale a huge machine map all the keys in different 
 * machines and collate or reduce it and the final aggregation would give the right outcome 
 */
