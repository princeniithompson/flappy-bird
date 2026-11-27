
// ===== FILE: com/unity3d/services/core/configuration/AdsSdkInitializer.java =====
package com.unity3d.services.core.configuration;

import android.content.Context;
import androidx.startup.Initializer;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdsSdkInitializer.kt */
@Metadata(m443d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\t0\bH\u0016¨\u0006\n"}, m444d2 = {"Lcom/unity3d/services/core/configuration/AdsSdkInitializer;", "Landroidx/startup/Initializer;", "", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class AdsSdkInitializer implements Initializer<Unit> {
    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit create(Context context) {
        create2(context);
        return Unit.INSTANCE;
    }

    /* renamed from: create, reason: avoid collision after fix types in other method */
    public void create2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ClientProperties.setApplicationContext(context.getApplicationContext());
        SdkProperties.setAppInitializationTimeSinceEpoch(System.currentTimeMillis());
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }
}

// ===== FILE: com/unity3d/services/core/configuration/Configuration.java =====
package com.unity3d.services.core.configuration;

import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.ads.configuration.AdsModuleConfiguration;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.analytics.core.configuration.AnalyticsModuleConfiguration;
import com.unity3d.services.banners.configuration.BannersModuleConfiguration;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.mapper.WebRequestToHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.store.core.configuration.StoreModuleConfiguration;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Configuration {
    private String _configUrl;
    private ConfigurationRequestFactory _configurationRequestFactory;
    private int _connectedEventThresholdInMs;
    private boolean _delayWebViewUpdate;
    private ExperimentsReader _experimentReader;
    private String _filteredJsonString;
    private int _loadTimeout;
    private int _maxRetries;
    private int _maximumConnectedEvents;
    private double _metricSampleRate;
    private Boolean _metricsEnabled;
    private String _metricsUrl;
    private final Class<?>[] _moduleConfigurationList;
    private Map<String, IModuleConfiguration> _moduleConfigurations;
    private long _networkErrorTimeout;
    private int _privacyRequestWaitTimeout;
    private JSONObject _rawJsonData;
    private int _resetWebAppTimeout;
    private long _retryDelay;
    private double _retryScalingFactor;
    private String _sTkn;
    private String _scarBiddingUrl;
    private String _sdkVersion;
    private int _showTimeout;
    private String _src;
    private String _stateId;
    private int _tokenTimeout;
    private String _unifiedAuctionToken;
    private Class[] _webAppApiClassList;
    private long _webViewAppCreateTimeout;
    private int _webViewBridgeTimeout;
    private String _webViewData;
    private String _webViewHash;
    private String _webViewUrl;
    private String _webViewVersion;

    public Configuration() {
        this._moduleConfigurationList = new Class[]{CoreModuleConfiguration.class, AdsModuleConfiguration.class, AnalyticsModuleConfiguration.class, BannersModuleConfiguration.class, StoreModuleConfiguration.class};
        this._experimentReader = new ExperimentsReader();
        setOptionalFields(new JSONObject(), false);
    }

    public Configuration(String str) {
        this(str, new Experiments());
    }

    public Configuration(JSONObject jSONObject) throws MalformedURLException, JSONException {
        this._moduleConfigurationList = new Class[]{CoreModuleConfiguration.class, AdsModuleConfiguration.class, AnalyticsModuleConfiguration.class, BannersModuleConfiguration.class, StoreModuleConfiguration.class};
        this._experimentReader = new ExperimentsReader();
        handleConfigurationData(jSONObject, false);
    }

    public Configuration(String str, ExperimentsReader experimentsReader) {
        this(str, experimentsReader.getCurrentlyActiveExperiments());
        this._experimentReader = experimentsReader;
    }

    public Configuration(String str, IExperiments iExperiments) {
        this();
        this._configUrl = str;
        this._configurationRequestFactory = new ConfigurationRequestFactory(this);
        this._experimentReader.updateLocalExperiments(iExperiments);
    }

    public String getConfigUrl() {
        return this._configUrl;
    }

    public Class[] getWebAppApiClassList() {
        if (this._webAppApiClassList == null) {
            createWebAppApiClassList();
        }
        return this._webAppApiClassList;
    }

    public Class[] getModuleConfigurationList() {
        return this._moduleConfigurationList;
    }

    public String getWebViewUrl() {
        return this._webViewUrl;
    }

    public void setWebViewUrl(String str) {
        this._webViewUrl = str;
    }

    public String getWebViewHash() {
        return this._webViewHash;
    }

    public void setWebViewHash(String str) {
        this._webViewHash = str;
    }

    public String getWebViewVersion() {
        return this._webViewVersion;
    }

    public String getWebViewData() {
        return this._webViewData;
    }

    public void setWebViewData(String str) {
        this._webViewData = str;
    }

    public String getSdkVersion() {
        return this._sdkVersion;
    }

    public boolean getDelayWebViewUpdate() {
        return this._delayWebViewUpdate;
    }

    public int getResetWebappTimeout() {
        return this._resetWebAppTimeout;
    }

    public int getMaxRetries() {
        return this._maxRetries;
    }

    public long getRetryDelay() {
        return this._retryDelay;
    }

    public double getRetryScalingFactor() {
        return this._retryScalingFactor;
    }

    public int getConnectedEventThreshold() {
        return this._connectedEventThresholdInMs;
    }

    public int getMaximumConnectedEvents() {
        return this._maximumConnectedEvents;
    }

    public long getNetworkErrorTimeout() {
        return this._networkErrorTimeout;
    }

    public int getShowTimeout() {
        return this._showTimeout;
    }

    public int getLoadTimeout() {
        return this._loadTimeout;
    }

    public int getWebViewBridgeTimeout() {
        return this._webViewBridgeTimeout;
    }

    public String getMetricsUrl() {
        return this._metricsUrl;
    }

    public String getScarBiddingUrl() {
        return this._scarBiddingUrl;
    }

    public double getMetricSampleRate() {
        return this._metricSampleRate;
    }

    public long getWebViewAppCreateTimeout() {
        return this._webViewAppCreateTimeout;
    }

    public String getStateId() {
        String str = this._stateId;
        return str != null ? str : "";
    }

    public String getUnifiedAuctionToken() {
        return this._unifiedAuctionToken;
    }

    public String getSessionToken() {
        return this._sTkn;
    }

    public IExperiments getExperiments() {
        return this._experimentReader.getCurrentlyActiveExperiments();
    }

    public ExperimentsReader getExperimentsReader() {
        return this._experimentReader;
    }

    public int getTokenTimeout() {
        return this._tokenTimeout;
    }

    public int getPrivacyRequestWaitTimeout() {
        return this._privacyRequestWaitTimeout;
    }

    public String getSrc() {
        String str = this._src;
        return str != null ? str : "";
    }

    public IModuleConfiguration getModuleConfiguration(Class cls) {
        Map<String, IModuleConfiguration> map = this._moduleConfigurations;
        if (map != null && map.containsKey(cls)) {
            return this._moduleConfigurations.get(cls);
        }
        try {
            IModuleConfiguration iModuleConfiguration = (IModuleConfiguration) cls.newInstance();
            if (iModuleConfiguration != null) {
                if (this._moduleConfigurations == null) {
                    HashMap hashMap = new HashMap();
                    this._moduleConfigurations = hashMap;
                    hashMap.put(cls.getName(), iModuleConfiguration);
                }
                return iModuleConfiguration;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String getFilteredJsonString() {
        return this._filteredJsonString;
    }

    public JSONObject getRawConfigData() {
        return this._rawJsonData;
    }

    public void makeRequest() throws Exception {
        if (this._configUrl == null) {
            throw new MalformedURLException("Base URL is null");
        }
        HttpRequest httpRequest = WebRequestToHttpRequestKt.toHttpRequest(this._configurationRequestFactory.getWebRequest());
        InitializeEventsMetricSender.getInstance().didConfigRequestStart();
        try {
            handleConfigurationData(new JSONObject(((HttpClient) Utilities.getService(HttpClient.class)).executeBlocking(httpRequest).getBody().toString()), true);
            InitializeEventsMetricSender.getInstance().didConfigRequestEnd(true);
            saveToDisk();
        } catch (Exception e) {
            InitializeEventsMetricSender.getInstance().didConfigRequestEnd(false);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void handleConfigurationData(JSONObject jSONObject, boolean z) throws MalformedURLException, JSONException {
        String str;
        if (!jSONObject.isNull("url")) {
            str = jSONObject.getString("url");
            if (!TextUtils.isEmpty(str)) {
                throw new MalformedURLException("WebView URL is null or empty");
            }
            this._webViewUrl = str;
            try {
                this._webViewHash = !jSONObject.isNull("hash") ? jSONObject.getString("hash") : null;
            } catch (JSONException unused) {
                this._webViewHash = null;
            }
            this._unifiedAuctionToken = !jSONObject.isNull("tkn") ? jSONObject.optString("tkn") : null;
            this._stateId = !jSONObject.isNull("sid") ? jSONObject.optString("sid") : null;
            this._sTkn = jSONObject.isNull("sTkn") ? null : jSONObject.optString("sTkn");
            setOptionalFields(jSONObject, z);
            this._filteredJsonString = getFilteredConfigJson(jSONObject).toString();
            this._rawJsonData = jSONObject;
            return;
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
    }

    private void setOptionalFields(JSONObject jSONObject, boolean z) {
        IExperiments experiments;
        this._webViewVersion = jSONObject.optString("version", null);
        this._delayWebViewUpdate = jSONObject.optBoolean("dwu", false);
        this._resetWebAppTimeout = jSONObject.optInt("rwt", 10000);
        this._maxRetries = jSONObject.optInt("mr", 6);
        this._retryDelay = jSONObject.optLong("rd", 5000L);
        this._retryScalingFactor = jSONObject.optDouble("rcf", 2.0d);
        this._connectedEventThresholdInMs = jSONObject.optInt("cet", 10000);
        this._maximumConnectedEvents = jSONObject.optInt("mce", UnityAdsConstants.RequestPolicy.RETRY_WAIT_BASE);
        this._networkErrorTimeout = jSONObject.optLong("net", 60000L);
        this._sdkVersion = jSONObject.optString("sdkv", "");
        this._showTimeout = jSONObject.optInt("sto", 10000);
        this._loadTimeout = jSONObject.optInt("lto", 30000);
        this._webViewBridgeTimeout = jSONObject.optInt("wto", 5000);
        this._metricsUrl = jSONObject.optString("murl", "");
        this._metricSampleRate = jSONObject.optDouble("msr", 100.0d);
        this._webViewAppCreateTimeout = jSONObject.optLong("wct", 60000L);
        this._tokenTimeout = jSONObject.optInt("tto", 5000);
        this._privacyRequestWaitTimeout = jSONObject.optInt("prwto", PathInterpolatorCompat.MAX_NUM_POINTS);
        this._src = jSONObject.optString("src", null);
        this._scarBiddingUrl = jSONObject.optString("scurl", ScarConstants.SCAR_PRD_BIDDING_ENDPOINT);
        this._metricsEnabled = Boolean.valueOf(this._metricSampleRate >= ((double) (new Random().nextInt(99) + 1)));
        if (jSONObject.has("expo")) {
            experiments = new ExperimentObjects(jSONObject.optJSONObject("expo"));
        } else {
            experiments = new Experiments(jSONObject.optJSONObject("exp"));
        }
        if (z) {
            this._experimentReader.updateRemoteExperiments(experiments);
        } else {
            this._experimentReader.updateLocalExperiments(experiments);
        }
    }

    private void createWebAppApiClassList() {
        ArrayList arrayList = new ArrayList();
        for (Class cls : getModuleConfigurationList()) {
            IModuleConfiguration moduleConfiguration = getModuleConfiguration(cls);
            if (moduleConfiguration != null && moduleConfiguration.getWebAppApiClassList() != null) {
                arrayList.addAll(Arrays.asList(moduleConfiguration.getWebAppApiClassList()));
            }
        }
        this._webAppApiClassList = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    public void saveToDisk() {
        Utilities.writeFile(new File(SdkProperties.getLocalConfigurationFilepath()), getFilteredJsonString());
    }

    public void deleteFromDisk() {
        File file = new File(SdkProperties.getLocalConfigurationFilepath());
        if (file.exists()) {
            file.delete();
        }
    }

    private JSONObject getFilteredConfigJson(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (!next.equalsIgnoreCase("tkn") && !next.equalsIgnoreCase("sid") && !next.equalsIgnoreCase("srr") && !next.equalsIgnoreCase("sTkn")) {
                jSONObject2.put(next, opt);
            }
        }
        return jSONObject2;
    }

    public Boolean areMetricsEnabledForCurrentSession() {
        return this._metricsEnabled;
    }
}

// ===== FILE: com/unity3d/services/core/configuration/ConfigurationFailure.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public enum ConfigurationFailure {
    NETWORK_FAILURE,
    INVALID_DATA
}

// ===== FILE: com/unity3d/services/core/configuration/ConfigurationLoader.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.mapper.WebRequestToHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ConfigurationLoader implements IConfigurationLoader {
    private final ConfigurationRequestFactory _configurationRequestFactory;
    private final HttpClient _httpClient;
    private final Configuration _localConfiguration;
    private final SDKMetricsSender _sdkMetricsSender;

    public ConfigurationLoader(ConfigurationRequestFactory configurationRequestFactory, SDKMetricsSender sDKMetricsSender, HttpClient httpClient) {
        this._localConfiguration = configurationRequestFactory.getConfiguration();
        this._configurationRequestFactory = configurationRequestFactory;
        this._sdkMetricsSender = sDKMetricsSender;
        this._httpClient = httpClient;
    }

    @Override // com.unity3d.services.core.configuration.IConfigurationLoader
    public void loadConfiguration(IConfigurationLoaderListener iConfigurationLoaderListener) throws Exception {
        try {
            HttpRequest httpRequest = WebRequestToHttpRequestKt.toHttpRequest(this._configurationRequestFactory.getWebRequest());
            InitializeEventsMetricSender.getInstance().didConfigRequestStart();
            HttpResponse executeBlocking = this._httpClient.executeBlocking(httpRequest);
            String obj = executeBlocking.getBody().toString();
            if (!(executeBlocking.getStatusCode() / 100 == 2)) {
                iConfigurationLoaderListener.onError("Non 2xx HTTP status received from ads configuration request.");
                return;
            }
            try {
                this._localConfiguration.handleConfigurationData(new JSONObject(obj), true);
                sendConfigMetrics(this._localConfiguration.getUnifiedAuctionToken(), this._localConfiguration.getStateId());
                iConfigurationLoaderListener.onSuccess(this._localConfiguration);
            } catch (Exception unused) {
                iConfigurationLoaderListener.onError("Could not create web request");
            }
        } catch (Exception e) {
            iConfigurationLoaderListener.onError("Could not create web request: " + e);
        }
    }

    @Override // com.unity3d.services.core.configuration.IConfigurationLoader
    public Configuration getLocalConfiguration() {
        return this._localConfiguration;
    }

    private void sendConfigMetrics(String str, String str2) {
        if (str == null || str.isEmpty()) {
            this._sdkMetricsSender.sendMetric(TSIMetric.newMissingToken());
        }
        if (str2 == null || str2.isEmpty()) {
            this._sdkMetricsSender.sendMetric(TSIMetric.newMissingStateId());
        }
    }
}

// ===== FILE: com/unity3d/services/core/configuration/ConfigurationReader.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.webview.WebViewApp;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ConfigurationReader {
    private Configuration _localConfiguration;

    public Configuration getCurrentConfiguration() {
        if (getRemoteConfiguration() != null) {
            return getRemoteConfiguration();
        }
        Configuration localConfiguration = getLocalConfiguration();
        return localConfiguration != null ? localConfiguration : new Configuration();
    }

    private Configuration getRemoteConfiguration() {
        if (WebViewApp.getCurrentApp() == null) {
            return null;
        }
        return WebViewApp.getCurrentApp().getConfiguration();
    }

    private Configuration getLocalConfiguration() {
        Configuration configuration = this._localConfiguration;
        if (configuration != null) {
            return configuration;
        }
        File file = new File(SdkProperties.getLocalConfigurationFilepath());
        if (file.exists()) {
            try {
                this._localConfiguration = new Configuration(new JSONObject(new String(Utilities.readFileBytes(file))));
            } catch (IOException | JSONException unused) {
                DeviceLog.debug("Unable to read configuration from storage");
                this._localConfiguration = null;
            }
        }
        return this._localConfiguration;
    }
}

// ===== FILE: com/unity3d/services/core/configuration/ConfigurationRequestFactory.java =====
package com.unity3d.services.core.configuration;

import androidx.browser.trusted.sharing.ShareTarget;
import com.unity3d.services.core.device.reader.IDeviceInfoDataContainer;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.WebRequest;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConfigurationRequestFactory {
    private final Configuration _configuration;
    private final IDeviceInfoDataContainer _deviceInfoDataContainer;

    public ConfigurationRequestFactory(Configuration configuration) {
        this(configuration, null);
    }

    public ConfigurationRequestFactory(Configuration configuration, IDeviceInfoDataContainer iDeviceInfoDataContainer) {
        this._configuration = configuration;
        this._deviceInfoDataContainer = iDeviceInfoDataContainer;
    }

    public Configuration getConfiguration() {
        return this._configuration;
    }

    public WebRequest getWebRequest() throws MalformedURLException {
        String configUrl = this._configuration.getConfigUrl();
        if (configUrl == null) {
            throw new MalformedURLException("Base URL is null");
        }
        StringBuilder sb = new StringBuilder(configUrl);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", Collections.singletonList("gzip"));
        WebRequest webRequest = new WebRequest(sb.toString(), ShareTarget.METHOD_POST, hashMap);
        IDeviceInfoDataContainer iDeviceInfoDataContainer = this._deviceInfoDataContainer;
        webRequest.setBody(iDeviceInfoDataContainer != null ? iDeviceInfoDataContainer.getDeviceData() : null);
        DeviceLog.debug("Requesting configuration with: " + ((Object) sb));
        return webRequest;
    }
}

// ===== FILE: com/unity3d/services/core/configuration/CoreModuleConfiguration.java =====
package com.unity3d.services.core.configuration;

import android.content.Context;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.api.Broadcast;
import com.unity3d.services.core.api.Cache;
import com.unity3d.services.core.api.ClassDetection;
import com.unity3d.services.core.api.Connectivity;
import com.unity3d.services.core.api.DeviceInfo;
import com.unity3d.services.core.api.Intent;
import com.unity3d.services.core.api.Lifecycle;
import com.unity3d.services.core.api.Permissions;
import com.unity3d.services.core.api.Preferences;
import com.unity3d.services.core.api.Request;
import com.unity3d.services.core.api.Resolve;
import com.unity3d.services.core.api.Sdk;
import com.unity3d.services.core.api.SensorInfo;
import com.unity3d.services.core.api.Storage;
import com.unity3d.services.core.broadcast.BroadcastMonitor;
import com.unity3d.services.core.cache.CacheThread;
import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.device.AdvertisingId;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.device.OpenAdvertisingId;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequestThread;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CoreModuleConfiguration implements IModuleConfiguration {
    @Override // com.unity3d.services.core.configuration.IModuleConfiguration
    public Class[] getWebAppApiClassList() {
        return new Class[]{Broadcast.class, Cache.class, Connectivity.class, DeviceInfo.class, ClassDetection.class, Storage.class, Sdk.class, Request.class, Resolve.class, Intent.class, Lifecycle.class, Preferences.class, SensorInfo.class, Permissions.class};
    }

    @Override // com.unity3d.services.core.configuration.IModuleConfiguration
    public boolean resetState(Configuration configuration) {
        BroadcastMonitor.getInstance().removeAllBroadcastListeners();
        CacheThread.cancel();
        WebRequestThread.cancel();
        ConnectivityMonitor.stopAll();
        StorageManager.init(ClientProperties.getApplicationContext());
        AdvertisingId.init(ClientProperties.getApplicationContext());
        OpenAdvertisingId.init(ClientProperties.getApplicationContext());
        ((VolumeChange) Utilities.getService(VolumeChange.class)).clearAllListeners();
        return true;
    }

    @Override // com.unity3d.services.core.configuration.IModuleConfiguration
    public boolean initErrorState(Configuration configuration, ErrorState errorState, final String str) {
        final UnityAds.UnityAdsInitializationError unityAdsInitializationError;
        SDKMetrics.setConfiguration(configuration);
        int i = C11303.$SwitchMap$com$unity3d$services$core$configuration$ErrorState[errorState.ordinal()];
        if (i == 1) {
            unityAdsInitializationError = UnityAds.UnityAdsInitializationError.INTERNAL_ERROR;
        } else if (i == 2) {
            unityAdsInitializationError = UnityAds.UnityAdsInitializationError.AD_BLOCKER_DETECTED;
        } else {
            unityAdsInitializationError = UnityAds.UnityAdsInitializationError.INTERNAL_ERROR;
            str = "Unity Ads failed to initialize due to internal error";
        }
        InitializationNotificationCenter.getInstance().triggerOnSdkInitializationFailed(str, errorState, 0);
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.configuration.CoreModuleConfiguration.1
            @Override // java.lang.Runnable
            public void run() {
                SdkProperties.notifyInitializationFailed(unityAdsInitializationError, str);
            }
        });
        return true;
    }

    /* renamed from: com.unity3d.services.core.configuration.CoreModuleConfiguration$3 */
    static /* synthetic */ class C11303 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$core$configuration$ErrorState;

        static {
            int[] iArr = new int[ErrorState.values().length];
            $SwitchMap$com$unity3d$services$core$configuration$ErrorState = iArr;
            try {
                iArr[ErrorState.CreateWebApp.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$core$configuration$ErrorState[ErrorState.InitModules.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.unity3d.services.core.configuration.IModuleConfiguration
    public boolean initCompleteState(Configuration configuration) {
        SDKMetrics.setConfiguration(configuration);
        InitializationNotificationCenter.getInstance().triggerOnSdkInitialized();
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.configuration.CoreModuleConfiguration.2
            @Override // java.lang.Runnable
            public void run() {
                SdkProperties.notifyInitializationComplete();
            }
        });
        collectMetrics(configuration);
        return true;
    }

    private void collectMetrics(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        if (Device.hasX264Decoder()) {
            arrayList.add(new Metric("native_device_decoder_x264_success"));
        } else {
            arrayList.add(new Metric("native_device_decoder_x264_failure"));
        }
        if (Device.hasX265Decoder()) {
            arrayList.add(new Metric("native_device_decoder_x265_success"));
        } else {
            arrayList.add(new Metric("native_device_decoder_x265_failure"));
        }
        if (Device.hasAV1Decoder()) {
            arrayList.add(new Metric("native_device_decoder_av1_success"));
        } else {
            arrayList.add(new Metric("native_device_decoder_av1_failure"));
        }
        SDKMetricsSender sDKMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
        sDKMetricsSender.sendMetrics(arrayList);
        checkForPC(configuration, sDKMetricsSender);
    }

    private void checkForPC(Configuration configuration, SDKMetricsSender sDKMetricsSender) {
        Context applicationContext;
        if (!configuration.getExperiments().isPCCheckEnabled() || (applicationContext = ClientProperties.getApplicationContext()) == null) {
            return;
        }
        if (applicationContext.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
            sDKMetricsSender.sendMetric(new Metric("native_device_is_pc_success"));
        } else {
            sDKMetricsSender.sendMetric(new Metric("native_device_is_pc_failure"));
        }
    }
}

// ===== FILE: com/unity3d/services/core/configuration/EnvironmentCheck.java =====
package com.unity3d.services.core.configuration;

import android.webkit.JavascriptInterface;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class EnvironmentCheck {
    public static boolean isEnvironmentOk() {
        return testProGuard() && testCacheDirectory();
    }

    public static boolean testProGuard() {
        try {
            Class<?> cls = Class.forName("com.unity3d.services.core.webview.bridge.WebViewBridgeInterface");
            Method method = cls.getMethod("handleInvocation", String.class);
            Method method2 = cls.getMethod("handleCallback", String.class, String.class, String.class);
            if (hasJavascriptInterface(method) && hasJavascriptInterface(method2)) {
                DeviceLog.debug("Unity Ads ProGuard check OK");
                return true;
            }
            DeviceLog.error("Unity Ads ProGuard check fail: missing @JavascriptInterface annotations in Unity Ads web bridge");
            return false;
        } catch (ClassNotFoundException e) {
            DeviceLog.exception("Unity Ads ProGuard check fail: Unity Ads web bridge class not found", e);
            return false;
        } catch (NoSuchMethodException e2) {
            DeviceLog.exception("Unity Ads ProGuard check fail: Unity Ads web bridge methods not found", e2);
            return false;
        } catch (Exception e3) {
            DeviceLog.exception("Unknown exception during Unity Ads ProGuard check: " + e3.getMessage(), e3);
            return true;
        }
    }

    public static boolean testCacheDirectory() {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        File webViewCacheDirectory = SdkProperties.getWebViewCacheDirectory();
        if (cacheDirectory != null && webViewCacheDirectory != null) {
            DeviceLog.debug("Unity Ads cache directory check OK");
            return true;
        }
        DeviceLog.error("Unity Ads cache directory check fail: no working cache directory available");
        return false;
    }

    private static boolean hasJavascriptInterface(Method method) {
        Annotation[] annotations = method.getAnnotations();
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof JavascriptInterface) {
                    return true;
                }
            }
        }
        return false;
    }
}

// ===== FILE: com/unity3d/services/core/configuration/ErrorState.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public enum ErrorState {
    CreateWebApp("create_webapp"),
    NetworkConfigRequest("network_config"),
    NetworkWebviewRequest("network_webview"),
    InvalidHash("invalid_hash"),
    CreateWebview("create_webview"),
    MalformedWebviewRequest("malformed_webview"),
    ResetWebApp("reset_webapp"),
    LoadCache("load_cache"),
    InitModules("init_modules"),
    CreateWebviewTimeout("create_webview_timeout"),
    CreateWebviewGameIdDisabled("create_webview_game_id_disabled"),
    CreateWebviewConfigError("create_webview_config_error"),
    CreateWebviewInvalidArgument("create_webview_invalid_arg");

    private String _stateMetricName;

    ErrorState(String str) {
        this._stateMetricName = str;
    }

    public String getMetricName() {
        return this._stateMetricName;
    }
}

// ===== FILE: com/unity3d/services/core/configuration/ExperimentAppliedRule.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public enum ExperimentAppliedRule {
    NEXT,
    IMMEDIATE
}

// ===== FILE: com/unity3d/services/core/configuration/ExperimentObject.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.log.DeviceLog;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ExperimentObject {
    private static final String APPLIED_KEY = "applied";
    private static final String VALUE_KEY = "value";
    private final JSONObject _experimentData;

    public ExperimentObject(JSONObject jSONObject) {
        this._experimentData = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public String getStringValue() {
        return this._experimentData.optString(VALUE_KEY);
    }

    public boolean getBooleanValue() {
        return this._experimentData.optBoolean(VALUE_KEY);
    }

    public ExperimentAppliedRule getAppliedRule() {
        ExperimentAppliedRule experimentAppliedRule = ExperimentAppliedRule.NEXT;
        String optString = this._experimentData.optString(APPLIED_KEY);
        if (optString.isEmpty()) {
            return experimentAppliedRule;
        }
        try {
            return ExperimentAppliedRule.valueOf(optString.toUpperCase());
        } catch (IllegalArgumentException unused) {
            DeviceLog.warning("Invalid rule %s for experiment", optString);
            return experimentAppliedRule;
        }
    }
}

// ===== FILE: com/unity3d/services/core/configuration/ExperimentObjects.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType;
import com.unity3d.services.core.network.core.OkHttp3Client;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ExperimentObjects extends ExperimentsBase {
    private final Map<String, ExperimentObject> _experimentObjects = new HashMap();
    private final JSONObject _experimentObjetsData;

    public ExperimentObjects(JSONObject jSONObject) {
        if (jSONObject != null) {
            this._experimentObjetsData = jSONObject;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this._experimentObjects.put(next, new ExperimentObject(jSONObject.optJSONObject(next)));
            }
            return;
        }
        this._experimentObjetsData = new JSONObject();
    }

    public ExperimentObject getExperimentObject(String str) {
        return this._experimentObjects.get(str);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean shouldNativeTokenAwaitPrivacy() {
        return getExperimentValueOrDefault("tsi_prw");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebAssetAdCaching() {
        return getExperimentValueOrDefault("wac");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebGestureNotRequired() {
        return getExperimentValueOrDefault("wgr");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isScarInitEnabled() {
        return getExperimentValueOrDefault("scar_init");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isJetpackLifecycle() {
        return getExperimentValueOrDefault("gjl");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isOkHttpEnabled() {
        return getExperimentValueOrDefault(OkHttp3Client.NETWORK_CLIENT_OKHTTP);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebMessageEnabled() {
        return getExperimentValueOrDefault("jwm");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebViewAsyncDownloadEnabled() {
        return getExperimentValueOrDefault("wad");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isNativeShowTimeoutDisabled() {
        return getExperimentValueOrDefault("nstd");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isNativeLoadTimeoutDisabled() {
        return getExperimentValueOrDefault("nltd");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isCaptureHDRCapabilitiesEnabled() {
        return getExperimentValueOrDefault("hdrc");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isScarBannerHbEnabled() {
        return getExperimentValueOrDefault("scar_bn");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public String getScarBiddingManager() {
        return getExperimentValue("scar_bm", ScarBiddingManagerType.DISABLED.getName());
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isPCCheckEnabled() {
        return getExperimentValueOrDefault("pc_check");
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isBoldSdkNextSessionEnabled() {
        return getExperimentValueOrDefault(ExperimentsBase.EXP_TAG_IS_BOLD_NEXT_SESSION);
    }

    private String getExperimentValue(String str, String str2) {
        ExperimentObject experimentObject = getExperimentObject(str);
        return experimentObject != null ? experimentObject.getStringValue() : str2;
    }

    private boolean getExperimentValue(String str, boolean z) {
        ExperimentObject experimentObject = getExperimentObject(str);
        return experimentObject != null ? experimentObject.getBooleanValue() : z;
    }

    private boolean getExperimentValueOrDefault(String str) {
        return getExperimentValue(str, false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getExperimentsAsJson() {
        return this._experimentObjetsData;
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public Map<String, String> getExperimentTags() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ExperimentObject> entry : this._experimentObjects.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().getStringValue());
        }
        return hashMap;
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getCurrentSessionExperiments() {
        return getExperimentWithAppliedRule(ExperimentAppliedRule.IMMEDIATE);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getNextSessionExperiments() {
        return getExperimentWithAppliedRule(ExperimentAppliedRule.NEXT);
    }

    private JSONObject getExperimentWithAppliedRule(ExperimentAppliedRule experimentAppliedRule) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ExperimentObject> entry : this._experimentObjects.entrySet()) {
            if (entry.getValue().getAppliedRule() == experimentAppliedRule) {
                hashMap.put(entry.getKey(), entry.getValue().getStringValue());
            }
        }
        return new JSONObject(hashMap);
    }
}

// ===== FILE: com/unity3d/services/core/configuration/Experiments.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType;
import com.unity3d.services.core.network.core.OkHttp3Client;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Experiments extends ExperimentsBase {
    private static final Set<String> NEXT_SESSION_FLAGS = new HashSet(Collections.singletonList("tsi_prw"));
    private final JSONObject _experimentData;

    public Experiments() {
        this(null);
    }

    public Experiments(JSONObject jSONObject) {
        if (jSONObject == null) {
            this._experimentData = new JSONObject();
        } else {
            this._experimentData = jSONObject;
        }
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean shouldNativeTokenAwaitPrivacy() {
        return this._experimentData.optBoolean("tsi_prw", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebAssetAdCaching() {
        return this._experimentData.optBoolean("wac", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebGestureNotRequired() {
        return this._experimentData.optBoolean("wgr", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isScarInitEnabled() {
        return this._experimentData.optBoolean("scar_init", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isScarBannerHbEnabled() {
        return this._experimentData.optBoolean("scar_bn", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public String getScarBiddingManager() {
        return this._experimentData.optString("scar_bm", ScarBiddingManagerType.DISABLED.getName());
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isJetpackLifecycle() {
        return this._experimentData.optBoolean("gjl", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isOkHttpEnabled() {
        return this._experimentData.optBoolean(OkHttp3Client.NETWORK_CLIENT_OKHTTP, false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebMessageEnabled() {
        return this._experimentData.optBoolean("jwm", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebViewAsyncDownloadEnabled() {
        return this._experimentData.optBoolean("wad", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isNativeShowTimeoutDisabled() {
        return this._experimentData.optBoolean("nstd", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isNativeLoadTimeoutDisabled() {
        return this._experimentData.optBoolean("nltd", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isCaptureHDRCapabilitiesEnabled() {
        return this._experimentData.optBoolean("hdrc", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isPCCheckEnabled() {
        return this._experimentData.optBoolean("pc_check", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isBoldSdkNextSessionEnabled() {
        return this._experimentData.optBoolean(ExperimentsBase.EXP_TAG_IS_BOLD_NEXT_SESSION, false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getExperimentsAsJson() {
        return this._experimentData;
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public Map<String, String> getExperimentTags() {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = this._experimentData.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, String.valueOf(this._experimentData.opt(next)));
        }
        return hashMap;
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getNextSessionExperiments() {
        if (this._experimentData == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = this._experimentData.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (NEXT_SESSION_FLAGS.contains(next)) {
                hashMap.put(next, String.valueOf(this._experimentData.optBoolean(next)));
            }
        }
        return new JSONObject(hashMap);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getCurrentSessionExperiments() {
        if (this._experimentData == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = this._experimentData.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!NEXT_SESSION_FLAGS.contains(next)) {
                hashMap.put(next, String.valueOf(this._experimentData.optBoolean(next)));
            }
        }
        return new JSONObject(hashMap);
    }
}

// ===== FILE: com/unity3d/services/core/configuration/ExperimentsBase.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public abstract class ExperimentsBase implements IExperiments {
    static final boolean EXP_DEFAULT_VALUE = false;
    static final String EXP_TAG_HDR_CAPABILITIES = "hdrc";
    public static final String EXP_TAG_IS_BOLD_NEXT_SESSION = "boldSdkNextSessionEnabled";
    static final String EXP_TAG_IS_PC_CHECK_ENABLED = "pc_check";
    static final String EXP_TAG_JETPACK_LIFECYCLE = "gjl";
    static final String EXP_TAG_LOAD_TIMEOUT_DISABLED = "nltd";
    static final String EXP_TAG_OK_HTTP = "okhttp";
    static final String EXP_TAG_SCAR_BIDDING_MANAGER = "scar_bm";
    static final String EXP_TAG_SCAR_HB_BN = "scar_bn";
    static final String EXP_TAG_SCAR_INIT = "scar_init";
    static final String EXP_TAG_SHOW_TIMEOUT_DISABLED = "nstd";
    static final String EXP_TAG_WEBVIEW_ASYNC_DOWNLOAD = "wad";
    static final String EXP_TAG_WEB_AD_ASSET_CACHING = "wac";
    static final String EXP_TAG_WEB_GESTURE_NOT_REQUIRED = "wgr";
    static final String EXP_TAG_WEB_MESSAGE = "jwm";
    static final String TSI_TAG_NATIVE_TOKEN_AWAIT_PRIVACY = "tsi_prw";
}

// ===== FILE: com/unity3d/services/core/configuration/ExperimentsReader.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import org.json.JSONException;

/* loaded from: classes.dex */
public class ExperimentsReader {
    private IExperiments _localExperiments;
    private IExperiments _remoteExperiments;

    public synchronized void updateLocalExperiments(IExperiments iExperiments) {
        this._localExperiments = iExperiments;
    }

    public synchronized void updateRemoteExperiments(IExperiments iExperiments) {
        this._remoteExperiments = iExperiments;
    }

    public synchronized IExperiments getCurrentlyActiveExperiments() {
        IExperiments iExperiments = this._remoteExperiments;
        if (iExperiments == null && this._localExperiments == null) {
            return new Experiments();
        }
        if (iExperiments == null) {
            return this._localExperiments;
        }
        if (this._localExperiments == null) {
            this._localExperiments = new Experiments();
        }
        try {
            return new Experiments(Utilities.mergeJsonObjects(this._localExperiments.getNextSessionExperiments(), this._remoteExperiments.getCurrentSessionExperiments()));
        } catch (JSONException unused) {
            DeviceLog.error("Couldn't get active experiments, reverting to default experiments");
            return new Experiments();
        }
    }
}

// ===== FILE: com/unity3d/services/core/configuration/IConfigurationLoader.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public interface IConfigurationLoader {
    Configuration getLocalConfiguration();

    void loadConfiguration(IConfigurationLoaderListener iConfigurationLoaderListener) throws Exception;
}

// ===== FILE: com/unity3d/services/core/configuration/IConfigurationLoaderListener.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public interface IConfigurationLoaderListener {
    void onError(String str);

    void onSuccess(Configuration configuration);
}

// ===== FILE: com/unity3d/services/core/configuration/IExperiments.java =====
package com.unity3d.services.core.configuration;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IExperiments {
    JSONObject getCurrentSessionExperiments();

    Map<String, String> getExperimentTags();

    JSONObject getExperimentsAsJson();

    JSONObject getNextSessionExperiments();

    String getScarBiddingManager();

    boolean isBoldSdkNextSessionEnabled();

    boolean isCaptureHDRCapabilitiesEnabled();

    boolean isJetpackLifecycle();

    boolean isNativeLoadTimeoutDisabled();

    boolean isNativeShowTimeoutDisabled();

    boolean isOkHttpEnabled();

    boolean isPCCheckEnabled();

    boolean isScarBannerHbEnabled();

    boolean isScarInitEnabled();

    boolean isWebAssetAdCaching();

    boolean isWebGestureNotRequired();

    boolean isWebMessageEnabled();

    boolean isWebViewAsyncDownloadEnabled();

    boolean shouldNativeTokenAwaitPrivacy();
}

// ===== FILE: com/unity3d/services/core/configuration/IInitializationListener.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public interface IInitializationListener {
    void onSdkInitializationFailed(String str, ErrorState errorState, int i);

    void onSdkInitialized();
}

// ===== FILE: com/unity3d/services/core/configuration/IInitializationNotificationCenter.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public interface IInitializationNotificationCenter {
    void addListener(IInitializationListener iInitializationListener);

    void removeListener(IInitializationListener iInitializationListener);

    void triggerOnSdkInitializationFailed(String str, ErrorState errorState, int i);

    void triggerOnSdkInitialized();
}

// ===== FILE: com/unity3d/services/core/configuration/IInitializeEventsMetricSender.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.request.metrics.Metric;
import java.util.Map;

/* loaded from: classes.dex */
public interface IInitializeEventsMetricSender {
    Long configRequestDuration();

    void didConfigRequestEnd(boolean z);

    void didConfigRequestStart();

    void didInitStart();

    void didPrivacyConfigRequestEnd(boolean z);

    void didPrivacyConfigRequestStart();

    Long duration();

    Map<String, String> getRetryTags();

    Long initializationStartTimeStamp();

    void onRetryConfig();

    void onRetryWebview();

    Long privacyConfigDuration();

    void sdkDidInitialize();

    void sdkInitializeFailed(String str, ErrorState errorState);

    void sdkTokenDidBecomeAvailableWithConfig(boolean z);

    void sendMetric(Metric metric);

    Long tokenDuration();
}

// ===== FILE: com/unity3d/services/core/configuration/IModuleConfiguration.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public interface IModuleConfiguration {
    Class[] getWebAppApiClassList();

    boolean initCompleteState(Configuration configuration);

    boolean initErrorState(Configuration configuration, ErrorState errorState, String str);

    boolean resetState(Configuration configuration);
}

// ===== FILE: com/unity3d/services/core/configuration/IPrivacyConfigurationListener.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public interface IPrivacyConfigurationListener {
    void onError(PrivacyCallError privacyCallError, String str);

    void onSuccess(PrivacyConfig privacyConfig);
}

// ===== FILE: com/unity3d/services/core/configuration/InitRequestType.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public enum InitRequestType {
    PRIVACY("privacy"),
    TOKEN("token_srr");

    private String _callType;

    InitRequestType(String str) {
        this._callType = str;
    }

    public String getCallType() {
        return this._callType;
    }
}

// ===== FILE: com/unity3d/services/core/configuration/InitializationNotificationCenter.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class InitializationNotificationCenter implements IInitializationNotificationCenter {
    private static InitializationNotificationCenter instance;
    private HashMap<Integer, IInitializationListener> _sdkListeners = new HashMap<>();

    public static InitializationNotificationCenter getInstance() {
        if (instance == null) {
            instance = new InitializationNotificationCenter();
        }
        return instance;
    }

    @Override // com.unity3d.services.core.configuration.IInitializationNotificationCenter
    public void addListener(IInitializationListener iInitializationListener) {
        synchronized (this._sdkListeners) {
            if (iInitializationListener != null) {
                this._sdkListeners.put(new Integer(iInitializationListener.hashCode()), iInitializationListener);
            }
        }
    }

    @Override // com.unity3d.services.core.configuration.IInitializationNotificationCenter
    public void removeListener(IInitializationListener iInitializationListener) {
        synchronized (this._sdkListeners) {
            if (iInitializationListener != null) {
                removeListener(new Integer(iInitializationListener.hashCode()));
            }
        }
    }

    @Override // com.unity3d.services.core.configuration.IInitializationNotificationCenter
    public void triggerOnSdkInitialized() {
        synchronized (this._sdkListeners) {
            ArrayList arrayList = new ArrayList();
            for (final Map.Entry<Integer, IInitializationListener> entry : this._sdkListeners.entrySet()) {
                if (entry.getValue() != null) {
                    Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.configuration.InitializationNotificationCenter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IInitializationListener) entry.getValue()).onSdkInitialized();
                        }
                    });
                } else {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this._sdkListeners.remove((Integer) it.next());
            }
        }
    }

    @Override // com.unity3d.services.core.configuration.IInitializationNotificationCenter
    public void triggerOnSdkInitializationFailed(String str, final ErrorState errorState, final int i) {
        synchronized (this._sdkListeners) {
            final String str2 = "SDK Failed to Initialize due to " + str;
            DeviceLog.error(str2);
            ArrayList arrayList = new ArrayList();
            for (final Map.Entry<Integer, IInitializationListener> entry : this._sdkListeners.entrySet()) {
                if (entry.getValue() != null) {
                    Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.configuration.InitializationNotificationCenter.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IInitializationListener) entry.getValue()).onSdkInitializationFailed(str2, errorState, i);
                        }
                    });
                } else {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this._sdkListeners.remove((Integer) it.next());
            }
        }
    }

    private void removeListener(Integer num) {
        this._sdkListeners.remove(num);
    }
}

// ===== FILE: com/unity3d/services/core/configuration/InitializeEventsMetricSender.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class InitializeEventsMetricSender implements IInitializeEventsMetricSender, IInitializationListener {
    private static InitializeEventsMetricSender _instance;
    private long _startTime = 0;
    private long _privacyConfigStartTime = 0;
    private long _privacyConfigEndTime = 0;
    private long _configStartTime = 0;
    private long _configEndTime = 0;
    private int _configRetryCount = 0;
    private int _webviewRetryCount = 0;
    private boolean _initMetricSent = false;
    private boolean _tokenMetricSent = false;
    private final SDKMetricsSender _sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);

    public static IInitializeEventsMetricSender getInstance() {
        if (_instance == null) {
            _instance = new InitializeEventsMetricSender();
        }
        return _instance;
    }

    private InitializeEventsMetricSender() {
        InitializationNotificationCenter.getInstance().addListener(this);
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public void didInitStart() {
        this._startTime = System.nanoTime();
        this._configRetryCount = 0;
        this._webviewRetryCount = 0;
        sendMetric(TSIMetric.newInitStarted());
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public void didConfigRequestStart() {
        this._configStartTime = System.nanoTime();
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public void didConfigRequestEnd(boolean z) {
        this._configEndTime = System.nanoTime();
        sendConfigResolutionRequestIfNeeded(z);
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public void didPrivacyConfigRequestStart() {
        this._privacyConfigStartTime = System.nanoTime();
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public void didPrivacyConfigRequestEnd(boolean z) {
        this._privacyConfigEndTime = System.nanoTime();
        sendPrivacyResolutionRequestIfNeeded(z);
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public synchronized void sdkDidInitialize() {
        if (initializationStartTimeStamp().longValue() == 0) {
            DeviceLog.debug("sdkDidInitialize called before didInitStart, skipping metric");
        }
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public Long initializationStartTimeStamp() {
        return Long.valueOf(this._startTime);
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public synchronized void sdkInitializeFailed(String str, ErrorState errorState) {
        if (this._startTime == 0) {
            DeviceLog.debug("sdkInitializeFailed called before didInitStart, skipping metric");
        }
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public synchronized void sdkTokenDidBecomeAvailableWithConfig(boolean z) {
        if (!this._tokenMetricSent) {
            sendTokenAvailabilityMetricWithConfig(z);
            if (z) {
                sendTokenResolutionRequestMetricIfNeeded();
            }
            this._tokenMetricSent = true;
        }
    }

    private void sendTokenAvailabilityMetricWithConfig(boolean z) {
        Metric newTokenAvailabilityLatencyWebview;
        if (this._startTime == 0) {
            DeviceLog.debug("sendTokenAvailabilityMetricWithConfig called before didInitStart, skipping metric");
            return;
        }
        Long valueOf = Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this._startTime));
        Map<String, String> retryTags = getRetryTags();
        if (z) {
            newTokenAvailabilityLatencyWebview = TSIMetric.newTokenAvailabilityLatencyConfig(valueOf, retryTags);
        } else {
            newTokenAvailabilityLatencyWebview = TSIMetric.newTokenAvailabilityLatencyWebview(valueOf, retryTags);
        }
        sendMetric(newTokenAvailabilityLatencyWebview);
    }

    private void sendTokenResolutionRequestMetricIfNeeded() {
        if (this._configStartTime == 0) {
            DeviceLog.debug("sendTokenResolutionRequestMetricIfNeeded called before didInitStart, skipping metric");
        } else {
            sendMetric(TSIMetric.newTokenResolutionRequestLatency(tokenDuration(), getRetryTags()));
        }
    }

    private void sendPrivacyResolutionRequestIfNeeded(boolean z) {
        if (this._privacyConfigStartTime == 0 || this._privacyConfigEndTime == 0) {
            DeviceLog.debug("sendPrivacyResolutionRequestIfNeeded called with invalid timestamps, skipping metric");
        } else {
            sendMetric(getPrivacyRequestMetric(z));
        }
    }

    private Metric getPrivacyRequestMetric(boolean z) {
        if (z) {
            return TSIMetric.newPrivacyRequestLatencySuccess(privacyConfigDuration());
        }
        return TSIMetric.newPrivacyRequestLatencyFailure(privacyConfigDuration());
    }

    private void sendConfigResolutionRequestIfNeeded(boolean z) {
        if (this._configStartTime == 0 || this._configEndTime == 0) {
            DeviceLog.debug("sendConfigResolutionRequestIfNeeded called with invalid timestamps, skipping metric");
        } else if (z) {
            sendMetric(TSIMetric.newConfigRequestLatencySuccess(configRequestDuration()));
        } else {
            sendMetric(TSIMetric.newConfigRequestLatencyFailure(configRequestDuration()));
        }
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public void onRetryConfig() {
        this._configRetryCount++;
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public void onRetryWebview() {
        this._webviewRetryCount++;
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public Long duration() {
        return Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this._startTime));
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public Long tokenDuration() {
        return Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this._configStartTime));
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public Long privacyConfigDuration() {
        return Long.valueOf(TimeUnit.NANOSECONDS.toMillis(this._privacyConfigEndTime - this._privacyConfigStartTime));
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public Long configRequestDuration() {
        return Long.valueOf(TimeUnit.NANOSECONDS.toMillis(this._configEndTime - this._configStartTime));
    }

    public Map<String, String> getErrorStateTags(ErrorState errorState) {
        Map<String, String> retryTags = getRetryTags();
        retryTags.put("stt", errorState.getMetricName());
        return retryTags;
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public Map<String, String> getRetryTags() {
        return new HashMap<String, String>() { // from class: com.unity3d.services.core.configuration.InitializeEventsMetricSender.1
            {
                put("c_retry", String.valueOf(InitializeEventsMetricSender.this._configRetryCount));
                put("wv_retry", String.valueOf(InitializeEventsMetricSender.this._webviewRetryCount));
            }
        };
    }

    @Override // com.unity3d.services.core.configuration.IInitializeEventsMetricSender
    public void sendMetric(Metric metric) {
        this._sdkMetricsSender.sendMetric(metric);
    }

    @Override // com.unity3d.services.core.configuration.IInitializationListener
    public void onSdkInitialized() {
        sdkDidInitialize();
    }

    @Override // com.unity3d.services.core.configuration.IInitializationListener
    public void onSdkInitializationFailed(String str, ErrorState errorState, int i) {
        sdkInitializeFailed(str, errorState);
    }
}

// ===== FILE: com/unity3d/services/core/configuration/InitializeThread.java =====
package com.unity3d.services.core.configuration;

import android.os.ConditionVariable;
import android.text.TextUtils;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.api.DownloadLatestWebViewStatus;
import com.unity3d.services.core.api.Lifecycle;
import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.connectivity.IConnectivityListener;
import com.unity3d.services.core.device.reader.DeviceInfoDataFactory;
import com.unity3d.services.core.lifecycle.CachedLifecycle;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import com.unity3d.services.core.webview.WebView;
import com.unity3d.services.core.webview.WebViewApp;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InitializeThread extends Thread {
    private static InitializeThread _thread;
    private InitializeState _state;
    private String _stateName;
    private long _stateStartTimestamp;
    private boolean _stopThread = false;
    private boolean _didRetry = false;
    private final SDKMetricsSender _sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);

    private int getStatePrefixLength() {
        return 15;
    }

    private InitializeThread(InitializeState initializeState) {
        this._state = initializeState;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            try {
                InitializeState initializeState = this._state;
                if (initializeState == null || this._stopThread) {
                    break;
                }
                try {
                    handleStateStartMetrics(initializeState);
                    InitializeState execute = this._state.execute();
                    this._state = execute;
                    handleStateEndMetrics(execute);
                } catch (Exception e) {
                    DeviceLog.exception("Unity Ads SDK encountered an error during initialization, cancel initialization", e);
                    Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.configuration.InitializeThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK encountered an error during initialization, cancel initialization");
                        }
                    });
                    this._state = new InitializeStateForceReset();
                } catch (OutOfMemoryError e2) {
                    DeviceLog.exception("Unity Ads SDK failed to initialize due to application doesn't have enough memory to initialize Unity Ads SDK", new Exception(e2));
                    Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.configuration.InitializeThread.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to application doesn't have enough memory to initialize Unity Ads SDK");
                        }
                    });
                    this._state = new InitializeStateForceReset();
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        _thread = null;
    }

    public void quit() {
        this._stopThread = true;
    }

    public static synchronized void initialize(Configuration configuration) {
        synchronized (InitializeThread.class) {
            if (_thread == null) {
                InitializeEventsMetricSender.getInstance().didInitStart();
                CachedLifecycle.register();
                InitializeThread initializeThread = new InitializeThread(new InitializeStateLoadConfigFile(configuration));
                _thread = initializeThread;
                initializeThread.setName("UnityAdsInitializeThread");
                _thread.start();
            }
        }
    }

    public static synchronized void reset() {
        synchronized (InitializeThread.class) {
            if (_thread == null) {
                InitializeThread initializeThread = new InitializeThread(new InitializeStateForceReset());
                _thread = initializeThread;
                initializeThread.setName("UnityAdsResetThread");
                _thread.start();
            }
        }
    }

    public static synchronized DownloadLatestWebViewStatus downloadLatestWebView() {
        synchronized (InitializeThread.class) {
            if (_thread != null) {
                return DownloadLatestWebViewStatus.INIT_QUEUE_NOT_EMPTY;
            }
            if (SdkProperties.getLatestConfiguration() == null) {
                return DownloadLatestWebViewStatus.MISSING_LATEST_CONFIG;
            }
            InitializeThread initializeThread = new InitializeThread(new InitializeStateCheckForCachedWebViewUpdate(SdkProperties.getLatestConfiguration()));
            _thread = initializeThread;
            initializeThread.setName("UnityAdsDownloadThread");
            _thread.start();
            return DownloadLatestWebViewStatus.BACKGROUND_DOWNLOAD_STARTED;
        }
    }

    private void handleStateStartMetrics(InitializeState initializeState) {
        if (isRetryState(initializeState)) {
            this._didRetry = true;
        } else {
            if (!this._didRetry) {
                this._stateStartTimestamp = System.nanoTime();
            }
            this._didRetry = false;
        }
        this._stateName = getMetricNameForState(initializeState);
    }

    private void handleStateEndMetrics(InitializeState initializeState) {
        if (this._stateName == null || isRetryState(initializeState) || this._stateName.equals("native_retry_state")) {
            return;
        }
        this._sdkMetricsSender.sendMetric(new Metric(this._stateName, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this._stateStartTimestamp)), getMetricTagsForState()));
    }

    private Map<String, String> getMetricTagsForState() {
        return InitializeEventsMetricSender.getInstance().getRetryTags();
    }

    private String getMetricNameForState(InitializeState initializeState) {
        if (initializeState == null) {
            return null;
        }
        String simpleName = initializeState.getClass().getSimpleName();
        if (simpleName.length() == 0) {
            return null;
        }
        String lowerCase = simpleName.substring(getStatePrefixLength()).toLowerCase();
        StringBuilder sb = new StringBuilder(7 + lowerCase.length() + 6);
        sb.append("native_");
        sb.append(lowerCase);
        sb.append("_state");
        return sb.toString();
    }

    private boolean isRetryState(InitializeState initializeState) {
        return initializeState instanceof InitializeStateRetry;
    }

    private static abstract class InitializeState {
        public abstract InitializeState execute();

        private InitializeState() {
        }
    }

    public static class InitializeStateLoadConfigFile extends InitializeState {
        private Configuration _configuration;

        public InitializeStateLoadConfigFile(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: Loading Config File Parameters");
            File file = new File(SdkProperties.getLocalConfigurationFilepath());
            if (!file.exists()) {
                return new InitializeStateReset(this._configuration);
            }
            try {
                this._configuration = new Configuration(new JSONObject(new String(Utilities.readFileBytes(file))));
            } catch (Exception unused) {
                DeviceLog.debug("Unity Ads init: Using default configuration parameters");
            }
            return new InitializeStateReset(this._configuration);
        }
    }

    public static class InitializeStateReset extends InitializeState {
        private Configuration _configuration;
        private int _resetWebAppTimeout;

        public InitializeStateReset(Configuration configuration) {
            super();
            this._configuration = configuration;
            this._resetWebAppTimeout = configuration.getResetWebappTimeout();
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            boolean z;
            DeviceLog.debug("Unity Ads init: starting init");
            final ConditionVariable conditionVariable = new ConditionVariable();
            final WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                currentApp.resetWebViewAppInitialization();
                if (currentApp.getWebView() != null) {
                    Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.configuration.InitializeThread.InitializeStateReset.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WebView webView = currentApp.getWebView();
                            if (webView != null) {
                                webView.destroy();
                                currentApp.setWebView(null);
                            }
                            conditionVariable.open();
                        }
                    });
                    z = conditionVariable.block(this._resetWebAppTimeout);
                } else {
                    z = true;
                }
                if (!z) {
                    return new InitializeStateError(ErrorState.ResetWebApp, new Exception("Reset failed on opening ConditionVariable"), this._configuration);
                }
            }
            unregisterLifecycleCallbacks();
            SdkProperties.setCacheDirectory(null);
            if (SdkProperties.getCacheDirectory() == null) {
                return new InitializeStateError(ErrorState.ResetWebApp, new Exception("Cache directory is NULL"), this._configuration);
            }
            SdkProperties.setWebViewCacheDirectory(null);
            if (SdkProperties.getWebViewCacheDirectory() == null) {
                return new InitializeStateError(ErrorState.ResetWebApp, new Exception("WebView cache directory is NULL"), this._configuration);
            }
            SdkProperties.setInitialized(false);
            for (Class cls : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration = this._configuration.getModuleConfiguration(cls);
                if (moduleConfiguration != null) {
                    moduleConfiguration.resetState(this._configuration);
                }
            }
            return new InitializeStateInitModules(this._configuration);
        }

        private void unregisterLifecycleCallbacks() {
            if (Lifecycle.getLifecycleListener() != null) {
                if (ClientProperties.getApplication() != null) {
                    ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener());
                }
                Lifecycle.setLifecycleListener(null);
            }
        }
    }

    public static class InitializeStateForceReset extends InitializeStateReset {
        public InitializeStateForceReset() {
            super(new Configuration());
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeStateReset, com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            SdkProperties.setInitializeState(SdkProperties.InitializationState.NOT_INITIALIZED);
            super.execute();
            return null;
        }
    }

    public static class InitializeStateInitModules extends InitializeState {
        private Configuration _configuration;

        public InitializeStateInitModules(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            return new InitializeStateConfig(this._configuration);
        }
    }

    public static class InitializeStateConfig extends InitializeState {
        private Configuration _configuration;
        private Configuration _localConfig;
        private int _maxRetries;
        private InitializeState _nextState;
        private int _retries;
        private long _retryDelay;
        private double _scalingFactor;

        public InitializeStateConfig(Configuration configuration) {
            super();
            this._configuration = new Configuration(SdkProperties.getConfigUrl(), configuration.getExperimentsReader());
            this._retries = 0;
            this._retryDelay = configuration.getRetryDelay();
            this._maxRetries = configuration.getMaxRetries();
            this._scalingFactor = configuration.getRetryScalingFactor();
            this._localConfig = configuration;
            this._nextState = null;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.info("Unity Ads init: load configuration from " + SdkProperties.getConfigUrl());
            return executeWithLoader();
        }

        public InitializeState executeLegacy(Configuration configuration) {
            try {
                configuration.makeRequest();
                if (configuration.getDelayWebViewUpdate()) {
                    return new InitializeStateLoadCacheConfigAndWebView(configuration, this._localConfig);
                }
                return new InitializeStateLoadCache(configuration);
            } catch (Exception e) {
                if (this._retries < this._maxRetries) {
                    this._retryDelay = (long) (this._retryDelay * this._scalingFactor);
                    this._retries++;
                    InitializeEventsMetricSender.getInstance().onRetryConfig();
                    return new InitializeStateRetry(this, this._retryDelay);
                }
                return new InitializeStateNetworkError(ErrorState.NetworkConfigRequest, e, this, this._localConfig);
            }
        }

        public InitializeState executeWithLoader() {
            final SDKMetricsSender sDKMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
            HttpClient httpClient = (HttpClient) Utilities.getService(HttpClient.class);
            PrivacyConfigStorage privacyConfigStorage = PrivacyConfigStorage.getInstance();
            DeviceInfoDataFactory deviceInfoDataFactory = new DeviceInfoDataFactory(sDKMetricsSender);
            PrivacyConfigurationLoader privacyConfigurationLoader = new PrivacyConfigurationLoader(new ConfigurationLoader(new ConfigurationRequestFactory(this._configuration, deviceInfoDataFactory.getDeviceInfoData(InitRequestType.TOKEN)), sDKMetricsSender, httpClient), new ConfigurationRequestFactory(this._configuration, deviceInfoDataFactory.getDeviceInfoData(InitRequestType.PRIVACY)), privacyConfigStorage, httpClient);
            final Configuration configuration = new Configuration(SdkProperties.getConfigUrl());
            try {
                privacyConfigurationLoader.loadConfiguration(new IConfigurationLoaderListener() { // from class: com.unity3d.services.core.configuration.InitializeThread.InitializeStateConfig.1
                    @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                    public void onSuccess(Configuration configuration2) {
                        InitializeStateConfig.this._configuration = configuration2;
                        InitializeStateConfig.this._configuration.saveToDisk();
                        if (InitializeStateConfig.this._configuration.getDelayWebViewUpdate()) {
                            InitializeStateConfig initializeStateConfig = InitializeStateConfig.this;
                            initializeStateConfig._nextState = new InitializeStateLoadCacheConfigAndWebView(initializeStateConfig._configuration, InitializeStateConfig.this._localConfig);
                        }
                        ((TokenStorage) Utilities.getService(TokenStorage.class)).setInitToken(InitializeStateConfig.this._configuration.getUnifiedAuctionToken());
                        InitializeStateConfig initializeStateConfig2 = InitializeStateConfig.this;
                        initializeStateConfig2._nextState = new InitializeStateLoadCache(initializeStateConfig2._configuration);
                    }

                    @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                    public void onError(String str) {
                        sDKMetricsSender.sendMetric(TSIMetric.newEmergencySwitchOff());
                        InitializeStateConfig initializeStateConfig = InitializeStateConfig.this;
                        initializeStateConfig._nextState = initializeStateConfig.executeLegacy(configuration);
                    }
                });
                return this._nextState;
            } catch (Exception e) {
                int i = this._retries;
                if (i < this._maxRetries) {
                    this._retryDelay = (long) (this._retryDelay * this._scalingFactor);
                    this._retries = i + 1;
                    InitializeEventsMetricSender.getInstance().onRetryConfig();
                    return new InitializeStateRetry(this, this._retryDelay);
                }
                return new InitializeStateNetworkError(ErrorState.NetworkConfigRequest, e, this, this._configuration);
            }
        }
    }

    public static class InitializeStateLoadCache extends InitializeState {
        private Configuration _configuration;

        public InitializeStateLoadCache(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            try {
                byte[] readFileBytes = Utilities.readFileBytes(new File(SdkProperties.getLocalWebViewFile()));
                String Sha256 = Utilities.Sha256(readFileBytes);
                if (Sha256 != null && Sha256.equals(this._configuration.getWebViewHash())) {
                    try {
                        String str = new String(readFileBytes, "UTF-8");
                        DeviceLog.info("Unity Ads init: webapp loaded from local cache");
                        return new InitializeStateCreate(this._configuration, str);
                    } catch (Exception e) {
                        return new InitializeStateError(ErrorState.LoadCache, e, this._configuration);
                    }
                }
                return new InitializeStateLoadWeb(this._configuration);
            } catch (Exception e2) {
                DeviceLog.debug("Unity Ads init: webapp not found in local cache: " + e2.getMessage());
                return new InitializeStateLoadWeb(this._configuration);
            }
        }
    }

    public static class InitializeStateLoadWeb extends InitializeState {
        private Configuration _configuration;
        private HttpClient _httpClient;
        private int _maxRetries;
        private int _retries;
        private long _retryDelay;
        private double _scalingFactor;

        public InitializeStateLoadWeb(Configuration configuration) {
            super();
            this._httpClient = (HttpClient) Utilities.getService(HttpClient.class);
            this._configuration = configuration;
            this._retries = 0;
            this._retryDelay = configuration.getRetryDelay();
            this._maxRetries = configuration.getMaxRetries();
            this._scalingFactor = configuration.getRetryScalingFactor();
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.info("Unity Ads init: loading webapp from " + this._configuration.getWebViewUrl());
            try {
                try {
                    String obj = this._httpClient.executeBlocking(new HttpRequest(this._configuration.getWebViewUrl())).getBody().toString();
                    String webViewHash = this._configuration.getWebViewHash();
                    if (webViewHash != null && !Utilities.Sha256(obj).equals(webViewHash)) {
                        return new InitializeStateError(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), this._configuration);
                    }
                    if (webViewHash != null) {
                        Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), obj);
                    }
                    return new InitializeStateCreate(this._configuration, obj);
                } catch (Exception e) {
                    int i = this._retries;
                    if (i < this._maxRetries) {
                        this._retryDelay = (long) (this._retryDelay * this._scalingFactor);
                        this._retries = i + 1;
                        InitializeEventsMetricSender.getInstance().onRetryWebview();
                        return new InitializeStateRetry(this, this._retryDelay);
                    }
                    return new InitializeStateNetworkError(ErrorState.NetworkWebviewRequest, e, this, this._configuration);
                }
            } catch (Exception e2) {
                DeviceLog.exception("Malformed URL", e2);
                return new InitializeStateError(ErrorState.MalformedWebviewRequest, e2, this._configuration);
            }
        }
    }

    public static class InitializeStateCreate extends InitializeState {
        private Configuration _configuration;
        private String _webViewData;

        public InitializeStateCreate(Configuration configuration, String str) {
            super();
            this._configuration = configuration;
            this._webViewData = str;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public String getWebData() {
            return this._webViewData;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: creating webapp");
            Configuration configuration = this._configuration;
            configuration.setWebViewData(this._webViewData);
            try {
                ErrorState create = WebViewApp.create(configuration, false);
                if (create == null) {
                    return new InitializeStateComplete(this._configuration);
                }
                String webAppFailureMessage = WebViewApp.getCurrentApp().getWebAppFailureMessage() != null ? WebViewApp.getCurrentApp().getWebAppFailureMessage() : "Unity Ads WebApp creation failed";
                DeviceLog.error(webAppFailureMessage);
                return new InitializeStateError(create, new Exception(webAppFailureMessage), this._configuration);
            } catch (IllegalThreadStateException e) {
                DeviceLog.exception("Illegal Thread", e);
                return new InitializeStateError(ErrorState.CreateWebApp, e, this._configuration);
            }
        }
    }

    public static class InitializeStateCreateWithRemote extends InitializeState {
        private Configuration _configuration;

        public InitializeStateCreateWithRemote(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: creating webapp");
            try {
                ErrorState create = WebViewApp.create(this._configuration, true);
                if (create == null) {
                    return new InitializeStateComplete(this._configuration);
                }
                String webAppFailureMessage = WebViewApp.getCurrentApp().getWebAppFailureMessage() != null ? WebViewApp.getCurrentApp().getWebAppFailureMessage() : "Unity Ads WebApp creation failed";
                DeviceLog.error(webAppFailureMessage);
                return new InitializeStateError(create, new Exception(webAppFailureMessage), this._configuration);
            } catch (IllegalThreadStateException e) {
                DeviceLog.exception("Illegal Thread", e);
                return new InitializeStateError(ErrorState.CreateWebApp, e, this._configuration);
            }
        }
    }

    public static class InitializeStateComplete extends InitializeState {
        private Configuration _configuration;

        public InitializeStateComplete(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            for (Class cls : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration = this._configuration.getModuleConfiguration(cls);
                if (moduleConfiguration != null) {
                    moduleConfiguration.initCompleteState(this._configuration);
                }
            }
            return null;
        }
    }

    public static class InitializeStateError extends InitializeState {
        protected Configuration _configuration;
        ErrorState _errorState;
        Exception _exception;

        public InitializeStateError(ErrorState errorState, Exception exc, Configuration configuration) {
            super();
            this._errorState = errorState;
            this._exception = exc;
            this._configuration = configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.error("Unity Ads init: halting init in " + this._errorState.getMetricName() + ": " + this._exception.getMessage());
            for (Class cls : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration = this._configuration.getModuleConfiguration(cls);
                if (moduleConfiguration != null) {
                    moduleConfiguration.initErrorState(this._configuration, this._errorState, this._exception.getMessage());
                }
            }
            return null;
        }
    }

    public static class InitializeStateNetworkError extends InitializeStateError implements IConnectivityListener {
        private static long _lastConnectedEventTimeMs;
        private static int _receivedConnectedEvents;
        private ConditionVariable _conditionVariable;
        private int _connectedEventThreshold;
        private InitializeState _erroredState;
        private int _maximumConnectedEvents;
        private long _networkErrorTimeout;
        private ErrorState _state;

        public InitializeStateNetworkError(ErrorState errorState, Exception exc, InitializeState initializeState, Configuration configuration) {
            super(errorState, exc, configuration);
            this._state = errorState;
            _receivedConnectedEvents = 0;
            _lastConnectedEventTimeMs = 0L;
            this._erroredState = initializeState;
            this._networkErrorTimeout = configuration.getNetworkErrorTimeout();
            this._maximumConnectedEvents = configuration.getMaximumConnectedEvents();
            this._connectedEventThreshold = configuration.getConnectedEventThreshold();
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeStateError, com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.error("Unity Ads init: network error, waiting for connection events");
            this._conditionVariable = new ConditionVariable();
            ConnectivityMonitor.addListener(this);
            if (this._conditionVariable.block(this._networkErrorTimeout)) {
                ConnectivityMonitor.removeListener(this);
                return this._erroredState;
            }
            ConnectivityMonitor.removeListener(this);
            return new InitializeStateError(this._state, new Exception("No connected events within the timeout!"), this._configuration);
        }

        @Override // com.unity3d.services.core.connectivity.IConnectivityListener
        public void onConnected() {
            _receivedConnectedEvents++;
            DeviceLog.debug("Unity Ads init got connected event");
            if (shouldHandleConnectedEvent()) {
                this._conditionVariable.open();
            }
            if (_receivedConnectedEvents > this._maximumConnectedEvents) {
                ConnectivityMonitor.removeListener(this);
            }
            _lastConnectedEventTimeMs = System.currentTimeMillis();
        }

        @Override // com.unity3d.services.core.connectivity.IConnectivityListener
        public void onDisconnected() {
            DeviceLog.debug("Unity Ads init got disconnected event");
        }

        private boolean shouldHandleConnectedEvent() {
            return System.currentTimeMillis() - _lastConnectedEventTimeMs >= ((long) this._connectedEventThreshold) && _receivedConnectedEvents <= this._maximumConnectedEvents;
        }
    }

    public static class InitializeStateRetry extends InitializeState {
        long _delay;
        InitializeState _state;

        public InitializeStateRetry(InitializeState initializeState, long j) {
            super();
            this._state = initializeState;
            this._delay = j;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: retrying in " + this._delay + " milliseconds");
            try {
                Thread.sleep(this._delay);
            } catch (Exception e) {
                DeviceLog.exception("Init retry interrupted", e);
                Thread.currentThread().interrupt();
            }
            return this._state;
        }
    }

    public static class InitializeStateLoadCacheConfigAndWebView extends InitializeState {
        private Configuration _configuration;
        private Configuration _localConfig;

        public InitializeStateLoadCacheConfigAndWebView(Configuration configuration, Configuration configuration2) {
            super();
            this._configuration = configuration;
            this._localConfig = configuration2;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            try {
                return new InitializeStateCheckForUpdatedWebView(this._configuration, InitializeThread.loadCachedFileToByteArray(new File(SdkProperties.getLocalWebViewFile())), this._localConfig);
            } catch (Exception unused) {
                return new InitializeStateCleanCache(this._configuration, new InitializeStateLoadWeb(this._configuration));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] loadCachedFileToByteArray(File file) throws IOException {
        if (file != null && file.exists()) {
            try {
                return Utilities.readFileBytes(file);
            } catch (IOException unused) {
                throw new IOException("could not read from file");
            }
        }
        throw new IOException("file not found");
    }

    public static class InitializeStateCleanCache extends InitializeState {
        private Configuration _configuration;
        private InitializeState _nextState;

        public InitializeStateCleanCache(Configuration configuration, InitializeState initializeState) {
            super();
            this._configuration = configuration;
            this._nextState = initializeState;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            try {
                File file = new File(SdkProperties.getLocalConfigurationFilepath());
                File file2 = new File(SdkProperties.getLocalWebViewFile());
                file.delete();
                file2.delete();
            } catch (Exception e) {
                DeviceLog.error("Failure trying to clean cache: " + e.getMessage());
            }
            return this._nextState;
        }
    }

    public static class InitializeStateCleanCacheIgnoreError extends InitializeStateCleanCache {
        public InitializeStateCleanCacheIgnoreError(Configuration configuration, InitializeState initializeState) {
            super(configuration, initializeState);
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeStateCleanCache, com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            try {
                InitializeState execute = super.execute();
                if (execute instanceof InitializeStateError) {
                    return null;
                }
                return execute;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class InitializeStateCheckForUpdatedWebView extends InitializeState {
        private Configuration _configuration;
        private Configuration _localWebViewConfiguration;
        private byte[] _localWebViewData;

        public InitializeStateCheckForUpdatedWebView(Configuration configuration, byte[] bArr, Configuration configuration2) {
            super();
            this._configuration = configuration;
            this._localWebViewData = bArr;
            this._localWebViewConfiguration = configuration2;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            try {
                String Sha256 = Utilities.Sha256(this._localWebViewData);
                if (!Sha256.equals(this._configuration.getWebViewHash())) {
                    SdkProperties.setLatestConfiguration(this._configuration);
                }
                if (!TextUtils.isEmpty(Sha256)) {
                    Configuration configuration = this._localWebViewConfiguration;
                    if (configuration != null && configuration.getWebViewHash() != null && this._localWebViewConfiguration.getWebViewHash().equals(Sha256) && SdkProperties.getVersionName().equals(this._localWebViewConfiguration.getSdkVersion())) {
                        return new InitializeStateCreate(this._localWebViewConfiguration, new String(this._localWebViewData, "UTF-8"));
                    }
                    Configuration configuration2 = this._configuration;
                    if (configuration2 != null && configuration2.getWebViewHash().equals(Sha256)) {
                        return new InitializeStateCreate(this._configuration, new String(this._localWebViewData, "UTF-8"));
                    }
                }
            } catch (Exception unused) {
            }
            return new InitializeStateCleanCache(this._configuration, new InitializeStateLoadWeb(this._configuration));
        }
    }

    public static class InitializeStateDownloadWebView extends InitializeState {
        private Configuration _configuration;
        private HttpClient _httpClient;
        private int _retries;
        private long _retryDelay;

        public InitializeStateDownloadWebView(Configuration configuration) {
            super();
            this._httpClient = (HttpClient) Utilities.getService(HttpClient.class);
            this._configuration = configuration;
            this._retries = 0;
            this._retryDelay = configuration.getRetryDelay();
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.info("Unity Ads init: downloading webapp from " + this._configuration.getWebViewUrl());
            try {
                try {
                    String obj = this._httpClient.executeBlocking(new HttpRequest(this._configuration.getWebViewUrl())).getBody().toString();
                    String webViewHash = this._configuration.getWebViewHash();
                    if (obj == null || webViewHash == null || !Utilities.Sha256(obj).equals(webViewHash)) {
                        return null;
                    }
                    return new InitializeStateUpdateCache(this._configuration, obj);
                } catch (Exception unused) {
                    if (this._retries >= this._configuration.getMaxRetries()) {
                        return null;
                    }
                    long retryScalingFactor = (long) (this._retryDelay * this._configuration.getRetryScalingFactor());
                    this._retryDelay = retryScalingFactor;
                    this._retries++;
                    return new InitializeStateRetry(this, retryScalingFactor);
                }
            } catch (Exception e) {
                DeviceLog.exception("Malformed URL", e);
                return null;
            }
        }
    }

    public static class InitializeStateUpdateCache extends InitializeState {
        private Configuration _configuration;
        private String _webViewData;

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public InitializeStateUpdateCache(Configuration configuration, String str) {
            super();
            this._configuration = configuration;
            this._webViewData = str;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            if (this._configuration != null && this._webViewData != null) {
                try {
                    Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), this._webViewData);
                    Utilities.writeFile(new File(SdkProperties.getLocalConfigurationFilepath()), this._configuration.getFilteredJsonString());
                } catch (Exception unused) {
                    return new InitializeStateCleanCacheIgnoreError(this._configuration, null);
                }
            }
            return null;
        }
    }

    public static class InitializeStateCheckForCachedWebViewUpdate extends InitializeState {
        private Configuration _configuration;

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public InitializeStateCheckForCachedWebViewUpdate(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        @Override // com.unity3d.services.core.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            try {
                byte[] loadCachedFileToByteArray = InitializeThread.loadCachedFileToByteArray(new File(SdkProperties.getLocalWebViewFile()));
                if (Utilities.Sha256(loadCachedFileToByteArray).equals(this._configuration.getWebViewHash())) {
                    return new InitializeStateUpdateCache(this._configuration, new String(loadCachedFileToByteArray, "UTF-8"));
                }
            } catch (Exception unused) {
            }
            return new InitializeStateDownloadWebView(this._configuration);
        }
    }
}

// ===== FILE: com/unity3d/services/core/configuration/PrivacyCallError.java =====
package com.unity3d.services.core.configuration;

import kotlin.Metadata;

/* compiled from: PrivacyCallError.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m444d2 = {"Lcom/unity3d/services/core/configuration/PrivacyCallError;", "", "(Ljava/lang/String;I)V", "NETWORK_ISSUE", "LOCKED_423", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public enum PrivacyCallError {
    NETWORK_ISSUE,
    LOCKED_423
}

// ===== FILE: com/unity3d/services/core/configuration/PrivacyConfig.java =====
package com.unity3d.services.core.configuration;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class PrivacyConfig {
    private PrivacyConfigStatus _privacyConfigStatus;
    private boolean _shouldSendNonBehavioral;

    public PrivacyConfig() {
        this(PrivacyConfigStatus.UNKNOWN);
    }

    public PrivacyConfig(JSONObject jSONObject) {
        parsePrivacyResponse(jSONObject);
    }

    public PrivacyConfig(PrivacyConfigStatus privacyConfigStatus) {
        this._privacyConfigStatus = privacyConfigStatus;
        this._shouldSendNonBehavioral = false;
    }

    public boolean allowedToSendPii() {
        return this._privacyConfigStatus.equals(PrivacyConfigStatus.ALLOWED);
    }

    public boolean shouldSendNonBehavioral() {
        return this._shouldSendNonBehavioral;
    }

    public PrivacyConfigStatus getPrivacyStatus() {
        return this._privacyConfigStatus;
    }

    private void parsePrivacyResponse(JSONObject jSONObject) {
        this._privacyConfigStatus = jSONObject.optBoolean("pas", false) ? PrivacyConfigStatus.ALLOWED : PrivacyConfigStatus.DENIED;
        this._shouldSendNonBehavioral = jSONObject.optBoolean("snb", false);
    }
}

// ===== FILE: com/unity3d/services/core/configuration/PrivacyConfigStatus.java =====
package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public enum PrivacyConfigStatus {
    UNKNOWN,
    ALLOWED,
    DENIED;

    public String toLowerCase() {
        return name().toLowerCase();
    }
}

// ===== FILE: com/unity3d/services/core/configuration/PrivacyConfigStorage.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.misc.IObserver;
import com.unity3d.services.core.misc.Observable;

/* loaded from: classes.dex */
public class PrivacyConfigStorage extends Observable<PrivacyConfig> {
    private static PrivacyConfigStorage _instance;
    private PrivacyConfig _privacyConfig = new PrivacyConfig();

    private PrivacyConfigStorage() {
    }

    public static PrivacyConfigStorage getInstance() {
        if (_instance == null) {
            _instance = new PrivacyConfigStorage();
        }
        return _instance;
    }

    public synchronized PrivacyConfig getPrivacyConfig() {
        return this._privacyConfig;
    }

    @Override // com.unity3d.services.core.misc.Observable
    public synchronized void registerObserver(IObserver<PrivacyConfig> iObserver) {
        super.registerObserver(iObserver);
        if (this._privacyConfig.getPrivacyStatus() != PrivacyConfigStatus.UNKNOWN) {
            iObserver.updated(this._privacyConfig);
        }
    }

    public synchronized void setPrivacyConfig(PrivacyConfig privacyConfig) {
        this._privacyConfig = privacyConfig;
        notifyObservers(privacyConfig);
    }
}

// ===== FILE: com/unity3d/services/core/configuration/PrivacyConfigurationLoader.java =====
package com.unity3d.services.core.configuration;

import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.mapper.WebRequestToHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PrivacyConfigurationLoader implements IConfigurationLoader {
    private final IConfigurationLoader _configurationLoader;
    private final ConfigurationRequestFactory _configurationRequestFactory;
    private final HttpClient _httpClient;
    private final PrivacyConfigStorage _privacyConfigStorage;

    public PrivacyConfigurationLoader(IConfigurationLoader iConfigurationLoader, ConfigurationRequestFactory configurationRequestFactory, PrivacyConfigStorage privacyConfigStorage, HttpClient httpClient) {
        this._configurationLoader = iConfigurationLoader;
        this._configurationRequestFactory = configurationRequestFactory;
        this._privacyConfigStorage = privacyConfigStorage;
        this._httpClient = httpClient;
    }

    @Override // com.unity3d.services.core.configuration.IConfigurationLoader
    public void loadConfiguration(IConfigurationLoaderListener iConfigurationLoaderListener) throws Exception {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (this._privacyConfigStorage.getPrivacyConfig().getPrivacyStatus() == PrivacyConfigStatus.UNKNOWN) {
            load(new IPrivacyConfigurationListener() { // from class: com.unity3d.services.core.configuration.PrivacyConfigurationLoader.1
                @Override // com.unity3d.services.core.configuration.IPrivacyConfigurationListener
                public void onSuccess(PrivacyConfig privacyConfig) {
                    PrivacyConfigurationLoader.this._privacyConfigStorage.setPrivacyConfig(privacyConfig);
                }

                @Override // com.unity3d.services.core.configuration.IPrivacyConfigurationListener
                public void onError(PrivacyCallError privacyCallError, String str) {
                    DeviceLog.warning("Couldn't fetch privacy configuration: " + str);
                    PrivacyConfigurationLoader.this._privacyConfigStorage.setPrivacyConfig(new PrivacyConfig());
                    if (privacyCallError == PrivacyCallError.LOCKED_423) {
                        atomicBoolean.set(true);
                    }
                }
            });
        }
        if (atomicBoolean.get()) {
            throw new AbortRetryException("Game is disabled");
        }
        this._configurationLoader.loadConfiguration(iConfigurationLoaderListener);
    }

    @Override // com.unity3d.services.core.configuration.IConfigurationLoader
    public Configuration getLocalConfiguration() {
        return this._configurationLoader.getLocalConfiguration();
    }

    private void load(IPrivacyConfigurationListener iPrivacyConfigurationListener) throws Exception {
        try {
            HttpRequest httpRequest = WebRequestToHttpRequestKt.toHttpRequest(this._configurationRequestFactory.getWebRequest());
            InitializeEventsMetricSender.getInstance().didPrivacyConfigRequestStart();
            HttpResponse executeBlocking = this._httpClient.executeBlocking(httpRequest);
            try {
                if (executeBlocking.getStatusCode() / 100 == 2) {
                    InitializeEventsMetricSender.getInstance().didPrivacyConfigRequestEnd(true);
                    iPrivacyConfigurationListener.onSuccess(new PrivacyConfig(new JSONObject(executeBlocking.getBody().toString())));
                } else if (executeBlocking.getStatusCode() == 423) {
                    InitializeEventsMetricSender.getInstance().didPrivacyConfigRequestEnd(false);
                    iPrivacyConfigurationListener.onError(PrivacyCallError.LOCKED_423, "Game ID is disabled " + ClientProperties.getGameId());
                } else {
                    InitializeEventsMetricSender.getInstance().didPrivacyConfigRequestEnd(false);
                    iPrivacyConfigurationListener.onError(PrivacyCallError.NETWORK_ISSUE, "Privacy request failed with code: " + executeBlocking.getStatusCode());
                }
            } catch (Exception unused) {
                InitializeEventsMetricSender.getInstance().didPrivacyConfigRequestEnd(false);
                iPrivacyConfigurationListener.onError(PrivacyCallError.NETWORK_ISSUE, "Could not create web request");
            }
        } catch (Exception e) {
            iPrivacyConfigurationListener.onError(PrivacyCallError.NETWORK_ISSUE, "Could not create web request: " + e);
        }
    }
}
