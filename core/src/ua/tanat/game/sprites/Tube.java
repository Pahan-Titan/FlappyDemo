package ua.tanat.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 * Created by TaNaT on 05.05.2016.
 */
public class Tube {

    public static final int TUBE_WIDTH = 52;

    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Texture topTube, botTube;
    private Vector2 posTopTube, posBotTube;
    private Random rand;
    private Rectangle boundsTop, boundsBot;

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBotTube() {
        return botTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Tube(float x){
        topTube = new Texture("toptube.png");
        botTube = new Texture("bottomtube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - botTube.getHeight());

        boundsTop = new Rectangle((int)(posTopTube.x), (int)(posTopTube.y), topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle((int)(posBotTube.x), (int)(posBotTube.y), botTube.getWidth(), botTube.getHeight());
    }

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - botTube.getHeight());
        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posBotTube.y);
    }

    public boolean collides (Rectangle player) {
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public void dispose() {
        topTube.dispose();
        botTube.dispose();
    }
}
