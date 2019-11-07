package com.skynet.infrastructure;

import com.qiniu.storage.Region;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.terapico.utils.MapUtil;

import java.util.Map;

public class QiniuOssService implements StorageService {

    private QiniuConfiguration mQiniuConfiguration;

    public QiniuConfiguration getQiniuConfiguration() {
        return mQiniuConfiguration;
    }

    public void setQiniuConfiguration(QiniuConfiguration pQiniuConfiguration) {
        mQiniuConfiguration = pQiniuConfiguration;
    }

    @Override
    public Map<String, Object> genToken(Object context) {
        if (context instanceof String) {
            return this.ossHome((String) context);
        }

        return null;


    }

    private Map<String, Object> ossHome(String home) {
        String accessKey = mQiniuConfiguration.accessKey;
        String secretKey = mQiniuConfiguration.secretKey;
        String bucket = mQiniuConfiguration.bucket;
        Auth auth = Auth.create(accessKey, secretKey);

        StringMap policy = new StringMap().put("isPrefixalScope", 1);

        String upToken = auth.uploadToken(bucket, home, 120, policy);


        return  MapUtil.put("token", upToken)
                .put("home", home)
                .put("bucket", bucket)
                .put("uploadPrefix", mQiniuConfiguration.uploadPrefix)
                .put("downloadPrefix", mQiniuConfiguration.downloadPrefix)
                .into_map();
    }


    @Override
    public String upload(String objName, byte[] content) {
        return null;
    }
}
