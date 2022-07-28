package com.techelevator.application;

import com.techelevator.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public List<VendingMachineItems> readFile() {

        List<VendingMachineItems> vendingMachineList = new ArrayList<>();
        File file = new File("catering.csv");

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] foodDetails = line.split(",");
                // reading through the catering file and loading the information into the food details array, making an entry for every value separated by a comma.
                //vendingMachineList.add( new VendingMachineItems(foodDetails[0], foodDetails [1], foodDetails[2], foodDetails[3]));
                if (foodDetails[3].equals("Munchy")) {
                    vendingMachineList.add(new Munchy(foodDetails[0], foodDetails[1], foodDetails[2], foodDetails[3]));
                } else if (foodDetails[3].equals("Drink")) {
                    vendingMachineList.add(new Drink(foodDetails[0], foodDetails[1], foodDetails[2], foodDetails[3]));
                } else if (foodDetails[3].equals("Candy")) {
                    vendingMachineList.add(new Candy(foodDetails[0], foodDetails[1], foodDetails[2], foodDetails[3]));
                } else if (foodDetails[3].equals("Gum")) {
                    vendingMachineList.add(new Gum(foodDetails[0], foodDetails[1], foodDetails[2], foodDetails[3]));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return vendingMachineList;
    }
}

