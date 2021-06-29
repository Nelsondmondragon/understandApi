package com.aprender.gatos;

import com.google.gson.Gson;
import com.squareup.okhttp.*;

import java.io.IOException;

public class CatService {


    public static Cat readCat() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        json = json.substring(1, json.length() - 1);
        //Covertir objeto.
        Gson gson = new Gson();
        return gson.fromJson(json, Cat.class);
    }

    public static void favorite(Cat cat) {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\":\"" + cat.getId() + "\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cat.getApiKey())
                    .build();
            client.newCall(request).execute();
        } catch (IOException e) {

        }
    }

    public static Cat[] listFavorite() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("GET", null)
                    .addHeader("x-api-key", "23e162ba-231c-4dfe-82b8-6c841efcfc81")
                    .build();
            Response response = client.newCall(request).execute();
            return new Gson().fromJson(response.body().string(),Cat[].class);
        } catch (IOException e) {
            System.out.println("Lis");
        }
        return null;
    }

    public static void deleteCatFavorite(Cat cat){
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites/" +cat.getId())
                    .method("DELETE", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cat.getApiKey())
                    .build();
          client.newCall(request).execute();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
