package de.toberkoe.fluentassertions.api.objects.entities;

import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DummyEntity {

    public static final DummyEntity ZERO = new DummyEntity(0);
    public static final DummyEntity POSITIVE = new DummyEntity(1);
    public static final DummyEntity NEGATIVE = new DummyEntity(-1);

    @Id
    @Min(1)
    private long id;

    @NotNull
    private String name;

    @Transient
    private String hobby;

    public DummyEntity() {
    }

    public DummyEntity(long id) {
        this.id = id;
    }

    public DummyEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameModified() {
        return name == null ? "EMPTY" : name;
    }
}
