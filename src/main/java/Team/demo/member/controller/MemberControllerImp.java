package Team.demo.member.controller;


import Team.demo.member.service.MemberService;
import Team.demo.member.service.MemberServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class MemberControllerImp  {

    private MemberService memberService;


    @Autowired
    public MemberControllerImp(MemberServiceImp memberServiceImp) {
        this.memberService= memberServiceImp;


    }


    @GetMapping
    public ModelAndView login(Model model, HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/login");
        return mv;

    }





}
