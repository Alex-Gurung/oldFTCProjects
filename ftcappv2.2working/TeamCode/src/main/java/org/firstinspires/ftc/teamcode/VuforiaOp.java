package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Derived from video posted by FTC #3491 - see https://youtu.be/2z-o9Ts8XoE
 *
 */

public class VuforiaOp extends LinearOpMode {
  @Override
  public void runOpMode() throws InterruptedException {
    VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);

    // - Which camera to use - BACK (the standard) or FRONT ("selfie").
    // - License key comes from the Vuforia web portal and maps to a developer's
    //   PERSONAL account.
    params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
    params.vuforiaLicenseKey = "AT63C8j/////AAAAGYOA5bqcME1yiMj1JQeoV/tY29plEVJ31c7A6JMjVMvGt9jKKbYT8Qwt67Bxptndzldbw0cMNoggwFQAUtgh6DtUQxSuHkoEcR0wslGfL2CCge3fVN/0lVrlUOk9vu9ggPbo+1HcSp9eydTu0h2/9+BtHwJv+47CfDPrYEJvhJ8yuQOYy4dcWeqP+wR6eiMm5WrXGircYkcIPfjuialHJLys+33hz1yrrMBu0UrHg4uA8q54UDVF14hUOxB9uxfI/AkXAc4atXRvjzdILLDWy1UxUnKtVkeeI3v3tPQJh4nTKfNc3BF1k6nWAXYFYx+ypNz3wpZ1v96wRHqvbSF6Tnz+ihA7H9F9iqUmJjgEt9NX";
    params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

    // Init the class and tell it what to look for.  The "FTC_2016-17" label comes
    // from the name of the XML file in the assets folder of the FtcRobotController module.
    VuforiaLocalizer vuforia = ClassFactory.createVuforiaLocalizer(params);
    Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

    VuforiaTrackables beacons = vuforia.loadTrackablesFromAsset("FTC_2016-17");
    beacons.get(0).setName("Wheels");
    beacons.get(1).setName("Tools");
    beacons.get(2).setName("Logo");
    beacons.get(3).setName("Gears");

    waitForStart();
    beacons.activate();

    while (opModeIsActive()) {
      for(VuforiaTrackable beac : beacons) {
        OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) beac.getListener()).getPose();

        // Assuming we have a result, get the data and output it to the screen of the controller.
        if(pose != null) {
          VectorF translation = pose.getTranslation();
          telemetry.addData(beac.getName() + "-Translation", translation);

          // This is for phones oriented in portrait mode.  In Landscape, use 0 and 2.

          double degreesToTurn = Math.toDegrees(Math.atan2(translation.get(1), translation.get(2)));
          telemetry.addData(beac.getName() + "-Degrees", degreesToTurn);
        }
      }
      telemetry.update();
    }
  }
}
