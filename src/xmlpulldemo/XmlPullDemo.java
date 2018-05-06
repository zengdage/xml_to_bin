
package xmlpulldemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlPullDemo {

    public static void main(String[] args) throws XmlPullParserException, IOException {

        // ����һ����������
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        // �ɹ�������һ������������
        XmlPullParser parser = factory.newPullParser();
        // ��xml�ĵ���Ӧ��������,��дxml�ĵ���·��
        parser.setInput(new FileInputStream("src/students.xml"), "UTF-8");
        // ����¼�����
        int eventType = parser.getEventType();
        System.out.println(eventType == XmlPullParser.START_DOCUMENT);
        do {
            switch (eventType) {
            case XmlPullParser.START_DOCUMENT:
                System.out.println("��ȡ��ʼ,��ʼ�ĵ�!");
                break;
            case XmlPullParser.START_TAG:
                String tagName = parser.getName();
                if (tagName.equals("student")) {
                    System.out.println("��ȡ����-��ʼ��ǩ:" + parser.getName() + ":" + parser.getAttributeName(0) + ":"
                            + parser.getAttributeValue(0));
                } else if (tagName.equals("stuno")) {
                    System.out.println("��ȡ����-ѧ��:" + parser.nextText());
                } else if (tagName.equals("name")) {
                    System.out.println("��ȡ����-����:" + parser.nextText());
                } else if (tagName.equals("sex")) {
                    System.out.println("��ȡ����-�Ա�:" + parser.nextText());
                } else if (tagName.equals("grade")) {
                    System.out.println("��ȡ����-�༶:" + parser.nextText());
                } else if (tagName.equals("students")) {
                    System.out.println("��ȡ��ʼ-��ʼ��Ŀ¼:" + parser.getName());
                }
                break;
            case XmlPullParser.END_TAG:
                if (parser.getName().equals("student")) {
                    System.out.println("��ȡ����-������ǩ:" + parser.getName());
                } else if (parser.getName().equals("students")) {
                    System.out.println("��ȡ���-������Ŀ¼:" + parser.getName());
                }
                break;
            }
            // ��ȡ��һ���ڵ�
            eventType = parser.next();
        } while (eventType != XmlPullParser.END_DOCUMENT);
        System.out.println("��ȡ��ɣ��ĵ�����!");
    }

}