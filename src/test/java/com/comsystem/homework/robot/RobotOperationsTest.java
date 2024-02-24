package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static com.comsystem.homework.model.RobotAction.CLONE;
import static com.comsystem.homework.model.RobotAction.DIG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class RobotOperationsTest {

    private static final Integer DAYS = 7;
    private static final Integer STONES = 16;
    private RobotPlan expectedRobotPlan;
    private RobotPlan expectedEmptyRobotPlan;

    @InjectMocks
    private RobotOperations robotOperations;

    @BeforeEach
    void setUp() {
        expectedRobotPlan = new RobotPlan(
                DAYS, STONES, Arrays.asList(CLONE, CLONE, CLONE, DIG, DIG, DIG, DIG)
        );

        expectedEmptyRobotPlan = new RobotPlan(
                0, 0, Collections.emptyList()
        );
    }

    @Test
    void testExcavateStonesForDaysWhenDaysAreZeroOrLess() {
        RobotPlan actualEmptyRobotPlan = robotOperations.excavateStonesForDays(0);

        assertNotNull(expectedEmptyRobotPlan);
        assertNotNull(actualEmptyRobotPlan);

        assertEquals(actualEmptyRobotPlan.numberOfStones(), 0);
        assertEquals(expectedEmptyRobotPlan.numberOfStones(), actualEmptyRobotPlan.numberOfStones());
        assertEquals(expectedEmptyRobotPlan, actualEmptyRobotPlan);
    }

    @Test
    void testExcavateStonesForDays() {
        RobotPlan actualRobotPlan = robotOperations.excavateStonesForDays(DAYS);

        assertNotNull(expectedRobotPlan);
        assertNotNull(actualRobotPlan);

        assertEquals(expectedRobotPlan.numberOfStones(), actualRobotPlan.numberOfStones());
        assertEquals(expectedRobotPlan, actualRobotPlan);
    }

    @Test
    void testDaysRequiredToCollectStonesWhenStonesAreZeroOrLess() {
        RobotPlan actualEmptyRobotPlan = robotOperations.daysRequiredToCollectStones(0);

        assertNotNull(expectedEmptyRobotPlan);
        assertNotNull(actualEmptyRobotPlan);

        assertEquals(actualEmptyRobotPlan.numberOfDays(), 0);
        assertEquals(expectedEmptyRobotPlan.numberOfDays(), actualEmptyRobotPlan.numberOfDays());
        assertEquals(expectedEmptyRobotPlan, actualEmptyRobotPlan);
    }

    @Test
    void testDaysRequiredToCollectStones() {
        RobotPlan actualRobotPlan = robotOperations.daysRequiredToCollectStones(STONES);

        assertNotNull(expectedRobotPlan);
        assertNotNull(actualRobotPlan);

        assertEquals(expectedRobotPlan.numberOfDays(), actualRobotPlan.numberOfDays());
        assertEquals(expectedRobotPlan, actualRobotPlan);
    }

}
