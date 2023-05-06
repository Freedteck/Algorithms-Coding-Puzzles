import java.util.*;

public class Race {
    public static void main(String[] args) {
        // John's speed and rest time
        int johnSpeed = 10; // meters per second
        int johnRunTime = 6; // seconds
        int johnRestTime = 20; // seconds

		// jenna's speed and rest time
		int jennaSpeed = 12; // meters per second
		int jennaRunTime = 5; // seconds
		int jennaRestTime = 16; // seconds

		// josh's speed and rest time
		int joshSpeed = 7;
		int joshRunTime = 7;
		int joshRestTime = 23;

		// jacob's speed and rest time
		int jacobSpeed = 9;
		int jacobRunTime = 4;
		int jacobRestTime =32;

		// jerry's speed and rest time
		int jerrySpeed = 5;
		int jerryRunTime = 9;
		int jerryRestTime = 18;

        // James's speed and rest time
        int jamesSpeed = 8; // meters per second
        int jamesRunTime = 8; // seconds
        int jamesRestTime = 25; // seconds

        // Initialize variables for distance traveled and time elapsed
        int johnDistance = 0;
        int jamesDistance = 0;
		int jennaDistance = 0;
		int joshDistance = 0;
		int jacobDistance = 0;
		int jerryDistance = 0;

        // Loop through 100 seconds
        for (int time = 0; time < 1234; time++) {
            // Calculate distance traveled by John and James
            if (time % (johnRunTime + johnRestTime) < johnRunTime) {
                johnDistance += johnSpeed; // John is running
            }
            if (time % (jamesRunTime + jamesRestTime) < jamesRunTime) {
                jamesDistance += jamesSpeed; // James is running
            }
			if (time % (jennaRunTime + jennaRestTime) < jennaRunTime) {
                jennaDistance += jennaSpeed; // James is running
            }
			if (time % (joshRunTime + joshRestTime) < joshRunTime) {
                joshDistance += joshSpeed; // James is running
            }
			if (time % (jerryRunTime + jerryRestTime) < jerryRunTime) {
                jerryDistance += jerrySpeed; // James is running
            }
			if (time % (jacobRunTime + jacobRestTime) < jacobRunTime) {
                jacobDistance += jacobSpeed; // James is running
            }
        }

        // Print the distance traveled by each runner
        System.out.println("John's distance: " + johnDistance + " meters");
        System.out.println("James's distance: " + jamesDistance + " meters");
		System.out.println("Jenna's distance: " + jennaDistance + " meters");
		System.out.println("Josh's distance: " + joshDistance + " meters");
		System.out.println("Jacob's distance: " + jacobDistance + " meters");
		System.out.println("Jerry's distance: " + jerryDistance + " meters");

        // Determine the winner
        if (johnDistance > jamesDistance && johnDistance > joshDistance && johnDistance > jacobDistance && johnDistance > jerryDistance && johnDistance > jennaDistance) {
            System.out.println("John has won the race!");
        } 
		else if(jamesDistance > joshDistance && jamesDistance > jacobDistance && jamesDistance > jerryDistance && jamesDistance > jennaDistance && jamesDistance > johnDistance){
            System.out.println("James has won the race!");
        }
		else if (joshDistance > johnDistance && joshDistance > jamesDistance && joshDistance > jerryDistance && joshDistance > jennaDistance && joshDistance > jacobDistance) {
			System.out.println("Josh has won the race!");
		} 
		else if (jacobDistance > johnDistance && jacobDistance > jamesDistance && jacobDistance > jennaDistance && jacobDistance > joshDistance && jacobDistance > jerryDistance) {
			System.out.println("Jacob has won the race!");
		} 
		else if (jennaDistance > joshDistance && jennaDistance > jacobDistance && jennaDistance > jerryDistance && jennaDistance > jamesDistance && jennaDistance > johnDistance) {
			System.out.println("Jenna has won the race!");
		} 
		else if (jerryDistance > joshDistance && jerryDistance > jacobDistance && jerryDistance > jamesDistance && jerryDistance > jennaDistance && jerryDistance > johnDistance) {
			System.out.println("Jerry has won the race!");
		} 
		else {
			System.out.println("It's a tie!");
		}

    }
}
