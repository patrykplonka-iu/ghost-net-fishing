package de.iu.ipwa02.ghostnet.service;

import de.iu.ipwa02.ghostnet.model.GhostNet;
import de.iu.ipwa02.ghostnet.model.GhostNetStatus;
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

    public GhostNet findGhostNetById(Long id) {
        return ghostNetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Geisternetz nicht gefunden"));
    }

    public GhostNet saveGhostNet(GhostNet ghostNet) {
        return ghostNetRepository.save(ghostNet);
    }

    public void assignRescuer(Long id, String rescuerName, String rescuerPhone) {
        GhostNet ghostNet = findGhostNetById(id);

        if (ghostNet.getStatus() == GhostNetStatus.GEMELDET) {
            ghostNet.setRescuerName(rescuerName);
            ghostNet.setRescuerPhone(rescuerPhone);
            ghostNet.setStatus(GhostNetStatus.BERGUNG_BEVORSTEHEND);
            ghostNetRepository.save(ghostNet);
        }
    }
    public void markAsRecovered(Long id) {
    GhostNet ghostNet = findGhostNetById(id);

    if (ghostNet.getStatus() == GhostNetStatus.BERGUNG_BEVORSTEHEND) {
        ghostNet.setStatus(GhostNetStatus.GEBORGEN);
        ghostNetRepository.save(ghostNet);
        }
    }
    public void markAsMissing(Long id, String reporterName, String reporterPhone) {
        GhostNet ghostNet = findGhostNetById(id);

        if (ghostNet.getStatus() == GhostNetStatus.GEMELDET) {
            ghostNet.setReporterName(reporterName);
            ghostNet.setReporterPhone(reporterPhone);
            ghostNet.setAnonymousReport(false);
            ghostNet.setStatus(GhostNetStatus.VERSCHOLLEN);
            ghostNetRepository.save(ghostNet);
        }
    }   
}