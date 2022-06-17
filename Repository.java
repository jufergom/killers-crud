import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<T> {

    List<T> findAll();

    List<T> filter(Predicate<? super T> predicate);

    Optional<T> findFirst(Predicate<? super T> predicate);

    boolean save(T entity);

    boolean update(T entity);

    boolean delete(T entity);
}