import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterIndex = new int[m][n];

        int startRow = 0, startCol = 0;
        int litterCount = 0;

        // Find starting position and give every L a bit index
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (cell == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }

        // Required by the problem statement
        String[] lumetarkon = classroom;

        if (litterCount == 0) {
            return 0;
        }

        // mask = litter still remaining
        int initialMask = (1 << litterCount) - 1;

        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> queue = new ArrayDeque<>();

        // {row, col, currentEnergy, remainingLitterMask}
        queue.offer(new int[]{
                startRow, startCol, energy, initialMask
        });

        visited[startRow][startCol][energy][initialMask] = true;

        int[] dir = {-1, 0, 1, 0, -1};
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] state = queue.poll();

                int row = state[0];
                int col = state[1];
                int currentEnergy = state[2];
                int mask = state[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // Cannot move further
                if (currentEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int newRow = row + dir[d];
                    int newCol = col + dir[d + 1];

                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n ||
                        lumetarkon[newRow].charAt(newCol) == 'X') {
                        continue;
                    }

                    char cell = lumetarkon[newRow].charAt(newCol);

                    int newEnergy;

                    // Moving onto R restores full energy
                    if (cell == 'R') {
                        newEnergy = energy;
                    } else {
                        newEnergy = currentEnergy - 1;
                    }

                    int newMask = mask;

                    // Collect the litter
                    if (cell == 'L') {
                        newMask &= ~(1 << litterIndex[newRow][newCol]);
                    }

                    if (!visited[newRow][newCol][newEnergy][newMask]) {
                        visited[newRow][newCol][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                                newRow, newCol, newEnergy, newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}