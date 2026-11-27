
// ===== FILE: net/codestage/actk/androidnative/ACTkAndroidRoutines.java =====
package net.codestage.actk.androidnative;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ACTkAndroidRoutines {
    public static long GetSystemCurrentTimeMs() {
        return System.currentTimeMillis();
    }

    public static long GetSystemNanoTimeMs() {
        return TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public static long GetSystemNanoTime() {
        return System.nanoTime();
    }

    public static String GetPackageInstallerName() throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, PackageManager.NameNotFoundException {
        String installerPackageName;
        Context GetApplicationContext = NativeUtils.GetApplicationContext();
        if (GetApplicationContext == null) {
            return null;
        }
        PackageManager packageManager = GetApplicationContext.getPackageManager();
        String packageName = GetApplicationContext.getPackageName();
        if (Build.VERSION.SDK_INT >= 30) {
            installerPackageName = packageManager.getInstallSourceInfo(packageName).getInstallingPackageName();
        } else {
            installerPackageName = packageManager.getInstallerPackageName(packageName);
        }
        return installerPackageName == null ? "" : installerPackageName;
    }
}

// ===== FILE: net/codestage/actk/androidnative/ACTkErrors.java =====
package net.codestage.actk.androidnative;

/* loaded from: classes2.dex */
class ACTkErrors {
    static final String APKReadError = "[CodeHashGenerator ERROR] Can't read APK with path: ";
    private static final String ErrorPrefix = "[CodeHashGenerator ERROR] ";
    static final String NoApkFile = "[CodeHashGenerator ERROR] Can't create file for APK path: ";
    static final String NoApkFolder = "[CodeHashGenerator ERROR] Can't find parent folder of APK file at path: ";
    static final String NoApkPath = "[CodeHashGenerator ERROR] Can't get APK path!";
    static final String NoApplicationInfo = "[CodeHashGenerator ERROR] Couldn't get ApplicationInfo!";
    static final String NoContext = "[CodeHashGenerator ERROR] Couldn't get Unity context!";
    static final String NoFilePath = "[CodeHashGenerator ERROR] Can't get path for file in APK folder!";
    static final String NoFilesInApkFolder = "[CodeHashGenerator ERROR] Can't get any files in APK folder at path: ";
    static final String NoJarEntries = "[CodeHashGenerator ERROR] Nothing found in APK JAR!";
    static final String NoPackageManager = "[CodeHashGenerator ERROR] Couldn't get package manager!";
    static final String NoPackageName = "[CodeHashGenerator ERROR] Couldn't get package name!";
    static final String NoSHA1Digest = "[CodeHashGenerator ERROR] Can't get SHA-1 digest instance!";
    static final String NoUnityActivity = "[CodeHashGenerator ERROR] Couldn't get Activity from com.unity3d.player.UnityPlayer:currentActivity field!";
    static final String NoUnityClass = "[CodeHashGenerator ERROR] Couldn't get com.unity3d.player.UnityPlayer class!";
    static final String NoUnityField = "[CodeHashGenerator ERROR] Couldn't get com.unity3d.player.UnityPlayer:currentActivity field!";
    static final String NothingToHash = "[CodeHashGenerator ERROR] Nothing to hash!";
    static final String NullJarEntry = "[CodeHashGenerator ERROR] Some JAR entry is null!";
    static final String NullJarEntryPath = "[CodeHashGenerator ERROR] Some JAR entry has null path!";
    static final String NullJarInputStream = "[CodeHashGenerator ERROR] JAR has null input stream for entry with path: ";

    ACTkErrors() {
    }

    static String GetText(String str) {
        return ErrorPrefix + str;
    }
}

// ===== FILE: net/codestage/actk/androidnative/C1432R.java =====
package net.codestage.actk.androidnative;

/* renamed from: net.codestage.actk.androidnative.R */
/* loaded from: classes2.dex */
public final class C1432R {

    /* renamed from: net.codestage.actk.androidnative.R$string */
    public static final class string {
        public static final int app_name = 2131623970;

        private string() {
        }
    }

    private C1432R() {
    }
}

// ===== FILE: net/codestage/actk/androidnative/CodeHashCallback.java =====
package net.codestage.actk.androidnative;

/* loaded from: classes2.dex */
public interface CodeHashCallback {
    void OnError(String str);

    void OnSuccess(String str, String[] strArr, String[] strArr2, String str2);
}

// ===== FILE: net/codestage/actk/androidnative/CodeHashGenerator.java =====
package net.codestage.actk.androidnative;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import net.codestage.actk.androidnative.CodeHashGenerator;

/* loaded from: classes2.dex */
public class CodeHashGenerator {

    /* JADX INFO: Access modifiers changed from: private */
    static class HashCalculationResult {
        String buildPath;
        String errorText;
        String[] hashes;
        String[] paths;
        String summaryHash;

        private HashCalculationResult() {
        }
    }

    public static void GetCodeHash(final String[] strArr, final CodeHashCallback codeHashCallback, final int i) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        final ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(newSingleThreadExecutor);
        final Handler handler = new Handler(Looper.getMainLooper());
        executorCompletionService.submit(new Callable() { // from class: net.codestage.actk.androidnative.CodeHashGenerator$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CodeHashGenerator.lambda$GetCodeHash$0(strArr, i);
            }
        });
        newSingleThreadExecutor.shutdown();
        new Thread(new Runnable() { // from class: net.codestage.actk.androidnative.CodeHashGenerator$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CodeHashGenerator.lambda$GetCodeHash$2(executorCompletionService, handler, codeHashCallback);
            }
        }).start();
    }

    static /* synthetic */ HashCalculationResult lambda$GetCodeHash$0(String[] strArr, int i) throws Exception {
        try {
            return GetCodeHashThread(FilteringData.CreateFromFilters(strArr), i);
        } catch (Throwable th) {
            HashCalculationResult hashCalculationResult = new HashCalculationResult();
            hashCalculationResult.errorText = ACTkErrors.GetText("Something went wrong while trying to hash current APK: " + th);
            Log.e(NativeUtils.LogTag, hashCalculationResult.errorText, th);
            return hashCalculationResult;
        }
    }

    static /* synthetic */ void lambda$GetCodeHash$2(CompletionService completionService, Handler handler, final CodeHashCallback codeHashCallback) {
        try {
            final HashCalculationResult hashCalculationResult = (HashCalculationResult) completionService.take().get();
            handler.post(new Runnable() { // from class: net.codestage.actk.androidnative.CodeHashGenerator$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    CodeHashGenerator.lambda$GetCodeHash$1(CodeHashGenerator.HashCalculationResult.this, codeHashCallback);
                }
            });
        } catch (InterruptedException | ExecutionException e) {
            Log.e(NativeUtils.LogTag, "Not all tasks completed within the specified timeout!", e);
        }
    }

    static /* synthetic */ void lambda$GetCodeHash$1(HashCalculationResult hashCalculationResult, CodeHashCallback codeHashCallback) {
        if (hashCalculationResult.errorText != null) {
            codeHashCallback.OnError(hashCalculationResult.errorText);
        } else {
            codeHashCallback.OnSuccess(hashCalculationResult.buildPath, hashCalculationResult.paths, hashCalculationResult.hashes, hashCalculationResult.summaryHash);
        }
    }

    private static HashCalculationResult GetCodeHashThread(FilteringData filteringData, int i) throws ClassNotFoundException, PackageManager.NameNotFoundException, NoSuchFieldException, IllegalAccessException, IOException {
        HashCalculationResult hashCalculationResult = new HashCalculationResult();
        String GetApkPath = NativeUtils.GetApkPath();
        if (GetApkPath == null) {
            hashCalculationResult.errorText = "[CodeHashGenerator ERROR] Can't get APK path!";
            Log.e(NativeUtils.LogTag, hashCalculationResult.errorText);
            return hashCalculationResult;
        }
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(GetApkPath);
        if (!file.exists()) {
            hashCalculationResult.errorText = ACTkErrors.GetText("[CodeHashGenerator ERROR] Can't create file for APK path: " + GetApkPath);
            Log.e(NativeUtils.LogTag, hashCalculationResult.errorText);
            return hashCalculationResult;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            Log.w(NativeUtils.LogTag, "[CodeHashGenerator ERROR] Can't find parent folder of APK file at path: ");
            arrayList.add(GetApkPath);
        } else {
            File[] listFiles = parentFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                Log.w(NativeUtils.LogTag, "[CodeHashGenerator ERROR] Can't get any files in APK folder at path: ");
                arrayList.add(GetApkPath);
            } else {
                for (File file2 : listFiles) {
                    String path = file2.getPath();
                    if (path.equals("")) {
                        Log.w(NativeUtils.LogTag, "[CodeHashGenerator ERROR] Can't get path for file in APK folder!");
                    } else if (path.toLowerCase().endsWith(".apk")) {
                        arrayList.add(path);
                    }
                }
            }
        }
        hashCalculationResult.buildPath = GetApkPath;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : arrayList) {
            JarFile GetJarFromApk = GetJarFromApk(str);
            if (GetJarFromApk == null) {
                hashCalculationResult.errorText = ACTkErrors.GetText("[CodeHashGenerator ERROR] Can't read APK with path: " + str);
                Log.e(NativeUtils.LogTag, hashCalculationResult.errorText);
                return hashCalculationResult;
            }
            HashFiles(GetJarFromApk, filteringData, arrayList2, arrayList3, i);
        }
        if (arrayList3.size() == 0) {
            hashCalculationResult.errorText = ACTkErrors.GetText("[CodeHashGenerator ERROR] Nothing to hash!");
            Log.e(NativeUtils.LogTag, hashCalculationResult.errorText);
            return hashCalculationResult;
        }
        hashCalculationResult.buildPath = GetApkPath;
        hashCalculationResult.hashes = (String[]) arrayList3.toArray(new String[0]);
        hashCalculationResult.paths = (String[]) arrayList2.toArray(new String[0]);
        hashCalculationResult.summaryHash = GetArrayHash(arrayList3);
        return hashCalculationResult;
    }

    private static JarFile GetJarFromApk(String str) throws IOException {
        if (new File(str).exists()) {
            return new JarFile(str);
        }
        return null;
    }

    private static void HashFiles(final JarFile jarFile, FilteringData filteringData, List<String> list, List<String> list2, int i) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i);
        ArrayList arrayList = new ArrayList();
        Enumeration<JarEntry> entries = jarFile.entries();
        if (entries == null) {
            Log.e(NativeUtils.LogTag, "[CodeHashGenerator ERROR] Nothing found in APK JAR!");
            return;
        }
        for (final JarEntry jarEntry : Collections.list(entries)) {
            if (jarEntry == null) {
                Log.w(NativeUtils.LogTag, "[CodeHashGenerator ERROR] Some JAR entry is null!");
            } else {
                final String name = jarEntry.getName();
                if (name == null) {
                    Log.w(NativeUtils.LogTag, "[CodeHashGenerator ERROR] Some JAR entry has null path!");
                } else if (!filteringData.IsIgnored(name) && filteringData.IsIncluded(name)) {
                    arrayList.add(newFixedThreadPool.submit(new Callable() { // from class: net.codestage.actk.androidnative.CodeHashGenerator$$ExternalSyntheticLambda2
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return CodeHashGenerator.lambda$HashFiles$3(jarFile, jarEntry, name);
                        }
                    }));
                }
            }
        }
        newFixedThreadPool.shutdown();
        try {
            if (!newFixedThreadPool.awaitTermination(1L, TimeUnit.HOURS)) {
                Log.e(NativeUtils.LogTag, "Not all tasks completed within the specified timeout");
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    Map map = (Map) ((Future) it.next()).get();
                    if (map != null) {
                        list.add((String) map.get("path"));
                        list2.add((String) map.get("hash"));
                    }
                } catch (InterruptedException | ExecutionException e) {
                    Log.e(NativeUtils.LogTag, "Error while processing file", e);
                }
            }
        } catch (InterruptedException unused) {
            Log.e(NativeUtils.LogTag, "Interrupted while waiting for tasks to complete");
        }
    }

    static /* synthetic */ Map lambda$HashFiles$3(JarFile jarFile, JarEntry jarEntry, String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
        byte[] bArr = new byte[8192];
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        if (inputStream == null) {
            Log.w(NativeUtils.LogTag, "[CodeHashGenerator ERROR] JAR has null input stream for entry with path: " + str);
            return null;
        }
        int i = 0;
        while (i != -1) {
            i = inputStream.read(bArr);
            if (i > 0) {
                messageDigest.update(bArr, 0, i);
            }
        }
        String BytesToHex = NativeUtils.BytesToHex(messageDigest.digest());
        HashMap hashMap = new HashMap();
        hashMap.put("path", str);
        hashMap.put("hash", BytesToHex);
        messageDigest.reset();
        inputStream.close();
        return hashMap;
    }

    public static String GetArrayHash(List<String> list) {
        int size;
        if (list == null || (size = list.size()) == 0) {
            return "";
        }
        int length = list.get(0).length();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            bArr[i] = list.get(i).getBytes(StandardCharsets.UTF_8);
        }
        int i2 = length / 2;
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            byte b = 0;
            for (int i4 = 0; i4 < size; i4++) {
                byte[] bArr3 = bArr[i4];
                b = (byte) (b ^ ((byte) (bArr3[i3 + 1] | (bArr3[i3] << 4))));
            }
            bArr2[i3 / 2] = b;
        }
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < i2; i5++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr2[i5])));
        }
        return sb.toString().toUpperCase().substring(0, length);
    }
}

// ===== FILE: net/codestage/actk/androidnative/FileFilter.java =====
package net.codestage.actk.androidnative;

import android.util.Log;
import java.io.File;
import java.util.Locale;

/* loaded from: classes2.dex */
class FileFilter {
    private Boolean caseSensitive;
    private Boolean exactFileNameMatch;
    private Boolean exactPathMatch;
    private String filterExtension;
    private String filterFileName;
    private String filterPath;
    private Boolean pathRecursive;

    FileFilter(String str) {
        if (str == null || str.isEmpty()) {
            Log.e(NativeUtils.LogTag, "Can't parse FileFilter: string is null or empty!");
            return;
        }
        String[] split = str.split("\\|");
        if (split.length < 4) {
            Log.e(NativeUtils.LogTag, "Can't parse FileFilter: string split only to " + split.length + " parts instead of minimum 4 parts!");
            return;
        }
        this.caseSensitive = Boolean.valueOf(Boolean.parseBoolean(split[0]));
        this.pathRecursive = Boolean.valueOf(Boolean.parseBoolean(split[1]));
        this.exactFileNameMatch = Boolean.valueOf(Boolean.parseBoolean(split[2]));
        this.exactPathMatch = Boolean.valueOf(Boolean.parseBoolean(split[3]));
        if (split.length >= 5) {
            this.filterPath = split[4];
        }
        if (split.length >= 6) {
            this.filterExtension = split[5];
        }
        if (split.length >= 7) {
            this.filterFileName = split[6];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
    
        if (r5.filterExtension.equalsIgnoreCase(r6) == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean MatchPath(String str) {
        String str2;
        String str3;
        File file = new File(str);
        String str4 = this.filterExtension;
        if ((str4 == null || str4.isEmpty()) && (((str2 = this.filterFileName) == null || str2.isEmpty()) && ((str3 = this.filterPath) == null || str3.isEmpty()))) {
            return false;
        }
        String str5 = this.filterExtension;
        if (str5 != null && !str5.isEmpty()) {
            String name = file.getName();
            if (!name.isEmpty() && name.indexOf(".") > 0) {
                String substring = name.substring(name.lastIndexOf(".") + 1);
                if (substring.isEmpty()) {
                    return false;
                }
                if (this.caseSensitive.booleanValue()) {
                    if (!this.filterExtension.equals(substring)) {
                        return false;
                    }
                }
            }
            return false;
        }
        String str6 = this.filterFileName;
        if (str6 != null && !str6.isEmpty()) {
            String name2 = file.getName();
            if (name2.isEmpty()) {
                return false;
            }
            if (name2.indexOf(".") > 0) {
                name2 = name2.substring(0, name2.lastIndexOf("."));
            }
            if (this.exactFileNameMatch.booleanValue()) {
                if ((this.caseSensitive.booleanValue() && !name2.equals(this.filterFileName)) || !name2.equalsIgnoreCase(this.filterFileName)) {
                    return false;
                }
            } else if ((this.caseSensitive.booleanValue() && !name2.contains(this.filterFileName)) || !NativeUtils.ContainsIgnoreCase(name2, this.filterFileName)) {
                return false;
            }
        }
        String str7 = this.filterPath;
        if (str7 != null && !str7.isEmpty()) {
            String path = file.getPath();
            if (path.isEmpty()) {
                return false;
            }
            if (this.exactPathMatch.booleanValue()) {
                if ((this.caseSensitive.booleanValue() && !path.equals(this.filterPath)) || !path.equalsIgnoreCase(this.filterPath)) {
                    return false;
                }
            } else if (!PathMatch(path, this.filterPath, this.pathRecursive.booleanValue(), !this.caseSensitive.booleanValue())) {
                return false;
            }
        }
        return true;
    }

    private static boolean PathMatch(String str, String str2, boolean z, boolean z2) {
        if (z) {
            return (!z2 || NativeUtils.ContainsIgnoreCase(str, str2)) && str.contains(str2);
        }
        int indexOf = z2 ? str.toLowerCase(Locale.US).indexOf(str2.toLowerCase(Locale.US)) : str.indexOf(str2);
        if (indexOf == -1) {
            return false;
        }
        int indexOf2 = str.indexOf(47, str2.length() + indexOf);
        return indexOf2 == -1 || indexOf2 <= indexOf;
    }

    String ToString() {
        return "caseSensitive: " + this.caseSensitive + ", pathRecursive: " + this.pathRecursive + ", exactFileNameMatch: " + this.exactFileNameMatch + ", exactPathMatch: " + this.exactPathMatch + ", filterPath: " + this.filterPath + ", filterExtension: " + this.filterExtension + ", filterFileName: " + this.filterFileName;
    }
}

// ===== FILE: net/codestage/actk/androidnative/FilteringData.java =====
package net.codestage.actk.androidnative;

import java.util.ArrayList;

/* loaded from: classes2.dex */
class FilteringData {
    private final FileFilter[] ignores;
    private final FileFilter[] includes;

    public static FilteringData CreateFromFilters(String[] strArr) {
        if (strArr == null) {
            return new FilteringData(null, null);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        for (String str : strArr) {
            if (str.equals("IGNORES")) {
                z = true;
            } else if (z) {
                arrayList2.add(str);
            } else {
                arrayList.add(str);
            }
        }
        return new FilteringData(GetFiltersFromStrings((String[]) arrayList.toArray(new String[arrayList.size()])), GetFiltersFromStrings((String[]) arrayList2.toArray(new String[arrayList2.size()])));
    }

    private static FileFilter[] GetFiltersFromStrings(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        FileFilter[] fileFilterArr = new FileFilter[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            fileFilterArr[i] = new FileFilter(strArr[i]);
        }
        return fileFilterArr;
    }

    public FilteringData(FileFilter[] fileFilterArr, FileFilter[] fileFilterArr2) {
        this.includes = fileFilterArr;
        this.ignores = fileFilterArr2;
    }

    public boolean IsIncluded(String str) {
        FileFilter[] fileFilterArr = this.includes;
        if (fileFilterArr == null || fileFilterArr.length == 0) {
            return false;
        }
        return IsPathMatchesFilters(str, fileFilterArr);
    }

    public boolean IsIgnored(String str) {
        FileFilter[] fileFilterArr = this.ignores;
        if (fileFilterArr == null || fileFilterArr.length == 0) {
            return false;
        }
        return IsPathMatchesFilters(str, fileFilterArr);
    }

    private boolean IsPathMatchesFilters(String str, FileFilter[] fileFilterArr) {
        for (FileFilter fileFilter : fileFilterArr) {
            if (fileFilter.MatchPath(str)) {
                return true;
            }
        }
        return false;
    }
}

// ===== FILE: net/codestage/actk/androidnative/NativeUtils.java =====
package net.codestage.actk.androidnative;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
class NativeUtils {
    static String LogTag = "ACTk";
    private static Context cachedApplicationContext;
    private static final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    NativeUtils() {
    }

    static String BytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] ^ 144) & 255;
            int i3 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    static String GetApkPath() throws PackageManager.NameNotFoundException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        GetApplicationContext();
        Context context = cachedApplicationContext;
        if (context == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get Unity context!");
            return null;
        }
        String packageName = context.getPackageName();
        if (packageName == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get package name!");
            return null;
        }
        PackageManager packageManager = cachedApplicationContext.getPackageManager();
        if (packageManager == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get package manager!");
            return null;
        }
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
        if (applicationInfo == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get ApplicationInfo!");
            return null;
        }
        return applicationInfo.publicSourceDir;
    }

    static boolean ContainsIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }

    static Context GetApplicationContext() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Context context = cachedApplicationContext;
        if (context != null) {
            return context;
        }
        Class<?> cls = Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
        if (cls == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get com.unity3d.player.UnityPlayer class!");
            return null;
        }
        Field declaredField = cls.getDeclaredField("currentActivity");
        if (declaredField == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get com.unity3d.player.UnityPlayer:currentActivity field!");
            return null;
        }
        Activity activity = (Activity) declaredField.get(null);
        if (activity == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get Activity from com.unity3d.player.UnityPlayer:currentActivity field!");
            return null;
        }
        Context applicationContext = activity.getApplicationContext();
        cachedApplicationContext = applicationContext;
        return applicationContext;
    }
}
