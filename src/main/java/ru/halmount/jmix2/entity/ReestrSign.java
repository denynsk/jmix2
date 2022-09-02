package ru.halmount.jmix2.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "JMIX2_REESTR_SIGN", indexes = {
        @Index(name = "IDX_JMIX2_REESTR_SIGN_TEACHER", columnList = "TEACHER_ID"),
        @Index(name = "IDX_JMIX2_REESTR_SIGN_REESTR", columnList = "REESTR_ID")
})
@Entity(name = "jmix2_ReestrSign")
public class ReestrSign {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "TEACHER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @JoinColumn(name = "REESTR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reestr reestr;

    @Column(name = "CREATESIGN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createsign;

    public Date getCreatesign() {
        return createsign;
    }

    public void setCreatesign(Date createsign) {
        this.createsign = createsign;
    }

    public Reestr getReestr() {
        return reestr;
    }

    public void setReestr(Reestr reestr) {
        this.reestr = reestr;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}