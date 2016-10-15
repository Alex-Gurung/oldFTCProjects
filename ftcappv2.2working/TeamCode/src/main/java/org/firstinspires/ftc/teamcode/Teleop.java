package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by nages on 12/6/2015.
 */
@TeleOp(name="Zeus: Teleop", group="Zeus")

public class Teleop extends BotTelemetryArm {

    boolean it = false;

    public Teleop() {
    }

    @Override
    public void loop() {
        float x = -gamepad1.left_stick_y;
        float y = gamepad1.right_stick_y;

        if(gamepad1.y)
        {
            leverLeft(0.1);
            leverRight(0.1);
            leftmudflap(0.1);
            rightmudflap(0.1);
            setGuideLeft(0.1);
            setGuideRight(0.1);
            m_hand_position(0.1);
            v_hand_position(0.1);
            wristPosition(0.1);
            keeperPosition(0.1);
        }

        fwd(x, x, y, y);

        if (gamepad1.x)
        {

            if(pushLeft.getPosition()>0.5)
                leverLeft(pushLeft.getPosition() - 0.05);
        }
        if (gamepad1.b)
        {
            if(pushRight.getPosition()<0.5)
                leverRight(pushRight.getPosition() + 0.05);
        }

        if (gamepad1.a)
        {
            //System.exit(0);
            telemetry.addData("pushleftposition", "lol");
            telemetry.addData("pushrightposition", pushRight.getPosition());
            leverLeft(pushLeft.getPosition() + 0.05);
            //leverRight(pushRight.getPosition() - 0.05);
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
            if(gamepad2.dpad_left)
                keeperPosition(keeper.getPosition()+ 0.005);
            else
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
