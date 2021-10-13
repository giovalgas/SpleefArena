package me.giodev.spleefarena.utils;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import org.bukkit.Location;

public class WorldGuardUtil {

  public static boolean isLocationInRegion(Location playerLocation, String areaKey) {
    World world = BukkitAdapter.adapt(playerLocation.getWorld());
    RegionManager rm = WorldGuard.getInstance().getPlatform().getRegionContainer().get(world);
    ApplicableRegionSet set = rm.getApplicableRegions(BlockVector3.at(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ()));

    return set.getRegions().contains(rm.getRegion(areaKey));
  }

  public static ProtectedRegion getArenaRegion(
  ) {
    return WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(ArenaManager.getArenaWorld())).getRegion(SetPlayAreaSubCommand.AREA_KEY);
  }

}
