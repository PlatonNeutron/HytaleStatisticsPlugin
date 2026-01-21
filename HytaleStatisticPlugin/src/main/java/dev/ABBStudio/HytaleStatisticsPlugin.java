package dev.ABBStudio;

import com.hypixel.hytale.server.core.event.events.player.PlayerMouseButtonEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import dev.ABBStudio.commands.PlayerStatsCommand;
import dev.ABBStudio.events.ExampleEvent;

import javax.annotation.Nonnull;

public class HytaleStatisticsPlugin extends JavaPlugin {

    public HytaleStatisticsPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getCommandRegistry().registerCommand(new PlayerStatsCommand("playerStats", "An example command"));
        this.getEventRegistry().registerGlobal(PlayerMouseButtonEvent.class, ExampleEvent::zoomWithSpyGlass);
    }
}