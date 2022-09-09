package ru.halmount.jmix2.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "JMIX2_TEACHER", indexes = {
        @Index(name = "IDX_JMIX2_TEACHER_USER", columnList = "USER_ID")
})
@Entity(name = "jmix2_Teacher")
public class Teacher {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "USER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "teacher")
    private List<Reestr> reestrs;

    public List<Reestr> getReestrs() {
        return reestrs;
    }

    public void setReestrs(List<Reestr> reestrs) {
        this.reestrs = reestrs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}