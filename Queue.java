import java.util.Stack;

public class Queue {
	
	Stack<Integer> main =new Stack<Integer>();
	Stack<Integer> temp =new Stack<Integer>();
	
	public void enqueue(int item){
		
		if(main.isEmpty()){
			main.push(item);
		}
		else{
			while(!main.isEmpty())
				temp.push(main.pop());
			
			main.push(item);
			
			while(!temp.isEmpty())
			     main.push(temp.pop()); 	
			
		}
	}

	public int dequeue() throws Exception{
		if(!main.isEmpty())
		  return main.pop();
		else
		  throw new Exception("Queue is empty");
		  
	}
	
	
}


	
	
	

