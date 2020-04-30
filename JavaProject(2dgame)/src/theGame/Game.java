package theGame;

import gfx.Assets;
import gfx.SpriteSheet;
import gfx.imageLoader;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import displayGame.Display;
import theGame.states.GameState;
import theGame.states.State;

public class Game implements Runnable {

    private Display display;

    public int width, heigth;
    public String title;
    private boolean running = false;

    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;
    
    //States
    private State gameState ;

    public Game(String title, int width, int heigth) {
        this.title = title;
        this.width = width;
        this.heigth = heigth;
    }

    private void init() {
        display = new Display(title, width, heigth);
        Assets.init();
        
        gameState = new GameState() ;
        State.setState(gameState);

    }

    

    private void update() {
        if(State.getState() != null){
            State.getState().tick();
        }      
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear Screen
        g.clearRect(150, 150, width, width);

        //beging drawing 
        if(State.getState() != null){
            State.getState().render(g);
        
        //g.drawImage(Assets.ss1, x, 0, null);
        //g.drawImage(Assets.ss2, 0, 300, null) ;
        //g.drawImage(Assets.ss3, 300, 0, null) ;
        //g.drawImage(Assets.ss4, 300, 300, null) ;

        //end Drawing
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0 ;
        int ticks = 0 ;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime ;
            lastTime = now ;
            
            if (delta >= 1) {
                update();
                render();
                ticks++ ;
                delta--;
            }
            if( timer >= 1000000000){
                System.out.println("FPS = "+ticks);
                ticks = 0 ;
                timer = 0 ;
            }
        }

        stop();

    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;

        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

}
