import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "1867";
        boolean foundDivisible = false;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int count = 0;

        // Loop over all possible permutations of the digits
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < input.length(); k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    for (int l = 0; l < input.length(); l++) {
                        if (i == l || j == l || k == l) {
                            continue;
                        }

                        // Convert the current permutation to an integer and check if it is divisible by 7
                        int number = Integer.parseInt("" + input.charAt(i) + input.charAt(j) + input.charAt(k) + input.charAt(l));
                        if (number % 7 == 0) {
                            foundDivisible = true;
                            smallest = Math.min(smallest, number);
                            largest = Math.max(largest, number);
                            count++;
                        }
                    }
                }
            }
        }

        if (foundDivisible) {
            // Calculate the average of the smallest and largest numbers
            double average = (smallest + largest) / 2.0;
            System.out.println("Values divisible by 7: " + count);
            System.out.println("Smallest value: " + smallest);
            System.out.println("Largest value: " + largest);
            System.out.println("The Average is: " + average);
        } else {
            System.out.println("There are no permutations of " + input + " that are divisible by 7.");
        }
    }
}

