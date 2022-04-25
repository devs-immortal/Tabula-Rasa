package net.immortaldevs.tabularasa.titanium;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaTitanium implements ModInitializer {
    public static final String TABULA_RASA_TITANIUM = "tabula_rasa_titanium";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_TITANIUM, path);
    }
}
