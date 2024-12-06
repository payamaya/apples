package com.Apples2Apples.util;

import com.Apples2Apples.common.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabelSizeUtilTest {
    @Test
    void testDetermineWinningGreenApples() {
        assertEquals(Constants.WINNING_GREEN_APPLES_4.getValue(), TabelSizeUtil.determineWinningGreenApples(4));
        assertEquals(Constants.WINNING_GREEN_APPLES_5.getValue(), TabelSizeUtil.determineWinningGreenApples(5));
        assertEquals(Constants.WINNING_GREEN_APPLES_6.getValue(), TabelSizeUtil.determineWinningGreenApples(6));
        assertEquals(Constants.WINNING_GREEN_APPLES_7.getValue(), TabelSizeUtil.determineWinningGreenApples(7));
        assertEquals(Constants.WINNING_GREEN_APPLES_DEFAULT.getValue(), TabelSizeUtil.determineWinningGreenApples(3));
        assertEquals(Constants.WINNING_GREEN_APPLES_DEFAULT.getValue(), TabelSizeUtil.determineWinningGreenApples(8));
    }
}