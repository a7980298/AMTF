package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010001Params extends UserImpl {
	/**
	 * 密码是否正确
	 */
	public String pwdbol;

	public List<String> select1;
}
