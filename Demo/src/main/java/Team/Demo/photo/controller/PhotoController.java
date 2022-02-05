package team.demo.photo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.demo.photo.service.PhotoService;


@RequestMapping("/photo")
public class PhotoController {



    @Autowired
    private PhotoService photoService;


    @GetMapping
    public ModelAndView photoBoard(Model model) {
        ModelAndView mv = new ModelAndView();



        return mv;

    }

    @GetMapping("/a")
    public ModelAndView a() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jsp파일경로");
        String a =서비스클래스이름.메소드();
        mv.addObject(a);//값을 넘겨줘야할때
    return  mv;
    }



}
