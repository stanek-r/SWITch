package xyz.switchannel.Main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.switchannel.Main.exceptions.NotFoundException;
import xyz.switchannel.Main.models.User;
import xyz.switchannel.Main.models.UserWallet;
import xyz.switchannel.Main.models.WalletMovement;
import xyz.switchannel.Main.repositories.UserWalletsRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class WalletService {
    public final HashMap<String, Double> CURRENT_VALUES = new HashMap<>();

    @Autowired
    UserWalletsRepository userWalletsRepository;

    public UserWallet getUserWallet(String userId) {
        UserWallet userWallet = userWalletsRepository.getUserWalletByUserId(userId);
        if (userWallet == null) {
            throw new NotFoundException("User not found!");
        }
        return userWallet;
    }

    private UserWallet addWalletMovement(UserWallet userWallet, WalletMovement walletMovement) {
        List<WalletMovement> walletMovements = Arrays.asList(userWallet.getMovements().clone());
        walletMovements.add(walletMovement);
        userWallet.setMovements(walletMovements.toArray(WalletMovement[]::new));
        userWalletsRepository.save(userWallet);
        return userWallet;
    }

    public double getUsersBalance(String userId) {
        Double currentValue = CURRENT_VALUES.get(userId);
        if (currentValue != null) {
            return currentValue;
        }
        UserWallet userWallet = this.getUserWallet(userId);
        double currentWallet = userWallet.getCurrentValue();
        this.CURRENT_VALUES.put(userId, currentWallet);
        return currentWallet;
    }

    public void createNewWallet(User user) {
        userWalletsRepository.insert(new UserWallet(user.getId(), new WalletMovement[0]));
    }
}
