import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;
// import my nuts

public class SpawnCommand extends JavaPlugin implements Listener {

    // the coords
    private int x = 0;
    private int y = 0;
    private int z = 0;

    // plugin enable event (might need this idk)
    @Override
    public void onEnable() {
        getLogger().info("spawn command enable");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    // plugin disable event (when will this ever be needed)
    @Override
    public void onDisable() {
        getLogger().info("spawn command disabled");
    }

    // listener for commands
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        // player who issued cmd
        Player player = event.getPlayer();
        // get command requested
        String command = event.getMessage();

        // check if cmd is /spawn
        if (command.startsWith("/spawn")) {
            // prevent normal execution
            event.setCancelled(true);

            // get the wold
            World world = player.getWorld();
            // location object
            Location spawn = new Location(world, x, y, z);

            // check if valid
            if (spawn == null) {
                // worlds best error handling
                player.sendMessage("Error: Failed to teleport to requested location (" + x + ", " + y + ", " + z + ")");
                return;
            }

            // if valid, teleport.
            player.teleport(spawn);
        }
    }
}
