class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = (rows * columns) - 1;

        while(left <= right){
            int mid = left + ((right - left) >>> 1);

            int midRow = mid / columns;
            int midCol = mid % columns;

            if(matrix[midRow][midCol] == target){
                return true;
            }

            if(matrix[midRow][midCol] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }
}
