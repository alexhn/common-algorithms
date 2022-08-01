package algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SegmentTreeTest {

	@Test
	public void test() {
		SegmentTree st = new SegmentTree(new int []{ 1, 2, 3, 4, 5 });
		assertEquals(15, st.sum(0, 4));
		assertEquals(1, st.sum(0, 0));
		assertEquals(5, st.sum(4, 4));
		
		st.set(0, 100);
		
		assertEquals(114, st.sum(0, 4));
		assertEquals(100, st.sum(0, 0));
		assertEquals(5, st.sum(4, 4));
		
		st.set(0, -50);
		
		assertEquals(-36, st.sum(0, 4));
		assertEquals(-50, st.sum(0, 0));
		assertEquals(5, st.sum(4, 4));
		
		st.set(4, 10);
		
		assertEquals(10, st.sum(4, 4));
		
	}
	
}
