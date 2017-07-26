import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {
	
	@Test
	public void queueTest() throws Exception{
		
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		int out = queue.dequeue();
		assertEquals(10,out);
		
		out = queue.dequeue();
		assertTrue( out != 10);
		
		assertTrue( out == 20);
		
		out = queue.dequeue();
		out = queue.dequeue();
		out = queue.dequeue();
	
		boolean thrown = false;

		  try {
			out = queue.dequeue();
		  } catch (Exception e) {
		    thrown = true;
		  }

		  assertTrue(thrown);
		
	}

}
