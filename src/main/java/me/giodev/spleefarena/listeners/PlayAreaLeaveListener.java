package me.giodev.spleefarena.listeners;

import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import me.giodev.spleefarena.utils.WorldGuardUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayAreaLeaveListener implements Listener {

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {

    if(event.getFrom().distance(event.getTo()) == 0) return;

    Player player = event.getPlayer();

    if(WorldGuardUtil.isPlayerInRegion(event.getFrom(), SetPlayAreaSubCommand.AREA_KEY) &&
            !(WorldGuardUtil.isPlayerInRegion(event.getTo(), SetPlayAreaSubCommand.AREA_KEY))
    ) {
      player.sendMessage("SAIU SPLEEF");
    }

  }

}
