package com.teamcitrus.fruitsforagingandfarming.main;

import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.UUID;

public class PatreonData {


    public static HashMap<UUID,Item> patreonItem = new HashMap<>();

    static {
        patreonItem.put(UUID.fromString("526ab88d-f353-4421-9d18-a629f735ac47"),ItemRegistration.KIWANO);



    }


    public static Item getContributedItem(UUID patreonid) {

            return  patreonItem.get(patreonid);

    }

}
