package cn.myfreecloud.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSDemo {
	
	
	
	public static void main(String[] args) throws Exception {
		//流不认识 相对路径    相对路径  都变成绝对
		ClientGlobal.init("D:\\develop\\IDEA\\idea_project\\my_projects\\java-utils\\fast-dfs\\src\\main\\resources\\fdfs_client.conf");
		
		TrackerClient trackerClient = new TrackerClient();
		//连接 Tracker
		TrackerServer trackerServer = trackerClient.getConnection();
		//Storage
		StorageClient1 storageClient1 = new StorageClient1(trackerServer,null);
		//上传图片
		String path = storageClient1.upload_file1("D:\\Desktop\\bef584b2b29387df11e7c2fab1d909f.jpg",
				"jpg", null);
		System.out.println(path);

        /**
         * 访问路径需要加192.168.200.128
         */
	}

}
