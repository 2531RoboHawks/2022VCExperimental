// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends CommandBase {
  private final DriveSubsystem m_subsystem;

  public PIDController gyroLoop = new PIDController(0.05, 0.01, 0);

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(DriveSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gyroLoop.reset();
    gyroLoop.setSetpoint(90);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double correction = gyroLoop.calculate(RobotContainer.m_navxgyrosubsystem.getYaw());
    RobotContainer.m_driveSubsystem.arcadeDrive(0, -correction);
    SmartDashboard.putNumber("Correction", correction);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
