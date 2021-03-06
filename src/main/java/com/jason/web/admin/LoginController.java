package com.jason.web.admin;

import com.jason.po.User;
import com.jason.service.BlogService;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Jason
 * @date 7/20/2020 4:02 PM
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message","用户名和密码错误!");
            return "redirect:/admin";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
//
//    @GetMapping("/footer/newblog")
//    public String newblogs(Model model){
//        model.addAttribute("newblogs",blogService.listRecommendBlogTop(3));
//        return "admin/_fragments::newblogList";
//    }


}
