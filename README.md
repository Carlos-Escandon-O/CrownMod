# 👑 CrownMod

Mod para **Minecraft**: si llevas puesta la corona, los aldeanos te siguen.

> **Estado:** en desarrollo — el repositorio está vacío por ahora (solo este README). La idea y el diseño están acá; la implementación viene después.

## 💡 La idea

Una corona como objeto mágico/regalía. Mientras un jugador la lleve equipada en la cabeza:

- Los **aldeanos** de alrededor lo perciben como su **líder** y lo **siguen** por el mundo de la misma forma en que seguirían a su propio personaje.
- Al quitársela, los aldeanos se quedan quietos o vuelven a su rutina.
- Posibilidades futuras: tradear con ellos mientras la llevas, atraer rebaños, alianza entre aldeas.

## 🛠️ Plan técnico (propuesto)

- **Lenguaje:** Java
- **Loader:** por definir — Fabric (recomendado por simplicidad) o NeoForge/Forge (más compatible con mods grandes)
- **Build:** Gradle + parchment/data packs
- **Plataforma:** Minecraft 1.21+ (la versión final depende del loader elegido)

## 📦 Roadmap

- [ ] Proyecto base del mod (Gradle, assets propios, cinta comodín `crown`)
- [ ] Item `crown` (receta de crafteo, texturas propias)
- [ ] Detección de "aldeano cerca" y de corona equipada
- [ ] IA de seguimiento (pathfinding de aldeanos hacia el portador de la corona)
- [ ] Configuración (radio de atracción, velocidad, el modo fácil/difícil)
- [ ] Publicar build en Modrinth / CurseForge

## Cómo probarlo (cuando exista el código)

1. Instala Fabric loader en tu cliente.
2. Coloca el `.jar` compilado en `mods/`.
3. Juega: busca aldeanos y ponte la corona → deberían seguirte.

## 📁 Estructura prevista

```
CrownMod/
├── src/main/java/…      # código del mod
├── src/main/resources/  # assets, mixins, fabric.mod.json / mods.toml
├── build.gradle
└── README.md
```

---

Autor: [@Carlos-Escandon-O](https://github.com/Carlos-Escandon-O) · Hecho por diversión
