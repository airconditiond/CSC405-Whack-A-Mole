float moleLocation = 0;
int moleX, moleY;
int score = 0;
int time = 5;
boolean gameOver;
boolean clickedMole = false;
 
void setup(){
  size(640,480);
}

void draw() {
  background(255); //background
  holes();
  moles();
  time(); //done
  score();
  fill(#E888E8);
  circle(mouseX, mouseY, 50); //mouse
  gameOver(); //done

}

void holes() {
  fill(#2D8B29);
  //top row
  circle(125,150,150);
  circle(325,150,150);
  circle(525,150,150);
  //bottom row
  circle(225,300,150); 
  circle(425,300,150);
}

void moles() { //moles go to random holes every 2 seconds or when the mole is clicked
  if(frameCount%60 == 0 || clickedMole == true) { //every second, random mole
    moleLocation = random(5);
    clickedMole = false;
  }

  if(moleLocation >= 4) { //first hole
    moleX = 125;
    moleY = 150;
  }

  else if(moleLocation >= 3) {//second hole
    moleX = 325;
    moleY = 150;
  }

  else if(moleLocation >= 2) { //third hole
    moleX = 525;
    moleY = 150;
  }

  else if(moleLocation >= 1) { //fourth hole
    moleX = 225;
    moleY = 300;
  }

  else if(moleLocation >= 0) { //fifth hole
    moleX = 425;
    moleY = 300;
  }

  fill(#FFCA08);
  circle(moleX, moleY, 50);
}

 

void time() {
  textSize(25);
  fill(0);
  text("Time: " + time, 500, 45);
  if(time>0 && frameCount%60 == 0) {
    time = time - 1;
  }
}

void score() {
  fill(0);
  textSize(25);
  text("Score: " + score, 50,45);
}

void mouseClicked() { //when you hit mole
  if(dist(moleX, moleY, mouseX, mouseY)<150) {
    score++;
    clickedMole = true;
  }
  else{
    score--;
  }
}

void gameOver() { // when time = 0
  if(time == 0) {
    background(0);
    fill(255);
    textSize(75);
    text("Game Over", 150, height/2);
    textSize(35);
    text("Press any key to restart", 50, 50);
    if(keyPressed) { //doesn't work?
      setup();
    }

  }

}

void keyPressed() {
  if(time == 0) {
    score = 0;
    time = 60;
    moleLocation = 0;
    gameOver = false;

  }

}