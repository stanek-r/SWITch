package xyz.switchannel.Main.models;

import xyz.switchannel.Main.enums.WalletMovementType;

import java.time.LocalDateTime;

public class WalletMovement {
    private double value;
    private WalletMovementType type;
    private LocalDateTime time;

    public WalletMovement(double value, WalletMovementType type, LocalDateTime time) {
        this.value = value;
        this.type = type;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public WalletMovementType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }
}
