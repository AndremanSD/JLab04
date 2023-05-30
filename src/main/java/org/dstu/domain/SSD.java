package org.dstu.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SSD {
    private int id;
    private String name;
    private Integer capacity;
    private String size;
    private Integer readSpeed;
    private Integer writeSpeed;
    private Server server;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "readSpeed")
    public Integer getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(Integer readSpeed) {
        this.readSpeed = readSpeed;
    }

    @Basic
    @Column(name = "writeSpeed")
    public Integer getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(Integer writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "server_id")
    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SSD ssd = (SSD) o;
        return id == ssd.id && Objects.equals(name, ssd.name) && Objects.equals(capacity, ssd.capacity) && Objects.equals(size, ssd.size) && Objects.equals(readSpeed, ssd.readSpeed) && Objects.equals(writeSpeed, ssd.writeSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity, size, readSpeed, writeSpeed);
    }
}
