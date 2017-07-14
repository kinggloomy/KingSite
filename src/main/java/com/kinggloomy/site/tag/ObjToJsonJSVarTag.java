package com.kinggloomy.site.tag;


import com.kinggloomy.site.service.utils.impl.JsonServiceImpl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/6.
 */
public class ObjToJsonJSVarTag extends SimpleTagSupport {
    private Object value;
    private String var;
    private JsonServiceImpl jsonService = new JsonServiceImpl();
    @Override
    public void doTag() throws JspException, IOException {

        String srart = "<script>";
        String end = "</script>";
        String json = jsonService.objToJson(value);
        JspWriter out = getJspContext().getOut();
        StringBuilder sb = new StringBuilder(srart);
        sb.append("\n").append("var _").append(var).append(" = \' ").append(json).append(" \'").append("\n");
        sb.append("var ").append(var).append(" = ").append("jQuery.parseJSON(_").append(var).append(")").append("\n").append(end);
        out.println(sb);

    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
