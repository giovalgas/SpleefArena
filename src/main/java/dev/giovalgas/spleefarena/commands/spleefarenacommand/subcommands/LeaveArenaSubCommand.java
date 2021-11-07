package dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands;

import dev.giovalgas.spleefarena.commands.SubCommand;
import dev.giovalgas.spleefarena.SpleefArena;
import dev.giovalgas.spleefarena.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LeaveArenaSubCommand implements SubCommand {
  @Override
  public void executeCommand(CommandSender sender, String[] args, SpleefArena plugin) {

    Player player = (Player) sender;
    if(plugin.getSpleefPlayer(player) != null) {
      plugin.removePlayerFromArena(player);
      player.sendMessage(plugin.getLanguageManager().getLeftSpleef());
    }else{
      player.sendMessage(plugin.getLanguageManager().getHelp());
    }

  }

  @Override
  public @NotNull String getPermission() {
    return Permission.LEAVE;
  }

  @Override
  public @Nullable String[] getArguments() {
    return new String[0];
  }
}
