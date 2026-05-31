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
        if (Boolean.TRUE.equals(ghostNet.getAnonymousReport())) {
            ghostNet.setReporterName(null);
            ghostNet.setReporterPhone(null);
        }

    return ghostNetRepository.save(ghostNet);
}

    public void assignRescuer(Long id, String rescuerName, String rescuerPhone) {
        GhostNet ghostNet = findGhostNetById(id);

        if (ghostNet.getStatus() != GhostNetStatus.GEMELDET) {
            throw new IllegalStateException("Die Bergung kann nur für gemeldete Geisternetze übernommen werden.");
        }

        ghostNet.setRescuerName(rescuerName);
        ghostNet.setRescuerPhone(rescuerPhone);
        ghostNet.setStatus(GhostNetStatus.BERGUNG_BEVORSTEHEND);
        ghostNetRepository.save(ghostNet);
    }

    public void markAsRecovered(Long id) {
        GhostNet ghostNet = findGhostNetById(id);

        if (ghostNet.getStatus() != GhostNetStatus.BERGUNG_BEVORSTEHEND) {
            throw new IllegalStateException("Nur Geisternetze mit bevorstehender Bergung können als geborgen gemeldet werden.");
        }

        ghostNet.setStatus(GhostNetStatus.GEBORGEN);
        ghostNetRepository.save(ghostNet);
    }

    public void markAsMissing(Long id, String reporterName, String reporterPhone) {
        GhostNet ghostNet = findGhostNetById(id);

        if (ghostNet.getStatus() != GhostNetStatus.GEMELDET) {
            throw new IllegalStateException("Nur gemeldete Geisternetze können als verschollen gemeldet werden.");
        }

        ghostNet.setReporterName(reporterName);
        ghostNet.setReporterPhone(reporterPhone);
        ghostNet.setAnonymousReport(false);
        ghostNet.setStatus(GhostNetStatus.VERSCHOLLEN);
        ghostNetRepository.save(ghostNet);
    }  

    public List<GhostNet> findOpenGhostNets() {
    return ghostNetRepository.findByStatusIn(List.of(
            GhostNetStatus.GEMELDET,
            GhostNetStatus.BERGUNG_BEVORSTEHEND
    ));
    }
}