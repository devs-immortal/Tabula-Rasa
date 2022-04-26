package net.immortaldevs.tabularasa.tin;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaTin implements ModInitializer {
    public static final String TABULA_RASA_TIN = "tabula_rasa_tin";

    @Override
    public void onInitialize() {
        TabulaRasaTinBlocks.init();
        TabulaRasaTinItems.init();
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_TIN, path);
    }
}
