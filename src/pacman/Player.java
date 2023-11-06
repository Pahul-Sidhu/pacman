package pacman;

import processing.core.PVector;

import java.util.ArrayList;

public class Player implements Drawable {
  private static Player player = null;
  private int biteFactor = 0;
  private PVector dir;
  private PVector pos;

  private Player(PVector pos, PVector dir) {
    this.pos = pos;
    this.dir = dir.normalize();
  }

  public static Player getInstance(PVector pos, PVector dir) {
    if (player == null) {
      player = new Player(pos, dir);
    }
    return player;
  }

  public void changedir(float x, float y) {
    this.dir = new PVector(x, y).normalize();
  }

  @Override
  public void draw(Window window) {
    window.noStroke();
    window.fill(255, 204, 0);
    window.ellipse(this.pos.x, this.pos.y, 24, 24);
    window.fill(0);

    if (dir.x == 1f && dir.y == 0) {
      window.arc(this.pos.x, this.pos.y, 24, 24,
              biteFactor * ((float) (-Math.PI / 3.0)), biteFactor * ((float) (Math.PI / 3.0)));
    } else if (dir.x == -1f && dir.y == 0) {
      window.arc(this.pos.x, this.pos.y, 24, 24,
              biteFactor * ((float) (Math.toRadians(125))), biteFactor * ((float) (Math.toRadians(240))));
    } else if (dir.x == 0 && dir.y == 1f) {
      window.arc(this.pos.x, this.pos.y, 24, 24,
              biteFactor * ((float) (Math.toRadians(30))), biteFactor * ((float) (Math.toRadians(150))));
    } else {
      window.arc(this.pos.x, this.pos.y, 24, 24,
              biteFactor * ((float) (Math.toRadians(210))), biteFactor * ((float) (Math.toRadians(330))));
    }

    biteFactor = (biteFactor + 1) % 2;
  }

  public void move(Window win) {
      this.pos = this.pos.add(this.dir.mult(1.00f));
      if(this.pos.x < 0){
        this.pos.x = 445;
        this.changedir(-1f, 0);
      }else if(this.pos.x > win.width){
        this.pos.x = 0;
        this.changedir(1f, 0);
      }
  }

}
