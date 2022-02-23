package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
        ArrayList<AdressZip> listOfZipsAndCities = new ArrayList<AdressZip>();

        int zip;
        String adress;

        try {
            File fileToRead = new File("data/AdressZips.csv");
            Scanner myReader = new Scanner(fileToRead);

            while (myReader.hasNext()) {
                String[] splitNextLine = myReader.nextLine().split(",");

                zip = Integer.parseInt(splitNextLine[0]);
                adress = splitNextLine[1];

                listOfZipsAndCities.add(new AdressZip(adress, zip));
            }


        } catch (FileNotFoundException e)
        {
            System.out.println("An error occured");
        }

        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        int userInput = 0;
        int userInputZip = 0;

        while (isRunning)
        {
            System.out.println("What do you want to do?");
            System.out.println("""
                                        
                    0: Cancel
                    1: Check zip nr.?
                    """);

            userInput = input.nextInt();

            if (userInput == 1)
            {
                System.out.println("What zip number do you wanna search by? (Note - if the number starts with 0, don't include that in search)");
                userInputZip = input.nextInt();


                switch (userInput)
                {
                    case 0:
                        isRunning = false;
                        break;
                    case 1:
                        for (AdressZip adressAndZip : listOfZipsAndCities
                        ) {
                            if (adressAndZip.getZip() == userInputZip) {
                                System.out.println(adressAndZip);
                            }
                        }
                        break;
                }
            }
        }
    }
}
