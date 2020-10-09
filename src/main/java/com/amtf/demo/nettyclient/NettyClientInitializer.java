package com.amtf.demo.nettyclient;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * netty客户端初始化器
 * 
 * @author wyx
 *
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		socketChannel.pipeline().addLast("decoder", new StringDecoder());
		socketChannel.pipeline().addLast("encoder", new StringEncoder());
		socketChannel.pipeline().addLast(new NettyClientHandler());
	}
}
