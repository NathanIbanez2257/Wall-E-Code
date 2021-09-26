// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakeSubsystem;

public class intakeInCommand extends CommandBase {

  intakeSubsystem iintakeSubsystem;
  int ddirectionDecider;

  /** Creates a new intakeInCommand. */
  public intakeInCommand(intakeSubsystem intakeSubsystem, int directionDecider) 
  {
    iintakeSubsystem = intakeSubsystem;
    ddirectionDecider = directionDecider;

     addRequirements(iintakeSubsystem); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    iintakeSubsystem.intakeIn(ddirectionDecider);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    iintakeSubsystem.Stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
