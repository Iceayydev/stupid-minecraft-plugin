// WELCOME to the SUPER COOL minecraft /spawn plugin
// wait you expected a jar file??? ill make you jar file, NOT it takes like a whole 5 min.
// as of febuary 22nd at 10:52AM this plugin WORKS for some reason.
// questions? concerns as to how i wrote working java code? dial 1-800-4-ICEAYY thats 1-800-4-ICEAYY

// ICEAYY WTF why are YOU making a minecraft plugin that already exists??
// my response:
import org.bukkit.Bukkit; // *bucket
import org.bukkit.Location; // uhhm its spelled bucket
import org.bukkit.World; // uhmhm actually is spelled bucket
import org.bukkit.command.Command;// duude its spelled BUCKET
import org.bukkit.command.CommandSender; // ITS SPELLED BUCKET BRO
import org.bukkit.entity.Player; // player: :sunglasses:
import org.bukkit.event.EventHandler; // ITS SPELLED BUCKET WTF IS A "bukkit" BRO
import org.bukkit.event.Listener; // "Hello yes i would like a "Bukkit" please"
import org.bukkit.event.player.PlayerCommandPreprocessEvent; // BRO??
import org.bukkit.plugin.java.JavaPlugin; // YES MY HOMIE????? okay once apon a time i forgot the ; and spent 30 min trying to find it BUT my vs code was silly at the time so NO ERRORS were showing and it took me like 30 minutes to fint he thing that took me 30 munutes because it took like 30 minutes to find because it was 30 minutes!
// import org.iceayy.fatnuts.nuts.massivenuts02;

public class SpawnCommand extends JavaPlugin implements Listener { // his ass is not listeninng. his ass:

    // the coords
    private int x = 0; // geometry dash extreme demon
    private int y = 0; // geometry dash extreme demon
    private int z = 0; // geometry dash extreme demon

    // plugin enable event (might need this idk) still questioning this
    @Override
    public void onEnable() { // the void
        getLogger().info("spawn command enable"); // im not adding the d to enabled to make it correct english i need to conserve bits, #savethebits
        Bukkit.getServer().getPluginManager().registerEvents(this, this); // this this
    }

    // plugin disable event (when will this ever be needed)   note to self it was needed thanks past tense iceayy
    @Override
    public void onDisable() {
        getLogger().info("spawn command disabled"); // this is racism because the enable one doesnt have the d on it so its not correct english what a fuckign faillure loser.
    }

    // listener for commands. thanks u/mylittleponycoderfan420 for this!!
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) { // me when said player attempts to issue a command:
        // player who issued cmd
        Player player = event.getPlayer(); // Player player = event.getPlayer.IPv4Adress(); player.sendMessage("your ip adress is" +IPv4Adress+ "lolol!");
        // get command requested
        String command = event.getMessage(); // *radio noise* got message, over

        // check if cmd is /spawn
        if (command.startsWith("/spawn")) { // imagine i changed this to /BALLSYESBALLSHOLYCRAPILOVEBALLSIWOULDEAT100000BALLSRIGHTNOW
            // prevent normal execution
            event.setCancelled(true); // checkmate

            // get the world. originally this said "get the wold" but i changed it because i can(icann.org)
            World world = player.getWorld();
            // location object
            Location spawn = new Location(world, x, y, z); // imagine i changed it from the variables to -172788821, 0, 278012327 lolol that would be funny

            // check if valid. NOT A REFERENCE TO THAT TWITTER ACCOUNT111!!!
            if (spawn == null) {
                // worlds best error handling. 
                // him: how much Stack Overflow® do you need??? me:
                player.sendMessage("Error: Failed to teleport to requested location (" + x + ", " + y + ", " + z + ")"); // lets hope we never need this, may god be with you should the teleport fail :(
                return;
            }

            // if valid, teleport.
            player.teleport(spawn); // WOOOOOOOOOOOOO0OOOOOOOOOOOOOOOOOO find the "0" for 1100 mr beast bucks.
        }
    }
}
