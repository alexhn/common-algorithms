package algo;

public class SegmentTreeMin {

	private int[] tree;
	private int n;
	
	public SegmentTreeMin(int[] input) {
		this.tree = new int[input.length * 4];
		this.n = input.length;
		buildTree(input, 1, 0, input.length - 1);
	}
	
	private void buildTree(int[] input, int v, int left, int right) {
		if (left == right) {
			tree[v] = input[left];
		} else {
			int middle = (left + right) / 2;
			buildTree(input, v * 2, left, middle);
			buildTree(input, v * 2 + 1, middle + 1, right);
			tree[v] = Math.min(tree[v * 2], tree[v * 2 + 1]);
		}
	}
	
	public int min(int left, int right) {
		return min(1, 0, n - 1, left, right);
	}
	
	private int min(int v, int left, int right, int segmentLeft, int segmentRight) {
		if (segmentLeft > segmentRight) {
			return Integer.MAX_VALUE;
		}
		if (segmentLeft == left && segmentRight == right) {
			return tree[v];
		}
		int middle = (left + right) / 2;
		return Math.min(
				min(v * 2, left, middle, segmentLeft, Math.min(segmentRight, middle)),
				min(v * 2 + 1, middle + 1, right, Math.max(segmentLeft, middle + 1), segmentRight)
			   );
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
			tree[v] = Math.min(tree[v * 2], tree[v * 2 + 1]);
		}
	}
	
	public void set(int index, int newValue) {
		update(1, 0, n - 1, index, newValue);
	}
	
}
