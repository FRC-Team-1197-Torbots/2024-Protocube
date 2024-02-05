package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterProto;
import frc.robot.subsystems.ShooterProto.ToggleShoot;
import edu.wpi.first.wpilibj.Timer;
public class PushNote extends Command{
    private final ShooterProto m_subsystem;
    private Timer m_timer;
    private double shootTime;
    private double endTime;
    public PushNote(ShooterProto subsystem){
        m_subsystem = subsystem;
        m_timer = new Timer();
        addRequirements(m_subsystem);
    }
    @Override
    public void initialize(){
        m_subsystem.runIntake(0.9);
    }
    @Override
    public void execute(){

    }   
    @Override
    public void end(boolean interrupted) {
      shootTime = m_timer.getFPGATimestamp();
      endTime = shootTime + 1.5;
      //if(m_timer.getFPGATimestamp() > endTime){
        m_subsystem.stopIntake();
        m_subsystem.changeState(ToggleShoot.IDLE);
      //}
    }

    @Override
    public boolean isFinished() {
      return !m_subsystem.getBreakBeamState();
    }
}
