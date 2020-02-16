package dev.esz.users.api.users.repository;

import dev.esz.users.api.users.data.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
