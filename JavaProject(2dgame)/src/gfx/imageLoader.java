package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class imageLoader {
    
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(imageLoader.class.getResource(path));
        
        } catch (IOException ex) {
            
            //Logger.getLogger(imageLoader.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    
}
