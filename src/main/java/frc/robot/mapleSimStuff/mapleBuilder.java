package frc.robot.mapleSimStuff;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.PowerDistribution;
import frc.robot.Constants;
import frc.robot.Constants.driveConstants;
import swervelib.SwerveDrive;
import swervelib.parser.json.ControllerPropertiesJson;
import swervelib.parser.json.ModuleJson;
import swervelib.parser.json.PIDFPropertiesJson;
import swervelib.parser.json.PhysicalPropertiesJson;
import swervelib.parser.json.SwerveDriveJson;
import swervelib.simulation.SwerveModuleSimulation;
import frc.robot.utils.MapleJoystickDriveInput;
import frc.robot.utils.MapleShooterOptimization;
import org.ironmaple.simulation.SimulatedArena;
import org.ironmaple.simulation.drivesims.GyroSimulation;
import org.ironmaple.simulation.drivesims.SwerveModuleSimulation;

import org.ironmaple.simulation.drivesims.SwerveDriveSimulation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;

import org.ironmaple.simulation.SimulatedArena;

public class mapleBuilder {
    private static final HashMap<String, Integer> moduleConfigs = new HashMap();
    public static SwerveDriveJson swerveDriveJson;
    public static ControllerPropertiesJson controllerPropertiesJson;
    public static PIDFPropertiesJson pidfPropertiesJson;
    public static PhysicalPropertiesJson physicalPropertiesJson;
    public static ModuleJson[] moduleJsons;

   
    public final SwerveDriveSimulation getMapleSimDrive(File directory){
        this.checkDirectory(directory);
        swerveDriveJson = (SwerveDriveJson)(new ObjectMapper()).readValue(new File(directory, "swervedrive.json"), SwerveDriveJson.class);
        controllerPropertiesJson = (ControllerPropertiesJson)(new ObjectMapper()).readValue(new File(directory, "controllerproperties.json"), ControllerPropertiesJson.class);
        pidfPropertiesJson = (PIDFPropertiesJson)(new ObjectMapper()).readValue(new File(directory, "modules/pidfproperties.json"), PIDFPropertiesJson.class);
        physicalPropertiesJson = (PhysicalPropertiesJson)(new ObjectMapper()).readValue(new File(directory, "modules/physicalproperties.json"), PhysicalPropertiesJson.class);
        moduleJsons = new ModuleJson[swerveDriveJson.modules.length];
  
        for(int i = 0; i < moduleJsons.length; ++i) {
           moduleConfigs.put(swerveDriveJson.modules[i], i);
           String var10003 = swerveDriveJson.modules[i];
           File moduleFile = new File(directory, "modules/" + var10003);
  
           assert moduleFile.exists();
  
           moduleJsons[i] = (ModuleJson)(new ObjectMapper()).readValue(moduleFile, ModuleJson.class);
        }



        final GyroSimulation gyroSimulation = GyroSimulation.createPigeon2();
        this.driveSimulation = new SwerveDriveSimulation(
            Constants.riveConstants.robotMass,
            Constants.driveConstants.chassisHeight,
            Constants.driveConstants.chassisWidth,
            Constants.driveConstants.totalHeight,
            Constants.driveConstants.totalWidth,
            () -> new SwerveModuleSimulation(
                DCMotor.getKrakenX60(1),
                DCMotor.getKrakenX60(1),
                12,
                PhysicalPropertiesJson.conversionFactors.drive,
                PhysicalPropertiesJson.conversionFactors.angle,
                Constants.driveTrainConstants.driveFrictionVoltage,
                Constants.driveTrainConstants.steerFrictionVoltage,
                PhysicalPropertiesJson.wheelGripCoefficientOfFriction,
                Constants.driveTrainConstants.wheelRadusInMeters,
                constants.driveTrainConstants.steerInertia
            ),
            gyroSimulation,
            new Pose2d(3, 3, new Rotation2d())
        );
        SimulatedArena.getInstance().addDriveTrainSimulation(driveSimulation);

        powerDistribution = new PowerDistribution();
        // Sim robot, instantiate physics sim IO implementations
        final ModuleIOSim
            frontLeft = new ModuleIOSim(driveSimulation.getModules()[0]),
            frontRight = new ModuleIOSim(driveSimulation.getModules()[1]),
            backLeft = new ModuleIOSim(driveSimulation.getModules()[2]),
            backRight = new ModuleIOSim(driveSimulation.getModules()[3]);
        final GyroIOSim gyroIOSim = new GyroIOSim(gyroSimulation);
        drive = new SwerveDrive(
            Constants.driveConstants.driveType.GENERIC,
            gyroIOSim,
            frontLeft, frontRight, backLeft, backRight
        );

        // aprilTagVision = new AprilTagVision(
        //     new ApriltagVisionIOSim(
        //             camerasProperties,
        //             VisionConstants.fieldLayout,
        //             driveSimulation::getSimulatedDriveTrainPose
        //     ),
        //     camerasProperties,
        //     drive
        // );

        SimulatedArena.getInstance().resetFieldForAuto();
    }
     

    private void checkDirectory(File directory) {
        assert (new File(directory, "swervedrive.json")).exists();
        
        assert (new File(directory, "controllerproperties.json")).exists();
  
        assert (new File(directory, "modules")).exists() && (new File(directory, "modules")).isDirectory();
  
        assert (new File(directory, "modules/pidfproperties.json")).exists();
  
        assert (new File(directory, "modules/physicalproperties.json")).exists();
  
    }
}
