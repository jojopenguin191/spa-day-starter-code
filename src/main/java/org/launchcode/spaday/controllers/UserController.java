package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import javax.validation.Valid;
import java.text.AttributedString;


@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        // add form submission handling code here
        model.addAttribute("verify", verify);
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());


        if (errors.hasErrors() || !user.getPassword().equals(verify)) {
            if (!user.getPassword().equals(verify)) {
                model.addAttribute("error", "Passwords do not match");
            }
            return "user/add";
        }
        return "user/index";
    }
}

