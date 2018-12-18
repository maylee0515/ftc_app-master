package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.concurrent.TimeUnit;

@TeleOp(name="mecanum_test", group="OpMode")
public class mecanum_wheel_teleop extends OpMode{
    public ElapsedTime time= new ElapsedTime();
    public ElapsedTime tt= new ElapsedTime();

    DcMotor frontLeft;
    DcMotor backLeft;
    DcMotor frontRight;
    DcMotor backRight;

    @Override
    public void init(){
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    public void mechanum(){
        if(gamepad1.left_stick_y > -0.3 && gamepad1.right_stick_y > -0.3){
            frontLeft.setPower(0.7*gamepad1.left_stick_y);
            frontRight.setPower(0.7*gamepad1.right_stick_y);
            backLeft.setPower(0.7*gamepad1.left_stick_y);
            backRight.setPower(0.7*gamepad1.right_stick_y);

        }
        else if(gamepad1.left_stick_y > 0.3 && gamepad1.right_stick_y > 0.3){
            frontLeft.setPower(-0.7*gamepad1.left_stick_y);
            frontRight.setPower(-0.7*gamepad1.right_stick_y);
            backLeft.setPower(-0.7*gamepad1.left_stick_y);
            backRight.setPower(-0.7*gamepad1.right_stick_y);

        }
        else if(gamepad1.left_bumper == true){
            frontLeft.setPower(-0.7*gamepad1.left_stick_y);
            frontRight.setPower(0.7*gamepad1.right_stick_y);
            backLeft.setPower(0.7*gamepad1.left_stick_y);
            backRight.setPower(-0.7*gamepad1.right_stick_y);
        }
        else if(gamepad1.right_bumper == true){
            frontLeft.setPower(0.7*gamepad1.left_stick_y);
            frontRight.setPower(-0.7*gamepad1.right_stick_y);
            backLeft.setPower(-0.7*gamepad1.left_stick_y);
            backRight.setPower(0.7*gamepad1.right_stick_y);
        }
        else{
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }



    }

    public void loop(){
        tt.startTime();
        if(tt.time(TimeUnit.SECONDS) < 3*60) {
            mechanum();

        }
    }

    public void stop(){
    }

}



