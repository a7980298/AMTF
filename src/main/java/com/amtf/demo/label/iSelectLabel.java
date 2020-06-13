package com.amtf.demo.label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.support.RequestContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.AttributeValueQuotes;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring5.naming.SpringContextVariableNames;
import org.thymeleaf.templatemode.TemplateMode;

import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.RequestUtils;
import com.amtf.demo.util.StringUtil;

public class iSelectLabel extends AbstractElementTagProcessor {

	private Map<String, String> map;

	public iSelectLabel(String dialectPrefix, String elementName, int precedence) {
		super(TemplateMode.HTML, dialectPrefix, elementName, dialectPrefix != null, null, false, precedence);
	}

	@SuppressWarnings("unchecked")
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

		// Map<String, Object> model = requestContext.getModel();

		String name = options.get("name");
		String prop = options.get("property");
		String propValue = "";
		// 获取Params的值
		Map<String, Object> valueMap = RequestUtils.getRequestValue(name, prop);

		List<String> valueLists = new ArrayList<String>();

		for (int i = 0; i < valueMap.size(); i++) {
			valueLists = (List<String>) valueMap.get(prop);
		}
		// 需要的内镶嵌的标签
		StringBuffer addsb = new StringBuffer();
		addsb.append("<select id='iSelectParamsId' class='col-md-12'>");
		for (int i = 0; i < valueLists.size(); i++) {
			addsb.append("<option value=" + i + ">" + valueLists.get(i) + "</option>");
		}
		addsb.append("</select>");

		// iModel.insert(1, modelFactory.createText(addsb.toString()));

		if (options.containsKey("property")) {
			// propValue = getObjectValue(model, name, prop);
		}

		if (CommonUtil.isEmpty(propValue) && options.containsKey("selectValue")) {
			propValue = options.get("selectValue");
		}

		// map = getOptionDate(model, options, propValue);
		// 将标签添加
		structureHandler.replaceWith(addsb, false);
	}

	@SuppressWarnings("unused")
	private void drawSelectTag(Map<String, Object> model, Map<String, String> options, String propValue,
			IModelFactory modlFactory, IModel iModel) {

		Map<String, String> attrbutes = new HashMap<>();

		// 设置disabled属性
		if ("disabled".equals(options.get("disavled"))) {
			prepareAttribute(attrbutes, "disabled", "disabled");
		}

		// 设置style属性
		if ("style".equals(options.get("style"))) {
			prepareAttribute(attrbutes, "style", options.get("style"));
		}

		// 设置class属性
		if ("class".equals(options.get("class"))) {
			prepareAttribute(attrbutes, "class", options.get("class"));
		}

		// 设置onblur事件
		if ("onblur".equals(options.get("onblur"))) {
			prepareAttribute(attrbutes, "onblur", options.get("onblur"));
		}

		// 设置onchange事件
		if ("change".equals(options.get("change"))) {
			prepareAttribute(attrbutes, "change", options.get("change"));
		}

		// 设置onfocus事件
		if ("onfocus".equals(options.get("onfocus"))) {
			prepareAttribute(attrbutes, "onfocus", options.get("onfocus"));
		}

		prepareAttribute(attrbutes, "name", options.get("name"));
		prepareAttribute(attrbutes, "id", options.get("id"));

		iModel.add(modlFactory.createOpenElementTag("SELECT", attrbutes, AttributeValueQuotes.DOUBLE, false));
		this.drawOptions(model, options, propValue, modlFactory, iModel);
		iModel.add(modlFactory.createCloseElementTag("SELECT"));

		for (int i = 0; i < map.size(); i++) {
			attrbutes = new HashMap<>();
			prepareAttribute(attrbutes, "value", map.get(StringUtil.toStr(i)));
			prepareAttribute(attrbutes, "name", options.get("name"));
			prepareAttribute(attrbutes, "type", "hidden");
			iModel.add(modlFactory.createOpenElementTag("INPUT", attrbutes, null, false));
			// iModel.add(modlFactory.createText());
		}

	}

	private void drawOptions(Map<String, Object> model, Map<String, String> options, String propValue,
			IModelFactory modelFactory, IModel iModel) {
		if (CommonUtil.isEmpty(map) && !"true".equalsIgnoreCase(options.get("emptyOption"))) {
			return;
		}

		Map<String, String> attrbutes = new HashMap<>();
		if (options.containsKey("emptyOption")) {
			if (CommonUtil.isEmpty(propValue)) {
				attrbutes.put("selected", "selected");
			}
			iModel.add(modelFactory.createOpenElementTag("OPTION", attrbutes, AttributeValueQuotes.DOUBLE, false));
			iModel.add(modelFactory.createText(options.get("emptyOption")));
			iModel.add(modelFactory.createCloseElementTag("OPTION"));
		}
		for (int i = 0; i < map.size(); i++) {
			attrbutes = new HashMap<>();
			attrbutes.put("value", StringUtil.toStr(i + 1));
			if (!CommonUtil.isEmpty(propValue) && propValue.equals(StringUtil.toStr(i + 1))) {
				attrbutes.put("selected", "selected");
			}
			iModel.add(modelFactory.createOpenElementTag("OPTION", attrbutes, AttributeValueQuotes.DOUBLE, false));
			iModel.add(modelFactory.createText(map.get("StringUtil.toStr(i)")));
			iModel.add(modelFactory.createCloseElementTag("OPTION"));
			// iModel.add(modelFactory.createText("OPTION"));
		}
	}

	protected void prepareAttribute(Map<String, String> headlers, String name, String value) {
		if (value != null) {
			headlers.put(name, value);
		}
	}

}
