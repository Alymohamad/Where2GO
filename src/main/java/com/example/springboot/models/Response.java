package com.example.springboot.models;

import com.example.springboot.Enums.ResponseStatus;

public class Response {

    private Location location;
    private ResponseStatus status;

    public Response(Location location, ResponseStatus status) {
        this.location = location;
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response{" +
                "location=" + location +
                ", status=" + status +
                '}';
    }
}
