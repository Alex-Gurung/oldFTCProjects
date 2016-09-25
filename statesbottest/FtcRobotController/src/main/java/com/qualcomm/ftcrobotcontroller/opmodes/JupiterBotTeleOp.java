package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by cwu on 12/6/2015.
 */
public class JupiterBotTeleOp extends JupiterBotTelemetry {
    public JupiterBotTeleOp() {
    }
    @Override
    public void loop() {
        float x = -gamepad1.left_stick_y;
        float y = gamepad1.right_stick_y;
        fwd(x, y);
        if(gamepad1.a) collect(0.99);
        if(gamepad1.y) collect(-0.99);
        if(gamepad1.b)
        {
            telemetry.addData("rolz eric this is revenge",12345);
            collect(0);
        }
    }
}
