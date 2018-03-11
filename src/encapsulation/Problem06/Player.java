package encapsulation.Problem06;

/**
 * Created by Chilly on 02.11.2017 г..
 */
public class Player {
    private static final String ENDURANCE_DEFAULT = "Endurance";
    private static final String SPRINT_DEFAULT = "Sprint";
    private static final String DRIBBLE_DEFAULT = "Dribble";
    private static final String PASSING_DEFAULT = "Passing";
    private static final String SHOOTING_DEFAULT = "Shooting";
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;
    private double average;

    public Player(String name, int e, int sp, int d, int p, int sh) {
        this.setName(name);
        this.setEndurance(e);
        this.setSprint(sp);
        this.setDribble(d);
        this.setPassing(p);
        this.setShooting(sh);
        this.setAverage();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setEndurance(int endurance) {
        if(checkValue(endurance, ENDURANCE_DEFAULT)) {
            this.endurance = endurance;
        }
    }

    private void setSprint(int sprint) {
        if (checkValue(sprint, SPRINT_DEFAULT)) {
            this.sprint = sprint;
        }
    }

    private void setDribble(int dribble) {
        if (checkValue(dribble, DRIBBLE_DEFAULT)) {
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if (checkValue(passing, PASSING_DEFAULT)) {
            this.passing = passing;
        }
    }

    private void setShooting(int shooting) {
        if (checkValue(shooting, SHOOTING_DEFAULT)) {
            this.shooting = shooting;
        }
    }

    private void setAverage() {
        this.average = (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }

    public double getAverage() {
        return this.average;
    }

    private boolean checkValue(int value, String currStat) {
        if (value < 1 || value > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", currStat));
        }
        return true;
    }
}