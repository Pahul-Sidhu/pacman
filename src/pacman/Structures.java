package pacman;

import processing.core.*;
import java.awt.*;
import java.util.*;

public class Structures implements Drawable{
    private ArrayList<line> lines;
    private ArrayList<rect> rectangle;
    //private float width = 5f;

    public Structures(Window win){
      lines = new ArrayList<>();
      rectangle = new ArrayList<>();
    }

    public void create(){
      //First half
      line l1 = new line(0, 180, 100, 180);
      line l2 = new line(100, 180, 100, 140);
      line l3 = new line(100, 140, 40, 140);
      line l4 = new line(40, 140, 40, 15);
      line l5 = new line(40, 15, 220, 15);
      line l6 = new line(220, 15, 220, 70);
      line l7 = new line(220, 15, 400, 15);
      line l8 = new line(400, 15, 400, 140);
      line l9 = new line(400, 140, 340, 140);
      line l10 = new line(340, 140, 340, 180);
      line l11 = new line(340, 180, 445, 180);

      //second half
      line l12 = new line(0, 210, 100, 210);
      line l13 = new line(340, 210, 445, 210);

      line l14 = new line(100, 210, 100, 250);
      line l15 = new line(340, 210, 340, 250);

      line l16 = new line(100, 250, 40, 250);
      line l17 = new line(340, 250, 400, 250);

      line l18 = new line(40, 250, 40, 375);
      line l19 = new line(400, 250, 400, 375);

      line l20 = new line(40, 312, 70, 312);
      line l21 = new line(400, 312, 370, 312);

      line l22 = new line(40, 375, 400, 375);

      //Building cage
      line c1 = new line(170, 210, 270, 210);
      line c2 = new line(170, 210, 170, 180);
      line c3 = new line(270, 210, 270, 180);
      line c4 = new line(170, 180, 200, 180);
      line c5 = new line(270, 180, 240, 180);

      //Filling first half
      line f11 = new line(135, 180, 135, 100);
      line f12 = new line(135, 140, 180, 140);

      line f13 = new line(305, 180, 305, 100);
      line f14 = new line(305, 140, 260, 140);

      line f15 = new line(170, 100, 270, 100);
      line f16 = new line(220, 100, 220, 140);

      line f17 = new line(75, 100, 100, 100);
      line f18 = new line(340, 100, 365, 100);

      rect f19 = new rect(75, 45, 25, 25, 5);
      rect f191 = new rect(135, 45, 50, 25, 5);

      rect f192 = new rect(255, 45, 50, 25, 5);
      rect f193 = new rect(340, 45, 25, 25, 5);


      //Filling second half
      line f21 = new line(135, 210, 135, 250);
      line f22 = new line(305, 210, 305, 250);

      line f23 = new line(170, 250, 270, 250);
      line f24 = new line(220, 250, 220, 281);

      line f25 = new line(100, 281, 100, 312);
      line f26 = new line(100, 281, 70, 281);

      line f27 = new line(340, 281, 340, 312);
      line f28 = new line(340, 281, 370, 281);

      line f29 = new line(135, 281, 170, 281);
      line f291 = new line(270, 281, 305, 281);

      line f292 = new line(170, 312, 270, 312);
      line f293 = new line(220, 312, 220, 342);

      line f294 = new line(70, 343, 170, 343);
      line f295 = new line(130, 343, 130, 313);

      line f296 = new line(270, 343, 370, 343);
      line f297 = new line(310, 343, 310, 313);

      //Add to the list
      lines.add(l1);
      lines.add(l2);
      lines.add(l3);
      lines.add(l4);
      lines.add(l5);
      lines.add(l6);
      lines.add(l7);
      lines.add(l8);
      lines.add(l9);
      lines.add(l10);
      lines.add(l11);
      lines.add(l12);
      lines.add(l13);
      lines.add(l14);
      lines.add(l15);
      lines.add(l16);
      lines.add(l17);
      lines.add(l18);
      lines.add(l19);
      lines.add(l20);
      lines.add(l21);
      lines.add(l22);
      lines.add(c1);
      lines.add(c2);
      lines.add(c3);
      lines.add(c4);
      lines.add(c5);
      lines.add(f21);
      lines.add(f22);
      lines.add(f23);
      lines.add(f24);
      lines.add(f25);
      lines.add(f26);
      lines.add(f27);
      lines.add(f28);
      lines.add(f29);
      lines.add(f291);
      lines.add(f292);
      lines.add(f293);
      lines.add(f294);
      lines.add(f295);
      lines.add(f296);
      lines.add(f297);
      lines.add(f11);
      lines.add(f12);
      lines.add(f13);
      lines.add(f14);
      lines.add(f15);
      lines.add(f16);
      lines.add(f17);
      lines.add(f18);

      rectangle.add(f19);
      rectangle.add(f191);
      rectangle.add(f192);
      rectangle.add(f193);
    }

    @Override
    public void draw(Window window){
      for(int i = 0; i < lines.size(); i++){
        lines.get(i).draw(window);
      }

      for(int i = 0; i < rectangle.size(); i++){
        rectangle.get(i).draw(window);
      }
    }

    public ArrayList<line> getLines(){
      return lines;
    }

    public ArrayList<rect> getrects(){
      return rectangle;
    }
}
