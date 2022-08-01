package algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SegmentTreeMinTest {

	@Test
	public void test() {
		SegmentTreeMin stm = new SegmentTreeMin(new int[] { 1, 2, 3, 4, 5 } );
		assertEquals(1, stm.min(0, 4));
		assertEquals(4, stm.min(3, 4));
		
		stm.set(0, 100);
		assertEquals(2, stm.min(0, 4));
		
		stm.set(1, 100);
		assertEquals(3, stm.min(0, 4));
		
		assertEquals(4, stm.min(3, 4));
	}
	
}
