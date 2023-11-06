package pacman;

import processing.core.PConstants;
import processing.core.PShape;

public class rect implements Drawable{
  private float x1;
  private float y1;
  private float width;
  private float height;
  private float radius;
  private PShape l;

  public rect(float x1, float y1, float x2, float y2, float radius){
    this.x1 = x1;
    this.y1 = y1;
    this.width = x2;
    this.height = y2;
    this.radius = radius;
  }


  @Override
  public void draw(Window window) {
    window.stroke(30, 30 ,250);
    window.strokeWeight(3f);
    window.fill(0);
    window.rect(x1, y1, width, height, radius);

  }

  public float getx1(){
    return x1;
  }

  public float getWidth(){
    return this.width;
  }

  public float gety1(){
    return y1;
  }

  public float getHeight(){
    return this.height;
  }
}
