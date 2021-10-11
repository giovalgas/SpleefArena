package me.giodev.templateplugin.data.config;

import me.giodev.templateplugin.TemplatePlugin;
import org.bukkit.configuration.InvalidConfigurationException;

public class ConfigManager {

  //Plugin
  private final TemplatePlugin plugin;

  //Config Values
  private String consolePrefix;

  public ConfigManager(TemplatePlugin plugin) throws InvalidConfigurationException {
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
