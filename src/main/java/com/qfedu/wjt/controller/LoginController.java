package com.qfedu.wjt.controller;

import com.github.pagehelper.Page;
import com.qfedu.wjt.common.JsonResult;
import com.qfedu.wjt.pojo.Info;
import com.qfedu.wjt.pojo.User;
import com.qfedu.wjt.service.UserService;
import com.qfedu.wjt.utils.StrUtils;

import javafx.scene.control.Alert;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Console;
import java.io.IOException;
import java.util.*;

@Controller
@ResponseBody
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    //使用注解修饰方法上的参数
    public JsonResult login(@NotEmpty String userName, @Size(min = 1, max = 8) String password, HttpSession session) {
        User user = userService.login(userName, password);
        session.setAttribute(StrUtils.LOGIN_USER, user);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }

    @RequestMapping("/listInfo.do")
    public Map<String, Object> findAll(Integer page, Integer limit, String searchInfo) {
        Map<String, Object> map = userService.findByPage(page, limit, searchInfo);
        System.out.println("controller:" + map);
        return map;
    }

    @RequestMapping("/queryInfo.do")
    public JsonResult findById(Integer id) {
        Info info = userService.findById(id);
        return new JsonResult(1, info);
    }

    @RequestMapping("/deleteInfo.do")
    public JsonResult deleteById(Integer id) {
        userService.deleteInfo(id);
        System.out.println(userService.deleteInfo(id));
        return new JsonResult(1, null);
    }

    @RequestMapping("/addInfo.do")
    public JsonResult addInfo(String projectName, String vested, String idCard, String housingTypes, int usableArea ,Date constructionTime) {
        Date date = new Date();
        Info info = new Info();

        info.setProjectName(projectName);
        info.setVested(vested);
        info.setIdCard(idCard);
        info.setHousingTypes(housingTypes);
        info.setUsableArea(usableArea);
        info.setConstructionTime(constructionTime);
        System.out.println(info);
        userService.addInfo(info);

        return new JsonResult(1, null);
    }

    @RequestMapping("/updateInfo.do")
    public JsonResult updateSpeaker(Info info) {
        userService.updateInfo(info);
        return new JsonResult(1, null);
    }

    @RequestMapping("/register.do")
    @ResponseBody
    public JsonResult addRegister(String userName, String passWord, HttpSession session) {
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        userService.addRegisterInfo(user);
        session.setAttribute(StrUtils.LOGIN_USER, user);
        return new JsonResult(1, null);
    }

    @RequestMapping("/updatePassword.do")
    @ResponseBody
    public JsonResult updatePassword(String userName, String passWord, HttpSession session) {
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        userService.updatePassword(user);
        session.setAttribute(StrUtils.LOGIN_USER, user);
        return new JsonResult(1, null);
    }

    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult getLoginInfo(HttpSession session) {
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        JsonResult result = null;
        if (user != null) {
            result = new JsonResult(1, user);
        } else {
            result = new JsonResult(0, "用户未登录");
        }
        return result;
    }

    @RequestMapping("/loginOut.do")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        session.invalidate();

        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        try {
            response.sendRedirect("login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
