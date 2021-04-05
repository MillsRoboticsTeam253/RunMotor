// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int talonSRXDefaultContinuousLimit = 38;
    public static int talonSRXDefaultPeakLimit = 45;
    public static int talonSRXDefaultPeakDuration = 125;
    
    public static final boolean talonFXStatorLimitEnable = false;
    public static final double talonFXStatorCurrentLimit = 100;
    public static final double talonFXStatorTriggerThreshold = 100;
    public static final double talonFXStatorTriggerDuration = 0;
    
    public static final boolean talonFXSupplyLimitEnable = false;
    public static final double talonFXSupplyCurrentLimit = 70;
    public static final double talonFXSupplyTriggerThreshold = 70;
    public static final double talonFXSupplyTriggerDuration = 0.7;
    
    public static int sparkMAXDefaultCurrentLimit = 60;
    
    public static double voltageCompensation = 12.0;
}
