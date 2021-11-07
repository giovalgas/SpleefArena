package dev.giovalgas.spleefarena.listeners;

import com.cryptomorin.xseries.XMaterial;
import dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import dev.giovalgas.spleefarena.utils.WorldGuardUtil;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SnowballListener implements Listener {

  @EventHandler
  public void onProjectileHit(ProjectileHitEvent event) {
    if(!WorldGuardUtil.isLocationInRegion(event.getHitBlock().getLocation(), SetPlayAreaSubCommand.AREA_KEY)) return;

    if(event.getEntity() instanceof Snowball && event.getHitBlock().getType() == XMaterial.SNOW_BLOCK.parseMaterial()) {
      event.getHitBlock().setType(XMaterial.AIR.parseMaterial());
    }

  }

}
