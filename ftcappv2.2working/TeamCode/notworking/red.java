package org.firstinspires.ftc.teamcode;
/**
 * Created by Charlie on 2/17/2016.
 *
 * Autonomous Code for FTC Res-Q Challenge

 */
public class red extends BotHardwareArmAuto{
    public void runOpMode() throws InterruptedException
    {
//setup

        hardwareMap.logDevices();
        waitOneFullHardwareCycle();
        telemetry.addData("red", "");
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
            telemetry.addData("(c) Xbots Industries", 2016);
            telemetry.addData("calibrating",0);
        }
        something:  while (opModeIsActive()) {

            sleep(50);
            int heading = gyro1.getHeading();
            int heading2 = gyro2.getHeading();
            telemetry.addData("gyro1: ", heading);
            telemetry.addData("gyro2: ", heading2);
            if ((heading<320 && heading> 10)||(heading2<320&&heading2>10)){
                fwd(0, 0, 0, 0);
                break something;
            }
            else {
                fwd(-0.5, -0.5, -0.5, -0.5  );
            }

        }

        fwd(0, 0, 0, 0);
        sleep(100);
//drives forward until white line
        bottomsensor.blue();
        bottomsensor.red();
        bottomsensor.green();
        waitForNextHardwareCycle();
        fwd(.75,.75,-.75,-.75);
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


        int testhead1 = gyro1.getHeading();
        int testhead2 = gyro2.getHeading();
        if((testhead1<278&&testhead1>10)||(testhead2<278&&testhead2>10))
        {
            telemetry.addData("aihoiheiogbiodoig", 0);
            telemetry.addData("aihoiheiogbiodoig1", testhead1);
            telemetry.addData("aihoiheiogbiodoig2", testhead2);
            sleep(1000);
        }
        telemetry.addData("aihoiheiogbiodoig", 0);
        telemetry.addData("HIaihoiheiogbiodoig1", testhead1);
        telemetry.addData("HIaihoiheiogbiodoig2", testhead2);
        sleep(1000);



        for(int i = 0; i <500; i++)
        {
            sleep(1);
            fwd(-0.5, -0.5, -0.5, -0.5);
            telemetry.addData("gyro1", gyro1.getHeading());
            telemetry.addData("gyro2", gyro2.getHeading());
        }
        thething:        while (opModeIsActive()) {
            sleep(20);
            int heading = gyro1.getHeading();
            int heading2 = gyro2.getHeading();
            telemetry.addData("gyro1: ", heading);
            telemetry.addData("gyro2: ", heading2);
            if ((heading<272 && heading>10)||(heading2<272 && heading2>10))
            {
                fwd(0, 0, 0, 0);
                break thething;
            }
            else {
                fwd(-0.5, -0.5, -0.5, -0.5);
            }

        }
        //wristPosition(0.5);
        fwd(0, 0, 0, 0);
        sleep(100);
        fwd(.5, .5, -.5, -.5);
        sleep(1200);
        fwd(0, 0, 0, 0);
        sleep(100);
        if(ods.getRawLightDetected()<3) {
            clear:
            while (opModeIsActive()) {
                sleep(20);
                int heading = gyro1.getHeading();
                int heading2 = gyro2.getHeading();
                telemetry.addData("gyro1: ", heading);
                telemetry.addData("gyro2: ", heading2);
                if ((heading < 190 && heading > 10)||(heading2 < 190 && heading2 >10)) {
                    fwd(0, 0, 0, 0);
                    break clear;
                } else {
                    fwd(-0.4,-0.4, -0.6, -0.6);
                }

            }
            fwd(0, 0, 0, 0);
            sleep(100);


            fwd(.6, .6, -.6, -.6);

            /*while (opModeIsActive()) {
                int calB = bottomsensor.blue();
                int calR = bottomsensor.red();
                int calG = bottomsensor.green();
                telemetry.addData("Blue: ", calB);
                telemetry.addData("Green: ", calG);
                telemetry.addData("Red: ", calR);

                if (calB >= 1.0 && calR == 0)
                    break;
            }*/


            //waiting for forward
            sleep(500);



            fwd(0, 0, 0, 0);
            sleep(100);


            raiser.setPower(0.4);
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
            sleep(100);

            clear:
            while (opModeIsActive()) {
                sleep(20);
                int heading = gyro1.getHeading();
                int heading2 = gyro2.getHeading();
                telemetry.addData("gyro1: ", heading);
                telemetry.addData("gyro2: ", heading2);
                //before is smaller than 90
                if ((heading > 279)||(heading2 > 279)) {
                    fwd(0, 0, 0, 0);
                    break clear;
                } else {
                    //0.6,0.6
                    fwd(-0.7, -0.7, -0.6, -0.6);
                }

            }
            fwd(0, 0, 0, 0);
            sleep(100);
            fwd(.35, .35, -.35, -.35);
            while (opModeIsActive()) {
                telemetry.addData("ods", ods.getRawLightDetected());
                //used to be 3
                if (ods.getRawLightDetected() >= 2) {
                    break;
                }
            }
        }
//drops climbers
        fwd(0, 0, 0, 0);
        wristPosition(0.5);
        fwd(0, 0, 0, 0);
        raiser.setPower(0.5);
        sleep(1700);
        raiser.setPower(0.1);
        sleep(1500);
        raiser.setPower(0);
        wristPosition(0.5);
//push button code
        wristPosition(0.5);
        fwd(.5,.5,-.5,-.5);
        while(opModeIsActive())
        {
            telemetry.addData("ods", ods.getRawLightDetected());
            if(ods.getRawLightDetected()>5) {
                break;
            }
        }
        fwd(0, 0, 0, 0);
        wristPosition(0.5);
        sensorRGB.enableLed(true);
        pushButton.setPosition(0.5);
        telemetry.addData("topBlue: ", sensorRGB.blue());
        telemetry.addData("topRed: ", sensorRGB.red());
        if(sensorRGB.blue()<sensorRGB.red()){
            pushButton.setPosition(0.98);
            telemetry.addData("pushing red ", "right");
        }
        else if(sensorRGB.blue()<sensorRGB.red())
        {
            pushButton.setPosition(0.02);
            telemetry.addData("pushing red ", "left");
        }
    }


}