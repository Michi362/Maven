package de.gremmelmaier;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
	private Queue queue = new Queue(3);
	
	@Test(expected=IllegalArgumentException.class)
	public void testeKonstruktor(){
		Queue q = new Queue(0);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testLeereQueue(){
		queue.dequeue();
	}
	
	@Test
	public void testEntnahme(){
		final int testWert = 5;
		queue.enqueue(testWert);
		assertEquals(testWert,queue.dequeue());
	}
	
	@Test
	public void testReihenfolge(){
		for(int i=1; i<4; i++){
			queue.enqueue(i);
		}
		for(int i=1; i<4; i++){
			assertEquals(i,queue.dequeue());
		}
	}
	
	@Test(expected=IllegalStateException.class)
	public void testMaxAnzahlWerte(){
		for(int i=0; i<5; i++){
			queue.enqueue(i);
		}
		for(int i=0; i<5; i++){
			queue.dequeue();
		}
	}
	
	@Test
	public void testUeberschreiben(){
		for(int i=1; i<7; i++){
			queue.enqueue(i);
		}
		for(int i=0; i<2; i++){
			queue.dequeue();
		}
		assertEquals(6,queue.dequeue());
	}
}
