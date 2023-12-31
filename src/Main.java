import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
            System.out.println(input);
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


           String[] myArray = s.split(" ");
            System.out.println(i);
            pfade(myArray);

           // String s1 = s.substring(0, s.indexOf(' '));
            //String s2 = s.substring(s.indexOf(' ') + 1);
            /*y1 = Integer.parseInt(s1.substring(0, s1.indexOf(',')));
            x1 = Integer.parseInt(s1.substring(s1.indexOf(',') + 1));

            y2 = Integer.parseInt(s2.substring(0, s2.indexOf(',')));
            x2 = Integer.parseInt(s2.substring(s2.indexOf(',') + 1));

            System.out.println(Arr[x1][y1] +""+ x1 + "," + y1);
            System.out.println(Arr[x2][y2] +""+ x2 + "," + y2);
            //System.out.println(x1 + " " + y1);


            if (rec(x1, y1, x2, y2, Arr)) {
                writer.write("SAME" + "\n");
            } else {
                writer.write("DIFFERENT" + "\n");

//            writer.write(Arr[Integer.parseInt(s.substring(s.indexOf(',')+1))][Integer.parseInt(s.substring(0, s.indexOf(',')))] + "\n");
            }*/
        }
    }
    public static boolean checkDups (String[]myArray){
        int y1, x1;

        for (int i = 0; i < myArray.length; i++) {
            y1 = Integer.parseInt(myArray[i].substring(0, myArray[i].indexOf(',')));
            x1 = Integer.parseInt(myArray[i].substring(myArray[i].indexOf(',') + 1));

            for(int j = i+1; j<myArray.length; j++){
                if(y1 == Integer.parseInt(myArray[j].substring(0, myArray[j].indexOf(','))) &&
                    x1 == Integer.parseInt(myArray[j].substring(myArray[j].indexOf(',') + 1))){
                    System.out.println("Dupe gefunden: " + y1 +" " + x1);
                    return true;
                }
            }

        }
        return false;
    }

        public static boolean pfade(String[] myArray){
            int x1, y1;
            if(checkDups(myArray)){
                System.out.println("Dupes vorhanden");
                return false;
            }

            ArrayList<double[]> diagonal = new ArrayList<>();

            int[][] arr = new int[myArray.length][2];


                for (int i = 0; i < myArray.length; i++) {
                    y1 = Integer.parseInt(myArray[i].substring(0, myArray[i].indexOf(',')));
                    x1 = Integer.parseInt(myArray[i].substring(myArray[i].indexOf(',') + 1));

                    //if(myArray[i].substring((4)).contains())

                    System.out.println(x1 + " " + y1);
                    arr[i][0] = x1;
                    arr[i][1] = y1;
                }
                System.out.println(Arrays.deepToString(arr));

                for (int i = 0; i < myArray.length - 1; i++) {
                    if (Math.abs(arr[i][0] - arr[i + 1][0]) + Math.abs(arr[i][0] - arr[i + 1][0]) > 1) { //gehst du gerade diagonaL?
                        double[] temp = new double[2];
                        temp[0] = arr[i][0] + arr[i+1][0] / 2.0;
                        temp[1] = arr[i][1] + arr[i+1][1] / 2.0;
                        diagonal.add(temp);
                    }
                }
                diagonal.toArray();

                return false;
            }

       /* public static boolean rec(int x1, int y1, int x2, int y2, char[][] field){
            //System.out.println(x1 + "," + y1);
            if (x1 == x2 && y1 == y2) {
                //System.out.println("success!");
                return true;
            } else if (x1 >= field.length || y1 >= field[0].length) {
                return false;
            } else if (field[x1][y1] == 'W') {
                //System.out.println("Ran into water");
                return false;
            }else if(field[x1][y1] == 'V'){
                //System.out.println("Ran into visited");
                return false;
            }else if (field[x1][y1] == 'L') {
                //System.out.println("one step");
                field[x1][y1] = 'V';

                return rec(x1 + 1, y1, x2, y2, field.clone()) ||
                        rec(x1 - 1, y1, x2, y2, field.clone()) ||
                        rec(x1, y1 + 1, x2, y2, field.clone()) ||
                        rec(x1, y1 - 1, x2, y2, field.clone());
            }else {
                return false;
            }



        }*/


        //write result to file
        //writer.write(result + "\n");
    }


