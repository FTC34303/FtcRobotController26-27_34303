package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Teleop1 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareConfig robot = new HardwareConfig(this);

        waitForStart();
        while (opModeIsActive()){
            robot.main();
        }
    }
}
