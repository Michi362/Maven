package de.gremmelmaier;

import org.junit.Test;

import static org.junit.Assert.*;


public class UtilTest{
	
	@Test
	public void testJanuar(){
		final int testWert = 1;
		final boolean sollWert = true;
		assertEquals(sollWert, Util.istErstesHalbjahr(testWert));
	}
	
	@Test
	public void testJuni(){
		final int testWert = 6;
		final boolean sollWert = true;
		assertEquals(sollWert, Util.istErstesHalbjahr(testWert));
	}
	
	@Test
	public void testJuli(){
		final int testWert = 7;
		final boolean sollWert = false;
		assertEquals(sollWert, Util.istErstesHalbjahr(testWert));
	}
	
	@Test
	public void testDezember(){
		final int testWert = 12;
		final boolean sollWert = false;
		assertEquals(sollWert, Util.istErstesHalbjahr(testWert));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNull(){
		final int testWert = 0;
		final boolean sollWert = false;
		assertEquals(sollWert, Util.istErstesHalbjahr(testWert));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativ(){
		final int testWert = -1;
		Util.istErstesHalbjahr(testWert);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGrosseZahl(){
		final int testWert = 13;
		Util.istErstesHalbjahr(testWert);
	}
}
