package com.drarchita.datecalculator.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Shagun on 09-11-2017.
 */

public class TestDateUtils {

    @Test
    public void betweenDates_test1() {
        int days = DateUtils.betweenDates("2/03/2017","3/03/2017");
        Assert.assertEquals(days, 1);
    }

    @Test
    public void betweenDates_test2() {
        int days = DateUtils.betweenDates("2/03/2017","3/04/2017");
        Assert.assertEquals(days, 32);
    }

    @Test
    public void addToDate_test1() {
        org.joda.time.LocalDate localDate = DateUtils.addToDate(
                "2/03/2017", "0", "0", "0");
        Assert.assertEquals(localDate.getYear(), 2017);
        Assert.assertEquals(localDate.getMonthOfYear(), 3);
        Assert.assertEquals(localDate.getDayOfMonth(), 2);
    }

    @Test
    public void addToDate_test2() {
        org.joda.time.LocalDate localDate = DateUtils.addToDate(
                "2/03/2017", "1", "0", "0");
        Assert.assertEquals(localDate.getYear(), 2017);
        Assert.assertEquals(localDate.getMonthOfYear(), 4);
        Assert.assertEquals(localDate.getDayOfMonth(), 2);
    }

    @Test
    public void addToDate_test3() {
        org.joda.time.LocalDate localDate = DateUtils.addToDate(
                "2/03/2017", "0", "1", "0");
        Assert.assertEquals(localDate.getYear(), 2017);
        Assert.assertEquals(localDate.getMonthOfYear(), 3);
        Assert.assertEquals(localDate.getDayOfMonth(), 9);
    }

    @Test
    public void addToDate_test4() {
        org.joda.time.LocalDate localDate = DateUtils.addToDate(
                "2/03/2017", "0", "0", "1");
        Assert.assertEquals(localDate.getYear(), 2017);
        Assert.assertEquals(localDate.getMonthOfYear(), 3);
        Assert.assertEquals(localDate.getDayOfMonth(), 3);
    }

    @Test
    public void addToDate_test5() {
        org.joda.time.LocalDate localDate = DateUtils.addToDate(
                "2/03/2017", "0", "1", "1");
        Assert.assertEquals(localDate.getYear(), 2017);
        Assert.assertEquals(localDate.getMonthOfYear(), 3);
        Assert.assertEquals(localDate.getDayOfMonth(), 10);
    }
}
