import exception.ModelException;
import model.*;
import saveload.SaveData;
import settings.Settings;
import settings.Text;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalFinancial {
    public static void main(String[] args) throws ModelException {
        init();
        testModel();
//        System.out.println(Format.dateMonth(new Date()));
//        System.out.println(Text.get("PROGRAM_NAME"));
//        System.out.println(Arrays.toString(Text.getMonths()));
//        System.out.println("\\, \\\\");
    }

    private static void testModel() throws ModelException {
        Currency c1 = new Currency("Рубль", "RUB", 1, true, true);
        Currency c2 = new Currency("Доллар", "USD", 65, true, false);
        Currency c3 = new Currency("Евро", "EUR", 75, false, false);
        Currency c4 = new Currency("Гривна", "UAH", 2.5, false, false);

        Account ac1 = new Account("Кошелек", c1, 1000);
        Account ac2 = new Account("VISA CARD", c1, 0);
        Account ac3 = new Account("DEPOSIT RUB", c1, 100000);
        Account ac4 = new Account("DEPOSIT USD", c2, 0);

        Article article1 = new Article("Прщдукты");
        Article article2 = new Article("ЖКХ");
        Article article3 = new Article("Зарплата");
        Article article4 = new Article("Столовая");
        Article article5 = new Article("Проценты по депозиту");

        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(c1);
        currencies.add(c2);
        currencies.add(c3);
        currencies.add(c4);

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(ac2, article3, 30000));
        transactions.add(new Transaction(ac2, article1, -1500, "На выходные"));
        transactions.add(new Transaction(ac1, article2, -5500, "Основная квартира"));
        transactions.add(new Transaction(ac1, article2, -4000, "Вторая квартира"));
        transactions.add(new Transaction(ac3, article5, 1000));
        transactions.add(new Transaction(ac2, article3, 25000, new Date((new Date()).getTime() - (long) 86400000 * 30)));
        transactions.add(new Transaction(ac3, article5, 1000, new Date((new Date()).getTime() - (long) 86400000 * 30)));

        for (int i = 0; i < 50; i++) {
            Article tempArticle;
            Account tempAccount;
            if (Math.random() < 0.5) tempArticle = article1;
            else tempArticle = article4;
            if (Math.random() < 0.5) tempAccount = ac1;
            else tempAccount = ac2;
            double tempAmount = Math.random() * (-1000);
            Date tempDate = new Date((long) (new Date().getTime() - (long) 86400000 * 30 * Math.random()));
            transactions.add(new Transaction(tempAccount, tempArticle, tempAmount, tempDate));
        }
        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(ac2, ac1, 25000, 25000));
        transfers.add(new Transfer(ac2, ac3, 3000, 3000));
        transfers.add(new Transfer(ac2, ac4, 6000, 90));

        for (Account a : accounts){
            a.setAmountFromTransactionsAndTransfers(transactions, transfers);
        }

        SaveData sd = SaveData.getInstance();
        sd.setArticles(articles);
        sd.setAccounts(accounts);
        sd.setCurrencies(currencies);
        sd.setTransactions(transactions);
        sd.setTransfers(transfers);
        sd.save();
        sd.load();
        System.out.println(sd);

    }

    private static void init() {
        try {
            Settings.init();
            Text.init();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ROBOTO_LIGHT));
        } catch (FontFormatException | IOException e) {
            Logger.getAnonymousLogger(PersonalFinancial.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
