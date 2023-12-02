package fop.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class CsvStreams {

    public static void main(final String[] args) {
        final Stream<String> csvFilePaths;
        final Stream<String> lines;
        final Stream<Integer[]> rows;
        final Integer[] columnSums;

        csvFilePaths = filterCsvFilePaths(getFiles());
        lines = getAllLines(csvFilePaths);
        rows = parseLines(lines);
        columnSums = sumColumns(rows);

        System.out.println(Arrays.toString(columnSums));
    }

    static Stream<String> filterCsvFilePaths(final Stream<String> filePaths) {
        // TODO
        return filePaths.filter(n -> n.endsWith(".csv"));
    }
    static Stream<String> getAllLines(final Stream<String> csvFilePaths) {
        // TODO
        return csvFilePaths.flatMap(CsvStreams::getLinesOfFile);
    }
    static Stream<Integer[]> parseLines(final Stream<String> lines) {
        return lines.filter(Objects::nonNull)
                .map(parsingLines);
    }

    static Integer[] sumColumns(final Stream<Integer[]> rows) {
        // TODO
        return rows.reduce(CsvStreams::addArrays).orElse(new Integer[0]);
    }
    // Auxiliary methods possibly used for implementation!
    static private final Function<String, Integer[]> parsingLines = (lines) ->{
        String[] arr = lines.split(",");
        Integer[] temporaryArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temporaryArray[i] = Integer.parseInt(arr[i]);
        }
        return temporaryArray;
    };
    // returns the paths to all files in the current directory as Stream<String>. 

    static Stream<String> getFiles() {
        try {
            return Files.list(Paths.get(".")).map(Path::toString);
        } catch (IOException e) {
            return Stream.of();
        }
    }

    // returns all lines in a file as Stream<String>.
    
    static Stream<String> getLinesOfFile(final String filePath) {
        try {
            return Files.lines(Path.of(filePath));
        } catch (IOException e) {
            return Stream.empty();
        }
    }

    // adds element-wise two Integer arrays.
    
    static Integer[] addArrays(final Integer[] arr1, final Integer[] arr2) {
        Integer[] res = new Integer[5];
        for (int i = 0; i < 5; i++)
            res[i] = arr1[i] + arr2[i];
        return res;
    }

    // transforms an Integer Stream into an Integer array.
    static Integer[] intStreamToIntArray(final Stream<Integer> intStream) {
        return intStream.toArray(Integer[]::new);
    }

    // transforms an arbitrary array into a stream.
    static <T> Stream<T> arrayToStream(final T[] array) {
        return Arrays.stream(array);
    }
}
