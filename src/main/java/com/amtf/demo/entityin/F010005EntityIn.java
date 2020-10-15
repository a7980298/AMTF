package com.amtf.demo.entityin;

import java.util.List;

import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010005EntityIn extends UserImpl {

	/**
	 * 活动id
	 */
	public String actiyity_id;

	/**
	 * 所有活动
	 */
	List<F010002_Select9Entity> select9;

}
