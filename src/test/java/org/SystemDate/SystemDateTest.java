package org.SystemDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SystemDateTest {

    @BeforeEach
    void setUp() {
        // LocalDate.now()で返ってくる値を指定する
        TestDateUtil.setup(LocalDate.of(2023, 11, 10));
    }

    @Test
    void テスト日付を固定できる() {
        LocalDate today = SystemDate.today();
        Assertions.assertEquals(LocalDate.of(2023, 11, 10), today);
    }

}
