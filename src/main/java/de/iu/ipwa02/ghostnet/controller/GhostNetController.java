package de.iu.ipwa02.ghostnet.controller;

import de.iu.ipwa02.ghostnet.model.GhostNet;
import de.iu.ipwa02.ghostnet.service.GhostNetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GhostNetController {

    private final GhostNetService ghostNetService;

    public GhostNetController(GhostNetService ghostNetService) {
        this.ghostNetService = ghostNetService;
    }

    @GetMapping("/ghostnets")
    public String showGhostNets(Model model) {
        model.addAttribute("ghostNets", ghostNetService.findAllGhostNets());
        return "ghostnets";
    }

    @GetMapping("/ghostnets/new")
    public String showReportForm(Model model) {
        model.addAttribute("ghostNet", new GhostNet());
        return "report-net";
    }

    @PostMapping("/ghostnets")
    public String saveGhostNet(GhostNet ghostNet) {
        ghostNetService.saveGhostNet(ghostNet);
        return "redirect:/ghostnets";
    }
}