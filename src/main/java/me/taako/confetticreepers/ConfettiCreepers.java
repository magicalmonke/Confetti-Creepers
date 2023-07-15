package me.taako.confetticreepers;

import me.taako.confetticreepers.listeners.EntityExplode;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ConfettiCreepers extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger logger = getLogger();
        logger.info("Plugin enabled successfully!");

        new EntityExplode(this);
    }

    @Override
    public void onDisable() {

    }
}
