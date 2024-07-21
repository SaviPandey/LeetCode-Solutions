class Solution {
        public int[][] restoreMatrix(int[] row, int[] col) {
        int m = row.length, n = col.length;
        int[][] validMatrix = new int[m][n];
            
        int i = 0, j = 0;
        while(i < m && j < n) {
            validMatrix[i][j] = Math.min(row[i], col[j]);
            row[i] -= validMatrix[i][j];
            col[j] -= validMatrix[i][j];
            
            if(row[i] == 0) {
                i++;
            } else {
                j++;
            }
        }
        return validMatrix;
    }
}