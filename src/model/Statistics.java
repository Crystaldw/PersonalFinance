package model;

import saveload.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {

    public static double getBalanceCurrency(Currency currency) {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            if (currency.equals(account.getCurrency())) amount += account.getAmount();
        }
        return amount;
    }

    public static double getBalance(Currency currency) {
        SaveData ad = SaveData.getInstance();
        double amount = 0;
        for (Account account : ad.getAccounts()) {
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }

    public static HashMap<String, Double> getDataForChartOnIncomeArticles() {
        return getDateForChartOnArticles(true);
    }

    public static HashMap<String, Double> getDataForChartOnExpArticles() {
        return getDateForChartOnArticles(false);
    }

    private static HashMap<String, Double> getDateForChartOnArticles(boolean income) {
        List<Transaction> transactions = SaveData.getInstance().getTransactions();
        HashMap<String, Double> data = new HashMap<>();
        for (Transaction t : transactions) {
            if ((income && t.getAmount() > 0) || (!income && t.getAmount() < 0)) {
                String key = t.getArticle().getTitle();
                double summa = 0;
                double amount = t.getAmount();
                if (!income) amount *= -1;
                if (data.containsKey(key)) summa = data.get(key);
                summa += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(summa));
            }
        }
        return data;
    }

    //округление суммы до 2 знауков после запятой
    private static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
