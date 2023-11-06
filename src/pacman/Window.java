package pacman;

import processing.core.PApplet;
import processing.core.PVector;
import processing.data.JSONObject;
import processing.event.KeyEvent;

import java.util.ArrayList;

public class Window extends PApplet {
  Structures struct;
  Player player;
  PVector playerdir;
  PVector playerpos;
  Renderfood food;
  private float lastx = 1f;
  private float lasty = 0;
  ArrayList<Ghost> ghosts;
  boolean gameOver = false;
  int score = 0;
  int highscore = 0;
  ArrayList<Food> particles;
  JSONObject js = new JSONObject();
  int conn = 0;
//  database db;
  float x = 0;
  float y = 0;

  public void setup() {
    ghosts = new ArrayList();
    Ghost g1 = new Ghost(this.width / 2, this.height / 2 - 100, this);
    Ghost g2 = new Ghost(this.width / 2, this.height / 2 - 40, this);
    Ghost g3 = new Ghost(this.width / 2 - 30, this.height / 2 - 40, this);
    Ghost g4 = new Ghost(this.width / 2 + 20, this.height / 2 - 40, this);

    g1.create(this, "/Users/pahulsidhu/Documents/Development/Projects/pacman/pacman/images/gh1.jpeg");
    g2.create(this, "/Users/pahulsidhu/Documents/Development/Projects/pacman/pacman/images/gh2.jpeg");
    g3.create(this, "/Users/pahulsidhu/Documents/Development/Projects/pacman/pacman/images/gh3.jpeg");
    g4.create(this, "/Users/pahulsidhu/Documents/Development/Projects/pacman/pacman/images/gh4.jpeg");

    ghosts.add(g1);
    ghosts.add(g2);
    ghosts.add(g3);
    ghosts.add(g4);

    struct = new Structures(this);
    struct.create();
    playerpos = new PVector(60, 30);
    playerdir = new PVector(1f, 0).normalize();
    player = Player.getInstance(playerpos, playerdir);
    food = new Renderfood();
    food.create();
    particles = food.getParticles();
//    db = new database();
//    highscore = db.printData(this);
  }

  public void keyPressed(KeyEvent event) {
    super.keyPressed(event);
    if (player == null) {
      return;
    }
    switch (event.getKeyCode()) {
      case RIGHT:
        player.changedir(1f, 0);
        lastx = 1f;
        lasty = 0;
        break;
      case LEFT:
        player.changedir(-1f, 0);
        lastx = -1f;
        lasty = 0;
        break;
      case UP:
        player.changedir(0, -1f);
        lastx = 0;
        lasty = -1f;
        break;
      case DOWN:
        player.changedir(0, 1f);
        lastx = 0;
        lasty = 1f;
        break;
      default:
        break;
    }
  }

  public void draw() {
    background(0);

    if (!gameOver) {
      for (int i = 0; i < ghosts.size(); i++) {
        ghosts.get(i).draw(this);
      }
      struct.draw(this);
      player.draw(this);
      player.move(this);
      food.draw(this);
      collision();
      ghostCollision();
      displayscore();
      enemyNear();
    } else {
      if(particles.size() == 0){
        textSize(90);
        fill(255, 204, 0);
        text("You Won !!!", 20, 220);
        textSize(30);
        text("Your score is : " + score, 120, 320);
      }else{
        textSize(90);
        fill(255, 204, 0);
        text("You Lost", 60, 220);
        textSize(30);
        text("Your score is : " + score, 120, 320);
      }
      if(conn == 0){
//        save();
        conn = 1;
      }

    }
  }

  public void settings() {
    size(445, 445);
  }

  public void collision() {
    ArrayList<line> lines = struct.getLines();
    ArrayList<rect> rects = struct.getrects();

    for (int i = 0; i < lines.size(); i++) {
      if (lineCircle(lines.get(i).getx1(), lines.get(i).gety1(), lines.get(i).getx2(), lines.get(i).gety2(),
              playerpos.x, playerpos.y, 9)) {
        if (lastx == -1f && lasty == 0) {
          player.changedir(1f, 0);
          lastx = 1f;
          lasty = 0;
        } else if (lastx == 1f && lasty == 0) {
          player.changedir(-1f, 0);
          lastx = -1f;
          lasty = 0;
        } else if (lastx == 0 && lasty == 1f) {
          player.changedir(0, -1f);
          lastx = 0;
          lasty = -1f;
        } else if (lastx == 0 && lasty == -1f) {
          player.changedir(0, 1f);
          lastx = 0;
          lasty = 1f;
        }
      }
    }

    for (int i = 0; i < rects.size(); i++) {
      if (circleRect(playerpos.x, playerpos.y, 9, rects.get(i).getx1(), rects.get(i).gety1(),
              rects.get(i).getWidth(), rects.get(i).getHeight())) {
        if (lastx == -1f && lasty == 0) {
          player.changedir(1f, 0);
          lastx = 1f;
          lasty = 0;
        } else if (lastx == 1f && lasty == 0) {
          player.changedir(-1f, 0);
          lastx = -1f;
          lasty = 0;
        } else if (lastx == 0 && lasty == 1f) {
          player.changedir(0, -1f);
          lastx = 0;
          lasty = -1f;
        } else if (lastx == 0 && lasty == -1f) {
          player.changedir(0, 1f);
          lastx = 0;
          lasty = 1f;
        }
      }
    }

    for (int i = 0; i < particles.size(); i++) {
      if (dist(particles.get(i).getX1(), particles.get(i).getY1(), playerpos.x, playerpos.y) <= 10) {
        particles.remove(i);
        if(particles.size() == 0){
          gameOver = true;
        }else{
          score++;
        }
      }
    }

  }

  private boolean lineCircle(float x1, float y1, float x2, float y2, float px, float py, float radius) {
    /*
    Check if pacman hits either end of the line.
    If so, return true.
     */
    boolean inside1 = pointCircle(x1, y1, px, py, radius);
    boolean inside2 = pointCircle(x2, y2, px, py, radius);
    if (inside1 || inside2) {
      return true;
    }

    //get length of the line
    float distX = x1 - x2;
    float distY = y1 - y2;
    float len = (float) Math.sqrt((distX * distX) + (distY * distY));

    //Get dot product of line and circle
    float dot = (float) ((((px - x1) * (x2 - x1)) + ((py - y1) * (y2 - y1))) / Math.pow(len, 2));

    //Finding the closest point on the line
    float closestX = x1 + (dot * (x2 - x1));
    float closestY = y1 + (dot * (y2 - y1));

    /*
    Check if that point is actually on the line.
    If so, proceed. Otherwise, return false
     */
    boolean onLine = linePoint(x1, y1, x2, y2, closestX, closestY);
    if (!onLine) {
      return false;
    }

    //Check if pacman has hit that point
    distX = closestX - px;
    distY = closestY - py;
    if ((float) Math.sqrt((distX * distX) + (distY * distY)) <= radius) {
      return true;
    }
    return false;

  }

  private boolean pointCircle(float px, float py, float cx, float cy, float radius) {
    //Calculate the distance from the either end to the centre of pacman
    float distX = px - cx;
    float distY = py - cy;
    float dist = (float) Math.sqrt((distX * distX) + (distY * distY));
    if (dist <= radius) {
      return true;
    }
    return false;
  }

  private boolean linePoint(float x1, float y1, float x2, float y2, float closestX, float closestY) {
    //Get distance of the point from two end of line
    float d1 = dist(closestX, closestY, x1, y1);
    float d2 = dist(closestX, closestY, x2, y2);

    //Get length of line
    float len = dist(x1, y1, x2, y2);

    //Add a little buffer to handle minute inaccuracies
    float buffer = 0.1f;

    //If the sum of two distances is equal to line length, return true
    if (d1 + d2 >= len - buffer && d1 + d2 <= len + buffer) {
      return true;
    }
    return false;
  }

  private boolean circleRect(float px, float py, float radius, float rx, float ry, float width, float height) {
    //Setting variables for testing
    float tempx = px;
    float tempy = py;

    //Seeing which edge is closest
    if (px < rx) {
      tempx = rx; //left edge
    } else if (px > (rx + width)) {
      tempx = rx + width; //right edge
    }

    if (py < ry) {
      tempy = ry; //top edge
    } else if (py > (ry + height)) {
      tempy = ry + height; //bottom edge
    }

    //Getting dist from closest edges
    float distX = px - tempx;
    float distY = py - tempy;
    float distance = sqrt((distX * distX) + (distY * distY));

    //if distance is less than radius, collision!!!
    if (distance <= radius) {
      return true;
    }
    return false;
  }

  private void ghostCollision() {
    ArrayList<line> lines = struct.getLines();
    ArrayList<rect> rects = struct.getrects();

    for (int j = 0; j < ghosts.size(); j++) {
      Ghost g1 = ghosts.get(j);
      for (int i = 0; i < lines.size(); i++) {
        if (linerect(lines.get(i).getx1(), lines.get(i).gety1(), lines.get(i).getx2(), lines.get(i).gety2(),
                g1.getX(), g1.getY(), g1.getWidth(), g1.getHeight())) {
          g1.changeDir(this, 0, 0);
        }
      }

      for (int i = 0; i < rects.size(); i++) {
        if (rectrect(rects.get(i).getx1(), rects.get(i).gety1(), rects.get(i).getWidth(), rects.get(i).getHeight(),
                g1.getX(), g1.getY(), g1.getWidth(), g1.getHeight())) {
          g1.changeDir(this, 0, 0);
        }
      }

      if (circleRect(playerpos.x, playerpos.y, 9, g1.getX(), g1.getY(), g1.getWidth(), g1.getHeight())) {
        gameOver = true;
      }
    }
  }

  private boolean linerect(float x1, float y1, float x2, float y2, float rx, float ry, float rw, float rh) {
    //check if any line has touched any side of our ghost image
    boolean left = lineline(x1, y1, x2, y2, rx, ry, rx, ry + rh);
    boolean right = lineline(x1, y1, x2, y2, rx + rw, ry, rx + rw, ry + rh);
    boolean top = lineline(x1, y1, x2, y2, rx, ry, rx + rw, ry);
    boolean bottom = lineline(x1, y1, x2, y2, rx, ry + rh, rx + rw, ry + rh);

    //if any of the above are true, ghost has collided with the structure line
    if (left || right || top || bottom) {
      return true;
    }
    return false;
  }

  private boolean rectrect(float r1x, float r1y, float r1w, float r1h, float r2x, float r2y, float r2w, float r2h) {
    //are the sides of one rectangle touching the other?
    if (r1x + r1w >= r2x &&
            r1x <= r2x + r2w &&
            r1y + r1h >= r2y &&
            r1y <= r2y + r2h) {
      return true;
    }
    return false;
  }

  private boolean lineline(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
    //calculate the direction of the lines
    float v = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
    float u1 = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / v;
    float u2 = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / v;

    if (u1 >= 0 && u1 <= 1 && u2 >= 0 && u2 <= 1) {
      return true;
    }
    return false;
  }

  private void displayscore(){
    textSize(30);
    fill(255, 204, 0);
    text("Score : " + score, 40, 420);
    text("High-Score : " + highscore, 200, 420);
  }

//  private void save(){
//    js.put("score", score);
//    FileWriter file;
//
//    try {
//      file = new FileWriter("output.txt");
//      file.write(js.t);
//      file.flush();
//      file.close();
//    }catch(Exception e){
//      System.out.println(e);
//    }
//
//    db.insertData(this);
//
// }

  public static void main(String[] args) {
    String[] appletArgs = new String[]{"game"};
    Window window = new Window();
    PApplet.runSketch(appletArgs, window);
  }

  public int getScore() {
    return score;
  }

  private void enemyNear(){
    for(int i = 0; i < ghosts.size(); i++){
      Ghost g = ghosts.get(i);
      if(dist(playerpos.x, playerpos.y, g.getX() + g.getWidth(), g.getY() + g.getHeight()) < 35f){
        float dx = playerpos.x - (g.getX() + g.getWidth());
        float dy = playerpos.y - (g.getY() + g.getHeight());

        x = dx;
        y = dy;
        g.changeDir(this, x, y);

      }
    }
  }
}
