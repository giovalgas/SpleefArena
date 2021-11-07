package dev.giovalgas.spleefarena.commands.spleefarenacommand.subcommands;

import dev.giovalgas.spleefarena.commands.SubCommand;
import dev.giovalgas.spleefarena.SpleefArena;
import dev.giovalgas.spleefarena.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConfigReloadSubCommand implements SubCommand {
  @Override
  public void executeCommand(CommandSender sender, String[] args, SpleefArena plugin) {

    try {
      plugin.getConfigManager().reload();
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }

    sender.sendMessage(plugin.getLanguageManager().getConfigReloaded());

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
