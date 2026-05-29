package de.iu.ipwa02.ghostnet.repository;

import de.iu.ipwa02.ghostnet.model.GhostNet;
import org.springframework.data.jpa.repository.JpaRepository;
import de.iu.ipwa02.ghostnet.model.GhostNetStatus;

import java.util.List;

public interface GhostNetRepository extends JpaRepository<GhostNet, Long> {

    List<GhostNet> findByStatusIn(List<GhostNetStatus> statuses);
}