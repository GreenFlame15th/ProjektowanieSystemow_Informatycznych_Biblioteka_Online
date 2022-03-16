package com.company;

import java.time.Duration;

public class Cassette implements ICanBeBorrowed{
    private Duration duration;

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
