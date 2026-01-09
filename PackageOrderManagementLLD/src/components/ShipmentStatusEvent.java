package components;

import enums.ShipmentStatus;

import java.time.LocalDateTime;

public class ShipmentStatusEvent {
    private ShipmentStatus status;
    private LocalDateTime timestamp;

    public ShipmentStatusEvent(ShipmentStatus status) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
