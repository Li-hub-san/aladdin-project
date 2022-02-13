package menus;

import java.util.List;
import models.Genie;
import models.MagicLamp;

/**
 * Menu to select a genie from a lamp's genies list.
 */
public class SelectGenieMenu extends SelectMenu<Genie> {

    /**
     * Selected lamp.
     */
    private final MagicLamp lamp;

    /**
     * Requires a selected lamp to initialize the {@link SelectGenieMenu}.
     *
     * @param lamp selected lamp.
     */
    public SelectGenieMenu(MagicLamp lamp) {
        this.lamp = lamp;
    }

    @Override
    protected String getMenuName() {
        return "select genie";
    }

    @Override
    protected List<Genie> getList() {
        return lamp.getGenies();
    }

    @Override
    protected void openNextMenu(Genie genie) {
        new GenieMenu(lamp, genie).show();
    }

}
