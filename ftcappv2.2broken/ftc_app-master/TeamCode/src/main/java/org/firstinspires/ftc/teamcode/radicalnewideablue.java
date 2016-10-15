package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Charlie on 2/17/2016.
 *
 * Autonomous Code for FTC Res-Q Challenge

 */
public class radicalnewideablue extends BotHardwareArmAuto{
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
        //wristPosition(0.5);
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
            if ((heading>43 && heading< 350)||(heading2>43&&heading<350)){
                fwd(0, 0, 0, 0);
                break something;
            }
            else {
                fwd(0.5, 0.5, 0.5, 0.5 );
            }

        }

        fwd(0, 0, 0, 0);
        sleep(100);
//drives forward until white line
        bottomsensor.blue();
        bottomsensor.red();
        bottomsensor.green();
        waitForNextHardwareCycle();
        fwd(.75, .75, -.75, -.75);
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
        fwd(0,0,0,0);
        sleep(100);

        raiser.setPower(0.45);
        sleep(200);
        raiser.setPower(0);

        sleep(100);

//pushes blocks out of way
        //wristPosition(0.5);
        //fwd(0, 0, 0, 0);
        sleep(500); //FROM 500 FOR THE TEST
        while(gyro1.isCalibrating())
        {
            telemetry.addData("gyro calibrating...",0);
        }




        for(int i = 0; i <500; i++)
        {
            fwd(0,0,0,0);
            sleep(1);
            telemetry.addData("gyro1", gyro1.getHeading());
            telemetry.addData("gyro2", gyro2.getHeading());
        }
        fwd(0, 0, -0.6, -0.6);
        sleep(750);
        fwd(0, 0, 0, 0);
        thething5:        while (opModeIsActive()) {
            sleep(20);
            int heading = gyro1.getHeading();
            int heading2 = gyro2.getHeading();
            telemetry.addData("gyro1: ", heading);
            telemetry.addData("gyro2: ", heading2);
            if (((heading<=360)&&(heading>340))||((heading2<=360)&&(heading2>340)))
            {
                fwd(0, 0, 0, 0);
                break thething5;
            }
            else {
                fwd(0, 0, -0.73, -0.73);
            }

        }
fwd(0, 0, 0, 0);
sleep(200);
//        fwd(-0.35, -0.35, .55, .55);
/*        while(opModeIsActive()) {
            int calB = bottomsensor.blue();
            int calR = bottomsensor.red();
            int calG= bottomsensor.green();
            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);

            if((calB>=1.0&&calG>=1.0)&&calR>=1.0)
                break;
        }
        //wristPosition(0.5);
        fwd(0, 0, 0, 0);
*/









//        fwd(0, 0, 0, 0);
        sleep(500); //FROM 500 FOR THE TEST
        while(gyro1.isCalibrating())
        {
            telemetry.addData("hi",0);
        }
        for(int i = 0; i <500; i++)
        {
            fwd(0,0,0,0);
            sleep(1);
            telemetry.addData("gyro1", gyro1.getHeading());
            telemetry.addData("gyro2", gyro2.getHeading());
        }
        fwd(0, 0, -0.6, -0.6);
        sleep(750);
        fwd(0, 0, 0, 0);
        thething4:        while (opModeIsActive()) {
            sleep(20);
            int heading = gyro1.getHeading();
            int heading2 = gyro2.getHeading();
            telemetry.addData("gyro1: ", heading);
            telemetry.addData("gyro2: ", heading2);
            if (((heading<=120)&&(heading>95))||((heading2<=120)&&(heading2>95)))
            {
                fwd(0, 0, 0, 0);
                break thething4;
            }
            else {
                fwd(0, 0, 0.73, 0.73);
            }

        }
        fwd(0, 0, 0, 0);
        sleep(200);







        fwd(0.1, 0.1, 0.73, 0.73);
        sleep(1610);
        fwd(0, 0, 0, 0);



telemetry.addData("YAS IT WORKERD", 0);
        sleep(1000);

        //fwd(0.5, 0.5, -0.65, -0.65);
        //sleep(850);
        //fwd(0,0,0,0);
        fwd(-0.5,-0.5,-0.5,-0.5);
        sleep(390);
        fwd(0,0,0,0);










/*
        fwd(0, 0, 0, 0);
        sleep(100);
        fwd(0.6, 0.6, 0.6, 0.6);
        sleep(2000);
        fwd(0, 0, 0, 0);
*/
        long timestart = System.currentTimeMillis();

        double dif = 0.3;
        int count = 0;
        int testnow = 1000;
theloop3:        while ((System.currentTimeMillis()-timestart > 4000)) {
    if((System.currentTimeMillis()-timestart > 4000)) break theloop3;
            telemetry.addData("TIMESINCESTARTOFLINEFOLLOW", System.currentTimeMillis()-timestart);
            if(bottomsensor.red()>0 && bottomsensor.green()>0 && bottomsensor.blue()>0)
            {
                fwd(0.5,0.5,0.35,0.35);
            }
            else
            {
                fwd(-0.35,-0.35,-0.5,-0.5);
            }
            sleep(50);
        }
        fwd(0, 0, 0, 0);











        timestart = System.currentTimeMillis();

        dif = 0.3;
        count = 0;
        testnow = 1000;
        theloop2:        while ((System.currentTimeMillis()-timestart > 6000)||ods.getLightDetectedRaw()>2) {
            if((System.currentTimeMillis()-timestart > 6000)) break theloop2;
            telemetry.addData("TIMESINCESTARTOFLINEFOLLOW", System.currentTimeMillis()-timestart);
            if(bottomsensor.red()>0 && bottomsensor.green()>0 && bottomsensor.blue()>0)
            {
                fwd(0.5,0.5,-0.35,-0.35);
            }
            else
            {
                fwd(0.35,0.35,-0.5,-0.5);
            }
            sleep(200);
        }
        fwd(0, 0, 0, 0);
















        wristPosition(0.5);
        fwd(0, 0, 0, 0);
        raiser.setPower(0.5);
        sleep(1700);
        raiser.setPower(0.1);
        sleep(1500);
        raiser.setPower(0);
        wristPosition(0.5);
        wristPosition(0.5);
        fwd(.3, .3, -.3, -.3);
        while(opModeIsActive())
        {
            telemetry.addData("ods", ods.getLightDetectedRaw());
            if(ods.getLightDetectedRaw()>3) {
                break;
            }
        }
        fwd(0, 0, 0, 0);
        wristPosition(0.5);
        sensorRGB.enableLed(false);
        pushButton.setPosition(0.5);
        telemetry.addData("topBlue: ", sensorRGB.blue());
        telemetry.addData("topRed: ", sensorRGB.red());
        if(sensorRGB.blue()>sensorRGB.red()){
            pushButton.setPosition(0);
            telemetry.addData("pushing blue ", "right");
        }
        else if(sensorRGB.blue()<sensorRGB.red())
        {
            pushButton.setPosition(1);
            telemetry.addData("pushing blue ", "left");
        }


    }


}
