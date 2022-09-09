package ru.halmount.jmix2.Repository

import io.jmix.core.FetchPlan
import io.jmix.core.repository.JmixDataRepository
import io.jmix.core.repository.Query
import org.springframework.data.repository.query.Param
import ru.halmount.jmix2.entity.Teacher

import javax.annotation.Nullable

public interface TeacherRepo extends JmixDataRepository<Teacher,UUID> {
    @Query("select t from Teacher t where t.user.firstName = :firstName and t.user.lastName = :lastName")
    List<Teacher> findTeachersByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    Teacher getById(UUID id, @Nullable FetchPlan fetchPlan);
}