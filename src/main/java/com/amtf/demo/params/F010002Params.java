package com.amtf.demo.params;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.user.UserImpl;
import com.amtf.demo.util.FenYe;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010002Params extends UserImpl {
	public FenYe fenye;
}
