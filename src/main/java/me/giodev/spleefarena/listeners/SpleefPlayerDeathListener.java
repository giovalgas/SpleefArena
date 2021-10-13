package me.giodev.spleefarena.listeners;

import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import me.giodev.spleefarena.utils.WorldGuardUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpleefPlayerDeathListener implements Listener {

  private SpleefArena plugin;

  public SpleefPlayerDeathListener(SpleefArena plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
    if(event.getFrom().distance(event.getTo()) == 0 || plugin.getSpleefPlayer(event.getPlayer()) == null) return;

    Player player = event.getPlayer();
    int deathY = plugin.getConfigManager().getDeathHeight(); //TODO -> add to config file

    if(event.getTo().getY() <= deathY && WorldGuardUtil.isLocationInRegion(event.getFrom(), SetPlayAreaSubCommand.AREA_KEY)) {
      plugin.getSpleefPlayer(player).resetPlayer();
      //TODO -> add messages
    }

  }

}
