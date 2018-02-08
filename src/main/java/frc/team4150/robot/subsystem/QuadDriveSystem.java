package main.java.frc.team4150.robot.subsystem;

import main.java.frc.team4150.robot.subsystem.motor.MotorSystem;
import main.java.frc.team4150.robot.util.Distance;

public class QuadDriveSystem extends DriveSystem {

	private MotorSystem leftMotor2;
	private MotorSystem rightMotor2;
	
	public QuadDriveSystem(MotorSystem leftMotor, MotorSystem leftMotor2, MotorSystem rightMotor, MotorSystem rightMotor2, EncoderSystem leftEncoder,
			EncoderSystem rightEncoder, Distance wheelRadius) {
		super(leftMotor, rightMotor, leftEncoder, rightEncoder, wheelRadius);
		this.leftMotor2 = leftMotor2;
		this.rightMotor2 = rightMotor2;
	}
	
	public MotorSystem getLeftMotor2() {
		return leftMotor2;
	}
	
	public MotorSystem getRightMotor2() {
		return rightMotor2;
	}
	
	@Override
	public void periodic() {
		super.periodic();
		leftMotor2.periodic();
		rightMotor2.periodic();
	}
	
	@Override
	public void setSpeed(double leftMotorSpeed, double rightMotorSpeed) {
		double left = leftMotorSpeed/2;
		double right = rightMotorSpeed/2;
		super.setSpeed(left, right);
		leftMotor2.setSpeed(left);
		rightMotor2.setSpeed(-right);
	}

}