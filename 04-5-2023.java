import java.util.*;

public class Main {

	public static void main(String[] args) {
		String instructions = "<<<<<<><><><><<<<><><><><><<<<><><><><><>>>><<><><><><><><><><>>>><<<<<><><><><><<<<<><><><><><><<<<><><><><><><><><><><><<<<<<><><<><><>>><<>><<><<>><><<><><><><><><><<<<<<<<<>><<><><<<><><><><<<<<<>>>>>>>>>>><>><><><>><<<><><><><<><><<><><><><><><><<<<><><><>><<>>>>><><><>><<<><><><><><><>><><><><><><><><><><><><><><><><><<<><><><><><><><><><><><><><><><><><>>>><><><><><><><><><>><<<<<<<<<<>>>>><<<<<>>>><<<<>><<><<><><><><><><><><><><<<<<<<><><<><<><<><<><><><><><<>><><>><><><><><<><<<<<>><<<<><><<<><>>><<><>>>>><>>><<><<><><><><<>><><><><><><><><><><><><><><><><<<<><><<<<><<<>>>>>>>>><<><<<>>>>><<<<<<<<<>>>><<><>><><<><<>><<>><<>><";

		int currentFloor = 0;
		for (int i = 0; i < instructions.length(); i++) {
			char c = instructions.charAt(i);
			if (c == '<') {
				currentFloor++;
			} else if (c == '>') {
				currentFloor--;
			}
		}
		System.out.println("John ended up on floor " + currentFloor);
	}

}
