package com.comsystem.homework.rest;

import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/robot/operation")
public final class RobotRestController {

    private final RobotOperations robotOperations;

    public RobotRestController() {
        this.robotOperations = new RobotOperations();
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#excavateStonesForDays(int)} via HTTP
     */
    @PostMapping("/excavation")
    public ResponseEntity<RobotPlan> excavateStones(@RequestParam Integer numberOfDays) {
        RobotPlan robotPlan = robotOperations.excavateStonesForDays(numberOfDays);

        return ResponseEntity.ok(robotPlan);
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#daysRequiredToCollectStones(int)} via HTTP
     */
    @PostMapping("/approximation")
    public ResponseEntity<RobotPlan> approximateDays(@RequestParam Integer numberOfStones) {
        RobotPlan robotPlan = robotOperations.daysRequiredToCollectStones(numberOfStones);

        return ResponseEntity.ok(robotPlan);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleError(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(Map.of("Teapot error", e.getMessage()));
    }

}
