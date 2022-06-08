package com.bei.forum.controller;

import com.bei.forum.common.Email;
import com.bei.forum.common.Res;
import com.bei.forum.pojo.Users;
import com.bei.forum.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/{email}/info")
    public Res info(@PathVariable String email) {
        return Res.ok().data("user", usersService.selectById(usersService.selectId(email)));
    }

    @RequestMapping("/info")
    public Res infoByName(@RequestParam String name) {
        return Res.ok().data("user", usersService.selectById(usersService.selectIdByName(name)));
    }

    @RequestMapping("/{email}/set")
    public Res setInfo(@PathVariable String email,
                       @RequestParam(value = "name") String name,
                       @RequestParam(value = "img") int avatarOrder) {
        Users user = new Users();
        user.setEmail(email);
        user.setName(name);
        user.setAvatarOrder(avatarOrder);
        if (usersService.update(user)) {
            return Res.ok()
                    .setMsg("修改成功")
                    .data("user", usersService.selectById(usersService.selectId(email)));
        } else {
            return Res.err().setMsg("修改出错");
        }
    }
}
