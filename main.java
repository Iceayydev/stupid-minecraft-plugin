// WELCOME to the SUPER COOL minecraft /spawn plugin
// wait you expected a jar file??? ill make you jar file, NOT it takes like a whole 5 min.
// as of febuary 22nd at 10:52AM this plugin WORKS for some reason.
// questions? concerns as to how i wrote working java code? dial 1-800-4-ICEAYY thats 1-800-4-ICEAYY

// ICEAYY WTF why are YOU making a minecraft plugin that already exists??
// my response:
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

    // plugin enable event (might need this idk) still questioning this
    @Override
    public void onEnable() {
        getLogger().info("spawn command enable"); // not making it enable(d) im keeping it like it is, gotta save the bytes. :muscule: :heart: #savethebytes
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    // plugin disable event (when will this ever be needed)   note to self it was needed thanks past tense iceayy
    @Override
    public void onDisable() {
        getLogger().info("spawn command disabled");
    }

    // listener for commands. thanks u/mylittleponycoderfan420 for this!!
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        // player who issued cmd
        Player player = event.getPlayer();
        // get command requested
        String command = event.getMessage();

        // check if cmd is /spawn
        if (command.startsWith("/spawn")) {
            // prevent normal execution
            event.setCancelled(true); // checkmate

            // get the world. originally this said "get the wold" but i changed it because i can(icann.org)
            World world = player.getWorld();
            // location object
            Location spawn = new Location(world, x, y, z);

            // check if valid. NOT A REFERENCE TO THAT TWITTER ACCOUNT111!!!
            if (spawn == null) {
                // worlds best error handling. 
                // him: how much Stack Overflow® do you need??? me:
                player.sendMessage("Error: Failed to teleport to requested location (" + x + ", " + y + ", " + z + ")");
                return;
            }

            // if valid, teleport.
            player.teleport(spawn);
        }
    }
}
