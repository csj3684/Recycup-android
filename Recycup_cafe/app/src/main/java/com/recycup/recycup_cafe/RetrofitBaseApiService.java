package com.recycup.recycup_cafe;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public interface RetrofitBaseApiService {
    final String Base_Url = "http://59.187.219.187:22406";

    //카페 지점 등록
    //input : cafeId(string), cafePassword(string), headName(String), cafeName (String) , latitude, longitude (double)
    //return : success(bool), headName(String), cafeName(String), material(String)
    @FormUrlEncoded
    @POST("cafe/cafeInfo/register")
    Call<JsonObject> registerCafe(@Field("cafeId") String cafeId,@Field("headName") String cafePassword,@Field("cafePassword") String headName, @Field("cafeName") String cafeName, @Field("latitude") double latitude, @Field("longitude") double longitude);

    //카페 아이디 중복검사
    //input : cafeId(String)
    //return : duplicate(bool) - true이면 중복이고, false이면 중복이 아니라는 얘기
    @FormUrlEncoded
    @POST("cafe/cafeInfo/duplicateCheck")
    Call<JsonObject> duplicateCheck(@Field("cafeId") String cafeId);


    //카페 로그인
    //input : cafeId, cafePassword (string)
    //return : headName(String), cafeName(String), material(String)
    @FormUrlEncoded
    @POST("cafe/cafeInfo/signIn")
    Call<JsonObject> cafeSignIn(@Field("cafeId") String cafeId, @Field("cafePassword") String cafePassword);


    //사용자로그인
    //input : phoneNumber, password (string)
    //return : success(bool) ,phoneNumber, name, password (string), point(int)
    @FormUrlEncoded
    @POST("/customer/signIn")
    Call<JsonObject> signIn(@Field("phoneNumber") String phoneNumber, @Field("password") String password);




}
