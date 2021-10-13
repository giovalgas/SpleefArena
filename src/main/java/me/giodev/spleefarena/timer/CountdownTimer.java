package me.giodev.spleefarena.timer;

import com.sk89q.worldedit.MaxChangedBlocksException;
import me.giodev.spleefarena.SpleefArena;

public class CountdownTimer implements Runnable {

  private SpleefArena plugin;
  private int secondsRemaining;

  public CountdownTimer(SpleefArena plugin) {
    this.plugin = plugin;
    this.secondsRemaining = plugin.getConfigManager().getResetTimer();
  }

  @Override
  public void run() {

    if(secondsRemaining == 0){
      this.onDisable();
    }

    secondsRemaining--;

  }

  public void resetTimer() {
    secondsRemaining = plugin.getConfigManager().getResetTimer();
  }

  public void onDisable() {
    try {
      plugin.getArenaManager().resetArena();
    } catch (MaxChangedBlocksException e) {
      e.printStackTrace();
    }
  }

}
