package exam_preparations.examI.app.entities.Nations;

import app.entities.Benders.Bender;
import app.entities.Monuments.Monument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class Nation {
    List<Bender> benders;
    List<Monument> monuments;

    public Nation() {
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    public void clearBendersAndMonuments() {
        this.benders.clear();
        this.monuments.clear();
    }

    public double getNationPower() {
        double nationPower = 0.0;
        for (Bender bender : benders) {
            nationPower += bender.getBenderPower();
        }

        long sum = 0L;
        for (Monument monument : monuments) {
            sum += monument.getMonumentPower();
        }
        nationPower += ( nationPower / 100 ) * sum;
        return nationPower;
    }

    public List<Bender> getBenders() {
        return Collections.unmodifiableList(this.benders);
    }

    public List<Monument> getMonuments() {
        return Collections.unmodifiableList(this.monuments);
    }

    public void addBenders(Bender bender) {
        this.benders.add(bender);
    }

    public void addMonuments(Monument monument) {
        this.monuments.add(monument);
    }
}