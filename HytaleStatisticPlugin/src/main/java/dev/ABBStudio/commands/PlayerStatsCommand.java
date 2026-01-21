package dev.ABBStudio.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.OptionalArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class PlayerStatsCommand extends AbstractCommand {

    public PlayerStatsCommand(String name, String description) {
        super(name, description);
    }

    OptionalArg<String> optionalPlayerName = this.withOptionalArg("optionalPlayerName", "", ArgTypes.STRING);

    @Nullable
    @Override
    protected CompletableFuture<Void> execute(@Nonnull CommandContext context) {
        String optionalPlayerNameArgument = optionalPlayerName.get(context);

        if (optionalPlayerNameArgument != null) {
            context.sendMessage(Message.raw("Hello from ExampleCommand! with argument : " + optionalPlayerNameArgument));
        }
        else {
            context.sendMessage(Message.raw("Hello from ExampleCommand! without argument"));
        }

        return CompletableFuture.completedFuture(null);
    }
}
