import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class WebAPI {
    public static final String token = "8KF4xgn-s0wAAAAAAAAAAW8eGJzQYF4GENAEX03-VA1Pq5WhSm8wBf-E65Cs7DUr";
    public static final String appKey = "059bufvzroy3a57";
    public static final String appSecret = "jy7yjiautmm8x1k";
    @Test
    public void uploadFile() throws IOException {
        RestAssured.baseURI = "https://content.dropboxapi.com/2/files/upload";
        File file = new File("src/fileTXT/text.txt");
        JSONObject uploadObj = new JSONObject();
        uploadObj.put("path", "/Desktop/text.txt");
        uploadObj.put("autorename", true);
        uploadObj.put("mode", "add");
        uploadObj.put("mute", false);

        RequestSpecification uploadRequest = RestAssured.given();
        uploadRequest.headers("Dropbox-API-Arg",uploadObj.toJSONString(),
                "Content-Type","text/plain; charset=dropbox-cors-hack",
                "Authorization", "Bearer " + token);

        uploadRequest.body(FileUtils.readFileToByteArray(file));
        Response uploadResponse = uploadRequest.post();

        assertEquals(uploadResponse.getStatusCode(), 200);

    }

    @Test
    public void getMetaData(){
        RestAssured.baseURI = "https://api.dropboxapi.com/2/files/get_metadata";
        RequestSpecification getMetaRequest = RestAssured.given();

        getMetaRequest.headers("Content-Type","application/json",
                "Authorization", "Bearer " + token);

        JSONObject getMetadataObj = new JSONObject();
        getMetadataObj.put("path", "/Desktop/text.txt");
        getMetadataObj.put("include_media_info", true);
        getMetaRequest.body(getMetadataObj.toJSONString());

        Response getMetaResponse = getMetaRequest.post();
        assertEquals(getMetaResponse.getStatusCode(), 200);
    }

    @Test
    public void test3_delete(){
        RestAssured.baseURI = "https://api.dropboxapi.com/2/files/delete_v2";
        RequestSpecification deleteRequest = RestAssured.given();

        deleteRequest.headers("Content-Type","application/json",
                "Authorization", "Bearer " + token);

        JSONObject deleteObj = new JSONObject();
        deleteObj.put("path", "/Desktop/text.txt");
        deleteRequest.body(deleteObj.toJSONString());

        Response deleteResponse = deleteRequest.post();
        assertEquals(deleteResponse.getStatusCode(), 200);
    }
}
