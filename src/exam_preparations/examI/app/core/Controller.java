package exam_preparations.examI.app.core;

import app.entities.Benders.Bender;
import app.entities.Monuments.Monument;
import app.entities.Nations.Nation;
import app.factories.BenderFactory;
import app.factories.MonumentFactory;

import java.util.ArrayList;
import java.util.List;

import static app.utilities.Constant.*;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class Controller {
    private static Nation airNation = new Nation();
    private static Nation fireNation = new Nation();
    private static Nation waterNation = new Nation();
    private static Nation earthNation = new Nation();
    public List<String> wars = new ArrayList<>();
    private int warsCounter = 0;

    public void startWar (String nation) {
        warsCounter++;
        wars.add(String.format("War %d issued by %s", this.warsCounter, nation));

        double airNationPower = airNation.getNationPower();
        double fireNationPower = fireNation.getNationPower();
        double waterNationPower = waterNation.getNationPower();
        double earthNationPower = earthNation.getNationPower();

        if (airNationPower > fireNationPower && airNationPower > waterNationPower && airNationPower > earthNationPower) {
            clearLoosers(fireNation, waterNation, earthNation);
        } else if (fireNationPower > airNationPower && fireNationPower > waterNationPower && fireNationPower > earthNationPower) {
            clearLoosers(airNation, waterNation, earthNation);
        } else if (waterNationPower > airNationPower && waterNationPower > fireNationPower && waterNationPower > earthNationPower) {
            clearLoosers(airNation, fireNation, earthNation);
        } else { //earth
            clearLoosers(airNation, fireNation, waterNation);
        }
    }

    private void clearLoosers(Nation n1, Nation n2, Nation n3) {
        n1.clearBendersAndMonuments();
        n2.clearBendersAndMonuments();
        n3.clearBendersAndMonuments();
    }

    public String getStatus(String type) {
        Nation currNation = getType(type);
        StringBuilder builder = new StringBuilder();
        builder.append(type).append(" Nation").append(System.lineSeparator());
        if (currNation.getBenders().size() > 0) {
            builder.append("Benders:").append(System.lineSeparator());
            for (Bender bender : currNation.getBenders()) {
                builder.append(bender).append(System.lineSeparator());
            }
        } else {
            builder.append("Benders: None").append(System.lineSeparator());
        }
        if (currNation.getMonuments().size() > 0) {
            builder.append("Monuments:").append(System.lineSeparator());
            for (Monument monument : currNation.getMonuments()) {
                builder.append(monument).append(System.lineSeparator());
            }
        } else {
            builder.append("Monuments: None").append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    private Nation getType(String type) {
        switch (type) {
            case AIR:
                return airNation;
            case FIRE:
                return fireNation;
            case WATER:
                return waterNation;
            case EARTH:
                return earthNation;
            default:
                return null;
        }
    }

    public void createBender(String type, String name, int power, double secondaryAbility) {
        Bender currBender;
        switch (type) {
            case AIR:
                currBender = BenderFactory.createBender(type, name, power, secondaryAbility);
                airNation.addBenders(currBender);
                break;
            case FIRE:
                currBender = BenderFactory.createBender(type, name, power, secondaryAbility);
                fireNation.addBenders(currBender);
                break;
            case WATER:
                currBender = BenderFactory.createBender(type, name, power, secondaryAbility);
                waterNation.addBenders(currBender);
                break;
            case EARTH:
                currBender = BenderFactory.createBender(type, name, power, secondaryAbility);
                earthNation.addBenders(currBender);
                break;
        }
    }

    public void createMonument(String type, String name, int affinity) {
        Monument currMonument;
        switch (type) {
            case AIR:
                currMonument = MonumentFactory.createMonument(type, name, affinity);
                airNation.addMonuments(currMonument);
                break;
            case FIRE:
                currMonument = MonumentFactory.createMonument(type, name, affinity);
                fireNation.addMonuments(currMonument);
                break;
            case WATER:
                currMonument = MonumentFactory.createMonument(type, name, affinity);
                waterNation.addMonuments(currMonument);
                break;
            case EARTH:
                currMonument = MonumentFactory.createMonument(type, name, affinity);
                earthNation.addMonuments(currMonument);
                break;
        }
    }
}