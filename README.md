# Flappy Bird — GO BIG A-TO-Z BLUEPRINT

## AI REBUILD & UPLOAD GUIDE
- **App Name**: Flappy Bird
- **Package Name**: `epic.org.flappybird`
- **Version**: 1.5 (code 21)
- **SDK**: minSdk=23, targetSdk=35
- **APK Size**: 119.2 MB
- **App Classes Exported**: 1907 / 1907 (100% — ZERO CAPS)
- **Decoded XML Files**: 35
- **Text Assets**: 87
- **Binary Media / Fonts / Raw**: 218
- **Native Libraries (.so)**: 14
- **Export Truncated**: NO (100% complete A-to-Z)
- **Runtime Notice**: Unity IL2CPP detected (`libil2cpp.so` contains compiled game code).

### How to Rebuild This App in AI Studio, Gemini, or ChatGPT
1. **Best for AI Studio**: Unzip this Go Big bundle and push the `app/` + `gradle/` structure to GitHub, then import into AI Studio (or upload files from `decompiled/java/`, `app/src/main/res/`, and `AndroidManifest.xml`).
2. **Best for Chat without Token Crashes**: Use the files in `ai_parts/` (0 Java part(s), 0 Smali part(s)). Each part stays under ~1.5 MB (~375K tokens) so Gemini and ChatGPT will never fail with `exceeded the maximum number of tokens allowed`.
3. **Exact Logic & UI**: `decompiled/java/` has full constant-propagated pseudo-Java (no line caps), `decompiled/smali/` has exact Dalvik bytecode, and `app/src/main/res/` has decoded layouts, vector icons, strings, colors, and raw images/fonts.

## 1. RECONSTRUCTED GRADLE SETUP
### `settings.gradle.kts`
```kotlin
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Flappy Bird"
include(":app")
```

### `app/build.gradle.kts`
```kotlin
// Reconstructed from APK metadata, AndroidManifest.xml, and DEX library signatures.
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "epic.org.flappybird"
    compileSdk = 35

    defaultConfig {
        applicationId = "epic.org.flappybird"
        minSdk = 23
        targetSdk = 35
        versionCode = 21
        versionName = "1.5"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}
```

## 2. ANDROID MANIFEST (DECODED)
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:versionCode="21"
  android:versionName="1.5"
  android:installLocation="2"
  android:compileSdkVersion="35"
  android:compileSdkVersionCodename="15"
  package="epic.org.flappybird"
  platformBuildVersionCode="35"
  platformBuildVersionName="15">
  <uses-sdk
    android:minSdkVersion="23"
    android:targetSdkVersion="35">
  </uses-sdk>
  <supports-screens
    android:anyDensity="true"
    android:smallScreens="true"
    android:normalScreens="true"
    android:largeScreens="true"
    android:xlargeScreens="true">
  </supports-screens>
  <uses-permission android:name="android.permission.INTERNET">
  </uses-permission>
  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE">
  </uses-permission>
  <uses-feature android:glEsVersion="0x30000">
  </uses-feature>
  <uses-feature
    android:name="android.hardware.vulkan.version"
    android:required="false">
  </uses-feature>
  <uses-feature
    android:name="android.hardware.touchscreen"
    android:required="false">
  </uses-feature>
  <uses-feature
    android:name="android.hardware.touchscreen.multitouch"
    android:required="false">
  </uses-feature>
  <uses-feature
    android:name="android.hardware.touchscreen.multitouch.distinct"
    android:required="false">
  </uses-feature>
  <uses-permission android:name="com.google.android.gms.permission.AD_ID">
  </uses-permission>
  <uses-permission android:name="android.permission.ACCESS_ADSERVICES_TOPICS">
  </uses-permission>
  <uses-permission android:name="android.permission.ACCESS_ADSERVICES_ATTRIBUTION">
  </uses-permission>
  <queries>
    <intent>
      <action android:name="android.intent.action.VIEW">
      </action>
      <category android:name="android.intent.category.BROWSABLE">
      </category>
      <data android:scheme="https">
      </data>
    </intent>
    <intent>
      <action android:name="android.intent.action.SEND">
      </action>
      <data android:mimeType="*/*">
      </data>
    </intent>
    <intent>
      <action android:name="android.intent.action.SEND_MULTIPLE">
      </action>
      <data android:mimeType="*/*">
      </data>
    </intent>
  </queries>
  <queries>
    <intent>
      <action android:name="android.support.customtabs.action.CustomTabsService">
      </action>
    </intent>
  </queries>
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE">
  </uses-permission>
  <uses-permission android:name="android.permission.DOWNLOAD_WITHOUT_NOTIFICATION">
  </uses-permission>
  <uses-permission android:name="android.permission.ACCESS_WIFI_STATE">
  </uses-permission>
  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE">
  </uses-permission>
  <uses-permission android:name="android.permission.WAKE_LOCK">
  </uses-permission>
  <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED">
  </uses-permission>
  <uses-permission android:name="android.permission.FOREGROUND_SERVICE">
  </uses-permission>
  <permission
    android:name="epic.org.flappybird.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION"
    android:protectionLevel="0x2">
  </permission>
  <uses-permission android:name="epic.org.flappybird.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION">
  </uses-permission>
  <application
    android:theme="@style/Theme.AppCompat.Light.NoActionBar.FullScreen"
    android:label="@string/app_name"
    android:icon="@mipmap/app_icon"
    android:extractNativeLibs="true"
    android:usesCleartextTraffic="true"
    android:appComponentFactory="androidx.core.app.CoreComponentFactory">
    <meta-data
      android:name="unity.splash-mode"
      android:value="2">
    </meta-data>
    <meta-data
      android:name="unity.splash-enable"
      android:value="true">
    </meta-data>
    <meta-data
      android:name="unity.launch-fullscreen"
      android:value="true">
    </meta-data>
    <meta-data
      android:name="unity.render-outside-safearea"
      android:value="true">
    </meta-data>
    <meta-data
      android:name="notch.config"
      android:value="portrait|landscape">
    </meta-data>
    <meta-data
      android:name="unity.auto-report-fully-drawn"
      android:value="true">
    </meta-data>
    <activity
      android:theme="@style/UnityThemeSelector"
      android:name="com.unity3d.player.UnityPlayerActivity"
      android:exported="true"
      android:launchMode="2"
      android:screenOrientation="1"
      android:configChanges="0x40003fff"
      android:hardwareAccelerated="false"
      android:resizeableActivity="false">
      <intent-filter>
        <category android:name="android.intent.category.LAUNCHER">
        </category>
        <action android:name="android.intent.action.MAIN">
        </action>
      </intent-filter>
      <meta-data
        android:name="unityplayer.UnityActivity"
        android:value="true">
      </meta-data>
      <meta-data
        android:name="notch_support"
        android:value="true">
      </meta-data>
    </activity>
    <activity
      android:theme="@0x01030007"
      android:name="com.unity3d.services.ads.adunit.AdUnitActivity"
      android:exported="false"
      android:configChanges="0x40000fff"
      android:hardwareAccelerated="true">
    </activity>
    <activity
      android:theme="@0x01030011"
      android:name="com.unity3d.services.ads.adunit.AdUnitTransparentActivity"
      android:exported="false"
      android:configChanges="0x40000fff"
      android:hardwareAccelerated="true">
    </activity>
    <activity
      android:theme="@0x01030011"
      android:name="com.unity3d.services.ads.adunit.AdUnitTransparentSoftwareActivity"
      android:exported="false"
      android:configChanges="0x40000fff"
      android:hardwareAccelerated="false">
    </activity>
    <activity
      android:theme="@0x01030007"
      android:name="com.unity3d.services.ads.adunit.AdUnitSoftwareActivity"
      android:exported="false"
      android:configChanges="0x40000fff"
      android:hardwareAccelerated="false">
    </activity>
    <activity
      android:theme="@0x01030007"
      android:name="com.unity3d.ads.adplayer.FullScreenWebViewDisplay"
      android:exported="false"
      android:configChanges="0x40000fff"
      android:hardwareAccelerated="true">
    </activity>
    <provider
      android:name="androidx.startup.InitializationProvider"
      android:exported="false"
      android:authorities="epic.org.flappybird.androidx-startup">
      <meta-data
        android:name="androidx.lifecycle.ProcessLifecycleInitializer"
        android:value="androidx.startup">
      </meta-data>
      <meta-data
        android:name="com.unity3d.services.core.configuration.AdsSdkInitializer"
        android:value="androidx.startup">
      </meta-data>
      <meta-data
        android:name="androidx.work.WorkManagerInitializer"
        android:value="androidx.startup">
      </meta-data>
      <meta-data
        android:name="androidx.emoji2.text.EmojiCompatInitializer"
        android:value="androidx.startup">
      </meta-data>
      <meta-data
        android:name="androidx.profileinstaller.ProfileInstallerInitializer"
        android:value="androidx.startup">
      </meta-data>
    </provider>
    <activity
      android:name="com.epicgames.mobile.eossdk.EOSAuthHandlerActivity"
      android:exported="true"
      android:configChanges="0x4a0"
      android:noHistory="true">
      <intent-filter>
        <action android:name="android.intent.action.VIEW">
        </action>
        <category android:name="android.intent.category.DEFAULT">
        </category>
        <category android:name="android.intent.category.BROWSABLE">
        </category>
        <data android:scheme="eos.xyza7891zruizvs8tjpl44nje28hssba">
        </data>
      </intent-filter>
    </activity>
    <activity
      android:theme="@style/Theme.NativeShareTransparent"
      android:name="com.yasirkula.unity.NativeShareCustomShareDialogActivity"
      android:exported="false">
    </activity>
    <receiver
      android:name="com.yasirkula.unity.NativeShareBroadcastListener"
      android:exported="false">
    </receiver>
    <provider
      android:name="com.yasirkula.unity.NativeShareContentProvider"
      android:exported="false"
      android:authorities="epic.org.flappybird.NativeShareContentProvider"
      android:grantUriPermissions="true">
    </provider>
    <activity
      android:theme="@0x01030010"
      android:name="com.google.android.gms.common.api.GoogleApiActivity"
      android:exported="false">
    </activity>
    <meta-data
      android:name="com.google.android.gms.version"
      android:value="@integer/google_play_services_version">
    </meta-data>
    <service
      android:name="androidx.work.impl.background.systemalarm.SystemAlarmService"
      android:enabled="@bool/enable_system_alarm_service_default"
      android:exported="false"
      android:directBootAware="false">
    </service>
    <service
      android:name="androidx.work.impl.background.systemjob.SystemJobService"
      android:permission="android.permission.BIND_JOB_SERVICE"
      android:enabled="@bool/enable_system_job_service_default"
      android:exported="true"
      android:directBootAware="false">
    </service>
    <service
      android:name="androidx.work.impl.foreground.SystemForegroundService"
      android:enabled="@bool/enable_system_foreground_service_default"
      android:exported="false"
      android:directBootAware="false">
    </service>
    <receiver
      android:name="androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver"
      android:enabled="true"
      android:exported="false"
      android:directBootAware="false">
    </receiver>
    <receiver
      android:name="androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy"
      android:enabled="false"
      android:exported="false"
      android:directBootAware="false">
      <intent-filter>
        <action android:name="android.intent.action.ACTION_POWER_CONNECTED">
        </action>
        <action android:name="android.intent.action.ACTION_POWER_DISCONNECTED">
        </action>
      </intent-filter>
    </receiver>
    <receiver
      android:name="androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy"
      android:enabled="false"
      android:exported="false"
      android:directBootAware="false">
      <intent-filter>
        <action android:name="android.intent.action.BATTERY_OKAY">
        </action>
        <action android:name="android.intent.action.BATTERY_LOW">
        </action>
      </intent-filter>
    </receiver>
    <receiver
      android:name="androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy"
      android:enabled="false"
      android:exported="false"
      android:directBootAware="false">
      <intent-filter>
        <action android:name="android.intent.action.DEVICE_STORAGE_LOW">
        </action>
        <action android:name="android.intent.action.DEVICE_STORAGE_OK">
        </action>
      </intent-filter>
    </receiver>
    <receiver
      android:name="androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy"
      android:enabled="false"
      android:exported="false"
      android:directBootAware="false">
      <intent-filter>
        <action android:name="android.net.conn.CONNECTIVITY_CHANGE">
        </action>
      </intent-filter>
    </receiver>
    <receiver
      android:name="androidx.work.impl.background.systemalarm.RescheduleReceiver"
      android:enabled="false"
      android:exported="false"
      android:directBootAware="false">
      <intent-filter>
        <action android:name="android.intent.action.BOOT_COMPLETED">
        </action>
        <action android:name="android.intent.action.TIME_SET">
        </action>
        <action android:name="android.intent.action.TIMEZONE_CHANGED">
        </action>
      </intent-filter>
    </receiver>
    <receiver
      android:name="androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver"
      android:enabled="@bool/enable_system_alarm_service_default"
      android:exported="false"
      android:directBootAware="false">
      <intent-filter>
        <action android:name="androidx.work.impl.background.systemalarm.UpdateProxies">
        </action>
      </intent-filter>
    </receiver>
    <receiver
      android:name="androidx.work.impl.diagnostics.DiagnosticsReceiver"
      android:permission="android.permission.DUMP"
      android:enabled="true"
      android:exported="true"
      android:directBootAware="false">
      <intent-filter>
        <action android:name="androidx.work.diagnostics.REQUEST_DIAGNOSTICS">
        </action>
      </intent-filter>
    </receiver>
    <receiver
      android:name="androidx.profileinstaller.ProfileInstallReceiver"
      android:permission="android.permission.DUMP"
      android:enabled="true"
      android:exported="true"
      android:directBootAware="false">
      <intent-filter>
        <action android:name="androidx.profileinstaller.action.INSTALL_PROFILE">
        </action>
      </intent-filter>
      <intent-filter>
        <action android:name="androidx.profileinstaller.action.SKIP_FILE">
        </action>
      </intent-filter>
      <intent-filter>
        <action android:name="androidx.profileinstaller.action.SAVE_PROFILE">
        </action>
      </intent-filter>
      <intent-filter>
        <action android:name="androidx.profileinstaller.action.BENCHMARK_OPERATION">
        </action>
      </intent-filter>
    </receiver>
    <service
      android:name="androidx.room.MultiInstanceInvalidationService"
      android:exported="false"
      android:directBootAware="true">
    </service>
  </application>
</manifest>

```

## 3. ALL APP RESOURCES (resources.arsc — ZERO CAPS)
### Strings (17)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="cronetproviderclassname">com.google.android.gms.net.PlayServicesCronetProvider</string>
    <string name="app_name">Flappy Bird</string>
    <string name="common_open_on_phone">Open on phone</string>
    <string name="common_signin_button_text">Sign in</string>
    <string name="common_signin_button_text_long">Sign in with Google</string>
    <string name="copy_toast_msg">Link copied to clipboard</string>
    <string name="eos_login_protocol_scheme">eos.xyza7891zruizvs8tjpl44nje28hssba</string>
    <string name="fallback_menu_item_copy_link">Copy link</string>
    <string name="fallback_menu_item_open_in_browser">Open in browser</string>
    <string name="fallback_menu_item_share_link">Share link</string>
    <string name="game_view_content_description">Game view</string>
    <string name="search_menu_title">Search</string>
    <string name="freeformwindoworientation_landscape">landscape</string>
    <string name="freeformwindoworientation_portrait">portrait</string>
    <string name="freeformwindowsize_maximize">maximize</string>
    <string name="freeformwindowsize_phone">phone</string>
    <string name="freeformwindowsize_tablet">tablet</string>
</resources>
```

### Colors (45)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="bright_foreground_disabled_material_dark">#80FFFFFF</color>
    <color name="bright_foreground_disabled_material_light">#80000000</color>
    <color name="browser_actions_bg_grey">#FFF5F5F5</color>
    <color name="browser_actions_divider_color">#1E000000</color>
    <color name="browser_actions_text_color">#DE000000</color>
    <color name="browser_actions_title_color">#FF646464</color>
    <color name="button_material_dark">#FF5A595B</color>
    <color name="button_material_light">#FFD6D7D7</color>
    <color name="dim_foreground_disabled_material_dark">#80BEBEBE</color>
    <color name="dim_foreground_disabled_material_light">#80323232</color>
    <color name="dim_foreground_material_dark">#FFBEBEBE</color>
    <color name="dim_foreground_material_light">#FF323232</color>
    <color name="eos_customtabtoolbarcolor">#FF272727</color>
    <color name="error_color_material_dark">#FFFF7043</color>
    <color name="error_color_material_light">#FFFF5722</color>
    <color name="highlighted_text_material_dark">#6680CBC4</color>
    <color name="highlighted_text_material_light">#66009688</color>
    <color name="material_blue_grey_800">#FF37474F</color>
    <color name="material_blue_grey_900">#FF263238</color>
    <color name="material_blue_grey_950">#FF21272B</color>
    <color name="material_deep_teal_200">#FF80CBC4</color>
    <color name="material_deep_teal_500">#FF008577</color>
    <color name="material_grey_100">#FFF5F5F5</color>
    <color name="material_grey_300">#FFE0E0E0</color>
    <color name="material_grey_50">#FFFAFAFA</color>
    <color name="material_grey_600">#FF757575</color>
    <color name="material_grey_800">#FF424242</color>
    <color name="material_grey_850">#FF303030</color>
    <color name="material_grey_900">#FF212121</color>
    <color name="notification_icon_bg_color">#FF9E9E9E</color>
    <color name="primary_text_default_material_dark">#FFFFFFFF</color>
    <color name="primary_text_default_material_light">#DE000000</color>
    <color name="primary_text_disabled_material_dark">#4DFFFFFF</color>
    <color name="primary_text_disabled_material_light">#39000000</color>
    <color name="ripple_material_dark">#33FFFFFF</color>
    <color name="ripple_material_light">#1F000000</color>
    <color name="secondary_text_default_material_dark">#B3FFFFFF</color>
    <color name="secondary_text_default_material_light">#8A000000</color>
    <color name="secondary_text_disabled_material_dark">#36FFFFFF</color>
    <color name="secondary_text_disabled_material_light">#24000000</color>
    <color name="staticsplashscreenbackgroundcolor">#FF231F20</color>
    <color name="switch_thumb_disabled_material_dark">#FF616161</color>
    <color name="switch_thumb_disabled_material_light">#FFBDBDBD</color>
    <color name="switch_thumb_normal_material_dark">#FFBDBDBD</color>
    <color name="switch_thumb_normal_material_light">#FFF1F1F1</color>
</resources>
```

### Dimens (24)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <dimen name="browser_actions_context_menu_max_width">500.0dp</dimen>
    <dimen name="browser_actions_context_menu_min_padding">20.0dp</dimen>
    <dimen name="compat_button_inset_horizontal_material">4.0dp</dimen>
    <dimen name="compat_button_inset_vertical_material">6.0dp</dimen>
    <dimen name="compat_button_padding_horizontal_material">8.0dp</dimen>
    <dimen name="compat_button_padding_vertical_material">4.0dp</dimen>
    <dimen name="compat_control_corner_material">2.0dp</dimen>
    <dimen name="compat_notification_large_icon_max_height">320.0dp</dimen>
    <dimen name="compat_notification_large_icon_max_width">320.0dp</dimen>
    <dimen name="notification_action_icon_size">32.0dp</dimen>
    <dimen name="notification_action_text_size">13.0sp</dimen>
    <dimen name="notification_big_circle_margin">12.0dp</dimen>
    <dimen name="notification_content_margin_start">0.0dp</dimen>
    <dimen name="notification_large_icon_height">64.0dp</dimen>
    <dimen name="notification_large_icon_width">64.0dp</dimen>
    <dimen name="notification_main_column_padding_top">0.0dp</dimen>
    <dimen name="notification_media_narrow_margin">12.0dp</dimen>
    <dimen name="notification_right_icon_size">16.0dp</dimen>
    <dimen name="notification_right_side_padding_top">4.0dp</dimen>
    <dimen name="notification_small_icon_background_padding">3.0dp</dimen>
    <dimen name="notification_small_icon_size_as_large">24.0dp</dimen>
    <dimen name="notification_subtext_size">13.0sp</dimen>
    <dimen name="notification_top_pad">10.0dp</dimen>
    <dimen name="notification_top_pad_large_text">5.0dp</dimen>
</resources>
```

### Drawables & Mipmaps (55)
- btn_checkbox_checked_mtrl -> res/drawable/btn_checkbox_checked_mtrl.xml
- btn_checkbox_checked_to_unchecked_mtrl_animation -> res/drawable/btn_checkbox_checked_to_unchecked_mtrl_animation.xml
- btn_checkbox_unchecked_mtrl -> res/drawable/btn_checkbox_unchecked_mtrl.xml
- btn_checkbox_unchecked_to_checked_mtrl_animation -> res/drawable/btn_checkbox_unchecked_to_checked_mtrl_animation.xml
- btn_radio_off_mtrl -> res/drawable/btn_radio_off_mtrl.xml
- btn_radio_off_to_on_mtrl_animation -> res/drawable/btn_radio_off_to_on_mtrl_animation.xml
- btn_radio_on_mtrl -> res/drawable/btn_radio_on_mtrl.xml
- btn_radio_on_to_off_mtrl_animation -> res/drawable/btn_radio_on_to_off_mtrl_animation.xml
- close_24px -> res/drawable/close_24px.xml
- notification_action_background -> res/drawable/notification_action_background.xml
- notification_bg -> res/drawable/notification_bg.xml
- notification_bg_low -> res/drawable/notification_bg_low.xml
- notification_icon_background -> res/drawable/notification_icon_background.xml
- notification_template_icon_bg
- notification_template_icon_low_bg
- notification_tile_bg -> res/drawable/notification_tile_bg.xml
- test_level_drawable -> res/drawable/test_level_drawable.xml
- unity_static_splash -> res/drawable/unity_static_splash.png
- googleg_disabled_color_18 -> res/drawable-mdpi/googleg_disabled_color_18.png
- googleg_standard_color_18 -> res/drawable-mdpi/googleg_standard_color_18.png
- notification_bg_low_normal -> res/drawable-mdpi/notification_bg_low_normal.9.png
- notification_bg_low_pressed -> res/drawable-mdpi/notification_bg_low_pressed.9.png
- notification_bg_normal -> res/drawable-mdpi/notification_bg_normal.9.png
- notification_bg_normal_pressed -> res/drawable-mdpi/notification_bg_normal_pressed.9.png
- notify_panel_notification_icon_bg -> res/drawable-mdpi/notify_panel_notification_icon_bg.png
- common_full_open_on_phone -> res/drawable-hdpi/common_full_open_on_phone.png
- googleg_disabled_color_18 -> res/drawable-hdpi/googleg_disabled_color_18.png
- googleg_standard_color_18 -> res/drawable-hdpi/googleg_standard_color_18.png
- notification_bg_low_normal -> res/drawable-hdpi/notification_bg_low_normal.9.png
- notification_bg_low_pressed -> res/drawable-hdpi/notification_bg_low_pressed.9.png
- notification_bg_normal -> res/drawable-hdpi/notification_bg_normal.9.png
- notification_bg_normal_pressed -> res/drawable-hdpi/notification_bg_normal_pressed.9.png
- notify_panel_notification_icon_bg -> res/drawable-hdpi/notify_panel_notification_icon_bg.png
- common_full_open_on_phone -> res/drawable-xhdpi/common_full_open_on_phone.png
- googleg_disabled_color_18 -> res/drawable-xhdpi/googleg_disabled_color_18.png
- googleg_standard_color_18 -> res/drawable-xhdpi/googleg_standard_color_18.png
- notification_bg_low_normal -> res/drawable-xhdpi/notification_bg_low_normal.9.png
- notification_bg_low_pressed -> res/drawable-xhdpi/notification_bg_low_pressed.9.png
- notification_bg_normal -> res/drawable-xhdpi/notification_bg_normal.9.png
- notification_bg_normal_pressed -> res/drawable-xhdpi/notification_bg_normal_pressed.9.png
- notify_panel_notification_icon_bg -> res/drawable-xhdpi/notify_panel_notification_icon_bg.png
- googleg_disabled_color_18 -> res/drawable-xxhdpi/googleg_disabled_color_18.png
- googleg_standard_color_18 -> res/drawable-xxhdpi/googleg_standard_color_18.png
- app_icon -> res/mipmap-ldpi/app_icon.png
- app_icon_round -> res/mipmap-ldpi/app_icon_round.png
- app_icon -> res/mipmap-mdpi/app_icon.png
- app_icon_round -> res/mipmap-mdpi/app_icon_round.png
- app_icon -> res/mipmap-hdpi/app_icon.png
- app_icon_round -> res/mipmap-hdpi/app_icon_round.png
- app_icon -> res/mipmap-xhdpi/app_icon.png
- app_icon_round -> res/mipmap-xhdpi/app_icon_round.png
- app_icon -> res/mipmap-xxhdpi/app_icon.png
- app_icon_round -> res/mipmap-xxhdpi/app_icon_round.png
- app_icon -> res/mipmap-xxxhdpi/app_icon.png
- app_icon_round -> res/mipmap-xxxhdpi/app_icon_round.png

## 4. DECODED XML & TEXT ASSET INDEX
- `app/src/main/res/anim/fragment_fast_out_extra_slow_in.xml`
- `app/src/main/res/animator/fragment_close_enter.xml`
- `app/src/main/res/animator/fragment_close_exit.xml`
- `app/src/main/res/animator/fragment_fade_enter.xml`
- `app/src/main/res/animator/fragment_fade_exit.xml`
- `app/src/main/res/animator/fragment_open_enter.xml`
- `app/src/main/res/animator/fragment_open_exit.xml`
- `app/src/main/res/color/common_google_signin_btn_text_dark.xml`
- `app/src/main/res/color/common_google_signin_btn_text_light.xml`
- `app/src/main/res/color/common_google_signin_btn_tint.xml`
- `app/src/main/res/color/switch_thumb_material_dark.xml`
- `app/src/main/res/color/switch_thumb_material_light.xml`
- `app/src/main/res/drawable/close_24px.xml`
- `app/src/main/res/drawable/common_google_signin_btn_icon_dark.xml`
- `app/src/main/res/drawable/common_google_signin_btn_icon_dark_focused.xml`
- `app/src/main/res/drawable/common_google_signin_btn_icon_dark_normal.xml`
- `app/src/main/res/drawable/common_google_signin_btn_icon_disabled.xml`
- `app/src/main/res/drawable/common_google_signin_btn_icon_light.xml`
- `app/src/main/res/drawable/common_google_signin_btn_icon_light_focused.xml`
- `app/src/main/res/drawable/common_google_signin_btn_icon_light_normal.xml`
- `app/src/main/res/drawable/common_google_signin_btn_text_dark.xml`
- `app/src/main/res/drawable/common_google_signin_btn_text_dark_focused.xml`
- `app/src/main/res/drawable/common_google_signin_btn_text_dark_normal.xml`
- `app/src/main/res/drawable/common_google_signin_btn_text_disabled.xml`
- `app/src/main/res/drawable/common_google_signin_btn_text_light.xml`
- `app/src/main/res/drawable/common_google_signin_btn_text_light_focused.xml`
- `app/src/main/res/drawable/common_google_signin_btn_text_light_normal.xml`
- `app/src/main/res/drawable/test_level_drawable.xml`
- `app/src/main/res/layout/browser_actions_context_menu_page.xml`
- `app/src/main/res/layout/browser_actions_context_menu_row.xml`
- `app/src/main/res/layout/native_share_custom_dialog_holder.xml`
- `app/src/main/res/layout/native_share_grid_element.xml`
- `app/src/main/res/layout/native_share_grid_view.xml`
- `app/src/main/res/xml/eossdk_backup_rules.xml`
- `app/src/main/res/xml/image_share_filepaths.xml`
- `app/src/main/META-INF/androidx.activity_activity-ktx.version`
- `app/src/main/META-INF/androidx.activity_activity.version`
- `app/src/main/META-INF/androidx.annotation_annotation-experimental.version`
- `app/src/main/META-INF/androidx.appcompat_appcompat-resources.version`
- `app/src/main/META-INF/androidx.appcompat_appcompat.version`
- `app/src/main/META-INF/androidx.arch.core_core-runtime.version`
- `app/src/main/META-INF/androidx.browser_browser.version`
- `app/src/main/META-INF/androidx.core_core-ktx.version`
- `app/src/main/META-INF/androidx.core_core.version`
- `app/src/main/META-INF/androidx.cursoradapter_cursoradapter.version`
- `app/src/main/META-INF/androidx.customview_customview.version`
- `app/src/main/META-INF/androidx.datastore_datastore.version`
- `app/src/main/META-INF/androidx.drawerlayout_drawerlayout.version`
- `app/src/main/META-INF/androidx.emoji2_emoji2-views-helper.version`
- `app/src/main/META-INF/androidx.emoji2_emoji2.version`
- `app/src/main/META-INF/androidx.fragment_fragment.version`
- `app/src/main/META-INF/androidx.interpolator_interpolator.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-livedata-core.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-livedata.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-process.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-runtime-ktx.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-runtime.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-service.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-viewmodel-ktx.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-viewmodel-savedstate.version`
- `app/src/main/META-INF/androidx.lifecycle_lifecycle-viewmodel.version`
- `app/src/main/META-INF/androidx.loader_loader.version`
- `app/src/main/META-INF/androidx.profileinstaller_profileinstaller.version`
- `app/src/main/META-INF/androidx.room_room-runtime.version`
- `app/src/main/META-INF/androidx.savedstate_savedstate-ktx.version`
- `app/src/main/META-INF/androidx.savedstate_savedstate.version`
- `app/src/main/META-INF/androidx.security_security-crypto.version`
- `app/src/main/META-INF/androidx.sqlite_sqlite-framework.version`
- `app/src/main/META-INF/androidx.sqlite_sqlite.version`
- `app/src/main/META-INF/androidx.startup_startup-runtime.version`
- `app/src/main/META-INF/androidx.tracing_tracing.version`
- `app/src/main/META-INF/androidx.vectordrawable_vectordrawable-animated.version`
- `app/src/main/META-INF/androidx.vectordrawable_vectordrawable.version`
- `app/src/main/META-INF/androidx.versionedparcelable_versionedparcelable.version`
- `app/src/main/META-INF/androidx.viewpager_viewpager.version`
- `app/src/main/META-INF/androidx.webkit_webkit.version`
- `app/src/main/META-INF/androidx.work_work-runtime-ktx.version`
- `app/src/main/META-INF/androidx.work_work-runtime.version`
- `app/src/main/META-INF/com/android/build/gradle/app-metadata.properties`
- `app/src/main/META-INF/kotlinx_coroutines_android.version`
- `app/src/main/META-INF/kotlinx_coroutines_core.version`
- `app/src/main/assets/EOS/EpicOnlineServicesConfig.json`
- `app/src/main/assets/EOS/eos_android_config.json`
- `app/src/main/assets/EOS/eos_ios_config.json`
- `app/src/main/assets/EOS/eos_linux_config.json`
- `app/src/main/assets/EOS/eos_macos_config.json`
- `app/src/main/assets/EOS/eos_product_config.json`
- `app/src/main/assets/EOS/eos_steam_config.json`
- `app/src/main/assets/EOS/eos_windows_config.json`
- `app/src/main/assets/EOS/log_level_config.json`
- `app/src/main/assets/UnityServicesProjectConfiguration.json`
- `app/src/main/assets/ad-viewer/245.2c89b6e7.js`
- `app/src/main/assets/ad-viewer/3.8b9677aa.js`
- `app/src/main/assets/ad-viewer/44.db5552a9.js`
- `app/src/main/assets/ad-viewer/ad-viewer-vendors.aa8108b8.js`
- `app/src/main/assets/ad-viewer/ad-viewer.v1.37.1-ad-viewer.html`
- `app/src/main/assets/ad-viewer/adViewer.3ac112b9.js`
- `app/src/main/assets/ad-viewer/config.ad-viewer.json`
- `app/src/main/assets/ad-viewer/da_DK.2e412e42.js`
- `app/src/main/assets/ad-viewer/de.5221b25b.js`
- `app/src/main/assets/ad-viewer/es.a1bb1dd4.js`
- `app/src/main/assets/ad-viewer/fi.9d322d2f.js`
- `app/src/main/assets/ad-viewer/fr.c87f7f8c.js`
- `app/src/main/assets/ad-viewer/is.cf86432c.js`
- `app/src/main/assets/ad-viewer/it.f54da851.js`
- `app/src/main/assets/ad-viewer/ja.9957fa62.js`
- `app/src/main/assets/ad-viewer/ko.5d69c609.js`
- `app/src/main/assets/ad-viewer/lt.2eaf757f.js`
- `app/src/main/assets/ad-viewer/mraid.0.0.6.js`
- `app/src/main/assets/ad-viewer/nb.9ce7e5f8.js`
- `app/src/main/assets/ad-viewer/omid-session-client-v1.js`
- `app/src/main/assets/ad-viewer/omsdk-v1.js`
- `app/src/main/assets/ad-viewer/pt.6cff0ff1.js`
- `app/src/main/assets/ad-viewer/pt_BR.040a0dc0.js`
- `app/src/main/assets/ad-viewer/ro.bfcd1d07.js`
- `app/src/main/assets/ad-viewer/ru.8befa1d9.js`
- `app/src/main/assets/ad-viewer/sv.f2e50e63.js`
- `app/src/main/assets/ad-viewer/tr.a4b783ac.js`
- `app/src/main/assets/ad-viewer/zh_Hans.1cbe8a79.js`
- `app/src/main/assets/ad-viewer/zh_Hant.94192f5b.js`
- `app/src/main/assets/bin/Data/RuntimeInitializeOnLoads.json`
- `app/src/main/assets/bin/Data/ScriptingAssemblies.json`

## 5. DETECTED LIBRARIES, NATIVE LIBS & CERTIFICATES
- androidx.activity_activity-ktx = 1.7.1
- androidx.activity_activity = 1.7.1
- androidx.annotation_annotation-experimental = 1.3.0
- androidx.appcompat_appcompat-resources = 1.5.1
- androidx.appcompat_appcompat = 1.5.1
- androidx.arch.core_core-runtime = task ':arch:core:core-runtime:writeVersionFile' property 'version'
- androidx.browser_browser = 1.4.0
- androidx.core_core-ktx = 1.9.0
- androidx.core_core = 1.9.0
- androidx.cursoradapter_cursoradapter = 1.0.0
- androidx.customview_customview = 1.0.0
- androidx.datastore_datastore = 1.0.0
- androidx.drawerlayout_drawerlayout = 1.0.0
- androidx.emoji2_emoji2-views-helper = 1.2.0
- androidx.emoji2_emoji2 = 1.2.0
- androidx.fragment_fragment = 1.3.6
- androidx.interpolator_interpolator = 1.0.0
- androidx.lifecycle_lifecycle-livedata-core = task ':lifecycle:lifecycle-livedata-core:writeVersionFile' property 'version'
- androidx.lifecycle_lifecycle-livedata = task ':lifecycle:lifecycle-livedata:writeVersionFile' property 'version'
- androidx.lifecycle_lifecycle-process = task ':lifecycle:lifecycle-process:writeVersionFile' property 'version'
- androidx.lifecycle_lifecycle-runtime-ktx = task ':lifecycle:lifecycle-runtime-ktx:writeVersionFile' property 'version'
- androidx.lifecycle_lifecycle-runtime = task ':lifecycle:lifecycle-runtime:writeVersionFile' property 'version'
- androidx.lifecycle_lifecycle-service = task ':lifecycle:lifecycle-service:writeVersionFile' property 'version'
- androidx.lifecycle_lifecycle-viewmodel-ktx = task ':lifecycle:lifecycle-viewmodel-ktx:writeVersionFile' property 'version'
- androidx.lifecycle_lifecycle-viewmodel-savedstate = task ':lifecycle:lifecycle-viewmodel-savedstate:writeVersionFile' property 'version'
- androidx.lifecycle_lifecycle-viewmodel = task ':lifecycle:lifecycle-viewmodel:writeVersionFile' property 'version'
- androidx.loader_loader = 1.0.0
- androidx.profileinstaller_profileinstaller = 1.3.0
- androidx.room_room-runtime = 2.2.5
- androidx.savedstate_savedstate-ktx = 1.2.1
- androidx.savedstate_savedstate = 1.2.1
- androidx.security_security-crypto = 1.0.0
- androidx.sqlite_sqlite-framework = 2.1.0
- androidx.sqlite_sqlite = 2.1.0
- androidx.startup_startup-runtime = 1.1.1
- androidx.tracing_tracing = 1.0.0
- androidx.vectordrawable_vectordrawable-animated = 1.1.0
- androidx.vectordrawable_vectordrawable = 1.1.0
- androidx.versionedparcelable_versionedparcelable = 1.1.1
- androidx.viewpager_viewpager = 1.0.0
- androidx.webkit_webkit = 1.6.1
- androidx.work_work-runtime-ktx = 2.7.0
- androidx.work_work-runtime = 2.7.0
- com/android/build/gradle/app-metadata.properties = appMetadataVersion=1.1 | androidGradlePluginVersion=7.4.2
- kotlinx_coroutines_android = 1.6.4
- kotlinx_coroutines_core = 1.6.4
- com.google.* (2126 classes)
- androidx.core.* (997 classes)
- kotlinx.coroutines.* (857 classes)
- androidx.appcompat.* (435 classes)
- androidx.constraintlayout.* (385 classes)
- androidx.work.* (309 classes)
- androidx.lifecycle.* (173 classes)
- kotlin.collections.* (163 classes)
- androidx.fragment.* (155 classes)
- kotlin.jvm.* (151 classes)
- okhttp3.internal.* (132 classes)
- androidx.activity.* (129 classes)
- androidx.emoji2.* (129 classes)
- androidx.webkit.* (115 classes)
- kotlin.* (113 classes)
- androidx.browser.* (107 classes)
- androidx.room.* (96 classes)
- kotlin.sequences.* (84 classes)
- org.chromium.* (80 classes)
- okhttp3.* (76 classes)
- androidx.annotation.* (73 classes)
- kotlin.io.* (70 classes)
- kotlin.text.* (70 classes)
- androidx.datastore.* (64 classes)
- kotlin.coroutines.* (51 classes)
- kotlin.reflect.* (51 classes)
- androidx.vectordrawable.* (47 classes)
- okio.* (44 classes)
- kotlin.ranges.* (42 classes)
- android.support.* (36 classes)
- androidx.profileinstaller.* (36 classes)
- androidx.viewpager.* (35 classes)
- androidx.loader.* (34 classes)
- kotlin.time.* (32 classes)
- androidx.customview.* (26 classes)
- org.intellij.* (25 classes)
- kotlin.internal.* (24 classes)
- kotlin.comparisons.* (23 classes)
- androidx.drawerlayout.* (22 classes)
- androidx.sqlite.* (22 classes)
- androidx.concurrent.* (19 classes)
- androidx.savedstate.* (18 classes)
- androidx.arch.* (17 classes)
- androidx.collection.* (17 classes)
- androidx.versionedparcelable.* (16 classes)
- kotlin.random.* (16 classes)
- androidx.security.* (13 classes)
- kotlin.contracts.* (11 classes)
- androidx.cursoradapter.* (10 classes)
- kotlin.properties.* (8 classes)
- androidx.startup.* (7 classes)
- org.jetbrains.* (7 classes)
- kotlin.annotation.* (6 classes)
- kotlin.enums.* (6 classes)
- kotlin.streams.* (6 classes)
- androidx.interpolator.* (5 classes)
- kotlin.concurrent.* (5 classes)
- kotlin.math.* (5 classes)
- androidx.tracing.* (4 classes)
- kotlin.experimental.* (4 classes)
- androidx.resourceinspection.* (3 classes)
- kotlin.system.* (2 classes)
- androidx.inspection.* (1 classes)
- kotlin.jdk7.* (1 classes)
- kotlin.js.* (1 classes)
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
- Cert [META-INF/FLAPPYBI.RSA] C=\+1,ST=New York,L=New York,O=Flappy Bird Publishing,OU=Development,CN=Jameel Khan | SHA1withRSA | SHA-256: E2:73:C0:57:47:90:BC:D7:CD:C8:51:60:99:83:FE:F1:25:3F:3F:27:88:67:18:F5:25:DF:3D:9A:A4:DC:B6:D5

## 6. URLS, ENDPOINTS, PROMPTS & KEY STRINGS
- `https://`
- `https://gateway.unityads.unity3d.com/v1`
- `https://scar.unityads.unity3d.com/v1/capture-scar-signals`
- `http://`
- `/UnityAdsWebViewConfiguration.json`
- `/config.json`
- `Lcom/google/android/gms/common/api/Api$AbstractClientBuilder<`
- `Lcom/google/android/gms/common/api/Api$AnyClientKey<`
- `Lcom/google/android/gms/common/api/Api$BaseClientBuilder<`
- `Lcom/google/android/gms/common/api/Api$ClientKey<`
- `Lcom/google/android/gms/common/api/Api<`
- `Lcom/google/android/gms/common/api/BatchResultToken<`
- `Lcom/google/android/gms/common/api/GoogleApi<`
- `Lcom/google/android/gms/common/api/HasApiKey<`
- `Lcom/google/android/gms/common/api/OptionalPendingResult<`
- `Lcom/google/android/gms/common/api/PendingResult<`
- `Lcom/google/android/gms/common/api/Response<`
- `Lcom/google/android/gms/common/api/ResultCallback<`
- `Lcom/google/android/gms/common/api/ResultCallbacks<`
- `Lcom/google/android/gms/common/api/ResultTransform<`
- `Lcom/google/android/gms/common/api/TransformedResult<`
- `Lcom/google/android/gms/common/api/internal/ApiKey<`
- `Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl<`
- `Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder<`
- `Lcom/google/android/gms/common/api/internal/BasePendingResult$CallbackHandler<`
- `Lcom/google/android/gms/common/api/internal/BasePendingResult<`
- `Lcom/google/android/gms/common/api/internal/ListenerHolder$ListenerKey<`
- `Lcom/google/android/gms/common/api/internal/ListenerHolder$Notifier<`
- `Lcom/google/android/gms/common/api/internal/ListenerHolder<`
- `Lcom/google/android/gms/common/api/internal/RegisterListenerMethod<`
- `Lcom/google/android/gms/common/api/internal/RegistrationMethods$Builder<`
- `Lcom/google/android/gms/common/api/internal/RegistrationMethods<`
- `Lcom/google/android/gms/common/api/internal/RemoteCall<`
- `Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder<`
- `Lcom/google/android/gms/common/api/internal/TaskApiCall<`
- `Lcom/google/android/gms/common/api/internal/UnregisterListenerMethod<`
- `Lcom/google/android/gms/common/api/internal/zabq<`
- `Lcom/google/android/gms/common/api/internal/zacd<`
- `Lcom/google/android/gms/common/api/internal/zad<`
- `Lcom/google/android/gms/common/api/internal/zada<`
- `http://schemas.android.com/apk/res/android`
- `https://plus.google.com/`
- `https://www.example.com`
- `https://www.googleapis.com/auth/appstate`
- `https://www.googleapis.com/auth/datastoremobile`
- `https://www.googleapis.com/auth/drive`
- `https://www.googleapis.com/auth/drive.appdata`
- `https://www.googleapis.com/auth/drive.apps`
- `https://www.googleapis.com/auth/drive.file`
- `https://www.googleapis.com/auth/games`
- `https://www.googleapis.com/auth/games.firstparty`
- `https://www.googleapis.com/auth/games_lite`
- `https://www.googleapis.com/auth/plus.login`
- `https://www.googleapis.com/auth/plus.me`
- `private-data.json`
- `public-data.json`
- "Failed to get application intent"
- "EOSOverlayBrowser() (Data), JavaScript:"
- "EOSOverlayBrowser close button error"
- "EOSOverlayBrowser.EndWebview, WebView already removed"
- "EOSOverlayBrowser.EndWebview, bCrashed:"
- "EOSOverlayBrowser.EvaluateJS, RequestId:"
- ", bReadyToEvaluateJavascript:"
- "EOSOverlayBrowser.EvaluateJS, No Browser, RequestId:"
- "EOSOverlayBrowser.InvokeJavascriptCallback, CallbackId:"
- "EOSOverlayBrowser.InvokeJavascriptCallback (No WebView), CallbackId:"
- "EOSOverlayBrowser.InvokeJavascriptCallback, JSONObject error:"
- "EOSOverlayBrowser.LoadURL (Data), URL:"
- "EOSOverlayBrowser.EvaluateJS (Completed), RequestId:"
- "EOSOverlayBrowser.LoadURL, SetCookies failed"
- "EOSOverlayBrowser.LoadURL, WebView no longer exists"
- "EOSOverlayBrowser.LoadURL, OnLoadURL"
- "EOSOverlayBrowser.LoadURL, RemoveAllCookies failed"
- "EOSOverlayBrowser.SetDisplaySettings (No WebView)"
- "EOSJSBridge.GetNextJavascriptCallbackId: , JavascriptCallbackId:"
- "EOSOverlayJavascriptInterface.OnExecuteJavascriptFunction: , CallbackId:"
- "EOSWebChromeClient, [console]"
- "EOSWebChromeClient unexpected onCreateWindow"
- "EOSWebChromeClient unexpected onGeolocationPermissionsHidePrompt"
- "EOSWebChromeClient unexpected onGeolocationPermissionsShowPrompt"
- "EOSWebChromeClient unexpected onJsAlert"
- "EOSWebChromeClient unexpected onJsBeforeUnload"
- "EOSWebChromeClient unexpected onJsConfirm"
- "EOSWebChromeClient unexpected onJsPrompt"
- "EOSWebChromeClient unexpected onPermissionRequest"
- "EOSWebChromeClient unexpected onPermissionRequestCanceled"
- "EOSWebChromeClient onProgressChanged:"
- "EOSWebChromeClient unexpected onShowFileChooser"
- "onTouchEvent, isWithinHitBox:"
- "performClick, isEnabled:"
- "EOSOverlayWebViewClient.onLoadResource, URL:"
- "EOSOverlayWebViewClient.onPageFinished, URL:"
- "EOSOverlayWebViewClient.onPageStarted, URL:"
- "EOSOverlayWebViewClient.onReceivedError, IsMainFrame:"
- "EOSOverlayWebViewClient.onReceivedHttpError, IsMainFrame:"
- "EOSOverlayWebViewClient.onReceivedSslError, URL:"
- "EOSOverlayWebViewClient.onRenderProcessGone, Browser termination unexpected. Sending crashed status, Detail:"
- ", bHasDarkenedBackground="
- ", bEnableExclusiveInputMode="
- "EOSOverlayWidgetManager.NewBrowser, Received LoadURL request with browser already open. Closing existing browser, URL:"
- "EOSOverlayWidgetManager.NewBrowser, Failed to create new Browser"
- "EOSOverlayWidgetManager.GetDisplaySettings, No such browser can be found"
- "EOSOverlayWidgetManager.LoadURL: no DisplaySettings, creating default ones instead"
- "EOSOverlayWidgetManager.OnExecuteJavascriptFunction, StoreOverlayIdForCallback failed, CallbackId:"
- "EOSOverlayWidgetManager.SetDisplaySettings: no DisplaySettings, creating default ones instead"
- "EOSOverlayWidgetManager.SetDisplaySettings, No such browser can be found"
- "EOSOverlayWidgetManager.EndWebview, No such browser can be found"
- "EOSOverlayWidgetManager.EvaluateJS, Eval JS Failed because no such browser can be found, RequestId:"
- "EOSOverlayWidgetManager.InvokeJavascriptCallback, No such callback can be found, CallbackId:"
- "EOSOverlayWidgetManager.InvokeJavascriptCallback, Mismatch between stored InstanceId and calling InstanceId, Stored OverlayId:"
- "EOSOverlayWidgetManager.InvokeJavascriptCallback, No such browser can be found"
- "Keychain ReadValue failed."
- "Keychain WriteValue failed."
- "No browser found in current profile"
- "No browser found for intent"
- "No Custom Tab Session available"
- "Prewarming URL successful"
- "No package found for binding custom tab service"
- "Custom tab bind successful"
- "Custom Tab Client warmup failed"
- "Custom Tab Client warmup successful"
- "Custom Tab Session failed"
- "Custom Tab Session successful"
- "Custom Tab service disconnected"
- "Unhandled case: unknown login state"
- "Failed to set Unity Ads options"
- "call to 'resume' before 'invoke' with coroutine"
- "BannerView not found for opportunityId:"
- "null cannot be cast to non-null type kotlin.String"
- "null cannot be cast to non-null type org.json.JSONArray"
- "Unity Ads WebView calling for:"
- "Builder()\n        .addPa…_DOMAIN)\n        .build()"
- "Webview Asset not found: %s"
- "AdPlayer was not able to load the webview."
- "Opportunity ID not found"
- "encodeToString(value, Base64.NO_WRAP)"
- "null cannot be cast to non-null type org.json.JSONObject"
- "this as java.lang.String).getBytes(charset)"
- "Gateway request was canceled due to exceeding timeout for operation"
- "Gateway was canceled while waiting for next request,  after"
- "retries currentDuration:"
- "Gateway request failed after"
- "retries  currentDuration:"
- "parseFrom(\n             …8859_1)\n                )"
- "Could not parse response from gateway service"
- "Failed to parse response from gateway service with exception: %s"
- "ERROR: Could not parse response from gateway service"
- "Super calls with default arguments not supported in this target, function: request"
- "Unable to find a suitable EGLConfig"
- "unable to initialize EGL14"
- "unable to get EGL14 display"
- "Cannot have identical entries."
- "Invalid object type for purchases"
- "Error constructing purchase object"
- "Unity Ads could not commit metadata due to storage error or the data is null"
- "Unity Ads could not commit metadata due to storage error"
- "Java interface default methods are only supported since Android Oreo"
- "Scripting proxy object was destroyed, because Unity player was unloaded."
- "startBluetoothSco() failed. no bluetooth device connected."
- "NetworkConnectivity: ConnectivityManager not found"
- "PlayAssetDeliveryUnityWrapper should be created only once. Use getInstance() instead."
- "AssetPackManager API is not available! Make sure your gradle project includes 'com.google.android.play:asset-delivery' dependency."
- "PlayAssetDeliveryUnityWrapper is not yet initialised."
- "PlayAssetDeliveryUnityWrapper.init() should be called only once. Use getInstance() instead."
- "Interrupted while waiting for all proxies to exit."
- "no %s field with name='%s' signature='%s' in class L%s;"
- "no %s method with name='%s' signature='%s' in class L%s;"
- "Not running from an Activity; Ignoring execution request..."
- "Your hardware does not support this application."
- "Native libraries not loaded - dropping message for"
- "NativeLoader.load failure, Unity libraries were not loaded."
- "Failed to load 'libmain.so'"
- "ms) while trying to pause the Unity Engine."
- "UI thread got interrupted while trying to pause the Unity Engine."
- "Java class preloading failed:"
- "Unable to unload libraries from libmain.so"
- "ms) while trying detaching primary window."
- "UI thread got interrupted while trying to detach the primary window from the Unity Engine."
- "addViewToPlayer: Failure adding view to hierarchy"
- "addViewToPlayer: Failure removing old view from hierarchy"
- "ms) while waiting softinput hiding operation."
- "UI thread got interrupted while waiting softinput hiding operation."
- "removeViewFromPlayer: Failure removing view from hierarchy"
- "removeVireFromPlayer: Failure agging old view to hierarchy"
- "ms) while waiting softinput showing operation."
- "UI thread got interrupted while waiting softinput showing operation."
- "Orientation Listener already started."
- "Orientation Listener cannot detect orientation."
- "Orientation Listener was not started."
- "Device model      : %s %s"
- "Exception when opening Softinput"
- "AssetPackManagerWrapper should be created only once. Use getInstance() instead."
- "Camera2: Capture session failed"
- "Camera2: CaptureSession configuration failed."
- "Camera2: IllegalStateException"
- "Camera2: CameraAccessException"
- "Camera2: CameraDevice disconnected."
- "Camera2: Error opeining CameraDevice"
- "Camera2: Wrong image format."
- "Camera2: Timeout waiting to lock camera for closing."
- "Camera2: Timeout waiting to close camera."
- "Camera2: Interrupted while waiting to close camera"
- "Camera2: Interrupted while trying to lock camera for closing"
- "Camera2: configuration map is not available."
- "Camera2: Interrupted while waiting for the background thread to finish"
- "Camera2: Setting manual focus point already started."
- "Camera2: only LEGACY hardware level is supported."
- "Camera2: Timeout waiting to lock camera for opening."
- "Camera2: Timeout waiting to open camera."
- "Camera2: Interrupted while waiting to open camera"
- "Camera2: Interrupted while trying to lock camera for opening"
- "Camera2: target FPS ranges are not avialable."
- "Couldn't add view, because it's already assigned to another parent"
- "NativeShare couldn't call grantUriPermission:"
- "getprop ro.miui.ui.version.name"
- "Can't find ContentProvider, share not possible!"
- "Creating custom share dialog"
- "Creating standard share dialog"
- "NativeShareResultReceiver was null!"
- "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
- "NativeShareContentProvider.resolveContentProvider is null!"
- "Provider must grant uri permissions"
- "Provider must not be exported"
- "No apps can perform this action."
- "Dismissed custom share dialog"
- "Reported share result (may not be correct):"
- "Failed to resolve canonical path for"
- "Resolved path jumped beyond configured root"
- "Unable to find configured root for"
- "Failed to find configured root that contains"
- "flattener.flattenJson(\".… flattenerRulesUseCase())"
- "Problems fetching adb enabled status"
- "Problems fetching airplane mode status"
- "Unity Ads was not able to get current network type due to missing permission"
- "{\n            TimeZone.g…ORT, Locale.US)\n        }"
- "Could not read timeZone information: %s"
- "Problems fetching stay on while plugged in status"
- "CN=Android Debug,O=Android,C=US"
- "{\n            if (pm.get…e\n            }\n        }"
- "Error getting package info"
- "{\n            Build.SOC_MODEL\n        }"
- "null cannot be cast to non-null type java.security.cert.X509Certificate"
- "Exception when signing certificate fingerprint"
- "Error reading memory info"
- "null cannot be cast to non-null type android.telephony.TelephonyManager"
- "{\n        WebSettings.ge…tUserAgent(context)\n    }"
- "Exception getting webview user agent"
- "pm.getApplicationInfo(pkgName, 0)"
- "this as java.lang.String).toLowerCase(locale)"
- "null cannot be cast to non-null type android.hardware.SensorManager"
- "{\n            ByteString.EMPTY\n        }"
- "newBuilder()\n           …rer)\n            .build()"
- "newBuilder()\n           …\n                .build()"
- "newBuilder()\n           …                 .build()"
- "currentData.toBuilder()\n…\n                .build()"
- "Super calls with default arguments not supported in this target, function: getFile"
- "Super calls with default arguments not supported in this target, function: fetch"
- "createAdSession(adSessionConfiguration, context)"
- "createAdSessionConfigura…VerificationScripts\n    )"
- "createHtmlAdSessionConte…customReferenceData\n    )"
- "createJavascriptAdSessio…customReferenceData\n    )"
- "Billing service disconnected"
- "null cannot be cast to non-null type kotlin.Long"
- "[UnityAds] Could not parse Ad Markup"
- "[UnityAds] Internal communication failure"
- "[UnityAds] Internal communication failure: %s"
- "[UnityAds] Internal communication timeout"
- "[UnityAds] Failed to create load request"
- "[UnityAds] SDK Initialization Failed"
- "[UnityAds] SDK Initialization Failure"
- "[UnityAds] SDK not initialized"
- "[UnityAds] Object ID cannot be null"
- "[UnityAds] Object ID already used"
- "[UnityAds] Placement ID cannot be null"
- "[UnityAds] Timeout while loading"
- "Unity Ads Sending diagnostic batch enabled:"
- "{\n            // We need…dererByteString\n        }"
- "{\n            ByteString.empty()\n        }"
- "Gateway communication failure"
- "Unity Ads Initialization Failure:"
- "Unity Ads Initialization Start"
- "Unity Ads Initialization Success"
- "override suspend fun inv…RefreshResponse\n        }"
- "IUnityAdsTokenListener is null"
- "newBuilder().apply {\n   …                }.build()"
- "opportunity ?: ByteString.EMPTY"
- "Unity Ads Load Failure for placement:"
- "Unity Ads Load Success for placement:"
- "Unity Ads Load Start for placement"
- "Ad player is unavailable."
- "Can't show a new ad unit when ad unit is already open"
- "No ad object found for opportunity id:"
- "No valid opportunity id provided"
- "[UnityAds] Timeout while trying to show"
- "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad"
- "Unity Ads Show Left Application for placement"
- "getOpportunityId(showOpt…ing() ?: ByteString.EMPTY"
- "Unity Ads Show Clicked for placement"
- "Unity Ads Show Completed for placement"
- "Unity Ads Show WV Start for placement"
- "Unity Ads Show Start for placement"
- "No adPlayer associated with ad"
- "No ad associated with opportunityId"
- "Super calls with default arguments not supported in this target, function: invoke"
- "awaitInitialization timeout"
- "Unity Ads Show Failed for placement"
- "baseUrl.toUri()\n        …4())\n            .build()"
- "null cannot be cast to non-null type kotlin.Int"
- "Builder()\n            .s…TED)\n            .build()"
- "OneTimeWorkRequestBuilde…a())\n            .build()"
- "when (result) {\n        …sult.Failure -> url\n    }"
- "acc.put(key, loadOptions[key])"
- "encodeToString(deviceInf…eArray(), Base64.NO_WRAP)"
- "null cannot be cast to non-null type kotlin.Boolean"
- "decode(it[0] as String, Base64.NO_WRAP)"
- "Invalid mediaEventsOwner"
- "Invalid videoEventsOwner"
- "{\n            universalR…esult.success()\n        }"
- "{\n            Result.retry()\n        }"
- "Builder()\n            .p…tId)\n            .build()"
- "it.fileName ?: SDKErrorHandler.UNKNOWN_FILE"
- "copyFrom(android.util.Base64.decode(this, flag))"
- "encodeToString(this.toByteArray(), flag)"
- "Expected 16 byte ByteString or UUID string"
- "Error mapping headers for the request"
- "Unity Ads cache: checking app directory for Unity Ads cached files"
- "Error closing FileOutputStream"
- "Unhandled deviceMaxVolume error:"
- "Unhandled deviceVolume error:"
- "Error while constructing process info"
- "Unhandled ringerMode error:"
- "Unhandled screenBrightness error:"
- "Exception parsing intent"
- "Couldn't parse categories for intent"
- "Unable to parse launch intent extra"
- "Unity Ads init: WebView called download"
- "Web Application initialized"
- "Error parsing response headers"
- "JSONException when composing extras for broadcast action"
- "Successfully created .nomedia file"
- "Using existing .nomedia file"
- "Failed to create .nomedia file"
- "Unity Ads is using external cache directory:"
- "Unity Ads is using internal cache directory:"
- "Creating external cache directory failed"
- "External media not mounted"
- "Unity Ads failed to initialize cache directory"
- "Failed to delete testfile"
- "Read buffer size mismatch"
- "Read buffer content mismatch"
- "Unity Ads exception while testing cache directory"
- "Couldn't synchronize thread"
- "Unity Ads cache: resuming download"
- "Unity Ads cache: start downloading"
- "Unity Ads cache: download cancelled, no internet connection available"
- "Couldn't create target file"
- "Unity Ads cache: could not set file readable!"
- "Unity Ads cache: downloading of"
- "There are headers left in data, reading them"
- "WebView URL is null or empty"
- "Non 2xx HTTP status received from ads configuration request."
- "Could not create web request"
- "Could not create web request:"
- "Unable to read configuration from storage"
- "Requesting configuration with:"
- "Unity Ads failed to initialize due to internal error"
- "Unity Ads cache directory check OK"
- "Unity Ads cache directory check fail: no working cache directory available"
- "Unity Ads ProGuard check OK"
- "Unity Ads ProGuard check fail: missing @JavascriptInterface annotations in Unity Ads web bridge"
- "Unknown exception during Unity Ads ProGuard check:"
- "Unity Ads ProGuard check fail: Unity Ads web bridge methods not found"
- "Unity Ads ProGuard check fail: Unity Ads web bridge class not found"
- "Invalid rule %s for experiment"
- "Couldn't get active experiments, reverting to default experiments"
- "SDK Failed to Initialize due to"
- "sendConfigResolutionRequestIfNeeded called with invalid timestamps, skipping metric"
- "sendPrivacyResolutionRequestIfNeeded called with invalid timestamps, skipping metric"
- "sendTokenAvailabilityMetricWithConfig called before didInitStart, skipping metric"
- "sendTokenResolutionRequestMetricIfNeeded called before didInitStart, skipping metric"
- "sdkDidInitialize called before didInitStart, skipping metric"
- "sdkInitializeFailed called before didInitStart, skipping metric"
- "could not read from file"
- "Unity Ads SDK failed to initialize due to application doesn't have enough memory to initialize Unity Ads SDK"
- "Unity Ads SDK encountered an error during initialization, cancel initialization"
- "Privacy request failed with code:"
- "Failure trying to clean cache:"
- "Unity Ads init: load configuration from"
- "Unity Ads init: creating webapp"
- "Unity Ads WebApp creation failed"
- "Unity Ads init: downloading webapp from"
- "Unity Ads init: halting init in"
- "Unity Ads init: check if webapp can be loaded from local cache"
- "Unity Ads init: webapp loaded from local cache"
- "Unity Ads init: webapp not found in local cache:"
- "Unity Ads init: Loading Config File Parameters"
- "Unity Ads init: Using default configuration parameters"
- "Unity Ads init: loading webapp from"
- "Unity Ads init: network error, waiting for connection events"
- "No connected events within the timeout!"
- "Unity Ads init got connected event"
- "Unity Ads init got disconnected event"
- "Unity Ads init: starting init"
- "Reset failed on opening ConditionVariable"
- "WebView cache directory is NULL"
- "Unity Ads init: retrying in"
- "Couldn't fetch privacy configuration:"
- "Unity Ads connectivity change: connected"
- "Unity Ads connectivity change: network change"
- "Unity Ads connectivity change: disconnected"
- "Couldn't bind to identifier service intent"
- "Couldn't get advertising info"
- "Error closing RandomAccessFile"
- "Error while reading memory info:"
- "Error while reading processor info:"
- "Couldn't get openAdvertising info"
- "Failed to read storage JSON file:"
- "Storage JSON file not found in local cache:"
- "Couldn't send storage event to WebApp"
- "null cannot be cast to non-null type android.database.ContentObserver"
- "Couldn't put service to binder que"
- "Error occurred while trying to compress device data."
- "Invalid DeviceInfoData: Expected non null map provided by reader"
- "Error getting webview user agent"
- "this as java.lang.String).toUpperCase(Locale.ROOT)"
- "No service instance found for"
- "Cannot have multiple identical services:"
- "StorageManager failed to initialize"
- "Super calls with default arguments not supported in this target, function: getService"
- "Wrong Exception type found"
- "this as java.lang.String).substring(startIndex)"
- "this as java.lang.String).toLowerCase(Locale.ROOT)"
- "Unity Ads Init: Could not load config file from local storage:"
- "Unity Ads Init: Loading Config File From Local Storage"
- "[Unity Ads] Internal error"
- "Unknown exception from withRetry"
- "DO NOT USE EMPTY MESSAGES, use DeviceLog.entered() instead"
- "Could not flatten JSON: %s"
- "Couldn't create new JSONObject"
- "Couldn't get existing JSONObject"
- "Couldn't read JSONObject:"
- "Data is NULL, readStorage probably not called"
- "Storage not properly initialized or incorrect parameters:"
- "Cannot set subvalue to an object that is not JSONObject"
- "Failed to merge storage:"
- "SHA-256 algorithm not found"
- "Failed to read all bytes from input file path:"
- "An uncaught exception has occurred in the client application.  Exception: %s"
- "Error while removing view from it's parent"
- "Network request timed out"
- "create(MediaType.parse(\"…in;charset=utf-8\"), body)"
- "create(MediaType.parse(\"…lain;charset=utf-8\"), \"\")"
- "Builder()\n    .also { he…ng(\",\")) } }\n    .build()"
- "create(MediaType.parse(\"…ation/x-protobuf\"), body)"
- "create(MediaType.parse(\"…ication/x-protobuf\"), \"\")"
- "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()"
- "acc.put(JSONArray(listOf(key, value)))"
- "Unity Ads failed to cast"
- "Failed to retrieve application info for current package"
- "ERROR: Could not find %s class with method %s and parameters : %s"
- "ERROR: Could not find method %s in %s"
- "ERROR: Could not find method %s"
- "ERROR: Could not invoke method %s : %s"
- "ERROR: Could not find Class %s %s"
- "ERROR: Could not find class %s"
- "Invalid url-protocol in url:"
- "Error writing POST params:"
- "Error while writing POST params"
- "Can't open error stream:"
- "Error completing request"
- "Handling request message:"
- "Out of memory error while doing web request."
- "Request is NULL or too short"
- "Exception while resolving host"
- "Failed to refreshMediationData: %s"
- "Metric event not sent due to being null or empty:"
- "Metrics event not send due to being empty"
- "was not sent to null or empty endpoint:"
- "Metric event not sent due to being empty:"
- "Metrics will not be sent from the device for this session due to misconfiguration"
- "Metrics will not be sent from the device for this session"
- "failed to send with error:"
- "failed to send with response code:"
- "was skipped from being sent"
- "Super calls with default arguments not supported in this target, function: sendEvent"
- "JSON error while constructing accelerometer data"
- "ERROR: IntervalTimer failed to start due to exception"
- "Cannot call create() from main thread!"
- "invokeBatchCallback ignored because web app is not loaded"
- "Out of memory error while invoking callback to WebView"
- "Error while invoking batch response for WebView"
- "invokeMethod ignored because web app is not loaded"
- "Out of memory error while handling invocation to WebView"
- "Error invoking javascript method"
- "sendEvent ignored because web app is not loaded"
- "Out of memory error while sending event to WebView"
- "Error while sending event to WebView"
- "Unsupported charset when encoding %s"
- "Unity Ads SDK unable to create WebViewApp"
- "Unity Ads SDK finished loading URL inside WebView:"
- "Unity Ads SDK encountered an error (code:"
- ")  in WebView while loading a resource"
- "Unity Ads SDK encountered an error in WebView while loading a resource"
- "UnityAds SDK WebView render process gone with following reason :"
- "Unity Ads SDK attempts to load URL inside WebView:"
- "Error handling invocation %s.%s(%s)"
- "Error while invoking method"
- "Couldn't get batch with id:"
- "webViewBridgeInvoker cannot be null"
- "WebViewBridgeInvocation callback method cannot be found"
- "WebViewBridgeInvocationRunnable:run: invokeMethod failure"
- "WebViewBridgeInvocationRunnable:run CallbackStatus.Error"
- "Couldn't fetch purchases onActivityResumed."
- "Error retrieving int from eventTypes"
- "Error building response JSON"
- "Couldn't fetch keyIndices"
- "Couldn't add value to requested infos"
- "Couldn't construct event info"
- "Couldn't construct info object"
- "JSON error while constructing display cutout object"
- "Error while calling displayCutout getter"
- "Method getDisplayCutout not found"
- "Error parsing views from viewList"
- "Unity Ads opening new transparent ad unit activity, hardware acceleration disabled"
- "Unity Ads opening new hardware accelerated ad unit activity"
- "Unity Ads opening new hardware accelerated transparent ad unit activity"
- "Unity Ads opening new ad unit activity, hardware acceleration disabled"
- "Opened AdUnitActivity with:"
- "Could not set activityId for intent"
- "Starting playback of prepared video"
- "Preparing video for playback:"
- "Error forming JSON object"
- "Operation state found is not for banner ad"
- "No operation found for requested banner"
- "Unity Ads SDK encountered an exception:"
- "Unity Ads SDK initialize has already been called with"
- "Responding with first initialization result."
- "Unity Ads SDK failed to initialize due to previous failed reason"
- "Error while initializing Unity Services: device is not supported"
- "Unity Ads SDK failed to initialize due to device is not supported"
- "Error while initializing Unity Services: empty game ID, halting Unity Ads init"
- "Unity Ads SDK failed to initialize due to empty game ID"
- "Error while initializing Unity Services: null context, halting Unity Ads init"
- "Unity Ads SDK failed to initialize due to null context"
- "Initializing Unity Services"
- "Error during Unity Services environment check, halting Unity Services init"
- "Unity Ads SDK failed to initialize due to environment check failed"
- "Unity Services environment check OK"
- "Error while initializing Unity Services: cannot retrieve application context, halting Unity Ads init"
- "Unity Ads SDK failed to initialize due to inability to retrieve application context"
- "Error while initializing Unity Services: cannot retrieve application from context, halting Unity Ads init"
- "Unity Ads SDK failed to initialize due to inability to retrieve application from context"
- "Error while initializing Unity Services: invalid context, halting Unity Ads init"
- "Unity Ads SDK failed to initialize due to invalid context"
- "Please provide non-null listener to UnityAds.GetToken method"
- "Unity Ads is not supported for this device"
- "Activity must not be null"
- "Could not place view because it is null, finishing activity"
- "Unity Ads web app is null, closing Unity Ads activity from onCreate"
- "Unity Ads web app is null, closing Unity Ads activity from onDestroy"
- "Unity Ads web app is null, closing Unity Ads activity from onPause"
- "Unity Ads web view is null, from onPause"
- "Unity Ads web app is null, closing Unity Ads activity from onResume"
- "Unity Ads web app is null, closing Unity Ads activity from onStart"
- "Unity Ads web app is null, closing Unity Ads activity from onStop"
- "Error getting layoutInDisplayCutoutMode"
- "Error setting layoutInDisplayCutoutMode"
- "Error while setting SystemUIVisibility"
- "Could not create SCAR adapter object."
- "SCAR bidding unsupported."
- "Could not create SCAR adapter object"
- "Scar Adapter object is null"
- "SCAR version %s is not supported."
- "ERROR: Could not find class %s %s"
- "ERROR: Could not get adapter states enum from AdapterStatus.State"
- "ERROR: Could not create InitializeCompletionListener"
- "Could not find class \"com.google.android.gms.ads.initialization.InitializationStatus\" %s"
- "Could not find class \"com.google.android.gms.ads.initialization.OnInitializationCompleteListener\" %s"
- "ERROR: Could not get initialization status of GMA SDK - %s"
- "Got exception finding GMA SDK: %s"
- "Could not parse %s to an Integer: %s"
- "webViewBridgeInvocation cannot be null"
- "invocationMethodName cannot be null"
- "[UnityAds] Error creating show options"
- "[UnityAds] Show Invocation Timeout"
- "Failed to remove callback from a handler"
- "Unknown token type passed to sendTokenMetrics"
- "Unity Ads failed to generate token."
- "Failed to get topics with error:"
- "MediaPlayer generic error"
- "Exception while sending current position to webapp"
- "Video player prepare timeout:"
- "Exception while preparing timer"
- "Method evaluateJavascript not found"
- "Error getting default return value"
- "Error getting super call status"
- "Error getting send event status"
- "Error while processing JavaScriptString"
- "Could not process JavaScript, the string is NULL"
- "Received SSL error for '%s': %s"
- "Received unknown SSL error: SslError was null"
- "UnityAds Sdk WebPlayer onRenderProcessGone :"
- "A Banner is already in use, please call destroy before loading another banner!"
- "Unity Ads is not supported on this device."
- "UnityAds is not initialized."
- "UnityAds sdk initialization failed"
- "WebViewApp was not available, this is likely because UnityAds has not been initialized"
- "Required value was null."
- "Couldn't parse BillingResponse JSON : %s"
- "Could not build Purchase result Json:"

## 7. BINARY MEDIA, FONTS & RAW ASSETS (218)
- `assets/bin/Data/Managed/Metadata/global-metadata.dat` (14.4 MB)
- `assets/bin/Data/Managed/Resources/Newtonsoft.Json.dll-resources.dat` (900 B)
- `assets/bin/Data/Managed/Resources/System.Data.dll-resources.dat` (91 KB)
- `assets/bin/Data/Managed/Resources/System.Drawing.dll-resources.dat` (24 KB)
- `assets/bin/Data/Managed/Resources/mscorlib.dll-resources.dat` (329 KB)
- `assets/bin/Data/boot.config` (151 B)
- `assets/bin/Data/data.unity3d` (33.2 MB)
- `assets/bin/Data/sharedassets0.resource` (1.2 MB)
- `assets/bin/Data/sharedassets2.resource` (114 KB)
- `assets/bin/Data/unity default resources` (1.1 MB)
- `assets/bin/Data/unity_app_guid` (36 B)
- `assets/dexopt/baseline.prof` (1 KB)
- `assets/dexopt/baseline.profm` (194 B)
- `res/drawable-hdpi/abc_ab_share_pack_mtrl_alpha.9.png` (272 B)
- `res/drawable-hdpi/abc_btn_check_to_on_mtrl_000.png` (227 B)
- `res/drawable-hdpi/abc_btn_check_to_on_mtrl_015.png` (404 B)
- `res/drawable-hdpi/abc_btn_radio_to_on_mtrl_000.png` (464 B)
- `res/drawable-hdpi/abc_btn_radio_to_on_mtrl_015.png` (563 B)
- `res/drawable-hdpi/abc_btn_switch_to_on_mtrl_00001.9.png` (1 KB)
- `res/drawable-hdpi/abc_btn_switch_to_on_mtrl_00012.9.png` (1 KB)
- `res/drawable-hdpi/abc_cab_background_top_mtrl_alpha.9.png` (226 B)
- `res/drawable-hdpi/abc_ic_commit_search_api_mtrl_alpha.png` (171 B)
- `res/drawable-hdpi/abc_list_divider_mtrl_alpha.9.png` (167 B)
- `res/drawable-hdpi/abc_list_focused_holo.9.png` (258 B)
- `res/drawable-hdpi/abc_list_longpressed_holo.9.png` (212 B)
- `res/drawable-hdpi/abc_list_pressed_holo_dark.9.png` (208 B)
- `res/drawable-hdpi/abc_list_pressed_holo_light.9.png` (208 B)
- `res/drawable-hdpi/abc_list_selector_disabled_holo_dark.9.png` (228 B)
- `res/drawable-hdpi/abc_list_selector_disabled_holo_light.9.png` (229 B)
- `res/drawable-hdpi/abc_menu_hardkey_panel_mtrl_mult.9.png` (738 B)
- `res/drawable-hdpi/abc_popup_background_mtrl_mult.9.png` (1 KB)
- `res/drawable-hdpi/abc_scrubber_control_off_mtrl_alpha.png` (201 B)
- `res/drawable-hdpi/abc_scrubber_control_to_pressed_mtrl_000.png` (196 B)
- `res/drawable-hdpi/abc_scrubber_control_to_pressed_mtrl_005.png` (272 B)
- `res/drawable-hdpi/abc_scrubber_primary_mtrl_alpha.9.png` (205 B)
- `res/drawable-hdpi/abc_scrubber_track_mtrl_alpha.9.png` (196 B)
- `res/drawable-hdpi/abc_spinner_mtrl_am_alpha.9.png` (345 B)
- `res/drawable-hdpi/abc_switch_track_mtrl_alpha.9.png` (484 B)
- `res/drawable-hdpi/abc_tab_indicator_mtrl_alpha.9.png` (190 B)
- `res/drawable-hdpi/abc_text_select_handle_left_mtrl.png` (278 B)
- `res/drawable-hdpi/abc_text_select_handle_middle_mtrl.png` (396 B)
- `res/drawable-hdpi/abc_text_select_handle_right_mtrl.png` (262 B)
- `res/drawable-hdpi/abc_textfield_activated_mtrl_alpha.9.png` (186 B)
- `res/drawable-hdpi/abc_textfield_default_mtrl_alpha.9.png` (192 B)
- `res/drawable-hdpi/abc_textfield_search_activated_mtrl_alpha.9.png` (178 B)
- `res/drawable-hdpi/abc_textfield_search_default_mtrl_alpha.9.png` (178 B)
- `res/drawable-hdpi/common_full_open_on_phone.png` (681 B)
- `res/drawable-hdpi/common_google_signin_btn_icon_dark_normal_background.9.png` (897 B)
- `res/drawable-hdpi/common_google_signin_btn_icon_light_normal_background.9.png` (683 B)
- `res/drawable-hdpi/common_google_signin_btn_text_dark_normal_background.9.png` (960 B)
- `res/drawable-hdpi/common_google_signin_btn_text_light_normal_background.9.png` (694 B)
- `res/drawable-hdpi/googleg_disabled_color_18.png` (410 B)
- `res/drawable-hdpi/googleg_standard_color_18.png` (808 B)
- `res/drawable-hdpi/notification_bg_low_normal.9.png` (212 B)
- `res/drawable-hdpi/notification_bg_low_pressed.9.png` (225 B)
- `res/drawable-hdpi/notification_bg_normal.9.png` (212 B)
- `res/drawable-hdpi/notification_bg_normal_pressed.9.png` (225 B)
- `res/drawable-hdpi/notify_panel_notification_icon_bg.png` (107 B)
- `res/drawable-ldrtl-hdpi/abc_spinner_mtrl_am_alpha.9.png` (345 B)
- `res/drawable-ldrtl-mdpi/abc_spinner_mtrl_am_alpha.9.png` (318 B)
- `res/drawable-ldrtl-xhdpi/abc_spinner_mtrl_am_alpha.9.png` (417 B)
- `res/drawable-ldrtl-xxhdpi/abc_spinner_mtrl_am_alpha.9.png` (525 B)
- `res/drawable-ldrtl-xxxhdpi/abc_spinner_mtrl_am_alpha.9.png` (437 B)
- `res/drawable-mdpi/abc_ab_share_pack_mtrl_alpha.9.png` (267 B)
- `res/drawable-mdpi/abc_btn_check_to_on_mtrl_000.png` (214 B)
- `res/drawable-mdpi/abc_btn_check_to_on_mtrl_015.png` (321 B)
- `res/drawable-mdpi/abc_btn_radio_to_on_mtrl_000.png` (324 B)
- `res/drawable-mdpi/abc_btn_radio_to_on_mtrl_015.png` (356 B)
- `res/drawable-mdpi/abc_btn_switch_to_on_mtrl_00001.9.png` (754 B)
- `res/drawable-mdpi/abc_btn_switch_to_on_mtrl_00012.9.png` (825 B)
- `res/drawable-mdpi/abc_cab_background_top_mtrl_alpha.9.png` (216 B)
- `res/drawable-mdpi/abc_ic_commit_search_api_mtrl_alpha.png` (173 B)
- `res/drawable-mdpi/abc_list_divider_mtrl_alpha.9.png` (167 B)
- `res/drawable-mdpi/abc_list_focused_holo.9.png` (228 B)
- `res/drawable-mdpi/abc_list_longpressed_holo.9.png` (211 B)
- `res/drawable-mdpi/abc_list_pressed_holo_dark.9.png` (207 B)
- `res/drawable-mdpi/abc_list_pressed_holo_light.9.png` (207 B)
- `res/drawable-mdpi/abc_list_selector_disabled_holo_dark.9.png` (217 B)
- `res/drawable-mdpi/abc_list_selector_disabled_holo_light.9.png` (217 B)
- `res/drawable-mdpi/abc_menu_hardkey_panel_mtrl_mult.9.png` (541 B)
- `res/drawable-mdpi/abc_popup_background_mtrl_mult.9.png` (776 B)
- `res/drawable-mdpi/abc_scrubber_control_off_mtrl_alpha.png` (159 B)
- `res/drawable-mdpi/abc_scrubber_control_to_pressed_mtrl_000.png` (145 B)
- `res/drawable-mdpi/abc_scrubber_control_to_pressed_mtrl_005.png` (197 B)
- `res/drawable-mdpi/abc_scrubber_primary_mtrl_alpha.9.png` (203 B)
- `res/drawable-mdpi/abc_scrubber_track_mtrl_alpha.9.png` (194 B)
- `res/drawable-mdpi/abc_spinner_mtrl_am_alpha.9.png` (327 B)
- `res/drawable-mdpi/abc_switch_track_mtrl_alpha.9.png` (395 B)
- `res/drawable-mdpi/abc_tab_indicator_mtrl_alpha.9.png` (186 B)
- `res/drawable-mdpi/abc_text_select_handle_left_mtrl.png` (203 B)
- `res/drawable-mdpi/abc_text_select_handle_middle_mtrl.png` (310 B)
- `res/drawable-mdpi/abc_text_select_handle_right_mtrl.png` (186 B)
- `res/drawable-mdpi/abc_textfield_activated_mtrl_alpha.9.png` (181 B)
- `res/drawable-mdpi/abc_textfield_default_mtrl_alpha.9.png` (178 B)
- `res/drawable-mdpi/abc_textfield_search_activated_mtrl_alpha.9.png` (178 B)
- `res/drawable-mdpi/abc_textfield_search_default_mtrl_alpha.9.png` (178 B)
- `res/drawable-mdpi/common_google_signin_btn_icon_dark_normal_background.9.png` (609 B)
- `res/drawable-mdpi/common_google_signin_btn_icon_light_normal_background.9.png` (500 B)
- `res/drawable-mdpi/common_google_signin_btn_text_dark_normal_background.9.png` (614 B)
- `res/drawable-mdpi/common_google_signin_btn_text_light_normal_background.9.png` (465 B)
- `res/drawable-mdpi/googleg_disabled_color_18.png` (281 B)
- `res/drawable-mdpi/googleg_standard_color_18.png` (562 B)
- `res/drawable-mdpi/notification_bg_low_normal.9.png` (215 B)
- `res/drawable-mdpi/notification_bg_low_pressed.9.png` (223 B)
- `res/drawable-mdpi/notification_bg_normal.9.png` (215 B)
- `res/drawable-mdpi/notification_bg_normal_pressed.9.png` (223 B)
- `res/drawable-mdpi/notify_panel_notification_icon_bg.png` (98 B)
- `res/drawable-xhdpi/abc_ab_share_pack_mtrl_alpha.9.png` (280 B)
- `res/drawable-xhdpi/abc_btn_check_to_on_mtrl_000.png` (281 B)
- `res/drawable-xhdpi/abc_btn_check_to_on_mtrl_015.png` (432 B)
- `res/drawable-xhdpi/abc_btn_radio_to_on_mtrl_000.png` (651 B)
- `res/drawable-xhdpi/abc_btn_radio_to_on_mtrl_015.png` (785 B)
- `res/drawable-xhdpi/abc_btn_switch_to_on_mtrl_00001.9.png` (1 KB)
- `res/drawable-xhdpi/abc_btn_switch_to_on_mtrl_00012.9.png` (1 KB)
- `res/drawable-xhdpi/abc_cab_background_top_mtrl_alpha.9.png` (229 B)
- `res/drawable-xhdpi/abc_ic_commit_search_api_mtrl_alpha.png` (228 B)
- `res/drawable-xhdpi/abc_list_divider_mtrl_alpha.9.png` (167 B)
- `res/drawable-xhdpi/abc_list_focused_holo.9.png` (261 B)
- `res/drawable-xhdpi/abc_list_longpressed_holo.9.png` (214 B)
- `res/drawable-xhdpi/abc_list_pressed_holo_dark.9.png` (209 B)
- `res/drawable-xhdpi/abc_list_pressed_holo_light.9.png` (209 B)
- `res/drawable-xhdpi/abc_list_selector_disabled_holo_dark.9.png` (236 B)
- `res/drawable-xhdpi/abc_list_selector_disabled_holo_light.9.png` (235 B)
- `res/drawable-xhdpi/abc_menu_hardkey_panel_mtrl_mult.9.png` (966 B)
- `res/drawable-xhdpi/abc_popup_background_mtrl_mult.9.png` (1 KB)
- `res/drawable-xhdpi/abc_scrubber_control_off_mtrl_alpha.png` (267 B)
- `res/drawable-xhdpi/abc_scrubber_control_to_pressed_mtrl_000.png` (267 B)
- `res/drawable-xhdpi/abc_scrubber_control_to_pressed_mtrl_005.png` (391 B)
- `res/drawable-xhdpi/abc_scrubber_primary_mtrl_alpha.9.png` (208 B)
- `res/drawable-xhdpi/abc_scrubber_track_mtrl_alpha.9.png` (198 B)
- `res/drawable-xhdpi/abc_spinner_mtrl_am_alpha.9.png` (448 B)
- `res/drawable-xhdpi/abc_switch_track_mtrl_alpha.9.png` (618 B)
- `res/drawable-xhdpi/abc_tab_indicator_mtrl_alpha.9.png` (194 B)
- `res/drawable-xhdpi/abc_text_select_handle_left_mtrl.png` (335 B)
- `res/drawable-xhdpi/abc_text_select_handle_middle_mtrl.png` (585 B)
- `res/drawable-xhdpi/abc_text_select_handle_right_mtrl.png` (318 B)
- `res/drawable-xhdpi/abc_textfield_activated_mtrl_alpha.9.png` (189 B)
- `res/drawable-xhdpi/abc_textfield_default_mtrl_alpha.9.png` (187 B)
- `res/drawable-xhdpi/abc_textfield_search_activated_mtrl_alpha.9.png` (184 B)
- `res/drawable-xhdpi/abc_textfield_search_default_mtrl_alpha.9.png` (182 B)
- `res/drawable-xhdpi/common_full_open_on_phone.png` (489 B)
- `res/drawable-xhdpi/common_google_signin_btn_icon_dark_normal_background.9.png` (1 KB)
- `res/drawable-xhdpi/common_google_signin_btn_icon_light_normal_background.9.png` (776 B)
- `res/drawable-xhdpi/common_google_signin_btn_text_dark_normal_background.9.png` (1 KB)
- `res/drawable-xhdpi/common_google_signin_btn_text_light_normal_background.9.png` (808 B)
- `res/drawable-xhdpi/googleg_disabled_color_18.png` (516 B)
- `res/drawable-xhdpi/googleg_standard_color_18.png` (982 B)
- `res/drawable-xhdpi/notification_bg_low_normal.9.png` (221 B)
- `res/drawable-xhdpi/notification_bg_low_pressed.9.png` (252 B)
- `res/drawable-xhdpi/notification_bg_normal.9.png` (221 B)
- `res/drawable-xhdpi/notification_bg_normal_pressed.9.png` (247 B)
- `res/drawable-xhdpi/notify_panel_notification_icon_bg.png` (138 B)
- `res/drawable-xxhdpi/abc_ab_share_pack_mtrl_alpha.9.png` (286 B)
- `res/drawable-xxhdpi/abc_btn_check_to_on_mtrl_000.png` (307 B)
- `res/drawable-xxhdpi/abc_btn_check_to_on_mtrl_015.png` (593 B)
- `res/drawable-xxhdpi/abc_btn_radio_to_on_mtrl_000.png` (984 B)
- `res/drawable-xxhdpi/abc_btn_radio_to_on_mtrl_015.png` (1 KB)
- `res/drawable-xxhdpi/abc_btn_switch_to_on_mtrl_00001.9.png` (2 KB)
- `res/drawable-xxhdpi/abc_btn_switch_to_on_mtrl_00012.9.png` (2 KB)
- `res/drawable-xxhdpi/abc_cab_background_top_mtrl_alpha.9.png` (237 B)
- `res/drawable-xxhdpi/abc_ic_commit_search_api_mtrl_alpha.png` (224 B)
- `res/drawable-xxhdpi/abc_list_divider_mtrl_alpha.9.png` (171 B)
- `res/drawable-xxhdpi/abc_list_focused_holo.9.png` (257 B)
- `res/drawable-xxhdpi/abc_list_longpressed_holo.9.png` (221 B)
- `res/drawable-xxhdpi/abc_list_pressed_holo_dark.9.png` (212 B)
- `res/drawable-xxhdpi/abc_list_pressed_holo_light.9.png` (212 B)
- `res/drawable-xxhdpi/abc_list_selector_disabled_holo_dark.9.png` (260 B)
- `res/drawable-xxhdpi/abc_list_selector_disabled_holo_light.9.png` (258 B)
- `res/drawable-xxhdpi/abc_menu_hardkey_panel_mtrl_mult.9.png` (1 KB)
- `res/drawable-xxhdpi/abc_popup_background_mtrl_mult.9.png` (2 KB)
- `res/drawable-xxhdpi/abc_scrubber_control_off_mtrl_alpha.png` (322 B)
- `res/drawable-xxhdpi/abc_scrubber_control_to_pressed_mtrl_000.png` (403 B)
- `res/drawable-xxhdpi/abc_scrubber_control_to_pressed_mtrl_005.png` (595 B)
- `res/drawable-xxhdpi/abc_scrubber_primary_mtrl_alpha.9.png` (210 B)
- `res/drawable-xxhdpi/abc_scrubber_track_mtrl_alpha.9.png` (207 B)
- `res/drawable-xxhdpi/abc_spinner_mtrl_am_alpha.9.png` (524 B)
- `res/drawable-xxhdpi/abc_switch_track_mtrl_alpha.9.png` (851 B)
- `res/drawable-xxhdpi/abc_tab_indicator_mtrl_alpha.9.png` (204 B)
- `res/drawable-xxhdpi/abc_text_select_handle_left_mtrl.png` (420 B)
- `res/drawable-xxhdpi/abc_text_select_handle_middle_mtrl.png` (753 B)
- `res/drawable-xxhdpi/abc_text_select_handle_right_mtrl.png` (422 B)
- `res/drawable-xxhdpi/abc_textfield_activated_mtrl_alpha.9.png` (199 B)
- `res/drawable-xxhdpi/abc_textfield_default_mtrl_alpha.9.png` (200 B)
- `res/drawable-xxhdpi/abc_textfield_search_activated_mtrl_alpha.9.png` (187 B)
- `res/drawable-xxhdpi/abc_textfield_search_default_mtrl_alpha.9.png` (186 B)
- `res/drawable-xxhdpi/common_google_signin_btn_icon_dark_normal_background.9.png` (1 KB)
- `res/drawable-xxhdpi/common_google_signin_btn_icon_light_normal_background.9.png` (1 KB)
- `res/drawable-xxhdpi/common_google_signin_btn_text_dark_normal_background.9.png` (1 KB)
- `res/drawable-xxhdpi/common_google_signin_btn_text_light_normal_background.9.png` (1 KB)
- `res/drawable-xxhdpi/googleg_disabled_color_18.png` (727 B)
- `res/drawable-xxhdpi/googleg_standard_color_18.png` (1 KB)
- `res/drawable-xxxhdpi/abc_btn_check_to_on_mtrl_000.png` (275 B)
- `res/drawable-xxxhdpi/abc_btn_check_to_on_mtrl_015.png` (476 B)
- `res/drawable-xxxhdpi/abc_btn_radio_to_on_mtrl_000.png` (785 B)
- `res/drawable-xxxhdpi/abc_btn_radio_to_on_mtrl_015.png` (946 B)
- `res/drawable-xxxhdpi/abc_btn_switch_to_on_mtrl_00001.9.png` (2 KB)
- `res/drawable-xxxhdpi/abc_btn_switch_to_on_mtrl_00012.9.png` (2 KB)
- `res/drawable-xxxhdpi/abc_scrubber_control_to_pressed_mtrl_000.png` (415 B)
- `res/drawable-xxxhdpi/abc_scrubber_control_to_pressed_mtrl_005.png` (631 B)
- `res/drawable-xxxhdpi/abc_spinner_mtrl_am_alpha.9.png` (430 B)
- `res/drawable-xxxhdpi/abc_switch_track_mtrl_alpha.9.png` (813 B)
- `res/drawable-xxxhdpi/abc_tab_indicator_mtrl_alpha.9.png` (202 B)
- `res/drawable-xxxhdpi/abc_text_select_handle_left_mtrl.png` (513 B)
- `res/drawable-xxxhdpi/abc_text_select_handle_right_mtrl.png` (513 B)
- `res/drawable/unity_static_splash.png` (506 KB)
- `res/mipmap-hdpi/app_icon.png` (4 KB)
- `res/mipmap-hdpi/app_icon_round.png` (4 KB)
- `res/mipmap-ldpi/app_icon.png` (1 KB)
- `res/mipmap-ldpi/app_icon_round.png` (1 KB)
- `res/mipmap-mdpi/app_icon.png` (2 KB)
- `res/mipmap-mdpi/app_icon_round.png` (2 KB)
- `res/mipmap-xhdpi/app_icon.png` (5 KB)
- `res/mipmap-xhdpi/app_icon_round.png` (5 KB)
- `res/mipmap-xxhdpi/app_icon.png` (8 KB)
- `res/mipmap-xxhdpi/app_icon_round.png` (8 KB)
- `res/mipmap-xxxhdpi/app_icon.png` (11 KB)
- `res/mipmap-xxxhdpi/app_icon_round.png` (11 KB)
- `res/raw/keep_cronet_api.xml` (156 B)

## 8. COMPLETE APP PACKAGE & CLASS MAP
- **com.epicgames.mobile.eossdk** (33): BuildConfig, EOSAuthHandlerActivity, EOSCookies, EOSLog, EOSLogger, EOSOverlay, EOSOverlayBackground, EOSOverlayBrowser, EOSOverlayClosedButton, EOSOverlayId, EOSOverlayJavascriptInterface, EOSOverlayLoadingBar, EOSOverlayQueuedEvaluateJavascript, EOSOverlayWebChromeClient, EOSOverlayWebView, EOSOverlayWebViewClient, EOSOverlayWebViewClientDelegate, EOSOverlayWebviewDisplaySettings, EOSOverlayWidgetManager, EOSPreferences, EOSSDK, LaunchUrlResult, LoginState, EOSLog$Category, EOSLog$IncludeRedactHolder, EOSLog$Level, EOSLogger$1, EOSOverlay$BrowserStatus, EOSOverlayWebChromeClient$1, EOSSDK$1, EOSSDK$2, EOSSDK$3, EOSSDK$LocalWebViewClient
- **com.unity3d.ads** (14): BuildConfig, IUnityAdsInitializationListener, IUnityAdsLoadListener, IUnityAdsShowListener, IUnityAdsTokenListener, UnityAds, UnityAdsBaseOptions, UnityAdsLoadOptions, UnityAdsShowOptions, UnityAds$UnityAdsInitializationError, UnityAds$UnityAdsLoadError, UnityAds$UnityAdsShowCompletionState, UnityAds$UnityAdsShowError, UnityAds$load$1
- **com.unity3d.ads.adplayer** (138): AdPlayer, AdPlayerError, AdPlayerScope, AndroidEmbeddableWebViewAdPlayer, AndroidFullscreenWebViewAdPlayer, AndroidShowOptions, AndroidWebViewClient, AndroidWebViewContainer, CommonWebViewBridge, DisplayMessage, EmbeddableAdPlayer, ExposedFunction, ExposedFunctionLocation, FullScreenWebViewDisplay, FullscreenAdPlayer, GetAdAssetLoader, GetAdAssetLoaderKt, GetWebViewAssetLoaderKt, GetWebViewCacheAssetLoader, HandlerType, Invocation, LoadWebViewError, ShowOptions, WebViewAdPlayer, WebViewAdPlayerKt, WebViewBridge, WebViewContainer, AdPlayer$Companion, AdPlayer$DefaultImpls, AndroidEmbeddableWebViewAdPlayer$destroy$1, AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$1, AndroidEmbeddableWebViewAdPlayer$show$1, AndroidEmbeddableWebViewAdPlayer$show$2$1, AndroidEmbeddableWebViewAdPlayer$show$2$2$1, AndroidEmbeddableWebViewAdPlayer$show$3, AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1, AndroidFullscreenWebViewAdPlayer$Companion, AndroidFullscreenWebViewAdPlayer$destroy$1, AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1, AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1, AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2, AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1, AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2, AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2, AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1, AndroidFullscreenWebViewAdPlayer$show$2, AndroidFullscreenWebViewAdPlayer$show$3, AndroidFullscreenWebViewAdPlayer$show$5, AndroidFullscreenWebViewAdPlayer$show$6, AndroidWebViewClient$Companion, AndroidWebViewContainer$2, AndroidWebViewContainer$addJavascriptInterface$1, AndroidWebViewContainer$addJavascriptInterface$2, AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1, AndroidWebViewContainer$destroy$1, AndroidWebViewContainer$destroy$2, AndroidWebViewContainer$evaluateJavascript$1, AndroidWebViewContainer$evaluateJavascript$2, AndroidWebViewContainer$loadUrl$1, AndroidWebViewContainer$loadUrl$2, AndroidWebViewContainer$onRenderProcessGone$1, AndroidWebViewContainer$special$$inlined$filter$1, AndroidWebViewContainer$special$$inlined$filter$1$2, AndroidWebViewContainer$special$$inlined$filter$1$2$1, CommonWebViewBridge$1, CommonWebViewBridge$handleInvocation$1, CommonWebViewBridge$handleInvocation$1$1, CommonWebViewBridge$request$1, DisplayMessage$DisplayDestroyed, DisplayMessage$DisplayError, DisplayMessage$DisplayFinishRequest, DisplayMessage$DisplayReady, DisplayMessage$FocusChanged, DisplayMessage$VisibilityChanged, DisplayMessage$WebViewInstanceRequest, DisplayMessage$WebViewInstanceResponse, EmbeddableAdPlayer$DefaultImpls, FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1, FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2, FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1, FullScreenWebViewDisplay$listenToAdPlayerEvents$2, FullScreenWebViewDisplay$loadWebView$1, FullScreenWebViewDisplay$onCreate$1$1, FullScreenWebViewDisplay$onCreate$5, FullScreenWebViewDisplay$onDestroy$1, FullScreenWebViewDisplay$onPause$1, FullScreenWebViewDisplay$onResume$1, FullScreenWebViewDisplay$onWindowFocusChanged$1, FullscreenAdPlayer$DefaultImpls, Invocation$handle$2, Invocation$handle$3, WebViewAdPlayer$1, WebViewAdPlayer$2, WebViewAdPlayer$onAllowedPiiChange$2, WebViewAdPlayer$onBroadcastEvent$2, WebViewAdPlayer$onShowEvent$3, WebViewAdPlayer$requestShow$1, WebViewAdPlayer$sendActivityDestroyed$2, WebViewAdPlayer$sendEvent$1, WebViewAdPlayer$sendFocusChange$2, WebViewAdPlayer$sendMuteChange$2, WebViewAdPlayer$sendPrivacyFsmChange$2, WebViewAdPlayer$sendUserConsentChange$2, WebViewAdPlayer$sendVisibilityChange$2, WebViewAdPlayer$sendVolumeChange$2, WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1, WebViewAdPlayer$special$$inlined$filter$1, WebViewAdPlayer$special$$inlined$filter$1$2, WebViewAdPlayer$special$$inlined$filter$1$2$1, WebViewAdPlayer$special$$inlined$filter$2, WebViewAdPlayer$special$$inlined$filter$2$2, WebViewAdPlayer$special$$inlined$filter$2$2$1, WebViewAdPlayer$special$$inlined$filter$3, WebViewAdPlayer$special$$inlined$filter$3$2, WebViewAdPlayer$special$$inlined$filter$3$2$1, WebViewAdPlayer$special$$inlined$filter$4, WebViewAdPlayer$special$$inlined$filter$4$2, WebViewAdPlayer$special$$inlined$filter$4$2$1, WebViewAdPlayer$special$$inlined$filter$5, WebViewAdPlayer$special$$inlined$filter$5$2, WebViewAdPlayer$special$$inlined$filter$5$2$1, WebViewAdPlayer$special$$inlined$map$1, WebViewAdPlayer$special$$inlined$map$1$2, WebViewAdPlayer$special$$inlined$map$1$2$1, WebViewAdPlayer$special$$inlined$map$2, WebViewAdPlayer$special$$inlined$map$2$2, WebViewAdPlayer$special$$inlined$map$2$2$1, WebViewAdPlayer$special$$inlined$map$3, WebViewAdPlayer$special$$inlined$map$3$2, WebViewAdPlayer$special$$inlined$map$3$2$1, WebViewAdPlayer$special$$inlined$map$4, WebViewAdPlayer$special$$inlined$map$4$2, WebViewAdPlayer$special$$inlined$map$4$2$1, WebViewAdPlayer$special$$inlined$map$5, WebViewAdPlayer$special$$inlined$map$5$2, WebViewAdPlayer$special$$inlined$map$5$2$1, WebViewAdPlayer$storageEventCallback$1, WebViewAdPlayer$storageEventCallback$1$1
- **com.unity3d.ads.adplayer.model** (20): ErrorReason, LoadEvent, OnActivityDestroyedEvent, OnAllowedPiiChangeEvent, OnBroadcastEvent, OnFocusChangeEvent, OnMuteChangeEvent, OnPrivacyFsmChangeEvent, OnStorageEvent, OnUserConsentChangeEvent, OnVisibilityChangeEvent, OnVolumeChangeEvent, OnWebRequestComplete, OnWebRequestFailed, ShowStatus, WebViewBridgeInterface, WebViewClientError, WebViewEvent, LoadEvent$Completed, LoadEvent$Error
- **com.unity3d.ads.gatewayclient** (8): CommonGatewayClient, GatewayClient, RequestPolicy, CommonGatewayClient$Companion, CommonGatewayClient$executeRequest$1, CommonGatewayClient$executeWithRetry$1, CommonGatewayClient$request$2, GatewayClient$DefaultImpls
- **com.unity3d.ads.gl** (4): EglCore, EglSurfaceBase, OffscreenSurface, EglCore$Companion
- **com.unity3d.ads.injection** (3): EntryKey, Factory, Registry
- **com.unity3d.ads.metadata** (4): InAppPurchaseMetaData, MediationMetaData, MetaData, PlayerMetaData
- **com.unity3d.player** (128): A, A0, AudioVolumeHandler, B, B0, BuildConfig, C, C0, Camera2Wrapper, D, D0, E, E0, E0-IA, F, F0, G, G0, GoogleARCoreApi, H, H0, H0-IA, HFPStatus, I, I0, I0-IA, IAssetPackManagerDownloadStatusCallback, IAssetPackManagerMobileDataConfirmationCallback, IAssetPackManagerStatusQueryCallback, IPermissionRequestCallbacks, IUnityPlayerLifecycleEvents, J, J0, K, K0, L, L0, M, M0, MultiWindowSupport, N, N0, NativeLoader, NetworkConnectivity, NetworkConnectivityNougat, O, O0, OrientationLockListener, P, P0, PermissionFragment, PlatformSupport, PlayAssetDeliveryUnityWrapper, Q, Q0, R0, ReflectionHelper, S, S0, SoftInputProvider, T, T0, U, U0, UnityCoreAssetPacksStatusCallbacks, UnityPermissions, UnityPlayer, UnityPlayerActivity, V, W, X, Y, Z, a, a0, b, b0, c, c0, d, d0, e, e0, f, f0, g, g0, h, h0, i, i0, j, j0, k, k0, l, l0, m, m0, n, n0, o, o0, p, p0, q, q0, r, r0, s, s0, t, t0, u, u0, v, v0, w, w0, x, x0, y, y0, z, z0, HFPStatus$1, UnityPermissions$ModalWaitForPermissionResponse, UnityPlayer$SynchronizationTimeout
- **com.unity3d.player.a** (5): a, b, c, d, e
- **com.yasirkula.unity** (14): NativeShare, NativeShareBroadcastListener, NativeShareContentProvider, NativeShareCustomShareDialog, NativeShareCustomShareDialogActivity, NativeShareFragment, NativeShareResultReceiver, NativeShareContentProvider$PathStrategy, NativeShareContentProvider$SimplePathStrategy, NativeShareCustomShareDialog$1, NativeShareCustomShareDialog$2, NativeShareCustomShareDialog$3, NativeShareCustomShareDialog$CustomShareDialogAdapter, NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder
- **epic.org.flappybird** (1): BuildConfig
- **com.unity3d.ads.core.configuration** (4): AlternativeFlowReader, GameServerIdReader, MetadataReader, GameServerIdReader$Companion
- **com.unity3d.ads.core.data.datasource** (57): AnalyticsDataSource, AndroidAnalyticsDataSource, AndroidByteStringDataSource, AndroidDeveloperConsentDataSource, AndroidDynamicDeviceInfoDataSource, AndroidKnownStore, AndroidLegacyConfigStoreDataSource, AndroidLegacyUserConsentDataSource, AndroidLifecycleDataSource, AndroidLocalCacheDataSource, AndroidMediationDataSource, AndroidPrivacyDeviceInfoDataSource, AndroidRemoteCacheDataSource, AndroidStaticDeviceInfoDataSource, AndroidStoreDataSource, AndroidTcfDataSource, ByteStringDataSource, CacheDataSource, DeveloperConsentDataSource, DynamicDeviceInfoDataSource, FetchGLInfoDataMigration, ForcefulPreservingByteStringPreferenceMigration, GetByteStringData, LegacyUserConsentDataSource, LifecycleDataSource, MediationDataSource, PreservingByteStringPreferenceMigration, PrivacyDeviceInfoDataSource, StaticDeviceInfoDataSource, StoreDataSource, TcfDataSource, UniversalRequestDataSource, VolumeSettingsChange, WebviewConfigurationDataSource, AndroidByteStringDataSource$get$2, AndroidByteStringDataSource$set$2, AndroidDynamicDeviceInfoDataSource$Companion, AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1, AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$1, AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1, AndroidLegacyConfigStoreDataSource$Companion, AndroidLifecycleDataSource$registerAppLifecycle$1, AndroidMediationDataSource$Companion, AndroidRemoteCacheDataSource$getFile$1, AndroidStaticDeviceInfoDataSource$Companion, AndroidStaticDeviceInfoDataSource$fetch$1, AndroidStaticDeviceInfoDataSource$getGPUModel$1, AndroidTcfDataSource$Companion, CacheDataSource$DefaultImpls, PrivacyDeviceInfoDataSource$DefaultImpls, UniversalRequestDataSource$get$2, UniversalRequestDataSource$remove$2, UniversalRequestDataSource$set$2, VolumeSettingsChange$MuteChange, VolumeSettingsChange$VolumeChange, WebviewConfigurationDataSource$get$2, WebviewConfigurationDataSource$set$2
- **com.unity3d.ads.core.data.manager** (14): AndroidOmidManager, AndroidSDKPropertiesManager, AndroidSDKPropertiesManagerKt, AndroidStorageManager, AndroidStorageManagerKt, OmidManager, SDKPropertiesManager, StorageManager, TransactionEventManager, AndroidStorageManager$Companion, TransactionEventManager$Companion, TransactionEventManager$invoke$1, TransactionEventManager$invoke$1$1$1, TransactionEventManager$onPurchasesReceived$1
- **com.unity3d.ads.core.data.model** (40): AdData, AdDataRefreshToken, AdObject, ByteStringSerializer, CacheError, CacheResult, CacheSource, CachedFile, ImpressionConfig, InitializationState, Listeners, LoadResult, OMData, OMResult, OmidOptions, OperationType, SessionChange, ShowEvent, StorageType, TokenCounters, UnityAdsShowResult, UniversalRequestStoreSerializer, WebViewConfiguration, WebViewConfigurationStoreSerializer, CacheResult$Failure, CacheResult$Success, Listeners$DefaultImpls, LoadResult$Companion, LoadResult$Failure, LoadResult$Success, OMResult$Failure, OMResult$Success, SessionChange$PrivacyFsmChange, SessionChange$UserConsentChange, ShowEvent$CancelTimeout, ShowEvent$Clicked, ShowEvent$Completed, ShowEvent$Error, ShowEvent$LeftApplication, ShowEvent$Started
- **com.unity3d.ads.core.data.model.exception** (8): ExposureException, GatewayException, InitializationException, LoadException, TransactionException, UnityAdsNetworkException, GatewayException$Companion, InitializationException$Companion
- **com.unity3d.ads.core.data.repository** (55): AdRepository, AndroidAdRepository, AndroidCacheRepository, AndroidCampaignRepository, AndroidDeveloperConsentRepository, AndroidDeviceInfoRepository, AndroidDiagnosticEventRepository, AndroidLegacyUserConsentRepository, AndroidMediationRepository, AndroidOpenMeasurementRepository, AndroidSessionRepository, AndroidTcfRepository, AndroidTransactionEventRepository, CacheRepository, CampaignRepository, DeveloperConsentRepository, DeviceInfoRepository, DiagnosticEventRepository, LegacyUserConsentRepository, MediationRepository, OpenMeasurementRepository, OperativeEventRepository, SessionRepository, TcfRepository, TransactionEventRepository, AndroidCacheRepository$clearCache$2, AndroidCacheRepository$getCacheSize$2, AndroidCacheRepository$getFile$2, AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1, AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1, AndroidDeviceInfoRepository$getAuidByteString$1, AndroidDiagnosticEventRepository$configure$1, AndroidDiagnosticEventRepository$flush$events$2, AndroidDiagnosticEventRepository$flush$events$3, AndroidDiagnosticEventRepository$flush$events$4, AndroidMediationRepository$mediationProvider$1, AndroidOpenMeasurementRepository$activateOM$2, AndroidOpenMeasurementRepository$finishSession$2, AndroidOpenMeasurementRepository$impressionOccurred$2, AndroidOpenMeasurementRepository$startSession$2, AndroidSessionRepository$1, AndroidSessionRepository$getGatewayCache$1, AndroidSessionRepository$getPrivacy$1, AndroidSessionRepository$getPrivacyFsm$1, AndroidSessionRepository$nativeConfiguration$1, AndroidSessionRepository$persistedNativeConfiguration$1, AndroidSessionRepository$setPrivacy$1, AndroidSessionRepository$setPrivacyFsm$1, AndroidSessionRepository$special$$inlined$filter$1, AndroidSessionRepository$special$$inlined$filter$1$2, AndroidSessionRepository$special$$inlined$filter$1$2$1, AndroidSessionRepository$special$$inlined$map$1, AndroidSessionRepository$special$$inlined$map$1$2, AndroidSessionRepository$special$$inlined$map$1$2$1, CacheRepository$DefaultImpls
- **com.unity3d.ads.core.domain** (226): AndroidBuildHeaderBiddingToken, AndroidExecuteAdViewerRequest, AndroidGenerateByteStringId, AndroidGetAdDataRefreshRequest, AndroidGetAdPlayerConfigRequest, AndroidGetAdPlayerContext, AndroidGetAdRequest, AndroidGetAdRequestPolicy, AndroidGetClientInfo, AndroidGetInitializationCompletedRequest, AndroidGetInitializationData, AndroidGetInitializationRequest, AndroidGetInitializationRequestPayload, AndroidGetLimitedSessionToken, AndroidGetOpenGLRendererInfo, AndroidGetSharedDataTimestamps, AndroidGetUniversalRequestForPayLoad, AndroidGetUniversalRequestSharedData, AndroidGetWebViewContainerUseCase, AndroidHandleGatewayAdResponse, AndroidHandleGatewayInitializationResponse, AndroidHandleGatewayUniversalResponse, AndroidHandleOpenUrl, AndroidHttpClientProvider, AndroidInitializeBoldSDK, AndroidLoad, AndroidRefresh, AndroidRemoveUrlQuery, AndroidSendDiagnosticEvent, AndroidSendWebViewClientErrorDiagnostics, AndroidShow, AndroidTriggerInitializationCompletedRequest, AwaitInitialization, BuildHeaderBiddingToken, CacheFile, ClearCache, CommonAwaitInitialization, CommonCacheFile, CommonClearCache, CommonCreateFile, CommonGetAdObject, CommonGetAdPlayer, CommonGetCacheDirectory, CommonGetFileExtensionFromUrl, CommonGetHeaderBiddingToken, CommonGetInitializationState, CommonGetIsFileCache, CommonGetWebViewBridgeUseCase, CommonInitAwaitingGetHeaderBiddingToken, CommonSetInitializationState, CreateFile, ExecuteAdViewerRequest, GetAdDataRefreshRequest, GetAdObject, GetAdPlayer, GetAdPlayerConfigRequest, GetAdRequest, GetAsyncHeaderBiddingToken, GetByteStringId, GetCacheDirectory, GetCachedAsset, GetClientInfo, GetFileExtensionFromUrl, GetHeaderBiddingToken, GetInitRequestPolicy, GetInitializationCompletedRequest, GetInitializationData, GetInitializationRequest, GetInitializationRequestPayload, GetInitializationState, GetIsFileCache, GetLatestWebViewConfiguration, GetLimitedSessionToken, GetOpenGLRendererInfo, GetOperativeEventRequestPolicy, GetOtherRequestPolicy, GetPrivacyUpdateRequest, GetRequestPolicy, GetSharedDataTimestamps, GetUniversalRequestForPayLoad, GetUniversalRequestSharedData, GetWebViewBridgeUseCase, GetWebViewContainerUseCase, HandleGatewayAdResponse, HandleGatewayInitializationResponse, HandleGatewayUniversalResponse, HandleInvocationsFromAdViewer, HandleOpenUrl, HttpClientProvider, InitializeBoldSDK, LegacyLoadUseCase, LegacyShowUseCase, Load, Refresh, RemoveUrlQuery, SendDiagnosticEvent, SendPrivacyUpdateRequest, SendWebViewClientErrorDiagnostics, SetInitializationState, Show, TriggerInitializationCompletedRequest, TriggerInitializeListener, AndroidBuildHeaderBiddingToken$invoke$1, AndroidExecuteAdViewerRequest$invoke$2, AndroidGetAdDataRefreshRequest$invoke$1, AndroidGetAdPlayerContext$Companion, AndroidGetAdPlayerContext$invoke$1, AndroidGetAdRequest$invoke$1, AndroidGetInitializationCompletedRequest$invoke$1, AndroidGetInitializationData$invoke$1, AndroidGetInitializationRequest$invoke$1, AndroidGetInitializationRequestPayload$invoke$1, AndroidGetLimitedSessionToken$invoke$1, AndroidGetUniversalRequestForPayLoad$invoke$1, AndroidGetUniversalRequestSharedData$invoke$1, AndroidGetWebViewContainerUseCase$invoke$1, AndroidGetWebViewContainerUseCase$invoke$webview$1, AndroidHandleGatewayAdResponse$cleanup$1, AndroidHandleGatewayAdResponse$invoke$1, AndroidHandleGatewayAdResponse$invoke$2, AndroidHandleGatewayAdResponse$invoke$3, AndroidHandleGatewayAdResponse$invoke$4, AndroidHandleGatewayAdResponse$invoke$5, AndroidHandleGatewayAdResponse$invoke$6, AndroidHandleGatewayInitializationResponse$invoke$2, AndroidHandleGatewayUniversalResponse$invoke$1, AndroidHttpClientProvider$buildNetworkClient$2$1, AndroidHttpClientProvider$invoke$1, AndroidHttpClientProvider$invoke$client$1, AndroidHttpClientProvider$invoke$config$1, AndroidInitializeBoldSDK$Companion, AndroidInitializeBoldSDK$initializationSuccess$1, AndroidInitializeBoldSDK$invoke$2, AndroidInitializeBoldSDK$invoke$2$1, AndroidLoad$invoke$2, AndroidRefresh$invoke$1, AndroidRefresh$invoke$2, AndroidShow$invoke$1, AndroidShow$invoke$1$2, AndroidShow$invoke$1$3, AndroidShow$invoke$1$4, AndroidShow$invoke$1$5, AndroidTriggerInitializationCompletedRequest$invoke$1, AwaitInitialization$DefaultImpls, CommonAwaitInitialization$invoke$2, CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1, CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2, CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1, CommonCacheFile$invoke$1, CommonClearCache$invoke$1, CommonGetHeaderBiddingToken$Companion, CommonGetHeaderBiddingToken$invoke$1, CommonGetIsFileCache$invoke$1, CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1, CommonInitAwaitingGetHeaderBiddingToken$invoke$1, CommonInitAwaitingGetHeaderBiddingToken$invoke$2, GetAdRequest$DefaultImpls, GetLatestWebViewConfiguration$invoke$1, HandleInvocationsFromAdViewer$Companion, HandleInvocationsFromAdViewer$invoke$2, HandleInvocationsFromAdViewer$invoke$3, HandleInvocationsFromAdViewer$invoke$3$1, HandleInvocationsFromAdViewer$invoke$definition$1, HandleInvocationsFromAdViewer$invoke$definition$10, HandleInvocationsFromAdViewer$invoke$definition$11, HandleInvocationsFromAdViewer$invoke$definition$12, HandleInvocationsFromAdViewer$invoke$definition$13, HandleInvocationsFromAdViewer$invoke$definition$14, HandleInvocationsFromAdViewer$invoke$definition$15, HandleInvocationsFromAdViewer$invoke$definition$16, HandleInvocationsFromAdViewer$invoke$definition$17, HandleInvocationsFromAdViewer$invoke$definition$18, HandleInvocationsFromAdViewer$invoke$definition$19, HandleInvocationsFromAdViewer$invoke$definition$2, HandleInvocationsFromAdViewer$invoke$definition$20, HandleInvocationsFromAdViewer$invoke$definition$21, HandleInvocationsFromAdViewer$invoke$definition$22, HandleInvocationsFromAdViewer$invoke$definition$23, HandleInvocationsFromAdViewer$invoke$definition$24, HandleInvocationsFromAdViewer$invoke$definition$25, HandleInvocationsFromAdViewer$invoke$definition$26, HandleInvocationsFromAdViewer$invoke$definition$27, HandleInvocationsFromAdViewer$invoke$definition$28, HandleInvocationsFromAdViewer$invoke$definition$29, HandleInvocationsFromAdViewer$invoke$definition$3, HandleInvocationsFromAdViewer$invoke$definition$30, HandleInvocationsFromAdViewer$invoke$definition$31, HandleInvocationsFromAdViewer$invoke$definition$32, HandleInvocationsFromAdViewer$invoke$definition$33, HandleInvocationsFromAdViewer$invoke$definition$34, HandleInvocationsFromAdViewer$invoke$definition$35, HandleInvocationsFromAdViewer$invoke$definition$36, HandleInvocationsFromAdViewer$invoke$definition$37, HandleInvocationsFromAdViewer$invoke$definition$38, HandleInvocationsFromAdViewer$invoke$definition$39, HandleInvocationsFromAdViewer$invoke$definition$4, HandleInvocationsFromAdViewer$invoke$definition$40, HandleInvocationsFromAdViewer$invoke$definition$5, HandleInvocationsFromAdViewer$invoke$definition$6, HandleInvocationsFromAdViewer$invoke$definition$7, HandleInvocationsFromAdViewer$invoke$definition$8, HandleInvocationsFromAdViewer$invoke$definition$9, LegacyLoadUseCase$Companion, LegacyLoadUseCase$invoke$1, LegacyLoadUseCase$invoke$loadResult$1, LegacyLoadUseCase$loadFailure$2, LegacyLoadUseCase$loadSuccess$2, LegacyShowUseCase$Companion, LegacyShowUseCase$getTmpAdObject$1, LegacyShowUseCase$invoke$1, LegacyShowUseCase$invoke$2, LegacyShowUseCase$invoke$3, LegacyShowUseCase$invoke$4, LegacyShowUseCase$invoke$4$emit$1, LegacyShowUseCase$showClicked$2, LegacyShowUseCase$showCompleted$2, LegacyShowUseCase$showError$1, LegacyShowUseCase$showError$1$1, LegacyShowUseCase$showStart$1, LegacyShowUseCase$showStarted$2, Load$DefaultImpls, SendDiagnosticEvent$Companion, SendDiagnosticEvent$DefaultImpls, SendPrivacyUpdateRequest$invoke$1, TriggerInitializeListener$error$1, TriggerInitializeListener$success$1
- **com.unity3d.ads.core.domain.attribution** (5): AndroidAttribution, AndroidAttribution$isAvailable$2$1, AndroidAttribution$measurementManager$2, AndroidAttribution$registerClick$2$1, AndroidAttribution$registerView$2$1
- **com.unity3d.ads.core.domain.events** (26): AndroidGetTransactionData, AndroidHandleGatewayEventResponse, CommonGetTransactionRequest, DiagnosticEventObserver, EventObservers, GetDiagnosticEventBatchRequest, GetDiagnosticEventRequest, GetOperativeEventApi, GetOperativeEventRequest, GetTransactionData, GetTransactionRequest, HandleGatewayEventResponse, OperativeEventObserver, TransactionEventObserver, UniversalRequestEventSender, CommonGetTransactionRequest$invoke$1, DiagnosticEventObserver$invoke$2, DiagnosticEventObserver$invoke$2$2, EventObservers$invoke$1, GetOperativeEventApi$invoke$1, GetOperativeEventRequest$invoke$1, OperativeEventObserver$invoke$2, OperativeEventObserver$invoke$2$2, TransactionEventObserver$invoke$2, TransactionEventObserver$invoke$2$2, UniversalRequestEventSender$invoke$1
- **com.unity3d.ads.core.domain.exposure** (56): CommonAdViewerExposedFunctionsKt, CommonAdViewerExposedFunctionsKt$attributionRegisterClick$1, CommonAdViewerExposedFunctionsKt$attributionRegisterView$1, CommonAdViewerExposedFunctionsKt$clearStorage$1, CommonAdViewerExposedFunctionsKt$deleteStorage$1, CommonAdViewerExposedFunctionsKt$download$1, CommonAdViewerExposedFunctionsKt$download$1$invoke$1, CommonAdViewerExposedFunctionsKt$getAdContext$1, CommonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1, CommonAdViewerExposedFunctionsKt$getAllowedPii$1, CommonAdViewerExposedFunctionsKt$getConnectionType$1, CommonAdViewerExposedFunctionsKt$getDeviceMaxVolume$1, CommonAdViewerExposedFunctionsKt$getDeviceVolume$1, CommonAdViewerExposedFunctionsKt$getKeysStorage$1, CommonAdViewerExposedFunctionsKt$getPrivacy$1, CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1, CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1, CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1, CommonAdViewerExposedFunctionsKt$getScreenHeight$1, CommonAdViewerExposedFunctionsKt$getScreenWidth$1, CommonAdViewerExposedFunctionsKt$getSessionToken$1, CommonAdViewerExposedFunctionsKt$getStorage$1, CommonAdViewerExposedFunctionsKt$hbTokenIncrementStarts$1, CommonAdViewerExposedFunctionsKt$hbTokenIncrementWins$1, CommonAdViewerExposedFunctionsKt$hbTokenReset$1, CommonAdViewerExposedFunctionsKt$incrementBannerImpressionCount$1, CommonAdViewerExposedFunctionsKt$isAttributionAvailable$1, CommonAdViewerExposedFunctionsKt$isFileCached$1, CommonAdViewerExposedFunctionsKt$markCampaignStateShown$1, CommonAdViewerExposedFunctionsKt$omFinishSession$1, CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1, CommonAdViewerExposedFunctionsKt$omGetData$1, CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1, CommonAdViewerExposedFunctionsKt$omImpression$1, CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1, CommonAdViewerExposedFunctionsKt$omStartSession$1, CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1, CommonAdViewerExposedFunctionsKt$openUrl$1, CommonAdViewerExposedFunctionsKt$readStorage$1, CommonAdViewerExposedFunctionsKt$refreshAdData$1, CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1, CommonAdViewerExposedFunctionsKt$sendDiagnosticEvent$1, CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1, CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1, CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1, CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1, CommonAdViewerExposedFunctionsKt$setAllowedPii$1, CommonAdViewerExposedFunctionsKt$setAllowedPii$1$1$1$2, CommonAdViewerExposedFunctionsKt$setAllowedPii$1$1$1$4, CommonAdViewerExposedFunctionsKt$setPrivacy$1, CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1, CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1, CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1, CommonAdViewerExposedFunctionsKt$setStorage$1, CommonAdViewerExposedFunctionsKt$updateTrackingToken$1, CommonAdViewerExposedFunctionsKt$writeStorage$1
- **com.unity3d.ads.core.domain.om** (18): AndroidInitializeOMSDK, AndroidOmFinishSession, AndroidOmImpressionOccurred, AndroidOmInteraction, AndroidOmStartSession, CommonGetOmData, CommonIsOMActivated, GetOmData, InitializeOMSDK, IsOMActivated, OmFinishSession, OmImpressionOccurred, OmInteraction, AndroidInitializeOMSDK$invoke$1, AndroidOmFinishSession$invoke$1, AndroidOmImpressionOccurred$invoke$1, AndroidOmStartSession$invoke$1, OmInteraction$Companion
- **com.unity3d.ads.core.domain.privacy** (3): DeveloperConsentFlattenerRulesUseCase, FlattenerRulesUseCase, LegacyUserConsentFlattenerRulesUseCase
- **com.unity3d.ads.core.domain.work** (14): BackgroundWorker, DiagnosticEventJob, DiagnosticEventRequestWorkModifier, OperativeEventJob, UniversalRequestJob, UniversalRequestWorkerData, DiagnosticEventJob$doWork$1, DiagnosticEventJob$special$$inlined$inject$default$1, DiagnosticEventJob$special$$inlined$inject$default$2, OperativeEventJob$special$$inlined$inject$default$1, UniversalRequestJob$doWork$1, UniversalRequestJob$special$$inlined$inject$default$1, UniversalRequestJob$special$$inlined$inject$default$2, UniversalRequestWorkerData$Companion
- **com.unity3d.ads.core.extensions** (19): ContextExtensionsKt, ExceptionExtensionsKt, FileExtensionsKt, FlowExtensionsKt, IntExtensionKt, JSONArrayExtensionsKt, JSONObjectExtensionsKt, JsonSerializableExtensionsKt, ProtobufExtensionsKt, ShowStatusExtensionsKt, StringExtensionsKt, TimeExtensionsKt, TimestampExtensionsKt, TransactionStateExtensionsKt, ViewExtensionsKt, FlowExtensionsKt$timeoutAfter$1, FlowExtensionsKt$timeoutAfter$1$1, FlowExtensionsKt$timeoutAfter$1$1$1, FlowExtensionsKt$timeoutAfter$1$2
- **com.unity3d.ads.core.utils** (4): CommonCoroutineTimer, ContinuationFromCallback, CoroutineTimer, CommonCoroutineTimer$start$1
- **com.unity3d.services.analytics.core.api** (2): Analytics, Analytics$1
- **com.unity3d.services.analytics.core.configuration** (1): AnalyticsModuleConfiguration
- **com.unity3d.services.core.api** (25): Broadcast, Cache, ClassDetection, Connectivity, DeviceInfo, DownloadLatestWebViewStatus, Intent, Lifecycle, Permissions, PermissionsError, Preferences, Request, Resolve, Sdk, SensorInfo, Storage, Cache$1, DeviceInfo$1, DeviceInfo$StorageType, Intent$IntentError, Intent$IntentException, Request$1, Request$2, Request$3, Resolve$1
- **com.unity3d.services.core.broadcast** (4): BroadcastError, BroadcastEvent, BroadcastEventReceiver, BroadcastMonitor
- **com.unity3d.services.core.cache** (8): CacheDirectory, CacheDirectoryType, CacheError, CacheEvent, CacheEventSender, CacheThread, CacheThreadHandler, CacheThreadHandler$1
- **com.unity3d.services.core.configuration** (64): AdsSdkInitializer, Configuration, ConfigurationFailure, ConfigurationLoader, ConfigurationReader, ConfigurationRequestFactory, CoreModuleConfiguration, EnvironmentCheck, ErrorState, ExperimentAppliedRule, ExperimentObject, ExperimentObjects, Experiments, ExperimentsBase, ExperimentsReader, IConfigurationLoader, IConfigurationLoaderListener, IExperiments, IInitializationListener, IInitializationNotificationCenter, IInitializeEventsMetricSender, IModuleConfiguration, IPrivacyConfigurationListener, InitRequestType, InitializationNotificationCenter, InitializeEventsMetricSender, InitializeThread, PrivacyCallError, PrivacyConfig, PrivacyConfigStatus, PrivacyConfigStorage, PrivacyConfigurationLoader, CoreModuleConfiguration$1, CoreModuleConfiguration$2, CoreModuleConfiguration$3, InitializationNotificationCenter$1, InitializationNotificationCenter$2, InitializeEventsMetricSender$1, InitializeThread$1, InitializeThread$2, InitializeThread$InitializeState, InitializeThread$InitializeStateCheckForCachedWebViewUpdate, InitializeThread$InitializeStateCheckForUpdatedWebView, InitializeThread$InitializeStateCleanCache, InitializeThread$InitializeStateCleanCacheIgnoreError, InitializeThread$InitializeStateComplete, InitializeThread$InitializeStateConfig, InitializeThread$InitializeStateConfig$1, InitializeThread$InitializeStateCreate, InitializeThread$InitializeStateCreateWithRemote, InitializeThread$InitializeStateDownloadWebView, InitializeThread$InitializeStateError, InitializeThread$InitializeStateForceReset, InitializeThread$InitializeStateInitModules, InitializeThread$InitializeStateLoadCache, InitializeThread$InitializeStateLoadCacheConfigAndWebView, InitializeThread$InitializeStateLoadConfigFile, InitializeThread$InitializeStateLoadWeb, InitializeThread$InitializeStateNetworkError, InitializeThread$InitializeStateReset, InitializeThread$InitializeStateReset$1, InitializeThread$InitializeStateRetry, InitializeThread$InitializeStateUpdateCache, PrivacyConfigurationLoader$1
- **com.unity3d.services.core.connectivity** (6): ConnectivityChangeReceiver, ConnectivityEvent, ConnectivityMonitor, ConnectivityNetworkCallback, IConnectivityListener, ConnectivityMonitor$1
- **com.unity3d.services.core.device** (32): AdvertisingId, Device, DeviceError, DeviceInfoEvent, MimeTypes, OpenAdvertisingId, Storage, StorageError, StorageEvent, StorageEventInfo, StorageManager, TokenType, VolumeChange, VolumeChangeContentObserver, VolumeChangeListener, VolumeChangeMonitor, AdvertisingId$1, AdvertisingId$GoogleAdvertisingInfo, AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder, AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder$GoogleAdvertisingInfoImplementation, AdvertisingId$GoogleAdvertisingServiceConnection, Device$1, Device$MemoryInfoType, OpenAdvertisingId$1, OpenAdvertisingId$HWAdvertisingInfo, OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder, OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder$HWAdvertisingInfoImplementation, OpenAdvertisingId$HWAdvertisingServiceConnection, Storage$Companion, StorageManager$StorageType, VolumeChangeContentObserver$startObserving$1, VolumeChangeMonitor$registerVolumeChangeListener$listener$1
- **com.unity3d.services.core.device.reader** (25): DeviceInfoDataFactory, DeviceInfoReaderCompressor, DeviceInfoReaderCompressorWithMetrics, DeviceInfoReaderExtended, DeviceInfoReaderFilterProvider, DeviceInfoReaderWithAuid, DeviceInfoReaderWithBehavioralFlag, DeviceInfoReaderWithExtras, DeviceInfoReaderWithFilter, DeviceInfoReaderWithLifecycle, DeviceInfoReaderWithMetrics, DeviceInfoReaderWithPrivacy, DeviceInfoReaderWithRequestType, DeviceInfoReaderWithSessionId, DeviceInfoReaderWithStorageInfo, GameSessionIdReader, HdrInfoReader, IDeviceInfoDataCompressor, IDeviceInfoDataContainer, IDeviceInfoReader, IGameSessionIdReader, IHdrInfoReader, JsonStorageKeyNames, MinimalDeviceInfoReader, DeviceInfoDataFactory$1
- **com.unity3d.services.core.device.reader.builder** (3): DeviceInfoReaderBuilder, DeviceInfoReaderBuilderWithExtras, DeviceInfoReaderPrivacyBuilder
- **com.unity3d.services.core.device.reader.pii** (6): NonBehavioralFlag, NonBehavioralFlagReader, PiiDataProvider, PiiPrivacyMode, PiiTrackingStatusReader, NonBehavioralFlag$Companion
- **com.unity3d.services.core.di** (196): Factory, IServiceComponent, IServiceComponentKt, IServiceProvider, IServicesRegistry, ServiceFactoryKt, ServiceKey, ServiceProvider, ServicesRegistry, ServicesRegistryKt, UnityAdsModule, IServiceComponent$DefaultImpls, IServiceComponentKt$inject$1, IServicesRegistry$DefaultImpls, ServiceProvider$initialize$1, ServiceProvider$initialize$1$1, ServiceProvider$initialize$1$10, ServiceProvider$initialize$1$100, ServiceProvider$initialize$1$101, ServiceProvider$initialize$1$102, ServiceProvider$initialize$1$103, ServiceProvider$initialize$1$104, ServiceProvider$initialize$1$105, ServiceProvider$initialize$1$106, ServiceProvider$initialize$1$107, ServiceProvider$initialize$1$108, ServiceProvider$initialize$1$109, ServiceProvider$initialize$1$11, ServiceProvider$initialize$1$110, ServiceProvider$initialize$1$111, ServiceProvider$initialize$1$112, ServiceProvider$initialize$1$113, ServiceProvider$initialize$1$114, ServiceProvider$initialize$1$115, ServiceProvider$initialize$1$116, ServiceProvider$initialize$1$117, ServiceProvider$initialize$1$118, ServiceProvider$initialize$1$119, ServiceProvider$initialize$1$12, ServiceProvider$initialize$1$120, ServiceProvider$initialize$1$121, ServiceProvider$initialize$1$122, ServiceProvider$initialize$1$123, ServiceProvider$initialize$1$124, ServiceProvider$initialize$1$125, ServiceProvider$initialize$1$126, ServiceProvider$initialize$1$127, ServiceProvider$initialize$1$128, ServiceProvider$initialize$1$129, ServiceProvider$initialize$1$13, ServiceProvider$initialize$1$130, ServiceProvider$initialize$1$131, ServiceProvider$initialize$1$132, ServiceProvider$initialize$1$133, ServiceProvider$initialize$1$134, ServiceProvider$initialize$1$135, ServiceProvider$initialize$1$136, ServiceProvider$initialize$1$137, ServiceProvider$initialize$1$138, ServiceProvider$initialize$1$139, ServiceProvider$initialize$1$14, ServiceProvider$initialize$1$140, ServiceProvider$initialize$1$141, ServiceProvider$initialize$1$142, ServiceProvider$initialize$1$143, ServiceProvider$initialize$1$144, ServiceProvider$initialize$1$145, ServiceProvider$initialize$1$146, ServiceProvider$initialize$1$147, ServiceProvider$initialize$1$148, ServiceProvider$initialize$1$149, ServiceProvider$initialize$1$15, ServiceProvider$initialize$1$150, ServiceProvider$initialize$1$151, ServiceProvider$initialize$1$152, ServiceProvider$initialize$1$153, ServiceProvider$initialize$1$154, ServiceProvider$initialize$1$155, ServiceProvider$initialize$1$156, ServiceProvider$initialize$1$157, ServiceProvider$initialize$1$158, ServiceProvider$initialize$1$159, ServiceProvider$initialize$1$16, ServiceProvider$initialize$1$160, ServiceProvider$initialize$1$161, ServiceProvider$initialize$1$162, ServiceProvider$initialize$1$163, ServiceProvider$initialize$1$164, ServiceProvider$initialize$1$165, ServiceProvider$initialize$1$166, ServiceProvider$initialize$1$167, ServiceProvider$initialize$1$168, ServiceProvider$initialize$1$169, ServiceProvider$initialize$1$17, ServiceProvider$initialize$1$170, ServiceProvider$initialize$1$171, ServiceProvider$initialize$1$172, ServiceProvider$initialize$1$173, ServiceProvider$initialize$1$174, ServiceProvider$initialize$1$175, ServiceProvider$initialize$1$18, ServiceProvider$initialize$1$19, ServiceProvider$initialize$1$2, ServiceProvider$initialize$1$20, ServiceProvider$initialize$1$21, ServiceProvider$initialize$1$22, ServiceProvider$initialize$1$23, ServiceProvider$initialize$1$24, ServiceProvider$initialize$1$25, ServiceProvider$initialize$1$26, ServiceProvider$initialize$1$27, ServiceProvider$initialize$1$28, ServiceProvider$initialize$1$29, ServiceProvider$initialize$1$3, ServiceProvider$initialize$1$30, ServiceProvider$initialize$1$31, ServiceProvider$initialize$1$32, ServiceProvider$initialize$1$33, ServiceProvider$initialize$1$34, ServiceProvider$initialize$1$35, ServiceProvider$initialize$1$36, ServiceProvider$initialize$1$36$1, ServiceProvider$initialize$1$37, ServiceProvider$initialize$1$38, ServiceProvider$initialize$1$39, ServiceProvider$initialize$1$4, ServiceProvider$initialize$1$40, ServiceProvider$initialize$1$41, ServiceProvider$initialize$1$42, ServiceProvider$initialize$1$43, ServiceProvider$initialize$1$44, ServiceProvider$initialize$1$45, ServiceProvider$initialize$1$46, ServiceProvider$initialize$1$47, ServiceProvider$initialize$1$48, ServiceProvider$initialize$1$49, ServiceProvider$initialize$1$5, ServiceProvider$initialize$1$50, ServiceProvider$initialize$1$51, ServiceProvider$initialize$1$52, ServiceProvider$initialize$1$53, ServiceProvider$initialize$1$54, ServiceProvider$initialize$1$55, ServiceProvider$initialize$1$56, ServiceProvider$initialize$1$57, ServiceProvider$initialize$1$58, ServiceProvider$initialize$1$59, ServiceProvider$initialize$1$6, ServiceProvider$initialize$1$60, ServiceProvider$initialize$1$61, ServiceProvider$initialize$1$62, ServiceProvider$initialize$1$63, ServiceProvider$initialize$1$64, ServiceProvider$initialize$1$65, ServiceProvider$initialize$1$66, ServiceProvider$initialize$1$67, ServiceProvider$initialize$1$68, ServiceProvider$initialize$1$69, ServiceProvider$initialize$1$7, ServiceProvider$initialize$1$70, ServiceProvider$initialize$1$71, ServiceProvider$initialize$1$72, ServiceProvider$initialize$1$73, ServiceProvider$initialize$1$74, ServiceProvider$initialize$1$75, ServiceProvider$initialize$1$76, ServiceProvider$initialize$1$77, ServiceProvider$initialize$1$78, ServiceProvider$initialize$1$79, ServiceProvider$initialize$1$8, ServiceProvider$initialize$1$80, ServiceProvider$initialize$1$81, ServiceProvider$initialize$1$82, ServiceProvider$initialize$1$83, ServiceProvider$initialize$1$84, ServiceProvider$initialize$1$85, ServiceProvider$initialize$1$86, ServiceProvider$initialize$1$87, ServiceProvider$initialize$1$88, ServiceProvider$initialize$1$89, ServiceProvider$initialize$1$9, ServiceProvider$initialize$1$90, ServiceProvider$initialize$1$91, ServiceProvider$initialize$1$92, ServiceProvider$initialize$1$93, ServiceProvider$initialize$1$94, ServiceProvider$initialize$1$95, ServiceProvider$initialize$1$96, ServiceProvider$initialize$1$97, ServiceProvider$initialize$1$98, ServiceProvider$initialize$1$99, UnityAdsModule$glInfoDataStore$1, UnityAdsModule$provideByteStringDataStore$1, UnityAdsModule$publicApiJob$1$1, UnityAdsModule$universalRequestDataStore$1, UnityAdsModule$webViewConfigurationDataStore$1
- **com.unity3d.services.core.domain** (3): ISDKDispatchers, ResultExtensionsKt, SDKDispatchers
- **com.unity3d.services.core.domain.task** (67): BaseParams, BaseTask, ConfigFileFromLocalStorage, EmptyParams, InitializationException, InitializeSDK, InitializeStateComplete, InitializeStateConfig, InitializeStateConfigWithLoader, InitializeStateCreate, InitializeStateError, InitializeStateLoadCache, InitializeStateLoadWeb, InitializeStateNetworkError, InitializeStateReset, MetricTask, BaseTask$DefaultImpls, BaseTask$invoke$1, ConfigFileFromLocalStorage$Params, ConfigFileFromLocalStorage$doWork$1, ConfigFileFromLocalStorage$doWork$2, InitializeSDK$doWork$1, InitializeSDK$doWork$2, InitializeSDK$doWork$2$1$webViewData$1, InitializeSDK$executeErrorState$1, InitializeSDK$handleInitializationException$1, InitializeStateComplete$Params, InitializeStateComplete$doWork$1, InitializeStateComplete$doWork$2, InitializeStateConfig$Params, InitializeStateConfig$doWork$1, InitializeStateConfig$doWork$2, InitializeStateConfigWithLoader$Params, InitializeStateConfigWithLoader$doWork$1, InitializeStateConfigWithLoader$doWork$2, InitializeStateConfigWithLoader$doWork$2$1$1, InitializeStateConfigWithLoader$doWork$2$1$1$1, InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1, InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1, InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1$1, InitializeStateCreate$Params, InitializeStateCreate$doWork$1, InitializeStateCreate$doWork$2, InitializeStateError$Params, InitializeStateError$doWork$1, InitializeStateError$doWork$2, InitializeStateLoadCache$LoadCacheResult, InitializeStateLoadCache$Params, InitializeStateLoadCache$doWork$1, InitializeStateLoadCache$doWork$2, InitializeStateLoadWeb$LoadWebResult, InitializeStateLoadWeb$Params, InitializeStateLoadWeb$doWork$1, InitializeStateLoadWeb$doWork$2, InitializeStateLoadWeb$doWork$2$1$webViewData$1, InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1, InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1, InitializeStateNetworkError$Params, InitializeStateNetworkError$doWork$1, InitializeStateNetworkError$doWork$2, InitializeStateNetworkError$doWork$2$1$success$1, InitializeStateReset$Params, InitializeStateReset$doWork$1, InitializeStateReset$doWork$2, InitializeStateReset$doWork$2$1$success$1, InitializeStateReset$doWork$2$1$success$1$1, MetricTask$invoke$1
- **com.unity3d.services.core.extensions** (8): AbortRetryException, CoroutineExtensionsKt, StringExtensionsKt, TaskExtensionsKt, CoroutineExtensionsKt$deferreds$1, CoroutineExtensionsKt$memoize$2, CoroutineExtensionsKt$memoize$2$deferred$1$1$1, TaskExtensionsKt$withRetry$1
- **com.unity3d.services.core.lifecycle** (9): CachedLifecycle, IAppActiveListener, IAppEventListener, LifecycleCache, LifecycleError, LifecycleEvent, LifecycleListener, LifecycleCache$1, LifecycleCache$2
- **com.unity3d.services.core.log** (5): DeviceLog, DeviceLogEntry, DeviceLogLevel, DeviceLog$1, DeviceLog$UnityAdsLogLevel
- **com.unity3d.services.core.misc** (12): EventSubject, IEventListener, IJsonStorageReader, IObserver, JsonFlattener, JsonFlattenerRules, JsonStorage, JsonStorageAggregator, Observable, Utilities, ViewUtilities, EventSubject$1
- **com.unity3d.services.core.network.core** (19): CronetClient, CronetEngineBuilderFactory, HttpClient, LegacyHttpClient, OkHttp3Client, UnityAdsUrlRequestCallback, CronetClient$Companion, CronetClient$execute$2$2, CronetClient$execute$2$callback$1, CronetClient$executeBlocking$1, LegacyHttpClient$Companion, LegacyHttpClient$execute$2, LegacyHttpClient$executeBlocking$1, OkHttp3Client$Companion, OkHttp3Client$execute$2, OkHttp3Client$executeBlocking$1, OkHttp3Client$makeRequest$2$1, UnityAdsUrlRequestCallback$Companion, UnityAdsUrlRequestCallback$startTimer$1
- **com.unity3d.services.core.network.mapper** (4): HttpRequestToOkHttpRequestKt, HttpRequestToWebRequestKt, HttpResponseHeaderToJSONArrayKt, WebRequestToHttpRequestKt
- **com.unity3d.services.core.network.model** (6): BodyType, HttpRequest, HttpResponse, HttpResponseKt, RequestType, HttpRequest$Companion
- **com.unity3d.services.core.preferences** (2): AndroidPreferences, PreferencesError
- **com.unity3d.services.core.properties** (9): ClientProperties, InitializationStatusReader, MadeWithUnityDetector, SdkProperties, Session, SessionIdReader, InitializationStatusReader$1, SdkProperties$InitializationState, Session$Default
- **com.unity3d.services.core.reflection** (2): GenericBridge, GenericListenerProxy
- **com.unity3d.services.core.request** (17): CancelableThreadPoolExecutor, IResolveHostListener, IWebRequestListener, IWebRequestProgressListener, NetworkIOException, ResolveHostError, ResolveHostEvent, WebRequest, WebRequestError, WebRequestEvent, WebRequestRunnable, WebRequestThread, WebRequest$RequestType, WebRequestRunnable$1, WebRequestThread$1, WebRequestThread$2, WebRequestThread$2$1
- **com.unity3d.services.core.request.metrics** (26): AdOperationError, AdOperationMetric, InitMetric, Metric, MetricCommonTags, MetricSender, MetricSenderBase, MetricSenderWithBatch, MetricsContainer, SDKMetrics, SDKMetricsSender, ScarMetric, TSIMetric, AdOperationMetric$1, AdOperationMetric$2, InitMetric$1, InitMetric$2, InitMetric$3, InitMetric$4, Metric$Companion, MetricCommonTags$1, MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1, MetricSender$sendMetrics$1, MetricsContainer$Companion, SDKMetrics$NullInstance, SDKMetricsSender$DefaultImpls
- **com.unity3d.services.core.sensorinfo** (2): SensorInfoError, SensorInfoListener
- **com.unity3d.services.core.timer** (10): BaseTimer, DefaultIntervalTimerFactory, IBaseTimer, IIntervalTimer, IIntervalTimerFactory, IIntervalTimerListener, ITimerListener, IntervalTimer, BaseTimer$1, BaseTimer$2
- **com.unity3d.services.core.webview** (15): WebView, WebViewApp, WebViewEventCategory, WebViewMetricKt, WebViewUrlBuilder, WebViewWithCache, WebView$special$$inlined$inject$default$1, WebViewApp$1, WebViewApp$2, WebViewApp$3, WebViewApp$4, WebViewApp$5, WebViewApp$WebAppClient, WebViewApp$WebAppClient$1, WebViewApp$WebAppClient$2
- **com.unity3d.services.core.webview.bridge** (22): CallbackStatus, IEventSender, IInvocationCallbackInvoker, INativeCallbackSubject, IWebViewBridge, IWebViewBridgeInvoker, IWebViewBridgeSharedObjectStore, IWebViewSharedObject, Invocation, NativeCallback, SharedInstances, WebViewBridge, WebViewBridgeError, WebViewBridgeInterface, WebViewBridgeInvoker, WebViewBridgeSharedObjectStore, WebViewCallback, WebViewExposed, SharedInstances$webViewAppNativeCallbackSubject$1, SharedInstances$webViewBridge$1, SharedInstances$webViewEventSender$1, WebViewCallback$1
- **com.unity3d.services.core.webview.bridge.invocation** (5): IWebViewBridgeInvocation, IWebViewBridgeInvocationCallback, WebViewBridgeInvocation, WebViewBridgeInvocationRunnable, WebViewBridgeInvocationSingleThreadedExecutor
- **com.unity3d.services.store.core** (6): GatewayStoreExceptionHandler, StoreEventListenerFactory, StoreExceptionHandler, StoreLifecycleListener, StoreWebViewError, WebViewStoreExceptionHandler
- **com.unity3d.services.store.core.api** (1): Store
- **com.unity3d.services.store.core.configuration** (1): StoreModuleConfiguration
- **com.unity3d.ads.datastore** (25): ByteStringStoreKt, ByteStringStoreKtKt, ByteStringStoreOuterClass, UniversalRequestStoreKt, UniversalRequestStoreKtKt, UniversalRequestStoreOuterClass, WebviewConfigurationStore, ByteStringStoreKt$Dsl, ByteStringStoreKt$Dsl$Companion, ByteStringStoreOuterClass$1, ByteStringStoreOuterClass$ByteStringStore, ByteStringStoreOuterClass$ByteStringStore$Builder, ByteStringStoreOuterClass$ByteStringStoreOrBuilder, UniversalRequestStoreKt$Dsl, UniversalRequestStoreKt$Dsl$Companion, UniversalRequestStoreKt$Dsl$UniversalRequestMapProxy, UniversalRequestStoreOuterClass$1, UniversalRequestStoreOuterClass$UniversalRequestStore, UniversalRequestStoreOuterClass$UniversalRequestStore$Builder, UniversalRequestStoreOuterClass$UniversalRequestStore$UniversalRequestMapDefaultEntryHolder, UniversalRequestStoreOuterClass$UniversalRequestStoreOrBuilder, WebviewConfigurationStore$1, WebviewConfigurationStore$WebViewConfigurationStore, WebviewConfigurationStore$WebViewConfigurationStore$Builder, WebviewConfigurationStore$WebViewConfigurationStoreOrBuilder
- **com.unity3d.ads.network** (1): HttpClient
- **com.unity3d.ads.network.client** (3): OkHttp3Client, OkHttp3Client$execute$2, OkHttp3Client$makeRequest$2$1
- **com.unity3d.ads.network.mapper** (1): HttpRequestToOkHttpRequestKt
- **com.unity3d.ads.network.model** (8): HttpBody, HttpRequest, HttpResponse, RequestType, HttpBody$ByteArrayBody, HttpBody$EmptyBody, HttpBody$StringBody, HttpRequest$Companion
- **com.unity3d.services.ads.api** (28): AdUnit, GMAScar, Load, Measurements, Show, Token, Topics, VideoPlayer, WebPlayer, AdUnit$1, AdUnit$2, AdUnit$3, AdUnit$4, AdUnit$5, AdUnit$6, VideoPlayer$1, VideoPlayer$2, VideoPlayer$3, VideoPlayer$4, VideoPlayer$5, VideoPlayer$6, WebPlayer$1, WebPlayer$2, WebPlayer$3, WebPlayer$4, WebPlayer$5, WebPlayer$6, WebPlayer$7
- **com.unity3d.services.banners.api** (4): Banner, BannerListener, Banner$1, Banner$BannerViewType
- **com.unity3d.services** (39): SDKErrorHandler, UnityAdsConstants, UnityAdsSDK, UnityServices, SDKErrorHandler$Companion, SDKErrorHandler$sendDiagnostic$1, UnityAdsConstants$AdOperations, UnityAdsConstants$Cache, UnityAdsConstants$ClientInfo, UnityAdsConstants$DefaultUrls, UnityAdsConstants$ErrorHandler, UnityAdsConstants$Messages, UnityAdsConstants$OpenMeasurement, UnityAdsConstants$Preferences, UnityAdsConstants$RequestPolicy, UnityAdsConstants$SharedFlow, UnityAdsConstants$Timeout, UnityAdsSDK$fetchToken$$inlined$inject$default$1, UnityAdsSDK$fetchToken$$inlined$inject$default$2, UnityAdsSDK$fetchToken$$inlined$inject$default$3, UnityAdsSDK$fetchToken$1, UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1, UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2, UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3, UnityAdsSDK$finishOMIDSession$1, UnityAdsSDK$getToken$$inlined$inject$default$1, UnityAdsSDK$getToken$1, UnityAdsSDK$getToken$2, UnityAdsSDK$initialize$$inlined$inject$default$1, UnityAdsSDK$initialize$$inlined$inject$default$2, UnityAdsSDK$initialize$$inlined$inject$default$3, UnityAdsSDK$initialize$$inlined$inject$default$4, UnityAdsSDK$initialize$1, UnityAdsSDK$isAlternativeFlowEnabled$$inlined$inject$default$1, UnityAdsSDK$load$$inlined$inject$default$1, UnityAdsSDK$load$1, UnityAdsSDK$show$$inlined$inject$default$1, UnityAdsSDK$show$1, UnityServices$UnityServicesError
- **com.unity3d.services.ads** (3): IUnityAds, UnityAdsImplementation, UnityAdsImplementation$1
- **com.unity3d.services.ads.adunit** (19): AdUnitActivity, AdUnitActivityController, AdUnitError, AdUnitEvent, AdUnitMotionEvent, AdUnitOpen, AdUnitRelativeLayout, AdUnitSoftwareActivity, AdUnitTransparentActivity, AdUnitTransparentActivityController, AdUnitTransparentSoftwareActivity, AdUnitViewHandlerFactory, IAdUnitActivity, IAdUnitViewHandler, IAdUnitViewHandlerFactory, PermissionsEvent, VideoPlayerHandler, WebPlayerHandler, WebViewHandler
- **com.unity3d.services.ads.configuration** (2): AdsModuleConfiguration, IAdsModuleConfiguration
- **com.unity3d.services.ads.gmascar** (2): GMA, GMAScarAdapterBridge
- **com.unity3d.services.ads.gmascar.adapters** (2): ScarAdapterFactory, ScarAdapterFactory$1
- **com.unity3d.services.ads.gmascar.bridges** (8): AdapterStatusBridge, AdapterStatusStateBridge, InitializationStatusBridge, InitializeListenerBridge, AdapterStatusBridge$1, InitializationStatusBridge$1, InitializeListenerBridge$1, InitializeListenerBridge$2
- **com.unity3d.services.ads.gmascar.bridges.mobileads** (7): IMobileAdsBridge, MobileAdsBridge, MobileAdsBridgeBase, MobileAdsBridgeFactory, MobileAdsBridgeLegacy, MobileAdsBridge$1, MobileAdsBridgeLegacy$1
- **com.unity3d.services.ads.gmascar.finder** (4): GMAInitializer, PresenceDetector, ScarAdapterVersion, ScarVersionFinder
- **com.unity3d.services.ads.gmascar.handlers** (8): BiddingSignalsHandler, ScarAdHandlerBase, ScarBannerAdHandler, ScarInterstitialAdHandler, ScarRewardedAdHandler, SignalsHandler, WebViewErrorHandler, ScarAdHandlerBase$1
- **com.unity3d.services.ads.gmascar.listeners** (2): IBiddingSignalsListener, IInitializationStatusListener
- **com.unity3d.services.ads.gmascar.managers** (9): BiddingBaseManager, BiddingDisabledManager, BiddingEagerManager, BiddingManagerFactory, IBiddingManager, ScarBiddingManagerType, BiddingBaseManager$1, BiddingManagerFactory$1, ScarBiddingManagerType$Constants
- **com.unity3d.services.ads.gmascar.models** (1): BiddingSignals
- **com.unity3d.services.ads.gmascar.utils** (3): GMAEventSender, ScarConstants, ScarRequestHandler
- **com.unity3d.services.ads.measurements** (5): MeasurementsErrors, MeasurementsEvents, MeasurementsReceiver, MeasurementsService, MeasurementsStatusReceiver
- **com.unity3d.services.ads.operation** (5): AdModule, AdOperation, IAdModule, IAdOperation, OperationState
- **com.unity3d.services.ads.operation.load** (18): BaseLoadModule, ILoadModule, ILoadOperation, LoadBannerModule, LoadBannerOperationState, LoadModule, LoadModuleDecorator, LoadModuleDecoratorInitializationBuffer, LoadModuleDecoratorTimeout, LoadOperation, LoadOperationState, BaseLoadModule$1, BaseLoadModule$2, LoadModuleDecoratorInitializationBuffer$1, LoadModuleDecoratorInitializationBuffer$2, LoadModuleDecoratorTimeout$1, LoadOperation$1, LoadOperation$2
- **com.unity3d.services.ads.operation.show** (14): IShowModule, IShowOperation, ShowModule, ShowModuleDecorator, ShowModuleDecoratorTimeout, ShowOperation, ShowOperationState, ShowModule$1, ShowModule$2, ShowModuleDecoratorTimeout$1, ShowOperation$1, ShowOperation$2, ShowOperation$3, ShowOperation$4
- **com.unity3d.services.ads.token** (19): AsyncTokenStorage, INativeTokenGenerator, INativeTokenGeneratorListener, InMemoryAsyncTokenStorage, InMemoryTokenStorage, NativeTokenGenerator, NativeTokenGeneratorWithPrivacyAwait, TokenError, TokenEvent, TokenStorage, InMemoryAsyncTokenStorage$1, InMemoryAsyncTokenStorage$2, InMemoryAsyncTokenStorage$2$1, InMemoryAsyncTokenStorage$3, InMemoryAsyncTokenStorage$TokenListenerState, InMemoryTokenStorage$special$$inlined$inject$default$1, NativeTokenGenerator$1, NativeTokenGeneratorWithPrivacyAwait$1, NativeTokenGeneratorWithPrivacyAwait$2
- **com.unity3d.services.ads.topics** (5): TopicsErrors, TopicsEvents, TopicsReceiver, TopicsService, TopicsStatus
- **com.unity3d.services.ads.video** (9): VideoPlayerError, VideoPlayerEvent, VideoPlayerView, VideoPlayerView$1, VideoPlayerView$2, VideoPlayerView$3, VideoPlayerView$4, VideoPlayerView$5, VideoPlayerView$6
- **com.unity3d.services.ads.webplayer** (14): WebPlayerBridgeInterface, WebPlayerError, WebPlayerEvent, WebPlayerEventBridge, WebPlayerSettingsCache, WebPlayerView, WebPlayerViewCache, WebPlayerView$1, WebPlayerView$2, WebPlayerView$JavaScriptInvocation, WebPlayerView$WebPlayerChromeClient, WebPlayerView$WebPlayerClient, WebPlayerView$WebPlayerClient$1, WebPlayerView$WebPlayerDownloadListener
- **com.unity3d.services.analytics** (4): AcquisitionType, UnityAnalytics, AcquisitionType$1, UnityAnalytics$AnalyticsEventType
- **com.unity3d.services.analytics.interfaces** (3): Analytics, AnalyticsError, IAnalytics
- **com.unity3d.services.banners** (27): BannerErrorCode, BannerErrorInfo, BannerView, BannerViewCache, IUnityBannerListener, UnityBannerSize, UnityBanners, BannerErrorInfo$1, BannerView$1, BannerView$2, BannerView$3, BannerView$IListener, BannerView$Listener, BannerViewCache$1, BannerViewCache$2, BannerViewCache$3, BannerViewCache$4, UnityBannerSize$Companion, UnityBanners$1, UnityBanners$2, UnityBanners$BannerAdRefreshView, UnityBanners$BannerAdRefreshView$1, UnityBanners$BannerAdRefreshView$2, UnityBanners$BannerAdRefreshView$3, UnityBanners$BannerAdRefreshView$LifecycleListener, UnityBanners$BannerWrapper, UnityBanners$BannerWrapper$1
- **com.unity3d.services.banners.bridge** (5): BannerBridge, BannerBridge$1, BannerBridge$2, BannerBridge$2$1, BannerBridge$BannerEvent
- **com.unity3d.services.banners.configuration** (1): BannersModuleConfiguration
- **com.unity3d.services.banners.properties** (1): BannerRefreshInfo
- **com.unity3d.services.banners.view** (6): BannerPosition, BannerWebPlayerContainer, ScarBannerContainer, BannerWebPlayerContainer$1, BannerWebPlayerContainer$2, BannerWebPlayerContainer$3
- **com.unity3d.services.store** (6): JsonSerializable, StoreError, StoreEvent, StoreMonitor, StoreWebViewEventSender, WebViewStoreEventListener
- **com.unity3d.services.store.gpbl** (3): BillingResultResponseCode, IBillingResponse, StoreBilling
- **com.unity3d.services.store.gpbl.bridges** (15): BillingResultBridge, CommonJsonResponseBridge, PurchaseBridge, PurchaseHistoryRecordBridge, PurchasesResultBridge, SkuDetailsBridge, SkuDetailsParamsBridge, BillingResultBridge$1, CommonJsonResponseBridge$1, PurchaseBridge$1, PurchasesResultBridge$1, SkuDetailsParamsBridge$1, SkuDetailsParamsBridge$2, SkuDetailsParamsBridge$BuilderBridge, SkuDetailsParamsBridge$BuilderBridge$1
- **com.unity3d.services.store.gpbl.bridges.billingclient** (3): BillingClientBuilderFactory, IBillingClient, IBillingClientBuilderBridge
- **com.unity3d.services.store.gpbl.bridges.billingclient.common** (5): BillingClientBridgeCommon, BillingClientBuilderBridgeCommon, BillingClientBridgeCommon$1, BillingClientBridgeCommon$2, BillingClientBuilderBridgeCommon$1
- **com.unity3d.services.store.gpbl.bridges.billingclient.v4** (3): BillingClientBridge, BillingClientBridge$1, BillingClientBridge$BuilderBridge
- **com.unity3d.services.store.gpbl.listeners** (8): BillingClientStateListener, BillingInitializationListener, FeatureSupportedListener, PurchaseHistoryResponseListener, PurchaseUpdatedResponseListener, PurchasesResponseListener, SkuDetailsResponseListener, StoreEventListener
- **com.unity3d.services.store.gpbl.proxies** (5): BillingClientStateListenerProxy, PurchaseHistoryResponseListenerProxy, PurchaseUpdatedListenerProxy, PurchasesResponseListenerProxy, SkuDetailsResponseListenerProxy

