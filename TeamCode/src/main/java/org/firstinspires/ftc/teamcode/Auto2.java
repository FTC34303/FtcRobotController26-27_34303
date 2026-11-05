
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
            robot.turntoAngle(-45);
            robot.turntoAngle(31);
        }

    }


