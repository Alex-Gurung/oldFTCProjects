package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by cwu on 3/15/2016.
 */
public class linefoolow extends BotHardwareArmAuto {
    public void runOpMode() throws InterruptedException{
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

        fwd(0, 0, 0, 0);
        sleep(100);
        fwd(-0.6, -0.6, -0.6, -0.6);
        sleep(350);
        fwd(0, 0, 0, 0);

        double dif = 0.3;
        int count = 0;
        int testnow = 1000;
        while (ods.getLightDetectedRaw()<2) {
            if(bottomsensor.red()>0 && bottomsensor.green()>0 && bottomsensor.blue()>0)
            {
                fwd(0.5,0.5,0.3,0.3);
            }
            else
            {
                fwd(-0.3,-0.3,-0.5,-0.5);
            }
            sleep(50);
        }
        fwd(0,0,0,0);

    }
}
