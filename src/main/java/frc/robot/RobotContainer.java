// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroscopeSubsystem;
import frc.robot.subsystems.NavXGyroSubsystem;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.TalonSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.commands.ShootCommand;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  public static final GyroscopeSubsystem m_gyroscopeSubsystem = new GyroscopeSubsystem();
  public static final NavXGyroSubsystem m_navxgyrosubsystem = new NavXGyroSubsystem();
  public static final TalonSubsystem talonSubsystem = new TalonSubsystem();
  public static final ShootSubsystem shootSubsystem = new ShootSubsystem();
  // public static final VisionSubsystem visionSubsystem = new VisionSubsystem();

  public static final Joystick leftJoy = new Joystick(0);
  public static final Joystick rightJoy = new Joystick(0);
  public static final Joystick gamepad = new Joystick(0);

  public static final Command shootCommand = new ShootCommand(shootSubsystem);

  public static SendableChooser<String> controlChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
