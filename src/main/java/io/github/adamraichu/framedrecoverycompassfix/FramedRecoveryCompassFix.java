package io.github.adamraichu.framedrecoverycompassfix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FramedRecoveryCompassFix implements ClientModInitializer {
  public static final String MOD_ID = "framedrecoverycompassfix";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitializeClient() {
    LOGGER.info(MOD_ID + " is present and (hopefully) active.");
  }
}
