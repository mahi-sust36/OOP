package theGame.states;

import gfx.Assets;
import java.awt.Graphics;

public class GameState extends State{
    
    public GameState(){
        
    }
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.ss1, 0, 0, null) ;
    }
    
}
