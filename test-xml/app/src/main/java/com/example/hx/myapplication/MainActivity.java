package com.example.hx.myapplication;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.hx.myapplication.download.Download;
import com.example.hx.myapplication.model.Mp3Info;
import com.example.hx.myapplication.xml.Mp3ListContentHandler;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends ListActivity {
    private static final int Update = 1;
    private static final int About = 1;



    /*
    在用户点击menu 按钮后会调用该方法，，我们可以在这个方法中加入自己的按钮控件
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, Update, 1, R.string.mp3list_undate);
        menu.add(1, About, 2, R.string.mp3list_about);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == Update) {//点击更新
            //下载包含所有Mp3基本信息的xml文件
            String xml = downloadXML("http//:192.168.0.5:8081/mp3/resources.xml");
            //对xml进行解析，并将解析的结果放置到Mp3Info对象当中；最后将这些Mp3Info放置到List当中

            List<Mp3Info> mp3Infos = parse(xml);
            //生成一个list对象，并按照simpleadapter的标准，将Mp3Infos当中的数据添加到List当中去。
            List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
            for (Iterator iterator = mp3Infos.iterator(); iterator.hasNext(); ) {
                Mp3Info mp3Info = (Mp3Info) iterator.next();
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("mp3_name", mp3Info.getMp3Name());
                map.put("mp3_size", mp3Info.getMp3Size());
                list.add(map);
                /*map.put("irc name",mp3Info.getIrcName());
                map.put("irc size",mp3Info.getIrcSize());*/

            }
            //创建一个simpleAdapte对象
            SimpleAdapter adapter = new SimpleAdapter(this, list,
                    R.layout.mp3info_item, new String[]{"mp3_name", "mp3_size"},
                    new int[]{R.id.mp3_name, R.id.mp3_size});
            //将这个Simpleadapter对象设置到ListActivity当中；
            setListAdapter(adapter);

        } else if (item.getItemId() == About) {//点击关于

        }
        System.out.println("itemId----->" + item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private String downloadXML(String urlStr) {
        Download httpDownloader = new Download();
        String result = httpDownloader.download(urlStr);

        return result;
    }

    private List<Mp3Info> parse(String xmlStr) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
            List<Mp3Info> infos = new ArrayList<Mp3Info>();
            Mp3ListContentHandler mp3ListContentHandler = new Mp3ListContentHandler
                    (infos);
            xmlReader.setContentHandler(mp3ListContentHandler);

            xmlReader.parse(new InputSource(new StringReader(xmlStr)));
            for (Iterator iterator = infos.iterator(); iterator.hasNext(); ) {
                Mp3Info mp3Info = (Mp3Info) iterator.next();
                System.out.println(mp3Info);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
