import java.util.*;

public class Main {

	public static void main(String[] args) {
		int[] efficiency = {1, 3, 54, 712, 52, 904, 113, 12, 135, 32, 31, 56, 23, 79, 611, 123, 677, 232, 997, 101, 111,
			123, 2, 7, 24, 57, 99, 45, 666, 42, 104, 129, 554, 335, 876, 35, 15, 93, 13};
		int minCost = getMinimumCost(efficiency);
		System.out.println("Minimum cost: " + minCost);
	}

	public static int getMinimumCost(int[] efficiency) {
		int n = efficiency.length;

		int minCost = Integer.MAX_VALUE;
		int excludeIndex = -1;

		for (int i = 0; i < n; i++) {
			int[] copy = Arrays.copyOf(efficiency, n);
			int excludeEfficiency = copy[i];
			copy[i] = -1; // exclude this worker

			// find pairings and calculate cost
			int cost = 0;
			for (int j = 0; j < n-1; j += 2) {
				int first = -1, second = -1;
				for (int k = 0; k < n; k++) {
					if (copy[k] != -1) {
						if (first == -1 || copy[k] > copy[first]) {
							first = k;
						}
					}
				}
				copy[first] = -1;

				for (int k = 0; k < n; k++) {
					if (copy[k] != -1) {
						if (second == -1 || copy[k] > copy[second]) {
							second = k;
						}
					}
				}
				copy[second] = -1;

				cost += Math.abs(efficiency[first] - efficiency[second]);
			}

			if (cost < minCost) {
				minCost = cost;
				excludeIndex = i;
			}
		}

		System.out.println("Excluding worker with efficiency " + efficiency[excludeIndex]);
		return minCost;
	}
}

