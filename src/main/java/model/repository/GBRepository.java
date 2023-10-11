package notebook.model.repository;

import notebook.model.User;

import java.util.List;
import java.util.Optional;

public interface GBRepository {

    List<String> readAll();
    void saveAll(List<String> data);
    List<User> findAll();
    void create(User user);

    Optional<User> update(Long userId, User update);
    boolean delete(Long id);
}
