package me.taako.confetticreepers.listeners;

import me.taako.confetticreepers.ConfettiCreepers;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class EntityExplode implements Listener {
    public EntityExplode(ConfettiCreepers plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (event.getEntity().getType() != EntityType.CREEPER) return;
        event.setCancelled(true); // Prevent block destruction

        Creeper creeper = (Creeper) event.getEntity();
        Firework firework = (Firework) creeper.getWorld().spawnEntity(creeper.getLocation(), EntityType.FIREWORK);

        FireworkEffect fireworkEffect = FireworkEffect.builder()
                .withColor(Color.fromRGB(179, 49, 44),
                        Color.fromRGB(235, 136, 68),
                        Color.fromRGB(222, 207, 42),
                        Color.fromRGB(65, 205, 52),
                        Color.fromRGB(102, 137, 211),
                        Color.fromRGB(123, 47, 190),
                        Color.fromRGB(216, 129, 152))
                .with(FireworkEffect.Type.BALL_LARGE)
                .build();

        FireworkMeta fireworkMeta = firework.getFireworkMeta();
        fireworkMeta.addEffect(fireworkEffect);
        fireworkMeta.setPower(0);

        firework.setFireworkMeta(fireworkMeta);
        firework.detonate();
    }
}
