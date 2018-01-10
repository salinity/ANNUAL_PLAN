package com.lion.common.config.impl;

import com.lion.common.config.IDBConnector;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/19.
 */
@Component
@Profile("devDb")
public class DevDBConnector implements IDBConnector {

    @Override
    public String configure() {
        return "devDb";
    }
}
