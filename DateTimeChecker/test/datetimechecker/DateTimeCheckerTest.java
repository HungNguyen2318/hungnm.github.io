/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetimechecker;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Acer
 */
public class DateTimeCheckerTest {

    @Test
    public void testDayInMonthCaseMonthOutOfRange1() {
        Assert.assertEquals(0, DateTimeChecker.dayInMonth(-23, 1000));
    }

    @Test
    public void testDayInMonthCaseMonthOutOfRange2() {
        Assert.assertEquals(0, DateTimeChecker.dayInMonth(0, 2019));
    }

    @Test
    public void testDayInMonthCaseMonthOutOfRange3() {
        Assert.assertEquals(0, DateTimeChecker.dayInMonth(13, 2016));
    }

    @Test
    public void testDayInMonthCaseMonthOutOfRange4() {
        Assert.assertEquals(0, DateTimeChecker.dayInMonth(23, 1001));
    }

    @Test
    public void testDayInMonthCaseYearOutOfRange1() {
        Assert.assertEquals(0, DateTimeChecker.dayInMonth(10, -123));
    }

    @Test
    public void testDayInMonthCaseYearOutOfRange2() {
        Assert.assertEquals(0, DateTimeChecker.dayInMonth(11, 999));
    }

    @Test
    public void testDayInMonthCaseYearOutOfRange3() {
        Assert.assertEquals(0, DateTimeChecker.dayInMonth(12, 3001));
    }

    @Test
    public void testDayInMonthCaseYearOutOfRange4() {
        Assert.assertEquals(0, DateTimeChecker.dayInMonth(9, 4000));
    }

    @Test
    public void testDayInMonthCaseJan() {
        Assert.assertEquals(31, DateTimeChecker.dayInMonth(1, 1000));
    }

    @Test
    public void testDayInMonthCaseMar() {
        Assert.assertEquals(31, DateTimeChecker.dayInMonth(3, 2999));
    }

    @Test
    public void testDayInMonthCaseMay() {
        Assert.assertEquals(31, DateTimeChecker.dayInMonth(5, 2999));
    }

    @Test
    public void testDayInMonthCaseJul() {
        Assert.assertEquals(31, DateTimeChecker.dayInMonth(7, 1001));
    }

    @Test
    public void testDayInMonthCaseAug() {
        Assert.assertEquals(31, DateTimeChecker.dayInMonth(8, 1000));
    }

    @Test
    public void testDayInMonthCaseOct() {
        Assert.assertEquals(31, DateTimeChecker.dayInMonth(10, 2019));
    }

    @Test
    public void testDayInMonthCaseDec() {
        Assert.assertEquals(31, DateTimeChecker.dayInMonth(12, 2019));
    }

    @Test
    public void testDayInMonthCaseApr() {
        Assert.assertEquals(30, DateTimeChecker.dayInMonth(4, 3000));
    }

    @Test
    public void testDayInMonthCaseJun() {
        Assert.assertEquals(30, DateTimeChecker.dayInMonth(6, 2019));
    }

    @Test
    public void testDayInMonthCaseSep() {
        Assert.assertEquals(30, DateTimeChecker.dayInMonth(9, 1001));
    }

    @Test
    public void testDayInMonthCaseNov() {
        Assert.assertEquals(30, DateTimeChecker.dayInMonth(11, 2999));
    }

    @Test
    public void testDayInMonthCase29Feb1() {
        Assert.assertEquals(29, DateTimeChecker.dayInMonth(2, 2016));
    }
    @Test
    public void testDayInMonthCase29Feb2() {
        Assert.assertEquals(29, DateTimeChecker.dayInMonth(2, 2000));
    }
    @Test
    public void testDayInMonthCase28Feb1() {
        Assert.assertEquals(28, DateTimeChecker.dayInMonth(2, 2019));
    }
    @Test
    public void testDayInMonthCase28Feb2() {
        Assert.assertEquals(28, DateTimeChecker.dayInMonth(2, 2100));
    }

    @Test
    public void testIsValidDayCaseDayOutOfRange1() {
        Assert.assertFalse(DateTimeChecker.isValidDate(-23, 1, 1000));
    }

    @Test
    public void testIsValidDayCaseDayOutOfRange2() {
        Assert.assertFalse(DateTimeChecker.isValidDate(0, 2, 1001));
    }

    @Test
    public void testIsValidDayCaseDayOutOfRange3() {
        Assert.assertFalse(DateTimeChecker.isValidDate(32, 3, 2016));
    }

    @Test
    public void testIsValidDayCaseDayOutOfRange4() {
        Assert.assertFalse(DateTimeChecker.isValidDate(50, 4, 2019));
    }

    @Test
    public void testIsValidDayCaseMonthOutOfRange1() {
        Assert.assertFalse(DateTimeChecker.isValidDate(1, -23, 2999));
    }

    @Test
    public void testIsValidDayCaseMonthOutOfRange2() {
        Assert.assertFalse(DateTimeChecker.isValidDate(2, 0, 3000));
    }

    @Test
    public void testIsValidDayCaseMonthOutOfRange3() {
        Assert.assertFalse(DateTimeChecker.isValidDate(15, 13, 2999));
    }

    @Test
    public void testIsValidDayCaseMonthOutOfRange4() {
        Assert.assertFalse(DateTimeChecker.isValidDate(28, 23, 2019));
    }

    @Test
    public void testIsValidDayCaseYearOutOfRange1() {
        Assert.assertFalse(DateTimeChecker.isValidDate(29, 12, -123));
    }

    @Test
    public void testIsValidDayCaseYearOutOfRange2() {
        Assert.assertFalse(DateTimeChecker.isValidDate(30, 11, 999));
    }

    @Test
    public void testIsValidDayCaseYearOutOfRange3() {
        Assert.assertFalse(DateTimeChecker.isValidDate(31, 10, 3001));
    }

    @Test
    public void testIsValidDayCaseYearOutOfRange4() {
        Assert.assertFalse(DateTimeChecker.isValidDate(30, 9, 4000));
    }

    @Test
    public void testIsValidDayCaseJan() {
        Assert.assertTrue(DateTimeChecker.isValidDate(31, 1, 3000));
    }

    @Test
    public void testIsValidDayCaseMar() {
        Assert.assertTrue(DateTimeChecker.isValidDate(31, 3, 2999));
    }

    @Test
    public void testIsValidDayCaseMay() {
        Assert.assertTrue(DateTimeChecker.isValidDate(31, 5, 2019));
    }

    @Test
    public void testIsValidDayCaseJul() {
        Assert.assertTrue(DateTimeChecker.isValidDate(31, 7, 2016));
    }

    @Test
    public void testIsValidDayCaseAug() {
        Assert.assertTrue(DateTimeChecker.isValidDate(31, 8, 1001));
    }

    @Test
    public void testIsValidDayCaseOct() {
        Assert.assertTrue(DateTimeChecker.isValidDate(31, 10, 1000));
    }

    @Test
    public void testIsValidDayCaseDec() {
        Assert.assertTrue(DateTimeChecker.isValidDate(31, 12, 1001));
    }

    @Test
    public void testIsValidDayCaseAprTrue() {
        Assert.assertTrue(DateTimeChecker.isValidDate(30, 4, 2016));
    }

    @Test
    public void testIsValidDayCaseJunTrue() {
        Assert.assertTrue(DateTimeChecker.isValidDate(30, 6, 2019));
    }

    @Test
    public void testIsValidDayCaseSepTrue() {
        Assert.assertTrue(DateTimeChecker.isValidDate(30, 9, 2999));
    }

    @Test
    public void testIsValidDayCaseNovTrue() {
        Assert.assertTrue(DateTimeChecker.isValidDate(30, 11, 3000));
    }

    @Test
    public void testIsValidDayCaseAprFalse() {
        Assert.assertFalse(DateTimeChecker.isValidDate(31, 4, 2999));
    }

    @Test
    public void testIsValidDayCaseJunFalse() {
        Assert.assertFalse(DateTimeChecker.isValidDate(31, 6, 2019));
    }

    @Test
    public void testIsValidDayCaseSepFalse() {
        Assert.assertFalse(DateTimeChecker.isValidDate(31, 9, 2016));
    }

    @Test
    public void testIsValidDayCaseNovFalse() {
        Assert.assertFalse(DateTimeChecker.isValidDate(31, 11, 1001));
    }
    @Test
    public void testIsValidDayCaseFeb28True() {
        Assert.assertTrue(DateTimeChecker.isValidDate(28, 2, 2019));
    }
    
    @Test   
    public void testIsValidDayCaseFeb29True1() {
        Assert.assertTrue(DateTimeChecker.isValidDate(29, 2, 2016));
    }
    @Test   
    public void testIsValidDayCaseFeb29True2() {
        Assert.assertTrue(DateTimeChecker.isValidDate(29, 2, 2000));
    }
    @Test
    public void testIsValidDayCaseFeb29False1() {
        Assert.assertFalse(DateTimeChecker.isValidDate(29, 2, 2019));
    }
     @Test
    public void testIsValidDayCaseFeb29False2() {
        Assert.assertFalse(DateTimeChecker.isValidDate(29, 2, 2100));
    }
    @Test
    public void testIsValidDayCaseFebFalse() {
        Assert.assertFalse(DateTimeChecker.isValidDate(30, 2, 2016));
    }

}
