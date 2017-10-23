package com.hfax.openplatform.connector;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class TCPSocketUtil {

	/**
	 * 读取流
	 * 
	 * @param inStream
	 * @return 字节数组
	 * @throws Exception
	 */
	public static byte[] readStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}

		if (outSteam != null) {
			outSteam.flush();
		}

		if (outSteam != null) {
			outSteam.close();
		}

		if (inStream != null) {
			inStream.close();
		}

		return outSteam.toByteArray();
	}

}
