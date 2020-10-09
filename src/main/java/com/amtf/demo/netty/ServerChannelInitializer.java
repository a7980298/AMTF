package com.amtf.demo.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * netty服务初始化器
 * 
 * @author wyx
 *
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		// 添加编解码
		socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast(new NettyServerHandler());
	}
}
