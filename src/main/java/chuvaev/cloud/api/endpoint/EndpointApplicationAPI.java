package chuvaev.cloud.api.endpoint;

import chuvaev.cloud.dto.ResultDTO;

import javax.jws.WebMethod;

public interface EndpointApplicationAPI extends EndpointAPI{

    @WebMethod
    ResultDTO ping();

    @WebMethod
    ResultDTO shutdown();

    @WebMethod
    ResultDTO connected();

    @WebMethod
    ResultDTO status();

    @WebMethod
    ResultDTO login();

    @WebMethod
    ResultDTO start();

    @WebMethod
    ResultDTO stop();

    @WebMethod
    ResultDTO sync();

    @WebMethod
    ResultDTO logout();
}
