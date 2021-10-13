package me.giodev.spleefarena.listeners;

import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.session.MoveType;
import com.sk89q.worldguard.session.Session;
import com.sk89q.worldguard.session.handler.Handler;
import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.data.permissions.Permission;
import me.giodev.spleefarena.utils.WorldGuardUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Set;

public class ArenaJoinLeaveHandler extends Handler {

  public static final Factory FACTORY = new Factory();

  public static class Factory extends Handler.Factory<ArenaJoinLeaveHandler> {
    @Override
    public ArenaJoinLeaveHandler create(Session session) {
      return new ArenaJoinLeaveHandler(session);
    }
  }

  protected ArenaJoinLeaveHandler(Session session) {
    super(session);
  }


  @Override
  public boolean onCrossBoundary(LocalPlayer player, Location from, Location to, ApplicableRegionSet toSet, Set<ProtectedRegion> entered, Set<ProtectedRegion> exited, MoveType moveType) {

    if(moveType.isTeleport()) return true;

    Player bukkitPlayer = Bukkit.getPlayer(player.getUniqueId());

    if(entered.contains(WorldGuardUtil.getArenaRegion())) {
      SpleefArena.getInstance().addPlayerToArena(bukkitPlayer);
      bukkitPlayer.sendMessage("Joined Spleef"); //TODO -> Add messages
    }else if(exited.contains(WorldGuardUtil.getArenaRegion())) {
      SpleefArena.getInstance().removePlayerFromArena(bukkitPlayer);
      bukkitPlayer.sendMessage("Left Spleef"); //TODO -> add messages
     }

    return player.hasPermission(Permission.ENTER_ARENA);
  }


}