package settings;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public class Settings {

    public static final File FONT_ROBOTO_LIGHT = new File("fonts/Roboto-Light.ttf"); //подключаем шрифт
    public static final File SAVE_DIR = new File("save/"); //папка для сохранения файлов
    public static final String SAVE_FILE_EXT = "myrus"; //придуманное расширение для сохраненных файлов
    public static final String FORMAT_AMOUNT = "%.2f"; //формат вывода суммы счета
    public static final String FORMAT_RATE = "%.4f"; //формат вывода курса валюты
    public static final String FORMAT_DATE = "dd.MM.yyyy"; //формат вывода даты
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy"; //формат вывода меысяца
    public static final String FORMAT_DATE_YEAR = "yyyy"; //формат вывода года
    public static final int COUNT_OVERVIEV_ROWS = 10;//какое колл-во строк будет показано на главном экране (последние транзакции)
    public static final String[] CURRENCIES_CODESS = new String[]{"PLN", "EUR", "USD", "UAH"}; //добавление валют

    private static final File FILE_SETTINGS = new File("save/settings.ini"); // место хранения файла настроек

    private static final File FILE_SAVE = new File("save/default.myrus"); //путь к последнему открытому файлу. если его нету, то дефолтный файл.

    public static void init() {
        try {
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences prefs = new iniPreferences(ini);
            String file =prefs.node("Settings").get("SAVE_FILE", null);
        } catch (IOException e) {
            Logger.getLogger(Settings.class.getName().log(Level.SEVERE, null, e));
        }

    }
}
