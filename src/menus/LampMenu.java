package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import models.Genie;
import models.MagicLamp;

import java.text.Normalizer;
import java.util.*;
import java.util.stream.Collectors;

public class LampMenu extends Menu {

    private final MagicLamp lamp;

    public LampMenu(MagicLamp lamp) {
        this.lamp = lamp;
    }

    @Override
    protected void printMenu() {
        MenuHelper.printTopLimit("lamp menu");
        MenuHelper.printTopLimit("magic lamp " + lamp.getId(), ".", "");
        System.out.println("1 - Rub Lamp");
        System.out.println("2 - Available Genies");
        System.out.println("3 - Released Genies");
        System.out.println("4 - Recharge history");
        if (lamp.hasGenies()) {
            System.out.println("5 - Select Genie");
            System.out.println("6 - List Genies");
            System.out.println("7 - Popular wishes");
        }
        System.out.println("0 - Previous menu");
        MenuHelper.printBottomLimit();
    }

    @Override
    protected void handleMenuChoice() throws InterruptedException {
        int choice = MenuHelper.requestOption();

        switch (choice) {
            case 1 -> {
                System.out.println("How many wishes do you want this genie to grant? ");
                Scanner scanner = new Scanner(System.in);
                int wishLimit = scanner.nextInt();
                lamp.rub(wishLimit);
            }
            case 2 -> MenuHelper.printOptionResponse("MagicLamp " + lamp.getId() + " -> " + lamp.getAvailableGenies() + " available genie(s).");
            case 3 -> MenuHelper.printOptionResponse("MagicLamp " + lamp.getId() + " -> released " + lamp.getGenieCounter() + " genie(s).");
            case 4 -> MenuHelper.printOptionResponse("MagicLamp " + lamp.getId() + " -> recharged " + lamp.getRechargeCounter() + " time(s).");
            case 5 -> {
                if (lamp.hasGenies()) {
                    new SelectGenieMenu(lamp).show();
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 6 -> {
                if (lamp.hasGenies()) {
                    printGenies(lamp.getGenies());
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 7 -> printPopularWishes();
            case 0 -> keepLooping = false;
            default -> ExceptionHelper.handleInputException();
        }
    }

    /**
     * Receives a list of Genies and prints all elements.
     *
     * @param genies List of Genies
     */
    private void printGenies(List<Genie> genies) {
        MenuHelper.printTopLimit("genie List", "'");
        genies.forEach(System.out::println);
        MenuHelper.printBottomLimit("'");
    }

    private void printPopularWishes() {
        MenuHelper.printTopLimit("popular wishes", "'");
        MenuHelper.printTopLimit("magic lamp " + lamp.getId(), ".", "");

        List<String> allWishes = getAllWishes();
        HashMap<String, Integer> cumulativeWishMap = getCumulativeWishMap(allWishes);
        printRepeatedWishes(cumulativeWishMap);

        MenuHelper.printBottomLimit("'");
    }

    private void printRepeatedWishes(HashMap<String, Integer> cumulativeWishMap) {
        Map<String, Integer> sortedWishMap = sortByPopularity(cumulativeWishMap);

        boolean hasPopularWishes = false;
        for (Map.Entry<String, Integer> entry : sortedWishMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": granted " + entry.getValue() + " time(s)!");
                hasPopularWishes = true;
            }
        }

        if (cumulativeWishMap.size() == 0) {
            MenuHelper.printOptionResponse("No wishes registered yet!");
            MenuHelper.printOptionResponse("Select a Genie to make a wish!");
        } else if (!hasPopularWishes) {
            MenuHelper.printOptionResponse("You were very original asking for wishes!");
        }
    }

    private List<String> getAllWishes() {
        List<String> allWishes = new ArrayList<>();

        for (Genie genie : lamp.getGenies()) {
            allWishes.addAll(genie.getWishes());
        }

        return allWishes;
    }

    private HashMap<String, Integer> getCumulativeWishMap(List<String> wishes) {
        List<String> normalizedWishes = normalizeWishes(wishes);

        HashMap<String, Integer> repeatedWishList = new HashMap<>();
        for (String wish1 : normalizedWishes) {
            Integer wishCounter = 0;
            for (String wish2 : normalizedWishes) {
                if (Objects.equals(wish1, wish2)) {
                    wishCounter++;
                    repeatedWishList.put(wish2, wishCounter);
                }
            }
        }

        return repeatedWishList;
    }

    private List<String> normalizeWishes(List<String> wishes) {
        List<String> normalizedWishes = new ArrayList<>();

        for (String wish : wishes) {
            String normalizedWish = Normalizer.normalize(wish, Normalizer.Form.NFD)
                    .toLowerCase()
                    .replaceAll("[^a-z0-9€$ ]", "")
                    .trim();
            normalizedWishes.add(normalizedWish);
        }

        return normalizedWishes;
    }

    private Map<String, Integer> sortByPopularity(HashMap<String, Integer> wishesMap) {
        return wishesMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2 - o1))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new)
                );
    }

}
