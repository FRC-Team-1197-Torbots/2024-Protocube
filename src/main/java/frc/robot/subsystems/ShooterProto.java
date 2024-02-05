package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DigitalInputConstants;
import frc.robot.Constants.SparkConstants;
import frc.robot.commands.PushNote;

public class ShooterProto extends SubsystemBase{
    private CANSparkMax Motor1;
    private CANSparkMax Motor2;
    private CANSparkMax Motor3;
    private DigitalInput BreakBeam;
    public enum ToggleShoot{
        INTAKE, SHOOT, IDLE
    }
    private ToggleShoot m_ToggleShoot = ToggleShoot.IDLE;
    public ShooterProto(){
        Motor1 = new CANSparkMax(SparkConstants.MotorA, MotorType.kBrushless);
        Motor2 = new CANSparkMax(SparkConstants.MotorB, MotorType.kBrushless);
        Motor3 = new CANSparkMax(SparkConstants.MotorC, MotorType.kBrushless);
        BreakBeam = new DigitalInput(DigitalInputConstants.BreakBeam);
        
    }
    public void runShooter(double spd){
        Motor1.set(spd);
        Motor2.set(-spd);
        System.out.println();
        //Motor3.set(-spd);
    }
    public void runIntake(double spd){
        Motor3.set(-spd);
    }
    public void stopIntake(){
        Motor3.set(0);
    }

    public void stopShooter(){
        Motor1.set(0);
        Motor2.set(0);
    }

    public void changeState(ToggleShoot state){
        m_ToggleShoot = state;
    }

    public void runState(){
        switch(m_ToggleShoot){
            case INTAKE:
                runIntake(0.23);
                break;
            case SHOOT:
                runShooter(0.23); //.9
                // runIntake(0.03); // prevent note from sliding out
                break;
            case IDLE:
                runShooter(0.23); //.4
                break;
        }
    }

    public ToggleShoot getShooterState(){
        return m_ToggleShoot;
    }

    public boolean getBreakBeamState(){
        return !BreakBeam.get();
    }

    @Override
    public void periodic(){
        // System.out.println(!BreakBeam.get());

        runState();
        SmartDashboard.putBoolean("BreakBeam", getBreakBeamState());
        SmartDashboard.putNumber("Motor1 Speed", Motor1.getEncoder().getVelocity()); //Positive Speed
        SmartDashboard.putNumber("Motor2 Speed", Math.abs(Motor2.getEncoder().getVelocity())); //Negative Speed
    }
}
