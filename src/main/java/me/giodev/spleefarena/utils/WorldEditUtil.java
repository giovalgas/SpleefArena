package me.giodev.spleefarena.utils;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.util.formatting.text.TextComponent;
import com.sk89q.worldedit.world.World;

public class WorldEditUtil {

  public static Region getPlayerSelection(Player actor) {
    LocalSession localSession = WorldEdit.getInstance().getSessionManager().get(actor);
    World selectionWorld = localSession.getSelectionWorld();
    Region selection;

    try {
      if(selectionWorld == null) throw new IncompleteRegionException();
      selection = localSession.getSelection(selectionWorld).clone();
    } catch (IncompleteRegionException e) {
      //TODO -> Add proper error message done
      selection = null;
    }

    return selection;
  }

}
