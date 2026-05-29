package de.iu.ipwa02.ghostnet.controller;

import de.iu.ipwa02.ghostnet.model.GhostNet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GhostNetController {

    @GetMapping("/ghostnets/new")
    public String showReportForm(Model model) {
        model.addAttribute("ghostNet", new GhostNet());
        return "report-net";
    }
}