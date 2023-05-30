package org.dstu.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class HDD {
    private int id;
    private String name;
    private Integer capacity;
    private String size;
    private Integer rpm;

    private String interf;
    private int transcriptNum;

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
        @Column(name = "rpm")
        public Integer getRpm() {
            return rpm;
        }

        public void setRpm(Integer rpm) {
            this.rpm = rpm;
        }
    @Basic
    @Column(name = "interf")
    public String getInterface() { return interf; }

    public void setInterface(String interf) {
        this.interf = interf;
    }



    @Basic
    @Column(name = "transcript_num")
    public int getTranscriptNum() {
        return transcriptNum;
    }

    public void setTranscriptNum(int transcriptNum) {
        this.transcriptNum = transcriptNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HDD student = (HDD) o;
        return id == student.id && transcriptNum == student.transcriptNum && Objects.equals(name, student.name) && Objects.equals(capacity, student.capacity) && Objects.equals(size, student.size) && Objects.equals(rpm, student.rpm) && Objects.equals(interf, student.interf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity, size, rpm, interf, transcriptNum);
    }
}
