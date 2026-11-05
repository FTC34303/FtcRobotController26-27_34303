package org.firstinspires.ftc.teamcode;

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
//        aprilTag.init(MyOpMode.hardwareMap);
        eesub.init(MyOpMode.hardwareMap);

    }

    public void main() {
        drive.drive(MyOpMode.gamepad1.right_stick_x, -MyOpMode.gamepad1.left_stick_y);
        eesub.update(MyOpMode.gamepad2);
        buildTelemtry();
    }

    public void buildTelemtry() {
        drive.telemetry(MyOpMode.telemetry);
//        aprilTag.telemetry(MyOpMode.telemetry);
        MyOpMode.telemetry.update();

    }

    public void turntoAngle(int angleDeg) {
        double track_width = 14.875;
        double degree_to_radians = angleDeg * 3.1415926535898 / 180;
        double degree_to_radius = track_width / 2 * degree_to_radians;
        double degree_to_length = -track_width / 2 * degree_to_radians;

        if (boolean left)
            degree_to_length *= -1;
            degree_to_radius *= -1;
        }

    }
}
