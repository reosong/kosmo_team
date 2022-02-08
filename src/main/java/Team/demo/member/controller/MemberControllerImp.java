package Team.demo.member.controller;


import Team.demo.member.domain.User;
import Team.demo.member.service.MemberService;
import Team.demo.member.service.MemberServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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




    @PostMapping
    public ModelAndView ch(HttpServletRequest request){
        System.out.println("ssss");
        System.out.println(request.getParameter("form"));

        return null;
    }

    //로그인 화면이동
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
//        if (request.getSession()==null) {
//            return "hhhh/login";
//        } else if (request.getSession() != null) {
//            return "redirect:/";
//        }
        return "hhhh/login";
    }


    //로그인
    @PostMapping("/login")
    public ModelAndView loginTry(User user, HttpServletRequest request) {
        String result = memberService.login(user);
        ModelAndView mv = new ModelAndView();
        if (result == null) {
            mv.setViewName("error");
            return mv;
        }

        int level =memberService.findLevel(user.getUserID());
        if(level == 99){
            mv.setViewName("redirect:http://localhost:8080/admin");
            return  mv;
        }
        HttpSession session = request.getSession();
        session.setAttribute("userID", user.getUserID());
        mv.setViewName("redirect:http://localhost:8080/hhhh");

        return mv;
    }

    //회원가입 화면이동
    @GetMapping("/login/member")
    public String joinFrom( HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") == null) {
            return "hhhh/member";
        }else{
            return "hhhh/member";
        }
    }
    //회원가입
    @PostMapping("/login/member")
    public String JoinMember(User user, @RequestParam String userPasswordOK) {

        if (user.getUserPassword().equals(userPasswordOK)) {
            memberService.join(user);
        } else {
            return "hhhh/error";
        }
        return "redirect:/hhhh";
    }


    @GetMapping("/login/home")
    public String back() {
        return "redirect:/";
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        System.out.println("cont");
        return "hhhh/main";
    }

    //마이페이지 이동
    @GetMapping("/myPage")
    public String myPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") == null) {
            return "hhhh/member";
        }else{
            return "hhhh/myPage";
        }

    }

    //정보 업데이트
    @PostMapping("/myPage")
    public ModelAndView memberUpdate(User user) {
        memberService.memberUpdate(user);
        ModelAndView mv = new ModelAndView("hhhh/main");
        return mv;
    }






}
