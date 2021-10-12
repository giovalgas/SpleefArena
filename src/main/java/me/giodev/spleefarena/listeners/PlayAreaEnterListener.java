package me.giodev.spleefarena.listeners;

import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import me.giodev.spleefarena.utils.WorldGuardUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayAreaEnterListener implements Listener {

  private SpleefArena plugin;

  public PlayAreaEnterListener(SpleefArena plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {

    if(event.getFrom().distance(event.getTo()) == 0) return;

    Player player = event.getPlayer();

    if(WorldGuardUtil.isLocationInRegion(event.getTo(), SetPlayAreaSubCommand.AREA_KEY) &&
            !(WorldGuardUtil.isLocationInRegion(event.getFrom(), SetPlayAreaSubCommand.AREA_KEY))
    ) {
      plugin.addPlayerToArena(player);
      player.sendMessage("Joined Spleef"); //TODO -> Add messages
    }

  }


}

