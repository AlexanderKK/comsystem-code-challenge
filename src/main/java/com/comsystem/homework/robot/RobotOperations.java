package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     *         algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     *         number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     *         days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        if(days <= 0) {
            return new RobotPlan(0, 0, new ArrayList<>());
        }

        int firstHalfDays = days / 2;
        int secondHalfDays = days - firstHalfDays;
        int numberOfRobots = firstHalfDays + 1;

        int excavatedStones = numberOfRobots * secondHalfDays;

        List<RobotAction> robotActions = this.getRobotActions(days);

        return new RobotPlan(days, excavatedStones, robotActions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     *         provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     *         {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     *         {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        if(numberOfStones <= 0) {
            return new RobotPlan(0, 0, new ArrayList<>());
        }

        int days = 0;
        int excavatedStones = 0;

        while(excavatedStones < numberOfStones) {
            days++;

            int daysForCloning = days / 2;
            int daysForDigging = days - daysForCloning;

            int robots = daysForCloning + 1;
            excavatedStones = robots * daysForDigging;
        }

        List<RobotAction> robotActions = this.getRobotActions(days);

        return new RobotPlan(days, numberOfStones, robotActions);
    }

    private List<RobotAction> getRobotActions(int days) {
        List<RobotAction> robotActions = new ArrayList<>();

        for (int day = 1; day <= days; day++) {
            if(day <= days / 2) {
                robotActions.add(RobotAction.CLONE);
            } else {
                robotActions.add(RobotAction.DIG);
            }
        }

        return robotActions;
    }

}
