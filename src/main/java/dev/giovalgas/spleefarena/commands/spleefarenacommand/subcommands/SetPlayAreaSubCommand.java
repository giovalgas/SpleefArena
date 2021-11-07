package dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import dev.giovalgas.spleefarena.SpleefArena;
import dev.giovalgas.spleefarena.commands.SubCommand;
import dev.giovalgas.spleefarena.data.permissions.Permission;
import dev.giovalgas.spleefarena.utils.WorldEditUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SetPlayAreaSubCommand implements SubCommand {

  public static final String AREA_KEY = "spleefarena_playableArea";

  @Override
  public void executeCommand(CommandSender sender, String[] args, SpleefArena plugin) {

    Player player = (Player) sender;
    Region selection = WorldEditUtil.getPlayerSelection(BukkitAdapter.adapt(player));

    if(selection == null) {
      player.sendMessage(plugin.getLanguageManager().getSelectionError());
      return;
    }

    ProtectedCuboidRegion playableArea = new ProtectedCuboidRegion(
            AREA_KEY,
            selection.getMinimumPoint(),
            selection.getMaximumPoint()
    );

    playableArea.setFlag(Flags.PVP, StateFlag.State.DENY);
    playableArea.setFlag(Flags.HUNGER_DRAIN, StateFlag.State.DENY);
    playableArea.setFlag(Flags.FALL_DAMAGE, StateFlag.State.DENY);
    playableArea.setFlag(Flags.MOB_SPAWNING, StateFlag.State.DENY);

    RegionManager rm = WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(player.getWorld()));

    if(rm.getRegion(AREA_KEY) != null) {
      rm.removeRegion(AREA_KEY);
    }

    plugin.getArenaManager().setArenaWorld(player.getWorld());
    rm.addRegion(playableArea);

    player.sendMessage(plugin.getLanguageManager().getPlayAreaSet());

  }

  @Override
  public @NotNull String getPermission() {
    return Permission.ADMIN;
  }

  @Override
  public @Nullable String[] getArguments() {
    return new String[0];
  }
}
