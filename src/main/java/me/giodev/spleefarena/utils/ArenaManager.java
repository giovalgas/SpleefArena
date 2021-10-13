package me.giodev.spleefarena.utils;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import com.sk89q.worldedit.world.block.BlockTypes;
import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.timer.CountdownTimer;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaManager {

  private SpleefArena plugin = SpleefArena.getInstance();
  private ArrayList<Region> snowLayers = new ArrayList<>();
  private BukkitTask runnable;
  private CountdownTimer timer;
  private YamlConfiguration arenaInfo;

  private static World arenaWorld;

  public ArenaManager() {
    this.timer = new CountdownTimer(plugin);
    this.runnable = Bukkit.getScheduler().runTaskTimer(plugin, timer, 0L, 20L);
    this.arenaInfo = new YamlConfiguration();
    this.loadArenaInfo();

  }

  private void loadArenaInfo() {

    File arenaInfoFile = new File(plugin.getDataFolder(), "arena.yml");

    if(!arenaInfoFile.exists()){
      FileManager.loadResource(plugin, "arena.yml");
    }

    try {
      arenaInfo.load(arenaInfoFile);
    } catch (IOException | InvalidConfigurationException e) {
      e.printStackTrace();
    }

    arenaWorld = Bukkit.getWorld(arenaInfo.getString("arena.world"));

    loadSnowLayers();

  }

  private void loadSnowLayers() {
    ConfigurationSection layerSection = arenaInfo.getConfigurationSection("snow-layers");

    if(layerSection == null) return;

    for(String key : layerSection.getKeys(false)) {

      List<Integer> configPos1 = layerSection.getIntegerList(key + ".pos1");
      List<Integer> configPos2 = layerSection.getIntegerList(key + ".pos2");

      BlockVector3 pos1 = BlockVector3.at( configPos1.get(0), configPos1.get(1), configPos1.get(2));
      BlockVector3 pos2 = BlockVector3.at( configPos2.get(0), configPos2.get(1), configPos2.get(2));

      addLayer(new CuboidRegion(BukkitAdapter.adapt(arenaWorld), pos1, pos2));

    }

  }

  private void saveSnowLayers() {

    ConfigurationSection layerSection = arenaInfo.createSection("snow-layers");

    for(int i = 0; i < snowLayers.size(); i++) {

      Region region = snowLayers.get(i);

      layerSection.set(i + ".pos1", blockVectorToStringList(region.getMaximumPoint()));
      layerSection.set(i + ".pos2", blockVectorToStringList(region.getMinimumPoint()));

    }

  }

  private List<Integer> blockVectorToStringList(BlockVector3 blockVector3) {
    List<Integer> loc = new ArrayList<>();

    loc.add(blockVector3.getBlockX());
    loc.add(blockVector3.getBlockY());
    loc.add(blockVector3.getBlockZ());

    return loc;
  }

  public void resetArena() throws MaxChangedBlocksException {

    if(snowLayers.size() != 0) {

      EditSession editSession = WorldEdit.getInstance().newEditSession(snowLayers.get(0).getWorld());

      for (Region layer : snowLayers) {
        editSession.setBlocks(layer, BlockTypes.SNOW_BLOCK.getDefaultState());
        editSession.commit();
      }

      editSession.close();

    }

    timer.resetTimer();
    plugin.getLog().info("Resetting all snow layers in the arena");

  }

  public void saveArenaInfo() {

    this.saveSnowLayers();

    arenaInfo.options().copyDefaults(true);

    try {
      arenaInfo.save(new File(plugin.getDataFolder(), "arena.yml"));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void setArenaWorld(World world) {
    arenaWorld = world;
    arenaInfo.set("arena.world", world.getName());
  }

  public void cancelRunnable() {
    runnable.cancel();
  }

  public static World getArenaWorld() {
    return arenaWorld;
  }

  public void addLayer(Region layer) {
    snowLayers.add(layer);
  }

}
