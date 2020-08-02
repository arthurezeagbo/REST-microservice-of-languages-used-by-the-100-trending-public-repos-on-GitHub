package com.arthurezeagbo.repoinfoservice.controllers;

import com.arthurezeagbo.repoinfoservice.exceptions.ErrorJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    @Autowired
    ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    ErrorJson errorJson(HttpServletRequest request, HttpServletResponse response){

        return new ErrorJson(response.getStatus(), getErorAttributes(request,true));
    }

    private Map<String, Object> getErorAttributes(HttpServletRequest request, boolean includeStackTrace){

        WebRequest requestAttributes = new ServletWebRequest(request);

        return errorAttributes.getErrorAttributes(requestAttributes,includeStackTrace);
    }
}
