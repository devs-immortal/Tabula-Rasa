package net.immortaldevs.tabularasa.brass;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaBrass implements ModInitializer {
    public static final String TABULA_RASA_BRASS = "tabula_rasa_brass";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_BRASS, path);
    }
}
