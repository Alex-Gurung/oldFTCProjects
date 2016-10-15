package org.firstinspires.ftc.teamcode;
/**
 * Created by Charlie on 2/17/2016.
 *
 * Autonomous Code for FTC Res-Q Challenge

 */
public class brightDimLineFollow extends BotHardwareArmAuto{
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

        while (opModeIsActive()) {
            int calB = bottomsensor.blue();
            int calR = bottomsensor.red();
            int calG = bottomsensor.green();
            int tempB = 0;
            int tempR = 0;
            int tempG = 0;

            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);

            if (calB >= 1.0 && calG >= 1.0 && calR >= 1.0){
                fwd(.3, .3, -0.3, -0.3);
            }
            else{
                tempB = calB;
                tempR = calR;
                tempG = calG;
                fwd(0.2, 0.2, 0.2, 0.2);
                calB = bottomsensor.blue();
                calR = bottomsensor.red();
                calG = bottomsensor.green();

            }
        }
        fwd(0, 0, 0, 0);
        sleep(100);

    }
}

