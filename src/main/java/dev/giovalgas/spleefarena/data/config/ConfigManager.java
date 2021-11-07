package dev.giovalgas.spleefarena.data.config;

import dev.giovalgas.spleefarena.SpleefArena;
import org.bukkit.configuration.InvalidConfigurationException;

public class ConfigManager {

  //Plugin
  private final SpleefArena plugin;

  //Config Values
  private String consolePrefix;
  private int resetTimer;
  private Integer[] resetLocation;
  private int deathHeight;
  private int snowballStartAmount;
  private int snowballBreakAmount;


  public ConfigManager(SpleefArena plugin) throws InvalidConfigurationException {
    this.plugin = plugin;
    load();
  }

  private void load() throws InvalidConfigurationException {
    ConfigFile config = new ConfigFile(plugin);
    config.load();

    this.consolePrefix = config.getString(ConfigKeys.CONSOLE_PREFIX, ConfigDefaults.CONSOLE_PREFIX);
    this.resetTimer = config.getInt(ConfigKeys.RESET_TIMER, ConfigDefaults.RESET_TIMER);
    this.resetLocation = config.getIntegerList(ConfigKeys.RESET_LOCATION, ConfigDefaults.RESET_LOCATION);
    this.deathHeight = config.getInt(ConfigKeys.DEATH_HEIGHT, ConfigDefaults.DEATH_HEIGHT);
    this.snowballStartAmount = config.getInt(ConfigKeys.SNOWBALLS_START_AMOUNT, ConfigDefaults.SNOWBALLS_START_AMOUNT);
    this.snowballBreakAmount = config.getInt(ConfigKeys.SNOWBALLS_BREAK_AMOUNT, ConfigDefaults.SNOWBALLS_BREAK_AMOUNT);

  }

  public void reload() throws InvalidConfigurationException {
    load();
  }

  public String getConsolePrefix() {
    return consolePrefix;
  }

  public int getResetTimer() {
    return resetTimer;
  }

  public Integer[] getResetLocation() {
    return resetLocation;
  }

  public int getDeathHeight() {
    return deathHeight;
  }

  public int getSnowballStartAmount() {
    return snowballStartAmount;
  }

  public int getSnowballBreakAmount() {
    return snowballBreakAmount;
  }


}
