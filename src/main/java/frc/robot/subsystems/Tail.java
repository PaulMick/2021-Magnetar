// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/** Add your docs here. */
public class Tail extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final TalonSRX tailMotor = new TalonSRX(6);

  public void tailMotorPercent(double percent) {
    tailMotor.set(ControlMode.PercentOutput, percent);
  }

  public double getTailMotorCurrent() {
    return tailMotor.getStatorCurrent();
  }
  
  
  
}
