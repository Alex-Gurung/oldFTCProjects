package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.lasarobotics.vision.android.Cameras;
import org.lasarobotics.vision.ftc.resq.Beacon;
import org.lasarobotics.vision.opmode.VisionOpMode;
import org.lasarobotics.vision.opmode.extensions.CameraControlExtension;
import org.lasarobotics.vision.util.ScreenOrientation;
import org.opencv.core.Size;

/**
 * Basic Vision Sample
 * <p/>
 * Use this in a typical op mode. A VisionOpMode allows using
 * Vision Extensions, which do a lot of processing for you. Just enable the extension
 * and set its options to your preference!
 * <p/>
 * The VisionOpMode is the base of all vision processing and other styles of OpMode
 * even extend the VisionOpMode class! Be sure to extend it if writing your own OpMode structure.
 */
@TeleOp(name="OpenCV: OpenCV Test", group="OpenCV")
public class openCVTest extends VisionOpMode {
    @Override
    public void init() {
        super.init();
        telemetry.addData("super.init()", 0);
        updateTelemetry(telemetry);
        /**
         * Set the camera used for detection
         * PRIMARY = Front-facing, larger camera
         * SECONDARY = Screen-facing, "selfie" camera :D
         **/
        this.setCamera(Cameras.PRIMARY);
        telemetry.addData("setCamera", 0);
        updateTelemetry(telemetry);

        /**
         * Set the frame size
         * Larger = sometimes more accurate, but also much slower
         * After this method runs, it will set the "width" and "height" of the frame
         **/
        this.setFrameSize(new Size(900, 900));
        telemetry.addData("frameSize", 0);
        updateTelemetry(telemetry);
        /**
         * Enable extensions. Use what you need.
         * If you turn on the BEACON extension, it's best to turn on ROTATION too.
         */
        enableExtension(Extensions.BEACON);         //Beacon detection
        telemetry.addData("extensionsBeacon", 0);
        updateTelemetry(telemetry);
        enableExtension(Extensions.ROTATION);       //Automatic screen rotation correction
        telemetry.addData("extensionsRotation", 0);
        updateTelemetry(telemetry);
        enableExtension(Extensions.CAMERA_CONTROL); //Manual camera control
        telemetry.addData("Camera_Control", 0);
        updateTelemetry(telemetry);

        /**
         * Set the beacon analysis method
         * Try them all and see what works!
         */
        beacon.setAnalysisMethod(Beacon.AnalysisMethod.FAST);
        telemetry.addData("analysisMethod", 0);
        updateTelemetry(telemetry);
        /**
         * Set color tolerances
         * 0 is default, -1 is minimum and 1 is maximum tolerance
         */
        beacon.setColorToleranceRed(0);
        telemetry.addData("colorToleranceRed", 0);
        updateTelemetry(telemetry);
        beacon.setColorToleranceBlue(0);
        telemetry.addData("colorToleranceRed", 0);
        updateTelemetry(telemetry);

        /**
         * Set analysis boundary
         * You should comment this to use the entire screen and uncomment only if
         * you want faster analysis at the cost of not using the entire frame.
         * This is also particularly useful if you know approximately where the beacon is
         * as this will eliminate parts of the frame which may cause problems
         * This will not work on some methods, such as COMPLEX
         **/
        //beacon.setAnalysisBounds(new Rectangle(new Point(width / 2, height / 2), width - 200, 200));

        /**
         * Set the rotation parameters of the screen
         * If colors are being flipped or output appears consistently incorrect, try changing these.
         *
         * First, tell the extension whether you are using a secondary camera
         * (or in some devices, a front-facing camera that reverses some colors).
         *
         * It's a good idea to disable global auto rotate in Android settings. You can do this
         * by calling disableAutoRotate() or enableAutoRotate().
         *
         * It's also a good idea to force the phone into a specific orientation (or auto rotate) by
         * calling either setActivityOrientationAutoRotate() or setActivityOrientationFixed(). If
         * you don't, the camera reader may have problems reading the current orientation.
         */
        rotation.setIsUsingSecondaryCamera(false);
        telemetry.addData("secondaryCamera?", 0);
        updateTelemetry(telemetry);
        rotation.disableAutoRotate();
        telemetry.addData("AutoRotateDisable", 0);
        updateTelemetry(telemetry);
        rotation.setActivityOrientationFixed(ScreenOrientation.PORTRAIT);
        telemetry.addData("Portrait", 0);
        updateTelemetry(telemetry);


        /**
         * Set camera control extension preferences
         *
         * Enabling manual settings will improve analysis rate and may lead to better results under
         * tested conditions. If the environment changes, expect to change these values.
         */
        cameraControl.setColorTemperature(CameraControlExtension.ColorTemperature.AUTO);
        telemetry.addData("ColorTemp", 0);
        updateTelemetry(telemetry);
        cameraControl.setAutoExposureCompensation();
        telemetry.addData("AutoExposureCompensation", 0);
        updateTelemetry(telemetry);
    }

    @Override
    public void loop() {
        super.loop();
        telemetry.addData("LOOP", 0);
        updateTelemetry(telemetry);
        telemetry.addData("Beacon Color", beacon.getAnalysis().getColorString());
        telemetry.addData("Beacon Center", beacon.getAnalysis().getLocationString());
        telemetry.addData("Beacon Confidence", beacon.getAnalysis().getConfidenceString());
        telemetry.addData("Beacon Buttons", beacon.getAnalysis().getButtonString());
        telemetry.addData("Screen Rotation", rotation.getScreenOrientationActual());
        telemetry.addData("Frame Rate", fps.getFPSString() + " FPS");
        telemetry.addData("Frame Size", "Width: " + width + " Height: " + height);
        updateTelemetry(telemetry);
    }

    @Override
    public void stop() {
        super.stop();
    }}
