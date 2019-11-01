package com.daffodil.varsity.aupf.model;

public class EventSegments {
    private String eventName;
    private String eventDate;

    public EventSegments(String eventName, String eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }
}
