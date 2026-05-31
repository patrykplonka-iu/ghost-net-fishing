package de.iu.ipwa02.ghostnet.controller;

import de.iu.ipwa02.ghostnet.model.GhostNet;
import de.iu.ipwa02.ghostnet.service.GhostNetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
public String saveGhostNet(@Valid GhostNet ghostNet, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "report-net";
    }

    ghostNetService.saveGhostNet(ghostNet);
    return "redirect:/ghostnets";
}

    @GetMapping("/ghostnets/{id}/assign")
    public String showAssignForm(@PathVariable Long id, Model model) {
        model.addAttribute("ghostNet", ghostNetService.findGhostNetById(id));
        return "assign-rescuer";
    }

    @PostMapping("/ghostnets/{id}/assign")
    public String assignRescuer(
            @PathVariable Long id,
            @RequestParam String rescuerName,
            @RequestParam String rescuerPhone) {

        ghostNetService.assignRescuer(id, rescuerName, rescuerPhone);
        return "redirect:/ghostnets";
    }

    @PostMapping("/ghostnets/{id}/recover")
    public String markAsRecovered(@PathVariable Long id) {
        ghostNetService.markAsRecovered(id);
        return "redirect:/ghostnets";
    }
    @GetMapping("/ghostnets/{id}/missing")
    public String showMissingForm(@PathVariable Long id, Model model) {
        model.addAttribute("ghostNet", ghostNetService.findGhostNetById(id));
        return "mark-missing";
    }
    @PostMapping("/ghostnets/{id}/missing")
    public String markAsMissing(
            @PathVariable Long id,
            @RequestParam String reporterName,
            @RequestParam String reporterPhone) {

        ghostNetService.markAsMissing(id, reporterName, reporterPhone);
        return "redirect:/ghostnets";
    }
    @GetMapping("/ghostnets/open")
    public String showOpenGhostNets(Model model) {
        model.addAttribute("ghostNets", ghostNetService.findOpenGhostNets());
        return "open-ghostnets";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException exception, Model model) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "error";
    }
}