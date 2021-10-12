package me.giodev.spleefarena;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import it.unimi.dsi.fastutil.Hash;
import jdk.nashorn.internal.ir.Block;
import me.giodev.spleefarena.commands.BaseCommand;
import me.giodev.spleefarena.commands.spleefarenacommand.SpleefArenaCommand;
import me.giodev.spleefarena.data.config.ConfigManager;
import me.giodev.spleefarena.data.data.SpleefPlayer;
import me.giodev.spleefarena.data.language.LanguageManager;
import me.giodev.spleefarena.listeners.*;
import me.giodev.spleefarena.utils.ArenaManager;
import me.giodev.spleefarena.utils.LoggerUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;


public final class SpleefArena extends JavaPlugin {

  private ConfigManager configManager;
  private LanguageManager languageManager;
  private LoggerUtil log;
  private WorldGuardPlugin worldGuard;
  private WorldEditPlugin worldEdit;
  private HashMap<UUID, SpleefPlayer> playersInArena = new HashMap<>();
  private ArenaManager arenaManager;

  @Override
  public void onEnable() {
    //Load config, language & logger
    loadConfig();
    loadLang();
    log = new LoggerUtil(this);

    //Commands, Events & Dependencies
    loadCommands();
    loadEvents();
    loadDependencies();

    arenaManager = new ArenaManager(this);
    log.info("Plugin fully started!");
  }

  private void loadDependencies() {
    this.worldGuard = loadWorldGuard();
    this.worldEdit = loadWorldEdit();
  }

  @Override
  public void onDisable() {
    log.info("Resetting all players");

    for(SpleefPlayer sp : playersInArena.values()) {
      sp.resetPlayer();
    }

    arenaManager.cancelRunnable();
    arenaManager.saveArenaInfo();

  }

  private void loadEvents() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new PlayAreaEnterListener(this), this);
    pm.registerEvents(new PlayAreaLeaveListener(this), this);
    pm.registerEvents(new SpleefPlayerDeathListener(this),this);
    pm.registerEvents(new SnowballListener(), this);
    pm.registerEvents(new BlockBreakListener(), this);
  }

  private void loadCommands() {
    loadCommand(new SpleefArenaCommand(this));
  }

  private void loadCommand(BaseCommand command) {
    getCommand(command.getName()).setExecutor(command);
    getCommand(command.getName()).setTabCompleter(command);
    getCommand(command.getName()).setAliases(command.getAliases());
  }

  private void loadConfig(){
    try {
      this.configManager = new ConfigManager(this);
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  private void loadLang(){
    try {
      this.languageManager = new LanguageManager(this);
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  public void addPlayerToArena(Player player) {
    if(playersInArena.get(player.getUniqueId()) != null) return;
    playersInArena.put(player.getUniqueId(), new SpleefPlayer(this, player));
  }

  public void removePlayerFromArena(Player player) {
    if(playersInArena.get(player.getUniqueId()) == null) return;

    SpleefPlayer spleefPlayer = playersInArena.get(player.getUniqueId());
    spleefPlayer.resetPlayer();

    playersInArena.remove(player.getUniqueId());

  }

  public SpleefPlayer getSpleefPlayer(Player player) {
    return playersInArena.get(player.getUniqueId());
  }

  private WorldGuardPlugin loadWorldGuard() {
    WorldGuardPlugin plugin = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");

    if(plugin == null) {
      log.severe("Did not find WorldGuard dependency disabling this plugin");
      Bukkit.getPluginManager().disablePlugin(this);
    }
    return plugin;
  }

  private WorldEditPlugin loadWorldEdit() {
    WorldEditPlugin plugin = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

    if(plugin == null) {
      log.severe("Did not find WorldEdit depency disabling this plugin");
      Bukkit.getPluginManager().disablePlugin(this);
    }

    return plugin;

  }

  public ArenaManager getArenaManager() { return arenaManager; }
  public WorldGuardPlugin getWorldGuard() { return worldGuard; }
  public LoggerUtil getLog() { return log; }
  public ConfigManager getConfigManager() { return configManager; }
  public LanguageManager getLanguageManager() { return languageManager; }

}
