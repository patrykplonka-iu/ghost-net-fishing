package de.iu.ipwa02.ghostnet.service;

import de.iu.ipwa02.ghostnet.model.GhostNet;
import de.iu.ipwa02.ghostnet.repository.GhostNetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GhostNetService {

    private final GhostNetRepository ghostNetRepository;

    public GhostNetService(GhostNetRepository ghostNetRepository) {
        this.ghostNetRepository = ghostNetRepository;
    }

    public List<GhostNet> findAllGhostNets() {
        return ghostNetRepository.findAll();
    }

    public GhostNet saveGhostNet(GhostNet ghostNet) {
        return ghostNetRepository.save(ghostNet);
    }
}