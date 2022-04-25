package net.immortaldevs.tabularasa.sulphur;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaSulphur implements ModInitializer {
    public static final String TABULA_RASA_SULPHUR = "tabula_rasa_sulphur";

    @Override
    public void onInitialize() {
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_SULPHUR, path);
    }
}
