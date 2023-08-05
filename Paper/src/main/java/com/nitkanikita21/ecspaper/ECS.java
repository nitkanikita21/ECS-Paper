package com.nitkanikita21.ecspaper;

import com.nitkanikita21.ecspaper.commons.EventRegister;
import com.nitkanikita21.ecspaper.items.ItemBundleApi;

public class ECS {
    public static ECS getAPI() {
        return ecs;
    }

    protected static ECS ecs;

    private final EventRegister eventRegister;

    public ItemBundleApi getItemBundleApi() {
        return itemBundleApi;
    }

    private final ItemBundleApi itemBundleApi;
    ECS(EventRegister eventRegister) {
        this.eventRegister = eventRegister;
        ECS.ecs = ecs;

        itemBundleApi = new ItemBundleApi(eventRegister);
    }
}
