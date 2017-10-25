package org.usfirst.frc.team6685.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
public class Robot extends IterativeRobot {

SpeedController motor1 = new Talon(0);
SpeedController motor2 = new Talon(1); 
SpeedController motor3 = new Talon(2); 
SpeedController motor4 = new Talon(3);
SpeedController intake = new Talon(4); 
SpeedController spin = new Talon (5);
SpeedController launcher = new Talon(6);
Joystick Stick = new Joystick (0);;
RobotDrive m_drive = new RobotDrive(motor4,motor1,motor3,motor2);

	public void robotInit() {

	}


	
	public void teleopPeriodic() {
		m_drive.mecanumDrive_Cartesian(Stick.getRawAxis(0), -Stick.getRawAxis(1), Stick.getRawAxis(4),0);
		
		
		if(Stick.getRawButton(8))
		{
			motor1.set(0);
			motor2.set(0);
			motor3.set(0);
			motor4.set(0);
			intake.set(0);
			spin.set(0);
			launcher.set(0);
		}
		
		if(Stick.getRawButton(1))
		{
			motor1.set(-1);
			motor2.set(-1);
			motor3.set(-1);
			motor4.set(-1);
		}
		
		
		
		 if(Stick.getRawButton(4))
	    	{
	    		Timer.delay(0.05);
	    		launcher.set(-1);
	    	    Timer.delay(0.2);
	    	    launcher.set(0);
	    	    Timer.delay(0.3);
	    	    launcher.set(0.2);
	    	    Timer.delay(1);
	    	    launcher.set(0);
	    	    Timer.delay(0.02);
	    	}
	    	    
	    	    else
	    	    {
	    	    	launcher.set(0);
	    	    	Timer.delay(0.02);
	    	    }
		 

 	 	if (Stick.getRawButton(2)) {
 	 		spin.set(1);
 	 		Timer.delay(0.02);
 	 	} else if(Stick.getRawButton(5)) {
 	 		intake.set(-0.5);
 	 	    Timer.delay(0.02);
 	 	} else if (Stick.getRawButton(6)) {
 	 		intake.set(0.5);
 	 		Timer.delay(0.02);
 	 	    }
 	 	    else
 	 	    {
 	 	    	spin.set(0);
 	 	        intake.set(0);
 	 	        Timer.delay(0.02);
 	 	    }
		
		
		
	}

	
}

