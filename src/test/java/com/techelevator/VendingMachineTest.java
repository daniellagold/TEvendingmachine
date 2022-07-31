package com.techelevator;

import com.techelevator.application.FileReader;
import com.techelevator.application.VendingMachine;

import com.techelevator.models.VendingMachineItems;
import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineTest {

    @Test
    public void getChangePassThreeFortyReturnThreeDollars(){
        VendingMachine vendingMachine = new VendingMachine();

        BigDecimal expected = BigDecimal.valueOf(0.00);
        BigDecimal actual =    vendingMachine.getChange(BigDecimal.valueOf(3.40));
        assertTrue(actual.compareTo(expected)==0);

    }

    @Test
    public void vendingItemPassB2Dollar5ReturnChange(){

        VendingMachine vendingMachine = new VendingMachine();
        FileReader fileReader = new FileReader();

        vendingMachine.setVendingMachineItemList(fileReader.readFile());

        BigDecimal expected = BigDecimal.valueOf(1.55);
       BigDecimal actual = vendingMachine.vendingItem("B2", BigDecimal.valueOf(5));

        assertTrue(actual.compareTo(expected)==0);

    }
    @Test
    public void vendingItemPassE2Dollar5ReturnInvalidSlot(){

        VendingMachine vendingMachine = new VendingMachine();
        FileReader fileReader = new FileReader();

        vendingMachine.setVendingMachineItemList(fileReader.readFile());

        BigDecimal expected = BigDecimal.valueOf(5);
        BigDecimal actual = vendingMachine.vendingItem("E2", BigDecimal.valueOf(5));

        assertTrue(actual.compareTo(expected)==0);

    }

    @Test
    public void vendingItemPassD2Dollar0Return0(){

        VendingMachine vendingMachine = new VendingMachine();
        FileReader fileReader = new FileReader();

        vendingMachine.setVendingMachineItemList(fileReader.readFile());

        BigDecimal expected = BigDecimal.valueOf(0);
        BigDecimal actual = vendingMachine.vendingItem("D2", BigDecimal.valueOf(0));

        assertTrue(actual.compareTo(expected)==0);

    }


    @Test
    public void vendingItemPassA1Dollar10ReturnChange(){

        VendingMachine vendingMachine = new VendingMachine();
        FileReader fileReader = new FileReader();

        vendingMachine.setVendingMachineItemList(fileReader.readFile());

        BigDecimal expected = BigDecimal.valueOf(8.35);
        BigDecimal actual = vendingMachine.vendingItem("A1", BigDecimal.valueOf(10));

        assertTrue(actual.compareTo(expected)==0);

    }
}
