package FixtureGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class FixtureGenerator {
    public List<String> teams;
    public List<List<Pair>> matchUps;
    private Random random = new Random();

    public FixtureGenerator(List<String> teams) {
        this.teams = teams;
        if (teams.size() % 2 == 1) {
            teams.add("Bay");
        }
        matchUps = new ArrayList<>((teams.size() - 1) * 2);
        generateMatchUps(teams);
    }

    public void print() {
        System.out.println("Takımlar");
        for (String team : teams) {
            System.out.println("- " + team);
        }

        for (int i = 0; i < matchUps.size(); i++) {
            System.out.printf("%nRound %d%n", i + 1);
            matchUps.get(i).forEach(System.out::println);
            System.out.println();
        }
    }

    private void generateMatchUps(List<String> teams) {
        teams = shuffle(teams);
        for (int i = 0; i < teams.size() - 1; i++) {
            List<Pair> matches = new ArrayList<>(teams.size() / 2);
            for (Iterator<String> it = teams.iterator(); it.hasNext(); ) {
                matches.add(new Pair(it.next(), it.next()));
            }
            matchUps.add(matches);
            teams = cycle(teams);
        }

        List<List<Pair>> revancheMatchUps = new ArrayList<>(teams.size() - 1);
        for (List<Pair> matches : matchUps) {
            List<Pair> revanches = new ArrayList<>(matches.size());
            for (Pair match : matches) {
                revanches.add(new Pair(match, true));
            }
            revancheMatchUps.add(revanches);
        }
        matchUps.addAll(revancheMatchUps);
    }

    private <T> List<T> shuffle(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(0, pop(list, i + random.nextInt(list.size() - i)));
        }

        return list;
    }

    private <T> List<T> cycle(List<T> list) {
        list.add(pop(list, 0));
        return list;
    }

    private <T> T pop(List<T> list, int idx) {
        int i = 0;
        for (ListIterator<T> it = list.listIterator(); it.hasNext(); ) {
            T item = it.next();
            if (i++ == idx) {
                it.remove();
                return item;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public class Pair {
        private String team1;
        private String team2;

        private Pair(String team1, String team2) {
            this.team1 = team1;
            this.team2 = team2;
        }

        private Pair(Pair pair) {
            this(pair, false);
        }

        private Pair(Pair pair, boolean reverse) {
            if (!reverse) {
                this.team1 = pair.team1;
                this.team2 = pair.team2;
            } else {
                this.team1 = pair.team2;
                this.team2 = pair.team1;
            }
        }

        @Override
        public String toString() {
            return team1 + " vs " + team2;
        }
    }
}
