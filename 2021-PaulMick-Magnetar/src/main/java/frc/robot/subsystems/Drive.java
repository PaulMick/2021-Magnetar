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

public class Drive extends SubsystemBase {
  
  public Drive() {}

    private final TalonSRX frontLeftDrive = new TalonSRX(1);
    private final TalonSRX frontRightDrive = new TalonSRX(3);
    private final TalonSRX backLeftDrive = new TalonSRX(2);
    private final TalonSRX backRightDrive = new TalonSRX(4);
    
    private final DoubleSolenoid shifters = new DoubleSolenoid(0, 0, 7);

    public void init(){
        backLeftDrive.set(ControlMode.Follower, 1);
        backRightDrive.set(ControlMode.Follower, 3);

        setDefaultCommand(new DriveDefault(this));
    }
    public void setLeftPercent(double percent) {
        frontLeftDrive.set(ControlMode.PercentOutput, percent);
    }
    public void setRightPercent(double percent) {
        frontRightDrive.set(ControlMode.PercentOutput, percent);
    }
    public void tankDrive(double left, double right) {
        setLeftPercent(left);
        setRightPercent(-right);
    }
    public void arcadeDrive(double left, double right) {
        
        if ((left - right) > 1) {
            scaleDownDrive(left, right);
        } else if ((-left - right) > 1) {
            scaleDownDrive(left, right);
        } else if ((left - right) < -1) {
            scaleDownDrive(left, right);
        } else if ((-left - right) < -1) {
            scaleDownDrive(left, right);
        }
        setLeftPercent(left - right);
        setRightPercent(-left - right);
        
        
    }
    public void setHighGear() {
        shifters.set(Value.kForward);
    }
    public void setLowGear() {
        shifters.set(Value.kReverse);
    }
    public void scaleDownDrive(double left, double right) {
        if (left > right) {
            left = 1;
            right /= left;
        } else if (right > left) {
            right = 1;
            left /= right;
        } else {
            right = 1;
            left = 1;
        }
    }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
