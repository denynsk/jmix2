package ru.halmount.jmix2.Repository;

import io.jmix.core.repository.JmixDataRepository;
import ru.halmount.jmix2.entity.User;

import java.util.UUID;

public interface UserRepo extends JmixDataRepository<User, UUID> {
}
