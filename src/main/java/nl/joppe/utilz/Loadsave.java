package nl.joppe.utilz;

import nl.joppe.game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Loadsave {

    public static final String PLAYER_ATLAS = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "level_one_data.png";

    public static BufferedImage GetSpriteAtlas(String fileName){
     BufferedImage image = null;
     InputStream is = Loadsave.class.getResourceAsStream("/" + fileName );
     try {
         image = ImageIO.read(is);

     } catch (IOException e) {
         e.printStackTrace();
     } finally {
         try {
             is.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
        return image;
    }
    public static int[][] GetLevelData() {
        int[][] lvlData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage image = GetSpriteAtlas(LEVEL_ONE_DATA);

        for(int j = 0; j < image.getHeight(); j++)
            for(int i = 0; i < image.getWidth(); i++){
                Color color = new Color(image.getRGB(i, j));
                int value = color.getRed();
                if(value >= 48)
                    value = 0;
                lvlData[j][i] = value;


            }
        return lvlData;
    }
}
