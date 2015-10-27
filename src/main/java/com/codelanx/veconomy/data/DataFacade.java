package com.codelanx.veconomy.data;

import com.codelanx.codelanxlib.data.types.SQLite;
import com.codelanx.veconomy.VariableEconomy;
import org.bukkit.Location;
import org.bukkit.material.MaterialData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Rogue on 10/27/2015.
 */
public class DataFacade {

    private final VariableEconomy plugin;
    private final SQLite db;

    public DataFacade(VariableEconomy plugin) throws SQLException {
        this.plugin = plugin;
        this.db = new SQLite();
        this.db.open(plugin, "data");
    }

    public void cacheChest(Location... loc) {
        this.db.batchUpdate(Statements.INSERT_CHEST_LOCATION, 10, Arrays.asList(loc), Location::getBlockX, Location::getBlockY, Location::getBlockZ);
    }

    public boolean isCachedChest(Location loc) {
        return this.db.query(ResultSet::next, Statements.GET_CHEST_LOCATION, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()).getResponse();
    }

    public void cacheItems(Map<MaterialData, Integer> items) {
        this.db.batchUpdate(Statements.UPDATE_ITEM_COUNT, 15, items.entrySet(),
                ent -> ent.getKey().getItemType().toString(),
                ent -> ent.getKey().getData(),
                ent -> ent.getValue());
    }

    public void decrement(Map<MaterialData, Integer> items) {
        this.db.batchUpdate(Statements.UPDATE_ITEM_COUNT, 15, items.entrySet(),
                ent -> ent.getKey().getItemType().toString(),
                ent -> ent.getKey().getData(),
                ent -> -ent.getValue());
    }
}
