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
        String originMessage = event.getMessage();
        if (!originMessage.substring(0, 1).equals("@")) return;

        Player sendMessagePlayer = event.getPlayer();
        String serverName = sendMessagePlayer.getCurrentServer().get().getServerInfo().getName();
        String playerName = sendMessagePlayer.getUsername();
        originMessage = originMessage.substring(1);
        Component message = Component.text(serverName +"->"+playerName+">>"+ originMessage);

        int serverHash = sendMessagePlayer.getCurrentServer().get().getServerInfo().hashCode();
        Collection<Player> playerList = TbcService.server.getAllPlayers();
        for (Player player : playerList) {
            if (player.getCurrentServer().get().getServerInfo().hashCode() == serverHash) continue;
            player.sendMessage(message);
        }
    }
}