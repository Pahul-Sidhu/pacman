package pacman;

public class Food implements Drawable{
  private float x1;
  private float y1;

  public void setX1(float x1) {
    this.x1 = x1;
  }

  public void setY1(float y1) {
    this.y1 = y1;
  }

  public Food(float x, float y){
    this.x1 = x;
    this.y1 = y;
  }


  @Override
  public void draw(Window window) {
    window.noStroke();
    window.fill(211, 211, 211);
    window.ellipse(x1, y1, 5, 5);
  }

  public float getX1(){
    return this.x1;

  }

  public float getY1(){
    return this.y1;
  }
}
