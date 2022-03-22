package FixtureGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.addAll(Arrays.asList(
            "Galatasaray",
            "Bursaspor",
            "Fenerbahçe",
            "Beşiktaş",
            "Başakşehir",
            "Trabzonspor"
        ));

        FixtureGenerator fixtureGenerator = new FixtureGenerator(teams);
        fixtureGenerator.print();
    }
}
