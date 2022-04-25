package net.immortaldevs.tabularasa.bronze;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaBronze implements ModInitializer {
    public static final String TABULA_RASA_BRONZE = "tabula_rasa_bronze";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_BRONZE, path);
    }
}
