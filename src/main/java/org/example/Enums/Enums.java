package org.example.Enums;
import java.util.EnumMap;

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
    public static void main(String[] args) {
        Enums enums = new Enums();
        DaysOfWeek today = DaysOfWeek.TUESDAY;
        DaysOfWeek tomorrow = today.getNextDay();
        System.out.println("Today: " + today);
        System.out.println("Tomorrow: " + tomorrow);

    }
}