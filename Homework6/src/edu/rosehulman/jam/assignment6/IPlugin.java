package edu.rosehulman.jam.assignment6;

import edu.rosehulman.jam.assignment6.controller.StatusController;
import edu.rosehulman.jam.assignment6.view.ExecuteView;

/**
 * Created by maken on 9/28/15.
 */
public interface IPlugin {
    void load(ExecuteView view, StatusController statusController);
    void run();
    void unload();
}
