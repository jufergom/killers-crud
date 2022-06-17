public class Killer implements Comparable<Killer> {

    private int id;

    private String name;

    private int hp;

    private boolean hasMori;

    public Killer(int id, String name, int hp, boolean hasMori) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.hasMori = hasMori;
    }

    public Killer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean hasMori() {
        return hasMori;
    }

    public void setHasMori(boolean hasMori) {
        this.hasMori = hasMori;
    }

    @Override
    public String toString() {
        return "Killer [id=" + id + ", name=" + name + ", hp=" + hp + ", hasMori=" + hasMori + "]";
    }

    @Override
    public int compareTo(Killer other) {
        return Integer.valueOf(this.getId()).compareTo(Integer.valueOf(other.getId()));
    }
}