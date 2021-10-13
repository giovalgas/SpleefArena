package me.giodev.spleefarena.data.language;

import com.cryptomorin.xseries.XSound;
import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.utils.FileManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LanguageManager {

  private SpleefArena plugin;
  private YamlConfiguration langFileConfig;

  //Messages
  private String chatPrefix;
  private String noPermission;
  private String[] help;
  private String configReloaded;
  private String[] joinedSpleef;
  private String leftSpleef;
  private String deathMessage;
  private String playAreaSet;
  private String layerAdded;
  private String selectionError;

  //Sounds

  public LanguageManager(SpleefArena plugin) throws InvalidConfigurationException {
    this.plugin = plugin;
    load();
  }

  private void load() throws InvalidConfigurationException {
    File langFile = new File(plugin.getDataFolder(), "language.yml");
    this.langFileConfig = new YamlConfiguration();

    if (!langFile.exists()) {
      FileManager.loadResource(plugin, "language.yml");
    }

    try {
      langFileConfig.load(langFile);
    } catch (IOException | InvalidConfigurationException e) {
      e.printStackTrace();
    }

    loadValues();

  }

  private void loadValues() throws InvalidConfigurationException {
    //Messages
    this.chatPrefix = getString(LanguageKeys.MESSAGE_PREFIX, LanguageDefaults.MESSAGE_PREFIX);
    this.noPermission = chatPrefix + getString(LanguageKeys.NO_PERMISSION, LanguageDefaults.NO_PERMISSION);
    this.help = getStringList(LanguageKeys.HELP, LanguageDefaults.HELP);
    this.configReloaded = getString(LanguageKeys.CONFIG_RELOADED, LanguageDefaults.CONFIG_RELOADED);
    this.joinedSpleef = getStringList(LanguageKeys.JOINED_SPLEEF, LanguageDefaults.JOINED_SPLEEF);
    this.leftSpleef = getString(LanguageKeys.LEFT_SPLEEF, LanguageDefaults.LEFT_SPLEEF);
    this.deathMessage = getString(LanguageKeys.DEATH_MESSAGE, LanguageDefaults.DEATH_MESSAGE);
    this.playAreaSet = getString(LanguageKeys.PLAY_AREA_SET, LanguageDefaults.PLAY_AREA_SET);
    this.layerAdded = getString(LanguageKeys.LAYER_ADDED, LanguageDefaults.LAYER_ADDED);
    this.selectionError = getString(LanguageKeys.LAYER_ADDED, LanguageDefaults.LAYER_ADDED);

    //Sounds

  }

  private String getString(String p, String defaultString) throws InvalidConfigurationException {
    if(langFileConfig.isString(p)) {
      return langFileConfig.getString(p).replace('&', '§');
    } else if(langFileConfig.contains(p)){
      throw new InvalidConfigurationException("'language.yml' at path:" + p + "' is not a string");
    }else {
      langFileConfig.set(p, defaultString);
      return defaultString;
    }
  }

  @SuppressWarnings("unchecked")
  public String[] getStringList(String p, String[] defaultList) throws InvalidConfigurationException {
    if (langFileConfig.isList(p)) {
      List<?> unknownList = langFileConfig.getList(p);

      ArrayList<String> stringList = new ArrayList(unknownList.size());
      Iterator it = unknownList.iterator();

      while(it.hasNext()) {
        Object obj = it.next();
        if (obj instanceof String) {
          stringList.add((String) ((String) obj).replace("&", "§"));
        } else {
          if (!(obj instanceof Double) && !(obj instanceof Integer) && !(obj instanceof Boolean)) {
            throw new InvalidConfigurationException("'" + langFileConfig.getName() + "' at path: '" + p + "' is not a string list");
          }

          stringList.add(obj.toString());
        }
      }

      return (String[])stringList.toArray(new String[0]);
    } else if (langFileConfig.contains(p)) {
      throw new InvalidConfigurationException("'" + langFileConfig.getName() + "' at path: '" + p + "' is not a list");
    } else {
      langFileConfig.set(p, defaultList);
      return defaultList;
    }
  }

  private XSound getSound(String p, XSound defaultSound) throws InvalidConfigurationException {
    try{
      return XSound.matchXSound(langFileConfig.getString(p)).get();
    }catch (IllegalArgumentException e){
      throw new InvalidConfigurationException("'Language.yml' the value specified in " + p + "is not a sound", e);
    }
  }

  public String[] getHelp() {
    return help;
  }

  public String getConfigReloaded() {
    return configReloaded;
  }

  public String[] getJoinedSpleef() {
    return joinedSpleef;
  }

  public String getLeftSpleef() {
    return leftSpleef;
  }

  public String getDeathMessage() {
    return deathMessage;
  }

  public String getPlayAreaSet() {
    return playAreaSet;
  }

  public String getLayerAdded() {
    return layerAdded;
  }

  public String getSelectionError() {
    return selectionError;
  }

  public String getNoPermission() {
    return noPermission;
  }

  public String getChatPrefix() {
    return chatPrefix;
  }

}
