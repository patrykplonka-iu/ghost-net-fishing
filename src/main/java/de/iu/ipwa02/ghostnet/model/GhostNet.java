package de.iu.ipwa02.ghostnet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GhostNet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;

    private Double longitude;

    private Double estimatedSize;

    @Enumerated(EnumType.STRING)
    private GhostNetStatus status;

    private Boolean anonymousReport;

    private String reporterName;

    private String reporterPhone;

    private String rescuerName;

    private String rescuerPhone;

    public GhostNet() {
        this.status = GhostNetStatus.GEMELDET;
        this.anonymousReport = false;
    }

    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}