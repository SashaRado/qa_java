package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        String expected = "Мяу";
        String actual = cat.getSound();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFood() throws Exception {
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();

    }
}