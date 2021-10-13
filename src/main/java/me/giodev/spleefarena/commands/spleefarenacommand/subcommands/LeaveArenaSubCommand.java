package me.giodev.spleefarena.commands.spleefarenacommand.subcommands;

import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.commands.SubCommand;
import me.giodev.spleefarena.data.permissions.Permission;
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
    }else{
      System.out.println("Not in arena");
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
