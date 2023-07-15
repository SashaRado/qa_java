package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensNoParam() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensAmountPositive() {
        int expected = 5;
        int actual = feline.getKittens(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensAmountNegative() {
        int expected = -1;
        int actual = feline.getKittens(-1);
        Assert.assertEquals(expected, actual);
    }
}