package problemsolving;

import java.io.*;
import java.util.stream.*;

public class DiagonalDifference {
    static class Result {

        /*
         * Complete the 'diagonalDifference' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */

        public static int diagonalDifference(Integer[][] arr) {
            int dp = 0, ds = 0;
            for(int i = 0; i < arr.length; i++){
                dp += arr[i][i];
                ds += arr[i][arr.length-i-1];
            }
            return Math.abs(dp-ds);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Integer[][] arr = new Integer[n][n];

        IntStream.range(0, n).forEach(i -> {
            try {
                arr[i] = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "")
                        .split(" "))
                        .map( Integer::parseInt)
                        .toArray(Integer[]::new);



            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

