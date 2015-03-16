package foods.domain;

import static foods.domain.Money.SEK;

public class  Menu {
    public static final Main HAMBURGER = new Main(SEK(10), 240);
    public static final Main FISH_BURGER = new Main(SEK(20), 390);
    public static final Main GIGANTIC_BURGER_WITH_BACON = new Main(SEK(60), 610);
    public static final Main CHICKEN_SANDWICH = new Main(SEK(50), 430);
    public static final Main HOTDOG = new Main(SEK(25), 290);

    public static final SideOrder SMALL_FRENCH_FRIES = new SideOrder(SEK(20), 230, Size.SMALL);
    public static final SideOrder LARGE_FRENCH_FRIES = new SideOrder(SEK(30), 510, Size.LARGE);
    public static final SideOrder SMALL_CHOCOLATE_MILKSHAKE = new SideOrder(SEK(20), 560, Size.SMALL);
    public static final SideOrder APPLE_PIE = new SideOrder(SEK(20), 250);

    public static final Beverage MEDIUM_LATTE = new Beverage(SEK(30), 210, Size.MEDIUM);
    public static final Beverage LARGE_LATTE = new Beverage(SEK(40), 280, Size.LARGE);
    public static final Beverage MEDIUM_COKE = new Beverage(SEK(20), 200, Size.MEDIUM);
    public static final Beverage LARGE_DIET_COKE = new Beverage(SEK(30), 0, Size.LARGE, Beverage.BeverageType.DIET);
}
