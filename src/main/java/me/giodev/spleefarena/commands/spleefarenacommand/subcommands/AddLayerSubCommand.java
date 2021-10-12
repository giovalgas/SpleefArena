package me.giodev.spleefarena.commands.spleefarenacommand.subcommands;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.commands.SubCommand;
import me.giodev.spleefarena.data.permissions.Permission;
import me.giodev.spleefarena.utils.WorldEditUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AddLayerSubCommand implements SubCommand {
  @Override
  public void executeCommand(CommandSender sender, String[] args, SpleefArena plugin) {

    Player player = (Player) sender;
    plugin.getArenaManager().addLayer(WorldEditUtil.getPlayerSelection(BukkitAdapter.adapt(player)));
    //TODO -> Add messages
    plugin.getLog().info("Added a layer");

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
