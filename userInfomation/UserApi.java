
package com.arg.gsbea.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import java.io.InputStream;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.springframework.web.bind.annotation.CrossOrigin;


@Path(value = "/")
@Api(value = "", authorizations = @Authorization(value = "apiKey"), tags = {"user"})
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface UserApi {
    
    @CrossOrigin
    @POST
    @Path("/updatePassword")
    @ApiOperation(value = "updatePassword", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok"),
    @ApiResponse(code = 405, message = "Invalid input"),
    @ApiResponse(code = 500, message = "Internal Error")})
    public Response updatePassword(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
           @CrossOrigin
    @POST
    @Path("/sendNotification")
    @ApiOperation(value = "sendNotification", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok"),
    @ApiResponse(code = 405, message = "Invalid input"),
    @ApiResponse(code = 500, message = "Internal Error")})
    public Response sendNotification(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
        
    @CrossOrigin
    @POST
    @Path("/select")
    @ApiOperation(value = "selectEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response selectEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
        
    @POST
    @Path("/authenEvent")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response authenEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
    @POST
    @Path("/insertEvent")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response insertEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
            
    @POST
    @Path("/setConfirmRegister")
    @ApiOperation(value = "setConfirmRegister", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response setConfirmRegister(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
             
    @POST
    @Path("/sendEmailRegister")
    @ApiOperation(value = "sendEmailRegister", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response sendEmailRegister(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data,@ApiParam(value = "Model of credential to be Insert", required = true)String url);
    
    
    
    @POST
    @Path("/updateEvent")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response updateEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
    @POST
    @Path("/deleteEvent")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response deleteEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
    @POST
    @Path("/uploadEvent")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
    @Produces({ MediaType.APPLICATION_JSON })
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response uploadEvent(
            @Multipart(required = false, value = "chipherText") String chipherText,//encrypt
            @Multipart(required = false, value = "refKey") String refKey,//encrypt
            @Multipart(required = false, value = "json") String json,//NON-encrypt
            @Multipart(required = false, value = "files") List<InputStream> picList
    );
    
    
    
    
    @POST
    @Produces({ MediaType.TEXT_PLAIN })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response getLinkForWeb(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String getWhat);
    
    @POST
    @Path("/selectWeb")
    @ApiOperation(value = "selectWebEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response selectWebEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
       
    
    @POST
    @Path("/insertWebEvent")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response insertWebEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
            
    @POST
    @Path("/setConfirmWebRegister")
    @ApiOperation(value = "setConfirmWebRegister", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response setConfirmWebRegister(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
             
    @POST
    @Path("/sendEmailWebRegister")
    @ApiOperation(value = "sendEmailWebRegister", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response sendEmailWebRegister(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data,@ApiParam(value = "Model of credential to be Insert", required = true)String url);
    
    
    
    @POST
    @Path("/updateWebEvent")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response updateWebEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
    @POST
    @Path("/deleteWebEvent")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response deleteWebEvent(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
    @POST
    @Path("/uploadWebEvent")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
    @Produces({ MediaType.APPLICATION_JSON })
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response uploadWebEvent(
            @Multipart("json") String json,
            @Multipart(required = false, value = "files") List<InputStream> picList
    );
    
    @POST
    @Path("/uploadImgAdsIns")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response uploadImgAdsIns(
            @Multipart(required = false, value = "files") InputStream picList
    );

    
    @POST
    @Path("/saveAllImgAds")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response saveAllImgAds(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
    @POST
    @Path("/getAllImgAds")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response getAllImgAds(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
    @POST
    @Path("/updateAllImgAds")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response updateAllImgAds(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
   
            
    @POST
    @Path("/user_InfomationData")
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response userInfomationData(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
            
    @POST
    @Path("/testJson")
    @ApiOperation(value = "testJson", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response testJson(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
    @POST
    @Path("/WTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENTWTFEVENT")
    @Produces({ MediaType.APPLICATION_OCTET_STREAM })
    @ApiOperation(value = "authenEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 405, message = "Invalid input"),
        @ApiResponse(code = 500, message = "Internal Error")})
    public Response exportMonthly(@Valid @ApiParam(value = "Model of credential to be Insert", required = true) String data);
    
    
   
    @POST
    @Path("/ldapChangePassword")
    @ApiOperation(value = "ldapAuthen", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok"),
    @ApiResponse(code = 405, message = "Invalid input"),
    @ApiResponse(code = 500, message = "Internal Error")})
    public Response ldapChangePassword(@Valid @ApiParam(value = "Model of credential to be ldapAuthen", required = true) String data);
    
    
    
     
    @POST
    @Path("/ldapLogin")
    @ApiOperation(value = "loginLdap", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok"),
    @ApiResponse(code = 405, message = "Invalid input"),
    @ApiResponse(code = 500, message = "Internal Error")})
    public Response ldapLogin(@Valid @ApiParam(value = "Model of credential to be loginLdap", required = true) String data);

    
    @POST
    @Path("/ldapGetAllUser")
    @ApiOperation(value = "ldapAuthen", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok"),
    @ApiResponse(code = 405, message = "Invalid input"),
    @ApiResponse(code = 500, message = "Internal Error")})
    public Response ldapGetAllUser(@Valid @ApiParam(value = "Model of credential to be ldapGetAllUser", required = true) String data);

    @POST
    @Path("/getAdsPanel")
    @ApiOperation(value = "getAdsPanel", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok"),
    @ApiResponse(code = 405, message = "Invalid input"),
    @ApiResponse(code = 500, message = "Internal Error")})
    public Response getAdsPanel();
    
    @POST
    @Path("/saveAdsPanel")
    @ApiOperation(value = "saveAdsPanel", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok"),
    @ApiResponse(code = 405, message = "Invalid input"),
    @ApiResponse(code = 500, message = "Internal Error")})
    public Response saveAdsPanel(@Valid @ApiParam(value = "Model to save ads panel", required = true) String data);
    
    @POST
    @Path("/updateRegisterFlagEvent")
    @ApiOperation(value = "updateRegisterFlagEvent", authorizations = @Authorization(value = "apiKey"), tags = {"credential"})
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok"),
    @ApiResponse(code = 405, message = "Invalid input"),
    @ApiResponse(code = 500, message = "Internal Error")})
    public Response updateRegisterFlagEvent(@Valid @ApiParam(value = "Model to save ads panel", required = true) String data);
    
}

