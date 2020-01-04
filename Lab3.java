public class Lab3
{
  public static void testLightCandles1()
  {
    Robot.load("candles1.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles2()
  {
    Robot.load("candles2.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
    
  public static void turnRight() {
      //pre-cond. facing an arbitrary direction
      //post-cond. facing 90° clockwise from previous direction
      Robot.setDelay(0);
      for (int i=1; i<=3; i++) {Robot.turnLeft();}
      Robot.setDelay(0.05); }
      
  public static void lightCandles()
  {
    //insert instructions below
    Robot.turnLeft();
    while (Robot.frontIsClear()) {Robot.move();}
    turnRight();
    Robot.move();
    for (int i=1; i<=10; i++) {
        turnRight();
        while (Robot.frontIsClear()) {Robot.move();}
        for (int k=1; k<=2; k++) {turnRight();}
        Robot.makeDark();
        while (Robot.frontIsClear()) {Robot.move();}
        turnRight();
        for (int k=1; k<=2; k++) {if (Robot.frontIsClear()) {Robot.move();}}
    }
  }
  
  //Run this method to test completeRoom on map room1.txt
  public static void testCompleteRoom1()
  {
     Robot.load("room1.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  //Run this method to test completeRoom on map room2.txt
  public static void testCompleteRoom2()
  {
    Robot.load("room2.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  //Complete this method.  You will need to write additional helper methods.
  public static void completeRoom() {
    for (int side=1; side<=4; side++) {
        for (int block=1; block<=5; block++) {
            Robot.turnLeft();
            if (Robot.frontIsClear()) {
                Robot.move();
                if (!Robot.onDark()) {Robot.makeDark();}
                for (int i=1; i<=2; i++) {Robot.turnLeft();}
                Robot.move();
                Robot.turnLeft();
            } else {turnRight();}
            if (block < 5) {Robot.move();}
        }
        turnRight();
    }  
  }
  
  //Run this method to test swapAll on map swap1.txt
  public static void testSwapAll1()
  {
    Robot.load("swap1.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll2()
  {
    Robot.load("swap2.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
    
  //Complete this method.  You will need to write additional helper methods.
  public static void swapAll()
  {
    //insert instructions below
    boolean[] lightdark = {false, false};
    for (int row=1; row<=10; row++) {
        for (int run=0; run<=2; run++) {
            Robot.turnLeft();
            while (Robot.frontIsClear()) {Robot.move();}
            if (run < 2) {
                lightdark[run] = Robot.onDark();
                Robot.turnLeft();
            } else {turnRight();} //ugly to stick movement here but conserves 'if' statements
            if (run > 0 && lightdark[run-1] != Robot.onDark()) {
                if (Robot.onDark()) {Robot.makeLight();}
                else {Robot.makeDark();}
            }
        }
        if (row<10) {Robot.move();}
    }
  }
  
  //Don't run these. I will!
  public static void testLightCandles3()
  {
    Robot.load("candles3.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles4()
  {
    Robot.load("candles4.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  public static void testCompleteRoom3()
  {
     Robot.load("room3.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  public static void testCompleteRoom4()
  {
    Robot.load("room4.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  public static void testSwapAll3()
  {
    Robot.load("swap3.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll4()
  {
    Robot.load("swap4.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
}