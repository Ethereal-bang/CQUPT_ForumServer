package com.bei.forum.controller;

import com.bei.forum.common.Email;
import com.bei.forum.common.Res;
import com.bei.forum.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UsersController {

    UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/verify")
    public Res verify(@RequestParam("email") String email, HttpSession httpSession) {
        String verifyNum = Email.send(email);  // 返回生成的认证码
        if (Objects.equals(verifyNum, "")) {
            return Res.err().setMsg("邮件发送失败");
        }
        // 存入session方便之后验证
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("code", verifyNum);
        return Res.ok().setMsg("邮件发送成功，请查看验证码");
    }

    @RequestMapping("/login")
    public Res login(@RequestParam("email") String email, @RequestParam("code") String code, HttpSession httpSession) {
        String myEmail = (String) httpSession.getAttribute("email");
        String myCode = (String) httpSession.getAttribute("code");
        if (!email.equals(myEmail) || !code.equals(myCode)) {
            return Res.err().setMsg("邮箱验证出错，请重试");
        }
        // 判断是否新账号
        if (!usersService.isExists(email)) {
            // 创建账号进数据库
            if (!usersService.addByEmail(email)) {
                return Res.err().setMsg("账号创建出错");
            }
        }
        return Res.ok().setMsg("登录成功");
    }
}
