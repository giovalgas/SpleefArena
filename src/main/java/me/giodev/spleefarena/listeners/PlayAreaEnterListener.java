package me.giodev.spleefarena.listeners;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayAreaEnterListener implements Listener {

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {

    Player player = event.getPlayer();

    if(inRegion(event.getTo()) && !(inRegion(event.getFrom()))) {
      // Handle player entering the minigame
    }

  }

  private boolean inRegion(Location loc) {
    World world = BukkitAdapter.adapt(loc.getWorld());
    RegionManager rm = WorldGuard.getInstance().getPlatform().getRegionContainer().get(world);
    ApplicableRegionSet set = rm.getApplicableRegions(BlockVector3.at(loc.getX(), loc.getY(), loc.getZ()));

    return set.getRegions().contains(rm.getRegion(SetPlayAreaSubCommand.AREA_KEY));
  }

}

