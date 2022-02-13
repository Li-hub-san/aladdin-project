package menus;

import java.util.List;
import models.MagicLamp;

/**
 * Menu to select a lamp from a list of created lamps.
 */
public class SelectLampMenu extends SelectMenu<MagicLamp> {

    /**
     * List of created lamps.
     */
    private final List<MagicLamp> lamps;

    /**
     * Requires the list of created lamps to initialize the {@link SelectLampMenu}.
     *
     * @param lamps list of created lamps.
     */
    public SelectLampMenu(List<MagicLamp> lamps) {
        this.lamps = lamps;
    }

    @Override
    protected String getMenuName() {
        return "select lamp";
    }

    @Override
    protected List<MagicLamp> getList() {
        return lamps;
    }

    @Override
    protected void openNextMenu(MagicLamp lamp) {
        new LampMenu(lamp).show();
    }

}
