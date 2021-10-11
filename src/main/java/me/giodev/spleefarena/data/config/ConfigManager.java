package me.giodev.spleefarena.data.config;

import me.giodev.spleefarena.SpleefArena;
import org.bukkit.configuration.InvalidConfigurationException;

public class ConfigManager {

  //Plugin
  private final SpleefArena plugin;

  //Config Values
  private String consolePrefix;

  public ConfigManager(SpleefArena plugin) throws InvalidConfigurationException {
    this.plugin = plugin;
    load();
  }

  private void load() throws InvalidConfigurationException {
    ConfigFile config = new ConfigFile(plugin);
    config.load();

    this.consolePrefix = config.getString(ConfigKeys.CONSOLE_PREFIX, ConfigDefaults.CONSOLE_PREFIX);

  }

  public void reload() throws InvalidConfigurationException {
    load();
  }

  public String getConsolePrefix() {
    return consolePrefix;
  }

}
