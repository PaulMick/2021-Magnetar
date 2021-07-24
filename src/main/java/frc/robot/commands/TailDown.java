// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.tools.Tool;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tail;

public class TailDown extends CommandBase {
  /** Creates a new TailDown. */
  private Tail tail;
  private int counter;
  public TailDown(Tail tail) {
    this.tail = tail;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.tail);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    counter = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    SmartDashboard.putNumber("Tail Motor Current", tail.getTailMotorCurrent());
    if (tail.getTailMotorCurrent() < -8 || counter != 0) {
      tail.tailMotorPercent(0);
      counter ++;
      if (counter == 100) {
        counter = 0;
      }
    } else {
      tail.tailMotorPercent(-0.2);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    tail.tailMotorPercent(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
