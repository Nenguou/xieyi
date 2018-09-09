package com.binguner.xieyi.RxUtils

import com.binguner.xieyi.beans.*
import io.reactivex.Observable
import retrofit2.http.*
import java.util.*

interface ApiServices{

    companion object {
        val BASE_URL = "39.106.122.7:3000/api/v1/"
    }

    // Register
    @POST("doregister")
    @FormUrlEncoded
    fun doRegister(@Field("phone") phone:String,@Field("username") username: String, @Field("password") password: String) :Observable<DoRegisterBean>

    // Login
    @POST("dologin")
    @FormUrlEncoded
    fun doLogin(@Field("username") username: String, @Field("password")password :String) :Observable<DoLoginBean>

    // Get user information
    @GET("userinfo")
    fun getUserInfo(@Query("id") userId: String)

    // Create Protocol
    @POST("doProtocol")
    @FormUrlEncoded
    fun createProtocol(@Field("title") title:String, @Field("content")content:String, @Field("ignatoryNum")ignatoryNum:String, @Field("username")username:String):Observable<DoProtocolBean>

    // Create doFloater
    @POST("doFloater")
    @FormUrlEncoded
    fun createFloater(@Field("username") username: String, @Field("title") title: String, @Field("content") content: String, @Field("region") region: String):Observable<MakeFloaterBean>

    // send feedback
    @POST("feedback")
    @FormUrlEncoded
    fun giveFeedback(@Field("content") content: String, @Field("qq") qq: String, @Field("phone") phone: String, @Field("weixin") weixin: String):Observable<FeedBackBean>

    // sign Protocol
    @POST("signProtocol")
    @FormUrlEncoded
    fun sighTheProtocol(@Field("username") username: String, @Field("id") protocolId: String)

    // get a Protocol information
    @GET("viewProtocol")
    fun getOneProtocolInfo(@Query("id") protocolId: String)

    // give a favorite
    @POST("protocol-parise")
    @FormUrlEncoded
    fun giveAHeart(@Field("protocol_id") protocol_id: String, @Field("user_id") user_id:String)

    // get the floater information
    @GET("getFloater")
    fun getFloaterInformation(@Query("id") protocolId: String)

    // modifyUserInfo
    @POST("modifyinfo")
    @FormUrlEncoded
    fun modifyUserInfo(@Query("id")user_id: String, @Query("nickname")nickname:String?, @Query("avatar") avatar_url:String?, @Query("sex")sex:String?,
                       @Query("career")career:String?, @Query("region")region:String?, @Query("phone")phoneNumber:String?, @Query("email")email:String?,
                       @Query("password")newPassword:String?):Observable<ModifyinfoBean>

}