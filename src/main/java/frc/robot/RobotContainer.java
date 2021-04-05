// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.OneMotor;

public class RobotContainer {
    private static RobotContainer instance;
    private static OneMotor subsystem;
    
    private static final XboxController controller = new XboxController(0);
    
    private RobotContainer() {
        subsystem = new OneMotor(controller);
    }
    
    public static RobotContainer getInstance() {
        if (instance == null) instance = new RobotContainer();
        return instance;
    }
    
    public Command getAutonomousCommand() {
        return null;
    }
}
