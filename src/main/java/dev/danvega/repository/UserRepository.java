package dev.danvega.repository;

import dev.danvega.domain.users.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
