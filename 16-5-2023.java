import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example start state
        char[][] startState = {
			{'X', 'X', 'X', 'X', '.'},
			{'X', '.', '.', '.', '.'},
			{'X', '.', '.', 'X', '.'},
			{'.', 'X', '.', 'X', '.'},
			{'X', 'X', '.', 'X', 'X'}
        };

        // Print the start state
        System.out.println("Start state:");
        printLayout(startState);

        // Generate and print the layouts until a repeated layout is encountered
        List<char[][]> layouts = new ArrayList<>();
        layouts.add(startState);  // Keep track of encountered layouts
        int minute = 1;
        while (true) {
            char[][] nextLayout = nextMinuteLayout(layouts.get(layouts.size() - 1));
            if (containsLayout(layouts, nextLayout)) {
                System.out.println(minute + " minute:");
                printLayout(nextLayout);
                System.out.println("Repeated layout encountered after " + minute + " minute(s).");
                break;
            } else {
                layouts.add(nextLayout);
                System.out.println(minute + " minute:");
                printLayout(nextLayout);
                minute++;
            }
        }
    }

    private static void printLayout(char[][] layout) {
        for (char[] row : layout) {
            System.out.println(new String(row));
        }
        System.out.println();
    }

    private static char[][] nextMinuteLayout(char[][] layout) {
        char[][] newLayout = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int lifeformsCount = 0;
                int emptySpacesCount = 0;

                // Check the four adjacent tiles
                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];

                    // Count the adjacent lifeforms and empty spaces
                    if (x >= 0 && x < 5 && y >= 0 && y < 5) {
                        if (layout[x][y] == 'X') {
                            lifeformsCount++;
                        } else {
                            emptySpacesCount++;
                        }
                    }
                }

                // Apply the rules to update the tile
                if (layout[i][j] == 'X') {
                    if (lifeformsCount == 1) {
                        newLayout[i][j] = 'X';
                    } else {
                        newLayout[i][j] = '.';
                    }
                } else {
                    if (lifeformsCount == 1 || lifeformsCount == 2) {
                        newLayout[i][j] = 'X';
                    } else {
                        newLayout[i][j] = '.';
                    }
                }
            }
        }

        return newLayout;
    }

    private static boolean containsLayout(List<char[][]> layouts, char[][] targetLayout) {
        for (char[][] layout : layouts) {
            if (areLayoutsEqual(layout, targetLayout)) {
                return true;
            }
        }
        return false;
    }

    private static boolean areLayoutsEqual(char[][] layout1, char[][] layout2) {
        for (int i = 0; i < layout1.length; i++) {
            for (int j = 0; j < layout1[i].length; j++) {
                if (layout1[i][j] != layout2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
