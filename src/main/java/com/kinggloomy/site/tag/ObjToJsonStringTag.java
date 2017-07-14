package com.kinggloomy.site.tag;

import com.kinggloomy.site.service.utils.impl.JsonServiceImpl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/6.
 */
public class ObjToJsonStringTag extends SimpleTagSupport {
    private Object value;
    private JsonServiceImpl jsonService = new JsonServiceImpl();

    @Override
    public void doTag() throws JspException, IOException {
        String json = jsonService.objToJson(value);
        JspWriter out = getJspContext().getOut();
        out.println(json);

    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}
