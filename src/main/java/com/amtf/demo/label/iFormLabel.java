package com.amtf.demo.label;

import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.AttributeValueQuotes;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import com.amtf.demo.util.CommonUtil;

public class iFormLabel extends AbstractElementModelProcessor {

	public iFormLabel(String dialectPrefix, String elementName, int precedence) {
		super(TemplateMode.HTML, dialectPrefix, elementName, dialectPrefix != null, null, false, precedence);
	}

	@Override
	protected void doProcess(ITemplateContext context, IModel iModel, IElementModelStructureHandler structureHandler) {
		//
		Map<String, String> options = new HashMap<String, String>();

		Map<String, String> attributes = new HashMap<String, String>();
		IModelFactory modelFactory = context.getModelFactory();
		IProcessableElementTag tag = (IProcessableElementTag) iModel.get(0);

		IAttribute[] allAttributes = tag.getAllAttributes();

		// 获取标签上的属性
		for (IAttribute ab : allAttributes) {
			options.put(ab.getAttributeCompleteName(), ab.getValue());
			if (ab.getAttributeCompleteName().startsWith("th:")) {
				prepareAttribute(attributes, ab.getAttributeCompleteName(), ab.getValue());
			}
		}
		// RequestUtils.getRequestValue("f010001Params");
		// 给标签添加可识别的属性
		prepareAttribute(attributes, "onsubmit", "return false");
		prepareAttribute(attributes, "id", options.get("id"));
		prepareAttribute(attributes, "name", options.get("name"));
		prepareAttribute(attributes, "class", options.get("class"));
		prepareAttribute(attributes, "target", options.get("target"));
		prepareAttribute(attributes, "action", options.get("action"));
		prepareAttribute(attributes, "method", options.get("method"));
		prepareAttribute(attributes, "enctype", options.get("enctype"));

		// 从开始的form标签截取
		iModel.replace(0, modelFactory.createOpenElementTag("form", attributes, AttributeValueQuotes.DOUBLE, false));

		StringBuffer addsb = new StringBuffer();
		String resultViewId = "";

		String iViewId = options.get("iViewid");

		if (!CommonUtil.isEmpty(iViewId)) {
			resultViewId = iViewId;
		} /*
			 * else { resultViewId = StringUtil.toStr(RequestUtil.getViewid()); }
			 */
		// 添加其他标签
		addsb.append("");
		iModel.insert(1, modelFactory.createText(addsb.toString()));
		// 到结束的form标签结束
		iModel.replace(iModel.size() - 1, modelFactory.createCloseElementTag("form"));
	}

	protected void prepareAttribute(Map<String, String> handlers, String name, String value) {
		if (value != null) {
			handlers.put(name, value);
		}
		return;
	}
}
