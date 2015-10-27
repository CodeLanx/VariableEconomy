package com.codelanx.veconomy;

import com.codelanx.codelanxlib.listener.SubListener;
import org.bukkit.event.entity.EntityCombustEvent;

/**
 * Created by Rogue on 10/27/2015.
 */
public class ItemChangeListener extends SubListener<VariableEconomy> {

    public ItemChangeListener(VariableEconomy plugin) {
        super(plugin);
    }

    //TODO: Detect item dropped in lava
    //TODO: Detect new chest breakage
    //TODO: Detect new chest opening
    //TODO: Detect fishing, taming, picked up items
    //TODO: Detect hoppers doing hopping

}
