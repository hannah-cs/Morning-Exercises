package org.example.Enums;
import java.util.EnumMap;
import java.util.Random;

public class Enums {
    enum DaysOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        private static final EnumMap<DaysOfWeek, DaysOfWeek> nextDayMap = new EnumMap<>(DaysOfWeek.class);

        static {
            nextDayMap.put(MONDAY, TUESDAY);
            nextDayMap.put(TUESDAY, WEDNESDAY);
            nextDayMap.put(WEDNESDAY, THURSDAY);
            nextDayMap.put(THURSDAY, FRIDAY);
            nextDayMap.put(FRIDAY, SATURDAY);
            nextDayMap.put(SATURDAY, SUNDAY);
            nextDayMap.put(SUNDAY, MONDAY);
        }

        public DaysOfWeek getNextDay() {
            return nextDayMap.get(this);
        }
    }

    enum Months {
        JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);
        private int daysInMonth;
        Months(int daysInMonth) {
            this.daysInMonth = daysInMonth;
        }
        public int getDays() {
            return daysInMonth;
        }
    }

    enum CardSuit {
        HEARTS, DIAMONDS, CLUBS, SPADES;
        public static CardSuit getRandomSuit(){
            Random random = new Random();
            int randomIndex = random.nextInt(CardSuit.values().length);
            return CardSuit.values()[randomIndex];
        }
    }
    public static void main(String[] args) {
        DaysOfWeek today = DaysOfWeek.TUESDAY;
        DaysOfWeek tomorrow = today.getNextDay();
        System.out.println("Today: " + today);
        System.out.println("Tomorrow: " + tomorrow);

        System.out.println(CardSuit.getRandomSuit());

        System.out.println("January has " + Months.JANUARY.getDays() + " days.");
        System.out.println("May has " + Months.MAY.getDays() + " days.");
        System.out.println("November has " + Months.NOVEMBER.getDays() + " days.");


    }
}