package com.teamcitrus.fruitsforagingandfarming.common.network;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketHandler extends SimpleNetworkWrapper {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(FruitsForagingAndFarming.MODID);

    public PacketHandler(String channelName) {
        super(channelName);
    }
}
