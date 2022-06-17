import java.util.List;

public class KillerServiceImpl implements KillerService {

    private Repository<Killer> killerRepository;

    public KillerServiceImpl() {
        killerRepository = new RepositoryImpl<Killer>();
    }

    @Override
    public void createKiller(Killer killer) {
        killerRepository.save(killer);
    }

    @Override
    public List<Killer> getAllKillers() {
        return killerRepository.findAll();
    }

    @Override
    public Killer getKillerById(int id) {
        return killerRepository.findFirst(k -> k.getId() == id)
                .orElseThrow(() -> new KillerNotFoundException(id));
    }

    @Override
    public void modifyKiller(int id, Killer newKiller) {
        killerRepository.findFirst(k -> k.getId() == id)
            .ifPresentOrElse(killer -> {
                killer.setName(killer.getName());
                killer.setHp(killer.getHp());
                killer.setHasMori(killer.hasMori());
                killerRepository.update(killer);
            }, () -> {
                throw new KillerNotFoundException(id);
            }
        );
    }

    @Override
    public void deleteKiller(int id) {
        killerRepository.findFirst(k -> k.getId() == id)
            .ifPresentOrElse(killer -> 
                killerRepository.delete(killer)
            ,() -> { 
                throw new KillerNotFoundException(id);   
            }
        );
    }
}
