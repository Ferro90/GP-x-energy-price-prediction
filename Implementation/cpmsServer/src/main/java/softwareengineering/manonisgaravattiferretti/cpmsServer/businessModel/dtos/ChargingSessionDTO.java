package softwareengineering.manonisgaravattiferretti.cpmsServer.businessModel.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChargingSessionDTO {
    private Long sessionId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Double kwh;
    private String chargingPointId;
    private Integer socketId;
    private String status;
    private Double totalCost;
    private LocalDateTime lastUpdated;
}
