package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous
public class Auto1 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareConfig robot = new HardwareConfig(this);
        robot.drive.initauto();

        waitForStart();
        robot.drive.encoderDrive(0.5, 1, 1, 10, this);
    }
}
