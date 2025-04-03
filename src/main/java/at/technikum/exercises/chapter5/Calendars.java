package at.technikum.exercises.chapter5;
import java.util.Scanner;

public class Calendars {
    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int daysInMonth(int year, int month) {
        if (year < 0 || month < 0 || month > 12) {
            return -1;
        }

        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};;
        if (isLeap(year) && month == 2) {
            return 29;
        }

        return daysInMonth[month - 1];
    }

    public static boolean checkDate(int year) {
        return year >= 1582 && year <= 2199;
    }

    public static boolean checkDate(int year, int month) {
        if (!checkDate(year) || (year == 1582 && month < 10)) return false;

        return month >= 1 && month <= 12;
    }

    public static boolean checkDate(int year, int month, int day) {
        if (!checkDate(year, month) || (year == 1582 && month == 10 && day < 16)) return false;

        return day >= 1 && day <= daysInMonth(year, month);
    }

    /*
       Calculates the weekday of a given date.
       The date is passed to the function as three integers.
       Returns the weekday according to Table 1 in Weekdays exercise or -1, if date is invalid
    */
    public static int ymd2w(int year, int month, int day) {
        if (!checkDate(year, month, day)) return -1;

        //day = 5;

        int y = year % 100;
        int c = year / 100;

        int monthShifted = month;

        if (month <= 2) {
            monthShifted += 10;
            if (y == 0) {
                y = 99;
            } else {
                y -= 1;
            }
            if (isLeap(year)) {
                c -= 1;
            }
        } else {
            monthShifted -= 2;
        }

        int a = (int) (day +  Math.floor((2.6 * monthShifted - 0.2)) + y + Math.floor(y / 4.) + Math.floor(c / 4.) - 2 * c);

        int result = a % 7;
        return result >= 0 ? result : result + 7;
    }

    /*
         returns the day count, or -1 if the given date is invalid.
         The day count is the number of days passed since the start of the year plus one.
         E.g.: Jan, 1 st is day 1 in any year; Dec. 31 st is day 365 in a non-leap year and day 366 in a leap year.
     */
    public static int dayNumber(int year, int month, int day) {
        if (!checkDate(year, month, day)) return -1;

        if (month == 1 && day == 1) return 1;
        else if (month == 12 && day == 31) {
            if (isLeap(year)) {
                return 366;
            } else {
                return 365;
            }
        }

        int daysCounter = 0;
        for (int i = 1; i <= month; i++) {
            int daysInMonth = daysInMonth(year, month);
            System.out.println("month: , " + month + " days in month: " + daysInMonth);
            for (int j = 1; j <= daysInMonth(year, i); j++) {
                daysCounter++;
                if (i == month && j == day) {
                    break;
                }
            }
        }
        return daysCounter;
    }

    /*
        Returns the week number of a given date, or -1 if date is invalid.
        Week 1 in any year is the week of Jan, 1 st .
     */
    public static int weekNumber(int year, int month, int day) {
        if (!checkDate(year, month, day)) return -1;

        int daysPassedSinceFirstJan = dayNumber(year, month, day) - 1;
        int weekDayOfFirstJan = ymd2w(year, 1, 1);

        return (daysPassedSinceFirstJan + weekDayOfFirstJan) / 7 + 1;
    }

    public static String getDayName(int day) {

        String[] weekdays = new String[]{
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };

        if (day < 0 || day > 6) {
            return "invalid day (" + day + ")";
        }

        return weekdays[day % 7];
    }

    /*
        Prints the name of day. The name of a day is given in
        Table 1 in Exercise Weekdays. prints invalid day(<day>) if day is not in the range 0-6. The output
        produced contains no whitespace or other additional characters before or after the name. The names
        are the full English names, e.g. “Monday”, “Friday”. . .
     */
    public static void printDayName(int day) {
        System.out.print(getDayName(day));
    }

    private static String getMonthName(int month) {
        if (month < 0 || month > 12) {
            return "invalid month (" + month + ")";
        }

        String[] months = new String[]{
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        return months[month - 1];
    }

    /*
        Prints the name of month. The months accepted are in the range 1-12, 1 being January.
        Prints invalid day(<month>) if month is not in the range 1-12.
        The output produced contains no whitespace or other additional characters before or after the name.
        The names are the full English names, e.g. “January”, “February”. . .
     */
    public static void printMonthName(int month) {
        System.out.print(getMonthName(month));
    }

    /*
        Prints the English number ending for n the number ending is:
            – st for numbers ending with 1, except 11
            – nd for numbers ending with 2, except 12
            – rd for number ending with 3 except 13
            - th otherwise
     */
    public static void printNumberEnding(int n) {
        if (n != 11 && n % 10 == 1) {
            System.out.print("st");
        } else if (n != 12 && n % 10 == 2) {
            System.out.print("nd");
        } else if (n != 13 && n % 10 == 3) {
            System.out.print("rd");
        } else {
            System.out.print("th");
        }
    }

    /*
        Prints a given date in the following format:
        <Weekday>, <Month> <day> <number_ending> <year>
        prints invalid date (<day><month>.<year>). for invalid dates.
     */
    public static void printDate(int year, int month, int day) {
        if (!checkDate(year, month, day)) {
            System.out.printf("invalid date (%d.%d.%d)", day, month, year);
            return;
        }

        int weekDay = ymd2w(year, month, day);

        printDayName(weekDay);
        System.out.print(", ");
        printMonthName(month);
        System.out.print(" " + day);
        printNumberEnding(day);
        System.out.print(" " + year);
    }

    /*
        Prints various information on the given date:
            – date as described in printDate(int,int,int)
            – the year and whether it is a leap year or not
            – the number of days in the month of the given date
            – the number of the day
            – the week of the date
        prints invalid date. for invalid dates.
     */
    public static void printStatistics(int year, int month, int day) {
        if (!checkDate(year, month, day)) {
            System.out.println("invalid date");
            return;
        }

        System.out.println("statistics for");
        printDate(year, month, day);
        System.out.println();

        if (isLeap(year)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }

        System.out.print("month " + month + " in year " + year + " has " + daysInMonth(year, month) + " days\n");
        System.out.println("it is day " + dayNumber(year, month, day) + " of year " + year);
        System.out.println("it is in week " + weekNumber(year, month, day) + " of year " + year);
    }

    /*
        Prints a calendar of the month of the given date. Each line of the calendar displays one week.
        The weeks in the calendar start on Monday. If highlight is set,
        the given date is highlighted with brackets <>in the calendar.
     */
    public static void printCalendar(int year, int month, int day, boolean highlight) {
        int weekDayOfFirst = ymd2w(year, month, 1);
        if (weekDayOfFirst == 0) {
            weekDayOfFirst = 7;
        }

        printMonthName(month);
        System.out.print(" " + year + "\n");
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < daysInMonth(year, month)+weekDayOfFirst; i++) {
            if (i > 1 && (i-1) % 7 == 0) {
                System.out.println();
            }

            String dayFormat = "%2d  ";
            String spaceFormat = "%4s";
            if (highlight && (i-weekDayOfFirst+1) == day) {
                dayFormat = day < 10 ? "<%d> " : "<%2d>";
            }
            if (i < weekDayOfFirst) {
                System.out.printf(spaceFormat, " ");
            } else {
                System.out.printf(dayFormat, i-weekDayOfFirst + 1);
            }
        }
    }

    private static Scanner sc = new Scanner(System.in);
    private static final int SET_DATE = 0;
    private static final int IS_LEAP = 1;
    private static final int DAYS_IN_MONTH = 2;
    private static final int CHECK_DATE = 3;
    private static final int YMD_2_W = 7;
    private static final int DAY_NUMBER = 8;
    private static final int WEEK_NUMBER = 9;
    //private static final int COMPARE = 10;

    //private static final int DAY_NAME = 13;
    //private static final int PRINT_DAY = 14;
    //private static final int DAY_SHORT_NAME = 15;
    //private static final int PRINT_DAY_SHORT = 16;
    //private static final int PRINT_MONTH = 17;
    //private static final int PRINT_MONTH_SHORT = 18;
    //private static final int PRINT_DATE = 19;
    private static final int PRINT_STATISTICS = 20;

    private static final int PRINT_CALENDAR_HIGHLIGHT = 21;
    private static final int PRINT_CALENDAR = 22;

    private static final int EXIT = 666;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int day = 1, month = 1, year = 1970;
        while (true) {

            int op;
            System.out.printf("current date: %02d.%02d.%04d\n", day, month, year);
            System.out.printf("enter option: ");

            op = sc.nextInt();

            switch (op) {
                case SET_DATE:
                    System.out.printf("day: ");

                    day = sc.nextInt();
                    System.out.printf("month: ");

                    month = sc.nextInt();
                    System.out.printf("year: ");

                    year = sc.nextInt();
                    break;

                /*------------------------- BASICS ----------------------*/
                case IS_LEAP:
                    System.out.printf("\nisLeap(year): %b\n", isLeap(year));
                    break;
                case DAYS_IN_MONTH:
                    System.out.printf("\ndaysInMonth(year, month): %d\n", daysInMonth(year, month));
                    break;
                case CHECK_DATE:
                    System.out.printf("\ncheckDate1(year): %b\n", checkDate(year));
                    System.out.printf("checkDate2(year, month): %b\n", checkDate(year, month));
                    System.out.printf("checkDate3(year, month, day): %b\n", checkDate(year, month, day));
                    break;
                /*------------------------- CALCULATIONS ----------------------*/
                case YMD_2_W: {
                    System.out.printf("\nymd2w(year, month, day): %d\n", ymd2w(year, month, day));
                    break;
                }
                case DAY_NUMBER:
                    System.out.printf("\ndayNumber(year, month, day): %d\n", dayNumber(year, month, day));
                    break;
                case WEEK_NUMBER:
                    System.out.printf("\nweekNumber(year, month, day): %d\n", weekNumber(year, month, day));
                    break;
                /*------------------------- OUTPUT ----------------------*/
                case PRINT_STATISTICS:
                    System.out.printf("\nprintStatistics: ");
                    printStatistics(year, month, day);
                    break;
                /*------------------------- APPLICATIONS ----------------------*/
                case PRINT_CALENDAR_HIGHLIGHT:
                    System.out.printf("\nprintCalendar(year, month, day, 1): \n");
                    printCalendar(year, month, day, true);

                    break;
                case PRINT_CALENDAR:
                    System.out.printf("\nprintCalendar(year, month, day, 0): \n");
                    printCalendar(year, month, day, false);
                    break;
                case EXIT:
                    System.out.printf("closing.\n");
                    sc.close();
                    return;
                default:
                    ;
            }
            System.out.printf("\n");
        }
    }
}

