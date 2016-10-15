package org.firstinspires.ftc.teamcode;
/**
 * Created by Charlie on 2/17/2016.
 *
 * Autonomous Code for FTC Res-Q Challenge

 */
public class bluetest extends BotHardwareArmAuto{
    public void runOpMode() throws InterruptedException
    {
//setup

        hardwareMap.logDevices();
        waitOneFullHardwareCycle();
        telemetry.addData("right", "");
        waitForStart();
        setup();
        pushLeft.setPosition(1);
        bottomsensor.setI2cAddress(0x42);
        sleep(100);
        //i2c address change
        bottomsensor.enableLed(true);
        sensorRGB.setI2cAddress(0x40);
        sensorRGB.enableLed(false);


        sleep(100);
        wristPosition(0.5);
        m_hand_position(0);
        v_hand_position(1);

//leaves the wall
        pushLeft.setPosition(1);
        fwd(0.4,0.4,-0.4,-0.4);
        sleep(800);
        fwd(0, 0, 0, 0);
        gyro1.calibrate();
        gyro2.calibrate();
        sleep(250);
//turns 45 degrees
        while(gyro1.isCalibrating()||gyro2.isCalibrating())
        {
            telemetry.addData("(c) Edward Industries", 2016);
            telemetry.addData("calibrating",0);
        }
        something:  while (opModeIsActive()) {

            sleep(50);
            int heading = gyro1.getHeading();
            int heading2 = gyro2.getHeading();
            telemetry.addData("gyro1: ", heading);
            telemetry.addData("gyro2: ", heading2);
            if ((heading>43 && heading< 350)||(heading2>43&&heading<350)){
                fwd(0, 0, 0, 0);
                break something;
            }
            else {
                fwd(0.4, 0.4, 0.4, 0.4  );
            }

        }

        fwd(0,0,0,0);
        sleep(500);
//drives forward until white line
        bottomsensor.blue();
        bottomsensor.red();
        bottomsensor.green();
        waitForNextHardwareCycle();
        fldrive.setPower(0.6);

        frdrive.setPower(-0.6);
        bldrive.setPower(0.6);
        brdrive.setPower(-0.6);

        while(opModeIsActive()) {
            int calB = bottomsensor.blue();
            int calR = bottomsensor.red();
            int calG= bottomsensor.green();
            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);

            if((calB>=1.0&&calG>=1.0)&&calR>=1.0)
                break;
        }
//turns until 90 degrees
        wristPosition(0.5);
        fwd(0, 0, 0, 0);
        sleep(500); //FROM 500 FOR THE TEST
        while(gyro1.isCalibrating())
        {
            telemetry.addData("hi",0);
        }
        thething:        while (opModeIsActive()) {
            sleep(20);
            int heading = gyro1.getHeading();
            int heading2 = gyro2.getHeading();

            telemetry.addData("gyro1: ", heading);
            telemetry.addData("gyro2: ", heading2);
            if ((heading>250 && heading<350)||(heading2>250 && heading2<350))//((heading>82 && heading<350)||(heading2>82 && heading2<350))
            {
                fwd(0, 0, 0, 0);
                break thething;
            }
            else {
                fwd(0.5, 0.5, 0.5, 0.5);
            }

        }
        //wristPosition(0.5);
        fwd(0, 0, 0, 0);
        sleep(300);
        fwd(.5, .5, -.5, -.5);
        sleep(1200);
        fwd(0, 0, 0, 0);
        sleep(300);
        if(ods.getLightDetectedRaw()<3) {
            clear:
            while (opModeIsActive()) {
                sleep(20);
                int heading = gyro1.getHeading();
                int heading2 = gyro2.getHeading();
                telemetry.addData("gyro1: ", heading);
                telemetry.addData("gyro2: ", heading2);
                if ((heading > 170 && heading < 350)||(heading2 > 170 && heading2 < 350)) {
                    fwd(0, 0, 0, 0);
                    break clear;
                } else {
                    fwd(0.6, 0.6, 0.4, 0.4);
                }

            }
            fwd(0, 0, 0, 0);
            sleep(300);


            fwd(.6, .6, -.6, -.6);

            while (opModeIsActive()) {
                int calB = bottomsensor.blue();
                int calR = bottomsensor.red();
                int calG = bottomsensor.green();
                telemetry.addData("Blue: ", calB);
                telemetry.addData("Green: ", calG);
                telemetry.addData("Red: ", calR);

                if (calB >= 1.0 && calR == 0)
                    break;
            }
            fwd(0, 0, 0, 0);
            sleep(300);


            raiser.setPower(4);
            sleep(200);
            raiser.setPower(0);


            sleep(300);
            fwd(-.6, -.6, .6, .6);

            while (opModeIsActive()) {
                int calB = bottomsensor.blue();
                int calR = bottomsensor.red();
                int calG = bottomsensor.green();
                telemetry.addData("Blue: ", calB);
                telemetry.addData("Green: ", calG);
                telemetry.addData("Red: ", calR);

                if ((calB >= 1.0 && calG >= 1.0) && calR >= 1.0)
                    break;
            }
            fwd(0, 0, 0, 0);
            sleep(300);

            clear:
            while (opModeIsActive()) {
                sleep(20);
                int heading = gyro1.getHeading();
                int heading2 = gyro2.getHeading();
                telemetry.addData("gyro1: ", heading);
                telemetry.addData("gyro2: ", heading2);
                if ((heading < 90)||(heading2 < 90)) {
                    fwd(0, 0, 0, 0);
                    break clear;
                } else {
                    fwd(-0.6, -0.6, -0.6, -0.6);
                }

            }
            fwd(0, 0, 0, 0);
            sleep(300);
            fwd(.3, .3, -.3, -.3);
            while (opModeIsActive()) {
                telemetry.addData("ods", ods.getLightDetectedRaw());
                if (ods.getLightDetectedRaw() >= 3) {
                    break;
                }
            }
        }
//drops climbers
        fwd(0, 0, 0, 0);

//drops climbers
        fwd(0, 0, 0, 0);
        wristPosition(0.5);
        fwd(0, 0, 0, 0);
        raiser.setPower(0.4);
        sleep(1500);
        raiser.setPower(0.1);
        sleep(1500);
        raiser.setPower(0);
        wristPosition(0.5);
//push button code
        wristPosition(0.5);
        fwd(.3,.3,-.3,-.3);
        while(opModeIsActive())
        {
            telemetry.addData("ods", ods.getLightDetectedRaw());
            if(ods.getLightDetectedRaw()>5) {
                break;
            }
        }
        fwd(0, 0, 0, 0);
        wristPosition(0.5);
        sensorRGB.enableLed(true);
        pushButton.setPosition(0.5);
        telemetry.addData("topBlue: ", sensorRGB.blue());
        telemetry.addData("topRed: ", sensorRGB.red());
        if(sensorRGB.blue()>sensorRGB.red()){
            pushButton.setPosition(1);
            telemetry.addData("pushing blue ", "right");
        }
        else if(sensorRGB.blue()<sensorRGB.red())
        {
            pushButton.setPosition(0);
            telemetry.addData("pushing blue ", "left");
        }
    }


}
