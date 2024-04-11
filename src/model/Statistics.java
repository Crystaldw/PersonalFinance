package model;

import saveload.SaveData;

public class Statistics {

    public static double getBalanceCurrency(Currency currency) {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()){
        if (currency.equals(account.getCurrency())) amount += account.getAmount();
        }
        return amount;
    }
}
