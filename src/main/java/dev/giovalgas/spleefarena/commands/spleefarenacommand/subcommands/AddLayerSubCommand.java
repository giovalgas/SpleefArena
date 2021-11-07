package dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import dev.giovalgas.spleefarena.commands.SubCommand;
import dev.giovalgas.spleefarena.SpleefArena;
import dev.giovalgas.spleefarena.data.permissions.Permission;
import dev.giovalgas.spleefarena.utils.WorldEditUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AddLayerSubCommand implements SubCommand {
  @Override
  public void executeCommand(CommandSender sender, String[] args, SpleefArena plugin) {

    Player player = (Player) sender;
    plugin.getArenaManager().addLayer(WorldEditUtil.getPlayerSelection(BukkitAdapter.adapt(player)));
    player.sendMessage(plugin.getLanguageManager().getLayerAdded());

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
