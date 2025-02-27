package sgu.j2ee.demo2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @GetMapping("/Search.do")
    public ModelAndView showSearchPage(HttpServletRequest request) {
        // The SecurityFilter has already verified the session
        // but we can also check again here if needed
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("user");

        ModelAndView mav = new ModelAndView("search");
        mav.addObject("username", username);

        return mav;
    }
}