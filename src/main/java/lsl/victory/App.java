package lsl.victory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import org.apache.http.impl.NoConnectionReuseStrategy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class App {

	private static String jsonString;
	private static String urlString;
	private static JSONObject jsonObject;
	private static String string = "";

	public static void main(String[] args) throws Exception {

		File fileWriter = new File("Data.txt");
		FileOutputStream fos = new FileOutputStream(fileWriter);

		StringBuilder stringBuilder = new StringBuilder();

		for (int j = 10; j < 410; j += 10) {

			Random random = new Random();
			int nextInt = random.nextInt(11);
			int sleep = nextInt + 10;
			int sleepTime = sleep * 1000;

			stringBuilder
					.append("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			stringBuilder.append(IntToString(j));
			stringBuilder.append("xxxxxxxx");
			urlString = stringBuilder.toString();
			jsonString = GetSource.getCode(urlString);
			jsonObject = JSONObject.parseObject(jsonString);

			for (int i = 0; i < 500; i++) {

				string = jsonObject.getJSONObject("res").getJSONArray("list").getJSONObject(i).getString("content");

				fos.write(string.getBytes());
				fos.write("\r\n".getBytes());
				fos.flush();
			}

			System.out.println("已抓取 " + j * 50 + " 条数据");
			System.out.println("系统休眠: " + sleep + " s");
			Thread.sleep(sleepTime);
		}

		fos.close();

	}

	private static String IntToString(int valueNum) {

		return String.valueOf(valueNum);

	}
}
