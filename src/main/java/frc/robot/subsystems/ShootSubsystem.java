// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootSubsystem extends SubsystemBase {
  private TalonSRX talon = new TalonSRX(5);

  public void shoot(double power) {
    talon.set(ControlMode.PercentOutput, power);
  }

  public void stop() {
    shoot(0);
  }
}
