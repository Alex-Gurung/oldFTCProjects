package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Charlie on 2/17/2016.
 *
 * Autonomous Code for FTC Res-Q Challenge

 */
public class basicLineAlign extends BotHardwareArmAuto{
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
        int count = 0;
        while (count<80) { //Line follow
            calB = bottomsensor.blue();
            calR = bottomsensor.red();
            calG = bottomsensor.green();
            tempB = calB;
            tempR = calR;
            tempG = calG;

            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);
            if (calB < 1.0 || calG < 1.0 || calR < 1.0){
                while ((calB < 1.0 || calG < 1.0 || calR < 1.0)&&opModeIsActive()){ //If it's not on line, turnn right
                    fwd(0.65, 0.65, 0.65, 0.65); //For both, 0.35 was too low so we increased it
                    calB = bottomsensor.blue();
                    calR = bottomsensor.red();
                    calG = bottomsensor.green();
                    telemetry.addData("Blue: ", calB);
                    telemetry.addData("Green: ", calG);
                    telemetry.addData("Red: ", calR);
                }
                fwd(0.97,0.97,-0.97,-0.97);
                sleep(125);
                fwd(0,0,0,0);

            }
            else if(calR>=1.0&&calB>=1.0&&calG>=1.0&&opModeIsActive())
            {
                count++;
            }
        }


        int rhigh = 0;
        int ghigh = 0;
        int bhigh = 0;

        calB = bottomsensor.blue();
        calR = bottomsensor.red();
        calG = bottomsensor.green();
        telemetry.addData("Blue: ", calB);
        telemetry.addData("Green: ", calG);
        telemetry.addData("Red: ", calR);

        fwd(-0.5, -0.5, -0.5, -0.5);
        sleep(500);
        fwd(0, 0, 0, 0);

        while(((bottomsensor.blue()>=bhigh)&&(bottomsensor.green()>=ghigh)&&(bottomsensor.red()>=rhigh))&&opModeIsActive())
        {
            bhigh=bottomsensor.blue();
            ghigh=bottomsensor.green();
            rhigh=bottomsensor.red();
            fwd(0.64,0.64,0.64,0.64);
        }
        fwd(0, 0, 0, 0);


        telemetry.addData("Blue High:", bhigh);
        telemetry.addData("Green High:", ghigh);
        telemetry.addData("Red High:", rhigh);
        sleep(20);

        fwd(0, 0, 0, 0);
        sleep(100);






        fwd(-0.5, -0.5, -0.5, -0.5);
        sleep(500);
        fwd(0, 0, 0, 0);
        while (count<80) { //Line follow
            calB = bottomsensor.blue();
            calR = bottomsensor.red();
            calG = bottomsensor.green();
            tempB = calB;
            tempR = calR;
            tempG = calG;

            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);
            if (calB < 1.0 || calG < 1.0 || calR < 1.0){
                while (calR>=1.0&&calB>=1.0&&calG>=1.0&&opModeIsActive()){ //If it's not on line, turnn right
                    fwd(-0.65, -0.65, -0.65, -0.65); //For both, 0.35 was too low so we increased it
                    calB = bottomsensor.blue();
                    calR = bottomsensor.red();
                    calG = bottomsensor.green();
                    telemetry.addData("Blue: ", calB);
                    telemetry.addData("Green: ", calG);
                    telemetry.addData("Red: ", calR);
                }
                fwd(0.97,0.97,-0.97,-0.97);
                sleep(125);
                fwd(0,0,0,0);

            }
            else if((calB < 1.0 || calG < 1.0 || calR < 1.0)&&opModeIsActive())
            {
                count++;
            }
        }


        int globalhigh=Math.min(Math.min(rhigh,bhigh),ghigh);
        telemetry.addData("globalhigh: ", globalhigh);
        int globallow=0;
        int maxturn = globalhigh-1;
        int minturn = globallow+1;
        int whitevalue = 0;
        while(opModeIsActive()) {
            calB = bottomsensor.blue();
            calR = bottomsensor.red();
            calG = bottomsensor.green();
            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);
            whitevalue = Math.min(Math.min(calB, calG),calR);
            if(whitevalue>=maxturn)
            {
                fwd(0.2,0.2,-0.45,-0.45);
            }
            else if(whitevalue<=minturn)
            {
                fwd(0.45,0.45,-0.2,-0.2);
            }
            else if(whitevalue>minturn && whitevalue<maxturn)
            {
                fwd(0.5,0.5,-0.5,-0.5);
            }
        }




    }
}

