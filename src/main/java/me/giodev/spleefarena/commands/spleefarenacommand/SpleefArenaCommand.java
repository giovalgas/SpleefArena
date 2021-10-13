package me.giodev.spleefarena.commands.spleefarenacommand;

import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.commands.BaseCommand;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.AddLayerSubCommand;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.ConfigReloadSubCommand;
import me.giodev.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import me.giodev.spleefarena.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

public class SpleefArenaCommand extends BaseCommand {

  public SpleefArenaCommand(SpleefArena plugin) {
    super(plugin);
    subCommands.put("SETAREA", new SetPlayAreaSubCommand());
    subCommands.put("ADDLAYER", new AddLayerSubCommand());
    subCommands.put("RELOAD", new ConfigReloadSubCommand());
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
    return "spleefarena";
  }


  @Override
  public @NotNull List<String> getAliases() { return Arrays.asList(new String[]{"sa"}.clone()); }

  @Override
  public boolean isPlayerOnly() {
    return true;
  }


}
