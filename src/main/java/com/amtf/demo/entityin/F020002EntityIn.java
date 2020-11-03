package com.amtf.demo.entityin;

import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class F020002EntityIn extends UserImpl {

	/**
	 * 页面id
	 */
	private String IViewId;

}
