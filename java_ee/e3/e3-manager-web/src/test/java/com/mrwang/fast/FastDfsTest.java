package com.mrwang.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.mrwang.common.utils.FastDFSClient;

public class FastDfsTest {
	@Test
	public void testUpload() throws Exception {
		ClientGlobal.init("C:/myProjects/java_ee/e3-manager-web/src/main/resources/conf/client.conf");
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		String[] strings = storageClient.upload_file(
				"C:\\Users\\Administrator.SKY-20170603AJG\\Pictures\\gamersky_08origin_15_2017631722DCF.jpg", "jpg",
				null);
		for (String string : strings) {
			// System.out.println("1"+string);
			System.out.println(string);
		}
	}

	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient(
				"C:/myProjects/java_ee/e3-manager-web/src/main/resources/conf/client.conf");
		String string = fastDFSClient.uploadFile(
				"C:\\Users\\Administrator.SKY-20170603AJG\\Pictures\\gamersky_01origin_01_2017631722638.jpg");
		System.out.println(string);
	}
}
