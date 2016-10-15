package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.Range;

public class BotHardwareArmAuto extends LinearOpMode {
    public static DcMotorController leftcontroller;
    public static DcMotorController rightcontroller;
    public static DcMotor fldrive;
    public static DcMotor frdrive;
    public static DcMotor bldrive;
    public static DcMotor brdrive;

    public static DcMotorController armcontroller;
    public static DcMotor turner;   //turntable
    public static DcMotor raiser;   //elbow

    public static ServoController servo1;
    public static Servo wrist;  //servo on collector, makes it tilt
    public static Servo fingers; //flaps for the debris
    public static Servo keeper;  //flap
    public static Servo pushButton;

    public static ServoController servo2;
    public static Servo pushLeft;
    public static Servo pushRight;
    public static Servo rightdoor;
    public static Servo leftMud;
    public static Servo rightMud;

    public static Servo guideLeft;
    public static Servo guideRight;

    DcMotorController muscle;
    DcMotor leftbicep;
    DcMotor rightbicep;

    ColorSensor sensorRGB;
    ColorSensor bottomsensor;
    GyroSensor gyro1;
    GyroSensor gyro2;
    OpticalDistanceSensor ods;
    DeviceInterfaceModule dim;

    public double wristposition =0;
    public double fingerposition =0;
    public boolean openLeft = false;
    public boolean openRight = false;

    public BotHardwareArmAuto() {
    }

    @Override
    public void runOpMode() throws InterruptedException {
    }

    public void setup() {
        leftcontroller = hardwareMap.dcMotorController.get("leftcontrol");
        rightcontroller = hardwareMap.dcMotorController.get("right");
        fldrive = hardwareMap.dcMotor.get("fl");
        frdrive = hardwareMap.dcMotor.get("fr");
        bldrive = hardwareMap.dcMotor.get("bl");
        brdrive = hardwareMap.dcMotor.get("br");

        //color = hardwareMap.colorSensor.get("color");

        servo1 = hardwareMap.servoController.get("servo1");
        servo2 = hardwareMap.servoController.get("servo2");
        wrist = hardwareMap.servo.get("wrist");
        rightdoor = hardwareMap.servo.get("rightdoor");
        fingers = hardwareMap.servo.get("leftdoor");
        keeper = hardwareMap.servo.get("keeper");

        leftMud = hardwareMap.servo.get("leftmud");
        rightMud = hardwareMap.servo.get("rightmud");
        turner = hardwareMap.dcMotor.get("turner");

        raiser = hardwareMap.dcMotor.get("raiser");
        armcontroller = hardwareMap.dcMotorController.get("arm");

        pushButton = hardwareMap.servo.get("pushbutton");
        pushLeft = hardwareMap.servo.get("leftlever");
        pushRight = hardwareMap.servo.get("rightlever");

        muscle = hardwareMap.dcMotorController.get("muscle");
        leftbicep = hardwareMap.dcMotor.get("leftbicep");
        rightbicep = hardwareMap.dcMotor.get("rightbicep");

        sensorRGB = hardwareMap.colorSensor.get("mr");
        bottomsensor = hardwareMap.colorSensor.get("bottomleft");
        gyro1 = hardwareMap.gyroSensor.get("gyro1");
        gyro2 = hardwareMap.gyroSensor.get("gyro2");
        ods = hardwareMap.opticalDistanceSensor.get("ods");
        dim = hardwareMap.deviceInterfaceModule.get("dim");
        guideLeft = hardwareMap.servo.get("guidel");
        guideRight = hardwareMap.servo.get("guider");
        sensorRGB.enableLed(true);
        bottomsensor.enableLed(true);

    }

    public void fwd(double fl, double bl, double fr, double br) {
        setup();
        fldrive.setPower(fl);
        frdrive.setPower(fr);
        bldrive.setPower(bl);
        brdrive.setPower(br);
    }

    void wristPosition (double p_position)
    {
        double l_position = Range.clip
                ( p_position
                        , Servo.MIN_POSITION
                        , Servo.MAX_POSITION
                );
        wrist.setPosition(l_position);

    }



    void setGuideLeft(double p_position)
    {
        double l_position= Range.clip
                (p_position
                        , Servo.MIN_POSITION
                        , Servo.MAX_POSITION

                );
        guideLeft.setPosition(l_position);
    }
    void setGuideRight(double p_position)
    {
        double l_position= Range.clip
                (p_position
                        , Servo.MIN_POSITION
                        , Servo.MAX_POSITION

                );
        guideRight.setPosition(l_position);
    }


    void m_hand_position (double p_position)
    {
        double l_position = Range.clip
                (p_position
                        , Servo.MIN_POSITION
                        , Servo.MAX_POSITION
                );
        fingers.setPosition(l_position);


    }

    void v_hand_position (double p_position)
    {
        double l_position = Range.clip
                ( p_position
                        , Servo.MIN_POSITION
                        , Servo.MAX_POSITION
                );
        rightdoor.setPosition (l_position);
    }

    boolean have_drive_encoders_reached
            ( double p_left_count
                    , double p_right_count
            )

    {
        boolean l_return = false;
        if (has_left_drive_encoder_reached (p_left_count) && has_right_drive_encoder_reached (p_right_count))
        {
            l_return = true;
        }

        //
        // Return the status.
        //
        return l_return;

    }
    boolean has_left_drive_encoder_reached (double p_count)
    {
        boolean l_return = false;
        if (fldrive != null)
        {
            if (Math.abs (fldrive.getCurrentPosition ()) > p_count)
            {
                l_return = true;
            }
        }
        return l_return;
    }
    boolean has_right_drive_encoder_reached (double p_count)
    {
        boolean l_return = false;
        if (frdrive != null)
        {
            if (Math.abs (frdrive.getCurrentPosition ()) > p_count)
            {
                l_return = true;
            }
        }
        return l_return;
    }



}