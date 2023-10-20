import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //settings
    private final static String inputPath = "src/input/";
    private final static String outputPath = "src/output/";
    private final static boolean isDebug = false;

    //DO NOT CHANGE METHOD
    public static void main(String[] args) {
        IOManager ioManager = new IOManager(inputPath, outputPath, isDebug);
        ioManager.execute();
    }

    //method for reading input from input file and writing solution to output file
    //gets applied to all given input files
    //example of a program to output line length of each line
    //DO NOT CHANGE PARAMETERS OR RETURN TYPE
    public static void solve(Scanner reader, FileWriter writer) throws IOException {
        //read lines from input
        //and write to file using: writer.write(result + "\n");
        int n = reader.nextInt();
        String input;
        char[][] Arr = new char[n][n];
        reader.nextLine();

        for (int i = 0; i < n; i++) {
            input = reader.nextLine();
            for (int j = 0; j < n; j++) {
                Arr[i][j] = input.charAt(j);
            }
        }

        int o = reader.nextInt();
        reader.nextLine();
        String s;
        int x1, x2, y1, y2;
        for (int i = 0; i < o; i++) {
            s = reader.nextLine();


            String s1 = s.substring(0, s.indexOf(' '));
            String s2 = s.substring(s.indexOf(' ') + 1);
            y1 = Integer.parseInt(s1.substring(0, s1.indexOf(',')));
            x1 = Integer.parseInt(s1.substring(s1.indexOf(',') + 1));

            y2 = Integer.parseInt(s2.substring(0, s2.indexOf(',')));
            x2 = Integer.parseInt(s2.substring(s2.indexOf(',') + 1));

            System.out.printf("1 Punkt: " + Arr[x1][y1]);
            System.out.println(" | 2 Punkt: " + Arr[x2][y2]);

            if (rec(x1, y1, x2, y2, copy(Arr))) {
                writer.write("SAME" + "\n");
            } else {
                writer.write("DIFFERENT" + "\n");

//            writer.write(Arr[Integer.parseInt(s.substring(s.indexOf(',')+1))][Integer.parseInt(s.substring(0, s.indexOf(',')))] + "\n");
            }
        }
    }


    public static boolean rec(int x1, int y1, int x2, int y2, char[][] field) {
        if (x1 == x2 && y1 == y2) {
            return true;
        } else if (field[x1][y1] == 'W' || field[x1][y1] == 'V'){
            return false;
        }
        field[x1][y1] = 'V';

        return rec(x1 + 1, y1, x2, y2, field) ||
                rec(x1 - 1, y1, x2, y2, field) ||
                rec(x1, y1 + 1, x2, y2, field) ||
                rec(x1, y1 - 1, x2, y2, field);
    }

    public static char[][] copy(char[][] arr) {
        if (arr == null) {
            return null;
        }

        int rows = arr.length;
        if (rows == 0) {
            return new char[0][0];
        }

        int cols = arr[0].length;
        char[][] copiedArray = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copiedArray[i][j] = arr[i][j];
            }
        }

        return copiedArray;
    }


}




