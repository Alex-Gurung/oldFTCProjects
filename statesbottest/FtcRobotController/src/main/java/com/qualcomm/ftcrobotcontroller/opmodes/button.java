package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by nages on 3/16/2016.
 */
public class button extends BotHardwareArmAuto {
    @Override
    public void runOpMode() throws InterruptedException {
        hardwareMap.logDevices();
        waitOneFullHardwareCycle();
        telemetry.addData("what color is it", "");
        waitForStart();
        setup();
        pushLeft.setPosition(1);
        bottomsensor.setI2cAddress(0x42);
        sleep(100);
        //i2c address change
        bottomsensor.enableLed(true);
        sensorRGB.setI2cAddress(0x40);
        sensorRGB.enableLed(true);

while(opModeIsActive())
{
    if(gamepad1.a) {
    sensorRGB.enableLed(false);
    }
    if(gamepad1.x)
        pushButton.setPosition(1.0);
    if (gamepad1.y)
        pushButton.setPosition(0);
    telemetry.addData("blue: ", sensorRGB.blue());
    telemetry.addData("green: ", sensorRGB.green());
    telemetry.addData("red: ", sensorRGB.red());
}





    }
}
