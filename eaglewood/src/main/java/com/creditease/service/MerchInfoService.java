package com.creditease.service;

import java.util.List;

public interface MerchInfoService {
    String getPrivateKey(String strEnv, String strMerchId);
    public List<String> getMerchIdList(String systemFlag, String systemEnv);
}
