package com.amtf.demo.label;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.support.RequestContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring5.naming.SpringContextVariableNames;
import org.thymeleaf.templatemode.TemplateMode;

import com.amtf.demo.util.CommonUtil;

public class IFneyeLabel extends AbstractElementTagProcessor {

	// 标签名字
	private static final String TAG_NAME = "ifneyelabel";
	// 识别属性clss
	private static final String CLASS = "class";
	// 识别属性action
	private static final String ACTION = "action";
	// 识别属性action
	private static final String TEXTURL = "texturl";

	private final String PATH = "/amtf";

	public IFneyeLabel(String dialectPrefix, String elementName, int precedence) {
		super(TemplateMode.HTML, dialectPrefix, elementName, dialectPrefix != null, null, false, precedence);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		IModelFactory modelFactory;
		IModel iModel;

		Map<String, String> options = new HashMap<String, String>();

		modelFactory = context.getModelFactory();
		iModel = modelFactory.createModel();

		RequestContext requestContext = (RequestContext) context
				.getVariable(SpringContextVariableNames.SPRING_REQUEST_CONTEXT);

		IAttribute[] allAttributes = tag.getAllAttributes();
		for (IAttribute ab : allAttributes) {
			options.put(ab.getAttributeCompleteName(), ab.getValue());
		}

		Map<String, Object> model = requestContext.getModel();

		String name = options.get("name");
		String prop = options.get("property");
		String propValue = "";

		/*
		 * if (options.containsKey("property")) { propValue =
		 * StringUtil.toStr(getObjectValue(model, name, prop)); }
		 */

		if (CommonUtil.isEmpty(propValue) && options.containsKey("selectValue")) {
			propValue = options.get("selectValue");
		}

		// map = getOptionDate(model, options, propValue);

		/*
		 * IAttribute tagName = tag.getAttribute(TAG_NAME); IAttribute clas =
		 * tag.getAttribute(CLASS); IAttribute action = tag.getAttribute(ACTION);
		 * IAttribute texturl = tag.getAttribute(TEXTURL);
		 * 
		 * String tagValue = "<ifneyelabel class=" + clas.getValue() + " action=" + PATH
		 * + action.getValue() + " texturl=" + texturl.getValue() + " id='fenye'>" +
		 * "<button class='btn btn-primary' onclick='amtf_fenye(amtf_form,this)'>始</button>"
		 * +
		 * "<button class='btn btn-primary' onclick='amtf_fenye(amtf_form,this)'>上</button>"
		 * +
		 * "<button class='btn btn-primary' onclick='amtf_fenye(amtf_form,this)'>下</button>"
		 * +
		 * "<button class='btn btn-primary' onclick='amtf_fenye(amtf_form,this)'>末</button>"
		 * + "</ifneyelabel>";
		 */
		// structureHandler.replaceWith(tagValue, false);
	}

}
