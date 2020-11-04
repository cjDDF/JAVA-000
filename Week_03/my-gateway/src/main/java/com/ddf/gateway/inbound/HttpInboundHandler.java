package com.ddf.gateway.inbound;

import com.ddf.gateway.filter.HttpRequestFilter;
import com.ddf.gateway.outbound.HttpClientOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author ddf
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);

    private final String proxyServer;

    private HttpClientOutboundHandler handler;
    public HttpInboundHandler(String proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpClientOutboundHandler(proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)   {
        FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
        //过滤器
        new HttpRequestFilter() {
            public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
                fullRequest.headers().set("nio", "GaoYuan");
            }
        }.filter(fullHttpRequest,null);

        handler.handle(fullHttpRequest, ctx);
    }
}
