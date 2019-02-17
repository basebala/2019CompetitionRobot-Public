package org.frcteam2910.c2019.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frcteam2910.common.math.Vector2;

public class ClimbCommand extends CommandGroup {
    private static final double DRIVE_SPEED = 0.15;
    private static final double INTAKE_SPEED = -0.3;

    public ClimbCommand() {
        addParallel(new SetClimberExtendedCommand(true));
        addParallel(new DriveCommand(new Vector2(DRIVE_SPEED, 0.0), 0.0, false));
        addParallel(new SetBottomCargoRollerSpeedCommand(INTAKE_SPEED));
        addSequential(new CorrectPitchCommand());
    }
}