package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class everythingelsesubsystem {
    DcMotor intake = null;
    DcMotor launcher = null;
    CRServo rightservo = null;
    CRServo leftservo = null;
    CRServo flickerservo = null;
    public void init(HardwareMap map){
      intake = map.get(DcMotor.class,"intake");
       launcher =  map.get(DcMotor.class, "launcher");
       rightservo =  map.get(CRServo.class,"rightservo");
      leftservo =   map.get(CRServo.class, "leftservo");
      flickerservo =  map.get(CRServo.class,"flickerservo");
    }
    public void update(Gamepad Gamepad1){
        if(Gamepad1.left_trigger_pressed){
            intake.setPower(1);
            leftservo.setPower(-1);
            rightservo.setPower(1);
        }
        else if(Gamepad1.left_bumper){
            intake.setPower(-1);
            leftservo.setPower(1);
            rightservo.setPower(-1);
        }else{
            intake.setPower(0);
            rightservo.setPower(0);
            leftservo.setPower(0);
        }
        if(Gamepad1.right_trigger_pressed){
            launcher.setPower(.5);
//            flickerservo.setPower(1);
        }
        else if (Gamepad1.right_bumper){
            launcher.setPower(-1);
//            flickerservo.setPower(-1);
        }
        else{
            launcher.setPower(0);
//            flickerservo.setPower(0);
        }
        if(Gamepad1.dpad_up){
            flickerservo.setPower(1);
        }else if (Gamepad1.dpad_down){
            flickerservo.setPower(-1);
        }else{
            flickerservo.setPower(0);
        }

    }
    public void telemetry(){


    }
}
