package dev.giovalgas.spleefarena.listeners;

import dev.giovalgas.spleefarena.SpleefArena;
import dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import dev.giovalgas.spleefarena.utils.WorldGuardUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpleefPlayerDeathListener implements Listener {

  private SpleefArena plugin = SpleefArena.getInstance();

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
    if(event.getFrom().distance(event.getTo()) == 0 || plugin.getSpleefPlayer(event.getPlayer()) == null) return;

    Player player = event.getPlayer();
    int deathY = plugin.getConfigManager().getDeathHeight();

    if(event.getTo().getY() <= deathY && WorldGuardUtil.isLocationInRegion(event.getFrom(), SetPlayAreaSubCommand.AREA_KEY)) {
      plugin.getSpleefPlayer(player).killPlayer();
      player.sendMessage(plugin.getLanguageManager().getDeathMessage());
    }

  }

}
