// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.File;

import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class OrchestraCommand extends CommandBase {
  private Orchestra orchestra;

  public OrchestraCommand(String name) {
    orchestra = new Orchestra();
    String path = new File(Filesystem.getDeployDirectory(), name).toString();
    orchestra.loadMusic(path);
    orchestra.addInstrument(RobotContainer.talonSubsystem.talon);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    orchestra.play();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    orchestra.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
