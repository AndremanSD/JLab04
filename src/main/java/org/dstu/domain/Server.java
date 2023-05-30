package org.dstu.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Server {
    private int id;
    private String name;
    private boolean running;
    private Set<SSD> staff = new LinkedHashSet<>();

    @Basic
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
    @Column(name = "running")
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @OneToMany(mappedBy = "server")
    public Set<SSD> getStaff() {
        return staff;
    }

    public void setStaff(Set<SSD> staff) {
        this.staff = staff;
    }
}
