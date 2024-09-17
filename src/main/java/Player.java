import lombok.Getter;

public class Player {
    public int id;
    @Getter
    public String name;
    @Getter
    public int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

}
