package menus;

import models.MagicLamp;

import java.util.List;

public class SelectLampMenu extends SelectMenu<MagicLamp> {

    private final List<MagicLamp> lamps;

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
    protected void openNextMenu(MagicLamp lamp) throws InterruptedException {
        new LampMenu(lamp).show();
    }

}
