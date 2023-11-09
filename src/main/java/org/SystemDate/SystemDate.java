package org.SystemDate;

import java.time.*;

public class SystemDate {
    static Clock clock = Clock.systemDefaultZone();

    public static YearMonth currentMonth() {
        return YearMonth.now();
    }

    public static LocalDate today() {
        return LocalDate.now(clock);
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(clock);
    }

    public static LocalTime time() {
        return LocalTime.now(clock);
    }
}
