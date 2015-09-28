package edu.rosehulman.jam.assignment6.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class StatusModel extends Observable {
    private List<String> statusList;

    public StatusModel() {
    }

    public void reinitializeStatusList() {
        statusList = new ArrayList<>();
        notifyObservers(statusList);
    }

    public void addStatusLine(String statusLine) {
        if (statusList == null) {
            statusList = new ArrayList<>();
        }
        statusList.add(statusLine);
        notifyObservers(statusList);
    }

    public List<String> getStatusList() {
        return statusList;
    }
}
