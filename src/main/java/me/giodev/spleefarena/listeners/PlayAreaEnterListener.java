package me.giodev.spleefarena.listeners;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import me.giodev.spleefarena.utils.WorldGuardUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayAreaEnterListener implements Listener {

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {

    Player player = event.getPlayer();

    if(WorldGuardUtil.isPlayerInRegion(event.getTo(), SetPlayAreaSubCommand.AREA_KEY) &&
            !(WorldGuardUtil.isPlayerInRegion(event.getFrom(), SetPlayAreaSubCommand.AREA_KEY))
    ) {
      // Handle player entering the minigame
    }

  }


}

