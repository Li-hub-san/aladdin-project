package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import models.Genie;
import models.MagicLamp;

import java.text.Normalizer;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class that handles the lamp menu.
 */
public class LampMenu extends Menu {

    /**
     * Selected lamp.
     */
    private final MagicLamp lamp;

    /**
     * Requires the selected lamp to initialize the {@link LampMenu}.
     *
     * @param lamp selected lamp.
     */
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

    /**
     * Requests a menu option choice and handles it. Handles invalid choices by calling {@link
     * ExceptionHelper#handleInputException()}.
     */
    @Override
    protected void handleMenuOption(int option) {
        switch (option) {
            case 1 -> {
                System.out.println("How many wishes do you want this genie to grant? ");
                Scanner scanner = new Scanner(System.in);
                int wishLimit = scanner.nextInt();
                if (wishLimit >= 0) {
                    lamp.rub(wishLimit);
                } else {
                    ExceptionHelper.handleInputException();
                }
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
                    printGenies();
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 7 -> {
                if (lamp.hasGenies()) {
                    printPopularWishes();
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 0 -> exitMenu();
            default -> ExceptionHelper.handleInputException();
        }
    }

    /**
     * Prints the selected lamp's list of released genies.
     */
    private void printGenies() {
        MenuHelper.printTopLimit("genie List", "'");
        lamp.getGenies().forEach(System.out::println);
        MenuHelper.printBottomLimit("'");
    }

    /**
     * Gathers all wishes from all genies and prints all which were granted more than once, sorted by repetition
     * (descending).
     */
    private void printPopularWishes() {
        MenuHelper.printTopLimit("popular wishes", "'");
        MenuHelper.printTopLimit("magic lamp " + lamp.getId(), ".", "");

        List<String> allWishes = getAllWishes();
        HashMap<String, Integer> cumulativeWishMap = getCumulativeWishMap(allWishes);
        printRepeatedWishes(cumulativeWishMap);

        MenuHelper.printBottomLimit("'");
    }

    /**
     * Sorts received wishes by popularity and prints all which were granted more than once. Prints an informative
     * message when no wishes were made yet, or no current wishes are repeated more than once.
     */
    private void printRepeatedWishes(HashMap<String, Integer> cumulativeWishMap) {
        LinkedHashMap<String, Integer> sortedWishMap = sortByPopularity(cumulativeWishMap);

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

    /**
     * Returns a list containing all wishes from all released genies within the selected lamp.
     *
     * @return wish list.
     */
    private List<String> getAllWishes() {
        List<String> allWishes = new ArrayList<>();

        for (Genie genie : lamp.getGenies()) {
            allWishes.addAll(genie.getWishes());
        }

        return allWishes;
    }

    /**
     * Normalizes the received wish list and returns a {@code HashMap} containing the wishes as keys and their frequency
     * as values.
     *
     * @param wishes the list of wishes
     * @return HashMap containing wishes as keys and their frequency as values.
     */
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

    /**
     * Returns the formatted list of wishes. Each wish is normalized, lower-cased, devoid of all irrelevant characters
     * and trimmed.
     *
     * @param wishes the list of wishes
     * @return the list of normalized wishes.
     */
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

    /**
     * Returns a {@code LinkedHashMap} containing wishes as keys and their frequency as values, sorted by descending
     * frequency.
     *
     * @param wishesMap HashMap containing wishes as keys and their frequency as values.
     * @return HashMap sorted by descending frequency.
     */
    private LinkedHashMap<String, Integer> sortByPopularity(HashMap<String, Integer> wishesMap) {
        return wishesMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2 - o1))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        )
                );
    }

}
