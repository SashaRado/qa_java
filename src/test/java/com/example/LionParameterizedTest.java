package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        Feline feline = new Feline();  // Создаем экземпляр класса Feline
        Lion lion = new Lion(sex, feline);  // Используем инъекцию зависимостей
        boolean actualHasMane = lion.doesHaveMane();  // Используем метод doesHaveMane()
        Assert.assertEquals(hasMane, actualHasMane);
    }
}