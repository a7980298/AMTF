package com.amtf.demo.label;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class iFneyeLabel extends AbstractElementTagProcessor {

	// 标签名字
	private static final String TAG_NAME = "ifneyelabel";
	// 识别属性clss
	private static final String CLASS = "class";
	// 识别属性action
	private static final String ACTION = "action";
	// 识别属性action
	private static final String TEXTURL = "texturl";

	private final String PATH = "/amtf";
	private static final int PRECEDENCE = 300;

	public iFneyeLabel(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false, PRECEDENCE);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		// TODO Auto-generated method stub
		IAttribute tagName = tag.getAttribute(TAG_NAME);
		IAttribute clas = tag.getAttribute(CLASS);
		IAttribute action = tag.getAttribute(ACTION);
		IAttribute texturl = tag.getAttribute(TEXTURL);

		String tagValue = "<ifneyelabel class=" + clas.getValue() + " action=" + PATH + action.getValue() + " texturl="
				+ texturl.getValue() + ">" + "<button class='btn btn-primary' onclick='amtf_fenye(this)'>始</button>"
				+ "<button class='btn btn-primary' onclick='amtf_fenye(this)'>上</button>"
				+ "<button class='btn btn-primary' onclick='amtf_fenye(this)'>下</button>"
				+ "<button class='btn btn-primary' onclick='amtf_fenye(this)'>末</button>" + "</ifneyelabel>";
		structureHandler.replaceWith(tagValue, false);
	}

}
