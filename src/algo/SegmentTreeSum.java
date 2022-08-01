package algo;

public class SegmentTreeSum {

	private int[] tree;
	private int n;
	
	public SegmentTreeSum(int[] input) {
		n = input.length;
		tree = new int[4 * input.length];
		buildTree(input, 1, 0, input.length - 1);
	}

	private void buildTree(int[] input, int v, int left, int right) {
		if (left == right) {
			tree[v] = input[left];
		} else {
			int middle = (left + right) / 2;
			buildTree(input, v * 2, left, middle);
			buildTree(input, v * 2 + 1, middle + 1, right);
			tree[v] = tree[v * 2] + tree[v * 2 + 1];
		}
	}
	
	private int sum(int v, int left, int right, int segmentLeft, int segmentRight) {
		if (segmentLeft > segmentRight) {
			return 0;
		}
		if (segmentLeft == left && segmentRight == right) {
			return tree[v];
		}
		int middle = (left + right) / 2;
		return sum(v * 2, left, middle, segmentLeft, Math.min(segmentRight, middle))
			 + sum(v * 2 + 1, middle + 1, right, Math.max(segmentLeft, middle + 1), segmentRight);
	}
	
	public int sum(int left, int right) {
		return sum(1, 0, n - 1, left, right);
	}
	
	private void update(int v, int left, int right, int index, int newValue) {
		if (left == right) {
			tree[v] = newValue;
		} else {
			int middle = (left + right) / 2;
			if (index <= middle) {
				update(v * 2, left, middle, index, newValue);
 			} else {
 				update(v * 2 + 1, middle + 1, right, index, newValue);
 			}
			tree[v] = tree[v * 2] + tree[v * 2 + 1];
		}
	}
	
	public void set(int index, int newValue) {
		update(1, 0, n - 1, index, newValue);
	}

}
