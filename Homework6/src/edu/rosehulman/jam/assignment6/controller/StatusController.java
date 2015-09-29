package edu.rosehulman.jam.assignment6.controller;

import edu.rosehulman.jam.assignment6.PluginCommons.IStatusController;
import edu.rosehulman.jam.assignment6.model.StatusModel;
import edu.rosehulman.jam.assignment6.view.StatusView;

public class StatusController implements IStatusController {
    StatusModel model = new StatusModel();
    StatusView view = new StatusView();

    public StatusController() {
        model.addObserver(view);
    }

    public void printToWindow(String stringToPrint) {
        model.addStatusLine(stringToPrint);
    }

    public void newPluginLoaded() {
        model.reinitializeStatusList();
    }
}
