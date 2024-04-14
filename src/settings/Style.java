package settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Style {

    public static final Color COLOR_BUTTON_BG_NORMAL = new Color(240, 240, 240); //цвеит для фона кнопок
    public static final Color COLOR_BUTTON_BG_HOVER = Color.YELLOW; //цвет кнопки при наведении на нее курсора мышки

    public static final Font FONT_BUTTON_TOOLBAR = new Font("Roboto-Light", Font.BOLD, 14); //настройка шрифта кнопок в тулбаре
    public static final Font FONT_MAIN_BUTTON = new Font("Roboto-Light", Font.BOLD, 14); //настройка шрифта кнопок

    public static final EmptyBorder BORDER_PANEL = new EmptyBorder(10, 10, 10, 10); //рамка для панели

    public static final ImageIcon ICON_MAIN = new ImageIcon("images/main.png"); //иконка программы
    public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("images/overview.png"); //иконка кнопки обзора гдавной сераницы
    public static final ImageIcon ICON_TOOLBAR_ACCOUNTS = new ImageIcon("images/accounts.png"); //иконка кнопки обзора гдавной сераницы
    public static final ImageIcon ICON_TOOLBAR_ARTICLES = new ImageIcon("images/articles.png"); //иконка кнопки обзора гдавной сераницы
    public static final ImageIcon ICON_TOOLBAR_TRANSACTIONS = new ImageIcon("images/transactions.png"); //иконка кнопки обзора гдавной сераницы
    public static final ImageIcon ICON_TOOLBAR_TRANSFERS = new ImageIcon("images/transfers.png"); //иконка кнопки обзора гдавной сераницы
    public static final ImageIcon ICON_TOOLBAR_CURRENCIES = new ImageIcon("images/currencies.png"); //иконка кнопки обзора гдавной сераницы
    public static final ImageIcon ICON_TOOLBAR_STATOSTOCS = new ImageIcon("images/statistics.png"); //иконка кнопки обзора гдавной сераницы
}
