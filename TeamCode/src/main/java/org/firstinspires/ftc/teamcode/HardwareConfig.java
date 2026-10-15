package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class HardwareConfig {

    OpMode MyOpMode;

    drivesubsystem drive = new drivesubsystem();
    Apriltagsubsyestem aprilTag = new Apriltagsubsyestem();

    everythingelsesubsystem eesub = new everythingelsesubsystem();

    public HardwareConfig (OpMode undersquareOpMode){
        this.MyOpMode = undersquareOpMode;
        init();}
    void init (){

        drive.init(MyOpMode.hardwareMap);
//        aprilTag.init(MyOpMode.hardwareMap);
        eesub.init(MyOpMode.hardwareMap);

    }
    public void main (){
        drive.drive(MyOpMode.gamepad1.right_stick_x, -MyOpMode.gamepad1.left_stick_y);
        eesub.update(MyOpMode.gamepad2);
buildTelemtry();}
    public void buildTelemtry (){
        drive.telemetry(MyOpMode.telemetry);
//        aprilTag.telemetry(MyOpMode.telemetry);
        MyOpMode.telemetry.update();

    }

}
