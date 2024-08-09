package com.learning.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("MyWebsite")
public class HomeController {
    @GetMapping("/")
    public String visitHome(HttpServletRequest request)
    {
        return "Hello World 2 (after login page) [session Id = " + request.getSession().getId() + "]";
    }

    @GetMapping("/about")
    public String visitAbout(HttpServletRequest request)
    {
        return "About page (after login page) [session Id = " + request.getSession().getId() + "]";
    }
}
