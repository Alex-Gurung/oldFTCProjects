package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Charlie on 2/17/2016.
 *
 * Autonomous Code for FTC Res-Q Challenge

 */
public class basicLineFollow extends BotHardwareArmAuto{
    public void runOpMode() throws InterruptedException
    {
//setup

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


        int calB = bottomsensor.blue();
        int calR = bottomsensor.red();
        int calG = bottomsensor.green();
        int tempB = calB;
        int tempR = calR;
        int tempG = calG;
        while(!(calB >=1 && calR >= 1 && calG >= 1) && opModeIsActive()) { //Move forward until we hit the white line
            fwd(0.2, 0.2,-0.2,-0.2);
            calB = bottomsensor.blue();
            calR = bottomsensor.red();
            calG = bottomsensor.green();
        }
        fwd(0, 0, 0, 0);
        sleep(100); //To go further onto line
        while(calB >=1 && calR >= 1 && calG >= 1 && opModeIsActive()){
            fwd(0.2, 0.2,-0.2,-0.2);
            calB = bottomsensor.blue();
            calR = bottomsensor.red();
            calG = bottomsensor.green();
        }
        fwd(0, 0, 0, 0); //WORKS UP UNTIL THIS POINT, WHEN WE NEED TO CURVE THE RIGHT SIDE BACK UNTIL STRAIGHT
        while (opModeIsActive()) { //Line follow
            calB = bottomsensor.blue();
            calR = bottomsensor.red();
            calG = bottomsensor.green();
            tempB = calB;
            tempR = calR;
            tempG = calG;

            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);
            if (calB < 1.0 && calG < 1.0 && calR < 1.0){ //If it's not on line, turnn right
                fwd(0.5, 0.5, 0.5, 0.5); //For both, 0.35 was too low so we increased it
            }
            else if (calB >7 && calR > 7 && calG > 7){ //If too white, turn left
                fwd(-0.5, -0.5, -0.5, -0.5);
            }
            else { //else go straight
                fwd(0.5, 0.5, 0.5, 0.5);
            }
        }
        fwd(0, 0, 0, 0);
        sleep(100);

    }
}

