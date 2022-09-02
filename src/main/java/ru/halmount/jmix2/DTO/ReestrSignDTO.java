package ru.halmount.jmix2.DTO;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;
import ru.halmount.jmix2.entity.Reestr;

import java.util.UUID;

@JmixEntity(name = "jmix2_ReestrSignDTO")
public class ReestrSignDTO {
    @JmixGeneratedValue
    @JmixId
    private UUID id;

    private TeacherDTO teacher;

    private Reestr reestr;

    public Reestr getReestr() {
        return reestr;
    }

    public void setReestr(Reestr reestr) {
        this.reestr = reestr;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}