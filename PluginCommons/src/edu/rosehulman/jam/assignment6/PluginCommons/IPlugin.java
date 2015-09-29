package edu.rosehulman.jam.assignment6.PluginCommons;

/**
 * Created by maken on 9/28/15.
 */
public interface IPlugin {
    void load(IExecuteView view, IStatusController statusController);
    void run();
    void unload();
}
