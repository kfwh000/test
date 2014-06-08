/***
 * Excerpted from "Learn to Program with Minecraft Plugins",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/ahmine for more book information.
***/
package cowshooter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
public class CowTask extends BukkitRunnable {
    private World world;
    //private Cow cow;
    private Creeper creeper;
    public CowTask(World myWorld, Creeper myCreeper) {
        world = myWorld;
        creeper = myCreeper;
    }
    public void run() {
      if (creeper.isOnGround()) {
        world.createExplosion(creeper.getLocation(), 4f, true);
        cancel();
      } else {
        creeper.setFireTicks(20);
        creeper.setHealth(creeper.getMaxHealth());
      }
    }
}
