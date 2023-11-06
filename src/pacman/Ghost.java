package pacman;

import java.io.File;
import java.util.*;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Ghost implements Drawable {
  private PVector dir;
  private PVector pos;
  PImage img;
  private float width = 20;
  private float height = 20;
  private float limit = 50;

  public Ghost(int x, int y, Window win) {
    this.pos = new PVector(x, y);
    this.dir = new PVector(win.random(-1f, 1f), win.random(-1f, 1f)).normalize();
  }

  public void create(Window window, String path) {
    img = window.loadImage(path);
  }

  @Override
  public void draw(Window window) {
    window.image(img, pos.x, pos.y, width, height);
    move(window);
  }

  public void move(Window win) {
    if ((this.pos.x < 0 || this.pos.x > win.width) ||
            (this.pos.y > win.height || this.pos.y < 0)) {
      this.pos = new PVector(win.width / 2, win.height / 2 - 40);
    }
    this.pos = this.pos.add(this.dir.mult(1.0f));
  }

  public void changeDir(Window win, float x, float y) {
    if (x == 0f || y == 0f) {
      this.dir.rotate((float) Math.PI / 1.5f).normalize();
    }else {
      this.pos.x += x * 0.03;
      this.pos.y += y * 0.03;
    }
  }

  public float getX() {
    return pos.x;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public float getY() {
    return pos.y;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }

}
