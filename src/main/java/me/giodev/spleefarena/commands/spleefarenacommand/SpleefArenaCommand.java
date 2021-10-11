package me.giodev.spleefarena.commands.spleefarenacommand;

import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.commands.BaseCommand;
import me.giodev.spleefarena.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

public class SpleefArenaCommand extends BaseCommand {

  public SpleefArenaCommand(SpleefArena plugin) {
    super(plugin);
  }


  @Override
  public void executeStockSubCommand(CommandSender sender) {
    plugin.getLog().info("executing stock command!");
  }

  @Override
  public @NotNull String getPermission() {
    return Permission.SA_COMMAND;
  }

  @Override
  public @NotNull String getName() {
    return "excommand";
  }


  @Override
  public @NotNull List<String> getAliases() { return Arrays.asList(new String[]{"excmd"}.clone()); }

  @Override
  public boolean isPlayerOnly() {
    return false;
  }


}
