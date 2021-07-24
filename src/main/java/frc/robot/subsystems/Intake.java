// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.defaults.DriveDefault;
import frc.robot.commands.defaults.IntakeDefault;

public class Intake extends SubsystemBase {
  
  public Intake() {}

    private final TalonSRX intakeMotor = new TalonSRX(5);

    private final DoubleSolenoid intakePiston = new DoubleSolenoid(2, 5);

    public void init() {
       

      setDefaultCommand(new IntakeDefault(this));
    }
    public void intakeDown() {
        intakePiston.set(Value.kReverse);
    }
    public void intakeUp() {
        intakePiston.set(Value.kForward);
    }
    public void intakeMotorPercent(double percent) {
      intakeMotor.set(ControlMode.PercentOutput, percent);
    }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
