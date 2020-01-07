package com.alexromanov.cuconv.service;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class MoneyConverterServiceTest {
    @Parameterized.Parameters
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][]{
                {"2310000.159897", "2 310 000.16"},
                {"1600", "1 600.00"},
                {"0", "0.00"},
                {"-123456.456", "-123 456.46"},
                {"123234,456", "123 234.46"},
                {".", ""},
                {",", ""},
                {"111.", "111.00"},
                {".222", "0.22"},
                {null, null}
        });
    }

    @Parameterized.Parameter
    public String input;

    @Parameterized.Parameter(1)
    public String expected;

    private MoneyConverterService moneyConverterService;

    @Before
    public void beforeTest() {
        moneyConverterService = new MoneyConverterService();
    }

    @Test
    public void shouldConvertValue() {
        assertThat(expected)
                .as("Invalid result of money conversion")
                .isEqualTo(moneyConverterService.formatMoney(input));
    }
}
