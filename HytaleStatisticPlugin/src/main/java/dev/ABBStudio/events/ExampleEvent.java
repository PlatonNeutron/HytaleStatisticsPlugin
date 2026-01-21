package dev.ABBStudio.events;

import com.hypixel.hytale.protocol.ClientCameraView;
import com.hypixel.hytale.protocol.MouseButtonEvent;
import com.hypixel.hytale.protocol.ServerCameraSettings;
import com.hypixel.hytale.protocol.packets.camera.SetServerCamera;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.asset.type.item.config.Item;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerMouseButtonEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;

import java.util.Objects;


public class ExampleEvent {

    public static void zoomWithSpyGlass(PlayerMouseButtonEvent event) {
        Item itemInHand = event.getItemInHand();
        MouseButtonEvent mouseButton = event.getMouseButton();
        PlayerRef player = event.getPlayerRefComponent();

        if (Objects.equals(itemInHand.getId(), "") && mouseButton.mouseButtonType.getValue() == 0) {
            ServerCameraSettings settings = new ServerCameraSettings();
            settings.distance = 10.0f;
            player.getPacketHandler().writeNoCache(
                    new SetServerCamera(ClientCameraView.Custom, true, settings)
            );
        }
    }

}