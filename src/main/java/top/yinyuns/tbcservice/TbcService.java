package top.yinyuns.tbcservice;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;
import top.yinyuns.tbcservice.listener.Chat;
import top.yinyuns.tbcservice.listener.ServerPingView;

@Plugin(
        id = "tbcservice",
        name = "TwoBlueCubeService",
        version = "0.1.0-SNAPSHOT",
        description = "Service plugin for TwoBlueCube server",
        url = "yinyuns.top",
        authors = {"Yinyun Studio"}
)
public class TbcService {


    public static Logger logger;
    public static ProxyServer server;

    @Inject
    public TbcService(Logger logger, ProxyServer server) {
        this.logger = logger;
        this.server = server;
        logger.info("Hello there, it's a test plugin I made!");
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getEventManager().register(this, new ServerPingView());
        server.getEventManager().register(this, new Chat());
        logger.info("ok!");
//        server.sendMessage();
    }
}
