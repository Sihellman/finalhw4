package plain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class prob1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter file name");
        String fileName = keyboard.next();
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(fileName);

            System.out.println("enter text, and press enter, -1 when finished");
            boolean boo = true;
            while (boo) {
                String line = keyboard.nextLine();
                if (line.equals("-1")) {
                    boo = false;
                } else {
                    outputStream.println(line);
                }
            }
            outputStream.close();
            System.out.println("Those lines were written to " +
                    fileName);
            Scanner inputStream = null;
            System.out.println("The file " + fileName +
                    "\ncontains the following lines:\n");
            int lines = 0;
            int words = 0;
            int chars = 0;

            try {
                File file = new File(fileName);
                inputStream = new Scanner(file);
                String line = "";
                if (inputStream.hasNextLine()) {
                    line = inputStream.nextLine();
                }
                while (inputStream.hasNextLine()) {
                    line = inputStream.nextLine();
                    lines++;
                    char[] array = new char[line.length()];
                    for (int i = 0; i < line.length(); i++){
                        array[i] = line.charAt(i);
                        if (array[i] != ' '){
                            chars++;
                        }

                    }
                    if (array[0] != ' '){
                        words++;
                    }
                    for (int i = 0; i < array.length; i++){
                        if ((array[i] == ' ') && (i != line.length() - 1)){
                            if (array[i] + 1 != ' '){
                                words++;
                            }
                        }
                    }
                }
                System.out.println("lines: " + lines + ", words: " + words + ", non blank characters: " + chars);

            } catch (FileNotFoundException e) {
                System.out.println("Error opening the file " + fileName);
                //System.exit(0);
            }

            finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            //System.exit(0);
        }
    }
}
