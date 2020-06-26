
package com.arg.gsbea.api.impl;

import com.arg.gsbea.api.UserApi;
import com.arg.gsbea.common.AesEcbEncryptDecrypt;
import com.arg.gsbea.common.dao.CommonDao;
import com.arg.gsbea.common.dao.SendEmailSMTP;
import com.arg.gsbea.common.model.aut.AcmoBizModel;
import com.arg.gsbea.common.model.aut.AcmoBizModelChipher;
import com.arg.gsbea.core.aut.AutUserDao;
import com.arg.gsbea.core.home.DeleteDao;
import com.arg.gsbea.core.home.InsertDao;
import com.arg.gsbea.core.home.LdapAuthenDao;
import com.arg.gsbea.core.home.SelectDao;
import com.arg.gsbea.core.home.UpdateDao;
import com.arg.gsbea.core.home.UploadAdsDao;
import com.arg.gsbea.core.home.UploadDao;
import com.arg.gsbea.core.home.UserInformationDao;
import com.arg.gsbea.core.web.NotificationDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.InputStream;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UserApiServiceImpl extends AuthenticationApi
        implements UserApi {

    private static final Logger LOG = LogManager.getLogger(UserApi.class);
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ORIGIN_TYPE_ACCEPT_AUTHORIZATION = "origin, content-type, accept, authorization";
    private static final String GET_POST = "GET, POST";
    private static final String NOT_SUPPORTED_YET = "Not supported yet.";
    private static final String CROSS_ORIGIN_TEXT = "CrossURL::";
    private final CommonDao cDao = new CommonDao();
    private String encryptFlag = cDao.getEncryptFlag();
    String crossURL = cDao.getCrossURL();
    private final AutUserDao autDao = new AutUserDao();
    private final UploadAdsDao uAdsDao = new UploadAdsDao();
//    @Context
//    HttpHeaders headers;

//    @Override
//    public Response findUserByName(String name) {
//        try {
//            if (isAuth()) {
//                List<User> users = UserCore.getUsers(name);
//                return Response.status(Response.Status.OK).entity(users).build();
//            } else {
//                return Response.status(Response.Status.UNAUTHORIZED).build();
//            }
//        } catch (Exception e) {
//            LOG.error("Error ::: ", e);
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @Override
//    public Response addUser(User body) {
//        if (isAuth()) {
//            try {
//                UserCore.addUser(body);
//                return Response.status(Response.Status.OK).build();
//            } catch (Exception e) {
//                LOG.error("Error ::: ", e);
//                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//            }
//        } else {
//            return Response.status(Response.Status.UNAUTHORIZED).build();
//        }
//    }
//    @Override
//    public Response authentication(Credential body) {
//        try {
//
//            LOG.info("Chiper TEXT.................:");
//            LOG.info(body.getCipher());
//            LOG.info("username.................:" );
//            LOG.info(body.getUUID());
//
//            TripleDES dESTest = new TripleDES("ARSOFT_GSB");
//
//            String value = dESTest.decrypt(body.getCipher());
//
//            LOG.info("Decript value : ");
//            LOG.info(value);
//            if (value.equals("Hello GSB")) {
//                AuthenticationApi authen = new AuthenticationApi();
//                String singnager = authen.createJWT("54108", "990821", "createบ่าง");
//                return Response.status(Response.Status.OK).entity(singnager).build();
//            } else {
//                AuthenticationApi authen = new AuthenticationApi();
//                String singnager = authen.createJWT("54108", "990821", "createบ่าง");
//                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(singnager).build();
//            }
//        } catch (Exception e) {
//            LOG.error("Error ::: ");
//            LOG.error(e);
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//    @Override
//    public Response register(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(AutUserDao.getInstance().register(data)).build();
//    }
//    
//    @Override
//    public Response login(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(AutUserDao.getInstance().login(data)).build();
//    }
//
//    
//    @Override
//    public Response forgotPassword(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(AutUserDao.getInstance().forgotPassword(data)).build();
//    }
//    @Override
//    public Response businessInformation(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(InsertDao.getInstance().businessInformation(data)).build();
//    }
//    @Override
//    public Response transactionType(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(HomeModuleDao.getInstance().transactionType(data)).build();
//    }
//    @Override
//    public Response categoryList(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(HomeModuleDao.getInstance().categoryList(data)).build();
//    }
//    @Override
//    public Response paymentCashType(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(HomeModuleDao.getInstance().paymentCashType(data)).build();
//    }
//    @Override
//    public Response paymentType(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(HomeModuleDao.getInstance().paymentType(data)).build();
//    }
//    @Override
//    public Response groupList(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(HomeModuleDao.getInstance().groupList(data)).build();
//    }
//    @Override
//    public Response accountType(String data) {
//        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
//                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
//                .header(ACCESS_CONTROL_ALLOW_HEADERS,
//                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
//                .header(ACCESS_CONTROL_ALLOW_METHODS,
//                        GET_POST).entity(CustomerDao.getInstance().accountType(data)).build();
//    }
    @Override
    public Response selectEvent(String data) {
        
        SelectDao sd = new SelectDao();
        LOG.info("Select:CrossURL::");
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        "POST").entity(sd.selectEvent(data,encryptFlag)).build();
    }

    @Override
    public Response authenEvent(String data) {
        String dataDecrypt = "";
        if(encryptFlag.equals("true")){
        //////////////////////////////////////decrypt////////////////////////////////////////////////////////
        LOG.info("data>>>" );
        LOG.info(data);
        AcmoBizModelChipher obJectChipher = autDao.parseModelChipher(data);

        LOG.info("obJectChipher>>>" );
        LOG.info(obJectChipher);
        LOG.info("obJectChipherText>>>" );
        LOG.info( obJectChipher.getChipherText());

        if (obJectChipher.getChipherText() != null) {
            //input key for decrypt (ต้นให้มา)
            AesEcbEncryptDecrypt.setKey("00bda6712d1882d3428c529aba3823f6");

//                    String strToDecrypt = AesEcbEncryptDecrypt.getEncryptedString();
//                    AesEcbEncryptDecrypt.decrypt(obJectChipher.getChipherText());
            AesEcbEncryptDecrypt decryptObject = new AesEcbEncryptDecrypt();

            
            String logStr =  decryptObject.decrypt(obJectChipher.getChipherText());
            LOG.info("Decrypt : ");
            LOG.info(logStr);
//                    LOG.info("Decrypted : " + AesEcbEncryptDecrypt.getDecryptedString());

            dataDecrypt = decryptObject.decrypt(obJectChipher.getChipherText());
            LOG.info("dataDecrypt : " );
            LOG.info(dataDecrypt);

        }
        }else{
            LOG.info("Login:data::"+data);
            dataDecrypt = data;
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AcmoBizModel object = autDao.parseModel(dataDecrypt);
        String url = autDao.getIPUrl();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        if (object.getTarget().equals("Login") && object.getModule().equals("BIZAuthentication")) {
            try {
                return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                        .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                        .header(ACCESS_CONTROL_ALLOW_HEADERS,
                                ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                        .header(ACCESS_CONTROL_ALLOW_METHODS,
                                GET_POST).entity(autDao.login(object.getData(), data,encryptFlag)).build();
            } catch (JsonProcessingException ex) {
                LOG.info("ERROR>>> : " );
                LOG.info(ex);
            }
        } else if (object.getTarget().equals("ForgotPassword") && object.getModule().equals("BIZAuthentication")) {
            return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                    .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                    .header(ACCESS_CONTROL_ALLOW_HEADERS,
                            ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                    .header(ACCESS_CONTROL_ALLOW_METHODS,
                            GET_POST).entity(autDao.forgotPassword(object.getData())).build();
        }
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(autDao.register(object.getData(), url, data)).build();

    }

    @Override
    public Response insertEvent(String data) {
        InsertDao iDao = new InsertDao();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(iDao.insertEvent(data,encryptFlag)).build();
    }

    @Override
    public Response updateEvent(String data) {
        UpdateDao uDao = new UpdateDao();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(uDao.updateEvent(data,encryptFlag)).build();
    }

    @Override
    public Response deleteEvent(String data) {
        DeleteDao dDao = new DeleteDao();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(dDao.deleteEvent(data,encryptFlag)).build();
    }

   @Override
    public Response uploadEvent(String chipherText, String refKey,String json, List<InputStream> picList) {
        UploadDao uDao = new UploadDao();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        if(encryptFlag.equals("false")){
            if(json == null || json.equals("")){
                //encryptFlag == false, but no json
                return Response.status(500).header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity("invalid json").build();
            }
            
            //encryptFlag == false, has json
            return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(uDao.uploadEvent(json, picList,encryptFlag)).build();
        }
        
        //if encryptFlag do this VVV
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(uDao.uploadEvent(chipherText, refKey, picList,encryptFlag)).build();
    }

    @Override
    public Response updatePassword(String data) {
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(autDao.updatePassword(data)).build();

    }

    @Override
    public Response setConfirmRegister(String data) {
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(autDao.setConfirmRegister(data)).build();
    }

    @Override
    public Response sendEmailRegister(String data, String url) {
        SendEmailSMTP sEmail = new SendEmailSMTP();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(sEmail.sendEmailRegister(data, url)).build();
    }

    @Override
    public Response getLinkForWeb(String getWhat) {
        return Response.ok().entity(autDao.getLinkForWeb(getWhat)).build();
    }

    @Override
    public Response selectWebEvent(String data) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response insertWebEvent(String data) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response setConfirmWebRegister(String data) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response sendEmailWebRegister(String data, String url) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response updateWebEvent(String data) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response deleteWebEvent(String data) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response uploadWebEvent(String json, List<InputStream> picList) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response exportMonthly(String data) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response sendNotification(String data) {
        NotificationDao nDao = new NotificationDao();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(nDao.sentNoti(data)).build();
    }

    @Override
    public Response ldapChangePassword(String data) {

        LdapAuthenDao sd = new LdapAuthenDao();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(sd.changePassword(data)).build();
    }

    @Override
    public Response ldapGetAllUser(String data) {

        LdapAuthenDao sd = new LdapAuthenDao();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(sd.getAll()).build();
    }

    @Override
    public Response ldapLogin(String data) {

        LdapAuthenDao sd = new LdapAuthenDao();
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(sd.login(data)).build();
    }

    @Override
    public Response saveAllImgAds(String data) {
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(uAdsDao.saveAllImgAds(data)).build();
    }

    @Override
    public Response getAllImgAds(String data) {
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(uAdsDao.getAllImgAds(data)).build();
    }

    @Override
    public Response updateAllImgAds(String data) {
        LOG.info(CROSS_ORIGIN_TEXT);
        LOG.info(crossURL);
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(uAdsDao.upDateAllImgAds(data)).build();
    }

    @Override
    public Response testJson(String data) {
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(UploadAdsDao.getInstance().testJson(data)).build();
    }

    @Override
    public Response uploadImgAdsIns(InputStream picList) {
          return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(UploadAdsDao.getInstance().uploadImgAdsIns(picList)).build();
    }

    @Override
    public Response userInfomationData(String data) {
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(UserInformationDao.getInstance().getDataUsersInfomation(data)).build();
    }
    
    @Override
    public Response getAdsPanel() {
                return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, "*")
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(UploadAdsDao.getInstance().getAdsPanel()).build();
    }
    
    @Override
    public Response saveAdsPanel(String data) {
                return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, "*")
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(UploadAdsDao.getInstance().saveAdsPanel(data)).build();
    }
     @Override
    public Response updateRegisterFlagEvent(String data) {
        return Response.ok().header(ACCESS_CONTROL_ALLOW_ORIGIN, crossURL)
                .header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
                .header(ACCESS_CONTROL_ALLOW_HEADERS,
                        ORIGIN_TYPE_ACCEPT_AUTHORIZATION)
                .header(ACCESS_CONTROL_ALLOW_METHODS,
                        GET_POST).entity(autDao.updateRegisterFlag(data)).build();
    }

}

