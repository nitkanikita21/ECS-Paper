package com.nitkanikita21.ecspaper;

import com.nitkanikita21.ecspaper.commons.EventRegister;
import org.bukkit.plugin.java.JavaPlugin;

public class EcsPaperPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        ECS ecs = new ECS(new EventRegister(this));

    }


}
