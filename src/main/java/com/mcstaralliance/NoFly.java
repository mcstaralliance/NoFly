package com.mcstaralliance;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.Plugin;

public class NoFly extends JavaPlugin implements Listener {
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        if (!event.isFlying())
            return;
        Player player = event.getPlayer();
        if (player.isOp() || player.getGameMode() == GameMode.CREATIVE)
            return;
        if (!player.getName().equalsIgnoreCase("fireland"))
            return;
        player.setFlying(false);
        player.sendMessage("§b[§c小域§b] §c此世界禁止飞行。");
                event.setCancelled(true);
    }
}
