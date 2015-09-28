package edu.rosehulman.jam.assignment6.controller;

import edu.rosehulman.jam.assignment6.model.StatusModel;
import edu.rosehulman.jam.assignment6.view.StatusView;

public class StatusController {
    //StatusView view = new StatusView();
    StatusModel model = new StatusModel();

    public void printToWindow(String stringToPrint) {
        model.addStatusLine(stringToPrint);
    }

    public void newPluginLoaded() {
        model.reinitializeStatusList();
    }
}
