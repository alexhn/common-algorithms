package algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class FenwickTreeTest {

	@Test
	public void test() {
		
		FenwickTree fw = new FenwickTree(new int[] { 1, 2, 3, 4, 5 } );
		assertEquals(15, fw.sum(0, 4));
		assertEquals(1, fw.sum(0, 0));
		assertEquals(5, fw.sum(4, 4));
		
		fw.inc(0, 100);
		
		assertEquals(115, fw.sum(0, 4));
		assertEquals(101, fw.sum(0, 0));
		assertEquals(5, fw.sum(4, 4));
		
		fw.inc(0, -50);
		
		assertEquals(65, fw.sum(0, 4));
		assertEquals(51, fw.sum(0, 0));
		assertEquals(5, fw.sum(4, 4));
		
		fw.inc(4, 10);
		
		assertEquals(15, fw.sum(4, 4));
		
	}
	
}
