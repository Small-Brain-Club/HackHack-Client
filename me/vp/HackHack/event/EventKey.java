package me.vp.HackHack.event;

public class EventKey extends Event {
    private int key;

    public EventKey(int key) { this.key = key;}

    public EventKey() {

    }

    public int getKey() {
        return key;

    }
}