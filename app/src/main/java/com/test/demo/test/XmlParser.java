package com.test.demo.test;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV002 on 2018/5/24.
 */

public class XmlParser {

    public List parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            in.close();
        }
    }
    private List readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        List entries = new ArrayList();
        //E.获取当前事件的状态
        int type = parser.getEventType();
        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type){
                case XmlPullParser.START_TAG:
                    //do parse
                    //parser.getName()获取元素
                    //parser.nextText()xml解析获得文本属性
                    break;
                case XmlPullParser.END_TAG:
                    break;
                default:
                    break;

            }
            parser.next();
        }
        return entries;
    }
}
