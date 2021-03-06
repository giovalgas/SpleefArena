package dev.giovalgas.spleefarena.commands.spleefarenacommand;

import dev.giovalgas.spleefarena.SpleefArena;
import dev.giovalgas.spleefarena.commands.BaseCommand;
import dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands.AddLayerSubCommand;
import dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands.ConfigReloadSubCommand;
import dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands.LeaveArenaSubCommand;
import dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands.SetPlayAreaSubCommand;
import dev.giovalgas.spleefarena.data.permissions.Permission;
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
    subCommands.put("LEAVE", new LeaveArenaSubCommand());
  }


  @Override
  public void executeStockSubCommand(CommandSender sender) {
    sender.sendMessage(plugin.getLanguageManager().getHelp());
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
