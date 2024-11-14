public class Main {
    public static void main(String[] args) throws Exception {
        TMatr matr = new TMatr(3, 4);

        for (int i = 0; i < matr.getRows(); i++) {
            for (int j = 0; j < matr.getCols(); j++) {
                matr.set(i, j, i * matr.getCols() + j + 1);
            }
        }

        System.out.println("Матрица:");
        matr.printMatrix();

        matr.setRows(5);

        System.out.println("\nПодматрица:");
        matr.printSubmatrix(1, 1, 3, 3);
    }
}
