package net.immortaldevs.tabularasa.phosphor;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaPhosphor implements ModInitializer {
    public static final String TABULA_RASA_PHOSPHOR = "tabula_rasa_phosphor";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_PHOSPHOR, path);
    }
}
