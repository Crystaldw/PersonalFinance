import settings.Format;
import settings.Settings;
import settings.Text;

import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalFinancial {
    public static void main(String[] args) {
        init();
//        System.out.println(Format.dateMonth(new Date()));
//        System.out.println(Text.get("PROGRAM_NAME"));
//        System.out.println(Arrays.toString(Text.getMonths()));
//        System.out.println("\\, \\\\");
    }

    private static void init(){
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
