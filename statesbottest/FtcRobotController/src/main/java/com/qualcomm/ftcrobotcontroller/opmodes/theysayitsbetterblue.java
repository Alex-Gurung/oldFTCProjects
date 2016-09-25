package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Charlie on 2/17/2016.
 *
 * Autonomous Code for FTC Res-Q Challenge

 */
public class theysayitsbetterblue extends BotHardwareArmAuto{
    public void runOpMode() throws InterruptedException
    {
//setup

        hardwareMap.logDevices();
        waitOneFullHardwareCycle();
        telemetry.addData("right... BUT THEY ARE RUNNING NOOOOOOOOOOOO GAHHHHH", "");
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
        sleep(100);
        while(ods.getLightDetectedRaw()<=2)
        {
            fwd(0.6,0.6,-0.6,-0.6);
        }
        fwd(0,0,0,0);
        sleep(100);
























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
                fwd(0.5, 0.5, 0, 0);
            }

        }
        fwd(0, 0, 0, 0);
        sleep(200);






        fwd(0.5,0.5,-0.5,-0.5);
        sleep(800);
        fwd(0,0,0,0);





    }


}
