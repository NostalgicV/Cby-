package com.cby.boot;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitTest {
    @DisplayName("测试前置条件")
    @Test
    void testDisplayName(){
        Assumptions.assumeTrue(true,"/////");
        System.out.println("");
    }
}
