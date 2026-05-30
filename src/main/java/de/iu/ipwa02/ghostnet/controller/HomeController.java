package de.iu.ipwa02.ghostnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import de.iu.ipwa02.ghostnet.service.GhostNetService;
import org.springframework.ui.Model;


@Controller
public class HomeController {

    private final GhostNetService ghostNetService;

    public HomeController(GhostNetService ghostNetService) {
        this.ghostNetService = ghostNetService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        int openGhostNetCount = ghostNetService.findAllGhostNets().size();
        model.addAttribute("openGhostNetCount", openGhostNetCount);
        return "index";
    }
}