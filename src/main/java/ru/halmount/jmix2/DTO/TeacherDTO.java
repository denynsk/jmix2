package ru.halmount.jmix2.DTO;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;
import ru.halmount.jmix2.entity.User;

import java.util.UUID;

@JmixEntity(name = "jmix2_TeacherDTO")
public class TeacherDTO {
    @JmixGeneratedValue
    @JmixProperty(mandatory = true)
    @JmixId
    private UUID id;

    private User user;

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