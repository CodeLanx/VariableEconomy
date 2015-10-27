package com.codelanx.veconomy;

import com.codelanx.codelanxlib.econ.CEconomy;
import com.codelanx.codelanxlib.listener.ListenerManager;
import com.codelanx.codelanxlib.logging.Logging;
import com.codelanx.veconomy.data.DataFacade;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

/**
 * Created by Rogue on 10/27/2015.
 */
public class VariableEconomy extends JavaPlugin {

    private CEconomy econ;
    private DataFacade data;

    public void onEnable() {
        try {
            this.data = new DataFacade(this);
        } catch (SQLException ex) {
            Logging.simple().error(ex, "Error initializing data handler!");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        ListenerManager.registerListener(new ItemChangeListener(this));
        this.econ = new CEconomy(this);
    }

    public DataFacade getData() {
        return this.data;
    }

}
