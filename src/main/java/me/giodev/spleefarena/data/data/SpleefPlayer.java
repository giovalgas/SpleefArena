package me.giodev.spleefarena.data.data;

import com.cryptomorin.xseries.XEnchantment;
import com.cryptomorin.xseries.XMaterial;
import me.giodev.spleefarena.SpleefArena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

public class SpleefPlayer {

  private SpleefArena plugin;
  private Player player;
  private Location resetLocation;
  private int deaths;

  // Player info
  private ItemStack[] inventoryContents;
  private ItemStack[] armorContents;
  private Collection<PotionEffect> potionEffects;

  public SpleefPlayer(SpleefArena plugin, Player player) {
    this.plugin = plugin;
    this.player = player;
    this.resetLocation = new Location(Bukkit.getWorld("world"), 750, 69, 1511); //TODO -> add config.yml
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

  private void giveKit() {
    ItemStack shovel = new ItemStack(XMaterial.GOLDEN_SHOVEL.parseMaterial()); {
      ItemMeta shovelMeta = shovel.getItemMeta();
      shovelMeta.setDisplayName(ChatColor.BLUE + "Spleef Shovel");
      shovelMeta.setUnbreakable(true);
      shovelMeta.addEnchant(XEnchantment.DIG_SPEED.parseEnchantment(), 5, false);
      shovel.setItemMeta(shovelMeta);
    }
    ItemStack snowballs = new ItemStack(XMaterial.SNOWBALL.parseMaterial(), 16); {
      ItemMeta snowballMeta = snowballs.getItemMeta();
      snowballMeta.setDisplayName(ChatColor.BLUE + "Snowballs");
      snowballs.setItemMeta(snowballMeta);
    }

    player.getInventory().setContents(new ItemStack[]{shovel,snowballs});

  }

  public int getDeaths() {
    return deaths;
  }

  public Player getPlayer() {
    return player;
  }

}
