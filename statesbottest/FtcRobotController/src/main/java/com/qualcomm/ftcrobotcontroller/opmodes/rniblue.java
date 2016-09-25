package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Charlie on 2/17/2016.
 *
 * Autonomous Code for FTC Res-Q Challenge

 */
public class rniblue extends BotHardwareArmAuto{
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
            telemetry.addData("(c) Xbots Industries", 2016);
            telemetry.addData("calibrating",0);
        }
        for(int i = 0; i < 100; i++)
        {
            telemetry.addData("leftgyro", gyro1.getHeading());
            telemetry.addData("rightgyro", gyro2.getHeading());
            fwd(0.5, 0.5, 0.5, 0.5);
            sleep(5);
        }
        fwd(0,0,0,0);

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
        //USED TO BE 0.75
        fwd(.859,.859,-.85,-.85);
        while(opModeIsActive()) {
            int calB = bottomsensor.blue();
            int calR = bottomsensor.red();
            int calG= bottomsensor.green();
            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);
            if(calB==0.0&&calG==0.0&&calR>0.0)
            {
                telemetry.addData("EXCEPTION CALLED HIT THE OTHER SIDE STOPPING EVERYTHING", 99999);
                fwd(-0.3,-0.3,0.3,0.3);
                sleep(2000);
                fwd(0,0,0,0);
                sleep(100000);
            }
            if((calB>=1.0&&calG>=1.0)&&calR>=1.0)
                break;
        }
//pushes blocks out of way
        wristPosition(0.5);
        fwd(0, 0, 0, 0);
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

        thething:        while (opModeIsActive()) {
            sleep(20);
            int heading = gyro1.getHeading();
            int heading2 = gyro2.getHeading();
            telemetry.addData("gyro1: ", heading);
            telemetry.addData("gyro2: ", heading2);
            if (((heading<360)&&(heading>320))||((heading2<360)&&(heading2>320)))
            {
                fwd(0, 0, 0, 0);
                break thething;
            }
            else {
                fwd(-0.6, -0.6, -0.6, -0.6);
            }

        }
        fwd(0, 0, 0, 0);

        fwd(0.6, 0.6, -0.6, -0.6);
        sleep(900);
        fwd(0, 0, 0, 0);
        raiser.setPower(0.45);
        sleep(500);
        raiser.setPower(0);
        sleep(100);
        //fwd(-0.6,-0.6,0.6,0.6);
        //sleep(550);
        //fwd(0,0,0,0);

        fwd(0,0,0,0);



        sleep(100);
        fwd(-0.6,-0.6,0.6,0.6);
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
        //wristPosition(0.5);
        fwd(0, 0, 0, 0);





        /*sleep(200);
        fwd(0.10,0.10,.55,.55);
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
        //wristPosition(0.5);
        fwd(0, 0, 0, 0);
*/



        fwd(1,1,0,0);
        sleep(1150);
        fwd(0,0,0,0);

        fwd(0,0,1,1);
        sleep(1055);
        fwd(0,0,0,0);


       long timestart = System.currentTimeMillis();

        double dif = 0.3;
        int count = 0;
        int testnow = 1000;
        timergoout: while (ods.getLightDetectedRaw()<2) {
            /*if(timestart-System.currentTimeMillis()>8500)
            {
                break timergoout;
            }*/
            if(bottomsensor.red()>0 && bottomsensor.green()>0 && bottomsensor.blue()>0)
            {
                fwd(0.5,0.5,0.2,0.2);
            }
            else
            {
                fwd(-0.2,-0.2,-0.5,-0.5);
            }
            sleep(40);
        }
        fwd(0, 0, 0, 0);


        wristPosition(0.5);
        fwd(0, 0, 0, 0);
        raiser.setPower(0.5);
        sleep(1700);
        raiser.setPower(0.02);
        sleep(1500);
        raiser.setPower(0);
        wristPosition(0.5);
        wristPosition(0.5);
        fwd(.3, .3, -.3, -.3);
        while(opModeIsActive())
        {
            telemetry.addData("ods", ods.getLightDetectedRaw());
            if(ods.getLightDetectedRaw()>3.
                    ) {
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
