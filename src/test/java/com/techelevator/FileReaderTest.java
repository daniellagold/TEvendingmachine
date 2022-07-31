package com.techelevator;

import com.techelevator.application.FileReader;
import org.junit.Test;
import org.mockito.Matchers;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void readFilePassInListIndex4ReturnStackers(){
        FileReader fileReader= new FileReader();
        String expected = "Stackers";
        String actual = fileReader.readFile().get(4).getItemName();
        assertEquals(expected,actual);

    }

    @Test
    public void readFilePassInIndex9Return7Down(){
        FileReader fileReader = new FileReader();
        String expected = "7Down";
        String actual = fileReader.readFile().get(9).getItemName();
        assertEquals(expected, actual);
    }


    @Test
    public void readFilePassInIndex13ReturnMunchy(){
        FileReader fileReader = new FileReader();
        String expected = "Munchy";
        String actual = fileReader.readFile().get(13).getType();
        assertEquals(expected, actual);

    }

    @Test
    public void readFilePassInIndex8ReturnPrice(){
        FileReader fileReader = new FileReader();
            BigDecimal expected= BigDecimal.valueOf(2.25);
            BigDecimal actual = fileReader.readFile().get(8).getPrice();
            assertTrue(actual.compareTo(expected)==0);

}
}
