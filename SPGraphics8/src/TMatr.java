public class TMatr {
    private int[][] matrix;
    private int rows;
    private int cols;

    public TMatr(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }

    public void setRows(int newRows) {
        if (newRows <= 0) {
            throw new IllegalArgumentException("Число строк должно быть больше 0.");
        }
        int[][] newMatrix = new int[newRows][cols];
        for (int i = 0; i < Math.min(newRows, rows); i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, cols);
        }
        matrix = newMatrix;
        rows = newRows;
    }

    public void setCols(int newCols) {
        if (newCols <= 0) {
            throw new IllegalArgumentException("Число столбцов должно быть больше 0.");
        }
        int[][] newMatrix = new int[rows][newCols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < Math.min(newCols, cols); j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        matrix = newMatrix;
        cols = newCols;
    }

    public void printSubmatrix(int startRow, int startCol, int endRow, int endCol) {
        if (startRow < 0 || startCol < 0 || endRow >= rows || endCol >= cols || startRow > endRow || startCol > endCol) {
            throw new IllegalArgumentException("Неверные координаты подматрицы.");
        }

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int get(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы матрицы.");
        }
        return matrix[row][col];
    }

    public void set(int row, int col, int value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы матрицы.");
        }
        matrix[row][col] = value;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
