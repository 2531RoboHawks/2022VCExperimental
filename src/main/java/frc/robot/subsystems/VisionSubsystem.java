package frc.robot.subsystems;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
    public VisionSubsystem() {
        new Thread(() -> {
            run();
        }, "Vision Thread").start();
    }

    private void run() {
        int width = 120;
        int height = 120;

        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
        camera.setResolution(width, height);
        camera.setFPS(30);

        CvSink cvSink = CameraServer.getInstance().getVideo(camera);
        CvSource outputStream = CameraServer.getInstance().putVideo("Test 123", width, height);

        Mat source = new Mat();
        while (!Thread.interrupted()) {
            if (cvSink.grabFrame(source) == 0) {
                continue;
            }
            Mat output = source.clone();
            // for (int row = 0; row < output.rows(); row++) {
            //     for (int col = 0; col < output.cols(); col++) {
            //         double[] pixels = source.get(row, col);
            //         double blue = pixels[0];
            //         double green = pixels[1];
            //         double red = pixels[2];
            //         if (blue > 150 && (blue - red) > 20 && (blue - green) > 20) {
            //             output.put(row, col, pixels);
            //         } else {
            //             output.put(row, col, 0, 0, 0);
            //         }
            //     }
            // }
            outputStream.putFrame(output);
        }
    }
}
