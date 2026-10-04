package org.firstinspires.ftc.team2844.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.vcs.valleylib.ftc.hardware.FtcSubsystem;

import org.firstinspires.ftc.team2844.helpers.Constants;

public class TransferSubsystem extends FtcSubsystem {
    private DcMotor transfer;
    public TransferSubsystem(HardwareMap hardwareMap){
        super(hardwareMap);
        transfer = hardwareMap.get(DcMotor.class, Constants.EHM1);
        transfer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void activate(){
        transfer.setPower(Constants.TRANSFER_SPEED);
    }

    public void stop(){
        transfer.setPower(0.0);
    }
}