package pacman;

import java.util.ArrayList;

public class Renderfood implements Drawable{
  private ArrayList<Food> particles = new ArrayList<>();

  public void create(){
    //Filling upper half
    int x = 60;
    int y = 30;

    //going right
    for(x = x; x < 220; x+=20 ){
      Food f = new Food(x, y);
      particles.add(f);
    }

    x = 200;

    //going down
    for(y = y; y <= 70; y+=20 ){
      Food f = new Food(x, y);
      particles.add(f);
    }

    y = 30;
    //going down from start
    for(y = y; y <= 110; y+=20 ){
      Food f = new Food(60, y);
      particles.add(f);
    }
    y = 120;
    x = 80;

    //going right
    for(x = x; x < 140; x+=20 ){
      Food f = new Food(x, y);
      particles.add(f);
    }

    //going down
    for(y = 50; y <= 325; y+=25){
      Food f = new Food(120, y);
      particles.add(f);
    }

    //going right
    for(x = 80; x < 400; x+=20 ){
      Food f = new Food(x, 85);
      particles.add(f);
    }

    //going down
    for(y = 30; y < 340; y+=20 ){
      Food f = new Food(320, y);
      particles.add(f);
    }

    for(x = 340; x <= 380; x+=20 ){
      Food f = new Food(x, 330);
      particles.add(f);
    }

    for(x = 240; x <= 380; x+=20 ){
      Food f = new Food(x, 30);
      particles.add(f);
    }

    for(y = 30; y < 130; y+=20 ){
      Food f = new Food(380, y);
      particles.add(f);
    }

    for(x = 380; x >= 340; x-=20 ){
      Food f = new Food(x, 120);
      particles.add(f);
    }

    for(x = 280; x <= 440; x+=20 ){
      Food f = new Food(x, 195);
      particles.add(f);
    }

    for(x = 160; x >= 0; x-=20 ){
      Food f = new Food(x, 195);
      particles.add(f);
    }

    //going left then right
    x = 100;
    y = 325;
    for(x = x; x > 40; x-=20 ){
      Food f = new Food(x, y);
      particles.add(f);
    }
    x = 60;
    for(y = y; y <= 350; y+=25){
      Food f = new Food(x, y);
      particles.add(f);
    }
    x = 80;
    for(x = x; x < 400; x+=20 ){
      Food f = new Food(x, 360);
      particles.add(f);
    }

    for(x = 380; x >= 60; x-=20 ){
      Food f = new Food(x, 265);
      particles.add(f);
    }

    for(x = 140; x <= 300; x+=20 ){
      Food f = new Food(x, 120);
      particles.add(f);
    }

    for(x = 140; x <= 300; x+=20 ){
      Food f = new Food(x, 160);
      particles.add(f);
    }

    for(x = 140; x <= 300; x+=20 ){
      Food f = new Food(x, 230);
      particles.add(f);
    }

    for(x = 140; x <= 300; x+=20 ){
      Food f = new Food(x, 297);
      particles.add(f);
    }

    for(x = 140; x <= 300; x+=20 ){
      Food f = new Food(x, 330);
      particles.add(f);
    }

  }

  @Override
  public void draw(Window window) {
    for(int i = 0; i < particles.size(); i++){
      particles.get(i).draw(window);
    }
  }

  public ArrayList<Food> getParticles(){
    return this.particles;
  }
}
