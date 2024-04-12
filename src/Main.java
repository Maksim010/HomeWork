import java.util .*;

        public class Main {
            private static int[][] area;
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter the size of the area (row column):");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();

                area = new int[rows][cols];

                System.out.println("Enter the number of active elements:");
                int numActive = scanner.nextInt();

                for (int i = 0; i < numActive; i++) {
                    System.out.println("Enter the position of active element " + (i + 1) + " (row column):");
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();
                    area[row][col] = i + 1;
                }

                System.out.println("Enter 'y' to show all steps, or any other key to show only the initial and final states:");
                String showSteps = scanner.next();

                System.out.println("Enter 'y' to disable diagonal coloring, or any other key to enable it:");
                boolean disableDiagonal = scanner.next().equals("y");

                int turns = 0;

                while (!isAreaFull()) {
                    if (showSteps.equals("y")) {
                        System.out.println("Turn " + (turns + 1) + ":");
                        printArea();
                    }

                    updateArea(disableDiagonal);
                    turns++;
                }

                System.out.println("All cells colored in " + turns + " turns:");
                printArea();

                scanner.close();
            }

            private static void updateArea(boolean disableDiagonal) {
                int[][] newArea = new int[area.length][area[0].length];

                for (int i = 0; i < area.length; i++) {
                    for (int j = 0; j < area[0].length; j++) {
                        if (area[i][j] > 0) {
                            int color = area[i][j];

                            newArea[i][j] = color;

                            if (i > 0) {
                                newArea[i - 1][j] = color;
                            }

                            if (j > 0) {
                                newArea[i][j - 1] = color;
                            }

                            if (i < area.length - 1) {
                                newArea[i + 1][j] = color;
                            }

                            if (j < area[0].length - 1) {
                                newArea[i][j + 1] = color;
                            }

                            if (!disableDiagonal) {
                                if (i > 0 && j > 0) {
                                    newArea[i - 1][j - 1] = color;
                                }

                                if (i > 0 && j < area[0].length - 1) {
                                    newArea[i - 1][j + 1] = color;
                                }

                                if (i < area.length - 1 && j > 0) {
                                    newArea[i + 1][j - 1] = color;
                                }

                                if (i < area.length - 1 && j < area[0].length - 1) {
                                    newArea[i + 1][j + 1] = color;
                                }
                            }
                        }
                    }
                }

                area = newArea;
            }

            private static boolean isAreaFull() {
                for (int[] row : area) {
                    for (int cell : row) {
                        if (cell == 0) {
                            return false;
                        }
                    }
                }

                return true;
            }

            private static void printArea() {
                for (int[] row : area) {
                    for (int cell : row) {
                        System.out.print(cell + " ");
                    }
                    System.out.println();
                }
            }
    }