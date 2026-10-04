package org.firstinspires.ftc.team2844.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.vcs.valleylib.ftc.hardware.FtcSubsystem;
import com.vcs.valleylib.ftc.hardware.Motor;
import com.vcs.valleylib.ftc.hardware.MotorEx;

import org.firstinspires.ftc.team2844.helpers.Constants;

public class ShooterSubsystem extends FtcSubsystem {
    private DcMotorEx shooter;
    public double kP, kI, kD, kF;
    public final String motorName;

    public ShooterSubsystem(HardwareMap hardwareMap, Constants.ShooterConfig config){
        super(hardwareMap);
        this.motorName = config.motorName;
        this.kP = config.kP;
        this.kI = config.kI;
        this.kD = config.kD;
        this.kF = config.kF;

        shooter = hardwareMap.get(DcMotorEx.class, motorName);
        shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooter.setPIDFCoefficients(
                DcMotor.RunMode.RUN_USING_ENCODER,
                new PIDFCoefficients(
                        kP,
                        kI,
                        kD,
                        kF
                )
        );
    }


    public void setVelocity(double vel){
        shooter.setVelocity(vel);
    }

    public void stop(){
        setVelocity(0.0);
    }

    public void setPIDF(double p, double i, double d, double f){
        shooter.setPIDFCoefficients(
                DcMotor.RunMode.RUN_USING_ENCODER,
                new PIDFCoefficients(
                        p,
                        i,
                        d,
                        f
                )
        );
    }
}
