package models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author ArvikV
 * @version 1.0
 * @since 14.01.2022
 */
@Entity
@Table(name = "model")
public class AutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public AutoModel() {
    }

    public AutoModel(String name) {
        this.name = name;
    }

    public static AutoModel of(String name) {
        AutoModel model = new AutoModel();
        model.name = name;
        return model;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AutoModel autoModel = (AutoModel) o;
        return id == autoModel.id && Objects.equals(name, autoModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AutoModel{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
