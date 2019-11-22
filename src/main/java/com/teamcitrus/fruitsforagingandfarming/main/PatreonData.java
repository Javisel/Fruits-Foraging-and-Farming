package com.teamcitrus.fruitsforagingandfarming.main;

import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.item.Item;

import java.util.UUID;

public class PatreonData {

    public static final String patreonUUIDS[] = {"526ab88d-f353-4421-9d18-a629f735ac47"};
    public static final Item contributedItem[] = {ItemRegistration.KIWANO};

    public static Item getContributedItem(UUID patreonid) {

        for (int i = 0; i < patreonUUIDS.length; i++) {

            if (patreonid.toString().equals(patreonUUIDS[i])) {

                return contributedItem[i];
            }

        }
        return null;


    }

}
