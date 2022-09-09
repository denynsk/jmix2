package ru.halmount.jmix2.Repository

import io.jmix.core.repository.JmixDataRepository
import ru.halmount.jmix2.entity.Reestr
import ru.halmount.jmix2.entity.Teacher

public interface ReestrRepo extends JmixDataRepository<Reestr, UUID> {

    Reestr getReestrByNum( Integer num);
    List<Reestr> getReestrsByTeacher(Teacher teacher);
}