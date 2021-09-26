// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.intakeInCommand;
import frc.robot.subsystems.driveSubsystem;
import frc.robot.subsystems.intakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final driveSubsystem driveSubsystem = new driveSubsystem();

  private final intakeSubsystem intakeSubsystem = new intakeSubsystem();

  private final Joystick loserNathan = new Joystick(0);

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // Configure the button bindings
    configureButtonBindings();
     driveSubsystem.setDefaultCommand(new RunCommand(
       ()-> driveSubsystem.tankDrive(Constants.driveSpeed*loserNathan.getRawAxis(Constants.leftJoystick), Constants.driveSpeed*loserNathan.getRawAxis(Constants.rightJoystick)), driveSubsystem));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    JoystickButton intakeIn = new JoystickButton(loserNathan, Constants.intakeInButton);
    JoystickButton intakeOut = new JoystickButton(loserNathan, Constants.intakeOutButton);

    intakeIn.whileHeld(new intakeInCommand(intakeSubsystem, 1));
    intakeOut.whileHeld(new intakeInCommand(intakeSubsystem, -1));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
