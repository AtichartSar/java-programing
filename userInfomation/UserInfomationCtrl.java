package com.arg.gsbea.ctrl;

import com.arg.gsbea.api.UserApi;
import com.arg.gsbea.common.helper.ContextHelper;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfomationCtrl {

    private static final Logger LOG = LogManager.getLogger(UserInfomationCtrl.class);
    UserApi webService = ContextHelper.getBean("webCliet", UserApi.class);
    private static final String MONTH = "month";
    private static final String YEAR = "year";

    @RequestMapping(value = "/user_Infomation.htm", method = {RequestMethod.GET})
    public String getPageUserInfomation(Model model, HttpServletRequest request, HttpServletResponse response) {
        LOG.info("<===[ userInfomationCtrl ]===>");
        Response res = null;
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        try {
            
            JSONObject obj = generateDateObj("", "");
            res = webService.userInfomationData(obj.toString());
            model.addAttribute("userInfomation", res.readEntity(String.class));
            
            return "user_Infomation";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/user_InfomationData.htm", method = {RequestMethod.GET})
    @ResponseBody
    public String getDataUserInfomation(HttpServletRequest request, HttpServletResponse response) {
        LOG.info("<===[ getDataUserInfomationCtrl ]===>");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        Response res = null;
        try {
            
            String month = request.getParameter(MONTH);
            String year = request.getParameter(YEAR);
            
            JSONObject obj = generateDateObj(month, year);
            res = webService.userInfomationData(obj.toString());
            
            return res.readEntity(String.class);
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public JSONObject generateDateObj(String month, String year) {
        JSONObject jobj = new JSONObject();
        if (month.isEmpty() && year.isEmpty()) {
            LocalDate myObj = LocalDate.now();
            month = String.valueOf(myObj.getMonthValue());
            year = String.valueOf(myObj.getYear() + 543);
            jobj.put(YEAR, year);
            jobj.put(MONTH, month);
            return jobj;
        }
        jobj.put(YEAR, year);
        jobj.put(MONTH, month);
        return jobj;
    }
}

