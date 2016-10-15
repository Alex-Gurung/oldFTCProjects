/* Copyright (c) 2014, 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

/**
 * Register Op Modes
 */
public class FtcOpModeRegister implements OpModeRegister {

  /**
   * The Op Mode Manager will call this method when it wants a list of all
   * available op modes. Add your op mode to the list to enable it.
   *
   * @param manager op mode manager
   */
  public void register(OpModeManager manager) {
    //manager.register("INFO: ver. 3.51.01        (pre-summer version)", infoclass.class);
//    manager.register("NullOp", NullOp.class);
//    manager.register("newTeleOp", newTeleOp.class);
//    manager.register("ARMTESTER", armsinglestick.class);
//    manager.register("BOTv1", botv1.class);
//    manager.register("TURNLEFT", auto2.class);
//    manager.register("TURNRIGHT", auto3.class);
//    manager.register("ColorTest", ColorTest.class);
  //  manager.register("basicLineFollow", basicLineFollow.class);
   // manager.register("basicLineAlign", basicLineAlign.class);
    manager.register("TeleOp", Teleop.class);
   // manager.register("JupiterTeleOp", JupiterBotTeleOp.class);
    manager.register("PushTeleOp", PushBotTest.class);
 //   manager.register("PushTeleOp42", PushBotTest42.class);
//    manager.register("colortest", onecolortesst.class);
//    manager.register("AUTOENCODERS", autoencode.class);
//    manager.register("autotestfour", auto4.class);
//    manager.register("theGOOD THING", encodertest.class);
//   manager.register("colortest2222222222", seenpush.class);
    //manager.register("encode", encodertest.class);
//manager.register("encode", encode.class);
//      manager.register("TESTR4LIN3D3T3CT!!!!", linedetect.class);
//      manager.register("gyro test", gyro.class);
 //   manager.register("Kierian's teleop", teleoptest.class);
 //   manager.register("I2CCHANGER bottom", LinearI2cColorSensorAddressChange9915.class);
 //   manager.register("I2CCHANGER top", Lineari2cchange2.class);
//    manager.register("pushbutton", pushbutton.class);
//      manager.register("right", practice.class);
//manager.register("left",left.class);
//      manager.register("rightclimber", rightclimber.class);
//      manager.register("leftclimber", leftclimber.class);
//      manager.register("leftreg", regleft.class);/
// /     manager.register("rightreg", regright.class);
//      manager.register("gyrotest", gyro.class);
//      manager.register("THISISGONNAWORK", thisisgonnawork.class);
//    manager.register("auto", thisisgonnaworkods.class);
//    manager.register("ods test", odstest.class);
//    manager.register("real", realauto.class);
    //manager.register("right aka blue WITH THE LINE FOLLOW", bluepid.class);
    //manager.register("right aka blue", blue.class);
//    manager.register("line follow", linefoolow.class);
//    manager.register("right", radicalnewideablue.class);
 //   manager.register("rightrmi", rniblue.class);
 //   manager.register("leftrmi", rnired.class);
 //   manager.register("they're running right", theysayitsbetterblue.class);
 //   manager.register("they're running left", theysayitsbetterred.class);
//    manager.register("color", button.class);
   // manager.register("left aka red  (use at own risk)", red.class);
//    manager.register("rightest", bluetest.class);
//    manager.register("fake", fakeauto.class);
//    manager.register("button", temp.class);
//    manager.register("tot", tot.class);
//  manager.register("left", red.class);
  }
}
