package dev.giovalgas.spleefarena.listeners;

import com.cryptomorin.xseries.XMaterial;
import dev.giovalgas.spleefarena.SpleefArena;
import dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import dev.giovalgas.spleefarena.data.items.Snowballs;
import dev.giovalgas.spleefarena.utils.WorldGuardUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

  private SpleefArena plugin = SpleefArena.getInstance();

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    if(!WorldGuardUtil.isLocationInRegion(event.getBlock().getLocation(), SetPlayAreaSubCommand.AREA_KEY) || event.getBlock() == null) return;

    event.setCancelled(true);
    event.getBlock().setType(XMaterial.AIR.parseMaterial());

    event.getPlayer().getInventory().addItem(Snowballs.getSnowball(plugin.getConfigManager().getSnowballBreakAmount()));

  }

}
