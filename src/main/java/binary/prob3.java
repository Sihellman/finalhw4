package binary;

import dataObject.Species;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class prob3 {
    public static void main(String[] args) {

        String resourceFolder = "src/main/resources";
        String fileName = resourceFolder + "/" + "species.dat";
        Species[] readFromFileSpecies = null;
        try (ObjectInputStream inputStream = new ObjectInputStream (new FileInputStream(fileName))) {
            readFromFileSpecies = (Species[]) inputStream.readObject ();
        } catch (Exception e) {
            System.out.println ("Error reading file " + fileName + ": " + e.getMessage());
        }


        System.out.println("The following were read from the file " + fileName + ":");
        assert readFromFileSpecies != null;
        for (Species readFromFileSpecy : readFromFileSpecies) {
            System.out.println(readFromFileSpecy.toString());
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter filename");


        String fileName2 = "src/main/resources/" + keyboard.next();

        PrintWriter printWriter = null;
        try {

            printWriter = new PrintWriter(fileName2);

            for (Species readFromFileSpecy : readFromFileSpecies) {
                printWriter.println("Name: " + readFromFileSpecy.getName());
                printWriter.println("Population: " + readFromFileSpecy.getPopulation());
                printWriter.println("Growth Rate: " + readFromFileSpecy.getGrowthRate() + "%");
                printWriter.println();
            }
            System.out.println("species objects were written to " + fileName2);



        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName2 + ": " + e.getMessage());
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }
}
