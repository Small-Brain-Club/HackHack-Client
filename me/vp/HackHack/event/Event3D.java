package me.vp.HackHack.event;

public class Event3D extends Event {
    private final float partialTicks;

    public Event3D(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }

}
