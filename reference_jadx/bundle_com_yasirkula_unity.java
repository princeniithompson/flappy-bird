
// ===== FILE: com/yasirkula/unity/C1286R.java =====
package com.yasirkula.unity;

/* renamed from: com.yasirkula.unity.R */
/* loaded from: classes.dex */
public final class C1286R {

    /* renamed from: com.yasirkula.unity.R$id */
    public static final class id {
        public static final int native_share_app_icon = 2131230915;
        public static final int native_share_app_name = 2131230916;
        public static final int native_share_grid_view_holder = 2131230917;

        private id() {
        }
    }

    /* renamed from: com.yasirkula.unity.R$layout */
    public static final class layout {
        public static final int native_share_custom_dialog_holder = 2131427359;
        public static final int native_share_grid_element = 2131427360;
        public static final int native_share_grid_view = 2131427361;

        private layout() {
        }
    }

    /* renamed from: com.yasirkula.unity.R$style */
    public static final class style {
        public static final int Theme_NativeShareTransparent = 2131689740;

        private style() {
        }
    }

    private C1286R() {
    }
}

// ===== FILE: com/yasirkula/unity/NativeShare.java =====
package com.yasirkula.unity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.webkit.ProxyConfig;
import androidx.webkit.internal.AssetHelper;
import com.unity3d.services.UnityAdsConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class NativeShare {
    public static boolean alwaysUseCustomShareDialog;
    public static String authority;
    private static int isXiaomiOrMIUI;
    public static NativeShareResultReceiver shareResultReceiver;

    public static void Share(final Context context, final NativeShareResultReceiver shareResultReceiver2, final String[] targetPackages, final String[] targetClasses, final String[] files, final String[] mimes, final String[] emailRecipients, final String subject, final String text, final String title) {
        if (files.length > 0 && GetAuthority(context) == null) {
            Log.e("Unity", "Can't find ContentProvider, share not possible!");
            shareResultReceiver2.OnShareCompleted(2, "");
            return;
        }
        shareResultReceiver = shareResultReceiver2;
        Bundle bundle = new Bundle();
        bundle.putString(NativeShareFragment.SUBJECT_ID, subject);
        bundle.putString(NativeShareFragment.TEXT_ID, text);
        bundle.putString(NativeShareFragment.TITLE_ID, title);
        bundle.putStringArrayList(NativeShareFragment.FILES_ID, ConvertArrayToArrayList(files));
        bundle.putStringArrayList(NativeShareFragment.MIMES_ID, ConvertArrayToArrayList(mimes));
        bundle.putStringArrayList(NativeShareFragment.EMAIL_RECIPIENTS_ID, ConvertArrayToArrayList(emailRecipients));
        bundle.putStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID, ConvertArrayToArrayList(targetPackages));
        bundle.putStringArrayList(NativeShareFragment.TARGET_CLASS_ID, ConvertArrayToArrayList(targetClasses));
        boolean z = true;
        boolean z2 = alwaysUseCustomShareDialog || targetPackages.length > 1;
        if (!z2 && shareResultReceiver2.HasManagedCallback() && "huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
            z2 = true;
        }
        if (z2 || !IsXiaomiOrMIUI() || (Build.VERSION.SDK_INT != 30 && !IsUnityInLandscapeMode((Activity) context))) {
            z = z2;
        }
        if (z) {
            Log.d("Unity", "Creating custom share dialog");
            Intent intent = new Intent(context, (Class<?>) NativeShareCustomShareDialogActivity.class);
            intent.putExtras(bundle);
            intent.setFlags(BasicMeasure.EXACTLY);
            context.startActivity(intent);
            return;
        }
        Log.d("Unity", "Creating standard share dialog");
        NativeShareFragment nativeShareFragment = new NativeShareFragment();
        nativeShareFragment.setArguments(bundle);
        ((Activity) context).getFragmentManager().beginTransaction().add(0, nativeShareFragment).commitAllowingStateLoss();
    }

    public static Intent CreateIntentFromBundle(Context context, Bundle bundle, ArrayList<Uri> fileUris) {
        String str;
        String mimeTypeFromExtension;
        int indexOf;
        String string = bundle.getString(NativeShareFragment.SUBJECT_ID);
        String string2 = bundle.getString(NativeShareFragment.TEXT_ID);
        String string3 = bundle.getString(NativeShareFragment.TITLE_ID);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeShareFragment.FILES_ID);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList(NativeShareFragment.MIMES_ID);
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList(NativeShareFragment.EMAIL_RECIPIENTS_ID);
        ArrayList<String> stringArrayList4 = bundle.getStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID);
        ArrayList<String> stringArrayList5 = bundle.getStringArrayList(NativeShareFragment.TARGET_CLASS_ID);
        Intent intent = new Intent();
        if (string.length() > 0) {
            intent.putExtra("android.intent.extra.SUBJECT", string);
        }
        if (string2.length() > 0) {
            intent.putExtra("android.intent.extra.TEXT", string2);
        }
        int i = 1;
        if (stringArrayList.size() > 0) {
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            while (i2 < stringArrayList.size()) {
                if (stringArrayList2.get(i2).length() > 0) {
                    mimeTypeFromExtension = stringArrayList2.get(i2);
                } else {
                    int lastIndexOf = stringArrayList.get(i2).lastIndexOf(46);
                    if (lastIndexOf >= 0 && lastIndexOf != stringArrayList.get(i2).length() - i) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(stringArrayList.get(i2).substring(lastIndexOf + 1).toLowerCase(Locale.ENGLISH));
                    }
                    str2 = ProxyConfig.MATCH_ALL_SCHEMES;
                    str3 = str2;
                    break;
                }
                if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() != 0 && (indexOf = mimeTypeFromExtension.indexOf(47)) > 0 && indexOf != mimeTypeFromExtension.length() - 1) {
                    ArrayList<String> arrayList = stringArrayList2;
                    String substring = mimeTypeFromExtension.substring(0, indexOf);
                    String substring2 = mimeTypeFromExtension.substring(indexOf + 1);
                    if (str2 == null) {
                        str2 = substring;
                    } else if (!str2.equals(substring)) {
                    }
                    if (str3 == null) {
                        str3 = substring2;
                    } else if (!str3.equals(substring2)) {
                        str3 = ProxyConfig.MATCH_ALL_SCHEMES;
                    }
                    i2++;
                    stringArrayList2 = arrayList;
                    i = 1;
                }
                str2 = ProxyConfig.MATCH_ALL_SCHEMES;
                str3 = str2;
            }
            str = str2 + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + str3;
            if (stringArrayList.size() == 1) {
                intent.setAction("android.intent.action.SEND");
                Uri uriForFile = NativeShareContentProvider.getUriForFile(context, authority, new File(stringArrayList.get(0)));
                fileUris.add(uriForFile);
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
            } else {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                    fileUris.add(NativeShareContentProvider.getUriForFile(context, authority, new File(stringArrayList.get(i3))));
                }
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", fileUris);
            }
        } else {
            intent.setAction("android.intent.action.SEND");
            str = AssetHelper.DEFAULT_MIME_TYPE;
        }
        if (stringArrayList3.size() > 0) {
            String[] strArr = new String[stringArrayList3.size()];
            stringArrayList3.toArray(strArr);
            intent.putExtra("android.intent.extra.EMAIL", strArr);
        }
        if (string3.length() > 0) {
            intent.putExtra("android.intent.extra.TITLE", string3);
        }
        intent.setType(str);
        intent.setFlags(1);
        if (stringArrayList4.size() == 1) {
            intent.setPackage(stringArrayList4.get(0));
            if (stringArrayList5.get(0).length() > 0) {
                intent.setClassName(stringArrayList4.get(0), stringArrayList5.get(0));
            }
        }
        return intent;
    }

    public static void GrantURIPermissionsToShareIntentTargets(Context context, List<ResolveInfo> shareTargets, ArrayList<Uri> fileUris) {
        try {
            for (int size = shareTargets.size() - 1; size >= 0; size--) {
                for (int size2 = fileUris.size() - 1; size2 >= 0; size2--) {
                    context.grantUriPermission(shareTargets.get(size).activityInfo.packageName, fileUris.get(size2), 1);
                }
            }
        } catch (Exception e) {
            Log.e("Unity", "NativeShare couldn't call grantUriPermission:", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        com.yasirkula.unity.NativeShare.authority = r3.authority;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String GetAuthority(Context context) {
        if (authority == null) {
            try {
                ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
                if (providerInfoArr != null) {
                    int length = providerInfoArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        ProviderInfo providerInfo = providerInfoArr[i];
                        if (providerInfo.name != null && providerInfo.packageName != null && providerInfo.authority != null && providerInfo.name.equals(NativeShareContentProvider.class.getName()) && providerInfo.packageName.equals(context.getPackageName()) && providerInfo.authority.length() > 0) {
                            break;
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                Log.e("Unity", "Exception:", e);
            }
        }
        return authority;
    }

    private static ArrayList<String> ConvertArrayToArrayList(String[] arr) {
        ArrayList<String> arrayList = new ArrayList<>(arr.length);
        for (String str : arr) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private static boolean IsUnityInLandscapeMode(Activity unityActivity) {
        return unityActivity.getResources().getConfiguration().orientation == 2;
    }

    private static boolean IsXiaomiOrMIUI() {
        BufferedReader bufferedReader;
        int i = isXiaomiOrMIUI;
        if (i > 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if ("xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
            isXiaomiOrMIUI = 1;
            return true;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.length() > 0) {
                isXiaomiOrMIUI = 1;
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return true;
            }
            isXiaomiOrMIUI = -1;
            try {
                bufferedReader.close();
            } catch (Exception unused3) {
            }
            return false;
        } catch (Exception unused4) {
            bufferedReader2 = bufferedReader;
            isXiaomiOrMIUI = -1;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused6) {
                }
            }
            throw th;
        }
    }

    public static boolean TargetExists(Context context, String packageName, String className) {
        if (className.length() == 0) {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        }
        ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(packageName, 1).activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (activityInfo.name.equals(className)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String FindMatchingTarget(Context context, String packageNameRegex, String classNameRegex) {
        ActivityInfo[] activityInfoArr;
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(1);
        if (installedPackages == null) {
            return "";
        }
        Pattern compile = Pattern.compile(packageNameRegex);
        Pattern compile2 = classNameRegex.length() > 0 ? Pattern.compile(classNameRegex) : null;
        for (PackageInfo packageInfo : installedPackages) {
            if (compile.matcher(packageInfo.packageName).find() && (activityInfoArr = packageInfo.activities) != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (compile2 == null || compile2.matcher(activityInfo.name).find()) {
                        return packageInfo.packageName + ">" + activityInfo.name;
                    }
                }
            }
        }
        return "";
    }
}

// ===== FILE: com/yasirkula/unity/NativeShareBroadcastListener.java =====
package com.yasirkula.unity;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class NativeShareBroadcastListener extends BroadcastReceiver {
    public static IntentSender Initialize(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) NativeShareBroadcastListener.class), Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728).getIntentSender();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (NativeShare.shareResultReceiver != null) {
            ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
            if (componentName != null) {
                String flattenToString = componentName.flattenToString();
                Log.d("Unity", "Shared on app: " + flattenToString);
                NativeShare.shareResultReceiver.OnShareCompleted(1, flattenToString);
                return;
            }
            Log.d("Unity", "Shared on app: Unknown");
            NativeShare.shareResultReceiver.OnShareCompleted(1, "");
            return;
        }
        Log.e("Unity", "NativeShareResultReceiver was null!");
    }
}

// ===== FILE: com/yasirkula/unity/NativeShareContentProvider.java =====
package com.yasirkula.unity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class NativeShareContentProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private PathStrategy mStrategy;
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
    private static HashMap<String, PathStrategy> sCache = new HashMap<>();

    interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo info) {
        super.attachInfo(context, info);
        if (info.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!info.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.mStrategy = getPathStrategy(context, info.authority);
    }

    public static Uri getUriForFile(Context context, String authority, File file) {
        return getPathStrategy(context, authority).getUriForFile(file);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int i;
        File fileForUri = this.mStrategy.getFileForUri(uri);
        if (projection == null) {
            projection = COLUMNS;
        }
        String[] strArr = new String[projection.length];
        Object[] objArr = new Object[projection.length];
        int i2 = 0;
        for (String str : projection) {
            if ("_display_name".equals(str)) {
                strArr[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileForUri.getName();
            } else if ("_size".equals(str)) {
                strArr[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(fileForUri.length());
            }
            i2 = i;
        }
        String[] copyOf = copyOf(strArr, i2);
        Object[] copyOf2 = copyOf(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileForUri = this.mStrategy.getFileForUri(uri);
        int lastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.mStrategy.getFileForUri(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(uri), modeToMode(mode));
    }

    private static PathStrategy getPathStrategy(Context context, String authority) {
        PathStrategy pathStrategy;
        synchronized (sCache) {
            pathStrategy = sCache.get(authority);
            if (pathStrategy == null) {
                try {
                    pathStrategy = parsePathStrategy(context, authority);
                    sCache.put(authority, pathStrategy);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return pathStrategy;
    }

    private static PathStrategy parsePathStrategy(Context context, String authority) throws IOException, XmlPullParserException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(authority);
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 128);
        if (resolveContentProvider == null) {
            Log.w("Unity", "NativeShareContentProvider.resolveContentProvider is null!");
        } else {
            resolveContentProvider.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        }
        File buildPath = buildPath(DEVICE_ROOT, ".");
        if (buildPath != null) {
            simplePathStrategy.addRoot("devroot", buildPath);
        }
        return simplePathStrategy;
    }

    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots = new HashMap<>();

        public SimplePathStrategy(String authority) {
            this.mAuthority = authority;
        }

        public void addRoot(String name, File root) {
            if (TextUtils.isEmpty(name)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.mRoots.put(name, root.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + root, e);
            }
        }

        @Override // com.yasirkula.unity.NativeShareContentProvider.PathStrategy
        public Uri getUriForFile(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.mRoots.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)) {
                    substring = canonicalPath.substring(path2.length());
                } else {
                    substring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme(HandleInvocationsFromAdViewer.KEY_PRIVACY_UPDATE_CONTENT).authority(this.mAuthority).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // com.yasirkula.unity.NativeShareContentProvider.PathStrategy
        public File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.mRoots.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }

    private static int modeToMode(String mode) {
        if (AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ.equals(mode)) {
            return 268435456;
        }
        if ("w".equals(mode) || "wt".equals(mode)) {
            return 738197504;
        }
        if ("wa".equals(mode)) {
            return 704643072;
        }
        if ("rw".equals(mode)) {
            return 939524096;
        }
        if ("rwt".equals(mode)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + mode);
    }

    private static File buildPath(File base, String... segments) {
        for (String str : segments) {
            if (str != null) {
                base = new File(base, str);
            }
        }
        return base;
    }

    private static String[] copyOf(String[] original, int newLength) {
        String[] strArr = new String[newLength];
        System.arraycopy(original, 0, strArr, 0, newLength);
        return strArr;
    }

    private static Object[] copyOf(Object[] original, int newLength) {
        Object[] objArr = new Object[newLength];
        System.arraycopy(original, 0, objArr, 0, newLength);
        return objArr;
    }
}

// ===== FILE: com/yasirkula/unity/NativeShareCustomShareDialog.java =====
package com.yasirkula.unity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class NativeShareCustomShareDialog extends DialogFragment {
    private boolean sentShareResult;

    private static class CustomShareDialogAdapter extends ArrayAdapter<ResolveInfo> {
        private PackageManager packageManager;
        private Activity unityActivity;

        private static class ViewHolder {
            private final ImageView icon;
            private final TextView label;

            public ViewHolder(TextView label, ImageView icon) {
                this.label = label;
                this.icon = icon;
            }
        }

        private CustomShareDialogAdapter(Activity unityActivity, List<ResolveInfo> apps) {
            super(unityActivity, C1286R.layout.native_share_grid_element, apps);
            this.unityActivity = unityActivity;
            this.packageManager = unityActivity.getPackageManager();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = this.unityActivity.getLayoutInflater().inflate(C1286R.layout.native_share_grid_element, parent, false);
                convertView.setTag(new ViewHolder((TextView) convertView.findViewById(C1286R.id.native_share_app_name), (ImageView) convertView.findViewById(C1286R.id.native_share_app_icon)));
            }
            ResolveInfo item = getItem(position);
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.label.setText(item.loadLabel(this.packageManager));
            viewHolder.icon.setImageDrawable(item.loadIcon(this.packageManager));
            return convertView;
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        final Intent CreateIntentFromBundle = NativeShare.CreateIntentFromBundle(getActivity(), getArguments(), arrayList);
        String string = getArguments().getString(NativeShareFragment.TITLE_ID);
        ArrayList<String> stringArrayList = getArguments().getStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID);
        ArrayList<String> stringArrayList2 = getArguments().getStringArrayList(NativeShareFragment.TARGET_CLASS_ID);
        PackageManager packageManager = getActivity().getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(CreateIntentFromBundle, 65536);
        if (arrayList.size() > 0) {
            NativeShare.GrantURIPermissionsToShareIntentTargets(getActivity(), queryIntentActivities, arrayList);
        }
        if (stringArrayList.size() > 1) {
            for (int size = queryIntentActivities.size() - 1; size >= 0; size--) {
                ActivityInfo activityInfo = queryIntentActivities.get(size).activityInfo;
                String str = activityInfo.applicationInfo.packageName;
                String str2 = activityInfo.name;
                for (int size2 = stringArrayList.size() - 1; size2 >= 0; size2--) {
                    if (str.equals(stringArrayList.get(size2)) && (stringArrayList2.get(size2).length() == 0 || str2.equals(stringArrayList2.get(size2)))) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (!z) {
                    queryIntentActivities.remove(size);
                }
            }
        }
        if (queryIntentActivities.size() == 0) {
            return new AlertDialog.Builder(getActivity()).setTitle(string).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.yasirkula.unity.NativeShareCustomShareDialog.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    NativeShareCustomShareDialog.this.dismissAllowingStateLoss();
                }
            }).setMessage("No apps can perform this action.").create();
        }
        if (queryIntentActivities.size() == 1) {
            StartTargetActivity(CreateIntentFromBundle, queryIntentActivities.get(0).activityInfo);
            dismissAllowingStateLoss();
        } else {
            Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
        }
        final CustomShareDialogAdapter customShareDialogAdapter = new CustomShareDialogAdapter(getActivity(), queryIntentActivities);
        View inflate = getActivity().getLayoutInflater().inflate(C1286R.layout.native_share_grid_view, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(C1286R.id.native_share_grid_view_holder);
        gridView.setAdapter((ListAdapter) customShareDialogAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yasirkula.unity.NativeShareCustomShareDialog.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NativeShareCustomShareDialog.this.StartTargetActivity(CreateIntentFromBundle, customShareDialogAdapter.getItem(position).activityInfo);
                NativeShareCustomShareDialog.this.dismissAllowingStateLoss();
            }
        });
        return new AlertDialog.Builder(getActivity()).setTitle(string).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.yasirkula.unity.NativeShareCustomShareDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                NativeShareCustomShareDialog.this.dismissAllowingStateLoss();
            }
        }).setView(inflate).create();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        dismissAllowingStateLoss();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.sentShareResult) {
            return;
        }
        this.sentShareResult = true;
        NativeShare.shareResultReceiver.OnShareCompleted(2, "");
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d("Unity", "Dismissed custom share dialog");
        if (!this.sentShareResult) {
            this.sentShareResult = true;
            NativeShare.shareResultReceiver.OnShareCompleted(2, "");
        }
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof NativeShareCustomShareDialogActivity)) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void StartTargetActivity(final Intent shareIntent, final ActivityInfo targetActivity) {
        ComponentName componentName = new ComponentName(targetActivity.applicationInfo.packageName, targetActivity.name);
        String flattenToString = componentName.flattenToString();
        Log.d("Unity", "Shared on app: " + flattenToString);
        NativeShare.shareResultReceiver.OnShareCompleted(1, flattenToString);
        this.sentShareResult = true;
        shareIntent.setFlags(268435456);
        shareIntent.setComponent(componentName);
        startActivity(shareIntent);
    }
}

// ===== FILE: com/yasirkula/unity/NativeShareCustomShareDialogActivity.java =====
package com.yasirkula.unity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/* loaded from: classes.dex */
public class NativeShareCustomShareDialogActivity extends Activity {
    private boolean dialogDisplayed;

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(C1286R.layout.native_share_custom_dialog_holder);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (!this.dialogDisplayed) {
            this.dialogDisplayed = true;
            NativeShareCustomShareDialog nativeShareCustomShareDialog = new NativeShareCustomShareDialog();
            nativeShareCustomShareDialog.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(0, nativeShareCustomShareDialog).commitAllowingStateLoss();
            return;
        }
        finish();
    }
}

// ===== FILE: com/yasirkula/unity/NativeShareFragment.java =====
package com.yasirkula.unity;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NativeShareFragment extends Fragment {
    public static final String EMAIL_RECIPIENTS_ID = "NS_EMAIL_RECIPIENTS";
    public static final String FILES_ID = "NS_FILES";
    public static final String MIMES_ID = "NS_MIMES";
    private static final int SHARE_RESULT_CODE = 774457;
    public static final String SUBJECT_ID = "NS_SUBJECT";
    public static final String TARGET_CLASS_ID = "NS_TARGET_CLASS";
    public static final String TARGET_PACKAGE_ID = "NS_TARGET_PACKAGE";
    public static final String TEXT_ID = "NS_TEXT";
    public static final String TITLE_ID = "NS_TITLE";

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (NativeShare.shareResultReceiver == null) {
            onActivityResult(SHARE_RESULT_CODE, 0, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Intent CreateIntentFromBundle = NativeShare.CreateIntentFromBundle(getActivity(), getArguments(), arrayList);
        String string = getArguments().getString(TITLE_ID);
        CreateIntentFromBundle.setFlags(268435456);
        try {
            Intent createChooser = Intent.createChooser(CreateIntentFromBundle, string, NativeShareBroadcastListener.Initialize(getActivity()));
            if (arrayList.size() > 0) {
                NativeShare.GrantURIPermissionsToShareIntentTargets(getActivity(), getActivity().getPackageManager().queryIntentActivities(createChooser, 65536), arrayList);
            }
            startActivityForResult(createChooser, SHARE_RESULT_CODE);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getActivity(), "No apps can perform this action.", 1).show();
            onActivityResult(SHARE_RESULT_CODE, 0, null);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != SHARE_RESULT_CODE) {
            return;
        }
        if (NativeShare.shareResultReceiver != null) {
            StringBuilder sb = new StringBuilder("Reported share result (may not be correct): ");
            sb.append(resultCode == -1);
            Log.d("Unity", sb.toString());
            if (resultCode == -1) {
                NativeShare.shareResultReceiver.OnShareCompleted(1, "");
            } else {
                NativeShare.shareResultReceiver.OnShareCompleted(2, "");
            }
        } else {
            Log.e("Unity", "NativeShareResultReceiver was null!");
        }
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }
}

// ===== FILE: com/yasirkula/unity/NativeShareResultReceiver.java =====
package com.yasirkula.unity;

/* loaded from: classes.dex */
public interface NativeShareResultReceiver {
    boolean HasManagedCallback();

    void OnShareCompleted(int result, String shareTarget);
}
