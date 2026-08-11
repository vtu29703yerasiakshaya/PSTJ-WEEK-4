import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        
        // Create an answer grid to store the rotated matrix values safely
        int[][] result = new int[m][n];
        
        // Calculate total layers based on the smaller matrix dimension
        int layers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();
            
            // Define layer boundaries
            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;
            
            // 1. Traverse top row (left to right)
            for (int j = left; j <= right; j++) {
                elements.add(matrix.get(top).get(j));
            }
            // 2. Traverse right column (top + 1 to bottom)
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix.get(i).get(right));
            }
            // 3. Traverse bottom row (right - 1 down to left)
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix.get(bottom).get(j));
            }
            // 4. Traverse left column (bottom - 1 down to top + 1)
            for (int i = bottom - 1; i >= top + 1; i--) {
                elements.add(matrix.get(i).get(left));
            }
            
            // Calculate effective rotation using modulo
            int size = elements.size();
            int effectiveRotation = r % size;
            
            // Write elements back into the result grid shifted anti-clockwise
            int index = effectiveRotation;
            
            // Put back into top row
            for (int j = left; j <= right; j++) {
                result[top][j] = elements.get(index);
                index = (index + 1) % size;
            }
            // Put back into right column
            for (int i = top + 1; i <= bottom; i++) {
                result[i][right] = elements.get(index);
                index = (index + 1) % size;
            }
            // Put back into bottom row
            for (int j = right - 1; j >= left; j--) {
                result[bottom][j] = elements.get(index);
                index = (index + 1) % size;
            }
            // Put back into left column
            for (int i = bottom - 1; i >= top + 1; i--) {
                result[i][left] = elements.get(index);
                index = (index + 1) % size;
            }
        }
        
        // Print the finalized matrix
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]);
                if (j < n - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
