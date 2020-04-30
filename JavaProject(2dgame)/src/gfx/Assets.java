package gfx;

import java.awt.image.BufferedImage;

public class Assets {
    
    private static final int width = 256 ,heigth = 278 ;
    
    public static BufferedImage ss1 ,ss2 ,ss3 ,ss4 ,bullet1 ,bullet2 ,bullet3;
    
    public static void init(){
        
        SpriteSheet sheet = new SpriteSheet(imageLoader.loadImage("/textures/ships.png")) ;
        
        ss1  = sheet.crop(0 ,0 ,width ,heigth);
        bullet1 = sheet.crop(width, 0, width , heigth);
        
        ss2 = sheet.crop(0, heigth, width , heigth);
        bullet2 = sheet.crop(width, heigth, width , heigth);
        
        ss3 = sheet.crop(0, 2*heigth-35 , width , heigth);
        bullet3 = sheet.crop(width, 2*heigth, width , heigth);
        
        ss4 = sheet.crop(0, 3*heigth-60, width , heigth);
        
    }
    
}
