package dev.giovalgas.spleefarena.commands;


import dev.giovalgas.spleefarena.SpleefArena;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SubCommand {
  void executeCommand(CommandSender sender, String[] args, SpleefArena plugin);

  @NotNull String getPermission();

  @Nullable String[] getArguments();

}
