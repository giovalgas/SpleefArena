package me.giodev.spleefarena.listeners;

import com.cryptomorin.xseries.XMaterial;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import me.giodev.spleefarena.utils.WorldGuardUtil;
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
