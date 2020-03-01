package org.ibrahimhilali.TimeTracker.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "PluginSettingsState",
        storages = @com.intellij.openapi.components.Storage("TimeTrackerPluginState.xml")
)
public class Storage implements PersistentStateComponent<PluginState> {

    private PluginState state;

    Storage() {
        state = new PluginState();
    }

    public static PersistentStateComponent<PluginState> getInstance() {
        return ServiceManager.getService(Storage.class);
    }

    @Nullable
    @Override
    public PluginState getState() {
        return state;
    }
    @Override
    public void loadState(@NotNull PluginState state) {
        this.state = state;
    }
}
