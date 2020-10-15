package com.amtf.demo.entityout;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010003EntityOut extends UserImpl {

	/**
	 * 是否修改成功
	 */
	public String isUpdatUserOk;
}
