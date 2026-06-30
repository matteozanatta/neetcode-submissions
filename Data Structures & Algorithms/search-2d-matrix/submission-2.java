class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix[0].length) * (matrix.length) - 1;

        while(left <= right){

            int mid = left + ((right - left) >>> 1);

            int midRow = (int) mid / matrix[0].length;
            int midCol = (int) mid % matrix[0].length;

            if(matrix[midRow][midCol] == target) return true;

            if(matrix[midRow][midCol] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }
}
