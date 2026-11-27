# AI STUDIO FIDELITY BLUEPRINT — Flappy Bird

This repository is pre-optimized for **Google AI Studio** (< 900 files, zero dropped assets, AI-Studio Gradle 9.3.1 + AGP 9.1.1 + SDK 36 + `debugConfig` signing).

## CRITICAL REBUILD RULES (READ FIRST)
1. **DO NOT invent placeholder graphics or audio when real assets exist!**
   - Load the **exact real images, sprites, backgrounds, UI buttons, fonts, and sound effects** already extracted in `app/src/main/assets/` and `app/src/main/res/`.
   - Check `docs/ASSET_AND_MEDIA_MAP.md` for every image's **exact pixel dimensions (`WxH`)**, audio filename, font, and stage/level data file.
2. **Preserve visual style & feel faithfully:**
   - Match the original app's layout structure, colors (`app/src/main/res/values/colors.xml`), strings (`app/src/main/res/values/strings.xml`), decoded layouts (`docs/original_AndroidManifest.xml`), and exact media assets.
3. **Read the decompiled code before coding:**
   - On-device decompiled Java is in `reference_src/`.
   - If GitHub Actions Cloud JADX has finished running, full PC-grade JADX Java is also in `reference_jadx/`.
4. **Keep the Android Gradle build working:**
   - Replace `app/src/main/java/epic/org/flappybird/MainActivity.kt` with the full app implementation.
   - Keep `signingConfigs { create("debugConfig") ... }` pointing to `${rootDir}/debug.keystore`.

## APP & ENGINE SUMMARY
- **App Name:** Flappy Bird
- **Package:** `epic.org.flappybird` (v1.5, code 21)
- **Detected Runtime:** Unity IL2CPP (native `libil2cpp.so` — use extracted assets/sprites/audio + recreate gameplay smoothly)
- **Extracted Audio Files:** 1
- **Extracted Unique Images / Sprites:** 5 (removed 13 duplicate density copies)
- **Extracted Level / Config Data Files:** 53
- **Decompiled App Classes:** 1907 (100% exported, 103 obfuscated symbols renamed)
- **Deobfuscated Resource Paths:** 5

## NATIVE LIBRARIES DETECTED
- lib/arm64-v8a/libEOSSDK.so (21.8 MB)
- lib/arm64-v8a/libUnityHelpers_Android.so (34 KB) | ARM64 64-bit | PIE=true | NX=true | RELRO=true
- lib/arm64-v8a/lib_burst_generated.so (189 KB) | ARM64 64-bit | PIE=true | NX=true | RELRO=true
- lib/arm64-v8a/libc++_shared.so (890 KB) | ARM64 64-bit | PIE=true | NX=true | RELRO=true
- lib/arm64-v8a/libil2cpp.so (76.7 MB)
- lib/arm64-v8a/libmain.so (6 KB) | ARM64 64-bit | PIE=true | NX=true | RELRO=true
- lib/arm64-v8a/libunity.so (23.9 MB)
- lib/armeabi-v7a/libEOSSDK.so (17.2 MB)
- lib/armeabi-v7a/libUnityHelpers_Android.so (17 KB) | ARMv7 32-bit | PIE=true | NX=true | RELRO=true
- lib/armeabi-v7a/lib_burst_generated.so (183 KB) | ARMv7 32-bit | PIE=true | NX=true | RELRO=true
- lib/armeabi-v7a/libc++_shared.so (541 KB) | ARMv7 32-bit | PIE=true | NX=true | RELRO=true
- lib/armeabi-v7a/libil2cpp.so (64.7 MB)
- lib/armeabi-v7a/libmain.so (8 KB) | ARMv7 32-bit | PIE=true | NX=true | RELRO=true
- lib/armeabi-v7a/libunity.so (17.3 MB)

