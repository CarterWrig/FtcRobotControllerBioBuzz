package org.firstinspires.ftc.team2844.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.vcs.valleylib.ftc.hardware.FtcSubsystem;

import org.firstinspires.ftc.team2844.helpers.Constants;

public class IntakeSubsystem extends FtcSubsystem {
    private DcMotor intakeMotor;
    public IntakeSubsystem(HardwareMap hardwareMap) {
        super(hardwareMap);

        intakeMotor = hardwareMap.get(DcMotor.class, Constants.EHM0);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void active(){
        intakeMotor.setPower(Constants.INTAKE_SPEED);
    }

    public void stop(){
        intakeMotor.setPower(0.0);
    }
}
