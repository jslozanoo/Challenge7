package jslozano.challenge7.controllers;

import jslozano.challenge7.commands.WeatherRegisterCommand;
import jslozano.challenge7.service.WeatherRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    private final WeatherRegisterService registerService;

    public RegisterController(WeatherRegisterService registerService) {
        this.registerService = registerService;
    }
    @RequestMapping("register/{id}/show")
    public String showById(@PathVariable Long id, Model model){
        model.addAttribute("registers", registerService.findById(id));

        return "register/show";
    }

    @RequestMapping("/register/new")
    public String newRegister(Model model){
        model.addAttribute("register", new WeatherRegisterCommand());
        return "register/registerform";
    }
    @PostMapping("register")
    public String saveOrUpdate(@ModelAttribute WeatherRegisterCommand command){
        WeatherRegisterCommand savedCommand = registerService.saveRegisterCommand(command);

        return "redirect:/register/" + savedCommand.getId() + "/show";

    }
}
