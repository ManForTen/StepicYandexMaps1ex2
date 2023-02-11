import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MyForm extends JFrame{

    private JPanel panel;
    private JButton button1;
    private JLabel label;

    MyForm() throws HeadlessException{
        super("Карта");
    }

    public void run() {
        addGui();
        addButtonActionListener();
    }

    public void addGui() {
        add(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addButtonActionListener() {
        button1.addActionListener(e -> {
            try {
                addImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void addImage() throws IOException {
        Image image = ImageIO.read(new URL("https://static-maps.yandex.ru/1.x/?ll=32.039091,54.781830&z=17&l=map&" +
                "pt=32.041901,54.780564,flag" +
                "~32.041703,54.780903,ya_ru" +
                "~32.040027,54.781253,3" +
                "~32.038424,54.782181,pmdos2~" +
                "32.038041,54.782746,pm2dom1"));
        label.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {
        new MyForm().run();
    }
}
