/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetimechecker;

/**
 *
 * @author Acer
 */
public class DateTimeChecker {

    /**
     * @param args the command line arguments
     */
    public static int dayInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else {
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                return 30;
            } else {
                if (month == 2) {
                    if (year % 400 == 0) {
                        return 28;
                    } else {
                        if (year % 100 == 0) {
                            return 29;
                        } else {
                            if (year % 4 == 0) {
                                return 29;
                            } else {
                                return 28;
                            }
                        }
                    }
                } else {

                    return 0;
                }
            }
        }

    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month >= 1 && month <= 12) {
            if (day >= 1) {
                if (day <= dayInMonth(month, year)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        DateTimeChecker date = new DateTimeChecker();
        System.out.println(date.isValidDate(28, 2, 2100));
    }

}
