package top.yinyuns.tbcservice.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;
import top.yinyuns.tbcservice.TbcService;

import java.util.Collection;

public class Chat {
    @Subscribe
    public void onPlayerChat(PlayerChatEvent event) {
        Player sendMessagePlayer = event.getPlayer();

        String playerServerName = sendMessagePlayer.getCurrentServer().get().getServerInfo().getName();
        String playerName = sendMessagePlayer.getUsername();
        Component message = Component.text(playerServerName+"->"+playerName+">>"+event.getMessage());

        int serverHash = sendMessagePlayer.getCurrentServer().get().getServerInfo().hashCode();
        Collection<Player> playerList = TbcService.server.getAllPlayers();
        for (Player player : playerList) {
            if (player.getCurrentServer().get().getServerInfo().hashCode() == serverHash) continue;
            player.sendMessage(message);
            TbcService.logger.info(player.getCurrentServer().get().getServerInfo().hashCode()+"");
            TbcService.logger.info(serverHash+"");
        }

    }
}