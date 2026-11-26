package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous
public class Auto2 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareConfig robot = new HardwareConfig(this);
        robot.drive.initauto();
        waitForStart();
        robot.eesub.launcher.setPower(0.5);
        sleep(1000);
        robot.eesub.flickerservo.setPower(1);
        sleep(5000);
        robot.eesub.launcher.setPower(0);
        robot.eesub.flickerservo.setPower(0);
        robot.drive.encoderDrive(0.5, -5, -5, 3, this);
        robot.turntoAngle(-46,true, this);
        // We are trying to figure out how to get the robot to park. We are trying to figure out how far it goes.
        robot.drive.encoderDrive(0.5, -48, -48, 5, this);
        robot.turntoAngle(-33,false,this);
        robot.drive.encoderDrive(0.5, -1.03*39,-1.03*39, 5, this);
        sleep(500);
    }
}