package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;

public class DealershipFileManager {

    //create derived methods

    //method to load and read inventory.csv file
    public Dealership getDealership(){

        Dealership dealership = null;

        //read the file line by line
        try {
            //create a file reader to read the file
            FileReader readFile = new FileReader("src/main/resources/inventory.csv");

            //create the buffered reader to read the file
            BufferedReader bufRead = new BufferedReader(readFile);

            //skips header row
            String header = bufRead.readLine();

            String line;

            //while loop
            while ((line = bufRead.readLine()) != null) {

                //split the line into different pieces
                String[] pieces = line.split("\\|");

                //if statement for pieces of the line
                if (pieces.length == 5) {

                    //parse the pieces of the line to be for the user to read
                    LocalDate date = LocalDate.parse(pieces[0].trim());
                    LocalTime time = LocalTime.parse(pieces[1].trim());
                    String description = pieces[2].trim();
                    String vendor = pieces[3].trim();
                    Double amount = Double.parseDouble(pieces[4].trim());

                    //create a new transaction
                    //Dealership d = new Dealership();

                    //add the product to our transaction ArrayList
                    //Dealership.add(d);
                }
            }
            //close the buffered reader so it can read the file
            bufRead.close();

        } catch (Exception e) {

            //if we run into an issue reading the file, display this instead
            System.out.println("Error reading the file ❌" + e.getMessage());
        }
        //return
        return dealership;
        }
    }
    //method to overwrite the inventory.csv file
    //saveDealership(dealership){}