package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SparkConstants;

public class ShooterProto extends SubsystemBase{
    private CANSparkMax Motor1;
    private CANSparkMax Motor2;
    private CANSparkMax Motor3;
    private enum ToggleShoot{
        FIRE, STOP
    }
    private ToggleShoot m_ToggleShoot = ToggleShoot.STOP;
    public ShooterProto(){
        Motor1 = new CANSparkMax(SparkConstants.MotorA, MotorType.kBrushless);
        Motor2 = new CANSparkMax(SparkConstants.MotorB, MotorType.kBrushless);
        Motor3 = new CANSparkMax(SparkConstants.MotorC, MotorType.kBrushless);
    }
    public void runMotors(double spd){
        Motor1.set(spd);
        Motor2.set(-spd);
        Motor3.set(-spd);
    }
    public void stopMotors(){
        Motor1.set(0);
        Motor2.set(0);
        Motor3.set(0);
    }
    public void changeState(){
        if(m_ToggleShoot == ToggleShoot.STOP){
            m_ToggleShoot = ToggleShoot.FIRE;
        }
        else{
            m_ToggleShoot = ToggleShoot.STOP;
        }
        switch(m_ToggleShoot){
            case FIRE:
                runMotors(0.9);
                break;
            case STOP:
                stopMotors();
                break;
        }

        
    }

    @Override
    public void periodic(){
        
        SmartDashboard.putNumber("Motor1 Speed", Motor1.get());
        SmartDashboard.putNumber("Motor2 Speed", Motor2.get());
    }
}
