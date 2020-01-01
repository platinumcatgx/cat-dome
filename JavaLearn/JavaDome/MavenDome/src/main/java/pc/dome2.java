package pc;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class dome2 {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient c = HttpClients.createDefault();
        HttpPost p = new HttpPost("http://www.itcast.cn/");
        //设置表单请求对象
        List list = new ArrayList();
        list.add(new BasicNameValuePair("keys","java"));
        //创建表单数据
        UrlEncodedFormEntity u = new UrlEncodedFormEntity(list,"utf8");
        p.setEntity(u);//添加到post请求中
        CloseableHttpResponse cr = null;

        try {
            cr = c.execute(p);
            if (cr.getStatusLine().getStatusCode()==200){
                System.out.println(EntityUtils.toString(cr.getEntity()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cr.close();  
        }
    }
}
