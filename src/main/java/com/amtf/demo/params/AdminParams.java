package com.amtf.demo.params;

import com.amtf.demo.f010001entity.F010001_Select2Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.f020001entity.F020001_Select7Entity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties
@Getter
@Setter
public class AdminParams extends UserImpl {
	/**
	 * 可操作的用户信息
	 */
	List<F020001_Select1Entity> select1;

	/**
	 * 导航栏
	 */
	public Map<String, List<F020001_Select7Entity>> navigation_bar;

}
