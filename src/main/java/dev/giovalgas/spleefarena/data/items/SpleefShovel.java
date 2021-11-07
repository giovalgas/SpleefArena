package dev.giovalgas.spleefarena.data.items;

import com.cryptomorin.xseries.XEnchantment;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpleefShovel {

  public static ItemStack getSpleefShovel() {
    ItemStack shovel = new ItemStack(XMaterial.GOLDEN_SHOVEL.parseMaterial());
    ItemMeta shovelMeta = shovel.getItemMeta();
    shovelMeta.setDisplayName(ChatColor.BLUE + "Spleef Shovel");
    shovelMeta.setUnbreakable(true);
    shovelMeta.addEnchant(XEnchantment.DIG_SPEED.parseEnchantment(), 5, false);
    shovel.setItemMeta(shovelMeta);

    return shovel;
  }

}
