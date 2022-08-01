package algo;

import java.util.Arrays;
import java.util.function.BiFunction;

public class SegmentTreeGeneric {

	private int[] tree;
	private int n;
	private BiFunction<Integer, Integer, Integer> func;
	private Integer identity;
	
	public SegmentTreeGeneric(int[] input, BiFunction<Integer, Integer, Integer> func, Integer identity) {
		this.tree = new int[input.length * 4];
		this.n = input.length;
		this.func = func;
		this.identity = identity;
		buildTree(input, 1, 0, input.length - 1);
	}

	private void buildTree(int[] input, int v, int left, int right) {
		if (left == right) {
			tree[v] = input[left];
		} else {
			int middle = (left + right) / 2;
			buildTree(input, v * 2, left, middle);
			buildTree(input, v * 2 + 1, middle + 1, right);
			tree[v] = func.apply(tree[v * 2], tree[v * 2 + 1]);
		}
	}

	private int calc(int v, int left, int right, int segmentLeft, int segmentRight) {
		if (segmentLeft > segmentRight) {
			return identity;
		}
		if (segmentLeft == left && segmentRight == right) {
			return tree[v];
		}
		int middle = (left + right) / 2;
		int leftValue = calc(v * 2, left, middle, segmentLeft, Math.min(middle, segmentRight));
		int rightValue = calc(v * 2 + 1, middle + 1, right, Math.max(middle + 1, segmentLeft), segmentRight);
		return func.apply(leftValue, rightValue);
	}
	
	public int calc(int left, int right) {
		return calc(1, 0, n - 1, left, right);
	}
	
	private void set(int v, int left, int right, int index, int newValue) {
		if (left == right) {
			tree[v] = newValue;
		} else {
			int middle = (left + right) / 2;
			if (index <= middle) {
				set(v * 2, left, middle, index, newValue);
			} else {
				set(v * 2 + 1, middle + 1, right, index, newValue);
			}
			tree[v] = func.apply(tree[v * 2], tree[v * 2 + 1]);
		}
	}

	public void set(int index, int newValue) {
		set(1, 0, n - 1, index, newValue);
	}
	
}
