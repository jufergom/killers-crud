import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RepositoryImpl<T extends Comparable<T>> implements Repository<T> {

    private List<T> genericList;

    public RepositoryImpl() {
        genericList = new ArrayList<>();
    }

    @Override
    public List<T> findAll() {
        return genericList;
    }

    @Override
    public List<T> filter(Predicate<? super T> predicate) {
        return genericList.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public Optional<T> findFirst(Predicate<? super T> predicate) {
        return genericList.stream().filter(predicate).findFirst();
    }

    @Override
    public boolean save(T entity) {
        return genericList.add(entity);
    }

    @Override
    public boolean update(T entity) {
        for(int i = 0; i < genericList.size(); i++) {
            if(genericList.get(i).compareTo(entity) == 0) {
                genericList.set(i, entity);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(T entity) {
        return genericList.remove(entity);
    }   
}