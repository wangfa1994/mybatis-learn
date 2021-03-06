package com.wf.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 *
 */
public class DocumentUtils {

    public static Document converDocumentByInputStrema(InputStream inputStream){
        SAXReader saxReader = new SAXReader();
        Document read = null;
        try {
            read = saxReader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return read;
    }
}
