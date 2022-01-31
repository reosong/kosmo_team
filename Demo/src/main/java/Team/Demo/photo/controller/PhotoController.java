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




}
