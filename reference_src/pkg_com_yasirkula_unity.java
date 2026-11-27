// Package bundle: com.yasirkula.unity (14 classes)

// ============================================================
// CLASS: com.yasirkula.unity.NativeShare
// ============================================================
package com.yasirkula.unity;

public class NativeShare {
    public static boolean alwaysUseCustomShareDialog;
    public static String authority;
    private static int isXiaomiOrMIUI;
    public static NativeShareResultReceiver shareResultReceiver;

    static <clinit>() {
        return;
    }

    public NativeShare() {
        new Object();
        return;
    }

    private static ArrayList ConvertArrayToArrayList(String[] p0) {
        new ArrayList(v1);
      L_7:
        if (if-ge(0, v2)) goto L_12;
        new ArrayList(..).add(v2);
      L_12:
        return new ArrayList(..);
    }

    public static Intent CreateIntentFromBundle(Context p0, Bundle p1, ArrayList p2) {
        p1.getString("NS_SUBJECT");
        p1.getString("NS_TEXT");
        p1.getString("NS_TITLE");
        p1.getStringArrayList("NS_FILES");
        p1.getStringArrayList("NS_MIMES");
        p1.getStringArrayList("NS_EMAIL_RECIPIENTS");
        p1.getStringArrayList("NS_TARGET_PACKAGE");
        p1.getStringArrayList("NS_TARGET_CLASS");
        new Intent();
        Bundle.getString(..).length();
        if (if-lez(String.length(..))) goto L_46;
        new Intent(..).putExtra("android.intent.extra.SUBJECT", Bundle.getString(..));
      L_46:
        Bundle.getString(..).length();
        if (if-lez(String.length(..))) goto L_51;
        new Intent(..).putExtra("android.intent.extra.TEXT", Bundle.getString(..));
      L_51:
        Bundle.getStringArrayList(..).size();
        if (if-lez(ArrayList.size(..))) goto L_15b;
      L_5d:
        Bundle.getStringArrayList(..).size();
        if (if-ge(0, ArrayList.size(..))) goto L_fb;
        Bundle.getStringArrayList(..).get(0);
        ArrayList.get(..).length();
        if (if-lez(String.length(..))) goto L_78;
        Bundle.getStringArrayList(..).get(0);
      L_78:
        Bundle.getStringArrayList(..).get(0);
        ArrayList.get(..).lastIndexOf(46);
        if (if-ltz(String.lastIndexOf(..))) goto L_f8;
        Bundle.getStringArrayList(..).get(0);
        ArrayList.get(..).length();
        if (if-ne(String.lastIndexOf(..), String.length(..))) goto L_95;
      L_95:
        MimeTypeMap.getSingleton();
        Bundle.getStringArrayList(..).get(0);
        ArrayList.get(..).substring(String.lastIndexOf(..));
        String.substring(..).toLowerCase(Locale.ENGLISH);
        MimeTypeMap.getSingleton(..).getMimeTypeFromExtension(String.toLowerCase(..));
      L_b1:
        if (if-eqz(MimeTypeMap.getMimeTypeFromExtension(..))) goto L_f8;
        String.length();
        if (if-nez(String.length(..))) goto L_ba;
      L_ba:
        String.indexOf(47);
        if (if-lez(String.indexOf(..))) goto L_f8;
        String.length();
        if (if-ne(String.indexOf(..), String.length(..))) goto L_cd;
      L_cd:
        String.substring(0, String.indexOf(..));
        String.substring(String.indexOf(..));
        if (if-nez(0)) goto L_de;
      L_de:
        String.substring(..).equals(String.substring(..));
        if (if-nez(String.equals(..))) goto L_e5;
      L_e5:
        if (if-nez(0)) goto L_e9;
      L_e9:
        String.substring(..).equals(String.substring(..));
        if (if-nez(String.equals(..))) goto L_f1;
      L_f1:
      L_f8:
      L_fb:
        new StringBuilder();
        new StringBuilder(..).append("*");
        new StringBuilder(..).append("/");
        new StringBuilder(..).append("*");
        new StringBuilder(..).toString();
        Bundle.getStringArrayList(..).size();
        if (if-ne(ArrayList.size(..), 1)) goto L_134;
        new Intent(..).setAction("android.intent.action.SEND");
        Bundle.getStringArrayList(..).get(0);
        new File(ArrayList.get(..));
        NativeShareContentProvider.getUriForFile(p0, NativeShare.authority, new File(..));
        p2.add(NativeShareContentProvider.getUriForFile(..));
        new Intent(..).putExtra("android.intent.extra.STREAM", NativeShareContentProvider.getUriForFile(..));
      L_134:
        new Intent(..).setAction("android.intent.action.SEND_MULTIPLE");
      L_13a:
        ArrayList.get(..).size();
        if (if-ge(0, ArrayList.size(..))) goto L_157;
        ArrayList.get(..).get(0);
        new File(ArrayList.get(..));
        NativeShareContentProvider.getUriForFile(NativeShareContentProvider.getUriForFile(..), NativeShare.authority, new File(..));
        p2.add(NativeShareContentProvider.getUriForFile(..));
      L_157:
        new Intent(..).putParcelableArrayListExtra("android.intent.extra.STREAM", p2);
      L_15b:
        new Intent(..).setAction(NativeShareContentProvider.getUriForFile(..));
      L_160:
        Bundle.getStringArrayList(..).size();
        if (if-lez(ArrayList.size(..))) goto L_174;
        Bundle.getStringArrayList(..).size();
        Bundle.getStringArrayList(..).toArray(ArrayList.size(..));
        new Intent(..).putExtra("android.intent.extra.EMAIL", ArrayList.size(..));
      L_174:
        Bundle.getString(..).length();
        if (if-lez(String.length(..))) goto L_17f;
        new Intent(..).putExtra("android.intent.extra.TITLE", Bundle.getString(..));
      L_17f:
        new Intent(..).setType("text/plain");
        new Intent(..).setFlags(1);
        Bundle.getStringArrayList(..).size();
        if (if-ne(ArrayList.size(..), 1)) goto L_1b1;
        Bundle.getStringArrayList(..).get(0);
        new Intent(..).setPackage(ArrayList.get(..));
        Bundle.getStringArrayList(..).get(0);
        ArrayList.get(..).length();
        if (if-lez(String.length(..))) goto L_1b1;
        Bundle.getStringArrayList(..).get(0);
        Bundle.getStringArrayList(..).get(0);
        new Intent(..).setClassName(ArrayList.get(..), ArrayList.get(..));
      L_1b1:
        return new Intent(..);
    }

    public static String FindMatchingTarget(Context p0, String p1, String p2) {
        p0.getPackageManager();
        Context.getPackageManager(..).getInstalledPackages(1);
        if (if-eqz(PackageManager.getInstalledPackages(..))) goto L_6c;
        Pattern.compile(p1);
        p2.length();
        if (if-lez(String.length(..))) goto L_1a;
        Pattern.compile(p2);
      L_1a:
      L_1b:
        List.iterator();
      L_1f:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_6c;
        List.iterator(..).next();
        Pattern.compile(..).matcher(packageName);
        Pattern.matcher(..).find();
        if (if-eqz(Matcher.find(..))) goto L_1f;
        if (if-eqz(activities)) goto L_1f;
      L_3d:
        if (if-ge(0, v2)) goto L_1f;
        if (if-eqz(0)) goto L_53;
        0.matcher(name);
        Pattern.matcher(..).find();
        if (if-eqz(Matcher.find(..))) goto L_50;
      L_50:
      L_53:
        new StringBuilder();
        new StringBuilder(..).append(packageName);
        new StringBuilder(..).append(">");
        new StringBuilder(..).append(name);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
      L_6c:
        return "";
    }

    private static String GetAuthority(Context p0) {
        if (if-nez(NativeShare.authority)) goto L_5a;
        p0.getPackageManager();
        p0.getPackageName();
        Context.getPackageManager(..).getPackageInfo(Context.getPackageName(..), 8);
        if (if-eqz(providers)) goto L_5a;
      L_18:
        if (if-ge(0, Context.getPackageName(..))) goto L_5a;
        if (if-eqz(name)) goto L_4f;
        if (if-eqz(packageName)) goto L_4f;
        if (if-eqz(authority)) goto L_4f;
        NativeShareContentProvider.class.getName();
        name.equals(Class.getName(..));
        if (if-eqz(String.equals(..))) goto L_4f;
        p0.getPackageName();
        packageName.equals(Context.getPackageName(..));
        if (if-eqz(String.equals(..))) goto L_4f;
        authority.length();
        if (if-lez(String.length(..))) goto L_4f;
        authority = authority;
      L_4f:
        Log.e("Unity", "Exception:", authority);
      L_5a:
        return NativeShare.authority;
    }

    public static void GrantURIPermissionsToShareIntentTargets(Context p0, List p1, ArrayList p2) {
        p1.size();
      L_6:
        if (if-ltz(List.size(..))) goto L_30;
        p2.size();
      L_d:
        if (if-ltz(ArrayList.size(..))) goto L_25;
        p1.get(List.size(..));
        p2.get(ArrayList.size(..));
        p0.grantUriPermission(packageName, ArrayList.get(..), 1);
      L_25:
        Log.e("Unity", "NativeShare couldn't call grantUriPermission:", p0);
      L_30:
        return;
    }

    private static boolean IsUnityInLandscapeMode(Activity p0) {
        p0.getResources();
        Activity.getResources(..).getConfiguration();
        if (if-ne(orientation, 2)) goto L_f;
      L_f:
      L_10:
        return 0;
    }

    private static boolean IsXiaomiOrMIUI() {
        if (if-lez(NativeShare.isXiaomiOrMIUI)) goto L_6;
        return 1;
      L_6:
        if (if-gez(NativeShare.isXiaomiOrMIUI)) goto L_a;
        return 0;
      L_a:
        "xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
        if (if-eqz(String.equalsIgnoreCase(..))) goto L_17;
        isXiaomiOrMIUI = 1;
        return 1;
      L_17:
        Runtime.getRuntime();
        Runtime.getRuntime(..).exec("getprop ro.miui.ui.version.name");
        Runtime.exec(..).getInputStream();
        new InputStreamReader(Process.getInputStream(..));
        new BufferedReader(new InputStreamReader(..), 1024);
        new BufferedReader(..).readLine();
        if (if-eqz(BufferedReader.readLine(..))) goto L_45;
        BufferedReader.readLine(..).length();
        if (if-lez(String.length(..))) goto L_45;
        isXiaomiOrMIUI = 1;
        new BufferedReader(..).close();
        return 1;
      L_45:
        isXiaomiOrMIUI = -1;
        new BufferedReader(..).close();
        return 0;
      L_52:
        isXiaomiOrMIUI = -1;
        if (if-eqz(new BufferedReader(..))) goto L_59;
        new BufferedReader(..).close();
      L_59:
        return 0;
      L_5a:
        if (if-eqz(new BufferedReader(..))) goto L_5f;
        new BufferedReader(..).close();
      L_5f:
        throw -1;
    }

    public static void Share(Context p0, NativeShareResultReceiver p1, String[] p2, String[] p3, String[] p4, String[] p5, String[] p6, String p7, String p8, String p9) {
        if (if-lez(v0)) goto L_17;
        NativeShare.GetAuthority(p0);
        if (if-nez(NativeShare.GetAuthority(..))) goto L_17;
        Log.e("Unity", "Can't find ContentProvider, share not possible!");
        p1.OnShareCompleted(2, "");
        return;
      L_17:
        shareResultReceiver = p1;
        new Bundle();
        new Bundle(..).putString("NS_SUBJECT", p7);
        new Bundle(..).putString("NS_TEXT", p8);
        new Bundle(..).putString("NS_TITLE", p9);
        NativeShare.ConvertArrayToArrayList(p4);
        new Bundle(..).putStringArrayList("NS_FILES", NativeShare.ConvertArrayToArrayList(..));
        NativeShare.ConvertArrayToArrayList(p5);
        new Bundle(..).putStringArrayList("NS_MIMES", NativeShare.ConvertArrayToArrayList(..));
        NativeShare.ConvertArrayToArrayList(p6);
        new Bundle(..).putStringArrayList("NS_EMAIL_RECIPIENTS", NativeShare.ConvertArrayToArrayList(..));
        NativeShare.ConvertArrayToArrayList("");
        new Bundle(..).putStringArrayList("NS_TARGET_PACKAGE", NativeShare.ConvertArrayToArrayList(..));
        NativeShare.ConvertArrayToArrayList(p3);
        new Bundle(..).putStringArrayList("NS_TARGET_CLASS", NativeShare.ConvertArrayToArrayList(..));
        if (if-nez(NativeShare.alwaysUseCustomShareDialog)) goto L_66;
        if (if-le("", 1)) goto L_64;
      L_64:
      L_66:
      L_67:
        if (if-nez(1)) goto L_7a;
        p1.HasManagedCallback();
        if (if-eqz(NativeShareResultReceiver.HasManagedCallback(..))) goto L_7a;
        "huawei".equalsIgnoreCase(Build.MANUFACTURER);
        if (if-eqz(String.equalsIgnoreCase(..))) goto L_7a;
      L_7a:
        if (if-nez(1)) goto L_92;
        NativeShare.IsXiaomiOrMIUI();
        if (if-eqz(NativeShare.IsXiaomiOrMIUI(..))) goto L_92;
        if (if-eq(Build$VERSION.SDK_INT, 30)) goto L_93;
        NativeShare.IsUnityInLandscapeMode(2);
        if (if-eqz(NativeShare.IsUnityInLandscapeMode(..))) goto L_92;
      L_92:
      L_93:
        if (if-eqz(1)) goto L_ad;
        Log.d("Unity", "Creating custom share dialog");
        new Intent(2, NativeShareCustomShareDialogActivity.class);
        new Intent(..).putExtras(new Bundle(..));
        new Intent(..).setFlags(2.0f);
        2.startActivity(new Intent(..));
      L_ad:
        Log.d("Unity", "Creating standard share dialog");
        new NativeShareFragment();
        new NativeShareFragment(..).setArguments(new Bundle(..));
        2.getFragmentManager();
        Activity.getFragmentManager(..).beginTransaction();
        FragmentManager.beginTransaction(..).add(0, new NativeShareFragment(..));
        FragmentTransaction.add(..).commitAllowingStateLoss();
      L_cb:
        return;
    }

    public static boolean TargetExists(Context p0, String p1, String p2) {
        p2.length();
        if (if-nez(String.length(..))) goto L_10;
        p0.getPackageManager();
        Context.getPackageManager(..).getPackageInfo(p1, 0);
        return 1;
      L_10:
        Context.getPackageManager(..).getPackageManager();
        Context.getPackageManager(..).getPackageInfo(p1, 1);
        if (if-eqz(activities)) goto L_2e;
      L_1e:
        if (if-ge(0, p1)) goto L_2e;
        name.equals(p2);
        if (if-eqz(String.equals(..))) goto L_2b;
        return 1;
      L_2b:
      L_2e:
        return 0;
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareBroadcastListener
// ============================================================
package com.yasirkula.unity;

public class NativeShareBroadcastListener extends BroadcastReceiver {
    public NativeShareBroadcastListener() {
        new BroadcastReceiver();
        return;
    }

    public static IntentSender Initialize(Context p0) {
        new Intent(p0, NativeShareBroadcastListener.class);
        if (if-lt(Build$VERSION.SDK_INT, 31)) goto L_10;
      L_10:
      L_12:
        PendingIntent.getBroadcast(p0, 0, new Intent(..), 0x8000000);
        PendingIntent.getBroadcast(..).getIntentSender();
        return PendingIntent.getIntentSender(..);
    }

    public void onReceive(Context p0, Intent p1) {
        if (if-eqz(NativeShare.shareResultReceiver)) goto L_39;
        p1.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
        if (if-eqz(Intent.getParcelableExtra(..))) goto L_2c;
        Intent.getParcelableExtra(..).flattenToString();
        new StringBuilder("Shared on app: ");
        new StringBuilder(..).append(ComponentName.flattenToString(..));
        new StringBuilder(..).toString();
        Log.d("Unity", StringBuilder.toString(..));
        NativeShare.shareResultReceiver.OnShareCompleted(1, ComponentName.flattenToString(..));
      L_2c:
        Log.d(NativeShare.shareResultReceiver, "Shared on app: Unknown");
        NativeShare.shareResultReceiver.OnShareCompleted(1, "");
      L_39:
        Log.e("", "NativeShareResultReceiver was null!");
      L_3e:
        return;
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareContentProvider
// ============================================================
package com.yasirkula.unity;

public class NativeShareContentProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static HashMap sCache;
    private NativeShareContentProvider$PathStrategy mStrategy;

    static <clinit>() {
        COLUMNS = v0;
        new File("/");
        DEVICE_ROOT = new File(..);
        new HashMap();
        sCache = new HashMap(..);
        return;
    }

    public NativeShareContentProvider() {
        new ContentProvider();
        return;
    }

    private static File buildPath(File p0, String[] p1) {
      L_2:
        if (if-ge(0, v0)) goto L_11;
        if (if-eqz(v2)) goto L_e;
        new File(p0, v2);
      L_e:
      L_11:
        return new File(..);
    }

    private static Object[] copyOf(Object[] p0, int p1) {
        System.arraycopy(p0, 0, v0, 0, p1);
        return v0;
    }

    private static String[] copyOf(String[] p0, int p1) {
        System.arraycopy(p0, 0, v0, 0, p1);
        return v0;
    }

    private static NativeShareContentProvider$PathStrategy getPathStrategy(Context p0, String p1) {
        NativeShareContentProvider.sCache.get(p1);
        if (if-nez(HashMap.get(..))) goto L_29;
        NativeShareContentProvider.parsePathStrategy(p0, p1);
        NativeShareContentProvider.sCache.put(p1, NativeShareContentProvider.parsePathStrategy(..));
        new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", NativeShareContentProvider.sCache);
        throw new IllegalArgumentException(..);
        new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", NativeShareContentProvider.sCache);
        throw new IllegalArgumentException(..);
      L_29:
        return "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data";
        throw NativeShareContentProvider.sCache;
    }

    public static Uri getUriForFile(Context p0, String p1, File p2) {
        NativeShareContentProvider.getPathStrategy(p0, p1);
        NativeShareContentProvider$PathStrategy.getUriForFile(p2);
        return NativeShareContentProvider$PathStrategy.getUriForFile(..);
    }

    private static int modeToMode(String p0) {
        "r".equals(p0);
        if (if-eqz(String.equals(..))) goto L_b;
      L_b:
        "w".equals(0x10000000);
        if (if-nez(String.equals(..))) goto L_51;
        "wt".equals(0x10000000);
        if (if-eqz(String.equals(..))) goto L_1c;
      L_1c:
        "wa".equals(0x10000000);
        if (if-eqz(String.equals(..))) goto L_27;
      L_27:
        "rw".equals(0x2a000000);
        if (if-eqz(String.equals(..))) goto L_32;
      L_32:
        "rwt".equals(0x38000000);
        if (if-eqz(String.equals(..))) goto L_3d;
      L_3d:
        new StringBuilder("Invalid mode: ");
        new StringBuilder(..).append(0.0078125f);
        new StringBuilder(..).toString();
        new IllegalArgumentException(StringBuilder.toString(..));
        throw new IllegalArgumentException(..);
      L_51:
      L_53:
        return 0x2c000000;
    }

    private static NativeShareContentProvider$PathStrategy parsePathStrategy(Context p0, String p1) {
        new NativeShareContentProvider$SimplePathStrategy(p1);
        p0.getPackageManager();
        Context.getPackageManager(..).resolveContentProvider(p1, 128);
        if (if-nez(PackageManager.resolveContentProvider(..))) goto L_19;
        Log.w("Unity", "NativeShareContentProvider.resolveContentProvider is null!");
      L_19:
        "Unity".getPackageManager();
        ProviderInfo.loadXmlMetaData(Context.getPackageManager(..), "android.support.FILE_PROVIDER_PATHS");
      L_22:
        NativeShareContentProvider.buildPath(NativeShareContentProvider.DEVICE_ROOT, ProviderInfo.loadXmlMetaData(..));
        if (if-eqz(NativeShareContentProvider.buildPath(..))) goto L_35;
        NativeShareContentProvider$SimplePathStrategy.addRoot("devroot", NativeShareContentProvider.buildPath(..));
      L_35:
        return new NativeShareContentProvider$SimplePathStrategy(..);
    }

    public void attachInfo(Context p0, ProviderInfo p1) {
        ContentProvider.attachInfo(p0, p1);
        if (if-nez(exported)) goto L_1c;
        if (if-eqz(grantUriPermissions)) goto L_14;
        NativeShareContentProvider.getPathStrategy(p0, authority);
        mStrategy = NativeShareContentProvider.getPathStrategy(..);
        return;
      L_14:
        new SecurityException("Provider must grant uri permissions");
        throw new SecurityException(..);
      L_1c:
        new SecurityException("Provider must not be exported");
        throw new SecurityException(..);
    }

    public int delete(Uri p0, String p1, String[] p2) {
        mStrategy.getFileForUri(p0);
        File.delete();
        return File.delete(..);
    }

    public String getType(Uri p0) {
        mStrategy.getFileForUri(p0);
        File.getName();
        File.getName(..).lastIndexOf(46);
        if (if-ltz(String.lastIndexOf(..))) goto L_27;
        File.getName();
        File.getName(..).substring(String.lastIndexOf(..));
        MimeTypeMap.getSingleton();
        MimeTypeMap.getSingleton(..).getMimeTypeFromExtension(String.substring(..));
        if (if-eqz(MimeTypeMap.getMimeTypeFromExtension(..))) goto L_27;
        return MimeTypeMap.getMimeTypeFromExtension(..);
      L_27:
        return "application/octet-stream";
    }

    public Uri insert(Uri p0, ContentValues p1) {
        new UnsupportedOperationException("No external inserts");
        throw new UnsupportedOperationException(..);
    }

    public boolean onCreate() {
        return 1;
    }

    public ParcelFileDescriptor openFile(Uri p0, String p1) {
        mStrategy.getFileForUri(p0);
        NativeShareContentProvider.modeToMode(p1);
        ParcelFileDescriptor.open(NativeShareContentProvider$PathStrategy.getFileForUri(..), NativeShareContentProvider.modeToMode(..));
        return ParcelFileDescriptor.open(..);
    }

    public Cursor query(Uri p0, String[] p1, String p2, String[] p3, String p4) {
        mStrategy.getFileForUri(p0);
        if (if-nez(p1)) goto L_a;
      L_a:
      L_13:
        if (if-ge(0, p4)) goto L_45;
        "_display_name".equals(v2);
        if (if-eqz(String.equals(..))) goto L_2b;
        File.getName();
      L_29:
      L_2b:
        "_size".equals(v2);
        if (if-eqz(String.equals(..))) goto L_42;
        File.length();
        Long.valueOf(File.length(..), String.equals(..));
      L_42:
      L_45:
        NativeShareContentProvider.copyOf(mStrategy, v2);
        NativeShareContentProvider.copyOf(p3, v2);
        new MatrixCursor(NativeShareContentProvider.copyOf(..), 1);
        new MatrixCursor(..).addRow(NativeShareContentProvider.copyOf(..));
        return new MatrixCursor(..);
    }

    public int update(Uri p0, ContentValues p1, String p2, String[] p3) {
        new UnsupportedOperationException("No external updates");
        throw new UnsupportedOperationException(..);
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareCustomShareDialog
// ============================================================
package com.yasirkula.unity;

public class NativeShareCustomShareDialog extends DialogFragment {
    private boolean sentShareResult;

    public NativeShareCustomShareDialog() {
        new DialogFragment();
        return;
    }

    private void StartTargetActivity(Intent p0, ActivityInfo p1) {
        new ComponentName(packageName, name);
        new ComponentName(..).flattenToString();
        new StringBuilder("Shared on app: ");
        new StringBuilder(..).append(ComponentName.flattenToString(..));
        new StringBuilder(..).toString();
        Log.d("Unity", StringBuilder.toString(..));
        NativeShare.shareResultReceiver.OnShareCompleted(1, ComponentName.flattenToString(..));
        sentShareResult = 1;
        p0.setFlags(0x10000000);
        p0.setComponent(new ComponentName(..));
        NativeShareCustomShareDialog.startActivity(p0);
        return;
    }

    static void access$300(NativeShareCustomShareDialog p0, Intent p1, ActivityInfo p2) {
        p0.StartTargetActivity(p1, p2);
        return;
    }

    public Dialog onCreateDialog(Bundle p0) {
        new ArrayList();
        NativeShareCustomShareDialog.getActivity();
        NativeShareCustomShareDialog.getArguments();
        NativeShare.CreateIntentFromBundle(NativeShareCustomShareDialog.getActivity(..), NativeShareCustomShareDialog.getArguments(..), new ArrayList(..));
        NativeShareCustomShareDialog.getArguments();
        Bundle.getString("NS_TITLE");
        NativeShareCustomShareDialog.getArguments();
        Bundle.getStringArrayList("NS_TARGET_PACKAGE");
        NativeShareCustomShareDialog.getArguments();
        Bundle.getStringArrayList("NS_TARGET_CLASS");
        NativeShareCustomShareDialog.getActivity();
        Activity.getPackageManager();
        Activity.getPackageManager(..).queryIntentActivities(NativeShare.CreateIntentFromBundle(..), 0x10000);
        new ArrayList(..).size();
        if (if-lez(ArrayList.size(..))) goto L_4a;
        NativeShareCustomShareDialog.getActivity();
        NativeShare.GrantURIPermissionsToShareIntentTargets(NativeShareCustomShareDialog.getActivity(..), PackageManager.queryIntentActivities(..), new ArrayList(..));
      L_4a:
        Bundle.getStringArrayList(..).size();
        if (if-le(ArrayList.size(..), 1)) goto L_9c;
        List.size();
      L_57:
        if (if-ltz(List.size(..))) goto L_9c;
        List.get(List.size(..));
        Bundle.getStringArrayList(..).size();
      L_6c:
        if (if-ltz(ArrayList.size(..))) goto L_93;
        Bundle.getStringArrayList(..).get(ArrayList.size(..));
        packageName.equals(ArrayList.get(..));
        if (if-eqz(String.equals(..))) goto L_90;
        Bundle.getStringArrayList(..).get(ArrayList.size(..));
        ArrayList.get(..).length();
        if (if-eqz(String.length(..))) goto L_8e;
        Bundle.getStringArrayList(..).get(ArrayList.size(..));
        name.equals(ArrayList.get(..));
        if (if-eqz(String.equals(..))) goto L_90;
      L_8e:
      L_90:
      L_93:
      L_94:
        if (if-nez(0)) goto L_99;
        List.remove(List.size(..));
      L_99:
      L_9c:
        List.size();
        if (if-nez(List.size(..))) goto L_c6;
        NativeShareCustomShareDialog.getActivity();
        new AlertDialog$Builder(NativeShareCustomShareDialog.getActivity(..));
        new AlertDialog$Builder(..).setTitle(Bundle.getString(..));
        new NativeShareCustomShareDialog$1(this);
        AlertDialog$Builder.setTitle(..).setPositiveButton(17039370, new NativeShareCustomShareDialog$1(..));
        AlertDialog$Builder.setMessage("No apps can perform this action.");
        AlertDialog$Builder.setMessage(..).create();
        return AlertDialog$Builder.create(..);
      L_c6:
        List.size();
        if (if-ne(List.size(..), 1)) goto L_db;
        List.get(0);
        NativeShareCustomShareDialog.StartTargetActivity("No apps can perform this action.", activityInfo);
        NativeShareCustomShareDialog.dismissAllowingStateLoss();
      L_db:
        new ResolveInfo$DisplayNameComparator(Activity.getPackageManager(..));
        Collections.sort(PackageManager.queryIntentActivities(..), new ResolveInfo$DisplayNameComparator(..));
      L_e3:
        NativeShareCustomShareDialog.getActivity();
        new NativeShareCustomShareDialog$CustomShareDialogAdapter(NativeShareCustomShareDialog.getActivity(..), PackageManager.queryIntentActivities(..), 0);
        NativeShareCustomShareDialog.getActivity();
        Activity.getLayoutInflater();
        Activity.getLayoutInflater(..).inflate(R$layout.native_share_grid_view, 0);
        LayoutInflater.inflate(..).findViewById(R$id.native_share_grid_view_holder);
        View.findViewById(..).setAdapter(new NativeShareCustomShareDialog$CustomShareDialogAdapter(..));
        new NativeShareCustomShareDialog$2(this, "No apps can perform this action.", new NativeShareCustomShareDialog$CustomShareDialogAdapter(..));
        View.findViewById(..).setOnItemClickListener(new NativeShareCustomShareDialog$2(..));
        NativeShareCustomShareDialog.getActivity();
        new AlertDialog$Builder(NativeShareCustomShareDialog.getActivity(..));
        new AlertDialog$Builder(..).setTitle(17039370);
        new NativeShareCustomShareDialog$3(this);
        AlertDialog$Builder.setTitle(..).setNegativeButton(0x1040000, new NativeShareCustomShareDialog$3(..));
        AlertDialog$Builder.setView(LayoutInflater.inflate(..));
        AlertDialog$Builder.setView(..).create();
        return AlertDialog$Builder.create(..);
    }

    public void onDestroy() {
        DialogFragment.onDestroy();
        if (if-nez(sentShareResult)) goto L_12;
        sentShareResult = 1;
        NativeShare.shareResultReceiver.OnShareCompleted(2, "");
      L_12:
        return;
    }

    public void onDismiss(DialogInterface p0) {
        DialogFragment.onDismiss(p0);
        Log.d("Unity", "Dismissed custom share dialog");
        if (if-nez(sentShareResult)) goto L_19;
        sentShareResult = 1;
        NativeShare.shareResultReceiver.OnShareCompleted(2, "");
      L_19:
        NativeShareCustomShareDialog.getActivity();
        if (if-eqz(NativeShareCustomShareDialog.getActivity(..))) goto L_26;
        if (if-eqz(2)) goto L_26;
        Activity.finish();
      L_26:
        return;
    }

    public void onPause() {
        DialogFragment.onPause();
        NativeShareCustomShareDialog.dismissAllowingStateLoss();
        return;
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareCustomShareDialogActivity
// ============================================================
package com.yasirkula.unity;

public class NativeShareCustomShareDialogActivity extends Activity {
    private boolean dialogDisplayed;

    public NativeShareCustomShareDialogActivity() {
        new Activity();
        return;
    }

    public void onCreate(Bundle p0, PersistableBundle p1) {
        Activity.onCreate(p0, p1);
        NativeShareCustomShareDialogActivity.setContentView(R$layout.native_share_custom_dialog_holder);
        return;
    }

    protected void onStart() {
        Activity.onStart();
        if (if-nez(dialogDisplayed)) goto L_2b;
        dialogDisplayed = 1;
        new NativeShareCustomShareDialog();
        NativeShareCustomShareDialogActivity.getIntent();
        Intent.getExtras();
        new NativeShareCustomShareDialog(..).setArguments(Intent.getExtras(..));
        NativeShareCustomShareDialogActivity.getFragmentManager();
        FragmentManager.beginTransaction();
        FragmentManager.beginTransaction(..).add(0, new NativeShareCustomShareDialog(..));
        FragmentTransaction.add(..).commitAllowingStateLoss();
      L_2b:
        NativeShareCustomShareDialogActivity.finish();
      L_2e:
        return;
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareFragment
// ============================================================
package com.yasirkula.unity;

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

    public NativeShareFragment() {
        new Fragment();
        return;
    }

    public void onActivityResult(int p0, int p1, Intent p2) {
        if (if-eq(p0, 774457)) goto L_6;
        return;
      L_6:
        if (if-eqz(NativeShare.shareResultReceiver)) goto L_35;
        new StringBuilder("Reported share result (may not be correct): ");
        if (if-ne(p1, -1)) goto L_19;
      L_19:
      L_1a:
        new StringBuilder(..).append(0);
        new StringBuilder(..).toString();
        Log.d("Unity", StringBuilder.toString(..));
        if (if-ne(p1, -1)) goto L_2e;
        NativeShare.shareResultReceiver.OnShareCompleted(1, "");
      L_2e:
        NativeShare.shareResultReceiver.OnShareCompleted(2, "");
      L_35:
        Log.e(2, "NativeShareResultReceiver was null!");
      L_3a:
        NativeShareFragment.getFragmentManager();
        FragmentManager.beginTransaction();
        FragmentManager.beginTransaction(..).remove(this);
        FragmentTransaction.remove(..).commitAllowingStateLoss();
        return;
    }

    public void onCreate(Bundle p0) {
        Fragment.onCreate(p0);
        if (if-nez(NativeShare.shareResultReceiver)) goto L_10;
        NativeShareFragment.onActivityResult(774457, 0, 0);
      L_10:
        new ArrayList();
        NativeShareFragment.getActivity();
        NativeShareFragment.getArguments();
        NativeShare.CreateIntentFromBundle(NativeShareFragment.getActivity(..), NativeShareFragment.getArguments(..), new ArrayList(..));
        NativeShareFragment.getArguments();
        NativeShareFragment.getArguments(..).getString("NS_TITLE");
        Intent.setFlags(0x10000000);
        NativeShareFragment.getActivity();
        NativeShareBroadcastListener.Initialize(NativeShareFragment.getActivity(..));
        Intent.createChooser(NativeShare.CreateIntentFromBundle(..), Bundle.getString(..), NativeShareBroadcastListener.Initialize(..));
        new ArrayList(..).size();
        if (if-lez(ArrayList.size(..))) goto L_57;
        NativeShareFragment.getActivity();
        NativeShareFragment.getActivity();
        NativeShareFragment.getActivity(..).getPackageManager();
        Activity.getPackageManager(..).queryIntentActivities(Intent.createChooser(..), 0x10000);
        NativeShare.GrantURIPermissionsToShareIntentTargets(NativeShareFragment.getActivity(..), PackageManager.queryIntentActivities(..), new ArrayList(..));
      L_57:
        NativeShareFragment.startActivityForResult(Intent.createChooser(..), 774457);
        NativeShareFragment.getActivity();
        Toast.makeText(NativeShareFragment.getActivity(..), "No apps can perform this action.", 1);
        Toast.makeText(..).show();
        NativeShareFragment.onActivityResult(774457, 0, 0);
      L_6c:
        return;
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareResultReceiver
// ============================================================
package com.yasirkula.unity;

public abstract class NativeShareResultReceiver {
    public abstract boolean HasManagedCallback() {
        // native or abstract
    }

    public abstract void OnShareCompleted(int p0, String p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareContentProvider$PathStrategy
// ============================================================
package com.yasirkula.unity;

abstract class NativeShareContentProvider$PathStrategy {
    public abstract File getFileForUri(Uri p0) {
        // native or abstract
    }

    public abstract Uri getUriForFile(File p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareContentProvider$SimplePathStrategy
// ============================================================
package com.yasirkula.unity;

class NativeShareContentProvider$SimplePathStrategy {
    private final String mAuthority;
    private final HashMap mRoots;

    public NativeShareContentProvider$SimplePathStrategy(String p0) {
        new Object();
        new HashMap();
        mRoots = new HashMap(..);
        mAuthority = p0;
        return;
    }

    public void addRoot(String p0, File p1) {
        TextUtils.isEmpty(p0);
        if (if-nez(TextUtils.isEmpty(..))) goto L_25;
        p1.getCanonicalFile();
        mRoots.put(p0, File.getCanonicalFile(..));
        return;
        new StringBuilder("Failed to resolve canonical path for ");
        new StringBuilder(..).append(File.getCanonicalFile(..));
        new StringBuilder(..).toString();
        new IllegalArgumentException(StringBuilder.toString(..), p0);
        throw new IllegalArgumentException(..);
      L_25:
        new IllegalArgumentException("Name must not be empty");
        throw new IllegalArgumentException(..);
    }

    public File getFileForUri(Uri p0) {
        p0.getEncodedPath();
        Uri.getEncodedPath(..).indexOf(47, 1);
        Uri.getEncodedPath(..).substring(1, String.indexOf(..));
        Uri.decode(String.substring(..));
        Uri.getEncodedPath(..).substring(String.indexOf(..));
        Uri.decode(String.substring(..));
        mRoots.get(Uri.decode(..));
        if (if-eqz(HashMap.get(..))) goto L_5a;
        new File(HashMap.get(..), Uri.decode(..));
        new File(..).getCanonicalFile();
        File.getCanonicalFile(..).getPath();
        HashMap.get(..).getPath();
        File.getPath(..).startsWith(File.getPath(..));
        if (if-eqz(String.startsWith(..))) goto L_3e;
        return File.getCanonicalFile(..);
      L_3e:
        new SecurityException("Resolved path jumped beyond configured root");
        throw new SecurityException(..);
        new StringBuilder("Failed to resolve canonical path for ");
        new StringBuilder(..).append(new SecurityException(..));
        new StringBuilder(..).toString();
        new IllegalArgumentException(StringBuilder.toString(..));
        throw new IllegalArgumentException(..);
      L_5a:
        new StringBuilder("Unable to find configured root for ");
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).toString();
        new IllegalArgumentException(StringBuilder.toString(..));
        throw new IllegalArgumentException(..);
    }

    public Uri getUriForFile(File p0) {
        p0.getCanonicalPath();
        mRoots.entrySet();
        HashMap.entrySet(..).iterator();
      L_f:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_43;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).getPath();
        File.getCanonicalPath(..).startsWith(File.getPath(..));
        if (if-eqz(String.startsWith(..))) goto L_f;
        if (if-eqz(0)) goto L_41;
        File.getPath(..).length();
        0.getValue();
        Map$Entry.getValue(..).getPath();
        File.getPath(..).length();
        if (if-le(String.length(..), String.length(..))) goto L_f;
      L_41:
      L_43:
        if (if-eqz(Iterator.next(..))) goto L_a6;
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).getPath();
        File.getPath(..).endsWith("/");
        if (if-eqz(String.endsWith(..))) goto L_60;
        File.getPath(..).length();
        File.getCanonicalPath(..).substring(String.length(..));
      L_60:
        String.length(..).length();
        String.substring(..).substring(String.length(..));
      L_6a:
        new StringBuilder();
        Iterator.next(..).getKey();
        Uri.encode(Map$Entry.getKey(..));
        new StringBuilder(..).append(Uri.encode(..));
        new StringBuilder(..).append(47);
        Uri.encode(String.substring(..), "/");
        new StringBuilder(..).append(Uri.encode(..));
        new StringBuilder(..).toString();
        new Uri$Builder();
        new Uri$Builder(..).scheme("content");
        Uri$Builder.scheme(..).authority(mAuthority);
        Uri$Builder.authority(..).encodedPath(StringBuilder.toString(..));
        Uri$Builder.encodedPath(..).build();
        return Uri$Builder.build(..);
      L_a6:
        new StringBuilder("Failed to find configured root that contains ");
        new StringBuilder(..).append(Uri$Builder.build(..));
        new StringBuilder(..).toString();
        new IllegalArgumentException(StringBuilder.toString(..));
        throw new IllegalArgumentException(..);
        new StringBuilder("Failed to resolve canonical path for ");
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).toString();
        new IllegalArgumentException(StringBuilder.toString(..));
        throw new IllegalArgumentException(..);
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareCustomShareDialog$1
// ============================================================
package com.yasirkula.unity;

class NativeShareCustomShareDialog$1 {
    final NativeShareCustomShareDialog this$0;

    NativeShareCustomShareDialog$1(NativeShareCustomShareDialog p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onClick(DialogInterface p0, int p1) {
        this$0.dismissAllowingStateLoss();
        return;
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareCustomShareDialog$2
// ============================================================
package com.yasirkula.unity;

class NativeShareCustomShareDialog$2 {
    final NativeShareCustomShareDialog this$0;
    final NativeShareCustomShareDialog$CustomShareDialogAdapter val$shareDialogAdapter;
    final Intent val$shareIntent;

    NativeShareCustomShareDialog$2(NativeShareCustomShareDialog p0, Intent p1, NativeShareCustomShareDialog$CustomShareDialogAdapter p2) {
        this$0 = p0;
        val$shareIntent = p1;
        val$shareDialogAdapter = p2;
        new Object();
        return;
    }

    public void onItemClick(AdapterView p0, View p1, int p2, long p3) {
        NativeShareCustomShareDialog$CustomShareDialogAdapter.getItem(p2);
        NativeShareCustomShareDialog.access$300(this$0, val$shareIntent, activityInfo);
        this$0.dismissAllowingStateLoss();
        return;
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareCustomShareDialog$3
// ============================================================
package com.yasirkula.unity;

class NativeShareCustomShareDialog$3 {
    final NativeShareCustomShareDialog this$0;

    NativeShareCustomShareDialog$3(NativeShareCustomShareDialog p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onClick(DialogInterface p0, int p1) {
        this$0.dismissAllowingStateLoss();
        return;
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareCustomShareDialog$CustomShareDialogAdapter
// ============================================================
package com.yasirkula.unity;

class NativeShareCustomShareDialog$CustomShareDialogAdapter extends ArrayAdapter {
    private PackageManager packageManager;
    private Activity unityActivity;

    private NativeShareCustomShareDialog$CustomShareDialogAdapter(Activity p0, List p1) {
        new ArrayAdapter(p0, R$layout.native_share_grid_element, p1);
        unityActivity = p0;
        p0.getPackageManager();
        packageManager = Activity.getPackageManager(..);
        return;
    }

    NativeShareCustomShareDialog$CustomShareDialogAdapter(Activity p0, List p1, NativeShareCustomShareDialog$1 p2) {
        new NativeShareCustomShareDialog$CustomShareDialogAdapter(p0, p1);
        return;
    }

    public View getView(int p0, View p1, ViewGroup p2) {
        if (if-nez(p1)) goto L_27;
        unityActivity.getLayoutInflater();
        Activity.getLayoutInflater(..).inflate(R$layout.native_share_grid_element, p2, 0);
        LayoutInflater.inflate(..).findViewById(R$id.native_share_app_name);
        LayoutInflater.inflate(..).findViewById(R$id.native_share_app_icon);
        new NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder(View.findViewById(..), View.findViewById(..));
        LayoutInflater.inflate(..).setTag(new NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder(..));
      L_27:
        NativeShareCustomShareDialog$CustomShareDialogAdapter.getItem(p0);
        LayoutInflater.inflate(..).getTag();
        NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder.access$000(View.getTag(..));
        ResolveInfo.loadLabel(packageManager);
        TextView.setText(ResolveInfo.loadLabel(..));
        NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder.access$100(View.getTag(..));
        ResolveInfo.loadIcon(packageManager);
        ImageView.setImageDrawable(ResolveInfo.loadIcon(..));
        return LayoutInflater.inflate(..);
    }

}


// ============================================================
// CLASS: com.yasirkula.unity.NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder
// ============================================================
package com.yasirkula.unity;

class NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder {
    private final ImageView icon;
    private final TextView label;

    public NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder(TextView p0, ImageView p1) {
        new Object();
        label = p0;
        icon = p1;
        return;
    }

    static TextView access$000(NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder p0) {
        return label;
    }

    static ImageView access$100(NativeShareCustomShareDialog$CustomShareDialogAdapter$ViewHolder p0) {
        return icon;
    }

}

