package Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

import static me.shakeforprotein.treebotalk.TreeboTalk.pl;

public class GuiListener implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Name Color")){
            e.setCancelled(true);
            String col = "";
            int slot = e.getSlot();
            Material material = e.getInventory().getItem(slot).getType();
            if(slot != -999) {
                if (material.equals(Material.BARRIER)) {
                } else if (material.equals(Material.DIAMOND)) {
                    col = "AQUA";
                } else if (material.equals(Material.REDSTONE)) {
                    col = "DARK_RED";
                } else if (material.equals(Material.ORANGE_DYE)) {
                    col = "GOLD";
                } else if (material.equals(Material.LIME_DYE)) {
                    col = "GREEN";
                } else if (material.equals(Material.GREEN_DYE)) {
                    col = "DARK_GREEN";
                } else if (material.equals(Material.CYAN_DYE)) {
                    col = "DARK_AQUA";
                } else if (material.equals(Material.LIGHT_BLUE_DYE)) {
                    col = "BLUE";
                } else if (material.equals(Material.BLUE_DYE)) {
                    col = "DARK_BLUE";
                } else if (material.equals(Material.MAGENTA_DYE)) {
                    col = "LIGHT_PURPLE";
                } else if (material.equals(Material.PURPLE_DYE)) {
                    col = "DARK_PURPLE";
                } else if (material.equals(Material.LIGHT_GRAY_DYE)) {
                    col = "GRAY";
                } else if (material.equals(Material.GRAY_DYE)) {
                    col = "DARK_GRAY";
                } else if (material.name().contains("_DYE")) {
                    col = material.name().split("_DYE")[0];
                }
                if (!col.equalsIgnoreCase("")) {
                    ((Player) e.getView().getPlayer()).setPlayerListName(ChatColor.valueOf(col) + e.getView().getPlayer().getName());
                    ((Player) e.getView().getPlayer()).setDisplayName(ChatColor.valueOf(col) + e.getView().getPlayer().getName());
                    ((Player) e.getView().getPlayer()).setCustomName(ChatColor.valueOf(col) + e.getView().getPlayer().getName());
                    e.getView().getPlayer().sendMessage(ChatColor.GOLD + "Your name has been updated to " + ChatColor.valueOf(col) + e.getView().getPlayer().getName());
                    pl.getConfig().set("PlayerColors." + e.getView().getPlayer().getUniqueId() + "", col);
                } else {
                    ((Player) e.getView().getPlayer()).setPlayerListName(e.getView().getPlayer().getName());
                    ((Player) e.getView().getPlayer()).setDisplayName(e.getView().getPlayer().getName());
                    ((Player) e.getView().getPlayer()).setCustomName(e.getView().getPlayer().getName());
                    e.getView().getPlayer().sendMessage(ChatColor.GOLD + "Your name has been restored to normal");
                    pl.getConfig().set("PlayerColors." + e.getView().getPlayer().getUniqueId() + "", null);
                }
            }
            e.getView().getPlayer().closeInventory();
        }
    }

    @EventHandler
    public void onInvDrag(InventoryDragEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Name Color")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInvPickup(InventoryInteractEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Name Color")) {
            e.setCancelled(true);
        }
    }
}
