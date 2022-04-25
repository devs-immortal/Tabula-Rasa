package net.immortaldevs.tabularasa.aluminium;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaAluminium implements ModInitializer {
    public static final String TABULA_RASA_ALUMINIUM = "tabula_rasa_aluminium";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_ALUMINIUM, path);
    }
}
