package menus;

import models.Genie;
import models.MagicLamp;

import java.util.List;

public class SelectGenieMenu extends SelectMenu<Genie> {

    private final MagicLamp lamp;

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
    protected void openNextMenu(Genie genie) throws InterruptedException {
        new GenieMenu(lamp, genie).show();
    }

}
