package algo;

public class FenwickTree {

	int[] tree;
	
	public FenwickTree(int[] arr) {
		tree = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			inc(i, arr[i]);
		}
	}
	
	public void inc(int index, int delta) {
		while (index < tree.length) {
			tree[index] += delta;
			index = index | (index + 1);
		}
	}
	
	public int sum(int right) {
		int ret = 0;
		while (right >= 0) {
			ret += tree[right];
			right = (right & (right + 1)) - 1;
		}
		return ret;
	}
	
	public int sum(int left, int right) {
		return sum(right) - sum(left - 1);
	}
	
}
