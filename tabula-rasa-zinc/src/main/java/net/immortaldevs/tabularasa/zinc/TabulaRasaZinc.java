package net.immortaldevs.tabularasa.zinc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaZinc implements ModInitializer {
    public static final String TABULA_RASA_ZINC = "tabula_rasa_zinc";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_ZINC, path);
    }
}
