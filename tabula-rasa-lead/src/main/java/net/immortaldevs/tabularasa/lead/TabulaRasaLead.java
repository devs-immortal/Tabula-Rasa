package net.immortaldevs.tabularasa.lead;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public final class TabulaRasaLead implements ModInitializer {
    public static final String TABULA_RASA_LEAD = "tabula_rasa_lead";

    @Override
    public void onInitialize() {
        TabulaRasaLeadBlocks.init();
        TabulaRasaLeadItems.init();
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_LEAD, path);
    }
}
