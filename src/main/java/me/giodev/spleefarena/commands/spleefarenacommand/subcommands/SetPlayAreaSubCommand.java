package me.giodev.spleefarena.commands.spleefarenacommand.subcommands;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.util.formatting.text.TextComponent;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.commands.SubCommand;
import me.giodev.spleefarena.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SetPlayAreaSubCommand implements SubCommand {

  private static final String AREA_KEY = "spleefarena_playableArea";

  @Override
  public void executeCommand(CommandSender sender, String[] args, SpleefArena plugin) {

    //TODO -> Add proper messages

    Player actor = BukkitAdapter.adapt((org.bukkit.entity.Player) sender);
    LocalSession localSession = WorldEdit.getInstance().getSessionManager().get(actor);
    World selectionWorld = localSession.getSelectionWorld();
    Region selection;

    try {
      if(selectionWorld == null) throw new IncompleteRegionException();
      selection = localSession.getSelection(selectionWorld);
    } catch (IncompleteRegionException e) {
      actor.printError(TextComponent.of("Please make a region selection first."));
      return;
    }

    ProtectedCuboidRegion playableArea = new ProtectedCuboidRegion(
            AREA_KEY,
            selection.getMinimumPoint(),
            selection.getMaximumPoint()
    );

    playableArea.setFlag(Flags.GREET_MESSAGE, "Spleef");
    playableArea.setFlag(Flags.PVP, StateFlag.State.DENY);

    RegionManager rm = WorldGuard.getInstance().getPlatform().getRegionContainer().get(selectionWorld);

    if(rm.getRegion(AREA_KEY) != null) {
      rm.removeRegion(AREA_KEY);
    }

    rm.addRegion(playableArea);

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
