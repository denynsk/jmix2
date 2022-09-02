package ru.halmount.jmix2.Repository

import io.jmix.core.Id
import io.jmix.core.repository.JmixDataRepository
import io.jmix.core.repository.Query
import liquibase.pro.packaged.T
import org.springframework.data.repository.NoRepositoryBean
import org.yaml.snakeyaml.events.Event
import ru.halmount.jmix2.entity.Reestr

public interface ReestrRepo extends JmixDataRepository<ReestrRepo, UUID> {

    ReestrRepo findByNum( Integer num);
}