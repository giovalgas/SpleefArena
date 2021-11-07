package dev.giovalgas.spleefarena.timer;

import com.sk89q.worldedit.MaxChangedBlocksException;
import dev.giovalgas.spleefarena.SpleefArena;

public class CountdownTimer implements Runnable {

  private SpleefArena plugin = SpleefArena.getInstance();
  private int secondsRemaining;

  public CountdownTimer(SpleefArena plugin) { ;
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
