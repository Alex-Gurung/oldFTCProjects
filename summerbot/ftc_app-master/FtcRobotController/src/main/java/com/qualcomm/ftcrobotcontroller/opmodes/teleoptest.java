package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by nages on 12/6/2015.
 */
public class teleoptest extends BotTelemetryArm {

    boolean it = false;

    public teleoptest() {
    }

    @Override
    public void loop() {
        float x = -gamepad1.left_stick_y;
        float y = gamepad1.right_stick_y;


        fwd(x, x, y, y);

        if (gamepad1.x)
        {
            pushButton.setPosition(0.1);
        }
        if (gamepad1.b)
        {
            pushButton.setPosition(0.9);
        }
        if (gamepad1.a)
        {
            leverLeft(pushLeft.getPosition() + 0.05);
            leverRight(pushRight.getPosition() - 0.05);
    }
        if (gamepad1.dpad_down)
        {
            leftmudflap(leftMud.getPosition() + 0.05);
            rightmudflap(rightMud.getPosition() - 0.05);
        }
        if(gamepad1.dpad_up)
        {
            leftmudflap(leftMud.getPosition()-0.05);
            rightmudflap(rightMud.getPosition()+0.05);
        }
        if(gamepad1.right_bumper)
        {
            setGuideRight(guideRight.getPosition() - 0.01);
        }
        if(gamepad1.right_trigger>0.5)
        {
            setGuideRight(guideRight.getPosition()+0.01);
        }
        if(gamepad1.left_bumper)
        {
            setGuideLeft(guideLeft.getPosition() + 0.01);
        }
        if(gamepad1.left_trigger>0.5)
        {
            setGuideLeft(guideLeft.getPosition()-0.01);
        }
        //if(!gamepad1.right_bumper && gamepad1.right_trigger <= 0.5)
        //    setGuideRight(0.5);
        //if(!gamepad1.left_bumper && gamepad1.left_trigger <= 0.5)
        //    setGuideLeft(0.5);
        //Second Gamepad

        if (gamepad2.x) {
            m_hand_position(fingers.getPosition() + 0.05);
            v_hand_position(rightdoor.getPosition() - 0.05);
        }
        if (gamepad2.b) {
            m_hand_position(fingers.getPosition() - 0.05);
            //collect(0);
            v_hand_position(rightdoor.getPosition() + 0.05);
        }
        if (gamepad2.dpad_down)
        {
            wristPosition(wrist.getPosition() - 0.05);
        }
        if (gamepad2.dpad_up) {
            wristPosition(wrist.getPosition() + 0.05);

        }
        if(!gamepad2.dpad_down && !gamepad2.dpad_up) wristPosition(0.5);
        if(gamepad2.y)
        {
            keeperPosition(keeper.getPosition() + 0.05);
        }
        if(gamepad2.a)
        {
            keeperPosition(keeper.getPosition() - 0.05);
        }
        if (gamepad2.left_bumper) {
            leftbicep.setPower(1);
        }
        if (gamepad2.right_bumper) {
            rightbicep.setPower(-1);
        }
        if (gamepad2.left_trigger > 0.5) {
            leftbicep.setPower(-0.99);
        }
        if (gamepad2.right_trigger >0.5) {
            rightbicep.setPower(0.99);
        }
        if(gamepad2.left_bumper == false && gamepad2.left_trigger < 0.5)
        {
            leftbicep.setPower(0);
        }
        if(gamepad2.right_bumper == false && gamepad2.right_trigger < 0.5)
        {
            rightbicep.setPower(0);
        }
        float turn = -gamepad2.left_stick_x;
        float raise = -gamepad2.right_stick_y;
        armcontrol(turn, raise);
    }
}