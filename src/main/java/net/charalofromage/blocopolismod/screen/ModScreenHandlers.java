package net.charalofromage.blocopolismod.screen;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.screen.custom.LeadChestScreenHandler;
import net.charalofromage.blocopolismod.screen.custom.BronzeChestScreenHandler;
import net.charalofromage.blocopolismod.screen.custom.SilverChestScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<SilverChestScreenHandler> SILVER_CHEST_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BlocopolisMod.MOD_ID, "silver_chest_screen_handler"),
                    new ExtendedScreenHandlerType<>(SilverChestScreenHandler::new, BlockPos.PACKET_CODEC));

public static final ScreenHandlerType<LeadChestScreenHandler> LEAD_CHEST_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BlocopolisMod.MOD_ID, "lead_chest_screen_handler"),
                    new ExtendedScreenHandlerType<>(LeadChestScreenHandler::new, BlockPos.PACKET_CODEC));

public static final ScreenHandlerType<BronzeChestScreenHandler> BRONZE_CHEST_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BlocopolisMod.MOD_ID, "bronze_chest_screen_handler"),
                    new ExtendedScreenHandlerType<>(BronzeChestScreenHandler::new, BlockPos.PACKET_CODEC));




    public static void registerScreenHandlers(){
        BlocopolisMod.LOGGER.info("Regiistering Screen Handlers for "+ BlocopolisMod.MOD_ID);
    }
}
