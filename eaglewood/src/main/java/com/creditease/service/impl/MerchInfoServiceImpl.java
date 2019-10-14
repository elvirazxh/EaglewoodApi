package com.creditease.service.impl;

import com.creditease.mybatis.dao.MerchInfoMapper;
import com.creditease.mybatis.pojo.MerchInfo;
import com.creditease.mybatis.pojo.MerchInfoExample;
import com.creditease.service.MerchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchInfoServiceImpl implements MerchInfoService {

    @Autowired
    private MerchInfoMapper merchInfoMapper;
    public String getPrivateKey(String strEnv,String strMerchId)
    {
        if(strEnv.isEmpty() )
            return "";
        if(strMerchId.isEmpty())
            return "";
        MerchInfoExample example = new MerchInfoExample();
        example.createCriteria().andMerchidEqualTo(strMerchId).andSystemEnvEqualTo(strEnv);

        List<MerchInfo> listMerchInfo =  merchInfoMapper.selectByExample(example);
        if(listMerchInfo.size() == 0 || listMerchInfo.size()>1)
           return "";
        else
            return listMerchInfo.get(0).getPrivateKey();
    }

    public List<String> getMerchIdList(String systemFlag, String systemEnv) {
        MerchInfoExample example = new MerchInfoExample();

        example.createCriteria().andSystemFlagEqualTo(systemFlag).andSystemEnvEqualTo(systemEnv);

        List<MerchInfo> list = merchInfoMapper.selectByExample(example);
        List<String> listMerchId = new ArrayList<>();
        for(int i = 0;i<list.size();i++) {
            listMerchId.set(i,list.get(i).getMerchid()) ;
        }
        return listMerchId;
    }
}
