package me.giodev.spleefarena.data.language;

import com.cryptomorin.xseries.XSound;
import org.bukkit.ChatColor;

public class LanguageDefaults {

  //messages
  public static final String MESSAGE_PREFIX = "&c[&6SpleefArena&c] ";
  public static final String NO_PERMISSION = MESSAGE_PREFIX + "&cYou don't have the permission needed to execute that command.";
  public static final String[] HELP = {
          "&8&m---------------------------------",
          "&e&lSpleefArena",
          "&7▪ &e/sa &7- Displays this list",
          "&7▪ &e/sa leave &7- Leaves the spleef arena",
          "&8&m---------------------------------"
  };
  public static final String CONFIG_RELOADED = MESSAGE_PREFIX + "&eReloaded the config file!";
  public static final String[] JOINED_SPLEEF = {
          "&eYou have joined the spleef arena!",
          "&eType &b/sa leave &eto leave"
  };
  public static final String LEFT_SPLEEF = MESSAGE_PREFIX + "&eYou have left the spleef arena";
  public static final String DEATH_MESSAGE = MESSAGE_PREFIX + "&eYou have died in the spleef arena.";
  public static final String PLAY_AREA_SET = MESSAGE_PREFIX + "&eSuccessfully set the arena area!";
  public static final String LAYER_ADDED = MESSAGE_PREFIX + "&eSuccessfully added a new snow layer!";
  public static final String SELECTION_ERROR = MESSAGE_PREFIX + "&cYou need to make a selection first.";

  //sounds

}
