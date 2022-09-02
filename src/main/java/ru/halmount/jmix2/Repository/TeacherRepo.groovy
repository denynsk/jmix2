package ru.halmount.jmix2.Repository

import io.jmix.core.repository.JmixDataRepository
import ru.halmount.jmix2.entity.Teacher

public interface TeacherRepo extends JmixDataRepository<Teacher,UUID> {

}