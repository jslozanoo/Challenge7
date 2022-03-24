package jslozano.challenge7.controllers;

import jslozano.challenge7.service.WeatherRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    private final WeatherRegisterService registerService;

    public indexController(WeatherRegisterService registerService) {
        this.registerService = registerService;
    }

    @RequestMapping({"", "/"})
    public String getRegisters(Model model){
        model.addAttribute("registers", registerService.getRegisters());

        return "index";
    }
}
