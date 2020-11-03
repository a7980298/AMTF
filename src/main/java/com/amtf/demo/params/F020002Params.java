package com.amtf.demo.params;

import com.amtf.demo.f010001entity.F010001_Select3Entity;
import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.f020001entity.F020001_Select7Entity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@ConfigurationProperties
@Getter
@Setter
public class F020002Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;
}
