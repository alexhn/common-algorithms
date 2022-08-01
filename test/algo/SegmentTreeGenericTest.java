package algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SegmentTreeGenericTest {

	@Test
	public void test() {
		
		SegmentTreeGeneric stsum = new SegmentTreeGeneric(
				new int []{ 1, 2, 3, 4, 5 },
				(val1, val2) -> val1 + val2,
				0);
		assertEquals(15, stsum.calc(0, 4));
		assertEquals(1, stsum.calc(0, 0));
		assertEquals(5, stsum.calc(4, 4));
		
		stsum.set(0, 100);
		
		assertEquals(114, stsum.calc(0, 4));
		assertEquals(100, stsum.calc(0, 0));
		assertEquals(5, stsum.calc(4, 4));
		
		stsum.set(0, -50);
		
		assertEquals(-36, stsum.calc(0, 4));
		assertEquals(-50, stsum.calc(0, 0));
		assertEquals(5, stsum.calc(4, 4));
		
		stsum.set(4, 10);
		
		assertEquals(10, stsum.calc(4, 4));
		
		SegmentTreeGeneric stmin = new SegmentTreeGeneric(
				new int[] { 1, 2, 3, 4, 5 },
				(val1, val2) -> Math.min(val1, val2),
				Integer.MAX_VALUE
				);
		assertEquals(1, stmin.calc(0, 4));
		assertEquals(4, stmin.calc(3, 4));
		
		stmin.set(0, 100);
		assertEquals(2, stmin.calc(0, 4));
		
		stmin.set(1, 100);
		assertEquals(3, stmin.calc(0, 4));
		
		assertEquals(4, stmin.calc(3, 4));
		
		
	}
	
}
