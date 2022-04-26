package net.immortaldevs.tabularasa.silver;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaSilver implements ModInitializer {
    public static final String TABULA_RASA_SILVER = "tabula_rasa_silver";

    @Override
    public void onInitialize() {
        TabulaRasaSilverBlocks.init();
        TabulaRasaSilverItems.init();
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_SILVER, path);
    }
}
