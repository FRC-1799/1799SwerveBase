package frc.robot.ballDrive;

import edu.wpi.first.math.geometry.Rotation2d;

//simple datatype for drive vectors to be used by balldrive
public class vector {
    private double speed;
    private Rotation2d angle;
    
    public vector(double speed, Rotation2d angle){
        this.speed=clamp(speed);
        this.angle=angle;
    }
    public vector(double Xchange, double Ychange){
        this.speed=Math.sqrt(square(clamp(Xchange))+square(clamp(Ychange)));
        this.angle = new Rotation2d(Ychange,Xchange);

    }
    private double square(double n){
        return n*n;
    }

    private double clamp(double value){
        return Math.max(-1, Math.min(value, 1));
    }

    public Rotation2d getRotation(){
        return angle;
    }
    public double getSpeed(){
        return speed;
    }
    public double getX(){
        return clamp(angle.getCos()*speed);
    }
    public double getY(){
        return clamp(angle.getSin()*speed);
    }
    
}
