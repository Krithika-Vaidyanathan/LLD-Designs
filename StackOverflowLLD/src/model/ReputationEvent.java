package model;

import enumTypes.ContentType;

import java.util.Date;

public class ReputationEvent {
    private int delta;
    private String reason;
    private Date timestamp;
    private ContentType contentType;

    public ReputationEvent(int delta, String reason, ContentType contentType) {
        this.delta = delta;
        this.reason = reason;
        this.timestamp = new Date();
        this.contentType = contentType;
    }

    public int getDelta() {
        return delta;
    }


}
