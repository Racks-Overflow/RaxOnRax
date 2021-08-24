package repository;

import domain.AdminAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAccountRepo extends CrudRepository<Long, AdminAccount> {
}
