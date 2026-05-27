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

// Neue Geisternetze werden standardmäßig als gemeldet angelegt.
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

    public Double getEstimatedSize() {
        return estimatedSize;
    }

    public void setEstimatedSize(Double estimatedSize) {
        this.estimatedSize = estimatedSize;
    }

    public GhostNetStatus getStatus() {
        return status;
    }

    public void setStatus(GhostNetStatus status) {
        this.status = status;
    }

    public Boolean getAnonymousReport() {
        return anonymousReport;
    }

    public void setAnonymousReport(Boolean anonymousReport) {
        this.anonymousReport = anonymousReport;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getReporterPhone() {
        return reporterPhone;
    }

    public void setReporterPhone(String reporterPhone) {
        this.reporterPhone = reporterPhone;
    }

    public String getRescuerName() {
        return rescuerName;
    }

    public void setRescuerName(String rescuerName) {
        this.rescuerName = rescuerName;
    }

    public String getRescuerPhone() {
        return rescuerPhone;
    }

    public void setRescuerPhone(String rescuerPhone) {
        this.rescuerPhone = rescuerPhone;
    }
}