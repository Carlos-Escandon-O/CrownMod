# 👑 CrownMod

Mod para **Minecraft: Java Edition (Fabric)**. Te pones la corona y **los aldeanos de los alrededores te siguen**.

## ✨ Qué hace

- **Item `crown`** — corona de oro con una esmeralda incrustada. Crafteable en la mesa de trabajo:

```
🟨🟨🟨
🟨💚🟨   →  👑  Corona
🟨🟨🟨
```

- **Pestaña creativa propia** (`CrownMod`) con la corona.
- Si la llevas puesta en el **slot de casco**, los **aldeanos cercanos** (12 bloques) acuden hacia ti y se paran a tu lado (vuelven a su rutina cuando te la quitas).
- Detiene su movimiento al acercarse a menos de ~1.5 bloques para que no te empujen.

## 💡 Idea original

Una corona como objeto de regalía: mientras la lleves puesta, los aldeanos te consideran su líder y te siguen.

## ⚙️ Ajustes (`config/crownmod.properties`)

```properties
radius = 12.0        # radio en bloques donde los aldeanos siguen al portador
speed = 0.6          # velocidad de caminata
stopDistance = 1.5   # distancia a la que se paran
grateful = true      # comerciantes agradecidos (corazones + sonido)
```

Si el archivo no existe, se crea con valores por defecto al primer arranque.

## 🛠️ Requisitos

- **Java 25**
- Minecraft **26.3**
- **Fabric Loader** y **Fabric API**

## 🔨 Compilar y probar

```bash
git clone https://github.com/Carlos-Escandon-O/CrownMod.git
cd CrownMod

# Compilar (genera build/libs/crownmod-*.jar)
./gradlew build

# Probar en cliente de desarrollo
./gradlew runClient

# Probar en servidor dedicado de desarrollo
./gradlew runServer
```

## 📦 Instalación

1. Instala **Fabric Loader** y **Fabric API** para Minecraft 26.3.
2. Copia `build/libs/crownmod-*.jar` a tu carpeta `mods/`.
3. Arranca el juego → cambia al modo creativo → tab **CrownMod** → toma la corona.
4. Ponla en el slot de casco y mírale a los ojos a los aldeanos.

## 🗺️ Roadmap

- [x] Proyecto base Fabric (MC 26.3, Fabric API 0.166.2+26.3, Loader 0.20.1)
- [x] Item `crown` (texturas propias, receta, pestaña creativa)
- [x] Aldeanos siguen al portador de la corona
- [x] Comerciantes agradecidos: mientras te siguen tiran corazones y hacen un sonido de villager-yes
- [x] Ajustes en `config/crownmod.properties` (radio, velocidad, distancia de parada)
- [ ] Comercio mejorado con aldeanos fieles
- [ ] Publicar en Modrinth

## 📁 Estructura

```
CrownMod/
├── src/
│   ├── main/java/com/carlosescandon/crownmod/
│   │   ├── CrownMod.java                 # entrypoint + registro + IA de aldeanos
│   │   └── mixin/CrownModMixin.java
│   ├── main/resources/
│   │   ├── fabric.mod.json
│   │   ├── crownmod.mixins.json
│   │   ├── assets/crownmod/              # icon.png, textura y modelo del ítem, lang
│   │   └── data/crownmod/recipe/crown.json
│   ├── client/java/…client/              # entrypoint de cliente + mixin
│   └── client/resources/
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradlew / gradlew.bat
└── README.md
```

## 📄 Licencia

CC0-1.0 (mismo espíritu del template: haz lo que quieras con el código).

---

Autor: [@Carlos-Escandon-O](https://github.com/Carlos-Escandon-O) · Hecho por diversión
