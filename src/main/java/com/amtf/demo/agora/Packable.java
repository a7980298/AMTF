package com.amtf.demo.agora;

/**
 *
 */
public interface Packable {
	ByteBuf marshal(ByteBuf out);
}