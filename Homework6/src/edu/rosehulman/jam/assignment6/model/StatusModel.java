package edu.rosehulman.jam.assignment6.model;

import java.util.ArrayList;
import java.util.List;

public class StatusModel {
    private List<String> statusList;

    public StatusModel() {

    }

    public void reinitializeStatusList() {
        statusList = new ArrayList<>();
    }

    public void addStatusLine(String statusLine) {
        if (statusList == null) {
            statusList = new ArrayList<>();
        }
        statusList.add(statusLine);
    }

    public List<String> getStatusList() {
        return statusList;
    }
}
