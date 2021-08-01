

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

30 days challenge

Day 11
Hackerrank https://www.hackerrank.com/challenges/30-2d-arrays/problem

 */
public class HourGlassProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int matrixSize = 6;
        Integer[][] matrix = arr.stream().map(
                l -> l.stream().toArray(Integer[]::new)
        ).toArray(Integer[][]::new);

        int maxValue = -9 * 6;
        for (int i = 0; i < matrixSize - 2; i++) {
            for (int j = 0; j < matrixSize - 2; j++) {

                Integer sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j + 1] + matrix[i + 2][j]
                        + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (sum > maxValue)
                    maxValue = sum;
            }
        }
        System.out.println(maxValue);
        bufferedReader.close();
    }
}
