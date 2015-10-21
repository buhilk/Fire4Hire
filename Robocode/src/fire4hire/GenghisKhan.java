/*
 *                 IFS Research & Development
 *
 *  This program is protected by copyright law and by international
 *  conventions. All licensing, renting, lending or copying (including
 *  for private use), and all other use of the program, which is not
 *  expressively permitted by IFS Research & Development (IFS), is a
 *  violation of the rights of IFS. Such violations will be reported to the
 *  appropriate authorities.
 *
 *  VIOLATIONS OF ANY COPYRIGHT IS PUNISHABLE BY LAW AND CAN LEAD
 *  TO UP TO TWO YEARS OF IMPRISONMENT AND LIABILITY TO PAY DAMAGES.
 */

package fire4hire;

import robocode.*;
import java.awt.Color;

/**
 * Created by buhilk on 14/10/2015.
 */
public class GenghisKhan extends AdvancedRobot{
   double battleFieldHeight;
   double battleFieldWidth;
   double heading;
   private boolean atTheWall = false;

   public void run() {
      // Initialization of the robot should be put here
      setColors(Color.DARK_GRAY,Color.DARK_GRAY,Color.WHITE); // body,gun,radar
      setBulletColor(Color.MAGENTA);
      battleFieldHeight = getBattleFieldHeight();
      battleFieldWidth = getBattleFieldWidth();
      heading = getHeading();

      if(heading <= 180){
         turnLeft(heading);
      } else{
         turnRight(360-heading);
      }
      ahead(battleFieldHeight);

      // Robot main loop
      while(atTheWall) {
         ahead(100);
         turnGunRight(360);
      }
   }

   /**
    * onScannedRobot: What to do when you see another robot
    */
   public void onScannedRobot(ScannedRobotEvent e) {
      // Replace the next line with any behavior you would like
      if (e.getDistance() < 100) {
         fire(3);
      } else {
         fire(1);
      }
   }

   /**
    * onHitByBullet: What to do when you're hit by a bullet
    */
   public void onHitByBullet(HitByBulletEvent e) {
      // Replace the next line with any behavior you would like
   }

   /**
    * onHitWall: What to do when you hit a wall
    */
   public void onHitWall(HitWallEvent e) {
      // Replace the next line with any behavior you would like
      back(100);
      turnRight(90);
      atTheWall = true;
   }

   private void randomMovement() {
      double fwd = Math.random() * 200;
      ahead(fwd);
   }

   @Override
   public String getName() {
      return "Sir Genghis Khan";
   }
}
