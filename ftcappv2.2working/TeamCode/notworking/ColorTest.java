package org.firstinspires.ftc.teamcode;
public class ColorTest extends BotHardwareArmAuto {

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("right", "");
        waitForStart();
        setup();
        bottomsensor.setI2cAddress(0x42);
        bottomsensor.enableLed(true);
        sensorRGB.setI2cAddress(sensorRGB.getI2cAddress());
        while(opModeIsActive()) {
            int calB = bottomsensor.blue();
            int calR = bottomsensor.red();
            int calG= bottomsensor.green();
            telemetry.addData("Blue: ", calB);
            telemetry.addData("Green: ", calG);
            telemetry.addData("Red: ", calR);
            telemetry.addData("topBlue: ", sensorRGB.blue());
            telemetry.addData("topGreen: ", sensorRGB.green());
            telemetry.addData("topRed: ", sensorRGB.red());
        }

    }
}