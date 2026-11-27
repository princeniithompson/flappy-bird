# Decoded APK XML Layouts, Drawables & Configs

## res/anim/fragment_fast_out_extra_slow_in.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<pathInterpolator
  xmlns:android="http://schemas.android.com/apk/res/android" android:pathData="M 0,0 C 0.05, 0, 0.133333, 0.06, 0.166666, 0.4 C 0.208333, 0.82, 0.25, 1, 1, 1">
</pathInterpolator>
```

## res/animator/fragment_close_enter.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<set
  xmlns:android="http://schemas.android.com/apk/res/android">
  <set android:ordering="1">
    <objectAnimator
      android:interpolator="@0x010a000b"
      android:duration="66"
      android:valueFrom="0.0"
      android:valueTo="0.0"
      android:propertyName="alpha">
    </objectAnimator>
    <objectAnimator
      android:interpolator="@0x010a000b"
      android:duration="50"
      android:valueFrom="0.0"
      android:valueTo="1.0"
      android:propertyName="alpha">
    </objectAnimator>
  </set>
  <objectAnimator
    android:interpolator="@anim/fragment_fast_out_extra_slow_in"
    android:duration="300"
    android:valueFrom="1.1"
    android:valueTo="1.0"
    android:propertyName="scaleX">
  </objectAnimator>
  <objectAnimator
    android:interpolator="@anim/fragment_fast_out_extra_slow_in"
    android:duration="300"
    android:valueFrom="1.1"
    android:valueTo="1.0"
    android:propertyName="scaleY">
  </objectAnimator>
</set>
```

## res/animator/fragment_close_exit.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<set
  xmlns:android="http://schemas.android.com/apk/res/android">
  <set android:ordering="1">
    <objectAnimator
      android:interpolator="@0x010a000b"
      android:duration="66"
      android:valueFrom="1.0"
      android:valueTo="1.0"
      android:propertyName="alpha">
    </objectAnimator>
    <objectAnimator
      android:interpolator="@0x010a000b"
      android:duration="50"
      android:valueFrom="1.0"
      android:valueTo="0.0"
      android:propertyName="alpha">
    </objectAnimator>
  </set>
  <objectAnimator
    android:interpolator="@anim/fragment_fast_out_extra_slow_in"
    android:duration="300"
    android:valueFrom="1.0"
    android:valueTo="0.9"
    android:propertyName="scaleX">
  </objectAnimator>
  <objectAnimator
    android:interpolator="@anim/fragment_fast_out_extra_slow_in"
    android:duration="300"
    android:valueFrom="1.0"
    android:valueTo="0.9"
    android:propertyName="scaleY">
  </objectAnimator>
</set>
```

## res/animator/fragment_fade_enter.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<objectAnimator
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:interpolator="@0x010a000b"
  android:duration="150"
  android:valueFrom="0.0"
  android:valueTo="1.0"
  android:propertyName="alpha">
</objectAnimator>
```

## res/animator/fragment_fade_exit.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<objectAnimator
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:interpolator="@0x010a000b"
  android:duration="150"
  android:valueFrom="1.0"
  android:valueTo="0.0"
  android:propertyName="alpha">
</objectAnimator>
```

## res/animator/fragment_open_enter.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<set
  xmlns:android="http://schemas.android.com/apk/res/android">
  <set android:ordering="1">
    <objectAnimator
      android:interpolator="@0x010a000b"
      android:duration="50"
      android:valueFrom="0.0"
      android:valueTo="0.0"
      android:propertyName="alpha">
    </objectAnimator>
    <objectAnimator
      android:interpolator="@0x010a000b"
      android:duration="50"
      android:valueFrom="0.0"
      android:valueTo="1.0"
      android:propertyName="alpha">
    </objectAnimator>
  </set>
  <objectAnimator
    android:interpolator="@anim/fragment_fast_out_extra_slow_in"
    android:duration="300"
    android:valueFrom="0.85"
    android:valueTo="1.0"
    android:propertyName="scaleX">
  </objectAnimator>
  <objectAnimator
    android:interpolator="@anim/fragment_fast_out_extra_slow_in"
    android:duration="300"
    android:valueFrom="0.85"
    android:valueTo="1.0"
    android:propertyName="scaleY">
  </objectAnimator>
</set>
```

## res/animator/fragment_open_exit.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<set
  xmlns:android="http://schemas.android.com/apk/res/android">
  <set android:ordering="1">
    <objectAnimator
      android:interpolator="@0x010a000b"
      android:duration="50"
      android:valueFrom="1.0"
      android:valueTo="1.0"
      android:propertyName="alpha">
    </objectAnimator>
    <objectAnimator
      android:interpolator="@0x010a000b"
      android:duration="50"
      android:valueFrom="1.0"
      android:valueTo="0.0"
      android:propertyName="alpha">
    </objectAnimator>
  </set>
  <objectAnimator
    android:interpolator="@anim/fragment_fast_out_extra_slow_in"
    android:duration="300"
    android:valueFrom="1.0"
    android:valueTo="1.15"
    android:propertyName="scaleX">
  </objectAnimator>
  <objectAnimator
    android:interpolator="@anim/fragment_fast_out_extra_slow_in"
    android:duration="300"
    android:valueFrom="1.0"
    android:valueTo="1.15"
    android:propertyName="scaleY">
  </objectAnimator>
</set>
```

## res/color/common_google_signin_btn_text_dark.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_enabled="false"
    android:color="@color/common_google_signin_btn_text_dark_disabled">
  </item>
  <item
    android:state_pressed="true"
    android:color="@color/common_google_signin_btn_text_dark_pressed">
  </item>
  <item
    android:state_focused="true"
    android:color="@color/common_google_signin_btn_text_dark_focused">
  </item>
  <item android:color="@color/common_google_signin_btn_text_dark_default">
  </item>
</selector>
```

## res/color/common_google_signin_btn_text_light.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_enabled="false"
    android:color="@color/common_google_signin_btn_text_light_disabled">
  </item>
  <item
    android:state_pressed="true"
    android:color="@color/common_google_signin_btn_text_light_pressed">
  </item>
  <item
    android:state_focused="true"
    android:color="@color/common_google_signin_btn_text_light_focused">
  </item>
  <item android:color="@color/common_google_signin_btn_text_light_default">
  </item>
</selector>
```

## res/color/common_google_signin_btn_tint.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_pressed="true"
    android:color="#11000000">
  </item>
  <item android:color="@0x0106000d">
  </item>
</selector>
```

## res/color/switch_thumb_material_dark.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_enabled="false"
    android:color="@color/switch_thumb_disabled_material_dark">
  </item>
  <item android:color="@color/switch_thumb_normal_material_dark">
  </item>
</selector>
```

## res/color/switch_thumb_material_light.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_enabled="false"
    android:color="@color/switch_thumb_disabled_material_light">
  </item>
  <item android:color="@color/switch_thumb_normal_material_light">
  </item>
</selector>
```

## res/drawable/close_24px.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<vector
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:tint="?0x7f03007c"
  android:height="24dp"
  android:width="24dp"
  android:viewportWidth="960.0"
  android:viewportHeight="960.0">
  <path
    android:fillColor="@0x0106000b"
    android:pathData="M256,760L200,704L424,480L200,256L256,200L480,424L704,200L760,256L536,480L760,704L704,760L480,536L256,760Z">
  </path>
</vector>
```

## res/drawable/common_google_signin_btn_icon_dark.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_enabled="false"
    android:drawable="@drawable/common_google_signin_btn_icon_disabled">
  </item>
  <item
    android:state_focused="true"
    android:drawable="@drawable/common_google_signin_btn_icon_dark_focused">
  </item>
  <item android:drawable="@drawable/common_google_signin_btn_icon_dark_normal">
  </item>
</selector>
```

## res/drawable/common_google_signin_btn_icon_dark_focused.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:left="1dp"
    android:top="1dp"
    android:right="1dp"
    android:bottom="1dp">
    <shape android:shape="0">
      <solid android:color="@0x0106000d">
      </solid>
      <stroke
        android:width="4dp"
        android:color="#FFC6DAFB">
      </stroke>
    </shape>
  </item>
  <item android:drawable="@drawable/common_google_signin_btn_icon_dark_normal">
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_icon_dark_normal.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item android:drawable="@drawable/common_google_signin_btn_icon_dark_normal_background">
  </item>
  <item>
    <bitmap
      android:gravity="0x11"
      android:src="@drawable/googleg_standard_color_18">
    </bitmap>
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_icon_disabled.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:left="3dp"
    android:top="3dp"
    android:right="3dp"
    android:bottom="3dp">
    <shape android:shape="0">
      <solid android:color="#FFEBEBEB">
      </solid>
      <corners android:radius="2dp">
      </corners>
      <padding
        android:left="7dp"
        android:top="7dp"
        android:right="7dp"
        android:bottom="7dp">
      </padding>
    </shape>
  </item>
  <item>
    <bitmap
      android:gravity="0x11"
      android:src="@drawable/googleg_disabled_color_18">
    </bitmap>
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_icon_light.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_enabled="false"
    android:drawable="@drawable/common_google_signin_btn_icon_disabled">
  </item>
  <item
    android:state_focused="true"
    android:drawable="@drawable/common_google_signin_btn_icon_light_focused">
  </item>
  <item android:drawable="@drawable/common_google_signin_btn_icon_light_normal">
  </item>
</selector>
```

## res/drawable/common_google_signin_btn_icon_light_focused.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:left="1dp"
    android:top="1dp"
    android:right="1dp"
    android:bottom="1dp">
    <shape android:shape="0">
      <solid android:color="@0x0106000d">
      </solid>
      <stroke
        android:width="4dp"
        android:color="#4D4284F2">
      </stroke>
    </shape>
  </item>
  <item android:drawable="@drawable/common_google_signin_btn_icon_light_normal">
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_icon_light_normal.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item android:drawable="@drawable/common_google_signin_btn_icon_light_normal_background">
  </item>
  <item>
    <bitmap
      android:gravity="0x11"
      android:src="@drawable/googleg_standard_color_18">
    </bitmap>
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_text_dark.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_enabled="false"
    android:drawable="@drawable/common_google_signin_btn_text_disabled">
  </item>
  <item
    android:state_focused="true"
    android:drawable="@drawable/common_google_signin_btn_text_dark_focused">
  </item>
  <item android:drawable="@drawable/common_google_signin_btn_text_dark_normal">
  </item>
</selector>
```

## res/drawable/common_google_signin_btn_text_dark_focused.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:left="1dp"
    android:top="1dp"
    android:right="1dp"
    android:bottom="1dp">
    <shape android:shape="0">
      <solid android:color="@0x0106000d">
      </solid>
      <stroke
        android:width="4dp"
        android:color="#FFC6DAFB">
      </stroke>
    </shape>
  </item>
  <item android:drawable="@drawable/common_google_signin_btn_text_dark_normal">
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_text_dark_normal.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item android:drawable="@drawable/common_google_signin_btn_text_dark_normal_background">
  </item>
  <item android:left="-36dp">
    <bitmap
      android:gravity="0x13"
      android:src="@drawable/googleg_standard_color_18">
    </bitmap>
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_text_disabled.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:left="3dp"
    android:top="3dp"
    android:right="3dp"
    android:bottom="3dp">
    <shape android:shape="0">
      <solid android:color="#FFEBEBEB">
      </solid>
      <corners android:radius="2dp">
      </corners>
      <padding
        android:left="50dp"
        android:top="8dp"
        android:right="11dp"
        android:bottom="7dp">
      </padding>
    </shape>
  </item>
  <item android:left="-36dp">
    <bitmap
      android:gravity="0x13"
      android:src="@drawable/googleg_disabled_color_18">
    </bitmap>
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_text_light.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:state_enabled="false"
    android:drawable="@drawable/common_google_signin_btn_text_disabled">
  </item>
  <item
    android:state_focused="true"
    android:drawable="@drawable/common_google_signin_btn_text_light_focused">
  </item>
  <item android:drawable="@drawable/common_google_signin_btn_text_light_normal">
  </item>
</selector>
```

## res/drawable/common_google_signin_btn_text_light_focused.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item
    android:left="1dp"
    android:top="1dp"
    android:right="1dp"
    android:bottom="1dp">
    <shape android:shape="0">
      <solid android:color="@0x0106000d">
      </solid>
      <stroke
        android:width="4dp"
        android:color="#4D4284F2">
      </stroke>
    </shape>
  </item>
  <item android:drawable="@drawable/common_google_signin_btn_text_light_normal">
  </item>
</layer-list>
```

## res/drawable/common_google_signin_btn_text_light_normal.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list
  xmlns:android="http://schemas.android.com/apk/res/android">
  <item android:drawable="@drawable/common_google_signin_btn_text_light_normal_background">
  </item>
  <item android:left="-36dp">
    <bitmap
      android:gravity="0x13"
      android:src="@drawable/googleg_standard_color_18">
    </bitmap>
  </item>
</layer-list>
```

## res/drawable/test_level_drawable.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape
  xmlns:android="http://schemas.android.com/apk/res/android">
  <solid android:color="@color/primary_dark_material_dark">
  </solid>
  <corners android:radius="10dp">
  </corners>
</shape>
```

## res/layout/browser_actions_context_menu_page.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.browser.browseractions.BrowserActionsFallbackMenuView
  xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  android:layout_gravity="0x11"
  android:orientation="1"
  android:id="@id/browser_actions_menu_view"
  android:background="@color/browser_actions_bg_grey"
  android:layout_width="-2"
  android:layout_height="-2"
  android:minWidth="280dp">
  <TextView
    android:textSize="13sp"
    android:textStyle="0x1"
    android:textColor="@color/browser_actions_title_color"
    android:ellipsize="3"
    android:gravity="0x11"
    android:id="@id/browser_actions_header_text"
    android:layout_width="-1"
    android:layout_height="-2"
    android:layout_marginTop="10dp"
    android:layout_marginBottom="10dp"
    android:maxLines="1"
    android:paddingStart="20dp"
    android:paddingEnd="20dp">
  </TextView>
  <View
    android:background="@color/browser_actions_divider_color"
    android:layout_width="-1"
    android:layout_height="1dp">
  </View>
  <ListView
    android:id="@id/browser_actions_menu_items"
    android:paddingTop="8dp"
    android:paddingBottom="8dp"
    android:layout_width="-1"
    android:layout_height="-2"
    android:divider="@0x00000000"
    android:dividerHeight="0dp">
  </ListView>
</androidx.browser.browseractions.BrowserActionsFallbackMenuView>
```

## res/layout/browser_actions_context_menu_row.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:orientation="0"
  android:layout_width="-1"
  android:layout_height="-2"
  android:minHeight="48dp"
  android:paddingStart="15dp"
  android:paddingEnd="15dp">
  <TextView
    android:textSize="15sp"
    android:textColor="@color/browser_actions_text_color"
    android:layout_gravity="0x10"
    android:id="@id/browser_actions_menu_item_text"
    android:layout_width="0dp"
    android:layout_height="-2"
    android:layout_marginLeft="10dp"
    android:layout_weight="1.0"
    android:layout_marginStart="10dp">
  </TextView>
  <ImageView
    android:id="@id/browser_actions_menu_item_icon"
    android:paddingTop="8dp"
    android:paddingBottom="8dp"
    android:layout_width="20dp"
    android:layout_height="-1"
    android:scaleType="7"
    android:contentDescription="@0x00000000">
  </ImageView>
</LinearLayout>
```

## res/layout/native_share_custom_dialog_holder.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:gravity="0x11"
  android:layout_gravity="0x11"
  android:layout_width="-1"
  android:layout_height="-1"
  android:layout_margin="20dp">
</RelativeLayout>
```

## res/layout/native_share_grid_element.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:gravity="0x31"
  android:orientation="1"
  android:layout_width="-1"
  android:layout_height="-2">
  <ImageView
    android:id="@id/native_share_app_icon"
    android:layout_width="56dp"
    android:layout_height="56dp"
    android:scaleType="3">
  </ImageView>
  <TextView
    android:textSize="12sp"
    android:textStyle="0x1"
    android:ellipsize="3"
    android:gravity="0x31"
    android:id="@id/native_share_app_name"
    android:paddingLeft="8dp"
    android:paddingTop="4dp"
    android:paddingRight="8dp"
    android:paddingBottom="0dp"
    android:layout_width="-1"
    android:layout_height="40dp"
    android:maxLines="2">
  </TextView>
</LinearLayout>
```

## res/layout/native_share_grid_view.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:orientation="1"
  android:layout_width="-1"
  android:layout_height="-2">
  <GridView
    android:gravity="0x11"
    android:id="@id/native_share_grid_view_holder"
    android:paddingLeft="10dp"
    android:paddingTop="20dp"
    android:paddingRight="10dp"
    android:paddingBottom="0dp"
    android:layout_width="-1"
    android:layout_height="-2"
    android:horizontalSpacing="10dp"
    android:verticalSpacing="10dp"
    android:stretchMode="2"
    android:columnWidth="75dp"
    android:numColumns="-1">
  </GridView>
</LinearLayout>
```

## res/xml/eossdk_backup_rules.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<full-backup-content>
  <exclude
    domain="sharedpref"
    path="EOS_KeychainPreferences">
  </exclude>
</full-backup-content>
```

## res/xml/image_share_filepaths.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<paths>
  <files-path
    name="image_provider_images"
    path="image_provider/">
  </files-path>
</paths>
```

