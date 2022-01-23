package integration;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author ArvikV
 * @version 1.0
 * @since 23.01.2022
 */
public class InOrder {
    private int id;
    private String name;
    private String description;
    private Timestamp created;

    public InOrder() {
    }

    public InOrder(int id, String name, String description, Timestamp created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public static InOrder of(String name, String description) {
        InOrder o = new InOrder();
        o.name = name;
        o.description = description;
        o.created = new Timestamp(System.currentTimeMillis());
        return o;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InOrder inOrder = (InOrder) o;
        return id == inOrder.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
