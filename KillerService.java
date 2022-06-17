import java.util.List;

public interface KillerService {
    void createKiller(Killer killer);

    List<Killer> getAllKillers();

    Killer getKillerById(int id);

    void modifyKiller(int id, Killer newKiller);

    void deleteKiller(int id);
}
