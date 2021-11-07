package dev.giovalgas.spleefarena.data.items;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Snowballs {

  public static ItemStack getSnowball(int amount) {
    ItemStack snowball = new ItemStack(XMaterial.SNOWBALL.parseMaterial(), amount);
    ItemMeta meta = snowball.getItemMeta();
    meta.setDisplayName(ChatColor.BLUE + "Snowballs");
    snowball.setItemMeta(meta);

    return snowball;
  }

}
