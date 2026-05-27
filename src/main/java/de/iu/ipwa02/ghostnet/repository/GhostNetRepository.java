package de.iu.ipwa02.ghostnet.repository;

import de.iu.ipwa02.ghostnet.model.GhostNet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GhostNetRepository extends JpaRepository<GhostNet, Long> {
}