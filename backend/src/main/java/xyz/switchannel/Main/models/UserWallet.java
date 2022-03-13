package xyz.switchannel.Main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document("user-wallets")
public class UserWallet {
    @Id
    private String _id;
    @Indexed
    private String userId;

    private WalletMovement[] movements;

    public UserWallet(String userId, WalletMovement[] movements) {
        this.userId = userId;
        this.movements = movements;
    }

    public String getUserId() {
        return userId;
    }

    public WalletMovement[] getMovements() {
        return movements;
    }

    public double getCurrentValue() {
        double realValue = 0.0;
        for (WalletMovement movement : movements) {
            realValue += movement.getValue();
        }
        return realValue;
    }

    public void setMovements(WalletMovement[] movements) {
        this.movements = movements;
    }
}
