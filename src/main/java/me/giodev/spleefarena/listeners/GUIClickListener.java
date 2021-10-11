package me.giodev.spleefarena.listeners;

import me.giodev.spleefarena.SpleefArena;
import me.giodev.spleefarena.data.gui.BaseGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class GUIClickListener implements Listener {

  private SpleefArena plugin;

  public GUIClickListener(SpleefArena plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onClick(InventoryClickEvent event) {

    InventoryHolder holder = event.getInventory().getHolder();

    if(holder instanceof BaseGUI) {

      event.setCancelled(true);
      plugin.getLanguageManager().getClickSound().play((Player) event.getWhoClicked());

      if(event.getCurrentItem() == null) return;

      BaseGUI gui = (BaseGUI) holder;

      gui.handleClick(event);

    }

  }


}
