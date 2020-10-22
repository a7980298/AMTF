package com.amtf.demo.agora;

public interface PackableEx extends Packable {
	void unmarshal(ByteBuf in);
}