package net.immortaldevs.tabularasa.steel;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaSteel implements ModInitializer {
    public static final String TABULA_RASA_STEEL = "tabula_rasa_steel";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_STEEL, path);
    }
}
