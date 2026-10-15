package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class drivesubsystem {
    private DcMotor LeftDrive = null;
//    private DcMotor backLeftDrive = null;
    private DcMotor RightDrive = null;
//    private DcMotor backRightDrive = null;
    static final double COUNTS_PER_MOTOR_REV = 1440;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // No External Gearing.
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    private ElapsedTime runtime = new ElapsedTime();

    public void init(HardwareMap hardwareMap) {
        LeftDrive = hardwareMap.get(DcMotor.class, "left_drive");
//        backLeftDrive = hardwareMap.get(DcMotor.class, "back_left_drive");
        RightDrive = hardwareMap.get(DcMotor.class, "right_drive");
//        backRightDrive = hardwareMap.get(DcMotor.class, "back_right_drive");
        LeftDrive.setDirection(DcMotor.Direction.FORWARD);
//        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        RightDrive.setDirection(DcMotor.Direction.REVERSE);
//        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        LeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void initauto() {
//        frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void drive(double turn, double drive) {
//        double max;
//
//        // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
//        double axial = x; // Note: pushing stick forward gives negative value
//        double lateral = y;
//        double yaw = turn;
//
//        // Combine the joystick requests for each axis-motion to determine each wheel's power.
//        // Set up a variable for each drive wheel to save the power level for telemetry.
////        double frontLeftPower = axial + lateral + yaw;
////        double frontRightPower = axial - lateral - yaw;
//        double LeftPower = axial - lateral + yaw;
//        double RightPower = axial + lateral - yaw;
//
//        // Normalize the values so no wheel power exceeds 100%
//        // This ensures that the robot maintains the desired motion.
//        max = Math.max(Math.abs(LeftPower), Math.abs(RightPower));
////        max = Math.max(max, Math.abs(backLeftPower));
////        max = Math.max(max, Math.abs(backRightPower));
//
//        if (max > 1.0) {
//            LeftPower /= max;
//            RightPower /= max;
////            backLeftPower /= max;
////            backRightPower /= max;
//        }

        // This is test code:
        //
        // Uncomment the following code to test your motor directions.
        // Each button should make the corresponding motor run FORWARD.
        //   1) First get all the motors to take to correct positions on the robot
        //      by adjusting your Robot Configuration if necessary.
        //   2) Then make sure they run in the correct direction by modifying the
        //      the setDirection() calls above.
        // Once the correct motors move in the correct direction re-comment this code.

            /*
            frontLeftPower  = gamepad1.x ? 1.0 : 0.0;  // X gamepad
            backLeftPower   = gamepad1.a ? 1.0 : 0.0;  // A gamepad
            frontRightPower = gamepad1.y ? 1.0 : 0.0;  // Y gamepad
            backRightPower  = gamepad1.b ? 1.0 : 0.0;  // B gamepad
            */

        // Send calculated power to wheels
//        frontLeftDrive.setPower(frontLeftPower);
//        frontRightDrive.setPower(frontRightPower);

        double LeftPower = Range.clip(drive + turn, -1.0, 1.0) ;
       double RightPower = Range.clip(drive - turn, -1.0, 1.0) ;

        LeftDrive.setPower(LeftPower);
        RightDrive.setPower(RightPower);
    }

    public void telemetry(Telemetry Telemetry1) {
        Telemetry1.addData(" left/Right", "%4.2f, %4.2f", LeftDrive.getPower(), RightDrive.getPower());
//        Telemetry1.addData("Back  left/Right", "%4.2f, %4.2f", backLeftDrive.getPower(), backRightDrive.getPower());
    }

    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS, LinearOpMode MyOpmode) {
        int newLeftTarget;
        //int newbackleftTarget;
        int newrightTarget;
        //int newbackrightTarget;
        // Ensure that the OpMode is still active
        if (MyOpmode.opModeIsActive()) {

            // Determine new target position, and pass to motor controller
          //  newbackleftTarget = backLeftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newLeftTarget = LeftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
//            newfrontrightTarget = frontRightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            newrightTarget = RightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            LeftDrive.setTargetPosition(newLeftTarget);
//            backLeftDrive.setTargetPosition(newbackleftTarget);
            RightDrive.setTargetPosition(newrightTarget);
//            backRightDrive.setTargetPosition(newbackrightTarget);


            // Turn On RUN_TO_POSITION
//            frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            // reset the timeout time and start motion.
            runtime.reset();
//            frontLeftDrive.setPower(Math.abs(speed));
            LeftDrive.setPower(Math.abs(speed));
//            frontRightDrive.setPower(Math.abs(speed));
            RightDrive.setPower(Math.abs(speed));


            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (MyOpmode.opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (RightDrive.isBusy() && LeftDrive.isBusy())) {

                // Display it for the driver.
                MyOpmode.telemetry.addData("Running to", " %7d :%7d", newLeftTarget, newrightTarget);
                MyOpmode.telemetry.addData("Currently at", " at %7d :%7d",
                        LeftDrive.getCurrentPosition(), RightDrive.getCurrentPosition());
                MyOpmode.telemetry.update();
            }

            // Stop all motion;
//            backLeftDrive.setPower(0);
            RightDrive.setPower(0);
//            frontRightDrive.setPower(0);
            LeftDrive.setPower(0);

            // Turn off RUN_TO_POSITION
//            frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
      /* void mecanumside(double speed, double inches, double timeoutS, LinearOpMode MyOpmode){

            if (MyOpmode.opModeIsActive()) {

                // Determine new target position, and pass to motor controller
                newbackleftTarget = backLeftDrive.getCurrentPosition() + (int) (inches * COUNTS_PER_INCH);
                newfrontLeftTarget = frontLeftDrive.getCurrentPosition() + (int) (inches * COUNTS_PER_INCH);
                newfrontrightTarget = frontRightDrive.getCurrentPosition() + (int) (inches * COUNTS_PER_INCH);
                newbackrightTarget = backRightDrive.getCurrentPosition() + (int) (inches * COUNTS_PER_INCH);
                frontLeftDrive.setTargetPosition(newfrontLeftTarget);
                backLeftDrive.setTargetPosition(newbackleftTarget);
                frontRightDrive.setTargetPosition(newfrontrightTarget);
                backRightDrive.setTargetPosition(newbackrightTarget);


                // Turn On RUN_TO_POSITION
                frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);


                // reset the timeout time and start motion.
                runtime.reset();
                frontLeftDrive.setPower(Math.abs(speed));
                backLeftDrive.setPower(Math.abs(speed));
                frontRightDrive.setPower(Math.abs(speed));
                backRightDrive.setPower(Math.abs(speed));

                while (MyOpmode.opModeIsActive() &&
                        (runtime.seconds() < timeoutS) &&
                        (backLeftDrive.isBusy() && backRightDrive.isBusy() && frontLeftDrive.isBusy() && frontRightDrive.isBusy())) {


            } */
    }}
