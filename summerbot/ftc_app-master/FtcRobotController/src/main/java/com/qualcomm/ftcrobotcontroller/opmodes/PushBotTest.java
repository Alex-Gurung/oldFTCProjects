package com.qualcomm.ftcrobotcontroller.opmodes;

//------------------------------------------------------------------------------
//
// PushBotManual
//
/**
 * Extends the PushBotTelemetry and PushBotHardware classes to provide a basic
 * manual operational mode for the Push Bot.
 *
 * @author SSI Robotics
 * @version 2015-08-01-06-01
 */
public class PushBotTest extends PushBotTelemetry

{
    //--------------------------------------------------------------------------
    //
    // PushBotManual
    //
    //--------
    // Constructs the class.
    //
    // The system calls this member when the class is instantiated.
    //--------
    public PushBotTest ()

    {
        //
        // Initialize base classes.
        //
        // All via self-construction.

        //
        // Initialize class members.
        //
        // All via self-construction.

    } // PushBotManual::PushBotManual

    //--------------------------------------------------------------------------
    //
    // loop
    //
    //--------
    // Initializes the class.
    //
    // The system calls this member repeatedly while the OpMode is running.
    //--------
    @Override public void loop ()

    {
        boolean clicked = false;
        if(gamepad1.left_stick_button == true) clicked = true;
        if(gamepad1.right_stick_button == true) clicked = false;
        //----------------------------------------------------------------------
        //
        // DC Motors
        //
        // Obtain the current values of the joystick controllers.
        //
        // Note that x and y equal -1 when the joystick is pushed all of the way
        // forward (i.e. away from the human holder's body).
        //
        // The clip method guarantees the value never exceeds the range +-1.
        //
        // The DC motors are scaled to make it easier to control them at slower
        // speeds.
        //
        // The setPower methods write the motor power values to the DcMotor
        // class, but the power levels aren't applied until this method ends.
        //

        //
        // Manage the drive wheel motors.
        //
        float l_gp1_left_stick_y = gamepad1.left_stick_y;
        float l_left_drive_power
                = (float)scale_motor_power (l_gp1_left_stick_y);

        float l_gp1_right_stick_y = gamepad1.right_stick_y;
        float l_right_drive_power
                = (float)scale_motor_power (l_gp1_right_stick_y);

        set_drive_power (l_right_drive_power, l_left_drive_power);

        boolean sprint = gamepad1.left_bumper;
        if(sprint == true && clicked == false) set_drive_power(1, 1);

        if(gamepad1.right_bumper==true&& clicked == false)
        {
            set_drive_power (-1.0, 1.0);
        }

        //
        // Manage the arm motor.
        //
//ARM MOTOR
        boolean down = gamepad1.a;
        boolean up = gamepad1.y;
        if(up == true && clicked == false)
        {
            v_motor_left_arm.setPower (0.49);
        }
        else if(down== true && clicked == false)
        {
            v_motor_left_arm.setPower (-0.49);
        }
        if(up== false && down==false && clicked == false)
        {
            v_motor_left_arm.setPower(0.00001);
        }
        //float l_gp2_left_stick_y = -gamepad1.left_stick_y;
        //float l_left_arm_power = (float)scale_motor_power (l_gp2_left_stick_y);
        // v_motor_left_arm.setPower (l_left_arm_power);

        //----------------------------------------------------------------------
        //
        // Servo Motors
        //
        // Obtain the current values of the gamepad 'x' and 'b' buttons.
        //
        // Note that x and b buttons have boolean values of true and false.
        //
        // The clip method guarantees the value never exceeds the allowable range of
        // [0,1].
        //
        // The setPosition methods write the motor power values to the Servo
        // class, but the positions aren't applied until this method ends.
        //
        if (gamepad1.x && clicked == false)
        {
            m_hand_position (a_hand_position () + 0.05);
        }
        else if (gamepad1.b && clicked == false)
        {
            m_hand_position (a_hand_position () - 0.05);
        }
        //
        // Send telemetry data to the driver station.
        //
        update_telemetry (); // Update common telemetry
        telemetry.addData ("10", "GP1 Left: " + l_gp1_left_stick_y);
        telemetry.addData ("11", "GP1 Right: " + l_gp1_right_stick_y);
       // telemetry.addData ("12", "GP2 Left: " + l_gp2_left_stick_y);
        telemetry.addData ("13", "GP2 X: " + gamepad2.x);
        telemetry.addData ("14", "GP2 Y: " + gamepad2.b);

    } // PushBotManual::loop

} // PushBotManual
