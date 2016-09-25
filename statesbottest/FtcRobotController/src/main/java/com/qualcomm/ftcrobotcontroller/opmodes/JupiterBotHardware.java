package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by cwu on 3/4/2016.
 * one drive
 * one lift
 * one raps
 * one collect
 */
public class   JupiterBotHardware extends OpMode{
    public static DcMotorController drivecontroller;
    //public static DcMotorController liftcontroller;
    //public static DcMotorController rapcontroller;
    public static DcMotorController collectcontroller;
    public static DcMotor leftdrive;
    public static DcMotor rightdrive;
    public static DcMotor collector;
    //public static DcMotor leftlift;
    //public static DcMotor rightlift;
    //public static DcMotor raiserrap;
    //public static DcMotor boxerrap;
    public void setup()
    {
        drivecontroller=hardwareMap.dcMotorController.get("drivecontroller");
        collectcontroller=hardwareMap.dcMotorController.get("collectcontroller");
        leftdrive=hardwareMap.dcMotor.get("leftdrive");
        rightdrive=hardwareMap.dcMotor.get("rightdrive");
        collector=hardwareMap.dcMotor.get("collector");
    }
    public void init()
    {
        drivecontroller=hardwareMap.dcMotorController.get("drivecontroller");
        collectcontroller=hardwareMap.dcMotorController.get("collectcontroller");
        leftdrive=hardwareMap.dcMotor.get("leftdrive");
        rightdrive=hardwareMap.dcMotor.get("rightdrive");
        collector=hardwareMap.dcMotor.get("collector");
    }
    @Override
    public void start() {

    }
    @Override
    public void loop()

    {

    }
    @Override
    public void stop() {

    }
    public void fwd(double left, double right)
    {
        setup();
        leftdrive.setPower(left);
        rightdrive.setPower(right);
    }
    public void collect(double power)
    {
        setup();
        collector.setPower(power);
    }
}