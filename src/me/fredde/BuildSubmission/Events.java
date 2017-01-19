package me.fredde.BuildSubmission;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.UUID;

class Events implements Listener {
    private Settings settings;
    private List<Builder> builders;

    Events(Settings settings, List<Builder> builders) {
        this.settings = settings;
        this.builders = builders;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        boolean isNew = !builders.stream().filter(p -> p.getUuid().equals(uuid)).findFirst().isPresent();
        if (isNew) builders.add(new Builder(settings.BUILDERS, uuid, 0, null));
    }
}