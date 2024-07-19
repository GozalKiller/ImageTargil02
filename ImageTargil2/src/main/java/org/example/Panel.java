package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Panel extends JPanel {
    private BufferedImage bufferedImage;
    private  MyMouseListener myMouseListener;

    public Panel(int x, int y, int w, int h) {
        this.setBounds(x, y, w, h);
        this.setLayout(null);
        gradient();
        this.myMouseListener = new MyMouseListener(this);//המחלקה מקבלת אתPANEL ואנחנו נמצאים במחלקת ה-PANEL ולכן this
        this.setFocusable(true);
        this.requestFocus(true);
        this.addMouseListener(myMouseListener);
    }

    public void gradient() {
        Random random = new Random();
        //Color color = randomColor();

        int red = random.nextInt(0,256);
        int green = random.nextInt(0, 256);
        int blue = random.nextInt(0, 256);
        this.bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);//י
        Color color = new Color(red, green, blue);
        for (int i = 0; i < this.bufferedImage.getWidth(); i++) {
            for (int j = 0; j < this.bufferedImage.getHeight(); j++) {
                this.bufferedImage.setRGB(i, j, color.getRGB());
                if (green + 4 < 256) {
                    green += 4;//יציג בחלון גוונים שדומים לירוק
                }else {
                    green-=10;
                }
            }
            if (red+2<256){
                red+=2;
            }else {
                red-=200;
            }
            color = new Color(red,green,blue);
        }

    }

    public Color randomColor() {
        Random random = new Random();
        int red = random.nextInt(0, 256);
        int green = random.nextInt(0, 256);
        int blue = random.nextInt(0, 256);
        Color color = new Color(red, green, blue);
        return color;
    }

    public void paintComponent(Graphics g) { // יש עליו אובר רייד לפי הסמל הכחול ליד המספר שוורה רק ל-JPENAL יש PaintComponent
        super.paintComponent(g);
        g.drawImage(this.bufferedImage, 0, 0, this.bufferedImage.getWidth(), this.bufferedImage.getHeight(), null);//

    }

}
