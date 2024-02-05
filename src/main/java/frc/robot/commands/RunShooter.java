package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterProto;
import frc.robot.subsystems.ShooterProto.ToggleShoot;

public class RunShooter extends Command{
    private final ShooterProto m_subsystem;
    public RunShooter(ShooterProto subsystem){
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }
    @Override
    public void initialize(){
       m_subsystem.changeState(ToggleShoot.SHOOT);
    }
    @Override
    public void execute(){
        // System.out.println("Trying to shoot");
        // m_subsystem.runShooter(0.9);
        // if(m_subsystem.getBreakBeamState()){
        //   m_subsystem.runShooter(0.9);
        // }
        // else if(!m_subsystem.getBreakBeamState()){
        //   //m_subsystem.stopIntake();
        //   //m_subsystem.stopShooter();
        // }
    }   
    @Override
    public void end(boolean interrupted) {
      m_subsystem.changeState(ToggleShoot.IDLE);
      m_subsystem.stopIntake();
      // m_subsystem.stopShooter();
      //m_subsystem.stopMotors();
    }

    @Override
    public boolean isFinished() {
      return false;
    }
}