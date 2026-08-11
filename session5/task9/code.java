class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int sum = 0;

                // Find the valid row boundaries
                int startRow = Math.max(0, i - k);
                int endRow = Math.min(m - 1, i + k);

                // Find the valid column boundaries
                int startCol = Math.max(0, j - k);
                int endCol = Math.min(n - 1, j + k);

                // Add all elements inside the block
                for (int r = startRow; r <= endRow; r++) {

                    for (int c = startCol; c <= endCol; c++) {
                        sum += mat[r][c];
                    }
                }

                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
