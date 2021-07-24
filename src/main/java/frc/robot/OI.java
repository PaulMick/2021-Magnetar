package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Tools.TriggerButton;

public class OI {
    public static XboxController driverController = new XboxController(0);

    public static double getDriverLeftY() {
        return driverController.getY(Hand.kLeft);
    }
    public static double getDriverRightY() {
        return driverController.getY(Hand.kRight);
    }
    public static double getDriverLeftX() {
        return driverController.getX(Hand.kLeft);
    }
    public static double getDriverRightX() {
        return driverController.getX(Hand.kRight);
    }
    public static JoystickButton leftBumper = new JoystickButton(driverController, 5);
    public static JoystickButton rightBumper = new JoystickButton(driverController, 6);
    public static TriggerButton rightTrigger = new TriggerButton(driverController, 3);
    public static TriggerButton leftTrigger = new TriggerButton(driverController, 2);
    public static JoystickButton aButton = new JoystickButton(driverController, 1);
    public static JoystickButton yButton = new JoystickButton(driverController, 4);
    public static JoystickButton xButton = new JoystickButton(driverController, 3);
    public static JoystickButton bButton = new JoystickButton(driverController, 2);
    public static JoystickButton windowButton = new JoystickButton(driverController, 7);
}