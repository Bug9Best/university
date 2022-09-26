
public class Player {
    private String name;
    private String team;

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void setTeam(String t) {
        this.team = t;
    }

    public String getTeam() {
        return this.team;
    }

    public boolean isSameTeam(Player p) {
        return this.getTeam().equals(p.getTeam());
    }
}
