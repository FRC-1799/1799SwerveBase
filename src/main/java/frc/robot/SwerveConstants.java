package frc.robot;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.ClosedLoopOutputType;

import frc.robot.CTRSwerve.SwerveDriveConstantsCreator;


public class SwerveConstants {
    public static class frontRight{
        public static final double Xoffset=0;
        public static final double Yoffset=0;
        public static final int driveID=0;
        public static final int turnID=0;
        public static final boolean driveInverted=false;
        public static final boolean steerInverted=false;


    }
    public static class frontLeft{
        public static final double Xoffset=0;
        public static final double Yoffset=0;
        public static final double driveID=0;
        public static final double turnID=0;
        public static final boolean driveInverted=false;
        public static final boolean steerInverted=false;
    }
    public static class backRight{
        public static final double Xoffset=0;
        public static final double Yoffset=0;
        public static final double driveID=0;
        public static final double turnID=0;
        public static final boolean driveInverted=false;
        public static final boolean steerInverted=false;
    }
    public static class backLeft{
        public static final double Xoffset=0;
        public static final double Yoffset=0;
        public static final double driveID=0;
        public static final double turnID=0;
        public static final boolean driveInverted=false;
        public static final boolean steerInverted=false;
    }
    public static class shared{
        public static final double wheelRadius=0;
        public static final double driveGearRatio=0;
        public static final double steerGearRatio=0;
        public static final double maxSpeed=0;
        public static final double driveVoltage=0;
        public static final double driveInerta=0;
        public static final double slipCurrent=0;
        public static final Slot0Configs steerGains= new Slot0Configs();
        public static final Slot0Configs driveGains = new Slot0Configs();
        public static final boolean steerInverted=true;
        public static final ClosedLoopOutputType driveMotorClosedLoop = null;
        public static final ClosedLoopOutputType steerMotorClosedLoop = null;

        


        SwerveModuleConstantsFactory m_constantsCreator =
        new SwerveModuleConstantsFactory().withCouplingGearRatio(driveGearRatio).withDriveFrictionVoltage(driveVoltage).withDriveInertia(driveInerta)
        .withDriveMotorClosedLoopOutput(driveMotorClosedLoop).withDriveMotorGains(driveGains).withDriveMotorGearRatio(driveGearRatio).withFeedbackSource(null).withSlipCurrent(slipCurrent)
        .withSpeedAt12VoltsMps(maxSpeed).withSteerMotorClosedLoopOutput(steerMotorClosedLoop).withSteerMotorGearRatio(steerGearRatio).withSteerMotorInverted(steerInverted).withWheelRadius(wheelRadius)
    }

    public static class driveTrainStuff{
        public static final int pidgonID=0;
        public static final SwerveDrivetrainConstants swerveDriveTrainConstants= new  SwerveDrivetrainConstants().withPigeon2Id(pidgonID);
    }
}
