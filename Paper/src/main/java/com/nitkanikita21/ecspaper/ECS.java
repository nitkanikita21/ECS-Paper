package com.nitkanikita21.ecspaper;

import com.nitkanikita21.ecspaper.commons.EventRegister;
import com.nitkanikita21.ecspaper.items.ItemBundleApi;

/**
 * Main API class
 */
public class ECS {

    protected static ECS ecs;

    /**
     * Static getter for API object
     * @return return singleton API object
     */
    public static ECS getAPI() {
        return ecs;
    }

    private final EventRegister eventRegister;

    /**
     * Getter for ItemBundleAPI
     * @return ItemBundleApi object
     */
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
