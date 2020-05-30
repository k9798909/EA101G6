package xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetGooglePlaceTest {
	private static final String MY_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?"
			+ "location=24.95375,121.22575&"
			+ "radius=500&"
			+ "types=food&"
			+ "name=鐵板燒&"
			+ "language=zh-TW&"
			+ "key=AIzaSyCBdjNRkmaIPNQAXO9GOEdtx8oMeJDCBH8";
	
	public static void main(String[] args) throws IOException {
		URL url = new URL(MY_URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		StringBuilder sb = new StringBuilder();
		con.setRequestMethod("GET");
		con.setUseCaches(false);
		
		InputStream is = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		
		br.close();
		isr.close();
		is.close();
		
		//System.out.println(sb.toString());
		
		/**if除了是否營業中其他的可以不用打，功用是判斷找不找的到key找的到才執行
		 * 因為營業中有一項是空的所以一定要做判斷，其他的都有避免有空的我才加
		 * results取出的值是陣列所以用JSONArray再用迴圈先取getJSONObject在取key的值*
		 * 如果包很多層就重複像經緯度*/
		//再包阿!!!
		
		try {
			JSONArray jsonarr =new JSONObject(sb.toString()).getJSONArray("results");
			for(int i=0 ; i<jsonarr.length() ; i++) {
				JSONObject json =jsonarr.getJSONObject(i);
				if(json.has("name"))
					System.out.print("店名:"+json.getString("name")+"  ");
				if(json.has("geometry")&&json.getJSONObject("geometry").has("location"))
					System.out.print("緯度:"+json.getJSONObject("geometry").getJSONObject("location").getDouble("lat")+"  ");
				if(json.has("geometry")&&json.getJSONObject("geometry").has("location"))
					System.out.print("經度:"+json.getJSONObject("geometry").getJSONObject("location").getDouble("lng")+"  ");
				if(json.has("rating"))
					System.out.print("評價:"+json.getDouble("rating")+"  ");
			    if(json.has("opening_hours"))
			    	System.out.print("是否營業中:"+(json.getJSONObject("opening_hours").getBoolean("open_now")?"有營業":"沒營業")+"   ");
			    if(json.has("vicinity"))
			    	System.out.print("地址:"+json.getString("vicinity")+"\n");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
