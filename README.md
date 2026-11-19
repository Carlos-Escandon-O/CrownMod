# 👑 CrownMod

Mod para **Minecraft (Java Edition, Fabric)**: si llevas puesta la corona, los aldeanos te siguen.

> **Estado:** scaffold del mod listo (compila con MC 26.3); la mecánica de la corona se implementa sobre esta base. Roadmap abajo.

## 💡 La idea

Una corona como objeto de regalía. Mientras el jugador la lleve equipada en la cabeza:

- Los **aldeanos** cercanos lo perciben como su **líder** y lo **siguen** por el mundo.
- Al quitársela, vuelven a sus rutinas.

## ✨ Plan / Roadmap

- [x] Proyecto base Fabric (MC 26.3, Fabric API 0.166.2, Loader 0.20.1)
- [ ] Item `crown` (crafteo, textura propia)
- [ ] Detección de "aldeano cerca" + corona equipada
- [ ] IA de seguimiento (pathfinding de aldeanos hacia el portador)
- [ ] Ajustes (radio de atracción, velocidad)
- [ ] Publicar en Modrinth

## 🛠️ Requisitos

- **Java 25** (el template usa `sourceCompatibility = VERSION_25`)
- Sistema operativo con soporte para Minecraft Java

## 🔨 Compilar y probar

```bash
# Clonar
git clone https://github.com/Carlos-Escandon-O/CrownMod.git
cd CrownMod

# Compilar (genera build/libs/crownmod-<version>.jar)
./gradlew build

# Probar en cliente de desarrollo
./gradlew runClient

# Probar en servidor de desarrollo
./gradlew runServer
```

## 📦 Instalación (cuando haya una build)

1. Instala **Fabric Loader** y **Fabric API** para Minecraft 26.3.
2. Copia `build/libs/crownmod-*.jar` a tu carpeta `mods/`.
3. Arranca el juego.

## 📁 Estructura

```
CrownMod/
├── src/
│   ├── main/java/com/carlosescandon/crownmod/        # código del mod
│   │   ├── CrownMod.java                              # entrypoint principal
│   │   └── mixin/CrownModMixin.java                   # mixins (inyectan en el juego)
│   ├── main/resources/                                # fabric.mod.json, mixins.json
│   │   └── assets/crownmod/                           # texturas e icono
│   ├── client/java/com/carlosescandon/crownmod/client/
│   │   ├── CrownModClient.java                        # entrypoint de cliente
│   │   └── mixin/CrownModClientMixin.java             # mixins de cliente
│   └── client/resources/
├── build.gradle                                       # dependencias y tareas de Loom
├── settings.gradle
├── gradle.properties                                  # versiones: MC 26.3, loader 0.20.1, Fabric API 0.166.2+26.3
└── gradlew / gradlew.bat                              # Gradle Wrapper
```

## 📄 Licencia

CC0-1.0 (mismo espíritu del template: haz lo que quieras).

---

Autor: [@Carlos-Escandon-O](https://github.com/Carlos-Escandon-O) · Hecho por diversión
