package problemsolving;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
public class Grading {
    static class Result {

        public static void gradingStudents(Integer[] grades) {
            for(int i = 0; i < grades.length; i++){
                if( grades[i] < 38 ) continue;
                int diff = 5-grades[i]%5;
                if( diff < 3) grades[i]+=diff;
            }
            System.out.println(Arrays.toString(grades));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        Integer[] grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Result.gradingStudents(grades);
        System.out.println(Arrays.toString(grades));

        bufferedWriter.write(
                Arrays.stream(grades)
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
