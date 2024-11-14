import java.util.Random;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность матрицы (n): ");
        int n = scanner.nextInt();
        scanner.close();

        int[][] matrix = new int[n][n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(15) - n;
            }
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(matrix);

        for (int i = 0; i < n; i++) {
            transformRow(matrix[i]);
        }

        System.out.println("\nПреобразованная матрица:");
        printMatrix(matrix);
    }

    private static void transformRow(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            while (left < right && row[left] != 0) {
                left++;
            }
            while (left < right && row[right] == 0) {
                right--;
            }
            if (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
