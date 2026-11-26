package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class HardwareConfig {

    OpMode MyOpMode;

    drivesubsystem drive = new drivesubsystem();
    Apriltagsubsyestem aprilTag = new Apriltagsubsyestem();

    everythingelsesubsystem eesub = new everythingelsesubsystem();

    public HardwareConfig(OpMode undersquareOpMode) {
        this.MyOpMode = undersquareOpMode;
        init();
    }

    void init() {

        drive.init(MyOpMode.hardwareMap);
        aprilTag.init(MyOpMode.hardwareMap);
        eesub.init(MyOpMode.hardwareMap);

    }

    public void main() {
        drive.drive(MyOpMode.gamepad1.right_stick_x, -MyOpMode.gamepad1.left_stick_y);
        double bearing = aprilTag.getBearing();
        if (MyOpMode.gamepad1.a&& bearing != Double.POSITIVE_INFINITY){
            boolean right = false;
            if (bearing < 0){
                right = true;
            }
            // Run with encoder and set all motors

            drive.turntoAngle((int) bearing, right);
            // Run without encoders

        }

        eesub.update(MyOpMode.gamepad2);
        buildTelemtry();
    }

    public void buildTelemtry() {
        drive.telemetry(MyOpMode.telemetry);
        aprilTag.telemetry(MyOpMode.telemetry);
        MyOpMode.telemetry.update();

    }

    public void turntoAngle(int angleDeg, boolean right, LinearOpMode Op1) {

        double track_width = 14.875;
        double degree_to_radians = angleDeg * 3.1415926535898 / 180;
        double distanceright = track_width / 2 * degree_to_radians;
        double distanceleft = -track_width / 2 * degree_to_radians;

        if (right){
        distanceleft *= -1;
        distanceright *= -1;

    }
        drive.encoderDrive(0.5, distanceleft , distanceright, 2.5, Op1);

}}


