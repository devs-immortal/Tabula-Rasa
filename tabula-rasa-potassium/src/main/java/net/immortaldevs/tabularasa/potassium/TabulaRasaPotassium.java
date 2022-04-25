package net.immortaldevs.tabularasa.potassium;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaPotassium implements ModInitializer {
    public static final String TABULA_RASA_POTASSIUM = "tabula_rasa_potassium";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_POTASSIUM, path);
    }
}
