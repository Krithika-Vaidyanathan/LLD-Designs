package components;

import panel.EntrancePanel;
import panel.ExitPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private List<ParkingFloor> floors = new ArrayList<>();
    private Map<String, EntrancePanel> entrancePanels = new HashMap<>();
    private Map<String, ExitPanel> exitPanels = new HashMap<>();

    public ParkingLot(String name) {
        this.name = name;
    }
    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }
    public void addEntrance(String id, EntrancePanel panel) {
        entrancePanels.put(id, panel);
    }
    public void addExit(String id, ExitPanel panel) {
        exitPanels.put(id, panel);
    }
    public List<ParkingFloor> getFloors() {
        return floors;
    }


}
