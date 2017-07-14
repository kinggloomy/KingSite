package com.kinggloomy.site.controller;


import com.kinggloomy.core.BaseTestCase;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class IndexControllerTest extends BaseTestCase{
    @Test
    public void test0() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setServletPath("");
        final ModelAndView mav = this.excuteAction(request, response);
    }


}