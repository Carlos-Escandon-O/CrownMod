package com.carlosescandon.crownmod;

import net.fabricmc.loader.api.FabricLoader;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/// Configuración del mod leída de `config/crownmod.properties`.
/// Si el archivo no existe, se crea con valores por defecto.
public class CrownConfig {
	public double radius = 12.0;
	public double speed = 0.6;
	public double stopDistance = 1.5;
	public boolean grateful = true;

	private static final String FILE_NAME = "crownmod.properties";

	public static CrownConfig load() {
		CrownConfig cfg = new CrownConfig();
		try {
			Path dir = FabricLoader.getInstance().getConfigDir();
			Path path = dir.resolve(FILE_NAME);
			if (!Files.exists(path)) {
				dir.toFile().mkdirs();
				Files.writeString(path, """
					# CrownMod — configuración
					# Radio (en bloques) alrededor del jugador donde los aldeanos lo siguen
					radius = 12.0
					# Velocidad de caminata (0.5 = despacio, 0.6 = normal, 0.8 = rápido)
					speed = 0.6
					# Distancia a la que se paran (para que no te empujen)
					stopDistance = 1.5
					# true = los aldeanos tiran corazones y hacen un sonido agradecido mientras te siguen
					grateful = true
					""");
				return cfg;
			}

			Properties props = new Properties();
			try (InputStream in = Files.newInputStream(path)) {
				props.load(in);
			}

			cfg.radius = Double.parseDouble(props.getProperty("radius", "12.0").trim());
			cfg.speed = Double.parseDouble(props.getProperty("speed", "0.6").trim());
			cfg.stopDistance = Double.parseDouble(props.getProperty("stopDistance", "1.5").trim());
			cfg.grateful = Boolean.parseBoolean(props.getProperty("grateful", "true").trim());
		} catch (Exception e) {
			CrownMod.LOGGER.warn("[CrownMod] No pude leer {}: {} — usando valores por defecto", FILE_NAME, e.getMessage());
		}

		return cfg;
	}
}
