
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.defaults.CatapultDefault;




/** Add your docs here. */
public class Catapult extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final DoubleSolenoid lockPiston = new DoubleSolenoid(3, 4);


  private final DoubleSolenoid catapultPiston = new DoubleSolenoid(1, 6);


  public void lockCatapult() {
    lockPiston.set(Value.kForward);
  }
  public void unlockCatapult() {
    lockPiston.set(Value.kReverse);
  }
  
  public void fireCatapult() {
    catapultPiston.set(Value.kForward);
  }
  public void retractCatapult() {
    catapultPiston.set(Value.kReverse);
  }

  public void init() {
    setDefaultCommand(new CatapultDefault(this));
  }

}
