package com.gamingroom;

/**
 * Base type for all domain entities (id + name).
 */
public abstract class Entity {
    protected final long id;
    protected final String name;

    protected Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId()   { return id; }
    public String getName(){ return name; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + ", name=" + name + "]";
    }
}
