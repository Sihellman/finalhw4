package binary;

import dataObject.Species;

import java.io.*;
import java.util.Scanner;

public class prob2 {
    public static void main(String[] args) {
        String resourceFolder2 = "src/main/resources";
        String file2Name2 = resourceFolder2 + "/" + "Species.txt";
        Scanner inputStream2 = null;
        int count = 0;
        try {
            File file2 = new File(file2Name2);
            inputStream2 = new Scanner(file2);
            String line = inputStream2.nextLine();


            while (inputStream2.hasNextLine()) {
                line = inputStream2.nextLine();
                count++;

            }

        } catch (IOException e) {
            System.out.println("Problem with input from file2 " + file2Name2 + ": " + e.getMessage());
        } finally {
            if (inputStream2 != null) {
                inputStream2.close();
            }
        }

        Species[] array = new Species[count];
        String resourceFolder = "src/main/resources";
        String fileName = resourceFolder + "/" + "Species.txt";
        Scanner inputStream = null;

        try {
            File file = new File(fileName);
            inputStream = new Scanner(file);
            String line = inputStream.nextLine();
            System.out.println("Header line is: " + line);




            int i = -1;
            while (inputStream.hasNextLine()) {

                line = inputStream.nextLine();
                i++;


                String[] dataArray = line.split(",");

                String name = dataArray[0];
                int population = Integer.parseInt(dataArray[1]);
                double growthRate = Double.parseDouble(dataArray[2]);

                Species obj = new Species(name, population, growthRate);
                System.out.println("read " + name + " " + population + " " + growthRate + "%");
                array[i] = obj;



            }
        } catch (IOException e) {
            System.out.println("Problem with input from file " + fileName + ": " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        String resourceFolder3 = "src/main/resources";
        String fileName3 = resourceFolder3 + "/" + "species.dat";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream (new FileOutputStream(fileName3))){
            objectOutputStream.writeObject (array);
        } catch (FileNotFoundException e) {
            System.out.println ("FileNotFoundException thrown writing to file " + fileName3 + ":" + e.getMessage());
        } catch (IOException e) {
            System.out.println ("IOException thrown writing to file " + fileName3 + ":" + e.getMessage());
        }
        System.out.println ("Array written to file " + fileName3 + " and file is closed.");
    }
}
