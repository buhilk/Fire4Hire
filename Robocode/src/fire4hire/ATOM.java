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

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

import java.awt.*;

/**
 * Created by buhilk on 14/10/2015.
 */
public class ATOM extends AdvancedRobot{
   double battleFieldHeight;
   double battleFieldWidth;
   double targetHeading;
   private boolean atTheWall = false;

   public void run() {
      // Initialization of the robot should be put here
      setColors(Color.DARK_GRAY,Color.DARK_GRAY,Color.WHITE); // body,gun,radar
      setBulletColor(Color.MAGENTA);
      battleFieldHeight = getBattleFieldHeight();
      battleFieldWidth = getBattleFieldWidth();


      // Robot main loop
      while(true) {
         turnGunRight(360);
      }
   }

   /**
    * onScannedRobot: What to do when you see another robot
    */
   public void onScannedRobot(ScannedRobotEvent e) {
      // Replace the next line with any behavior you would like
      fire(1);
   }

   /**
    * onHitByBullet: What to do when you're hit by a bullet
    */
   public void onHitByBullet(HitByBulletEvent e) {
      // Replace the next line with any behavior you would like
      targetHeading = e.getHeading() + 180;
      double heading = this.getHeading();
      turnRight(targetHeading - heading);
      ahead(200);
   }

   /**
    * onHitWall: What to do when you hit a wall
    */
   public void onHitWall(HitWallEvent e) {
      // Replace the next line with any behavior you would like
      back(50);
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
