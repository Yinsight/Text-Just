package TextJustification;

import java.util.ArrayList;

public class Question2 {

	public static ArrayList<Integer> split(String[] W, int width) {
		return MinimumBadness(W, width);     //return a list of breakpoints L
	}

	public static ArrayList<Integer> MinimumBadness(String[] W, int width) {
		ArrayList<Integer> list = new ArrayList<Integer>();// a list to save the minimum aggregated badness
		int[] memo = new int[W.length + 1];
		for (int i = 0; i < memo.length; i++) { // Initialize an integer array with a value of -1
			memo[i] = -1;
		}


		MemoizedMinmumBadness(W, 0, memo, width);
		for (int j = 0; j < W.length; j++) {
			list.add(memo[j]);// compute each line's minimum aggregated badness ,then add to list
		}
		ArrayList<Integer> splitList = new ArrayList<Integer>();//the list of breakpoints
		splitList.add(0);
		int i = 0;
		int index = 1;
		//compute each breakpoint,then add to the splitlist
		while (index < W.length) {
			//to figure out the index of breakpoint,flag is true,means the value of index is a breakpoint 
			boolean flag = (list.get(i) == Question1.badness(W, i, index, width) + list.get(index));
			if (flag) {
				splitList.add(index);
				i = index;
			}
			index++;
		}

		return splitList; // returns a list L ,each line minimize the aggregated badness
	}

	private static int MemoizedMinmumBadness(String[] W, int i, int[] memo, int width) {
		int n = memo.length;
		if (memo[i] > 0)
			return memo[i]; // indecate that this line has been calculated
		if (i == n)
			memo[i] = 0; // indecate the last line has been calculated
		else {
			int min = Integer.MAX_VALUE; // Initialize the aggregated badness
			int temp;
			for (int j = i + 1; j < n; j++) { // seen in Algorithms 2
				temp = Question1.badness(W, i, j, width);
				temp += MemoizedMinmumBadness(W, j, memo, width);// Recursive
				if (temp < min)
					min = temp;
			}
			memo[i] = min;
		}

		return memo[i];
	}
}
