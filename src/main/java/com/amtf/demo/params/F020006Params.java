package com.amtf.demo.params;

import com.amtf.demo.commonentity.AmtfPowerEntity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties
@Getter
@Setter
public class F020006Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 客户端总页面
	 */
	private List<AmtfPowerEntity> totalClientPage;

	/**
	 * 客户端显示的页面
	 */
	private List<AmtfPowerEntity> clientPageDisplayed;

	/**
	 * 修改页面的id
	 */
	private String pagesShow;

	/**
	 * 修改页面显示成功条数
	 */
	private Integer pageCount;

	/**
	 * 权限
	 */
	private String userPower;
}
