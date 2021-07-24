// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Intake;





public class ShootBall extends SequentialCommandGroup {
  /** Creates a new ShootBall. */
  private Catapult catapult;
  public ShootBall(Catapult catapult, Intake intake) {
    this.catapult = catapult;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.catapult);
    addCommands(
      new IntakeDown(intake),

      new WaitCommand(0.75),

      new FireCatapult(catapult),
      
      new UnlockCatapult(catapult),

      new WaitCommand(0.5),

      new RetractCatapult(catapult),

      new WaitCommand(0.6),

      new LockCatapult(catapult)
    );
  }

  

}
