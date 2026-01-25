package me.elliot.disabledragonbreath;

import org.bukkit.Bukkit;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DisableDragonBreath extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("DisableDragonBreath enabled!");
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof AreaEffectCloud) {
            AreaEffectCloud cloud = (AreaEffectCloud) event.getEntity();

            if (cloud.getSource() instanceof EnderDragon) {
                event.setCancelled(true);
            }
        }
    }
}
