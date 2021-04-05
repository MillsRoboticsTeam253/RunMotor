// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Subsystem;

import static frc.robot.Constants.*;

public class OneMotor implements Subsystem {
    private static OneMotor instance;
    
    private TalonSRX spinMotor;
    private CANSparkMax conveyorMotor;
    private XboxController controller;
    
    public OneMotor(XboxController controller) {
        this.controller = controller;
        
        // pick the motor you want idk
        // the ports here are set to 0 but you can change them
        /*
        spinMotor = createTalonSRX(0);
        conveyorMotor = createSparkMAX(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        
         */

        register();
    }
    
    public static double deadbandX(double input, double deadband) {
        if (Math.abs(input) <= deadband) {
            return 0;
        } else if (Math.abs(input) == 1) {
            return input;
        } else {
            return (1 / (1 - deadband) * (input + Math.signum(-input) * deadband));
        }
    }
    
    @Override
    public void periodic() {
        setOpenLoop(deadbandX(controller.getY(GenericHID.Hand.kRight), 0.07));
    }
    
    /**
     * Try to set the motors to a speed if they exist.
     */
    public void setOpenLoop(double speed) {
        if (spinMotor != null) spinMotor.set(ControlMode.PercentOutput, speed);
        if (conveyorMotor != null) conveyorMotor.set(speed);
    }
    
    public static TalonSRX createTalonSRX(int id) {
        TalonSRXConfiguration config = new TalonSRXConfiguration();
        config.continuousCurrentLimit = talonSRXDefaultContinuousLimit;
        config.peakCurrentLimit = talonSRXDefaultPeakLimit;
        config.peakCurrentDuration = talonSRXDefaultPeakDuration;
        config.voltageCompSaturation = voltageCompensation;
        
        TalonSRX talon = new TalonSRX(id);
        talon.configFactoryDefault();
        talon.configAllSettings(config);
        talon.enableCurrentLimit(true);
        talon.enableVoltageCompensation(true);
        talon.setNeutralMode(NeutralMode.Brake);
        
        return talon;
    }
    
    public static CANSparkMax createSparkMAX(int id, CANSparkMaxLowLevel.MotorType motortype) {
        CANSparkMax sparkMAX = new CANSparkMax(id, motortype);
        sparkMAX.restoreFactoryDefaults();
        sparkMAX.enableVoltageCompensation(voltageCompensation);
        sparkMAX.setSmartCurrentLimit(sparkMAXDefaultCurrentLimit);
        sparkMAX.setIdleMode(CANSparkMax.IdleMode.kBrake);
        
        sparkMAX.burnFlash();
        return sparkMAX;
    }
}
