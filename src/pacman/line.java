package pacman;

import processing.core.PConstants;
import processing.core.PShape;

public class line implements Drawable{
  private float x1;
  private float x2;
  private float y1;
  private float y2;
  private PShape l;

  public line(float x1, float y1, float x2, float y2){
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }

  @Override
  public void draw(Window window) {
    PShape l = window.createShape();
    l.beginShape();
    l.stroke(30, 30 ,250);
    l.vertex(x1, y1);
    l.vertex(x2, y2);
    l.endShape(PConstants.CLOSE);
    l.setStrokeWeight(3f);
    window.shape(l);
  }

  public void setX1(float x1) {
    this.x1 = x1;
  }

  public void setX2(float x2) {
    this.x2 = x2;
  }

  public void setY1(float y1) {
    this.y1 = y1;
  }

  public void setY2(float y2) {
    this.y2 = y2;
  }

  public float getx1(){
    return x1;
  }

  public float getx2(){
    return x2;
  }

  public float gety1(){
    return y1;
  }

  public float gety2(){
    return y2;
  }

}
