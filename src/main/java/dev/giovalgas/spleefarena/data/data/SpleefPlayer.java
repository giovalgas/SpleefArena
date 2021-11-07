package dev.giovalgas.spleefarena.data.data;

import dev.giovalgas.spleefarena.data.items.Snowballs;
import dev.giovalgas.spleefarena.data.items.SpleefShovel;
import dev.giovalgas.spleefarena.SpleefArena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

public class SpleefPlayer {

  private SpleefArena plugin = SpleefArena.getInstance();
  private Player player;
  private Location resetLocation;

  // Player info
  private ItemStack[] inventoryContents;
  private ItemStack[] armorContents;
  private Collection<PotionEffect> potionEffects;

  public SpleefPlayer(Player player) {
    this.player = player;

    this.resetLocation = new Location(Bukkit.getWorld("world"),
            plugin.getConfigManager().getResetLocation()[0],
            plugin.getConfigManager().getResetLocation()[1],
            plugin.getConfigManager().getResetLocation()[2]
    );

    this.loadPlayer();
  }

  private void loadPlayer() {
    this.inventoryContents = player.getInventory().getContents();
    this.armorContents = player.getInventory().getArmorContents();
    this.potionEffects = player.getActivePotionEffects();
    this.giveKit();
  }

  public void resetPlayer() {
    player.getInventory().setArmorContents(armorContents);
    player.getInventory().setContents(inventoryContents);
    player.addPotionEffects(potionEffects);
    player.teleport(resetLocation);
  }

  public void killPlayer() {
    plugin.removePlayerFromArena(player);
  }

  private void giveKit() {
    ItemStack shovel = SpleefShovel.getSpleefShovel();
    ItemStack snowballs = Snowballs.getSnowball(plugin.getConfigManager().getSnowballStartAmount());

    player.getInventory().setContents(new ItemStack[]{shovel,snowballs});
  }

  public Player getPlayer() {
    return player;
  }

}
