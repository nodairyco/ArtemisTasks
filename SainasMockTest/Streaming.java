import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class Streaming {
    private static String[] filePaths = new String[3];

    public static void main(String[] args) {
        filePaths[0] = args[0];
        filePaths[1] = args[1];
        filePaths[2] = args[2];
        writeToIntFile();
        writeToStringFile();
    }

    public static Stream<String> returnOnlyIntegers(Stream<String> stream){
        return stream
                .filter(stringToIntPredicate);
    }

    public static Stream<String> returnOnlyStrings(Stream<String> stream){
        return stream
                .filter(stringToStringPredicate)
                .filter(stringy -> !stringToIntPredicate.test(stringy))
                .map(String::toUpperCase);
    }

    //Aux methods for using
    public static Predicate<String> stringToIntPredicate = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            try {
                int x = Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e){
                return false;
            }
        }
    };

    public static Predicate<String> stringToStringPredicate = new Predicate<String>() {

        @Override
        public boolean test(String s) {
            Pattern pattern = Pattern.compile("[*(&!&#@ *_!@((]");

            Matcher matcher = pattern.matcher(s);
            return !matcher.find();
        }
    };

    static Stream<String> getLinesOfFile(final String filePath) {
        try {
            return Files.lines(Path.of(filePath));
        } catch (IOException e) {
            return Stream.empty();
        }
    }

    //writes to the intFile
    public static void writeToIntFile(){

        Stream<String> stream = getLinesOfFile(filePaths[0]);

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(filePaths[1]);
            List<String> intList = returnOnlyIntegers(stream).toList();

            for(String i : intList){
                fileOutputStream.write(i.getBytes());
                fileOutputStream.write(System.lineSeparator().getBytes());
            }

            fileOutputStream.close();

        } catch (IOException e){

            System.out.println(e);

        }
    }

    //writes to the stringFile
    public static void writeToStringFile(){

        Stream<String> stream = returnOnlyStrings(getLinesOfFile(filePaths[0]));

        try{

            FileOutputStream fileOutputStream = new FileOutputStream(filePaths[2]);
            List<String> stringList = stream.toList();

            for(String i : stringList){
                fileOutputStream.write(i.getBytes());
                fileOutputStream.write(System.lineSeparator().getBytes());
            }

            fileOutputStream.close();

        } catch (IOException e){
            System.out.println(e);
        }
    }
}
