package me.giodev.spleefarena.utils;

import com.cryptomorin.xseries.XMaterial;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.block.BlockState;
import com.sk89q.worldedit.world.block.BlockType;
import com.sk89q.worldedit.world.block.BlockTypes;
import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.timer.CountdownTimer;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class ArenaManager {

  private SpleefArena plugin;
  private ArrayList<Region> snowLayers = new ArrayList<>();
  private BukkitTask runnable;
  private CountdownTimer timer;

  public ArenaManager(SpleefArena plugin) {
    this.plugin = plugin;
    this.timer = new CountdownTimer(plugin);
    this.runnable = Bukkit.getScheduler().runTaskTimer(plugin, timer, 0L, 20L);
    //TODO -> get snowLayers from config file
  }

  public void resetArena() throws MaxChangedBlocksException {

    if(snowLayers.size() != 0) {

      EditSession editSession = WorldEdit.getInstance().newEditSession(snowLayers.get(0).getWorld());

      for (Region layer : snowLayers) {
        System.out.println(layer.getMaximumPoint() + " : " + layer.getMinimumPoint());
        editSession.setBlocks(layer, BlockTypes.SNOW_BLOCK.getDefaultState());
        editSession.commit();
      }

      editSession.close();

    }

    timer.resetTimer();
    plugin.getLog().info("Resetting all snow layers in the arena");

  }



  public void addLayer(Region layer) {
    snowLayers.add(layer);
  }

}
