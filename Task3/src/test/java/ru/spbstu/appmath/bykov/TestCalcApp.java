/**
 * Created by Андрей on 25.01.2016.
 */

package ru.spbstu.appmath.bykov;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestCalcApp {
    private Parser p = new Parser();

    private static Object[][] TEST_DATA = {
            {"x",0.0},
            {"(5 + x) / x",6.0},
            {"x - 4.32 + 5 * (-1.9 + x)",17.18},
            {"x + x * 2 + x * 3 + (x * 4 + 3)",33.0},
            {"-5.0",-5.0},
            {"7.32 * 5 - (x * 10)/(x - 10) ",46.6},
            {"(((x + 3) + 3) + 2) * 2)"},
            {"(x + 33.33) * x / ((x) - 3.0)"}
    };

    @Test
    public void test() throws Exception{
        for (int i = 0; i < 6; i++) {
            Expression f = p.parse((String) TEST_DATA[i][0]);
            Assert.assertEquals(f.calc(i), TEST_DATA[i][1]);
        }
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testException1() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Syntax error");
        Expression f = p.parse((String) TEST_DATA[6][0]);
        double result = f.calc(6);
        System.out.println(result);
    }


    @Test
    public void testException2() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Calculation error");
        Expression f = p.parse((String) TEST_DATA[7][0]);
        double result = f.calc(3);
        System.out.println(result);
    }


}