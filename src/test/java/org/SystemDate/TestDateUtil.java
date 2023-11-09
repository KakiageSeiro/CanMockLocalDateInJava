package org.SystemDate;

import java.lang.reflect.Field;
import java.time.*;

public class TestDateUtil {
    public static void setup(LocalDate localDate) {
        setup(LocalDateTime.of(localDate, LocalTime.now()));
    }

    public static void setup(LocalDate localDate, LocalTime localTime) {
        setup(LocalDateTime.of(localDate, localTime));
    }

    public static void setup(LocalDateTime localDateTime) {
        try {
            Class<?> clazz = SystemDate.class;

            //SystemDateクラスのフィールド(メンバー変数)であるclockのFieldを取得
            Field clock = clazz.getDeclaredField("clock");

            // clockフィールドに対してアクセス制限を外す
            clock.setAccessible(true);

            // clockフィールドに対して、第二引数を設定する。第一引数はstaticの場合利用しないのでnull。
            clock.set(null, Clock.fixed(localDateTime.toInstant(ZoneOffset.ofHours(9)), ZoneId.systemDefault()));
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    public static void clear() {
        try {
            Class<?> clazz = SystemDate.class;

            Field clock = clazz.getDeclaredField("clock");

            clock.setAccessible(true);
            clock.set(null, Clock.systemDefaultZone());
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

}
