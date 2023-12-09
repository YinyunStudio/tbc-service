package top.yinyuns.tbcservice.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.proxy.server.ServerPing;
import com.velocitypowered.api.util.Favicon;

public class ServerPingView {

    private Favicon icon;
    public ServerPingView() {
    }

    @Subscribe
    public void onPing(ProxyPingEvent event) {
        ServerPing ping = event.getPing();
        ServerPing.Builder builder = ping.asBuilder();
        builder.favicon(new Favicon("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAACXBIWXMAAAsTAAALEwEAmpwYAAAFHGlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxNDUgNzkuMTYzNDk5LCAyMDE4LzA4LzEzLTE2OjQwOjIyICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxOSAoV2luZG93cykiIHhtcDpDcmVhdGVEYXRlPSIyMDIxLTA2LTI2VDEyOjAxOjE5KzA4OjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAyMS0wNi0yNlQxMjowODoyNyswODowMCIgeG1wOk1ldGFkYXRhRGF0ZT0iMjAyMS0wNi0yNlQxMjowODoyNyswODowMCIgZGM6Zm9ybWF0PSJpbWFnZS9wbmciIHBob3Rvc2hvcDpDb2xvck1vZGU9IjMiIHBob3Rvc2hvcDpJQ0NQcm9maWxlPSJzUkdCIElFQzYxOTY2LTIuMSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo4M2MxNGJjYy0zNzk2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"));
        event.setPing(builder.build());
    }
}