package org.web3j.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author xj.x
 * Sample service to demonstrate web3j bean being correctly injected.
 */
@Service
public class Web3jSampleService {

    @Autowired
    private Web3j web3j;

    @Autowired
    private Admin admin;

    public String getClientVersion() throws IOException {
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        return web3ClientVersion.getWeb3ClientVersion();
    }

    public String getClientVersionByAdmin() throws ExecutionException, InterruptedException {
        Web3ClientVersion web3ClientVersion = admin.web3ClientVersion().sendAsync().get();
        return web3ClientVersion.getWeb3ClientVersion();
    }
}
