package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;

public class SwerveConstants {
    public static class frontRight{
        public static final double Xoffset=0;
        public static final double Yoffset=0;
        public static final int driveID=0;
        public static final int turnID=0;
        public static final boolean driveInverted=false;
        public static final boolean steerInverted=false;
        public static final SwerveModuleConstants frontRightConstants = new SwerveModuleConstants().withLocationX(Xoffset).withLocationY(Yoffset)
        .withDriveMotorId(driveID).withSteerMotorId(turnID).withDriveMotorInverted(driveInverted).withSteerMotorInverted(steerInverted);

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
        public static final double turnGearRatio=0;
        public static final double maxSpeed=0;
    }

    public static class driveTrainStuff{
        public static final int pidgonID=0;
        public static final SwerveDrivetrainConstants swerveDriveTrainConstants= new  SwerveDrivetrainConstants().withPigeon2Id(pidgonID);
    }
}
