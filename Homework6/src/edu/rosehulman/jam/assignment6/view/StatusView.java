package edu.rosehulman.jam.assignment6.view;

import edu.rosehulman.jam.assignment6.model.StatusModel;

import java.awt.*;

public class StatusView {
    private TextArea myTextField;
    private StatusModel model;
    public StatusView(StatusModel model) {
        this.model = model;
    }

    public void modelChanged() {
        this.model.getStatusList();
    }
}
